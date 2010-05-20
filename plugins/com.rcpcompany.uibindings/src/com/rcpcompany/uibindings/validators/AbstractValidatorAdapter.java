package com.rcpcompany.uibindings.validators;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;

/**
 * Abstract base class for validator adapters.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public abstract class AbstractValidatorAdapter implements IValidatorAdapter {

	@Override
	public abstract void validateObjectTree(EObject root, IObservableList messages);

	@Override
	public void dispose() {
	}
}
