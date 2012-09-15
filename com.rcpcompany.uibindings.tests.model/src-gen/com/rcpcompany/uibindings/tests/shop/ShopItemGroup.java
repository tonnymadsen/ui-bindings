/**
 */
package com.rcpcompany.uibindings.tests.shop;

import com.rcpcompany.uibindings.moao.INamedObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getShop <em>Shop</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItemGroup()
 * @generated
 */
public interface ShopItemGroup extends INamedObject {
	/**
	 * Returns the value of the '<em><b>Shop</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.tests.shop.Shop#getShopGroups <em>Shop Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shop</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shop</em>' container reference.
	 * @see #setShop(Shop)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItemGroup_Shop()
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getShopGroups
	 * @generated
	 */
	Shop getShop();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getShop <em>Shop</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shop</em>' container reference.
	 * @see #getShop()
	 * @generated
	 */
	void setShop(Shop value);

	/**
	 * Returns the value of the '<em><b>Item</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' reference.
	 * @see #setItem(ShopItem)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItemGroup_Item()
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getGroup
	 * @generated
	 */
	ShopItem getItem();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getItem <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(ShopItem value);

} // ShopItemGroup
