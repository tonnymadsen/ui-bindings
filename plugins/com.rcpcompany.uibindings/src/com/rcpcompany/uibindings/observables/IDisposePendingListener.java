package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.IObservablesListener;

/**
 * Listener used to be notified from an {@link IDisposePendingObservable} that a dispose is pending.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IDisposePendingListener extends IObservablesListener {
	void disposePending(DisposePendingEvent event);
}
