/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.CustomerType;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemDescription;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopItemInformation;
import com.rcpcompany.uibindings.tests.shop.ShopItemURL;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage
 * @generated
 */
public class ShopValidator extends EObjectValidator {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final ShopValidator INSTANCE = new ShopValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
	 * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.rcpcompany.uibindings.tests.shop";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Length
	 * OK' of 'Shop'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int SHOP__NAME_LENGTH_OK = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name Price
	 * OK' of 'Item'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int SHOP_ITEM__NAME_PRICE_OK = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Name OK' of
	 * 'Item'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int SHOP_ITEM__NAME_OK = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint
	 * 'Abbreviation Length OK' of 'Country'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int COUNTRY__ABBREVIATION_LENGTH_OK = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint
	 * 'Abbreviation Case OK' of 'Country'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int COUNTRY__ABBREVIATION_CASE_OK = 5;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written
	 * constants. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 5;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written
	 * constants in a derived class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ShopValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
		return ShopPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
		case ShopPackage.SHOP:
			return validateShop((Shop) value, diagnostics, context);
		case ShopPackage.CUSTOMER:
			return validateCustomer((Customer) value, diagnostics, context);
		case ShopPackage.SHOP_ITEM:
			return validateShopItem((ShopItem) value, diagnostics, context);
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
		case ShopPackage.SHOP_ITEM_INFORMATION:
			return validateShopItemInformation((ShopItemInformation) value, diagnostics, context);
		case ShopPackage.SHOP_ITEM_DESCRIPTION:
			return validateShopItemDescription((ShopItemDescription) value, diagnostics, context);
		case ShopPackage.SHOP_ITEM_URL:
			return validateShopItemURL((ShopItemURL) value, diagnostics, context);
		case ShopPackage.CUSTOMER_TYPE:
			return validateCustomerType((CustomerType) value, diagnostics, context);
		case ShopPackage.DIAGNOSTIC_CHAIN:
			return validateDiagnosticChain((DiagnosticChain) value, diagnostics, context);
		default:
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateShop(Shop shop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shop, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shop, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(shop, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(shop, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(shop, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(shop, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(shop, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(shop, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(shop, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateShop_nameLengthOK(shop, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the nameLengthOK constraint of '<em>Shop</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateShop_nameLengthOK(Shop shop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return shop.nameLengthOK(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCustomer(Customer customer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(customer, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateShopItem(ShopItem shopItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(shopItem, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(shopItem, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(shopItem, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(shopItem, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(shopItem, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(shopItem, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(shopItem, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(shopItem, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(shopItem, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateShopItem_namePriceOK(shopItem, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateShopItem_nameOK(shopItem, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the namePriceOK constraint of '<em>Item</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateShopItem_namePriceOK(ShopItem shopItem, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return shopItem.namePriceOK(diagnostics, context);
	}

	/**
	 * Validates the nameOK constraint of '<em>Item</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	public boolean validateShopItem_nameOK(ShopItem shopItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return shopItem.nameOK(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateShopItemGroup(ShopItemGroup shopItemGroup, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(shopItemGroup, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateOrder(Order order, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(order, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateOrderItem(OrderItem orderItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(orderItem, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateContact(Contact contact, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(contact, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCountry(Country country, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(country, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(country, diagnostics, context);
		if (result || diagnostics != null) {
			result &= validate_EveryDataValueConforms(country, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryReferenceIsContained(country, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryBidirectionalReferenceIsPaired(country, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryProxyResolves(country, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_UniqueID(country, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryKeyUnique(country, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validate_EveryMapEntryUnique(country, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateCountry_abbreviationLengthOK(country, diagnostics, context);
		}
		if (result || diagnostics != null) {
			result &= validateCountry_abbreviationCaseOK(country, diagnostics, context);
		}
		return result;
	}

	/**
	 * Validates the abbreviationLengthOK constraint of '<em>Country</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCountry_abbreviationLengthOK(Country country, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return country.abbreviationLengthOK(diagnostics, context);
	}

	/**
	 * Validates the abbreviationCaseOK constraint of '<em>Country</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCountry_abbreviationCaseOK(Country country, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return country.abbreviationCaseOK(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateShopItemInformation(ShopItemInformation shopItemInformation, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(shopItemInformation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateShopItemDescription(ShopItemDescription shopItemDescription, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(shopItemDescription, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateShopItemURL(ShopItemURL shopItemURL, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(shopItemURL, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateCustomerType(CustomerType customerType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateDiagnosticChain(DiagnosticChain diagnosticChain, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's
	 * diagnostics. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // ShopValidator
