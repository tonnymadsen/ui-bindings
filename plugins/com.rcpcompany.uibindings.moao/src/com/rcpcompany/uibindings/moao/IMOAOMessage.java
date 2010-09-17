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
package com.rcpcompany.uibindings.moao;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Message</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getOwner <em>Owner</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getObject <em>Object</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getFeature <em>Feature</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getDescription <em>Description</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getSeverity <em>Severity</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getDetails <em>Details</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage()
 * @generated
 */
public interface IMOAOMessage extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Owner()
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getOwner
	 * <em>Owner</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);

	/**
	 * Returns the value of the '<em><b>Object</b></em>' container reference. It is bidirectional
	 * and its opposite is '{@link com.rcpcompany.uibindings.moao.IMOAO#getMessages
	 * <em>Messages</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Object</em>' container reference.
	 * @see #setObject(IMOAO)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Object()
	 * @see com.rcpcompany.uibindings.moao.IMOAO#getMessages
	 * @generated
	 */
	IMOAO getObject();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getObject
	 * <em>Object</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Object</em>' container reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(IMOAO value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EStructuralFeature)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Feature()
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getFeature
	 * <em>Feature</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Description()
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getDescription
	 * <em>Description</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute. The literals are from the
	 * enumeration {@link com.rcpcompany.uibindings.moao.Severity}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see com.rcpcompany.uibindings.moao.Severity
	 * @see #setSeverity(Severity)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Severity()
	 * @generated
	 */
	Severity getSeverity();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getSeverity
	 * <em>Severity</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see com.rcpcompany.uibindings.moao.Severity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(Severity value);

	/**
	 * Returns the value of the '<em><b>Details</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Details</em>' attribute.
	 * @see #setDetails(String)
	 * @see com.rcpcompany.uibindings.moao.IMOAOPackage#getMOAOMessage_Details()
	 * @generated
	 */
	String getDetails();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.moao.IMOAOMessage#getDetails
	 * <em>Details</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Details</em>' attribute.
	 * @see #getDetails()
	 * @generated
	 */
	void setDetails(String value);

} // IMOAOMessage
