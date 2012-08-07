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

import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IDisposable;

/**
 * This interface is used to adapt between the {@link ContextMessageDecorator} and the
 * form/wizard/whatever that is used to shows the context.
 * <p>
 * The main function of the interface is {@link #update(List,boolean,int)} that should update the
 * form/whatever with
 * <ul>
 * <li>a specified list of messages are to be shown</li>
 * <li>whether the context is in error or not. This is used to enable/disable any build-in "Accept",
 * "OK", or "Next" buttons.</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IContextMessageDecoratorAdapter extends IDisposable {
	/**
	 * Updates the form/wizard/whatever that a specific set of messages are to be shown.
	 * 
	 * @param messages the messages to be shown
	 * @param inError <code>true</code> if the context is in error
	 * @param maxType the max message type - one of {@link IMessageProvider#NONE},
	 *            {@link IMessageProvider#INFORMATION}, {@link IMessageProvider#WARNING}, or
	 *            {@link IMessageProvider#ERROR}
	 */
	void update(List<IBindingMessage> messages, boolean inError, int maxType);
}
