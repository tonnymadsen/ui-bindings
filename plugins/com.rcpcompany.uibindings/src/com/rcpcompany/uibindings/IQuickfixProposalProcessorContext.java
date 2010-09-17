/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The context used for a quick fix proposal processor. <!-- end-user-doc
 * -->
 * 
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorContext()
 * @generated
 */
public interface IQuickfixProposalProcessorContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorContext_Message()
	 * @generated
	 */
	IBindingMessage getMessage();

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * The binding for which to find quickfixes.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Binding</em>' reference.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorContext_Binding()
	 * @generated
	 */
	IValueBinding getBinding();

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The current text of the control in question if applicable. E.g. for a slider, this will be
	 * <code>null</code>.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorContext_Text()
	 * @generated
	 */
	String getText();

	/**
	 * Adds a new proposal to the list of proposals of this context.
	 * 
	 * @param proposal the new proposal
	 */
	void addProposal(IQuickfixProposal proposal);
} // IQuickfixProposalProcessorContext
