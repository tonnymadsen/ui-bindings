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
	public final static class Factory {
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
	 * Opens the popup for the specified messages
	 */
	public void open(List<IBindingMessage> messages);
}
