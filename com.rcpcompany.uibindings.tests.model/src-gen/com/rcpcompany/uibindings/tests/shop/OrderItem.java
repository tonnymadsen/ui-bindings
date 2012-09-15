/**
 */
package com.rcpcompany.uibindings.tests.shop;

import com.rcpcompany.uibindings.moao.IMOAO;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Order Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.OrderItem#getOrder <em>Order</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.OrderItem#getNo <em>No</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.OrderItem#getItem <em>Item</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.OrderItem#getCount <em>Count</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.OrderItem#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrderItem()
 * @generated
 */
public interface OrderItem extends IMOAO {

	/**
	 * Returns the value of the '<em><b>Order</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.tests.shop.Order#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' container reference.
	 * @see #setOrder(Order)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrderItem_Order()
	 * @see com.rcpcompany.uibindings.tests.shop.Order#getItems
	 * @generated
	 */
	Order getOrder();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.OrderItem#getOrder <em>Order</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' container reference.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(Order value);

	/**
	 * Returns the value of the '<em><b>No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No</em>' attribute.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrderItem_No()
	 * @generated
	 */
	int getNo();

	/**
	 * Returns the value of the '<em><b>Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' reference.
	 * @see #setItem(ShopItem)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrderItem_Item()
	 * @generated
	 */
	ShopItem getItem();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.OrderItem#getItem <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(ShopItem value);

	/**
	 * Returns the value of the '<em><b>Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' attribute.
	 * @see #setCount(int)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrderItem_Count()
	 * @generated
	 */
	int getCount();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.OrderItem#getCount <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' attribute.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(int value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrderItem_Id()
	 * @generated
	 */
	String getId();
} // OrderItem
