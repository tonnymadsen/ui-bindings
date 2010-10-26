/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.bindingDataTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Factory for {@link IBindingDataType} objects.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public final class BindingDataTypeFactory {
	private BindingDataTypeFactory() {
		// TODO Auto-generated constructor stub
	}

	private static final Map<Object, IBindingDataType> DATA_TYPE_MAPPING = new HashMap<Object, IBindingDataType>();

	/**
	 * Creates and returns a new {@link IBindingDataType binding data type} appropriate for the
	 * specified element.
	 * <p>
	 * The result is cached and reused.
	 * <p>
	 * The context is used to get a more accurate result when the element is a structural feature -
	 * or something that evaluates to that.
	 * 
	 * @param context the context of the element
	 * @param element the element to return a data type for
	 * @return the data type object or <code>null</code>
	 */
	public static IBindingDataType create(Object context, Object element) {
		EClassifier classifier = null;
		IBindingDataType dt = null;
		if (element instanceof EClassifier) {
			if (DATA_TYPE_MAPPING.containsKey(element)) return DATA_TYPE_MAPPING.get(element);
			dt = new EClassifierBindingDataType((EClassifier) element);
			DATA_TYPE_MAPPING.put(element, dt);
		} else if (element instanceof EStructuralFeature) {
			final CSF csf = new CSF();
			csf.eSF = (EStructuralFeature) element;
			/*
			 * Features are special: for these we use the context so, you can specify a specific
			 * sub-class for the feature.
			 */
			if (context instanceof IObservableValue) {
				context = ((IObservableValue) context).getValue();
			}

			/*
			 * Convert EObject to EClasses and Object to Classes
			 */
			if (context instanceof EClass) {
				// Do nothing
			} else if (context instanceof EObject) {
				context = ((EObject) context).eClass();
			} else if (context instanceof Class) {
				// Do nothing
			} else if (context instanceof Object) {
				context = context.getClass();
			}
			if (context instanceof EClass) {
				csf.eCls = (EClass) context;
			} else if (context instanceof Class) {
				final EClassifier c = IBindingDataType.Factory.convertToClassifier((Class<?>) context);
				if (c instanceof EClass) {
					csf.eCls = (EClass) c;
				}
			} else {
				csf.eCls = csf.eSF.getEContainingClass();
			}

			if (DATA_TYPE_MAPPING.containsKey(csf)) return DATA_TYPE_MAPPING.get(element);
			dt = new EStructuralFeatureBindingDataType(csf.eCls, csf.eSF);

			DATA_TYPE_MAPPING.put(csf, dt);
		} else if (element instanceof EEnumLiteral) {
			if (DATA_TYPE_MAPPING.containsKey(element)) return DATA_TYPE_MAPPING.get(element);
			dt = new EEnumLiteralBindingDataType((EEnumLiteral) element);
			DATA_TYPE_MAPPING.put(element, dt);
		} else if (element instanceof Class<?>) {
			if (DATA_TYPE_MAPPING.containsKey(element)) return DATA_TYPE_MAPPING.get(element);
			/*
			 * Try to look up the instance class to find a proper EClassifier
			 */
			classifier = IBindingDataType.Factory.convertToClassifier((Class<?>) element);
			if (classifier != null) {
				dt = create(null, classifier);
				DATA_TYPE_MAPPING.put(classifier, dt);
			} else {
				dt = new JavaClassBindingDataType((Class<?>) element);
			}
			DATA_TYPE_MAPPING.put(element, dt);
		} else if (element == null) {
			if (DATA_TYPE_MAPPING.containsKey(element)) return DATA_TYPE_MAPPING.get(element);
			dt = create(null, EcorePackage.Literals.EJAVA_OBJECT);
			DATA_TYPE_MAPPING.put(element, dt);
		} else {
			LogUtils.error(element, "No IBindingDataType for " + element); //$NON-NLS-1$
			dt = null;
		}
		return dt;
	}

	/**
	 * Data object used as key in {@link BindingDataTypeFactory#DATA_TYPE_MAPPING} for structural
	 * features.
	 */
	private static class CSF {
		public EClass eCls;
		public EStructuralFeature eSF;
	}

	/**
	 * Tries to convert a Java class to the corresponding {@link EClassifier}.
	 * <p>
	 * All registered EMF packages are searched.
	 * 
	 * @param cls the class to convert
	 * @return the corresponding classifier or <code>null</code> if not found
	 */
	public static EClassifier convertToClassifier(Class<?> cls) {
		/*
		 * The interface class that corresponds to clss - if any exist
		 */
		Class<?> ifCls = null;
		if (!cls.isInterface()) {
			final Class<?>[] interfaces = cls.getInterfaces();
			if (interfaces.length > 0) {
				ifCls = interfaces[0];
			}
		}

		/*
		 * To check the ecore package first! Otherwise the XML Type package
		 * [http://www.eclipse.org/emf/2003/XMLType] will overshadow the basic Java types.
		 */
		for (final EClassifier c : EcorePackage.eINSTANCE.getEClassifiers()) {
			if (c.getInstanceClass() == cls) return c;
			if (ifCls != null && c.getInstanceClass() == ifCls) return c;
		}

		/*
		 * Now try all the packages
		 */
		final Registry registry = EPackage.Registry.INSTANCE;
		for (final Object v : registry.values()) {
			if (!(v instanceof EPackage)) {
				continue;
			}
			if (v == EcorePackage.eINSTANCE) {
				continue;
			}
			final EPackage ep = (EPackage) v;

			for (final EClassifier c : ep.getEClassifiers()) {
				if (c.getInstanceClass() == cls) return c;
				if (ifCls != null && c.getInstanceClass() == ifCls) return c;
			}
		}

		return null;
	}

	/**
	 * Mapping from class to the set of super classes as defined by
	 * {@link IAdapterManager#computeClassOrder(Class)}.
	 */
	private static final Map<IBindingDataType, IBindingDataType[]> SUPER_TYPE_MAPPING = new HashMap<IBindingDataType, IBindingDataType[]>();

	/**
	 * Returns a list of the {@link IBindingDataType} objects that defines all the super types of
	 * the specified data type.
	 * <p>
	 * If not already calculated, then do that by creating an array with
	 * <ul>
	 * <li>IBDTs for all super types (ECore classes)</li>
	 * <li>IBDTs for all super classes (Java classes) not already added from their Ecore
	 * counterparts</li>
	 * </ul>
	 * 
	 * @param dt the data type to test
	 * @return the super types
	 */
	public static IBindingDataType[] getSuperTypes(IBindingDataType dt) {
		IBindingDataType[] dts = SUPER_TYPE_MAPPING.get(dt);
		if (dts == null) {
			final List<IBindingDataType> dtList = new ArrayList<IBindingDataType>();
			final EClassifier classifier = dt.getEType();
			if (classifier != null) {
				dtList.add(create(null, classifier));
				if (classifier instanceof EClass) {
					/*
					 * getEAllSuperTypes() returns the reverse list with the grand-father super-type
					 * first...
					 */
					final List<EClass> superTypes = ((EClass) classifier).getEAllSuperTypes();
					for (int i = superTypes.size() - 1; i >= 0; i--) {
						final EClass e = superTypes.get(i);
						final IBindingDataType d = create(null, e);
						if (dtList.contains(d)) {
							continue;
						}
						dtList.add(d);
					}
				}
			}
			final Class<?>[] superClasses = Platform.getAdapterManager().computeClassOrder(dt.getDataType());
			for (final Class<?> c : superClasses) {
				final IBindingDataType d = create(null, c);
				if (dtList.contains(d)) {
					continue;
				}
				dtList.add(d);
			}
			dts = dtList.toArray(new IBindingDataType[dtList.size()]);
			SUPER_TYPE_MAPPING.put(dt, dts);
		}
		return dts;
	}
}
