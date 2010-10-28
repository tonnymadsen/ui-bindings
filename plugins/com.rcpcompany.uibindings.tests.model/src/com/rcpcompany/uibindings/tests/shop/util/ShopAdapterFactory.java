/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop.util;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.INamedObject;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.CustomerGroup;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage
 * @generated
 */
public class ShopAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ShopPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ShopAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ShopPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
	 * --> This implementation returns <code>true</code> if the object is either the model's package
	 * or is an instance object of the model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) return true;
		if (object instanceof EObject) return ((EObject) object).eClass().getEPackage() == modelPackage;
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ShopSwitch<Adapter> modelSwitch = new ShopSwitch<Adapter>() {
		@Override
		public Adapter caseShop(Shop object) {
			return createShopAdapter();
		}

		@Override
		public Adapter caseCustomer(Customer object) {
			return createCustomerAdapter();
		}

		@Override
		public Adapter caseCustomerGroup(CustomerGroup object) {
			return createCustomerGroupAdapter();
		}

		@Override
		public Adapter caseShopItem(ShopItem object) {
			return createShopItemAdapter();
		}

		@Override
		public Adapter caseShopItemProperties(ShopItemProperties object) {
			return createShopItemPropertiesAdapter();
		}

		@Override
		public Adapter caseShopItemGroup(ShopItemGroup object) {
			return createShopItemGroupAdapter();
		}

		@Override
		public Adapter caseOrder(Order object) {
			return createOrderAdapter();
		}

		@Override
		public Adapter caseOrderItem(OrderItem object) {
			return createOrderItemAdapter();
		}

		@Override
		public Adapter caseContact(Contact object) {
			return createContactAdapter();
		}

		@Override
		public Adapter caseCountry(Country object) {
			return createCountryAdapter();
		}

		@Override
		public Adapter caseShopItemInformation(ShopItemInformation object) {
			return createShopItemInformationAdapter();
		}

		@Override
		public Adapter caseShopItemDescription(ShopItemDescription object) {
			return createShopItemDescriptionAdapter();
		}

		@Override
		public Adapter caseShopItemURL(ShopItemURL object) {
			return createShopItemURLAdapter();
		}

		@Override
		public Adapter caseShopInformation(ShopInformation object) {
			return createShopInformationAdapter();
		}

		@Override
		public Adapter caseShopURL(ShopURL object) {
			return createShopURLAdapter();
		}

		@Override
		public Adapter caseShopAddress(ShopAddress object) {
			return createShopAddressAdapter();
		}

		@Override
		public Adapter caseIAdaptable(IAdaptable object) {
			return createIAdaptableAdapter();
		}

		@Override
		public Adapter caseMOAO(IMOAO object) {
			return createMOAOAdapter();
		}

		@Override
		public Adapter caseNamedObject(INamedObject object) {
			return createNamedObjectAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop <em>Shop</em>}'. <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop
	 * @generated
	 */
	public Adapter createShopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.Customer <em>Customer</em>}'. <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.Customer
	 * @generated
	 */
	public Adapter createCustomerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.CustomerGroup <em>Customer Group</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.CustomerGroup
	 * @generated
	 */
	public Adapter createCustomerGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItem <em>Item</em>}'. <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem
	 * @generated
	 */
	public Adapter createShopItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemProperties <em>Item Properties</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemProperties
	 * @generated
	 */
	public Adapter createShopItemPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup <em>Item Group</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemGroup
	 * @generated
	 */
	public Adapter createShopItemGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.Order <em>Order</em>}'. <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.Order
	 * @generated
	 */
	public Adapter createOrderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.OrderItem <em>Order Item</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.OrderItem
	 * @generated
	 */
	public Adapter createOrderItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.Contact <em>Contact</em>}'. <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.Contact
	 * @generated
	 */
	public Adapter createContactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.Country <em>Country</em>}'. <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.Country
	 * @generated
	 */
	public Adapter createCountryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemInformation <em>Item Information</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemInformation
	 * @generated
	 */
	public Adapter createShopItemInformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemDescription <em>Item Description</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemDescription
	 * @generated
	 */
	public Adapter createShopItemDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemURL <em>Item URL</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemURL
	 * @generated
	 */
	public Adapter createShopItemURLAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopInformation <em>Information</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopInformation
	 * @generated
	 */
	public Adapter createShopInformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopURL <em>URL</em>}'. <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopURL
	 * @generated
	 */
	public Adapter createShopURLAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopAddress <em>Address</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopAddress
	 * @generated
	 */
	public Adapter createShopAddressAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.core.runtime.IAdaptable
	 * <em>IAdaptable</em>}'. <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
	 * the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.eclipse.core.runtime.IAdaptable
	 * @generated
	 */
	public Adapter createIAdaptableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.rcpcompany.uibindings.moao.IMOAO
	 * <em>MOAO</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
	 * cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.moao.IMOAO
	 * @generated
	 */
	public Adapter createMOAOAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link com.rcpcompany.uibindings.moao.INamedObject <em>Named Object</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see com.rcpcompany.uibindings.moao.INamedObject
	 * @generated
	 */
	public Adapter createNamedObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
	 * implementation returns null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // ShopAdapterFactory
