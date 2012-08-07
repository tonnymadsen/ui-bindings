package com.rcpcompany.uibindings.validators;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter.Message;

/**
 * The full description of a single constraint.
 * <p>
 * Created in {@link ConstraintValidatorAdapter#getConstraints(EObject)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IConstraintValidatorAdapterConstraint {
	/**
	 * Validates the specified object against this constraint.
	 * <p>
	 * If the validation fails a new message is added to the messages list - if not already present
	 * - and (whether it existed already or not) returned.
	 * 
	 * @param obj the object to validate
	 * @param messages the list of current messages
	 * @return the message for the validation if it failed
	 */
	Message validate(EObject obj, IObservableList messages);
}
