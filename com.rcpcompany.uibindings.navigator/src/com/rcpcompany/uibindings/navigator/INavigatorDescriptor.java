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
package com.rcpcompany.uibindings.navigator;

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.navigator.views.INavigatorBaseViewAdvisor;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Navigator Descriptor</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.navigator.INavigatorDescriptor#getId <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.navigator.INavigatorDescriptor#getAdvisor <em>Advisor</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getNavigatorDescriptor()
 * @generated
 */
public interface INavigatorDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getNavigatorDescriptor_Id()
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.INavigatorDescriptor#getId
	 * <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Advisor</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advisor</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Advisor</em>' attribute.
	 * @see #setAdvisor(CEObjectHolder)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getNavigatorDescriptor_Advisor()
	 * @generated
	 */
	CEObjectHolder<INavigatorBaseViewAdvisor> getAdvisor();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.navigator.INavigatorDescriptor#getAdvisor <em>Advisor</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Advisor</em>' attribute.
	 * @see #getAdvisor()
	 * @generated
	 */
	void setAdvisor(CEObjectHolder<INavigatorBaseViewAdvisor> value);

} // INavigatorDescriptor
