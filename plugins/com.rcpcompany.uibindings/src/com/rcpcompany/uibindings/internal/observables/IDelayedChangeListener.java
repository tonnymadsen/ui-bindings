package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IObservablesListener;
import org.eclipse.core.databinding.observable.IStaleListener;
import org.eclipse.core.databinding.observable.StaleEvent;

import com.rcpcompany.uibindings.TextCommitStrategy;

/**
 * Listener for delayed change events. A listener will receive delayed change events if a change is pending according to
 * the current {@link TextCommitStrategy}, but the change has not been committed yet.
 * <p>
 * As such, this is very similar to {@link IStaleListener}, but {@link StaleEvent} are only fired once for each an
 * observable becomes stale, whereas {@link DelayedChangeEvent} is fired for each change of the observable until a
 * {@link ChangeEvent}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IDelayedChangeListener extends IObservablesListener {

	/**
	 * Notifies the listener that a delayed change is pending.
	 * 
	 * @param event the event
	 */
	public void handleDelayedChange(DelayedChangeEvent event);
}
