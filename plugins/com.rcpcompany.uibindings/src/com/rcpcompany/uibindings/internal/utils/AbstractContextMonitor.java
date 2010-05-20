package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * This class is used as the base class for context adapter and other classes that needs to monitor the coming and going
 * of bindings in a context
 * 
 * TODO TEST
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractContextMonitor implements IDisposable {
	private final IBindingContext myContext;

	/**
	 * Constructs and returns a new context monitor
	 * 
	 * @param context the context to monitor
	 */
	public AbstractContextMonitor(IBindingContext context) {
		myContext = context;
	}

	/**
	 * Initializes this monitor.
	 */
	public void init() {
		getContext().registerService(this);
		myContext.eAdapters().add(myContextAdapter);
		for (final IBinding b : myContext.getOkBindings()) {
			bindingAdded(b);
		}
	}

	/**
	 * Disposes of the monitor.
	 */
	@Override
	public void dispose() {
		for (final IBinding b : myContext.getOkBindings()) {
			bindingRemoved(b);
		}
		getContext().eAdapters().remove(myContextAdapter);
		getContext().deregisterService(this);
	}

	/**
	 * Returns the context of this monitor
	 * 
	 * @return the context
	 */
	public IBindingContext getContext() {
		return myContext;
	}

	private final Adapter myContextAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) {
				return;
			}
			if (msg.getFeature() != IUIBindingsPackage.Literals.BINDING_CONTEXT__OK_BINDINGS) {
				return;
			}
			switch (msg.getEventType()) {
			case Notification.ADD:
				final IBinding newBinding = (IBinding) msg.getNewValue();
				if (newBinding.getState() == BindingState.OK) {
					bindingAdded(newBinding);
				} else {
					((EObject) newBinding).eAdapters().add(myOKAdapter);
				}
				break;
			case Notification.REMOVE:
				bindingRemoved((IBinding) msg.getOldValue());
				break;
			}
		}
	};

	private final Adapter myOKAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) {
				return;
			}
			if (msg.getFeature() != IUIBindingsPackage.Literals.BINDING_STATE) {
				return;
			}
			final IBinding newBinding = (IBinding) msg.getNotifier();
			switch (newBinding.getState()) {
			case OK:
				bindingAdded(newBinding);
				//$FALL-THROUGH$
			case DISPOSED:
				((EObject) newBinding).eAdapters().remove(myOKAdapter);
				break;
			default:
				break;
			}
		}
	};

	/**
	 * Invoked for each added binding in the context.
	 * 
	 * @param binding the new binding
	 */
	protected void bindingAdded(IBinding binding) {

	}

	/**
	 * Invoked for each removed binding in the context.
	 * 
	 * @param binding the new binding
	 */
	protected void bindingRemoved(IBinding binding) {

	}
}
