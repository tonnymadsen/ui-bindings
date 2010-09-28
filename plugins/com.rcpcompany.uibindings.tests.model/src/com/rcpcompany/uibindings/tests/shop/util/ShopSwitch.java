/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop.util;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.INamedObject;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopAddress;
import com.rcpcompany.uibindings.tests.shop.ShopInformation;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemDescription;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopItemInformation;
import com.rcpcompany.uibindings.tests.shop.ShopItemProperties;
import com.rcpcompany.uibindings.tests.shop.ShopItemURL;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.shop.ShopURL;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage
 * @generated
 */
public class ShopSwitch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ShopPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ShopSwitch() {
		if (modelPackage == null) {
			modelPackage = ShopPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage)
			return doSwitch(theEClass.getClassifierID(), theEObject);
		else {
			final List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
	 * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case ShopPackage.SHOP: {
			final Shop shop = (Shop) theEObject;
			T result = caseShop(shop);
			if (result == null) {
				result = caseNamedObject(shop);
			}
			if (result == null) {
				result = caseMOAO(shop);
			}
			if (result == null) {
				result = caseIAdaptable(shop);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.CUSTOMER: {
			final Customer customer = (Customer) theEObject;
			T result = caseCustomer(customer);
			if (result == null) {
				result = caseMOAO(customer);
			}
			if (result == null) {
				result = caseIAdaptable(customer);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.SHOP_ITEM: {
			final ShopItem shopItem = (ShopItem) theEObject;
			T result = caseShopItem(shopItem);
			if (result == null) {
				result = caseNamedObject(shopItem);
			}
			if (result == null) {
				result = caseMOAO(shopItem);
			}
			if (result == null) {
				result = caseIAdaptable(shopItem);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.SHOP_ITEM_PROPERTIES: {
			final ShopItemProperties shopItemProperties = (ShopItemProperties) theEObject;
			T result = caseShopItemProperties(shopItemProperties);
			if (result == null) {
				result = caseNamedObject(shopItemProperties);
			}
			if (result == null) {
				result = caseMOAO(shopItemProperties);
			}
			if (result == null) {
				result = caseIAdaptable(shopItemProperties);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.SHOP_ITEM_GROUP: {
			final ShopItemGroup shopItemGroup = (ShopItemGroup) theEObject;
			T result = caseShopItemGroup(shopItemGroup);
			if (result == null) {
				result = caseNamedObject(shopItemGroup);
			}
			if (result == null) {
				result = caseMOAO(shopItemGroup);
			}
			if (result == null) {
				result = caseIAdaptable(shopItemGroup);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.ORDER: {
			final Order order = (Order) theEObject;
			T result = caseOrder(order);
			if (result == null) {
				result = caseMOAO(order);
			}
			if (result == null) {
				result = caseIAdaptable(order);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.ORDER_ITEM: {
			final OrderItem orderItem = (OrderItem) theEObject;
			T result = caseOrderItem(orderItem);
			if (result == null) {
				result = caseMOAO(orderItem);
			}
			if (result == null) {
				result = caseIAdaptable(orderItem);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.CONTACT: {
			final Contact contact = (Contact) theEObject;
			T result = caseContact(contact);
			if (result == null) {
				result = caseNamedObject(contact);
			}
			if (result == null) {
				result = caseMOAO(contact);
			}
			if (result == null) {
				result = caseIAdaptable(contact);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.COUNTRY: {
			final Country country = (Country) theEObject;
			T result = caseCountry(country);
			if (result == null) {
				result = caseNamedObject(country);
			}
			if (result == null) {
				result = caseMOAO(country);
			}
			if (result == null) {
				result = caseIAdaptable(country);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.SHOP_ITEM_INFORMATION: {
			final ShopItemInformation shopItemInformation = (ShopItemInformation) theEObject;
			T result = caseShopItemInformation(shopItemInformation);
			if (result == null) {
				result = caseMOAO(shopItemInformation);
			}
			if (result == null) {
				result = caseIAdaptable(shopItemInformation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.SHOP_ITEM_DESCRIPTION: {
			final ShopItemDescription shopItemDescription = (ShopItemDescription) theEObject;
			T result = caseShopItemDescription(shopItemDescription);
			if (result == null) {
				result = caseShopItemInformation(shopItemDescription);
			}
			if (result == null) {
				result = caseMOAO(shopItemDescription);
			}
			if (result == null) {
				result = caseIAdaptable(shopItemDescription);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.SHOP_ITEM_URL: {
			final ShopItemURL shopItemURL = (ShopItemURL) theEObject;
			T result = caseShopItemURL(shopItemURL);
			if (result == null) {
				result = caseShopItemInformation(shopItemURL);
			}
			if (result == null) {
				result = caseMOAO(shopItemURL);
			}
			if (result == null) {
				result = caseIAdaptable(shopItemURL);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.SHOP_INFORMATION: {
			final ShopInformation shopInformation = (ShopInformation) theEObject;
			T result = caseShopInformation(shopInformation);
			if (result == null) {
				result = caseNamedObject(shopInformation);
			}
			if (result == null) {
				result = caseMOAO(shopInformation);
			}
			if (result == null) {
				result = caseIAdaptable(shopInformation);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.SHOP_URL: {
			final ShopURL shopURL = (ShopURL) theEObject;
			T result = caseShopURL(shopURL);
			if (result == null) {
				result = caseShopInformation(shopURL);
			}
			if (result == null) {
				result = caseNamedObject(shopURL);
			}
			if (result == null) {
				result = caseMOAO(shopURL);
			}
			if (result == null) {
				result = caseIAdaptable(shopURL);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ShopPackage.SHOP_ADDRESS: {
			final ShopAddress shopAddress = (ShopAddress) theEObject;
			T result = caseShopAddress(shopAddress);
			if (result == null) {
				result = caseShopInformation(shopAddress);
			}
			if (result == null) {
				result = caseNamedObject(shopAddress);
			}
			if (result == null) {
				result = caseMOAO(shopAddress);
			}
			if (result == null) {
				result = caseIAdaptable(shopAddress);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shop</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShop(Shop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Customer</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Customer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomer(Customer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShopItem(ShopItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item Properties</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShopItemProperties(ShopItemProperties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item Group</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShopItemGroup(ShopItemGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Order</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Order</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrder(Order object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Order Item</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Order Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderItem(OrderItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contact</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContact(Contact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Country</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Country</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountry(Country object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item Information</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShopItemInformation(ShopItemInformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item Description</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShopItemDescription(ShopItemDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item URL</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item URL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShopItemURL(ShopItemURL object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Information</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Information</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShopInformation(ShopInformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>URL</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>URL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShopURL(ShopURL object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Address</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Address</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShopAddress(ShopAddress object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IAdaptable</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IAdaptable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIAdaptable(IAdaptable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>MOAO</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>MOAO</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMOAO(IMOAO object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Object</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedObject(INamedObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will
	 * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // ShopSwitch
