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
package com.rcpcompany.uibindings;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Quickfix Proposal Processor Descriptor</b></em> '. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getModelType <em>Model
 * Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getFeature <em>Feature
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getSource <em>Source
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getCode <em>Code</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getMessagePattern <em>
 * Message Pattern</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getProcessor <em>
 * Processor</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorDescriptor()
 * @generated
 */
public interface IQuickfixProposalProcessorDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Type</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Type</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Type</em>' attribute.
	 * @see #setModelType(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorDescriptor_ModelType()
	 * @generated
	 */
	String getModelType();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getModelType
	 * <em>Model Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Type</em>' attribute.
	 * @see #getModelType()
	 * @generated
	 */
	void setModelType(String value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature</em>' attribute.
	 * @see #setFeature(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorDescriptor_Feature()
	 * @generated
	 */
	String getFeature();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getFeature
	 * <em>Feature</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Feature</em>' attribute.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorDescriptor_Source()
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getSource
	 * <em>Source</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(int)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorDescriptor_Code()
	 * @generated
	 */
	int getCode();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getCode <em>Code</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(int value);

	/**
	 * Returns the value of the '<em><b>Message Pattern</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Pattern</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message Pattern</em>' attribute.
	 * @see #setMessagePattern(Pattern)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorDescriptor_MessagePattern()
	 * @generated
	 */
	Pattern getMessagePattern();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getMessagePattern
	 * <em>Message Pattern</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Message Pattern</em>' attribute.
	 * @see #getMessagePattern()
	 * @generated
	 */
	void setMessagePattern(Pattern value);

	/**
	 * Returns the value of the '<em><b>Processor</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Processor</em>' attribute.
	 * @see #setProcessor(CEObjectHolder)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getQuickfixProposalProcessorDescriptor_Processor()
	 * @generated
	 */
	CEObjectHolder<IQuickfixProposalProcessor> getProcessor();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor#getProcessor
	 * <em>Processor</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Processor</em>' attribute.
	 * @see #getProcessor()
	 * @generated
	 */
	void setProcessor(CEObjectHolder<IQuickfixProposalProcessor> value);

} // IQuickfixProposalProcessorDescriptor
