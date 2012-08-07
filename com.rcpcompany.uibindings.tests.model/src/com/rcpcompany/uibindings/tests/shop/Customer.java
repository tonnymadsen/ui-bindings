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

import org.eclipse.emf.common.util.EList;

import com.rcpcompany.uibindings.moao.IMOAO;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Customer</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Customer#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Customer#getContact <em>Contact</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Customer#getOrders <em>Orders</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Customer#getLoyalty <em>Loyalty</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Customer#getLogoFileName <em>Logo File Name</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCustomer()
 * @generated
 */
public interface Customer extends IMOAO {
	/**
	 * Returns the value of the '<em><b>Shop</b></em>' container reference. It is bidirectional and
	 * its opposite is '{@link com.rcpcompany.uibindings.tests.shop.Shop#getCustomers
	 * <em>Customers</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shop</em>' container reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Shop</em>' container reference.
	 * @see #setShop(Shop)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCustomer_Shop()
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getCustomers
	 * @generated
	 */
	Shop getShop();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Customer#getShop
	 * <em>Shop</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Shop</em>' container reference.
	 * @see #getShop()
	 * @generated
	 */
	void setShop(Shop value);

	/**
	 * Returns the value of the '<em><b>Contact</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.tests.shop.Contact#getCustomer
	 * <em>Customer</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contact</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contact</em>' reference.
	 * @see #setContact(Contact)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCustomer_Contact()
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#getCustomer
	 * @generated
	 */
	Contact getContact();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Customer#getContact
	 * <em>Contact</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Contact</em>' reference.
	 * @see #getContact()
	 * @generated
	 */
	void setContact(Contact value);

	/**
	 * Returns the value of the '<em><b>Orders</b></em>' reference list. The list contents are of
	 * type {@link com.rcpcompany.uibindings.tests.shop.Order}. It is bidirectional and its opposite
	 * is ' {@link com.rcpcompany.uibindings.tests.shop.Order#getCustomer <em>Customer</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orders</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Orders</em>' reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCustomer_Orders()
	 * @see com.rcpcompany.uibindings.tests.shop.Order#getCustomer
	 * @model opposite="customer" resolveProxies="false"
	 * @generated
	 */
	EList<Order> getOrders();

	/**
	 * Returns the value of the '<em><b>Loyalty</b></em>' attribute. The default value is
	 * <code>"BRONCE"</code>. The literals are from the enumeration
	 * {@link com.rcpcompany.uibindings.tests.shop.CustomerType}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loyalty</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Loyalty</em>' attribute.
	 * @see com.rcpcompany.uibindings.tests.shop.CustomerType
	 * @see #setLoyalty(CustomerType)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCustomer_Loyalty()
	 * @generated
	 */
	CustomerType getLoyalty();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Customer#getLoyalty
	 * <em>Loyalty</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Loyalty</em>' attribute.
	 * @see com.rcpcompany.uibindings.tests.shop.CustomerType
	 * @see #getLoyalty()
	 * @generated
	 */
	void setLoyalty(CustomerType value);

	/**
	 * Returns the value of the '<em><b>Logo File Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logo File Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Logo File Name</em>' attribute.
	 * @see #setLogoFileName(String)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCustomer_LogoFileName()
	 * @generated
	 */
	String getLogoFileName();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Customer#getLogoFileName
	 * <em>Logo File Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Logo File Name</em>' attribute.
	 * @see #getLogoFileName()
	 * @generated
	 */
	void setLogoFileName(String value);

} // Customer
