package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.IObservable;

/**
 * Mix-in interface for {@link IObservable}. Allows co-operating users to signal and be signalled
 * that a disposal is pending.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IDisposePendingObservable {
	void fireDisposePending();

	void addDisposePendingListener(IDisposePendingListener listener);

	void removeDisposePendingListener(IDisposePendingListener listener);
}
