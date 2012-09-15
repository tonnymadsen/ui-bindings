/**
 */
package com.rcpcompany.uibindings.tests.shop.util;

import com.rcpcompany.uibindings.moao.util.MOAOValidator;

import com.rcpcompany.uibindings.tests.shop.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage
 * @generated
 */
public class ShopValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final ShopValidator INSTANCE = new ShopValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.rcpcompany.uibindings.tests.shop"; //$NON-NLS-1$

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Length OK' of 'Shop'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHOP__NAME_LENGTH_OK = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Price OK' of 'Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHOP_ITEM__NAME_PRICE_OK = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name OK' of 'Item'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int SHOP_ITEM__NAME_OK = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Abbreviation Length OK' of 'Country'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COUNTRY__ABBREVIATION_LENGTH_OK = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Abbreviation Case OK' of 'Country'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int COUNTRY__ABBREVIATION_CASE_OK = 5;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 5;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MOAOValidator moaoValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShopValidator() {
		super();
		moaoValidator = MOAOValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return ShopPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
		case ShopPackage.SHOP:
			return validateShop((Shop) value, diagnostics, context);
		case ShopPackage.CUSTOMER:
			return validateCustomer((Customer) value, diagnostics, context);
		case ShopPackage.CUSTOMER_GROUP:
			return validateCustomerGroup((CustomerGroup) value, diagnostics, context);
		case ShopPackage.SHOP_ITEM:
			return validateShopItem((ShopItem) value, diagnostics, context);
		case ShopPackage.SHOP_ITEM_PROPERTIES:
			return validateShopItemProperties((ShopItemProperties) value, diagnostics, context);
		case ShopPackage.SHOP_ITEM_GROUP:
			return validateShopItemGroup((ShopItemGroup) value, diagnostics, context);
		case ShopPackage.ORDER:
			return validateOrder((Order) value, diagnostics, context);
		case ShopPackage.ORDER_ITEM:
			return validateOrderItem((OrderItem) value, diagnostics, context);
		case ShopPackage.CONTACT:
			return validateContact((Contact) value, diagnostics, context);
		case ShopPackage.COUNTRY:
			return validateCountry((Country) value, diagnostics, context);
		case ShopPackage.COUNTRY_INFO:
			return validateCountryInfo((CountryInfo) value, diagnostics, context);
		case ShopPackage.SHOP_ITEM_INFORMATION:
			return validateShopItemInformation((ShopItemInformation) value, diagnostics, context);
		case ShopPackage.SHOP_ITEM_DESCRIPTION:
			return validateShopItemDescription((ShopItemDescription) value, diagnostics, context);
		case ShopPackage.SHOP_ITEM_URL:
			return validateShopItemURL((ShopItemURL) value, diagnostics, context);
		case ShopPackage.SHOP_INFORMATION:
			return validateShopInformation((ShopInformation) value, diagnostics, context);
		case ShopPackage.SHOP_URL:
			return validateShopURL((ShopURL) value, diagnostics, context);
		case ShopPackage.SHOP_ADDRESS:
			return validateShopAddress((ShopAddress) value, diagnostics, context);
		case ShopPackage.CUSTOMER_TYPE:
			return validateCustomerType((CustomerType) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShop(Shop shop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shop, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(shop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(shop, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(shop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(shop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(shop, diagnostics, context);
		if (result || diagnostics != null) result &= moaoValidator.validateMOAO_isValid(shop, diagnostics, context);
		if (result || diagnostics != null) result &= validateShop_nameLengthOK(shop, diagnostics, context);
		return result;
	}

	/**
	 * Validates the nameLengthOK constraint of '<em>Shop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShop_nameLengthOK(Shop shop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return shop.nameLengthOK(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCustomer(Customer customer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(customer, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(customer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(customer, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(customer, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(customer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(customer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(customer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(customer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(customer, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(customer, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCustomerGroup(CustomerGroup customerGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(customerGroup, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(customerGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(customerGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(customerGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(customerGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(customerGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(customerGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(customerGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(customerGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(customerGroup, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopItem(ShopItem shopItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shopItem, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shopItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(shopItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(shopItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(shopItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(shopItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shopItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shopItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(shopItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(shopItem, diagnostics, context);
		if (result || diagnostics != null) result &= validateShopItem_namePriceOK(shopItem, diagnostics, context);
		if (result || diagnostics != null) result &= validateShopItem_nameOK(shopItem, diagnostics, context);
		return result;
	}

	/**
	 * Validates the namePriceOK constraint of '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopItem_namePriceOK(ShopItem shopItem, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return shopItem.namePriceOK(diagnostics, context);
	}

	/**
	 * Validates the nameOK constraint of '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopItem_nameOK(ShopItem shopItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return shopItem.nameOK(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopItemProperties(ShopItemProperties shopItemProperties, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shopItemProperties, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shopItemProperties, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(shopItemProperties, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(shopItemProperties, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(shopItemProperties, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(shopItemProperties, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shopItemProperties, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shopItemProperties, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(shopItemProperties, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(shopItemProperties, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopItemGroup(ShopItemGroup shopItemGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shopItemGroup, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shopItemGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(shopItemGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(shopItemGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(shopItemGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(shopItemGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shopItemGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shopItemGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(shopItemGroup, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(shopItemGroup, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrder(Order order, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(order, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(order, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(order, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(order, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(order, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(order, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(order, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(order, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(order, diagnostics, context);
		if (result || diagnostics != null) result &= moaoValidator.validateMOAO_isValid(order, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOrderItem(OrderItem orderItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(orderItem, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(orderItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(orderItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(orderItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(orderItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(orderItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(orderItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(orderItem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(orderItem, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(orderItem, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContact(Contact contact, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(contact, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(contact, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(contact, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(contact, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(contact, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(contact, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(contact, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(contact, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(contact, diagnostics, context);
		if (result || diagnostics != null) result &= moaoValidator.validateMOAO_isValid(contact, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCountry(Country country, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(country, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(country, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(country, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(country, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(country, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(country, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(country, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(country, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(country, diagnostics, context);
		if (result || diagnostics != null) result &= moaoValidator.validateMOAO_isValid(country, diagnostics, context);
		if (result || diagnostics != null)
			result &= validateCountry_abbreviationLengthOK(country, diagnostics, context);
		if (result || diagnostics != null) result &= validateCountry_abbreviationCaseOK(country, diagnostics, context);
		return result;
	}

	/**
	 * Validates the abbreviationLengthOK constraint of '<em>Country</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCountry_abbreviationLengthOK(Country country, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return country.abbreviationLengthOK(diagnostics, context);
	}

	/**
	 * Validates the abbreviationCaseOK constraint of '<em>Country</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCountry_abbreviationCaseOK(Country country, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return country.abbreviationCaseOK(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCountryInfo(CountryInfo countryInfo, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(countryInfo, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(countryInfo, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(countryInfo, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(countryInfo, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(countryInfo, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(countryInfo, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(countryInfo, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(countryInfo, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(countryInfo, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(countryInfo, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopItemInformation(ShopItemInformation shopItemInformation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shopItemInformation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shopItemInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(shopItemInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(shopItemInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(shopItemInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(shopItemInformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shopItemInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(shopItemInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(shopItemInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(shopItemInformation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopItemDescription(ShopItemDescription shopItemDescription, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shopItemDescription, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shopItemDescription, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(shopItemDescription, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(shopItemDescription, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(shopItemDescription, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(shopItemDescription, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shopItemDescription, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryKeyUnique(shopItemDescription, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(shopItemDescription, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(shopItemDescription, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopItemURL(ShopItemURL shopItemURL, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shopItemURL, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shopItemURL, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(shopItemURL, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(shopItemURL, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(shopItemURL, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(shopItemURL, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shopItemURL, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shopItemURL, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(shopItemURL, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(shopItemURL, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopInformation(ShopInformation shopInformation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shopInformation, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shopInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(shopInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(shopInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(shopInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryProxyResolves(shopInformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shopInformation, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shopInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryMapEntryUnique(shopInformation, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(shopInformation, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopURL(ShopURL shopURL, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shopURL, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shopURL, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(shopURL, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(shopURL, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(shopURL, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(shopURL, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shopURL, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shopURL, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(shopURL, diagnostics, context);
		if (result || diagnostics != null) result &= moaoValidator.validateMOAO_isValid(shopURL, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateShopAddress(ShopAddress shopAddress, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shopAddress, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shopAddress, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryDataValueConforms(shopAddress, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryReferenceIsContained(shopAddress, diagnostics, context);
		if (result || diagnostics != null)
			result &= validate_EveryBidirectionalReferenceIsPaired(shopAddress, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(shopAddress, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(shopAddress, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(shopAddress, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(shopAddress, diagnostics, context);
		if (result || diagnostics != null)
			result &= moaoValidator.validateMOAO_isValid(shopAddress, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCustomerType(CustomerType customerType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ShopValidator
