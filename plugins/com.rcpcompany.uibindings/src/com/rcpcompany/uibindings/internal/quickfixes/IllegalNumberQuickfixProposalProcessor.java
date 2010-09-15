package com.rcpcompany.uibindings.internal.quickfixes;

import com.rcpcompany.uibindings.IQuickfixProposalProcessor;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorContext;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposalProcessor;

/**
 * Quick fix proposal processor for number based problems...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class IllegalNumberQuickfixProposalProcessor extends AbstractQuickfixProposalProcessor implements
		IQuickfixProposalProcessor {

	@Override
	public void getProposals(IQuickfixProposalProcessorContext context) {
		final String text = context.getText();
		if (text == null) return;
		addReplacementProposal(context, "Remove illegal characters", findReplacementText(text));
	}

	private String findReplacementText(String text) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			final char ch = text.charAt(i);
			if (Character.isDigit(ch)) {
				sb.append(ch);
			}
		}

		return sb.toString();
	}
}
