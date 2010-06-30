package com.rcpcompany.uibindings.internal.decorators;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

/**
 * {@link IContentProposalProvider} for file and directory names.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FileNameContentProposalProvider implements IContentProposalProvider {

	/**
	 * Constructs and returns a new proposal provider.
	 * 
	 * @param directoryMode whether directory or file names are completed
	 * @param filterExtensions filters for file names
	 */
	public FileNameContentProposalProvider(boolean directoryMode, String[] filterExtensions) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IContentProposal[] getProposals(String contents, int position) {
		// TODO Auto-generated method stub
		return null;
	}

}
