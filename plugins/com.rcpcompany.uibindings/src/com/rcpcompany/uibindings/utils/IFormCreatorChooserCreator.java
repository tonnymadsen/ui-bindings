package com.rcpcompany.uibindings.utils;

import org.eclipse.core.databinding.observable.value.IObservableValue;

/**
 * This interface is used by {@link IFormChooser} to create new forms based on {@link IFormCreator}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IFormCreatorChooserCreator {
	/**
	 * Creates a new form with the specified parent.
	 * <p>
	 * The form is automatically {@link IFormCreator#finish() finished} when the call has returned.
	 * 
	 * @param discriminant the discriminant value that resulted in the form
	 * @param form the form for the chooser
	 */
	public void createForm(IObservableValue discriminant, IFormCreator form);
}
