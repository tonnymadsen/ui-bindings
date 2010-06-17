package com.rcpcompany.uibindings.validators;

/**
 * Listener interface for changes in {@link IValidatorAdapterManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IValidationAdapterManagerChangeListener {
	/**
	 * Signals that the state of the {@link IValidatorAdapterManager} has changed. specified objects
	 * have either gotten additional messages, changed messages or "lost" messages.
	 * 
	 * @param event a description of the current state
	 */
	void affectedObjectsChanged(IValidationAdapterManagerChangeEvent event);
}
