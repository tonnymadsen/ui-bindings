package com.rcpcompany.uibindings.internal.utils;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.utils.IBindingMessagesPopup;

/**
 * Popup dialog that can show a list of messages.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingMessagesPopup extends ContentProposalAdapter implements IBindingMessagesPopup {

	/**
	 * Constructs and returns a new message popup.
	 * 
	 * @param control the control that should have the popup assiciated.
	 * @param messages the messages to show
	 */
	public BindingMessagesPopup(Control control) {
		super(control, new MyControlContentAdapter(), null, null, null);
		setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_IGNORE);
		addContentProposalListener(new IContentProposalListener() {
			@Override
			public void proposalAccepted(IContentProposal proposal) {
				Assert.isNotNull(proposal);
				final IBindingMessage message = ((MyContentProposal) proposal).getMessage();

				message.getBinding().setFocus();
			}
		});
		setLabelProvider(new MyQuickfixLabelProvider());
	}

	/**
	 * Opens the adapter.
	 */
	@Override
	public void open(List<IBindingMessage> messages) {
		setContentProposalProvider(new MyContentProposalProvider(messages));
		openProposalPopup();
	}

	@Override
	public void dispose() {
		closeProposalPopup();
	}

	/**
	 * A single proposal...
	 */
	protected static class MyContentProposal implements IContentProposal {
		private final IBindingMessage myMessage;

		/**
		 * Constructs and returns a new proposal based on the specified message
		 * 
		 * @param message the message
		 */
		public MyContentProposal(IBindingMessage message) {
			myMessage = message;
		}

		@Override
		public String getContent() {
			return null;
		}

		@Override
		public int getCursorPosition() {
			return 0;
		}

		@Override
		public String getDescription() {
			return null;
		}

		@Override
		public String getLabel() {
			return getMessage().getMessage();
		}

		/**
		 * Returns the message that backs this proposal.
		 * 
		 * @return the message
		 */
		public IBindingMessage getMessage() {
			return myMessage;
		}
	}

	/**
	 * A simple content provider...
	 */
	protected static class MyContentProposalProvider implements IContentProposalProvider {
		/**
		 * The messages to show
		 */
		public final IContentProposal[] myMessages;

		/**
		 * Constructs and returns new provider.
		 * 
		 * @param messages the messages of the provider
		 */
		public MyContentProposalProvider(List<IBindingMessage> messages) {
			myMessages = new IContentProposal[messages.size()];
			for (int i = 0; i < messages.size(); i++) {
				final IBindingMessage m = messages.get(i);
				myMessages[i] = new MyContentProposal(m);
			}
		}

		@Override
		public IContentProposal[] getProposals(String contents, int position) {
			return myMessages;
		}
	};

	/**
	 * A label provider for the messages..
	 */
	protected static class MyQuickfixLabelProvider extends BaseLabelProvider implements ILabelProvider {
		@Override
		public String getText(Object proposal) {
			Assert.isNotNull(proposal);
			final IBindingMessage message = ((MyContentProposal) proposal).getMessage();

			return AbstractBindingMessage.getFullMessage(message);
		}

		@Override
		public Image getImage(Object proposal) {
			Assert.isNotNull(proposal);
			final IBindingMessage message = ((MyContentProposal) proposal).getMessage();
			switch (message.getSeverity()) {
			case ERROR:
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
			case WARNING:
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK);
			case INFORMATION:
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_INFO_TSK);
			case NONE:
				return null;
			}
			return null;
		}
	}

	/**
	 * A null ControlContentAdapter that does... nothing...
	 */
	protected static class MyControlContentAdapter implements IControlContentAdapter {
		@Override
		public String getControlContents(Control control) {
			return "";
		}

		@Override
		public int getCursorPosition(Control control) {
			return 0;
		}

		@Override
		public Rectangle getInsertionBounds(Control control) {
			return null;
		}

		@Override
		public void insertControlContents(Control control, String contents, int cursorPosition) {
		}

		@Override
		public void setControlContents(Control control, String contents, int cursorPosition) {
		}

		@Override
		public void setCursorPosition(Control control, int index) {
		}
	}

}
