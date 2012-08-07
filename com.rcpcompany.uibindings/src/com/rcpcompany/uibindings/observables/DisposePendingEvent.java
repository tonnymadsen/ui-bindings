package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObservablesListener;
import org.eclipse.core.databinding.observable.ObservableEvent;

/**
 * Event used to signal that a dispose is pending for an {@link IObservable}.
 * 
 * @see IDisposePendingListener
 * @author Tonny Madsen, The RCP Company
 */
public class DisposePendingEvent extends ObservableEvent {
	/**
	 * Creates a new event.
	 * 
	 * @param source the source observable
	 */
	public DisposePendingEvent(IObservable source) {
		super(source);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3491012225431471077L;

	static final Object TYPE = new Object();

	@Override
	protected void dispatch(IObservablesListener listener) {
		((IDisposePendingListener) listener).disposePending(this);
	}

	@Override
	protected Object getListenerType() {
		return TYPE;
	}
}
