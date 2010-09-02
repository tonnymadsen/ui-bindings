package com.rcpcompany.uibindings.units;

/**
 * Interface used by listeners for changes in the {@link IUnitBindingSupport unit support for
 * bindings}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IUnitBindingSupportListener {
	/**
	 * Invoked to notify the listener that units might have changed that is relevant for listener.
	 */
	void unitsChanged();
}
