/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorContext;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Quickfix Proposal Processor Context</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorContextImpl#getMessage
 * <em>Message</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorContextImpl#getBinding
 * <em>Binding</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorContextImpl#getText <em>
 * Text</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class QuickfixProposalProcessorContextImpl extends EObjectImpl implements
		IQuickfixProposalProcessorContext {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QuickfixProposalProcessorContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IBindingMessage getMessage();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract IValueBinding getBinding();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public abstract String getText();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__MESSAGE:
			return getMessage();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__BINDING:
			return getBinding();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__TEXT:
			return getText();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__MESSAGE:
			return getMessage() != null;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__BINDING:
			return getBinding() != null;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_CONTEXT__TEXT:
			return TEXT_EDEFAULT == null ? getText() != null : !TEXT_EDEFAULT.equals(getText());
		}
		return super.eIsSet(featureID);
	}

} // QuickfixProposalProcessorContextImpl
