package com.rcpcompany.uibindings.units;

import com.rcpcompany.uibindings.IValueBinding;

/**
 * The context interface for {@link IUnitBindingSupport} methods.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IUnitBindingSupportContext {
	/**
	 * Returns the binding for the adapter method.
	 * 
	 * @return the binding
	 */
	IValueBinding getBinding();
}
