package com.rcpcompany.uibindings.internal.quickfixes;

import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IQuickfixProposalProcessor;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorContext;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposalProcessor;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposal.Type;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Quick fix proposal processor for spelling related problems...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NamingQuickfixProposalProcessor extends AbstractQuickfixProposalProcessor implements
		IQuickfixProposalProcessor {

	@Override
	public void getProposals(IQuickfixProposalProcessorContext context, IBindingMessage message) {
		final IValueBinding binding = message.getBinding();
		if (binding == null) {
			return;
		}
		final IUIBindingDecorator decorator = binding.getDecorator();
		final List<Object> list = decorator.getValidUIList();
		if (list == null) {
			return;
		}

		final IObservableValue observable = binding.getUIObservable();
		if (observable.getValueType() != String.class) {
			return;
		}
		final String text = (String) observable.getValue();
		if (text == null) {
			return; // Possible for Lists
		}

		for (final Object e : list) {
			if (e == null) {
				// LogUtils.debug(decorator, "decorator returns null values in validUIList");
				continue;
			}
			if (!(e instanceof String)) {
				LogUtils.debug(decorator, "decorator returns non-String values in validUIList");
				continue;
			}
			matchOne(context, message, text, (String) e);
		}
	}

	private void matchOne(IQuickfixProposalProcessorContext context, IBindingMessage message, String gotString,
			String wantedString) {

		// Perfect match
		if (wantedString.equals(gotString)) {
			return;
		}

		// Case error, but match
		if (wantedString.equalsIgnoreCase(gotString)) {
			addReplacementProposal(context, message, Type.CHANGE, IQuickfixProposal.SURE_PROPOSAL, "Change case",
					wantedString);
		}

		final int wantedLen = wantedString.length();
		final int gotLen = gotString.length();

		// Missing letter, but match
		for (int i = 0; i < wantedLen; i++) {
			// Construct the near miss
			final String nearWanted = wantedString.substring(0, i) + wantedString.substring(i + 1);
			if (nearWanted.equals(gotString)) {
				addReplacementProposal(context, message, Type.CHANGE, IQuickfixProposal.LIKELY_PROPOSAL,
						"Add missing letter", wantedString);
			}
		}

		// Extra letter, but match
		for (int i = 0; i < gotLen; i++) {
			// Construct the near miss
			final String nearWanted = gotString.substring(0, i) + gotString.substring(i + 1);
			if (nearWanted.equals(wantedString)) {
				addReplacementProposal(context, message, Type.CHANGE, IQuickfixProposal.LIKELY_PROPOSAL,
						"Remove extra letter", wantedString);
			}
		}

		// Transposed letter, but match
		for (int i = 0; i < wantedLen - 1; i++) {
			// Construct the near miss
			final String nearWanted = wantedString.substring(0, i) + wantedString.charAt(i + 1)
					+ wantedString.charAt(i) + wantedString.substring(i + 2);
			if (nearWanted.equals(gotString)) {
				addReplacementProposal(context, message, Type.CHANGE, IQuickfixProposal.LIKELY_PROPOSAL,
						"Transposed letters", wantedString);
			}
		}
	}
}
