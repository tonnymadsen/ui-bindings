package com.rcpcompany.uibindings.validators;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IMessageProvider;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.validators.ValidatorAdapterManager;

/**
 * This manager handles all registered validation adapters as well as distribution of messages on all value bindings.
 * <p>
 * All matching between {@link IBindingMessage messages} and {@link IValueBinding value binding} is performed in this
 * class. As a special case, the class also tracks changes in the base object of value binding - e.g. this happens in
 * master-detail forms - and updates the value binding with new messages.
 * <p>
 * The implementation is made under the assumption that there are relatively few messages compared with the number of
 * active bindings.
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
	public static final class Factory {
		/**
		 * Returns the singleton manager
		 * 
		 * @return the manager
		 */
		public static IValidatorAdapterManager getManager() {
			return ValidatorAdapterManager.getManager();
		}
	}

	/**
	 * Adds a listener to this manager
	 * 
	 * @param listener the new listener
	 */
	public void addValidationAdapterManagerChangeListener(IValidationAdapterManagerChangeListener listener);

	/**
	 * Removes a listener from this manager
	 * 
	 * @param listener the listener to remove
	 */
	public void removeValidationAdapterManagerChangeListener(IValidationAdapterManagerChangeListener listener);

	/**
	 * Adds a new root object to the set of objects for which validation is done
	 * 
	 * @param root the new root
	 * @param validationAdapter TODO
	 */
	public void addRoot(EObject root, IValidatorAdapter validationAdapter);

	/**
	 * Removes an existing root object from the set of objects for which validation is done
	 * 
	 * @param root the root to remove
	 * @param validationAdapter the used adapter
	 */
	public void removeRoot(EObject root, IValidatorAdapter validationAdapter);

	/**
	 * Returns a list of all current messages
	 * 
	 * @return a list
	 */
	public List<IBindingMessage> getUnboundMessages();

	/**
	 * Observable list version of {@link #getUnboundMessages()} with element type {@link IBindingMessage} Eclass.
	 * 
	 * @return the observable list
	 */
	public IObservableList getUnboundMessagesOL();

	/**
	 * Delay the next validation of all objects.
	 */
	public void delayValidation();

	/**
	 * Immediately validate all root objects...
	 */
	public void validate();

	/**
	 * Adds the specified decorator to this manager and populates it with all relevant messages.
	 * 
	 * @param decorator the new decorator
	 */
	public void addDecorator(IValidatorAdapterMessageDecorator decorator);

	/**
	 * Removes the specified decorator from this manager and all messages from this manager that are shown in the
	 * decorator.
	 * 
	 * @param decorator the decorator to remove
	 */
	public void removeDecorator(IValidatorAdapterMessageDecorator decorator);

	/**
	 * Resets the specified decoration, which basically means all the current messages are removed and new messages are
	 * created - if any...
	 * <p>
	 * For now, we just remove and re-add the decorator...
	 * 
	 * @param decorator the decorator to reset
	 */
	public void resetDecorator(IValidatorAdapterMessageDecorator decorator);

	/**
	 * Checks and returns the max severity of the object in the form of one of the severity values of
	 * {@link IBindingMessage}.
	 * 
	 * @param object the object to check
	 * @return one of {@link IMessageProvider#NONE}, {@link IMessageProvider#INFORMATION},
	 *         {@link IMessageProvider#WARNING} or {@link IMessageProvider#ERROR}
	 */
	public int getObjectSeverity(EObject object);

	/**
	 * Executes the the specified runnable with a pause to the validation.
	 * 
	 * @param runnable the runnable to run
	 */
	public void executeWithoutValidation(Runnable runnable);

	/**
	 * Resets the manager to some sane state.
	 * <p>
	 * For use in tests...
	 */
	void reset();
}
