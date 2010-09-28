/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import com.rcpcompany.uibindings.moao.INamedObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Shop</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Shop#getNextOrderNo <em>Next Order No</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Shop#getNextCustomerNo <em>Next Customer No</em>}
 * </li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Shop#getTmpDir <em>Tmp Dir</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Shop#getCountries <em>Countries</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Shop#getContacts <em>Contacts</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Shop#getShopItems <em>Shop Items</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Shop#getOrders <em>Orders</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Shop#getCustomers <em>Customers</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Shop#getShopGroups <em>Shop Groups</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Shop#getInfos <em>Infos</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop()
 * @generated
 */
public interface Shop extends INamedObject {
	/**
	 * Returns the value of the '<em><b>Next Order No</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Order No</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Next Order No</em>' attribute.
	 * @see #setNextOrderNo(int)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop_NextOrderNo()
	 * @generated
	 */
	int getNextOrderNo();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Shop#getNextOrderNo
	 * <em>Next Order No</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Next Order No</em>' attribute.
	 * @see #getNextOrderNo()
	 * @generated
	 */
	void setNextOrderNo(int value);

	/**
	 * Returns the value of the '<em><b>Next Customer No</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Next Customer No</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Next Customer No</em>' attribute.
	 * @see #setNextCustomerNo(int)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop_NextCustomerNo()
	 * @generated
	 */
	int getNextCustomerNo();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Shop#getNextCustomerNo
	 * <em>Next Customer No</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Next Customer No</em>' attribute.
	 * @see #getNextCustomerNo()
	 * @generated
	 */
	void setNextCustomerNo(int value);

	/**
	 * Returns the value of the '<em><b>Tmp Dir</b></em>' attribute. The default value is
	 * <code>"C:\\Windows\\Temp"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tmp Dir</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tmp Dir</em>' attribute.
	 * @see #setTmpDir(String)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop_TmpDir()
	 * @generated
	 */
	String getTmpDir();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Shop#getTmpDir
	 * <em>Tmp Dir</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Tmp Dir</em>' attribute.
	 * @see #getTmpDir()
	 * @generated
	 */
	void setTmpDir(String value);

	/**
	 * Returns the value of the '<em><b>Countries</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.tests.shop.Country}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.Country#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Countries</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Countries</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop_Countries()
	 * @see com.rcpcompany.uibindings.tests.shop.Country#getShop
	 * @model opposite="shop" containment="true"
	 * @generated
	 */
	EList<Country> getCountries();

	/**
	 * Returns the value of the '<em><b>Contacts</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.tests.shop.Contact}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.Contact#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contacts</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Contacts</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop_Contacts()
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#getShop
	 * @model opposite="shop" containment="true"
	 * @generated
	 */
	EList<Contact> getContacts();

	/**
	 * Returns the value of the '<em><b>Shop Items</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.tests.shop.ShopItem}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItem#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shop Items</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Shop Items</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop_ShopItems()
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getShop
	 * @model opposite="shop" containment="true"
	 * @generated
	 */
	EList<ShopItem> getShopItems();

	/**
	 * Returns the value of the '<em><b>Orders</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.tests.shop.Order}. It is bidirectional
	 * and its opposite is '{@link com.rcpcompany.uibindings.tests.shop.Order#getShop <em>Shop</em>}
	 * '. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orders</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Orders</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop_Orders()
	 * @see com.rcpcompany.uibindings.tests.shop.Order#getShop
	 * @generated
	 */
	EList<Order> getOrders();

	/**
	 * Returns the value of the '<em><b>Customers</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.tests.shop.Customer}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.Customer#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customers</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Customers</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop_Customers()
	 * @see com.rcpcompany.uibindings.tests.shop.Customer#getShop
	 * @model opposite="shop" containment="true"
	 * @generated
	 */
	EList<Customer> getCustomers();

	/**
	 * Returns the value of the '<em><b>Shop Groups</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shop Groups</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Shop Groups</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop_ShopGroups()
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getShop
	 * @model opposite="shop" containment="true"
	 * @generated
	 */
	EList<ShopItemGroup> getShopGroups();

	/**
	 * Returns the value of the '<em><b>Infos</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.tests.shop.ShopItemInformation}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infos</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Infos</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShop_Infos()
	 * @generated
	 */
	EList<ShopInformation> getInfos();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	void save();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	boolean nameLengthOK(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Shop
