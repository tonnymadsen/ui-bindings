/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop;

import com.rcpcompany.uibindings.moao.INamedObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Item Properties</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItemProperties#getValue <em>Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.ShopItemProperties#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItemProperties()
 * @generated
 */
public interface ShopItemProperties extends INamedObject {
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
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItemProperties_Value()
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemProperties#getValue <em>Value</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Item</b></em>' container reference. It is bidirectional and
	 * its opposite is '{@link com.rcpcompany.uibindings.tests.shop.ShopItem#getProperties
	 * <em>Properties</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Item</em>' container reference.
	 * @see #setItem(ShopItem)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getShopItemProperties_Item()
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getProperties
	 * @generated
	 */
	ShopItem getItem();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemProperties#getItem <em>Item</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Item</em>' container reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(ShopItem value);

} // ShopItemProperties
