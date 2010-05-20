package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The context used for a quick fix proposal processor. <!-- end-user-doc -->
 * 
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorContext()
 * @generated
 */
public interface IQuickfixProposalProcessorContext extends EObject {
	/**
	 * Adds a new proposal to the list of proposals of this context.
	 * 
	 * @param proposal the new proposal
	 */
	public void addProposal(IQuickfixProposal proposal);
} // IQuickfixProposalProcessorContext
