/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Item</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getName <em>Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getPrice <em>Price</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getOrderItems <em>Order Items</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#isForSale <em>For Sale</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getInformation <em>Information</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem()
 * @model
 * @generated
 */
public interface ShopItem extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Price</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Price</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Price</em>' attribute.
	 * @see #setPrice(float)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Price()
	 * @model required="true"
	 * @generated
	 */
	float getPrice();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getPrice <em>Price</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Price</em>' attribute.
	 * @see #getPrice()
	 * @generated
	 */
	void setPrice(float value);

	/**
	 * Returns the value of the '<em><b>Shop</b></em>' container reference. It is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getShopItems <em>Shop Items</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shop</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Shop</em>' container reference.
	 * @see #setShop(Shop)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Shop()
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getShopItems
	 * @model opposite="shopItems" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	Shop getShop();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getShop <em>Shop</em>}' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Shop</em>' container reference.
	 * @see #getShop()
	 * @generated
	 */
	void setShop(Shop value);

	/**
	 * Returns the value of the '<em><b>Order Items</b></em>' reference list. The list contents are of type
	 * {@link com.rcpcompany.uibindings.tests.shop.OrderItem}. It is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.OrderItem#getItem <em>Item</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order Items</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Order Items</em>' reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_OrderItems()
	 * @see com.rcpcompany.uibindings.tests.shop.OrderItem#getItem
	 * @model opposite="item" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<OrderItem> getOrderItems();

	/**
	 * Returns the value of the '<em><b>For Sale</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Sale</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>For Sale</em>' attribute.
	 * @see #setForSale(boolean)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_ForSale()
	 * @model required="true"
	 * @generated
	 */
	boolean isForSale();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#isForSale <em>For Sale</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>For Sale</em>' attribute.
	 * @see #isForSale()
	 * @generated
	 */
	void setForSale(boolean value);

	/**
	 * Returns the value of the '<em><b>Information</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Information</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Information</em>' containment reference.
	 * @see #setInformation(ShopItemInformation)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Information()
	 * @model containment="true"
	 * @generated
	 */
	ShopItemInformation getInformation();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getInformation <em>Information</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Information</em>' containment reference.
	 * @see #getInformation()
	 * @generated
	 */
	void setInformation(ShopItemInformation value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getItems <em>Items</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Group</em>' reference.
	 * @see #setGroup(ShopItemGroup)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Group()
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getItems
	 * @model opposite="items"
	 * @generated
	 */
	ShopItemGroup getGroup();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getGroup <em>Group</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Group</em>' reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(ShopItemGroup value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model diagnosticsDataType="com.rcpcompany.uibindings.tests.shop.DiagnosticChain" diagnosticsRequired="true"
	 * @generated
	 */
	boolean namePriceOK(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model diagnosticsDataType="com.rcpcompany.uibindings.tests.shop.DiagnosticChain" diagnosticsRequired="true"
	 * @generated
	 */
	boolean nameOK(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ShopItem
