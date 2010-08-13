package com.rcpcompany.uibindings.bindingMessages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.ui.model.IWorkbenchAdapter;

import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.validators.IValidationAdapterManagerChangeEvent;
import com.rcpcompany.uibindings.validators.IValidationAdapterManagerChangeListener;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Label decotator that adds an error or warning overlay to objects with outstanding errors.
 * <p>
 * The decorator can also propagate the state of child objects to the parents (recursively). This is
 * done either by specifying the string "propagate" as a argument to the class as shown below.
 * <p>
 * To use this decorator, specify the following extension:
 * 
 * <pre>
 * &lt;extension point=&quot;org.eclipse.ui.decorators&quot;&gt;
 *   &lt;decorator
 *         class=&quot;com.rcpcompany.uibindings.bindingMessages.ValidationLabelDecorator:propagate&quot;
 *         id=&quot;com.rcpcompany.uibindings.decorator&quot;
 *         label=&quot;UI Bindings&quot;
 *         lightweight=&quot;true&quot;
 *         location=&quot;TOP_LEFT&quot;
 *         state=&quot;true&quot;&gt;
 *         &lt;enablement&gt;
 *         &lt;objectClass
 *               name=&quot;org.eclipse.emf.ecore.EObject&quot;&gt;
 *         &lt;/objectClass&gt;
 *      &lt;/enablement&gt;
 *   &lt;/decorator&gt;
 * &lt;/extension&gt;
 * </pre>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ValidationLabelDecorator implements ILightweightLabelDecorator, IExecutableExtension {
	/**
	 * This interface is used when the validation status must be propagated to parent objects in a
	 * tree.
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	public interface IPropagationAdapter {
		/**
		 * Returns the parent object of the specified child.
		 * 
		 * @param object the child object
		 * @return the parent of the child or <code>null</code> for root elements
		 */
		Object getParent(Object object);
	}

	/**
	 * The keyword used to specify whether the label decorator will propagate the state of child
	 * objects are propagated to the parents (recursively).
	 */
	public static final String PROPAGATE = "propagate"; //$NON-NLS-1$
	/**
	 * The propagation adapter used to find the parent.
	 */
	private IPropagationAdapter myPropagationAdapter = null;

	/**
	 * Returns the current propagation adapter.
	 * 
	 * @return the current adapter
	 */
	public IPropagationAdapter getPropagationAdapter() {
		return myPropagationAdapter;
	}

	/**
	 * Set the new propagation adapter to used for this label decorator.
	 * 
	 * @param propagationAdapter the new adapter
	 */
	public void setPropagationAdapter(IPropagationAdapter propagationAdapter) {
		myPropagationAdapter = propagationAdapter;
	}

	/**
	 * The validation manager...
	 */
	private final IValidatorAdapterManager myValidatorManager = IValidatorAdapterManager.Factory.getManager();

	/**
	 * Constructs and returns a new decorator.
	 */
	public ValidationLabelDecorator() {
		myValidatorManager.addValidationAdapterManagerChangeListener(myVAMListener);
	}

	@Override
	public void dispose() {
		myValidatorManager.removeValidationAdapterManagerChangeListener(myVAMListener);
	}

	/**
	 * The current severities for the affected objects. Calculated in
	 */
	private final Map<Object, Integer> myObjectSeverities = new HashMap<Object, Integer>();

	/**
	 * Returns the max severity for the specified element.
	 * <p>
	 * Includes the severity of any popagated severity
	 * 
	 * @param element the element to test
	 * @return the severity
	 */
	public int getElementSeverity(Object element) {
		final Integer severity = myObjectSeverities.get(element);
		if (severity == null) return IMessageProvider.NONE;

		return severity;
	}

	@Override
	public void decorate(Object element, IDecoration decoration) {
		final Integer severity = myObjectSeverities.get(element);
		if (severity == null) return;
		if (Activator.getDefault() != null && Activator.getDefault().TRACE_LABEL_DECORATOR) {
			LogUtils.debug(this, hashCode() + ": " + element + ": severity: " + severity); //$NON-NLS-1$ //$NON-NLS-2$
		}
		switch (severity) {
		case IMessageProvider.NONE:
			break;
		case IMessageProvider.INFORMATION:
			break;
		case IMessageProvider.WARNING:
			decoration.addOverlay(WARNING_IMAGE);
			break;
		case IMessageProvider.ERROR:
			decoration.addOverlay(ERROR_IMAGE);
			break;
		default:
			break;
		}
	}

	/**
	 * Image used to indicate that the object has an error.
	 */
	public static final ImageDescriptor ERROR_IMAGE = ImageDescriptor.createFromImage(FieldDecorationRegistry
			.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage());
	/**
	 * Image used to indicate that the object has a warning.
	 */
	public static final ImageDescriptor WARNING_IMAGE = ImageDescriptor.createFromImage(FieldDecorationRegistry
			.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_WARNING).getImage());

	/**
	 * Listeners on this label decorator.
	 * 
	 * @see #addListener(ILabelProviderListener)
	 * @see #removeListener(ILabelProviderListener)
	 */
	private final ArrayList<ILabelProviderListener> myListeners = new ArrayList<ILabelProviderListener>();

	/**
	 * Whether this decorator has been fully initialized.
	 */
	private boolean inited;

	@Override
	public void addListener(ILabelProviderListener listener) {
		if (!myListeners.contains(listener)) {
			myListeners.add(listener);
		}

		if (!inited) {
			inited = true;
			calculateSeverities();
		}
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		myListeners.remove(listener);
	}

	private final IValidationAdapterManagerChangeListener myVAMListener = new IValidationAdapterManagerChangeListener() {
		@Override
		public void affectedObjectsChanged(IValidationAdapterManagerChangeEvent event) {
			calculateSeverities();
		}
	};

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return true;
	}

	/**
	 * Calculates the severities for all the affected objects covered by this decorator.
	 */
	protected void calculateSeverities() {
		// Calculate the new severities for all objects with a message
		final Map<Object, Integer> newSeverities = new HashMap<Object, Integer>();
		for (final EObject o : myValidatorManager.getCurrentObjects()) {
			final int severity = myValidatorManager.getObjectSeverity(o);
			if (severity == IMessageProvider.NONE) {
				continue;
			}
			updateSeverity(newSeverities, o, severity);
		}

		// Update myObjectSeverities and changedObjects
		final Set<Object> changedObjects = new HashSet<Object>();
		final Set<Object> deletedObjects = new HashSet<Object>();
		for (final Map.Entry<Object, Integer> e : newSeverities.entrySet()) {
			final Object o = e.getKey();
			if (myObjectSeverities.get(o) == e.getValue()) {
				continue;
			}
			if (Activator.getDefault().TRACE_LABEL_DECORATOR) {
				LogUtils.debug(this, hashCode() + ": " + o + ": NEW severity: " + e.getValue()); //$NON-NLS-1$ //$NON-NLS-2$
			}
			myObjectSeverities.put(o, e.getValue());
			changedObjects.add(o);
		}
		for (final Map.Entry<Object, Integer> e : myObjectSeverities.entrySet()) {
			final Object o = e.getKey();
			if (newSeverities.get(o) != null) {
				continue;
			}
			deletedObjects.add(o);
			changedObjects.add(o);
		}
		for (final Object o : deletedObjects) {
			myObjectSeverities.remove(o);
		}
		if (changedObjects.size() == 0) return;
		final Object[] array = changedObjects.toArray();
		final LabelProviderChangedEvent event = new LabelProviderChangedEvent(ValidationLabelDecorator.this, array);
		if (Activator.getDefault().TRACE_LABEL_DECORATOR) {
			LogUtils.debug(this, hashCode() + ": " + Arrays.toString(array)); //$NON-NLS-1$
		}
		for (final ILabelProviderListener l : myListeners) {
			try {
				l.labelProviderChanged(event);
			} catch (final Exception ex) {
				LogUtils.error(l, ex);
			}
		}
	}

	/**
	 * A static translation from integer values to the corresponding integer objects.
	 * <p>
	 * Used to avoid creating too many Integer objects in {@link #updateSeverity(Map, Object, int)}.
	 */
	private static final Integer[] SEVERITY_OBJECTS = { IMessageProvider.NONE, IMessageProvider.INFORMATION,
			IMessageProvider.WARNING, IMessageProvider.ERROR };

	/**
	 * Updates the specified map with the specified severity for the specified object if the new
	 * severity is more grave than any old severity stored for the same object.
	 * <p>
	 * If the map is updated and a propagation adapter is defined, the parent object is also
	 * updated.
	 * 
	 * @param map the map with severities
	 * @param o the object to update
	 * @param severity the new severity
	 */
	private void updateSeverity(Map<Object, Integer> map, Object o, int severity) {
		final Integer oldSeverity = map.get(o);
		if (oldSeverity != null && oldSeverity >= severity) return;
		if (oldSeverity == null) {
			int oSeverity;
			if (o instanceof EObject) {
				oSeverity = myValidatorManager.getObjectSeverity((EObject) o);
			} else {
				oSeverity = IMessageProvider.NONE;
			}
			if (severity < oSeverity) {
				severity = oSeverity;
			}
		}

		if (Activator.getDefault().TRACE_LABEL_DECORATOR) {
			LogUtils.debug(this, hashCode() + ": update " + severity + ": " + o); //$NON-NLS-1$ //$NON-NLS-2$
		}
		map.put(o, SEVERITY_OBJECTS[severity]);

		if (myPropagationAdapter == null) return;
		final Object parent = myPropagationAdapter.getParent(o);
		if (parent != null) {
			updateSeverity(map, parent, severity);
		}
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		if (PROPAGATE.equals(data)
				|| ((data instanceof Map<?, ?>) && ((Map<String, ?>) data).get(PROPAGATE) == Boolean.TRUE)) {
			myPropagationAdapter = new WorkbenchAdapterPropagationAdapter();
		}
	}

	/**
	 * {@link IPropagationAdapter} implementation that is based on {@link IWorkbenchAdapter}.
	 */
	protected static class WorkbenchAdapterPropagationAdapter implements IPropagationAdapter {
		@Override
		public Object getParent(Object object) {
			IWorkbenchAdapter adapter = null;
			if (adapter == null && object instanceof IAdaptable) {
				adapter = (IWorkbenchAdapter) ((IAdaptable) object).getAdapter(IWorkbenchAdapter.class);
			}
			if (adapter == null) {
				adapter = (IWorkbenchAdapter) Platform.getAdapterManager().getAdapter(object, IWorkbenchAdapter.class);
			}
			if (adapter == null) return object;

			return adapter.getParent(object);
		}

	}
}
