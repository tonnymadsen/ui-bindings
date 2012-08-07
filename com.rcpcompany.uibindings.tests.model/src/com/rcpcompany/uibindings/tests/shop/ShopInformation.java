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
package com.rcpcompany.uibindings.tests.shop;

import com.rcpcompany.uibindings.moao.INamedObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Information</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopInformation#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopInformation()
 * @generated
 */
public interface ShopInformation extends INamedObject {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopInformation_Value()
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopInformation#getValue
	 * <em>Value</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);
} // ShopInformation
