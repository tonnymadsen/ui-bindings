/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop;

import org.eclipse.emf.common.util.EList;

import com.rcpcompany.uibindings.moao.IMOAO;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Order</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Order#getNo <em>No</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Order#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Order#getCustomer <em>Customer</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Order#getPrice <em>Price</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Order#getItems <em>Items</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Order#getDiscount <em>Discount</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrder()
 * @generated
 */
public interface Order extends IMOAO {
	/**
	 * Returns the value of the '<em><b>No</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>No</em>' attribute.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrder_No()
	 * @generated
	 */
	int getNo();

	/**
	 * Returns the value of the '<em><b>Shop</b></em>' container reference. It is bidirectional and
	 * its opposite is '{@link com.rcpcompany.uibindings.tests.shop.Shop#getOrders <em>Orders</em>}
	 * '. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shop</em>' container reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Shop</em>' container reference.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrder_Shop()
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getOrders
	 * @generated
	 */
	Shop getShop();

	/**
	 * Returns the value of the '<em><b>Customer</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.tests.shop.Customer#getOrders <em>Orders</em>}
	 * '. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customer</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Customer</em>' reference.
	 * @see #setCustomer(Customer)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrder_Customer()
	 * @see com.rcpcompany.uibindings.tests.shop.Customer#getOrders
	 * @generated
	 */
	Customer getCustomer();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Order#getCustomer
	 * <em>Customer</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Customer</em>' reference.
	 * @see #getCustomer()
	 * @generated
	 */
	void setCustomer(Customer value);

	/**
	 * Returns the value of the '<em><b>Price</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Price</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Price</em>' attribute.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrder_Price()
	 * @generated
	 */
	float getPrice();

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.tests.shop.OrderItem}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.OrderItem#getOrder <em>Order</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrder_Items()
	 * @see com.rcpcompany.uibindings.tests.shop.OrderItem#getOrder
	 * @model opposite="order" containment="true" upper="2"
	 * @generated
	 */
	EList<OrderItem> getItems();

	/**
	 * Returns the value of the '<em><b>Discount</b></em>' attribute. The default value is
	 * <code>"0.0"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discount</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Discount</em>' attribute.
	 * @see #isSetDiscount()
	 * @see #unsetDiscount()
	 * @see #setDiscount(float)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getOrder_Discount()
	 * @generated
	 */
	float getDiscount();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Order#getDiscount
	 * <em>Discount</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Discount</em>' attribute.
	 * @see #isSetDiscount()
	 * @see #unsetDiscount()
	 * @see #getDiscount()
	 * @generated
	 */
	void setDiscount(float value);

	/**
	 * Unsets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Order#getDiscount
	 * <em>Discount</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSetDiscount()
	 * @see #getDiscount()
	 * @see #setDiscount(float)
	 * @generated
	 */
	void unsetDiscount();

	/**
	 * Returns whether the value of the '
	 * {@link com.rcpcompany.uibindings.tests.shop.Order#getDiscount <em>Discount</em>}' attribute
	 * is set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return whether the value of the '<em>Discount</em>' attribute is set.
	 * @see #unsetDiscount()
	 * @see #getDiscount()
	 * @see #setDiscount(float)
	 * @generated
	 */
	boolean isSetDiscount();

} // Order
