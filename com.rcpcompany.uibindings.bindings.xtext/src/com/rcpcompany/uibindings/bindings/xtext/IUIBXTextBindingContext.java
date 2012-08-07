package com.rcpcompany.uibindings.bindings.xtext;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.IValueBinding;

/**
 * UI Bindings context injected for use in the complete, etc..
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IUIBXTextBindingContext {
	/**
	 * Returns the {@link IValueBinding} of the current binding.
	 * 
	 * @return the binding
	 */
	IValueBinding getBinding();

	/**
	 * Returns the {@link IObservableValue} for the model side of the current binding.
	 * <p>
	 * Can be <code>null</code>.
	 * 
	 * @return the observable with the model value or <code>null</code>
	 */
	IObservableValue getModelOV();

	/**
	 * Returns the model object for the model side of the current binding.
	 * <p>
	 * Can be <code>null</code>.
	 * 
	 * @return the model object or <code>null</code>
	 */
	EObject getModelObject();
}
