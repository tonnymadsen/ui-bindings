package com.rcpcompany.uibindings.validators;

import com.rcpcompany.uibindings.IValueBinding;

/**
 * Provider for {@link IConstraintValidatorAdapterConstraint}.
 * <p>
 * Returns a constraint for binding if relevant.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IConstraintValidatorAdapterConstraintProvider {
	/**
	 * Returns a constraint to use for the specified (virtual) binding if relevant.
	 * <p>
	 * Otherwise <code>null</code> is returned.
	 * 
	 * @param binding the binding to return a constraint for
	 * @return the constraint for the binding or <code>null</code>
	 */
	IConstraintValidatorAdapterConstraint getConstraint(IValueBinding binding);
}
