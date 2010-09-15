package com.rcpcompany.uibindings.quixkfixes;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorContext;
import com.rcpcompany.uibindings.internal.QuickfixProposalProcessorImpl;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposal.Type;

/**
 * Abstract base class for all quick fix proposal processors.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public abstract class AbstractQuickfixProposalProcessor extends QuickfixProposalProcessorImpl {

	@Override
	public void getProposals(IQuickfixProposalProcessorContext context) {
		/*
		 * Fall back on the original
		 */
		getProposals(context, context.getMessage());
	}

	@Override
	public void getProposals(IQuickfixProposalProcessorContext context, IBindingMessage message) {

	}

	/**
	 * Constructs and returns a new proposal.
	 * 
	 * @param context the context to add to
	 * @param title the title to use
	 * @param replacementString the replacement string
	 */
	public void addReplacementProposal(IQuickfixProposalProcessorContext context, String title, String replacementString) {
		addReplacementProposal(context, Type.CHANGE, IQuickfixProposal.DEFAULT_RELEVANCE, title, replacementString);
	}

	/**
	 * Constructs and returns a new proposal.
	 * 
	 * @param context the context to add to
	 * @param type the basic type of the proposal
	 * @param relevance the relevance of the proposal
	 * @param title the title to use
	 * @param replacementString the replacement string
	 */
	public void addReplacementProposal(IQuickfixProposalProcessorContext context, Type type, int relevance,
			String title, String replacementString) {
		context.addProposal(new ReplacementProposal(context.getMessage(), type, relevance, title, replacementString));
	}

	/**
	 * A generic replacement string for the current widget.
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	public static class ReplacementProposal extends AbstractQuickfixProposal {
		private final IBindingMessage myMessage;
		private final String myReplacementString;

		/**
		 * Constructs and returns a new proposal.
		 * 
		 * @param message the original decorator message
		 * @param type the basic type of the proposal
		 * @param relevance the wanted relevance or <code>null</code>
		 * @param title the title to use
		 * @param replacementString the replacement string
		 */
		protected ReplacementProposal(IBindingMessage message, Type type, int relevance, String title,
				String replacementString) {
			super(title, type, relevance);
			myMessage = message;
			myReplacementString = replacementString;
		}

		@Override
		public void apply() {
			final IObservableValue observable = myMessage.getBinding().getUIObservable();
			if (observable.getValueType() != String.class) return;
			observable.setValue(myReplacementString);

			final Control control = myMessage.getBinding().getControl();
			if (control.isFocusControl()) {
				if (control instanceof Text) {
					final Text t = (Text) control;
					t.setSelection(0, myReplacementString.length());
				} else if (control instanceof Combo) {
					final Combo t = (Combo) control;
					t.setSelection(new Point(0, myReplacementString.length()));
				} else if (control instanceof CCombo) {
					final CCombo t = (CCombo) control;
					t.setSelection(new Point(0, myReplacementString.length()));
				} else if (control instanceof StyledText) {
					final StyledText t = (StyledText) control;
					t.setSelection(new Point(0, myReplacementString.length()));
				} else {
					// Nothing...
				}
			}
		}

		@Override
		public String getDescription() {
			return "Replace the current text with '" + myReplacementString + "'";
		}
	};

}
