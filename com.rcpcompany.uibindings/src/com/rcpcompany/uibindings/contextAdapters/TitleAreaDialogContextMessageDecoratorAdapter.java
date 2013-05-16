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

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;

/**
 * Decoration support for a single {@link IBindingContext} based on a {@link TitleAreaDialog}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class TitleAreaDialogContextMessageDecoratorAdapter implements IContextMessageDecoratorAdapter {
	/**
	 * The form of this context decorator
	 */
	protected final TitleAreaDialog myDialog;

	/**
	 * The OK button of the dialog
	 */
	private Button myOKButton;

	/**
	 * Constructs and returns a new adapter
	 * 
	 * @param dialog the wizard page
	 */
	public TitleAreaDialogContextMessageDecoratorAdapter(TitleAreaDialog dialog) {
		myDialog = dialog;
	}

	@Override
	public void dispose() {
		// Do nothing
	}

	@Override
	public void update(List<IBindingMessage> messages, boolean inError, int maxType) {
		if (maxType == IMessageProvider.NONE) {
			myDialog.setMessage(null, IMessageProvider.NONE);
		} else if (messages.size() == 1) {
			final String m = AbstractBindingMessage.getFullMessage(messages.get(0));
			myDialog.setMessage(m, maxType);
		} else {
			final String m = messages.size() + " messages"; // TODO NLS
			myDialog.setMessage(m, maxType);
		}
		/*
		 * We assume that the button bar is a standard bar as created by Dialog.createButtonBar...
		 * 
		 * See Dialog.createButton(...)
		 */
		if (myOKButton == null) {
			if (myDialog.buttonBar instanceof Composite) {
				final Composite buttonBarComposite = (Composite) myDialog.buttonBar;
				for (final Control c : buttonBarComposite.getChildren()) {
					if (!(c instanceof Button)) {
						continue;
					}
					final Button b = (Button) c;
					final Object data = b.getData();
					if (!(data instanceof Integer)) {
						continue;
					}
					final Integer i = (Integer) data;
					if (i.intValue() == IDialogConstants.OK_ID) {
						myOKButton = b;
						break;
					}
				}
			}
		}
		if (myOKButton != null) {
			myOKButton.setEnabled(!inError);
		}
	}
}
