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
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Argument Information</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IArgumentInformation#getName <em>Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IArgumentInformation#isLookupParent <em>Lookup Parent</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IArgumentInformation#isLookupAttributeTargetType <em>Lookup
 * Attribute Target Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IArgumentInformation#isLookupAttributeContainingClass <em>
 * Lookup Attribute Containing Class</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IArgumentInformation#isLookupReferenceTargetType <em>Lookup
 * Reference Target Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IArgumentInformation#isLookupReferenceContainingClass <em>
 * Lookup Reference Containing Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getArgumentInformation()
 * @generated
 */
public interface IArgumentInformation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getArgumentInformation_Name()
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IArgumentInformation#getName
	 * <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Lookup Parent</b></em>' attribute. The default value is
	 * <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lookup Parent</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Lookup Parent</em>' attribute.
	 * @see #setLookupParent(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getArgumentInformation_LookupParent()
	 * @generated
	 */
	boolean isLookupParent();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IArgumentInformation#isLookupParent
	 * <em>Lookup Parent</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Lookup Parent</em>' attribute.
	 * @see #isLookupParent()
	 * @generated
	 */
	void setLookupParent(boolean value);

	/**
	 * Returns the value of the '<em><b>Lookup Attribute Target Type</b></em>' attribute. The
	 * default value is <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lookup Attribute Target Type</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Lookup Attribute Target Type</em>' attribute.
	 * @see #setLookupAttributeTargetType(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getArgumentInformation_LookupAttributeTargetType()
	 * @generated
	 */
	boolean isLookupAttributeTargetType();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IArgumentInformation#isLookupAttributeTargetType
	 * <em>Lookup Attribute Target Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Lookup Attribute Target Type</em>' attribute.
	 * @see #isLookupAttributeTargetType()
	 * @generated
	 */
	void setLookupAttributeTargetType(boolean value);

	/**
	 * Returns the value of the '<em><b>Lookup Attribute Containing Class</b></em>' attribute. The
	 * default value is <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lookup Attribute Containing Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Lookup Attribute Containing Class</em>' attribute.
	 * @see #setLookupAttributeContainingClass(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getArgumentInformation_LookupAttributeContainingClass()
	 * @generated
	 */
	boolean isLookupAttributeContainingClass();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IArgumentInformation#isLookupAttributeContainingClass
	 * <em>Lookup Attribute Containing Class</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Lookup Attribute Containing Class</em>' attribute.
	 * @see #isLookupAttributeContainingClass()
	 * @generated
	 */
	void setLookupAttributeContainingClass(boolean value);

	/**
	 * Returns the value of the '<em><b>Lookup Reference Target Type</b></em>' attribute. The
	 * default value is <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lookup Reference Target Type</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Lookup Reference Target Type</em>' attribute.
	 * @see #setLookupReferenceTargetType(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getArgumentInformation_LookupReferenceTargetType()
	 * @generated
	 */
	boolean isLookupReferenceTargetType();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IArgumentInformation#isLookupReferenceTargetType
	 * <em>Lookup Reference Target Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value the new value of the '<em>Lookup Reference Target Type</em>' attribute.
	 * @see #isLookupReferenceTargetType()
	 * @generated
	 */
	void setLookupReferenceTargetType(boolean value);

	/**
	 * Returns the value of the '<em><b>Lookup Reference Containing Class</b></em>' attribute. The
	 * default value is <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lookup Reference Containing Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Lookup Reference Containing Class</em>' attribute.
	 * @see #setLookupReferenceContainingClass(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getArgumentInformation_LookupReferenceContainingClass()
	 * @generated
	 */
	boolean isLookupReferenceContainingClass();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IArgumentInformation#isLookupReferenceContainingClass
	 * <em>Lookup Reference Containing Class</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Lookup Reference Containing Class</em>' attribute.
	 * @see #isLookupReferenceContainingClass()
	 * @generated
	 */
	void setLookupReferenceContainingClass(boolean value);

} // IArgumentInformation
