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
package com.rcpcompany.uibindings.utils;

import java.util.List;

import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.BindingMessagesPopup;

/**
 * This interface is used to show a popup menu for a set of messages. If any of the messages are
 * clicked, focus will be moved to the binding in question.
 * 
 * @author Tonny Madsen, The RCP Company
 * @noimplement
 */
public interface IBindingMessagesPopup extends IDisposable {
	final class Factory {
		private Factory() {

		}

		/**
		 * Constructs and returns a new popup.
		 * 
		 * @param control the control for the popup
		 * @return the popup
		 * 
		 */
		public static IBindingMessagesPopup create(Control control) {
			return new BindingMessagesPopup(control);
		}
	}

	/**
	 * Opens the popup for the specified messages.
	 */
	void open(List<IBindingMessage> messages);
}
