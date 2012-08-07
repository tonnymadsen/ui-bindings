/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.bindingMessages;

import org.eclipse.core.databinding.observable.list.IObservableList;

import com.rcpcompany.uibindings.IBindingMessage;

/**
 * Interface used by {@link ContextMessageDecorator} when retriving messages to show for a context.
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
	IObservableList getMessages();
}
