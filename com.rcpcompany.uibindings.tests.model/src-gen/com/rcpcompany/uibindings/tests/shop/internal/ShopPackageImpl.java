/**
 */
package com.rcpcompany.uibindings.tests.shop.internal;

import com.rcpcompany.uibindings.moao.IMOAOPackage;

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
import com.rcpcompany.uibindings.tests.shop.ShopInformation;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemDescription;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopItemInformation;
import com.rcpcompany.uibindings.tests.shop.ShopItemProperties;
import com.rcpcompany.uibindings.tests.shop.ShopItemURL;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.shop.ShopURL;

import com.rcpcompany.uibindings.tests.shop.util.ShopValidator;

import java.util.Date;
import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ShopPackageImpl extends EPackageImpl implements ShopPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customerGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shopItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shopItemPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shopItemGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countryInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shopItemInformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shopItemDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shopItemURLEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shopInformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shopURLEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shopAddressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum customerTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eDiagnosticChainEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eMapEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType eDateEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ShopPackageImpl() {
		super(eNS_URI, ShopFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ShopPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ShopPackage init() {
		if (isInited) return (ShopPackage) EPackage.Registry.INSTANCE.getEPackage(ShopPackage.eNS_URI);

		// Obtain or create and register package
		ShopPackageImpl theShopPackage = (ShopPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ShopPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new ShopPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IMOAOPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theShopPackage.createPackageContents();

		// Initialize created meta-data
		theShopPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theShopPackage, new EValidator.Descriptor() {
			public EValidator getEValidator() {
				return ShopValidator.INSTANCE;
			}
		});

		// Mark meta-data to indicate it can't be changed
		theShopPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ShopPackage.eNS_URI, theShopPackage);
		return theShopPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShop() {
		return shopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShop_NextOrderNo() {
		return (EAttribute) shopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShop_NextCustomerNo() {
		return (EAttribute) shopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShop_TmpDir() {
		return (EAttribute) shopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShop_Countries() {
		return (EReference) shopEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShop_Contacts() {
		return (EReference) shopEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShop_ShopItems() {
		return (EReference) shopEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShop_Orders() {
		return (EReference) shopEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShop_Customers() {
		return (EReference) shopEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShop_CustomerGroups() {
		return (EReference) shopEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShop_ShopGroups() {
		return (EReference) shopEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShop_Infos() {
		return (EReference) shopEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShop__Save() {
		return shopEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShop__NameLengthOK__DiagnosticChain_Map() {
		return shopEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomer() {
		return customerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomer_Shop() {
		return (EReference) customerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomer_Contact() {
		return (EReference) customerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomer_Orders() {
		return (EReference) customerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomer_Loyalty() {
		return (EAttribute) customerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomer_LogoFileName() {
		return (EAttribute) customerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomerGroup() {
		return customerGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomerGroup_Shop() {
		return (EReference) customerGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCustomerGroup_Customers() {
		return (EReference) customerGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShopItem() {
		return shopItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShopItem_Shop() {
		return (EReference) shopItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShopItem_Price() {
		return (EAttribute) shopItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShopItem_AdvancedPrice() {
		return (EAttribute) shopItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShopItem_OrderItems() {
		return (EReference) shopItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShopItem_ForSale() {
		return (EAttribute) shopItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShopItem_Information() {
		return (EReference) shopItemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShopItem_Group() {
		return (EReference) shopItemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShopItem_Locations() {
		return (EAttribute) shopItemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShopItem_Properties() {
		return (EReference) shopItemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShopItem__NamePriceOK__DiagnosticChain_Map() {
		return shopItemEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getShopItem__NameOK__DiagnosticChain_Map() {
		return shopItemEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShopItemProperties() {
		return shopItemPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShopItemProperties_Item() {
		return (EReference) shopItemPropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShopItemProperties_Value() {
		return (EAttribute) shopItemPropertiesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShopItemGroup() {
		return shopItemGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShopItemGroup_Shop() {
		return (EReference) shopItemGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getShopItemGroup_Item() {
		return (EReference) shopItemGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrder() {
		return orderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrder_Shop() {
		return (EReference) orderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrder_No() {
		return (EAttribute) orderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrder_Customer() {
		return (EReference) orderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrder_Price() {
		return (EAttribute) orderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrder_Items() {
		return (EReference) orderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrder_Discount() {
		return (EAttribute) orderEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderItem() {
		return orderItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrderItem_Order() {
		return (EReference) orderItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrderItem_No() {
		return (EAttribute) orderItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrderItem_Item() {
		return (EReference) orderItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrderItem_Count() {
		return (EAttribute) orderItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrderItem_Id() {
		return (EAttribute) orderItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContact() {
		return contactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContact_Shop() {
		return (EReference) contactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContact_Address() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContact_City() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContact_Zip() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContact_Country() {
		return (EReference) contactEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContact_Customer() {
		return (EReference) contactEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContact_Newsletter() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContact_Birthday() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountry() {
		return countryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_Shop() {
		return (EReference) countryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountry_Abbreviation() {
		return (EAttribute) countryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_Contacts() {
		return (EReference) countryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCountry_Information() {
		return (EReference) countryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCountry__AbbreviationLengthOK__DiagnosticChain_Map() {
		return countryEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCountry__AbbreviationCaseOK__DiagnosticChain_Map() {
		return countryEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCountryInfo() {
		return countryInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountryInfo_Population() {
		return (EAttribute) countryInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCountryInfo_Currency() {
		return (EAttribute) countryInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShopItemInformation() {
		return shopItemInformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShopItemDescription() {
		return shopItemDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShopItemURL() {
		return shopItemURLEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShopItemURL_Url() {
		return (EAttribute) shopItemURLEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShopInformation() {
		return shopInformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShopInformation_Value() {
		return (EAttribute) shopInformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShopURL() {
		return shopURLEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShopURL_Url() {
		return (EAttribute) shopURLEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShopAddress() {
		return shopAddressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShopAddress_Url() {
		return (EAttribute) shopAddressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCustomerType() {
		return customerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEDiagnosticChain() {
		return eDiagnosticChainEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEMap() {
		return eMapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEDate() {
		return eDateEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShopFactory getShopFactory() {
		return (ShopFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		shopEClass = createEClass(SHOP);
		createEAttribute(shopEClass, SHOP__NEXT_ORDER_NO);
		createEAttribute(shopEClass, SHOP__NEXT_CUSTOMER_NO);
		createEAttribute(shopEClass, SHOP__TMP_DIR);
		createEReference(shopEClass, SHOP__COUNTRIES);
		createEReference(shopEClass, SHOP__CONTACTS);
		createEReference(shopEClass, SHOP__SHOP_ITEMS);
		createEReference(shopEClass, SHOP__ORDERS);
		createEReference(shopEClass, SHOP__CUSTOMERS);
		createEReference(shopEClass, SHOP__CUSTOMER_GROUPS);
		createEReference(shopEClass, SHOP__SHOP_GROUPS);
		createEReference(shopEClass, SHOP__INFOS);
		createEOperation(shopEClass, SHOP___SAVE);
		createEOperation(shopEClass, SHOP___NAME_LENGTH_OK__DIAGNOSTICCHAIN_MAP);

		customerEClass = createEClass(CUSTOMER);
		createEReference(customerEClass, CUSTOMER__SHOP);
		createEReference(customerEClass, CUSTOMER__CONTACT);
		createEReference(customerEClass, CUSTOMER__ORDERS);
		createEAttribute(customerEClass, CUSTOMER__LOYALTY);
		createEAttribute(customerEClass, CUSTOMER__LOGO_FILE_NAME);

		customerGroupEClass = createEClass(CUSTOMER_GROUP);
		createEReference(customerGroupEClass, CUSTOMER_GROUP__SHOP);
		createEReference(customerGroupEClass, CUSTOMER_GROUP__CUSTOMERS);

		shopItemEClass = createEClass(SHOP_ITEM);
		createEReference(shopItemEClass, SHOP_ITEM__SHOP);
		createEAttribute(shopItemEClass, SHOP_ITEM__PRICE);
		createEAttribute(shopItemEClass, SHOP_ITEM__ADVANCED_PRICE);
		createEReference(shopItemEClass, SHOP_ITEM__ORDER_ITEMS);
		createEAttribute(shopItemEClass, SHOP_ITEM__FOR_SALE);
		createEReference(shopItemEClass, SHOP_ITEM__INFORMATION);
		createEReference(shopItemEClass, SHOP_ITEM__GROUP);
		createEAttribute(shopItemEClass, SHOP_ITEM__LOCATIONS);
		createEReference(shopItemEClass, SHOP_ITEM__PROPERTIES);
		createEOperation(shopItemEClass, SHOP_ITEM___NAME_PRICE_OK__DIAGNOSTICCHAIN_MAP);
		createEOperation(shopItemEClass, SHOP_ITEM___NAME_OK__DIAGNOSTICCHAIN_MAP);

		shopItemPropertiesEClass = createEClass(SHOP_ITEM_PROPERTIES);
		createEReference(shopItemPropertiesEClass, SHOP_ITEM_PROPERTIES__ITEM);
		createEAttribute(shopItemPropertiesEClass, SHOP_ITEM_PROPERTIES__VALUE);

		shopItemGroupEClass = createEClass(SHOP_ITEM_GROUP);
		createEReference(shopItemGroupEClass, SHOP_ITEM_GROUP__SHOP);
		createEReference(shopItemGroupEClass, SHOP_ITEM_GROUP__ITEM);

		orderEClass = createEClass(ORDER);
		createEReference(orderEClass, ORDER__SHOP);
		createEAttribute(orderEClass, ORDER__NO);
		createEReference(orderEClass, ORDER__CUSTOMER);
		createEAttribute(orderEClass, ORDER__PRICE);
		createEReference(orderEClass, ORDER__ITEMS);
		createEAttribute(orderEClass, ORDER__DISCOUNT);

		orderItemEClass = createEClass(ORDER_ITEM);
		createEReference(orderItemEClass, ORDER_ITEM__ORDER);
		createEAttribute(orderItemEClass, ORDER_ITEM__NO);
		createEReference(orderItemEClass, ORDER_ITEM__ITEM);
		createEAttribute(orderItemEClass, ORDER_ITEM__COUNT);
		createEAttribute(orderItemEClass, ORDER_ITEM__ID);

		contactEClass = createEClass(CONTACT);
		createEReference(contactEClass, CONTACT__SHOP);
		createEAttribute(contactEClass, CONTACT__ADDRESS);
		createEAttribute(contactEClass, CONTACT__CITY);
		createEAttribute(contactEClass, CONTACT__ZIP);
		createEReference(contactEClass, CONTACT__COUNTRY);
		createEReference(contactEClass, CONTACT__CUSTOMER);
		createEAttribute(contactEClass, CONTACT__NEWSLETTER);
		createEAttribute(contactEClass, CONTACT__BIRTHDAY);

		countryEClass = createEClass(COUNTRY);
		createEReference(countryEClass, COUNTRY__SHOP);
		createEAttribute(countryEClass, COUNTRY__ABBREVIATION);
		createEReference(countryEClass, COUNTRY__CONTACTS);
		createEReference(countryEClass, COUNTRY__INFORMATION);
		createEOperation(countryEClass, COUNTRY___ABBREVIATION_LENGTH_OK__DIAGNOSTICCHAIN_MAP);
		createEOperation(countryEClass, COUNTRY___ABBREVIATION_CASE_OK__DIAGNOSTICCHAIN_MAP);

		countryInfoEClass = createEClass(COUNTRY_INFO);
		createEAttribute(countryInfoEClass, COUNTRY_INFO__POPULATION);
		createEAttribute(countryInfoEClass, COUNTRY_INFO__CURRENCY);

		shopItemInformationEClass = createEClass(SHOP_ITEM_INFORMATION);

		shopItemDescriptionEClass = createEClass(SHOP_ITEM_DESCRIPTION);

		shopItemURLEClass = createEClass(SHOP_ITEM_URL);
		createEAttribute(shopItemURLEClass, SHOP_ITEM_URL__URL);

		shopInformationEClass = createEClass(SHOP_INFORMATION);
		createEAttribute(shopInformationEClass, SHOP_INFORMATION__VALUE);

		shopURLEClass = createEClass(SHOP_URL);
		createEAttribute(shopURLEClass, SHOP_URL__URL);

		shopAddressEClass = createEClass(SHOP_ADDRESS);
		createEAttribute(shopAddressEClass, SHOP_ADDRESS__URL);

		// Create enums
		customerTypeEEnum = createEEnum(CUSTOMER_TYPE);

		// Create data types
		eDiagnosticChainEDataType = createEDataType(EDIAGNOSTIC_CHAIN);
		eMapEDataType = createEDataType(EMAP);
		eDateEDataType = createEDataType(EDATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		IMOAOPackage theMOAOPackage = (IMOAOPackage) EPackage.Registry.INSTANCE.getEPackage(IMOAOPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters
		addETypeParameter(eMapEDataType, "K"); //$NON-NLS-1$
		addETypeParameter(eMapEDataType, "V"); //$NON-NLS-1$

		// Set bounds for type parameters

		// Add supertypes to classes
		shopEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		customerEClass.getESuperTypes().add(theMOAOPackage.getMOAO());
		customerGroupEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		shopItemEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		shopItemPropertiesEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		shopItemGroupEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		orderEClass.getESuperTypes().add(theMOAOPackage.getMOAO());
		orderItemEClass.getESuperTypes().add(theMOAOPackage.getMOAO());
		contactEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		countryEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		countryInfoEClass.getESuperTypes().add(theMOAOPackage.getMOAO());
		shopItemInformationEClass.getESuperTypes().add(theMOAOPackage.getMOAO());
		shopItemDescriptionEClass.getESuperTypes().add(this.getShopItemInformation());
		shopItemURLEClass.getESuperTypes().add(this.getShopItemInformation());
		shopInformationEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		shopURLEClass.getESuperTypes().add(this.getShopInformation());
		shopAddressEClass.getESuperTypes().add(this.getShopInformation());

		// Initialize classes, features, and operations; add parameters
		initEClass(shopEClass, Shop.class, "Shop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getShop_NextOrderNo(),
				theEcorePackage.getEInt(),
				"nextOrderNo", null, 0, 1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getShop_NextCustomerNo(),
				theEcorePackage.getEInt(),
				"nextCustomerNo", null, 0, 1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getShop_TmpDir(),
				theEcorePackage.getEString(),
				"tmpDir", "C:\\Windows\\Temp", 0, 1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getShop_Countries(),
				this.getCountry(),
				this.getCountry_Shop(),
				"countries", null, 0, -1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		getShop_Countries().getEKeys().add(this.getCountry_Abbreviation());
		initEReference(
				getShop_Contacts(),
				this.getContact(),
				this.getContact_Shop(),
				"contacts", null, 0, -1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getShop_ShopItems(),
				this.getShopItem(),
				this.getShopItem_Shop(),
				"shopItems", null, 0, -1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getShop_Orders(),
				this.getOrder(),
				this.getOrder_Shop(),
				"orders", null, 0, -1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		getShop_Orders().getEKeys().add(this.getOrder_No());
		initEReference(
				getShop_Customers(),
				this.getCustomer(),
				this.getCustomer_Shop(),
				"customers", null, 0, -1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getShop_CustomerGroups(),
				this.getCustomerGroup(),
				this.getCustomerGroup_Shop(),
				"customerGroups", null, 0, -1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getShop_ShopGroups(),
				this.getShopItemGroup(),
				this.getShopItemGroup_Shop(),
				"shopGroups", null, 0, -1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getShop_Infos(),
				this.getShopInformation(),
				null,
				"infos", null, 0, -1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEOperation(getShop__Save(), null, "save", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		EOperation op = initEOperation(getShop__NameLengthOK__DiagnosticChain_Map(), theEcorePackage.getEBoolean(),
				"nameLengthOK", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getEDiagnosticChain(), "diagnostics", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		EGenericType g1 = createEGenericType(this.getEMap());
		EGenericType g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(customerEClass, Customer.class, "Customer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCustomer_Shop(),
				this.getShop(),
				this.getShop_Customers(),
				"shop", null, 0, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCustomer_Contact(),
				this.getContact(),
				this.getContact_Customer(),
				"contact", null, 1, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCustomer_Orders(),
				this.getOrder(),
				this.getOrder_Customer(),
				"orders", null, 0, -1, Customer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getCustomer_Loyalty(),
				this.getCustomerType(),
				"loyalty", "BRONCE", 0, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getCustomer_LogoFileName(),
				theEcorePackage.getEString(),
				"logoFileName", null, 0, 1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(customerGroupEClass, CustomerGroup.class,
				"CustomerGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCustomerGroup_Shop(),
				this.getShop(),
				this.getShop_CustomerGroups(),
				"shop", null, 0, 1, CustomerGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCustomerGroup_Customers(),
				this.getCustomer(),
				null,
				"customers", null, 0, -1, CustomerGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(shopItemEClass, ShopItem.class, "ShopItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getShopItem_Shop(),
				this.getShop(),
				this.getShop_ShopItems(),
				"shop", null, 0, 1, ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getShopItem_Price(),
				theEcorePackage.getEFloat(),
				"price", null, 0, 1, ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getShopItem_AdvancedPrice(),
				theEcorePackage.getEString(),
				"advancedPrice", "", 0, 1, ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(
				getShopItem_OrderItems(),
				this.getOrderItem(),
				null,
				"orderItems", null, 0, -1, ShopItem.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getShopItem_ForSale(),
				theEcorePackage.getEBoolean(),
				"forSale", null, 1, 1, ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getShopItem_Information(),
				this.getShopItemInformation(),
				null,
				"information", null, 0, -1, ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getShopItem_Group(),
				this.getShopItemGroup(),
				this.getShopItemGroup_Item(),
				"group", null, 0, 1, ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getShopItem_Locations(),
				theEcorePackage.getEString(),
				"locations", null, 0, -1, ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getShopItem_Properties(),
				this.getShopItemProperties(),
				this.getShopItemProperties_Item(),
				"properties", null, 0, -1, ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getShopItem__NamePriceOK__DiagnosticChain_Map(), theEcorePackage.getEBoolean(),
				"namePriceOK", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getEDiagnosticChain(), "diagnostics", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getEMap());
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getShopItem__NameOK__DiagnosticChain_Map(), theEcorePackage.getEBoolean(),
				"nameOK", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getEDiagnosticChain(), "diagnostics", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getEMap());
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(shopItemPropertiesEClass, ShopItemProperties.class,
				"ShopItemProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getShopItemProperties_Item(),
				this.getShopItem(),
				this.getShopItem_Properties(),
				"item", null, 0, 1, ShopItemProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getShopItemProperties_Value(),
				theEcorePackage.getEString(),
				"value", null, 0, 1, ShopItemProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(shopItemGroupEClass, ShopItemGroup.class,
				"ShopItemGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getShopItemGroup_Shop(),
				this.getShop(),
				this.getShop_ShopGroups(),
				"shop", null, 0, 1, ShopItemGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getShopItemGroup_Item(),
				this.getShopItem(),
				this.getShopItem_Group(),
				"item", null, 0, 1, ShopItemGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(orderEClass, Order.class, "Order", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getOrder_Shop(),
				this.getShop(),
				this.getShop_Orders(),
				"shop", null, 0, 1, Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOrder_No(),
				theEcorePackage.getEInt(),
				"no", null, 0, 1, Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOrder_Customer(),
				this.getCustomer(),
				this.getCustomer_Orders(),
				"customer", null, 1, 1, Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOrder_Price(),
				theEcorePackage.getEFloat(),
				"price", null, 0, 1, Order.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOrder_Items(),
				this.getOrderItem(),
				this.getOrderItem_Order(),
				"items", null, 0, -1, Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		getOrder_Items().getEKeys().add(this.getOrderItem_No());
		initEAttribute(
				getOrder_Discount(),
				theEcorePackage.getEFloat(),
				"discount", "0.0", 0, 1, Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(orderItemEClass, OrderItem.class,
				"OrderItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getOrderItem_Order(),
				this.getOrder(),
				this.getOrder_Items(),
				"order", null, 0, 1, OrderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOrderItem_No(),
				theEcorePackage.getEInt(),
				"no", null, 0, 1, OrderItem.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getOrderItem_Item(),
				this.getShopItem(),
				null,
				"item", null, 1, 1, OrderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getOrderItem_Count(),
				theEcorePackage.getEInt(),
				"count", "1", 0, 1, OrderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getOrderItem_Id(),
				theEcorePackage.getEString(),
				"id", null, 0, 1, OrderItem.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(contactEClass, Contact.class, "Contact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getContact_Shop(),
				this.getShop(),
				this.getShop_Contacts(),
				"shop", null, 0, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getContact_Address(),
				theEcorePackage.getEString(),
				"address", "", 0, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getContact_City(),
				theEcorePackage.getEString(),
				"city", null, 1, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getContact_Zip(),
				theEcorePackage.getEString(),
				"zip", null, 0, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getContact_Country(),
				this.getCountry(),
				this.getCountry_Contacts(),
				"country", null, 1, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getContact_Customer(),
				this.getCustomer(),
				this.getCustomer_Contact(),
				"customer", null, 0, 1, Contact.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getContact_Newsletter(),
				theEcorePackage.getEBoolean(),
				"newsletter", "true", 1, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(
				getContact_Birthday(),
				this.getEDate(),
				"birthday", null, 1, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(countryEClass, Country.class, "Country", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getCountry_Shop(),
				this.getShop(),
				this.getShop_Countries(),
				"shop", null, 0, 1, Country.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getCountry_Abbreviation(),
				theEcorePackage.getEString(),
				"abbreviation", null, 0, 1, Country.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCountry_Contacts(),
				this.getContact(),
				this.getContact_Country(),
				"contacts", null, 0, -1, Country.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getCountry_Information(),
				this.getCountryInfo(),
				null,
				"information", null, 0, 1, Country.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getCountry__AbbreviationLengthOK__DiagnosticChain_Map(), theEcorePackage.getEBoolean(),
				"abbreviationLengthOK", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getEDiagnosticChain(), "diagnostics", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getEMap());
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		op = initEOperation(getCountry__AbbreviationCaseOK__DiagnosticChain_Map(), theEcorePackage.getEBoolean(),
				"abbreviationCaseOK", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getEDiagnosticChain(), "diagnostics", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(this.getEMap());
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theEcorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, !IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(countryInfoEClass, CountryInfo.class,
				"CountryInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getCountryInfo_Population(),
				theEcorePackage.getEInt(),
				"population", null, 0, 1, CountryInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getCountryInfo_Currency(),
				theEcorePackage.getEString(),
				"currency", null, 0, 1, CountryInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(shopItemInformationEClass, ShopItemInformation.class,
				"ShopItemInformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(shopItemDescriptionEClass, ShopItemDescription.class,
				"ShopItemDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(shopItemURLEClass, ShopItemURL.class,
				"ShopItemURL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getShopItemURL_Url(),
				theEcorePackage.getEString(),
				"url", null, 0, 1, ShopItemURL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(shopInformationEClass, ShopInformation.class,
				"ShopInformation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getShopInformation_Value(),
				theEcorePackage.getEString(),
				"value", null, 0, 1, ShopInformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(shopURLEClass, ShopURL.class, "ShopURL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getShopURL_Url(),
				theEcorePackage.getEString(),
				"url", null, 0, 1, ShopURL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(shopAddressEClass, ShopAddress.class,
				"ShopAddress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getShopAddress_Url(),
				theEcorePackage.getEString(),
				"url", null, 0, 1, ShopAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(customerTypeEEnum, CustomerType.class, "CustomerType"); //$NON-NLS-1$
		addEEnumLiteral(customerTypeEEnum, CustomerType.BRONCE);
		addEEnumLiteral(customerTypeEEnum, CustomerType.SILVER);
		addEEnumLiteral(customerTypeEEnum, CustomerType.GOLD);

		// Initialize data types
		initEDataType(eDiagnosticChainEDataType, DiagnosticChain.class,
				"EDiagnosticChain", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(eMapEDataType, Map.class, "EMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(eDateEDataType, Date.class, "EDate", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
		// http://www.eclipse.org/emf/2011/Xcore
		createXcoreAnnotations();
		// http://rcp-company.com/schemas/uibindings
		createUibindingsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel"; //$NON-NLS-1$		
		addAnnotation(this, source, new String[] { "basePackage", "com.rcpcompany.uibindings.tests", //$NON-NLS-1$ //$NON-NLS-2$
				"nonNLSMarkers", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"classPackageSuffix", "internal", //$NON-NLS-1$ //$NON-NLS-2$
				"adapterFactory", "false", //$NON-NLS-1$ //$NON-NLS-2$
				"classNamePattern", "{0}Impl", //$NON-NLS-1$ //$NON-NLS-2$
				"interfaceNamePattern", "{0}", //$NON-NLS-1$ //$NON-NLS-2$
				"suppressEMFModelTags", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"fileExtensions", "shop", //$NON-NLS-1$ //$NON-NLS-2$
				"suppressGenModelAnnotations", "false", //$NON-NLS-1$ //$NON-NLS-2$
				"language", "", //$NON-NLS-1$ //$NON-NLS-2$
				"prefix", "Shop", //$NON-NLS-1$ //$NON-NLS-2$
				"modelName", "Shop", //$NON-NLS-1$ //$NON-NLS-2$
				"codeFormatting", "true", //$NON-NLS-1$ //$NON-NLS-2$
				"redirection", "", //$NON-NLS-1$ //$NON-NLS-2$
				"updateClasspath", "false" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOrder_No(), source, new String[] { "suppressedSetVisibility", "true" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(getOrder_Price(), source, new String[] { "suppressedSetVisibility", "true" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2011/Xcore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2011/Xcore"; //$NON-NLS-1$			
		addAnnotation(this, source, new String[] { "uibindings", "http://rcp-company.com/schemas/uibindings" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

	/**
	 * Initializes the annotations for <b>http://rcp-company.com/schemas/uibindings</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUibindingsAnnotations() {
		String source = "http://rcp-company.com/schemas/uibindings"; //$NON-NLS-1$						
		addAnnotation(countryEClass, source, new String[] { "featureName", "abbreviation" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

} //ShopPackageImpl
