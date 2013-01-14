/**
 */
package com.rcpcompany.uibindings.tests.shop;

import org.eclipse.emf.common.util.EList;

import com.rcpcompany.uibindings.moao.INamedObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Item Group</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItemGroup()
 * @generated
 */
public interface ShopItemGroup extends INamedObject {
	/**
	 * Returns the value of the '<em><b>Shop</b></em>' container reference. It is bidirectional and
	 * its opposite is '{@link com.rcpcompany.uibindings.tests.shop.Shop#getShopGroups
	 * <em>Shop Groups</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shop</em>' container reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Shop</em>' container reference.
	 * @see #setShop(Shop)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItemGroup_Shop()
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getShopGroups
	 * @generated
	 */
	Shop getShop();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getShop
	 * <em>Shop</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Shop</em>' container reference.
	 * @see #getShop()
	 * @generated
	 */
	void setShop(Shop value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' reference list. The list contents are of
	 * type {@link com.rcpcompany.uibindings.tests.shop.ShopItem}. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Items</em>' reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItemGroup_Items()
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getGroup
	 * @generated
	 */
	EList<ShopItem> getItems();

} // ShopItemGroup
