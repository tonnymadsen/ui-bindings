/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop;

import org.eclipse.emf.common.util.EList;

import com.rcpcompany.uibindings.moao.INamedObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Customer Group</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.CustomerGroup#getCustomers <em>Customers</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCustomerGroup()
 * @generated
 */
public interface CustomerGroup extends INamedObject {
	/**
	 * Returns the value of the '<em><b>Customers</b></em>' reference list. The list contents are of
	 * type {@link com.rcpcompany.uibindings.tests.shop.Customer}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customers</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Customers</em>' reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCustomerGroup_Customers()
	 * @generated
	 */
	EList<Customer> getCustomers();

} // CustomerGroup
