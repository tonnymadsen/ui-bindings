// $codepro.audit.disable numericLiterals
/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EObjectObservableList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.ChildCreationSpecification;
import com.rcpcompany.uibindings.internal.decorators.GenericEObjectDecorator;
import com.rcpcompany.uibindings.internal.observables.MyDetailObservableList;
import com.rcpcompany.uibindings.observables.IObservableListMapper;
import com.rcpcompany.uibindings.observables.ProxyObservableValue;
import com.rcpcompany.uibindings.utils.CoreRuntimeException;
import com.rcpcompany.uibindings.utils.ExtendedCommandStack;
import com.rcpcompany.utils.basic.ClassUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Various utility methods.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class UIBindingsUtils {
	private UIBindingsUtils() {
	}

	/**
	 * Adds to the specified list of {@link IChildCreationSpecification} with the specified
	 * information.
	 * <p>
	 * Also adds any sub-classes of child type.
	 * 
	 * @param specs the list of specifications to add to
	 * @param parent the parent object
	 * @param ref the reference
	 * @param childType the child type
	 * @param index TODO
	 */
	public static void addToChildCreationSpecification(final List<IChildCreationSpecification> specs, EObject parent,
			EReference ref, final EClass childType, int index) {
		/*
		 * Allow the user to prevent the addition
		 */
		final IBindingDataType dt = IBindingDataType.Factory.create(parent, ref);

		if (!childType.isAbstract() && !childType.isInterface()
				&& dt.getArgument(Constants.ARG_NEW_ALLOWED, null, Boolean.class, Boolean.TRUE)) {
			specs.add(new ChildCreationSpecification(parent, ref, childType, index));
		}

		final Collection<EClass> subClasses = EcoreExtUtils.getSubClasses(childType);
		if (subClasses == null) return;

		for (final EClass c : subClasses) {
			addToChildCreationSpecification(specs, parent, ref, c, index);
		}
	}

	/**
	 * Returns {@link IChildCreationSpecification} for children of the specified list.
	 * 
	 * @param l the list
	 * @param sibling a possible sibling, if non-<code>null</code>
	 * 
	 * @return the possible top-level children
	 */
	public static List<IChildCreationSpecification> getPossibleTopLevelChildObjects(IObservableList l, EObject sibling) {
		final List<IChildCreationSpecification> specs = new ArrayList<IChildCreationSpecification>();

		/*
		 * Figure out the EReference of the elements
		 */
		EObject parent = null;
		EReference ref = null;
		if (l instanceof EObjectEList<?>) {
			final EObjectEList<?> el = (EObjectEList<?>) l;
			final EStructuralFeature sf = el.getEStructuralFeature();
			if (sf instanceof EReference) {
				parent = (EObject) el.getNotifier();
				ref = (EReference) sf;
			}
		}
		if (ref == null && l instanceof MyDetailObservableList) {
			parent = (EObject) ((MyDetailObservableList) l).getObserved();
			ref = (EReference) ((MyDetailObservableList) l).getElementType();
		}
		if (ref == null && l instanceof EObjectObservableList) {
			parent = (EObject) ((EObjectObservableList) l).getObserved();
			ref = (EReference) ((EObjectObservableList) l).getElementType();
		}
		if (ref == null) return specs;
		final EClass childType = ref.getEReferenceType();
		int index = -1;
		if (sibling != null) {
			index = l.indexOf(sibling);
			if (index == -1) return specs;
		}

		UIBindingsUtils.addToChildCreationSpecification(specs, parent, ref, childType, index);
		return specs;
	}

	/**
	 * Creates a new validation error status with the given message.
	 * <p>
	 * This error message does <em>not</em> prevent the data binding to set the value
	 * 
	 * @param isFatal <code>true</code> if this is a fatal error - value should not set in data
	 *            binding
	 * @param code the code used for the message
	 * @param m the message for the error
	 * @return a new error status with the given message
	 */
	public static IStatus error(boolean isFatal, int code, String m) {
		if (isFatal)
			return new Status(IStatus.ERROR, Activator.ID, code, m, null);
		else
			return new MyNonFatalStatus(IStatus.ERROR, Activator.ID, code, m, null);
	}

	/**
	 * Creates a new validation error status with the given message.
	 * <p>
	 * This error message does <em>not</em> prevent the data binding to set the value
	 * 
	 * @param code the code used for the message
	 * @param m the message for the error
	 * @return a new error status with the given message
	 */
	public static IStatus error(int code, String m) {
		return error(IManager.Factory.getManager().isValidationErrorsAreFatal(), code, m);
	}

	/**
	 * Creates a new validation error status with the given message.
	 * <p>
	 * This error message does <em>not</em> prevent the data binding to set the value
	 * 
	 * @param isFatal <code>true</code> if this is a fatal error - value should not set in data
	 *            binding
	 * @param code the code used for the message
	 * @param m the message for the error
	 * 
	 * @return a new error status with the given message
	 */
	public static void throwError(boolean isFatal, int code, String m) {
		throw new CoreRuntimeException(error(isFatal, code, m));
	}

	/**
	 * Creates a new validation warning status with the given message.
	 * <p>
	 * This warning message does <em>not</em> prevent the data binding to set the value
	 * 
	 * @param code the code used for the message
	 * @param m the message for the warning
	 * @return a new warning status with the given message
	 */
	public static IStatus warning(int code, String m) {
		return new Status(IStatus.WARNING, Activator.ID, code, m, null);
	}

	/**
	 * Returns whether the specified status is a fatal error or not.
	 * <p>
	 * A fatal error will not result in the value being set in a data binding, but wil still show as
	 * an error.
	 * 
	 * @param status the status to check
	 * @return <code>true</code> if it is a fatal error, and <code>false</code> otherwise
	 */
	public static boolean isFatalError(IStatus status) {
		/*
		 * Assuming multi-status have the correct severity...
		 */
		if (status.getSeverity() != IStatus.ERROR) return false;
		final IStatus[] children = status.getChildren();
		if (children != null) {
			for (final IStatus c : children) {
				if (isFatalError(c)) return true;
			}
		}
		if (status instanceof MultiStatus) return false;
		if (status instanceof MyNonFatalStatus) return false;
		return true;

	}

	/**
	 * The default alignment for specific types.
	 */
	private static final Map<Object, Integer> DEFAULT_ALIGNMENT = new HashMap<Object, Integer>();

	static {
		DEFAULT_ALIGNMENT.put(EcorePackage.Literals.EBYTE, SWT.RIGHT);
		DEFAULT_ALIGNMENT.put(EcorePackage.Literals.EBYTE_OBJECT, SWT.RIGHT);
		DEFAULT_ALIGNMENT.put(EcorePackage.Literals.ESHORT, SWT.RIGHT);
		DEFAULT_ALIGNMENT.put(EcorePackage.Literals.ESHORT_OBJECT, SWT.RIGHT);
		DEFAULT_ALIGNMENT.put(EcorePackage.Literals.EINT, SWT.RIGHT);
		DEFAULT_ALIGNMENT.put(EcorePackage.Literals.EINTEGER_OBJECT, SWT.RIGHT);
		DEFAULT_ALIGNMENT.put(EcorePackage.Literals.EFLOAT, SWT.RIGHT);
		DEFAULT_ALIGNMENT.put(EcorePackage.Literals.EFLOAT_OBJECT, SWT.RIGHT);
		DEFAULT_ALIGNMENT.put(EcorePackage.Literals.EDOUBLE, SWT.RIGHT);
		DEFAULT_ALIGNMENT.put(EcorePackage.Literals.EDOUBLE_OBJECT, SWT.RIGHT);
	}

	/**
	 * Returns the default alignment for the specific value type.
	 * <p>
	 * If you want to change the alignment use the <code>uibindings/model</code> and
	 * <code>uibindings/model/feature elements</code>.
	 * 
	 * @param valueType the value type to test
	 * @return the default alignment
	 */
	public static int defaultAlignment(Object valueType) {
		if (valueType instanceof EStructuralFeature) {
			final EStructuralFeature sf = (EStructuralFeature) valueType;
			valueType = sf.getEType();
		}
		final Integer alignment = DEFAULT_ALIGNMENT.get(valueType);
		if (alignment != null) return alignment;
		return SWT.NONE;
	}

	/**
	 * Returns a corner image for the specified position and color.
	 * <p>
	 * The returned image is cached and may not be disposed.
	 * 
	 * @param position the wanted position of the image
	 * @param rgb the wanted color
	 * @return the image
	 */
	public static Image getCornerImage(DecorationPosition position, RGB rgb) {
		final String key = "CORNER_IMAGE:" + position + ":" + rgb; //$NON-NLS-1$ //$NON-NLS-2$
		final ImageRegistry ir = JFaceResources.getImageRegistry();
		Image image = ir.get(key);
		if (image != null) return image;

		final Display device = Display.getDefault();
		final Color color = new Color(device, rgb);

		image = new Image(device, 5, 5);
		final GC gc = new GC(image);
		gc.setBackground(color);

		switch (position) {
		case TOP_LEFT:
			gc.fillPolygon(new int[] { 0, 0, 4, 0, 0, 4 });
			break;
		case CENTER_LEFT:
			gc.fillPolygon(new int[] { 0, 0, 4, 2, 0, 4 });
			break;
		case BOTTOM_LEFT:
			gc.fillPolygon(new int[] { 0, 0, 4, 4, 0, 4 });
			break;
		case TOP_RIGHT:
			gc.fillPolygon(new int[] { 4, 0, 0, 0, 4, 4 });
			break;
		case CENTER_RIGHT:
			gc.fillPolygon(new int[] { 4, 0, 2, 0, 4, 4 });
			break;
		case BOTTOM_RIGHT:
			gc.fillPolygon(new int[] { 4, 0, 4, 0, 4, 4 });
			break;
		}

		gc.dispose();
		color.dispose();

		/*
		 * Set the transparent color
		 */
		final ImageData ideaData = image.getImageData();
		final int whitePixel = ideaData.palette.getPixel(new RGB(255, 255, 255));
		ideaData.transparentPixel = whitePixel;

		ir.put(key, image);

		return image;
	}

	/**
	 * Returns a square image for the specified color.
	 * <p>
	 * The returned image is cached and may not be disposed.
	 * 
	 * @param rgb the wanted color
	 * @param size TODO
	 * @return the image
	 */
	public static Image getSquareImage(RGB rgb, int size) {
		final String key = "SQUARE_IMAGE:" + rgb; //$NON-NLS-1$
		final ImageRegistry ir = JFaceResources.getImageRegistry();
		Image image = ir.get(key);
		if (image != null) return image;

		final Display device = Display.getDefault();
		final Color color = new Color(device, rgb);

		image = new Image(device, size, size);
		final GC gc = new GC(image);
		gc.setBackground(color);

		gc.fillRectangle(0, 0, size, size);

		gc.dispose();
		color.dispose();

		ir.put(key, image);

		return image;
	}

	protected static class MyNonFatalStatus extends Status {

		protected MyNonFatalStatus(int severity, String pluginId, int code, String message, Throwable exception) {
			super(severity, pluginId, code, message, exception);
		}

	}

	/**
	 * Returns whether the two objects are equal or both <code>null</code>.
	 * 
	 * @param a object a
	 * @param b object b
	 * @return true if a and b are equal or both are <code>null</code>
	 */
	public static boolean equals(Object a, Object b) {
		if (a == b) return true;
		if (a == null) return false;
		return a.equals(b);
	}

	/**
	 * Returns whether the two objects are deeply equal or both <code>null</code>.
	 * <p>
	 * Note that two arrays of the same length, base type and with equals elements are considered
	 * equal.
	 * <p>
	 * Also two collections of the same size and with equal elements are also considered equal.
	 * 
	 * @param a object a
	 * @param b object b
	 * @return true if a and b are equal or both are <code>null</code>
	 */
	public static boolean deepEquals(Object a, Object b) {
		if (a == b) return true;
		if (a == null) return false;
		if (a.getClass().isArray() && b.getClass().isArray()) {
			if (a.getClass() != b.getClass()) return false;
			if (a instanceof Object[] && b instanceof Object[])
				return Arrays.deepEquals((Object[]) a, (Object[]) b);
			else if (a instanceof byte[] && b instanceof byte[])
				return Arrays.equals((byte[]) a, (byte[]) b);
			else if (a instanceof short[] && b instanceof short[])
				return Arrays.equals((short[]) a, (short[]) b);
			else if (a instanceof int[] && b instanceof int[])
				return Arrays.equals((int[]) a, (int[]) b);
			else if (a instanceof long[] && b instanceof long[])
				return Arrays.equals((long[]) a, (long[]) b);
			else if (a instanceof char[] && b instanceof char[])
				return Arrays.equals((char[]) a, (char[]) b);
			else if (a instanceof float[] && b instanceof float[])
				return Arrays.equals((float[]) a, (float[]) b);
			else if (a instanceof double[] && b instanceof double[])
				return Arrays.equals((double[]) a, (double[]) b);
			else if (a instanceof boolean[] && b instanceof boolean[])
				return Arrays.equals((boolean[]) a, (boolean[]) b);
			else
				return false;
		}
		if (a instanceof Collection && b instanceof Collection) {
			final Collection<?> aData = (Collection<?>) a;
			final Collection<?> bData = (Collection<?>) b;
			if (aData.size() != bData.size()) return false;
			final Iterator<?> aIterator = aData.iterator();
			final Iterator<?> bIterator = bData.iterator();
			while (aIterator.hasNext()) {
				if (!deepEquals(aIterator.next(), bIterator.next())) return false;
			}
			return true;
		}
		return a.equals(b);
	}

	/**
	 * Returns whether the two EObjects are equal or both <code>null</code>.
	 * <p>
	 * This version uses the equality concept from EMF with object keys. I.e. if <code>key</code> is
	 * non-<code>null</code>, it also tests if the key attribute of the objects are
	 * {@link #equals(Object, Object)}. So two objects are "equal" if just the keys are equal.
	 * 
	 * @param a object a
	 * @param b object b
	 * @param key key attribute in objects
	 * @return true if a and b are equal or both are <code>null</code>
	 */
	public static boolean equals(EObject a, EObject b, EAttribute key) {
		if (a == b) return true;
		if (a == null) return false;
		if (a.equals(b)) return true;

		if (b == null || key == null) return false;
		return equals(a.eGet(key), b.eGet(key));
	}

	/**
	 * Returns whether the two {@link Diagnostic} objects are equal or both <code>null</code>.
	 * 
	 * @param a {@link Diagnostic} object a
	 * @param b {@link Diagnostic} object b
	 * @return true if a and b represent the same {@link Diagnostic} or both are <code>null</code>
	 */
	public static boolean equals(Diagnostic a, Diagnostic b) {
		if (a == b) return true;
		if (a == null) return false;

		if (a.getSeverity() != b.getSeverity()) return false;

		if (!equals(a.getSource(), b.getSource())) return false;
		if (a.getCode() != b.getCode()) return false;

		if (!equals(a.getMessage(), b.getMessage())) return false;
		if (!equals(a.getException(), b.getException())) return false;

		if (!deepEquals(a.getChildren(), b.getChildren())) return false;
		if (!deepEquals(a.getData(), b.getData())) return false;

		return true;
	}

	/**
	 * Constructs and returns a new simple editing domain suitable for UI Bindings.
	 * 
	 * @return the new editing domain
	 */
	public static EditingDomain createEditingDomain() {
		final EditingDomain newDomain = new AdapterFactoryEditingDomain(new ReflectiveItemProviderAdapterFactory(),
				new ExtendedCommandStack());
		return newDomain;
	}

	private static Boolean myIsWindows = null;

	/**
	 * Returns whether the application is running under Windows (any version).
	 * 
	 * @return <code>true</code> if Windows, <code>false</code> otherwise
	 */
	public static boolean isWindows() {
		if (myIsWindows == null) {
			final String osname = System.getProperty("os.name"); //$NON-NLS-1$
			myIsWindows = osname.startsWith("Windows"); //$NON-NLS-1$
		}
		return myIsWindows;
	}

	private static Boolean myIsWindowsXP = null;

	/**
	 * Returns whether the application is running under Windows XP.
	 * 
	 * @return <code>true</code> if Windows XP, <code>false</code> otherwise
	 */
	public static boolean isWindowsXP() {
		if (myIsWindowsXP == null) {
			final String osname = System.getProperty("os.name"); //$NON-NLS-1$
			final String osversion = System.getProperty("os.version"); //$NON-NLS-1$
			//LogUtils.debug(Activator.getDefault(), "name='" + osname + "', version='" + osversion + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			myIsWindowsXP = osname.startsWith("Windows") && "5.1".equals(osversion); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return myIsWindowsXP;
	}

	/**
	 * Interface used to map an {@link EObject} to the identifier attribute of the object.
	 * 
	 * @see GenericEObjectDecorator
	 * @author Tonny Madsen, The RCP Company
	 */
	public interface IClassIdentiferMapper extends IObservableListMapper {
		/**
		 * @see IUIBindingDecorator#getDisplayObservableValue(IObservableValue)
		 * @param value the value
		 * @param editingDomain the editing domain used for any changes in the returned observable
		 *            value
		 * @return the observable value for the displayed text
		 */
		IObservableValue getObservableValue(IObservableValue value, EditingDomain editingDomain);
	}

	/**
	 * Creates a list mapper that corresponding to the facilities of the specified type.
	 * <p>
	 * The mapper is chosen according to the following priorities:
	 * <ul>
	 * <li>annotated field</li>
	 * <li>via genmodel label field - requires additional generation of information</li>
	 * <li>by field name: label, name, fullName</li>
	 * <li>by field type: String</li>
	 * <li>{@link #toString()}</li>
	 * </ul>
	 * 
	 * @param binding the binding to map
	 * @param ec the class to create the mapper for
	 * 
	 * @return the mapper
	 */
	public static IClassIdentiferMapper createClassIdentiferMapper(IBinding binding, EClass ec) {
		EStructuralFeature feature;

		// Via Annotation
		final String featureNames = binding.getArgument(Constants.ARG_FEATURE_NAME, String.class, null);
		if (featureNames != null) {
			// Pattern.compile("(\\p{L}+)")
			final StringTokenizer st = new StringTokenizer(featureNames, ".");
			EClassifier c = ec;
			final List<EStructuralFeature> sfs = new ArrayList<EStructuralFeature>();
			while (st.hasMoreTokens()) {
				final String name = st.nextToken();
				binding.assertTrue(c instanceof EClass, "Intermidiate features must be references");
				final EClass eClass = (EClass) c;
				feature = eClass.getEStructuralFeature(name);
				binding.assertTrue(feature != null, "Unknown feature: '" + eClass.getName() + "." + name
						+ "' in argument " + Constants.ARG_FEATURE_NAME + " (" + featureNames + ")");

				sfs.add(feature);
				c = feature.getEType();
			}

			switch (sfs.size()) {
			case 0:
				LogUtils.error(binding, "Feature names '" + featureNames + "' does not exist. Ignored.",
						binding.getCreationPoint());
				break;
			case 1:
				return new SingleFeatureMapper(sfs.get(0));
			default:
				return new MultipleFeatureMapper(sfs.toArray(new EStructuralFeature[sfs.size()]));
			}
		}

		// By Field Name
		feature = ec.getEStructuralFeature("label");
		if (feature != null) return new SingleFeatureMapper(feature);
		feature = ec.getEStructuralFeature("name");
		if (feature != null) return new SingleFeatureMapper(feature);
		feature = ec.getEStructuralFeature("fullName");
		if (feature != null) return new SingleFeatureMapper(feature);

		// By Field Type
		for (final EAttribute a : ec.getEAllAttributes()) {
			if (a.getEType() == EcorePackage.Literals.ESTRING) return new SingleFeatureMapper(a);
		}

		// Fall back on toString()....
		return DEFAULT_MAPPER;
	}

	/**
	 * The singleton default mapper.
	 */
	public static final DefaultMapper DEFAULT_MAPPER = new DefaultMapper();

	/**
	 * {@link IClassIdentiferMapper} based on {@link Object#toString()}.
	 */
	public static class DefaultMapper implements IClassIdentiferMapper {
		@Override
		public Object map(Object value) {
			return value != null ? value.toString() : "";
		}

		@Override
		public IObservableValue getObservableValue(IObservableValue value, EditingDomain editingDomain) {
			return value;
		}

		@Override
		public String toString() {
			return ClassUtils.getLastClassName(this) + "[]";
		}
	}

	/**
	 * {@link IClassIdentiferMapper} based on a single {@link EStructuralFeature feature}.
	 */
	protected static class SingleFeatureMapper implements IClassIdentiferMapper {
		private final EStructuralFeature myFeature;

		/**
		 * Constructs and returns a new mapper based on the specified feature.
		 * 
		 * @param feature the feature of the mapper
		 */
		protected SingleFeatureMapper(EStructuralFeature feature) {
			myFeature = feature;
		}

		@Override
		public Object map(Object value) {
			if (value != null) {
				value = ((EObject) value).eGet(myFeature);
			}
			if (value == null) {
				value = "";
			}
			return value;
		}

		@Override
		public IObservableValue getObservableValue(IObservableValue value, EditingDomain editingDomain) {
			value = new ProxyObservableValue(value);
			return UIBindingsEMFObservables.observeDetailValue(value.getRealm(), editingDomain, value, myFeature);
		}

		@Override
		public String toString() {
			return ClassUtils.getLastClassName(this) + "[" + myFeature.getName() + "]";
		}
	}

	/**
	 * {@link IClassIdentiferMapper} based on a chain of {@link EStructuralFeature features}.
	 */
	protected static class MultipleFeatureMapper implements IClassIdentiferMapper {
		private final EStructuralFeature[] myFeatures;

		/**
		 * Constructs and returns a new mapper based on the specified features.
		 * 
		 * @param features the features of the mapper
		 */
		protected MultipleFeatureMapper(EStructuralFeature[] features) {
			myFeatures = features;
		}

		@Override
		public Object map(Object value) {
			for (final EStructuralFeature sf : myFeatures) {
				if (value == null) return "";
				value = ((EObject) value).eGet(sf);
			}
			if (value == null) return "";
			return value;
		}

		@Override
		public IObservableValue getObservableValue(IObservableValue value, EditingDomain editingDomain) {
			for (final EStructuralFeature sf : myFeatures) {
				if (value == null) return null;
				value = UIBindingsEMFObservables.observeDetailValue(value.getRealm(), editingDomain, value, sf);
			}
			return value;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder(50);
			sb.append(ClassUtils.getLastClassName(this)).append('[');
			boolean first = true;
			for (final EStructuralFeature sf : myFeatures) {
				if (!first) {
					sb.append('.');
				}
				sb.append(sf.getName());
				first = false;
			}
			sb.append(']');

			return sb.toString();
		}
	}

	/**
	 * Version of {@link Collections#sort(List, Comparator)} that can be used with {@link EList}
	 * with the unique property.
	 * 
	 * @param list the list to be sorted.
	 * @param c the comparator to determine the order of the list. A <tt>null</tt> value indicates
	 *            that the elements' <i>natural ordering</i> should be used.
	 * @throws ClassCastException if the list contains elements that are not <i>mutually
	 *             comparable</i> using the specified comparator.
	 * @throws UnsupportedOperationException if the specified list's list-iterator does not support
	 *             the <tt>set</tt> operation.
	 * @see Comparator
	 */
	public static <T> void sort(EList<T> list, Comparator<? super T> c) {
		ECollections.sort(list, c);
	}

	/**
	 * Mapping of boxed to primitive data types - e.g. <code>Integer</code> to <code>int</code>.
	 */
	private static final Map<String, String> BOXED2PRIMITIVE = new HashMap<String, String>();

	static {
		UIBindingsUtils.BOXED2PRIMITIVE.put(Boolean.class.getName(), Boolean.TYPE.getName());
		UIBindingsUtils.BOXED2PRIMITIVE.put(Character.class.getName(), Character.TYPE.getName());
		UIBindingsUtils.BOXED2PRIMITIVE.put(Byte.class.getName(), Byte.TYPE.getName());
		UIBindingsUtils.BOXED2PRIMITIVE.put(Short.class.getName(), Short.TYPE.getName());
		UIBindingsUtils.BOXED2PRIMITIVE.put(Integer.class.getName(), Integer.TYPE.getName());
		UIBindingsUtils.BOXED2PRIMITIVE.put(Long.class.getName(), Long.TYPE.getName());
		UIBindingsUtils.BOXED2PRIMITIVE.put(Float.class.getName(), Float.TYPE.getName());
		UIBindingsUtils.BOXED2PRIMITIVE.put(Double.class.getName(), Double.TYPE.getName());
	}

	/**
	 * Returns the primitive data type corresponding to the specified boxed data type, if one
	 * exists.
	 * 
	 * @param boxed the boxed type
	 * @return the primitive type or <code>null</code>
	 */
	public static String getBoxed2Primitive(String boxed) {
		return BOXED2PRIMITIVE.get(boxed);
	}

	/**
	 * Calculates the needed Y adjustment for the specified control for decorations inside the
	 * control.
	 * <p>
	 * Needed for {@link Tree} under Windows.
	 * 
	 * @param control the control to calculate the adjustment for
	 * @return the adjustment in pixels
	 */
	public static int calculateYAdjustment(final Control control) {
		int adjustY = 0;
		if (isWindows() && control instanceof Tree) {
			/*
			 * BUG under Windows?
			 * 
			 * Tree.getClientArea does not return the visible area of the tree, but rather the
			 * complete area of the tree if there was "room" enough.
			 * 
			 * The fix is to calculate the y of the top-index and correct with this when saving
			 * locations inside a Tree.
			 * 
			 * This code finds the bounds of the first root element. When this is not the top
			 * element in the view of the tree, the bounds still returned with a negative y...
			 */
			final Tree t = (Tree) control;
			if (t.getItemCount() == 0) return 0;
			final TreeItem rootItem = t.getItem(0);
			adjustY = -rootItem.getBounds().y;
			// LogUtils.debug(control, "Adjust y " + adjustY + " for " + rootItem.getData());
		}
		return adjustY;
	}
}
