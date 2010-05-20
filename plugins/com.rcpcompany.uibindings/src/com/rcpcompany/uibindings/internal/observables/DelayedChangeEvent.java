package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObservablesListener;
import org.eclipse.core.databinding.observable.ObservableEvent;

/**
 * Event for {@link IDelayedChangeListener}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DelayedChangeEvent extends ObservableEvent {

	/**
	 * Creates a new event.
	 * 
	 * @param source the source observable
	 */
	public DelayedChangeEvent(IObservable source) {
		super(source);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3491012225431471077L;

	static final Object TYPE = new Object();

	@Override
	protected void dispatch(IObservablesListener listener) {
		((IDelayedChangeListener) listener).handleDelayedChange(this);
	}

	@Override
	protected Object getListenerType() {
		return TYPE;
	}
}
