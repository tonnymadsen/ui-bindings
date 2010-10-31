/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.validators;

import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IMessageProvider;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.validators.ValidatorAdapterManager;

/**
 * This manager handles all registered validation adapters as well as distribution of messages on
 * all value bindings.
 * <p>
 * All matching between {@link IBindingMessage messages} and {@link IValueBinding value binding} is
 * performed in this class. As a special case, the class also tracks changes in the base object of
 * value binding - e.g. this happens in master-detail forms - and updates the value binding with new
 * messages.
 * <p>
 * The implementation is made under the assumption that there are relatively few messages compared
 * with the number of active bindings.
 * <p>
 * Also the manager must be created before any binding that wants to use the service.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IValidatorAdapterManager {
	/**
	 * The factory methods for {@link IValidatorAdapterManager}.
	 */
	final class Factory {
		private Factory() {
		}

		/**
		 * Returns the singleton manager.
		 * 
		 * @return the manager
		 */
		public static IValidatorAdapterManager getManager() {
			return ValidatorAdapterManager.getManager();
		}
	}

	/**
	 * Adds a listener to this manager.
	 * 
	 * @param listener the new listener
	 */
	void addValidationAdapterManagerChangeListener(IValidationAdapterManagerChangeListener listener);

	/**
	 * Removes a listener from this manager.
	 * 
	 * @param listener the listener to remove
	 */
	void removeValidationAdapterManagerChangeListener(IValidationAdapterManagerChangeListener listener);

	/**
	 * Adds a new root object to the set of objects for which validation is done.
	 * 
	 * @param root the new root
	 * @param validationAdapter the validation adapter to use for the root
	 */
	void addRoot(EObject root, IValidatorAdapter validationAdapter);

	/**
	 * Removes an existing root object from the set of objects for which validation is done.
	 * 
	 * @param root the root to remove
	 * @param validationAdapter the used adapter
	 */
	void removeRoot(EObject root, IValidatorAdapter validationAdapter);

	/**
	 * Returns a list of all current messages.
	 * 
	 * @return a list
	 */
	List<IBindingMessage> getUnboundMessages();

	/**
	 * Observable list version of {@link #getUnboundMessages()} with element type
	 * {@link IBindingMessage} Eclass.
	 * 
	 * @return the observable list
	 */
	IObservableList getUnboundMessagesOL();

	/**
	 * Delayed validation of all changed object roots.
	 */
	void delayValidation();

	/**
	 * Immediately validate all changed object roots.
	 */
	void validate();

	/**
	 * Adds the specified decorator to this manager and populates it with all relevant messages.
	 * 
	 * @param decorator the new decorator
	 */
	void addDecorator(IValidatorAdapterMessageDecorator decorator);

	/**
	 * Removes the specified decorator from this manager and all messages from this manager that are
	 * shown in the decorator.
	 * 
	 * @param decorator the decorator to remove
	 */
	void removeDecorator(IValidatorAdapterMessageDecorator decorator);

	/**
	 * Resets the specified decoration, which basically means all the current messages are removed
	 * and new messages are created - if any...
	 * <p>
	 * For now, we just remove and re-add the decorator...
	 * 
	 * @param decorator the decorator to reset
	 */
	void resetDecorator(IValidatorAdapterMessageDecorator decorator);

	/**
	 * Checks and returns the max severity of the object in the form of one of the severity values
	 * of {@link IBindingMessage}.
	 * 
	 * @param object the object to check
	 * @return one of {@link IMessageProvider#NONE}, {@link IMessageProvider#INFORMATION},
	 *         {@link IMessageProvider#WARNING} or {@link IMessageProvider#ERROR}
	 */
	int getObjectSeverity(EObject object);

	/**
	 * Executes the the specified runnable with a pause in the validation.
	 * 
	 * @param runnable the runnable to run
	 */
	void executeWithoutValidation(Runnable runnable);

	/**
	 * Resets the manager to some sane state.
	 * <p>
	 * For use in tests...
	 */
	void reset();

	/**
	 * Returns an unmodifiable set of the objects that currently have associated messages.
	 * 
	 * @return the set of objects
	 */
	Set<EObject> getCurrentObjects();
}
