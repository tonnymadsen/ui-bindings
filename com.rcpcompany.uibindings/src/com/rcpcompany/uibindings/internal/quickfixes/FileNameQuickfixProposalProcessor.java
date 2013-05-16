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
package com.rcpcompany.uibindings.internal.quickfixes;

import java.io.File;

import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IQuickfixProposalProcessor;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorContext;
import com.rcpcompany.uibindings.internal.decorators.FileNameControlDecorator;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposal.Type;
import com.rcpcompany.uibindings.quixkfixes.AbstractQuickfixProposalProcessor;

/**
 * {@link IQuickfixProposalProcessor} for "File does not exist" of {@link FileNameControlDecorator}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FileNameQuickfixProposalProcessor extends AbstractQuickfixProposalProcessor implements
		IQuickfixProposalProcessor {

	@Override
	public void getProposals(IQuickfixProposalProcessorContext context) {
		final String text = context.getText();
		if (text == null) return;

		// Remove Extra letter, but match an exiting file
		for (int i = 0; i < text.length(); i++) {
			// Construct the near miss
			final String nearWanted = text.substring(0, i) + text.substring(i + 1);
			if (new File(nearWanted).exists()) {
				addReplacementProposal(context, Type.CHANGE, IQuickfixProposal.LIKELY_PROPOSAL, "Remove extra letter",
						nearWanted);
			}
		}

		// TODO: walk through path to see if a near miss exists...
	}
}
