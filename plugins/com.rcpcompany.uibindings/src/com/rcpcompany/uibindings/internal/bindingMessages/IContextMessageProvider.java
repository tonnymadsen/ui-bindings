package com.rcpcompany.uibindings.internal.bindingMessages;

import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IBindingMessage;

/**
 * Interface used by {@link ContextMessageDecorator} when retriving messages to show for a context
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IContextMessageProvider {
	/**
	 * Returns a list of all current messages from this decorator.
	 * <p>
	 * Changes can be observed on the list with element type {@link IBindingMessage}.
	 * 
	 * @return the list - possibly empty, but always non-<code>null</code>
	 */
	public IObservableList getMessages();
}
