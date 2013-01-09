/**
 */
package com.rcpcompany.uibindings.tests.shop;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import com.rcpcompany.uibindings.moao.INamedObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Item</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getShop <em>Shop</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getPrice <em>Price</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getAdvancedPrice <em>Advanced Price</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getOrderItems <em>Order Items</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#isForSale <em>For Sale</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getInformation <em>Information</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getGroup <em>Group</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getLocations <em>Locations</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem()
 * @generated
 */
public interface ShopItem extends INamedObject {

	/**
	 * Returns the value of the '<em><b>Shop</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.tests.shop.Shop#getShopItems <em>Shop Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shop</em>' container reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shop</em>' container reference.
	 * @see #setShop(Shop)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Shop()
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getShopItems
	 * @generated
	 */
	Shop getShop();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getShop <em>Shop</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shop</em>' container reference.
	 * @see #getShop()
	 * @generated
	 */
	void setShop(Shop value);

	/**
	 * Returns the value of the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Price</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Price</em>' attribute.
	 * @see #setPrice(float)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Price()
	 * @generated
	 */
	float getPrice();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getPrice <em>Price</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Price</em>' attribute.
	 * @see #getPrice()
	 * @generated
	 */
	void setPrice(float value);

	/**
	 * Returns the value of the '<em><b>Advanced Price</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advanced Price</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advanced Price</em>' attribute.
	 * @see #setAdvancedPrice(String)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_AdvancedPrice()
	 * @generated
	 */
	String getAdvancedPrice();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getAdvancedPrice <em>Advanced Price</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Advanced Price</em>' attribute.
	 * @see #getAdvancedPrice()
	 * @generated
	 */
	void setAdvancedPrice(String value);

	/**
	 * Returns the value of the '<em><b>Order Items</b></em>' reference list.
	 * The list contents are of type {@link com.rcpcompany.uibindings.tests.shop.OrderItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order Items</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order Items</em>' reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_OrderItems()
	 * @generated
	 */
	EList<OrderItem> getOrderItems();

	/**
	 * Returns the value of the '<em><b>For Sale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For Sale</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Sale</em>' attribute.
	 * @see #setForSale(boolean)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_ForSale()
	 * @generated
	 */
	boolean isForSale();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#isForSale <em>For Sale</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Sale</em>' attribute.
	 * @see #isForSale()
	 * @generated
	 */
	void setForSale(boolean value);

	/**
	 * Returns the value of the '<em><b>Information</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Information</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Information</em>' reference.
	 * @see #setInformation(ShopItemInformation)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Information()
	 * @generated
	 */
	ShopItemInformation getInformation();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getInformation <em>Information</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Information</em>' reference.
	 * @see #getInformation()
	 * @generated
	 */
	void setInformation(ShopItemInformation value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' reference.
	 * @see #setGroup(ShopItemGroup)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Group()
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getItems
	 * @generated
	 */
	ShopItemGroup getGroup();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getGroup <em>Group</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(ShopItemGroup value);

	/**
	 * Returns the value of the '<em><b>Locations</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locations</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locations</em>' attribute list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Locations()
	 * @generated
	 */
	EList<String> getLocations();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.tests.shop.ShopItemProperties}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemProperties#getItem <em>Item</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItem_Properties()
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemProperties#getItem
	 * @generated
	 */
	EList<ShopItemProperties> getProperties();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	boolean namePriceOK(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	boolean nameOK(DiagnosticChain diagnostics, Map<Object, Object> context);
} // ShopItem
