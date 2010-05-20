package com.rcpcompany.uibindings.internal.observables;

/**
 * This interface is used to force an update of the value of an observable.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IUpdatableObservable {
	/**
	 * Used to force an update of the value. Any change in the value will fire an event.
	 */
	public void forceUpdateValue();
}
