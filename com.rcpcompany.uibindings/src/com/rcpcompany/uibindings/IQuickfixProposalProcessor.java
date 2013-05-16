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
	 * 
	 * @deprecated Use {@link #getProposals(IQuickfixProposalProcessorContext)}
	 */
	@Deprecated
	void getProposals(IQuickfixProposalProcessorContext context, IBindingMessage message);

	/**
	 * Returns a list of proposals for the specified decorator message
	 * <p>
	 * Any returned list is owned by the caller and may be modified.
	 * 
	 * @param context the context of the processor
	 */
	void getProposals(IQuickfixProposalProcessorContext context);
} // IQuickfixProposalProcessor
