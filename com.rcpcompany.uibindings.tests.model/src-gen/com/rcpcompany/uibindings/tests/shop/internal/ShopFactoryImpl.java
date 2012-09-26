/**
 */
package com.rcpcompany.uibindings.tests.shop.internal;

import com.rcpcompany.uibindings.tests.shop.*;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Date;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.CountryInfo;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.CustomerGroup;
import com.rcpcompany.uibindings.tests.shop.CustomerType;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopAddress;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemDescription;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopItemInformation;
import com.rcpcompany.uibindings.tests.shop.ShopItemProperties;
import com.rcpcompany.uibindings.tests.shop.ShopItemURL;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.shop.ShopURL;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ShopFactoryImpl extends EFactoryImpl implements ShopFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ShopFactory init() {
		try {
			ShopFactory theShopFactory = (ShopFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://rcp-company.com/schemas/uibindings/shop.ecore"); //$NON-NLS-1$ 
			if (theShopFactory != null) { return theShopFactory; }
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ShopFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopFactoryImpl() {
		super();
	}

	private Shop theShop = null;

	@Override
	public Shop getShop(EditingDomain editingDomain) {
		if (theShop == null) {
			/*
			 * Make sure the shop package is properly initialized
			 */
			final ShopPackage shopPackage = ShopPackage.eINSTANCE;

			/*
			 * Need to convert the platform: URI into a file: URI as we otherwise cannot save the
			 * data
			 */
			URL resolve = null;
			try {
				resolve = FileLocator.resolve(new URL(
						"platform:/plugin/com.rcpcompany.uibindings.tests.model/data/TEST.shop"));
			} catch (final FileNotFoundException ex) {
				LogUtils.error(this, "test shop does not exist!?!", ex);
				return null;
			} catch (final Exception ex) {
				LogUtils.error(this, ex);
				return null;
			}
			final Resource resource = editingDomain.loadResource(resolve.toString());
			if (resource != null) {
				theShop = (Shop) resource.getContents().get(0);
			}
		}
		return theShop;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ShopPackage.SHOP:
			return createShop();
		case ShopPackage.CUSTOMER:
			return createCustomer();
		case ShopPackage.CUSTOMER_GROUP:
			return createCustomerGroup();
		case ShopPackage.SHOP_ITEM:
			return createShopItem();
		case ShopPackage.SHOP_ITEM_PROPERTIES:
			return createShopItemProperties();
		case ShopPackage.SHOP_ITEM_GROUP:
			return createShopItemGroup();
		case ShopPackage.ORDER:
			return createOrder();
		case ShopPackage.ORDER_ITEM:
			return createOrderItem();
		case ShopPackage.CONTACT:
			return createContact();
		case ShopPackage.COUNTRY:
			return createCountry();
		case ShopPackage.COUNTRY_INFO:
			return createCountryInfo();
		case ShopPackage.SHOP_ITEM_INFORMATION:
			return createShopItemInformation();
		case ShopPackage.SHOP_ITEM_DESCRIPTION:
			return createShopItemDescription();
		case ShopPackage.SHOP_ITEM_URL:
			return createShopItemURL();
		case ShopPackage.SHOP_URL:
			return createShopURL();
		case ShopPackage.SHOP_ADDRESS:
			return createShopAddress();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case ShopPackage.CUSTOMER_TYPE:
			return createCustomerTypeFromString(eDataType, initialValue);
		case ShopPackage.EDIAGNOSTIC_CHAIN:
			return createEDiagnosticChainFromString(eDataType, initialValue);
		case ShopPackage.EMAP:
			return createEMapFromString(eDataType, initialValue);
		case ShopPackage.EDATE:
			return createEDateFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case ShopPackage.CUSTOMER_TYPE:
			return convertCustomerTypeToString(eDataType, instanceValue);
		case ShopPackage.EDIAGNOSTIC_CHAIN:
			return convertEDiagnosticChainToString(eDataType, instanceValue);
		case ShopPackage.EMAP:
			return convertEMapToString(eDataType, instanceValue);
		case ShopPackage.EDATE:
			return convertEDateToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Shop createShop() {
		ShopImpl shop = new ShopImpl();
		return shop;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Customer createCustomer() {
		CustomerImpl customer = new CustomerImpl();
		return customer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerGroup createCustomerGroup() {
		CustomerGroupImpl customerGroup = new CustomerGroupImpl();
		return customerGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopItem createShopItem() {
		ShopItemImpl shopItem = new ShopItemImpl();
		return shopItem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopItemProperties createShopItemProperties() {
		ShopItemPropertiesImpl shopItemProperties = new ShopItemPropertiesImpl();
		return shopItemProperties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopItemGroup createShopItemGroup() {
		ShopItemGroupImpl shopItemGroup = new ShopItemGroupImpl();
		return shopItemGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Order createOrder() {
		OrderImpl order = new OrderImpl();
		return order;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OrderItem createOrderItem() {
		OrderItemImpl orderItem = new OrderItemImpl();
		return orderItem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Contact createContact() {
		ContactImpl contact = new ContactImpl();
		return contact;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Country createCountry() {
		CountryImpl country = new CountryImpl();
		return country;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CountryInfo createCountryInfo() {
		CountryInfoImpl countryInfo = new CountryInfoImpl();
		return countryInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopItemInformation createShopItemInformation() {
		ShopItemInformationImpl shopItemInformation = new ShopItemInformationImpl();
		return shopItemInformation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopItemDescription createShopItemDescription() {
		ShopItemDescriptionImpl shopItemDescription = new ShopItemDescriptionImpl();
		return shopItemDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopItemURL createShopItemURL() {
		ShopItemURLImpl shopItemURL = new ShopItemURLImpl();
		return shopItemURL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopURL createShopURL() {
		ShopURLImpl shopURL = new ShopURLImpl();
		return shopURL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopAddress createShopAddress() {
		ShopAddressImpl shopAddress = new ShopAddressImpl();
		return shopAddress;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerType createCustomerTypeFromString(EDataType eDataType, String initialValue) {
		CustomerType result = CustomerType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCustomerTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DiagnosticChain createEDiagnosticChainFromString(EDataType eDataType, String initialValue) {
		return (DiagnosticChain) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDiagnosticChainToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map<?, ?> createEMapFromString(EDataType eDataType, String initialValue) {
		return (Map<?, ?>) super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date createEDateFromString(EDataType eDataType, String initialValue) {
		return (Date) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEDateToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopPackage getShopPackage() {
		return (ShopPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ShopPackage getPackage() {
		return ShopPackage.eINSTANCE;
	}

} // ShopFactoryImpl
