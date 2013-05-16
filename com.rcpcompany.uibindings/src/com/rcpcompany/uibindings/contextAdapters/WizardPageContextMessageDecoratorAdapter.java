/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.contextAdapters;

import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;

/**
 * Decoration support for a single {@link IBindingContext} based on a {@link IWizardPage}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class WizardPageContextMessageDecoratorAdapter implements IContextMessageDecoratorAdapter {
	/**
	 * The form of this context decorator
	 */
	protected final WizardPage myPage;

	/**
	 * Constructs and returns a new adapter
	 * 
	 * @param page the wizard page
	 */
	public WizardPageContextMessageDecoratorAdapter(WizardPage page) {
		myPage = page;
	}

	@Override
	public void dispose() {
		// Do nothing
	}

	@Override
	public void update(List<IBindingMessage> messages, boolean inError, int maxType) {
		if (maxType == IMessageProvider.NONE) {
			myPage.setMessage(null, IMessageProvider.NONE);
		} else if (messages.size() == 1) {
			final String m = AbstractBindingMessage.getFullMessage(messages.get(0));
			myPage.setMessage(m, maxType);
		} else {
			final String m = messages.size() + " messages"; // TODO NLS
			myPage.setMessage(m, maxType);
		}
		myPage.setPageComplete(!inError);
	}
}
