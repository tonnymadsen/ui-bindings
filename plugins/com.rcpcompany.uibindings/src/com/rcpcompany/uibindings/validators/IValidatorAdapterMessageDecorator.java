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

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IValueBinding;

/**
 * This interface is used by a message decorator for the {@link IValidatorAdapterManager validator
 * manager}.
 * <p>
 * A message decorator is associated with a specific binding and will decorate a binding with a
 * specific set of messages from the vailator manager.
 * <p>
 * The messages are added and removed via the methods {@link #addMessage(IBindingMessage)} and
 * {@link #removeMessage(IBindingMessage)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IValidatorAdapterMessageDecorator {

	/**
	 * The binding of this decorator.
	 * <p>
	 * Used to construct bound messages.
	 * 
	 * @return the binding of this decorator
	 */
	IValueBinding getBinding();

	/**
	 * Adds a message to the decorator.
	 * 
	 * @param message the new message
	 */
	void addMessage(IBindingMessage message);

	/**
	 * Removes a message from the decorator.
	 * 
	 * @param message the message to remove
	 */
	void removeMessage(IBindingMessage message);

	/**
	 * Returns whethe the unbound message is acceptable for this decorator.
	 * 
	 * @param unboundMessage the unbound message to test
	 * @return <code>true</code> if the message is acceptable for the decorator
	 */
	boolean accept(IBindingMessage unboundMessage);
}
