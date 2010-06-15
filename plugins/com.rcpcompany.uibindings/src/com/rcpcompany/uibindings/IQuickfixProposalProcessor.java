package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A quick fix proposal processor is used to create quick fixes in a
 * specific context. <!-- end-user-doc -->
 * 
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessor()
 * @generated
 */
public interface IQuickfixProposalProcessor extends EObject {
	/**
	 * Returns a list of proposals for the specified decorator message
	 * <p>
	 * Any returned list is owned by the caller and may be modified.
	 * 
	 * @param context the context of the processor
	 * @param message the message to return proposals for
	 */
	public void getProposals(IQuickfixProposalProcessorContext context, IBindingMessage message);
} // IQuickfixProposalProcessor
