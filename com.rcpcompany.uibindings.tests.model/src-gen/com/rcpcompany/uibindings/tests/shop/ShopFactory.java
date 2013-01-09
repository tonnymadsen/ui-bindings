/**
 */
package com.rcpcompany.uibindings.tests.shop;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage
 * @generated
 */
public interface ShopFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ShopFactory eINSTANCE = com.rcpcompany.uibindings.tests.shop.internal.ShopFactoryImpl.init();

	Shop getShop(EditingDomain editingDomain);

	/**
	 * Returns a new object of class '<em>Shop</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Shop</em>'.
	 * @generated
	 */
	Shop createShop();

	/**
	 * Returns a new object of class '<em>Customer</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Customer</em>'.
	 * @generated
	 */
	Customer createCustomer();

	/**
	 * Returns a new object of class '<em>Customer Group</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Customer Group</em>'.
	 * @generated
	 */
	CustomerGroup createCustomerGroup();

	/**
	 * Returns a new object of class '<em>Item</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Item</em>'.
	 * @generated
	 */
	ShopItem createShopItem();

	/**
	 * Returns a new object of class '<em>Item Properties</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Item Properties</em>'.
	 * @generated
	 */
	ShopItemProperties createShopItemProperties();

	/**
	 * Returns a new object of class '<em>Item Group</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Item Group</em>'.
	 * @generated
	 */
	ShopItemGroup createShopItemGroup();

	/**
	 * Returns a new object of class '<em>Order</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Order</em>'.
	 * @generated
	 */
	Order createOrder();

	/**
	 * Returns a new object of class '<em>Order Item</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Order Item</em>'.
	 * @generated
	 */
	OrderItem createOrderItem();

	/**
	 * Returns a new object of class '<em>Contact</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Contact</em>'.
	 * @generated
	 */
	Contact createContact();

	/**
	 * Returns a new object of class '<em>Country</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Country</em>'.
	 * @generated
	 */
	Country createCountry();

	/**
	 * Returns a new object of class '<em>Country Info</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Country Info</em>'.
	 * @generated
	 */
	CountryInfo createCountryInfo();

	/**
	 * Returns a new object of class '<em>Item Information</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Item Information</em>'.
	 * @generated
	 */
	ShopItemInformation createShopItemInformation();

	/**
	 * Returns a new object of class '<em>Item Description</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Item Description</em>'.
	 * @generated
	 */
	ShopItemDescription createShopItemDescription();

	/**
	 * Returns a new object of class '<em>Item URL</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Item URL</em>'.
	 * @generated
	 */
	ShopItemURL createShopItemURL();

	/**
	 * Returns a new object of class '<em>URL</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>URL</em>'.
	 * @generated
	 */
	ShopURL createShopURL();

	/**
	 * Returns a new object of class '<em>Address</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Address</em>'.
	 * @generated
	 */
	ShopAddress createShopAddress();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ShopPackage getShopPackage();

} // ShopFactory
