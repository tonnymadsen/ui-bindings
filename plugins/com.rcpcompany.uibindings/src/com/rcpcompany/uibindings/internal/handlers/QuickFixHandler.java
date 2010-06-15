package com.rcpcompany.uibindings.internal.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Handler for quick fixes...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class QuickFixHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// LogUtils.debug(this, "hello");
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "");
		}
		final IValueBinding binding = (IValueBinding) HandlerUtil.getVariable(event, Constants.SOURCES_ACTIVE_BINDING);
		if (binding == null) {
			Display.getDefault().beep();
			throw new ExecutionException("Quickfixes not supported for control");
		}

		final ValueBindingMessageImageDecorator decorator = binding.getService(ValueBindingMessageImageDecorator.class);
		if (decorator == null) {
			Display.getDefault().beep();
			throw new ExecutionException("Quickfixes not supported for control");
		}

		final List<IQuickfixProposal> quickfixes = decorator.getQuickfixes();

		if (quickfixes == null || quickfixes.size() == 0) return null;

		if (quickfixes.size() == 1 && IManager.Factory.getManager().isAutoApplySingleQuickfix()) {
			quickfixes.get(0).apply();
			return null;
		}
		final IQuickfixProposal[] quickfixArray = quickfixes.toArray(new IQuickfixProposal[quickfixes.size()]);

		final IContentProposalProvider proposalProvider = new IContentProposalProvider() {
			@Override
			public IContentProposal[] getProposals(String contents, int position) {
				return quickfixArray;
			}
		};
		final MyContentProposalAdapter proposalAdapter = new MyContentProposalAdapter(binding.getControl(),
				new MyControlContentAdapter(), proposalProvider);
		proposalAdapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_IGNORE);
		proposalAdapter.addContentProposalListener(new IContentProposalListener() {
			@Override
			public void proposalAccepted(IContentProposal proposal) {
				Assert.isNotNull(proposal);
				final IQuickfixProposal quickfix = (IQuickfixProposal) proposal;
				quickfix.apply();
			}
		});
		proposalAdapter.setLabelProvider(new MyQuickfixLabelProvider());
		proposalAdapter.open();

		return null;
	}

	protected static class MyContentProposalAdapter extends ContentProposalAdapter {

		public MyContentProposalAdapter(Control control, IControlContentAdapter controlContentAdapter,
				IContentProposalProvider proposalProvider) {
			super(control, controlContentAdapter, proposalProvider, null, null);
		}

		/**
		 * Opens the adapter.
		 */
		public void open() {
			openProposalPopup();
		}
	}

	/**
	 * A label provider for the quickfixes..
	 */
	protected static class MyQuickfixLabelProvider extends BaseLabelProvider implements ILabelProvider {
		@Override
		public String getText(Object proposal) {
			Assert.isNotNull(proposal);
			final IQuickfixProposal quickfix = (IQuickfixProposal) proposal;
			return quickfix.getLabel();
		}

		@Override
		public Image getImage(Object proposal) {
			Assert.isNotNull(proposal);
			final IQuickfixProposal quickfix = (IQuickfixProposal) proposal;
			final ImageDescriptor image = quickfix.getImage();
			if (image == null) return null;
			return image.createImage(true);
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
