package com.rcpcompany.uibindings.validators;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * The event report via {@link IValidationAdapterManagerChangeListener}.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IValidationAdapterManagerChangeEvent {
	/**
	 * Returns a set of all the current objects of {@link IValidatorAdapterManager}.
	 * 
	 * @return the current objects
	 */
	public Set<EObject> getCurrentObjects();

	/**
	 * Returns a set of all the changed objects of {@link IValidatorAdapterManager}.
	 * 
	 * @return the changed objects
	 */
	public Set<EObject> getChangedObjects();
}
