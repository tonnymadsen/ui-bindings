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
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.internal.Messages;
import com.rcpcompany.uibindings.utils.IBindingMessagesPopup;

/**
 * Decoration support for a single {@link IBindingContext} based on a {@link ScrolledForm}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScrolledFormContextMessageDecoratorAdapter implements IContextMessageDecoratorAdapter {
	/**
	 * The form of this context decorator
	 */
	protected final ScrolledForm myForm;

	protected List<IBindingMessage> myCurrentMessages = null;

	/**
	 * Constructs and returns a new decorator context adapter
	 * 
	 * @param form the form
	 */
	public ScrolledFormContextMessageDecoratorAdapter(ScrolledForm form) {
		myForm = form;

		myForm.getForm().addMessageHyperlinkListener(myHyperlinkListener);
	}

	@Override
	public void dispose() {
		if (myPopup != null) {
			myPopup.dispose();
		}
		if (!myForm.isDisposed()) {
			try {
				myForm.getForm().removeMessageHyperlinkListener(myHyperlinkListener);
			} catch (final SWTException ex) { // $codepro.audit.disable emptyCatchClause
				// Ignore: handle exception from hyperlink of the form
				// TODO solve this problem
			}
		}
	}

	private static final String[] MULTIPLE_MESSAGE_SUMMARY_KEYS = {
			Messages.MessageDecoratorContextAdapter_pMessageSummary,
			Messages.MessageDecoratorContextAdapter_pMessageSummary,
			Messages.MessageDecoratorContextAdapter_pWarningSummary,
			Messages.MessageDecoratorContextAdapter_pErrorSummary };

	/*
	 * Based on MessageManager.update(List)
	 */
	@Override
	public void update(List<IBindingMessage> messages, boolean inError, int maxType) {
		// LogUtils.debug(this, "\n" + messages + "\nerror: " + inError + " type: " + maxType);
		if (myForm.getForm().getHead().isDisposed()) return;
		if (myForm.getForm().getHead().getBounds().height == 0 || messages.isEmpty()) {
			myForm.setMessage(null, IMessageProvider.NONE);
			return;
		}

		myCurrentMessages = messages;
		String messageText = null;
		if (myCurrentMessages.size() == 1) {
			// a single message
			final IBindingMessage message = messages.get(0);
			messageText = AbstractBindingMessage.getFullMessage(message);
			myForm.setMessage(messageText, maxType);
		} else {
			// show a summary message for the message and list of errors for the details
			messageText = NLS.bind(MULTIPLE_MESSAGE_SUMMARY_KEYS[maxType], new String[] { messages.size() + "" }); //$NON-NLS-1$
			myForm.setMessage(messageText, maxType);
		}
	}

	/**
	 * The popup for the messages.
	 */
	protected IBindingMessagesPopup myPopup;

	/**
	 * Hyper link listener used when the form header is clicked.
	 */
	private final IHyperlinkListener myHyperlinkListener = new HyperlinkAdapter() {

		@Override
		public void linkActivated(HyperlinkEvent e) {
			switch (myCurrentMessages.size()) {
			case 0:
				return;
			case 1:
				// Just one message - go there directly
				myCurrentMessages.get(0).getBinding().setFocus();
				return;
			default:
				if (myPopup == null) {
					myPopup = IBindingMessagesPopup.Factory.create((Control) e.getSource());
				}
				myPopup.open(myCurrentMessages);
			}
		}
	};
}
