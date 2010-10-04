/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop.impl;

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

import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Customer;
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

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ShopPackageImpl extends EPackageImpl implements ShopPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass shopEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass customerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass shopItemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass shopItemPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass shopItemGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass orderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass orderItemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass contactEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass countryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass shopItemInformationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass shopItemDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass shopItemURLEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass shopInformationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass shopURLEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass shopAddressEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum customerTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType diagnosticChainEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
	 * value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init
	 * init()}, which also performs initialization of the package, or returns the registered
	 * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ShopPackageImpl() {
		super(eNS_URI, ShopFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
	 * upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link ShopPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to
	 * obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ShopPackage init() {
		if (isInited) return (ShopPackage) EPackage.Registry.INSTANCE.getEPackage(ShopPackage.eNS_URI);

		// Obtain or create and register package
		final ShopPackageImpl theShopPackage = (ShopPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ShopPackageImpl ? EPackage.Registry.INSTANCE
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
			@Override
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getShop() {
		return shopEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getShop_NextOrderNo() {
		return (EAttribute) shopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getShop_NextCustomerNo() {
		return (EAttribute) shopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getShop_TmpDir() {
		return (EAttribute) shopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShop_Countries() {
		return (EReference) shopEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShop_Contacts() {
		return (EReference) shopEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShop_ShopItems() {
		return (EReference) shopEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShop_Orders() {
		return (EReference) shopEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShop_Customers() {
		return (EReference) shopEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShop_ShopGroups() {
		return (EReference) shopEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShop_Infos() {
		return (EReference) shopEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getCustomer() {
		return customerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCustomer_Shop() {
		return (EReference) customerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCustomer_Contact() {
		return (EReference) customerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCustomer_Orders() {
		return (EReference) customerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getCustomer_Loyalty() {
		return (EAttribute) customerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getCustomer_LogoFileName() {
		return (EAttribute) customerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getShopItem() {
		return shopItemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getShopItem_Price() {
		return (EAttribute) shopItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShopItem_Shop() {
		return (EReference) shopItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShopItem_OrderItems() {
		return (EReference) shopItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getShopItem_ForSale() {
		return (EAttribute) shopItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShopItem_Information() {
		return (EReference) shopItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShopItem_Group() {
		return (EReference) shopItemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getShopItem_Locations() {
		return (EAttribute) shopItemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShopItem_Properties() {
		return (EReference) shopItemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getShopItemProperties() {
		return shopItemPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getShopItemProperties_Value() {
		return (EAttribute) shopItemPropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShopItemProperties_Item() {
		return (EReference) shopItemPropertiesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getShopItemGroup() {
		return shopItemGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShopItemGroup_Items() {
		return (EReference) shopItemGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getShopItemGroup_Shop() {
		return (EReference) shopItemGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getOrder() {
		return orderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getOrder_No() {
		return (EAttribute) orderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getOrder_Shop() {
		return (EReference) orderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getOrder_Customer() {
		return (EReference) orderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getOrder_Price() {
		return (EAttribute) orderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getOrder_Items() {
		return (EReference) orderEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getOrderItem() {
		return orderItemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getOrderItem_No() {
		return (EAttribute) orderItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getOrderItem_Order() {
		return (EReference) orderItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getOrderItem_Item() {
		return (EReference) orderItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getOrderItem_Count() {
		return (EAttribute) orderItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getOrderItem_Id() {
		return (EAttribute) orderItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getContact() {
		return contactEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getContact_Address() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getContact_City() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getContact_Zip() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getContact_Country() {
		return (EReference) contactEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getContact_Shop() {
		return (EReference) contactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getContact_Customer() {
		return (EReference) contactEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getContact_Newsletter() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getContact_Birthday() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getCountry() {
		return countryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getCountry_Abbreviation() {
		return (EAttribute) countryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCountry_Contacts() {
		return (EReference) countryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EReference getCountry_Shop() {
		return (EReference) countryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getShopItemInformation() {
		return shopItemInformationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getShopItemDescription() {
		return shopItemDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getShopItemURL() {
		return shopItemURLEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getShopItemURL_Url() {
		return (EAttribute) shopItemURLEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getShopInformation() {
		return shopInformationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getShopURL() {
		return shopURLEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getShopURL_Url() {
		return (EAttribute) shopURLEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EClass getShopAddress() {
		return shopAddressEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EAttribute getShopAddress_Url() {
		return (EAttribute) shopAddressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EEnum getCustomerType() {
		return customerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EDataType getDiagnosticChain() {
		return diagnosticChainEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ShopFactory getShopFactory() {
		return (ShopFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on
	 * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		createEReference(shopEClass, SHOP__SHOP_GROUPS);
		createEReference(shopEClass, SHOP__INFOS);

		customerEClass = createEClass(CUSTOMER);
		createEReference(customerEClass, CUSTOMER__SHOP);
		createEReference(customerEClass, CUSTOMER__CONTACT);
		createEReference(customerEClass, CUSTOMER__ORDERS);
		createEAttribute(customerEClass, CUSTOMER__LOYALTY);
		createEAttribute(customerEClass, CUSTOMER__LOGO_FILE_NAME);

		shopItemEClass = createEClass(SHOP_ITEM);
		createEReference(shopItemEClass, SHOP_ITEM__SHOP);
		createEAttribute(shopItemEClass, SHOP_ITEM__PRICE);
		createEReference(shopItemEClass, SHOP_ITEM__ORDER_ITEMS);
		createEAttribute(shopItemEClass, SHOP_ITEM__FOR_SALE);
		createEReference(shopItemEClass, SHOP_ITEM__INFORMATION);
		createEReference(shopItemEClass, SHOP_ITEM__GROUP);
		createEAttribute(shopItemEClass, SHOP_ITEM__LOCATIONS);
		createEReference(shopItemEClass, SHOP_ITEM__PROPERTIES);

		shopItemPropertiesEClass = createEClass(SHOP_ITEM_PROPERTIES);
		createEAttribute(shopItemPropertiesEClass, SHOP_ITEM_PROPERTIES__VALUE);
		createEReference(shopItemPropertiesEClass, SHOP_ITEM_PROPERTIES__ITEM);

		shopItemGroupEClass = createEClass(SHOP_ITEM_GROUP);
		createEReference(shopItemGroupEClass, SHOP_ITEM_GROUP__ITEMS);
		createEReference(shopItemGroupEClass, SHOP_ITEM_GROUP__SHOP);

		orderEClass = createEClass(ORDER);
		createEAttribute(orderEClass, ORDER__NO);
		createEReference(orderEClass, ORDER__SHOP);
		createEReference(orderEClass, ORDER__CUSTOMER);
		createEAttribute(orderEClass, ORDER__PRICE);
		createEReference(orderEClass, ORDER__ITEMS);

		orderItemEClass = createEClass(ORDER_ITEM);
		createEAttribute(orderItemEClass, ORDER_ITEM__NO);
		createEReference(orderItemEClass, ORDER_ITEM__ORDER);
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

		shopItemInformationEClass = createEClass(SHOP_ITEM_INFORMATION);

		shopItemDescriptionEClass = createEClass(SHOP_ITEM_DESCRIPTION);

		shopItemURLEClass = createEClass(SHOP_ITEM_URL);
		createEAttribute(shopItemURLEClass, SHOP_ITEM_URL__URL);

		shopInformationEClass = createEClass(SHOP_INFORMATION);

		shopURLEClass = createEClass(SHOP_URL);
		createEAttribute(shopURLEClass, SHOP_URL__URL);

		shopAddressEClass = createEClass(SHOP_ADDRESS);
		createEAttribute(shopAddressEClass, SHOP_ADDRESS__URL);

		// Create enums
		customerTypeEEnum = createEEnum(CUSTOMER_TYPE);

		// Create data types
		diagnosticChainEDataType = createEDataType(DIAGNOSTIC_CHAIN);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have
	 * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		final IMOAOPackage theMOAOPackage = (IMOAOPackage) EPackage.Registry.INSTANCE.getEPackage(IMOAOPackage.eNS_URI);
		final EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		shopEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		customerEClass.getESuperTypes().add(theMOAOPackage.getMOAO());
		shopItemEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		shopItemPropertiesEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		shopItemGroupEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		orderEClass.getESuperTypes().add(theMOAOPackage.getMOAO());
		orderItemEClass.getESuperTypes().add(theMOAOPackage.getMOAO());
		contactEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		countryEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		shopItemInformationEClass.getESuperTypes().add(theMOAOPackage.getMOAO());
		shopItemDescriptionEClass.getESuperTypes().add(this.getShopItemInformation());
		shopItemURLEClass.getESuperTypes().add(this.getShopItemInformation());
		shopInformationEClass.getESuperTypes().add(theMOAOPackage.getNamedObject());
		shopURLEClass.getESuperTypes().add(this.getShopInformation());
		shopAddressEClass.getESuperTypes().add(this.getShopInformation());

		// Initialize classes and features; add operations and parameters
		initEClass(shopEClass, Shop.class, "Shop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShop_NextOrderNo(), ecorePackage.getEInt(), "nextOrderNo", null, 1, 1, Shop.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShop_NextCustomerNo(), ecorePackage.getEInt(), "nextCustomerNo", null, 1, 1, Shop.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShop_TmpDir(), ecorePackage.getEString(), "tmpDir", "C:\\Windows\\Temp", 1, 1, Shop.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShop_Countries(), this.getCountry(), this.getCountry_Shop(), "countries", null, 0, -1,
				Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getShop_Countries().getEKeys().add(this.getCountry_Abbreviation());
		initEReference(getShop_Contacts(), this.getContact(), this.getContact_Shop(), "contacts", null, 0, -1,
				Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShop_ShopItems(), this.getShopItem(), this.getShopItem_Shop(), "shopItems", null, 0, -1,
				Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getShop_ShopItems().getEKeys().add(theMOAOPackage.getNamedObject_Name());
		initEReference(getShop_Orders(), this.getOrder(), this.getOrder_Shop(), "orders", null, 0, -1, Shop.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getShop_Orders().getEKeys().add(this.getOrder_No());
		initEReference(getShop_Customers(), this.getCustomer(), this.getCustomer_Shop(), "customers", null, 0, -1,
				Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShop_ShopGroups(), this.getShopItemGroup(), this.getShopItemGroup_Shop(), "shopGroups", null,
				0, -1, Shop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShop_Infos(), this.getShopInformation(), null, "infos", null, 0, -1, Shop.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(shopEClass, null, "save", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(shopEClass, ecorePackage.getEBoolean(), "nameLengthOK", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, this.getDiagnosticChain(), "diagnostics", 1, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(customerEClass, Customer.class, "Customer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCustomer_Shop(), this.getShop(), this.getShop_Customers(), "shop", null, 1, 1,
				Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCustomer_Contact(), this.getContact(), this.getContact_Customer(), "contact", null, 1, 1,
				Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCustomer_Orders(), this.getOrder(), this.getOrder_Customer(), "orders", null, 0, -1,
				Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomer_Loyalty(), this.getCustomerType(), "loyalty", "BRONCE", 0, 1, Customer.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomer_LogoFileName(), ecorePackage.getEString(), "logoFileName", null, 0, 1,
				Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(shopItemEClass, ShopItem.class, "ShopItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getShopItem_Shop(), this.getShop(), this.getShop_ShopItems(), "shop", null, 1, 1,
				ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShopItem_Price(), ecorePackage.getEFloat(), "price", null, 1, 1, ShopItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShopItem_OrderItems(), this.getOrderItem(), this.getOrderItem_Item(), "orderItems", null, 0,
				-1, ShopItem.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShopItem_ForSale(), ecorePackage.getEBoolean(), "forSale", null, 1, 1, ShopItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShopItem_Information(), this.getShopItemInformation(), null, "information", null, 0, 1,
				ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShopItem_Group(), this.getShopItemGroup(), this.getShopItemGroup_Items(), "group", null, 0,
				1, ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getShopItem_Locations(), ecorePackage.getEString(), "locations", null, 0, -1, ShopItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShopItem_Properties(), this.getShopItemProperties(), this.getShopItemProperties_Item(),
				"properties", null, 0, -1, ShopItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(shopItemEClass, ecorePackage.getEBoolean(), "namePriceOK", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDiagnosticChain(), "diagnostics", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(shopItemEClass, ecorePackage.getEBoolean(), "nameOK", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDiagnosticChain(), "diagnostics", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(shopItemPropertiesEClass, ShopItemProperties.class, "ShopItemProperties", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShopItemProperties_Value(), theEcorePackage.getEString(), "value", null, 0, 1,
				ShopItemProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShopItemProperties_Item(), this.getShopItem(), this.getShopItem_Properties(), "item", null,
				0, 1, ShopItemProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getShopItemProperties_Item().getEKeys().add(theMOAOPackage.getNamedObject_Name());

		initEClass(shopItemGroupEClass, ShopItemGroup.class, "ShopItemGroup", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getShopItemGroup_Items(), this.getShopItem(), this.getShopItem_Group(), "items", null, 0, -1,
				ShopItemGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getShopItemGroup_Shop(), this.getShop(), this.getShop_ShopGroups(), "shop", null, 1, 1,
				ShopItemGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orderEClass, Order.class, "Order", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrder_No(), ecorePackage.getEInt(), "no", null, 1, 1, Order.class, !IS_TRANSIENT,
				!IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrder_Shop(), this.getShop(), this.getShop_Orders(), "shop", null, 1, 1, Order.class,
				!IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getOrder_Customer(), this.getCustomer(), this.getCustomer_Orders(), "customer", null, 0, 1,
				Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrder_Price(), ecorePackage.getEFloat(), "price", null, 1, 1, Order.class, IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrder_Items(), this.getOrderItem(), this.getOrderItem_Order(), "items", null, 0, 2,
				Order.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getOrder_Items().getEKeys().add(this.getOrderItem_No());

		initEClass(orderItemEClass, OrderItem.class, "OrderItem", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrderItem_No(), ecorePackage.getEInt(), "no", null, 1, 1, OrderItem.class, IS_TRANSIENT,
				!IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrderItem_Order(), this.getOrder(), this.getOrder_Items(), "order", null, 1, 1,
				OrderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrderItem_Item(), this.getShopItem(), this.getShopItem_OrderItems(), "item", null, 1, 1,
				OrderItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrderItem_Count(), ecorePackage.getEInt(), "count", "1", 1, 1, OrderItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrderItem_Id(), ecorePackage.getEString(), "id", null, 0, 1, OrderItem.class, IS_TRANSIENT,
				IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(contactEClass, Contact.class, "Contact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContact_Shop(), this.getShop(), this.getShop_Contacts(), "shop", null, 1, 1, Contact.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContact_Address(), ecorePackage.getEString(), "address", null, 0, 1, Contact.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContact_City(), ecorePackage.getEString(), "city", null, 1, 1, Contact.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContact_Zip(), ecorePackage.getEString(), "zip", null, 0, 1, Contact.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContact_Country(), this.getCountry(), this.getCountry_Contacts(), "country", null, 1, 1,
				Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContact_Customer(), this.getCustomer(), this.getCustomer_Contact(), "customer", null, 0, 1,
				Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContact_Newsletter(), ecorePackage.getEBoolean(), "newsletter", null, 1, 1, Contact.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContact_Birthday(), ecorePackage.getEDate(), "birthday", null, 1, 1, Contact.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(countryEClass, Country.class, "Country", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCountry_Shop(), this.getShop(), this.getShop_Countries(), "shop", null, 1, 1, Country.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCountry_Abbreviation(), ecorePackage.getEString(), "abbreviation", null, 1, 1, Country.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCountry_Contacts(), this.getContact(), this.getContact_Country(), "contacts", null, 0, -1,
				Country.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(countryEClass, ecorePackage.getEBoolean(), "abbreviationLengthOK", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, this.getDiagnosticChain(), "diagnostics", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(countryEClass, ecorePackage.getEBoolean(), "abbreviationCaseOK", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDiagnosticChain(), "diagnostics", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(shopItemInformationEClass, ShopItemInformation.class, "ShopItemInformation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shopItemDescriptionEClass, ShopItemDescription.class, "ShopItemDescription", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shopItemURLEClass, ShopItemURL.class, "ShopItemURL", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShopItemURL_Url(), ecorePackage.getEString(), "url", null, 0, 1, ShopItemURL.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shopInformationEClass, ShopInformation.class, "ShopInformation", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(shopURLEClass, ShopURL.class, "ShopURL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShopURL_Url(), ecorePackage.getEString(), "url", null, 0, 1, ShopURL.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shopAddressEClass, ShopAddress.class, "ShopAddress", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShopAddress_Url(), ecorePackage.getEString(), "url", null, 0, 1, ShopAddress.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(customerTypeEEnum, CustomerType.class, "CustomerType");
		addEEnumLiteral(customerTypeEEnum, CustomerType.BRONCE);
		addEEnumLiteral(customerTypeEEnum, CustomerType.SILVER);
		addEEnumLiteral(customerTypeEEnum, CustomerType.GOLD);

		// Initialize data types
		initEDataType(diagnosticChainEDataType, DiagnosticChain.class, "DiagnosticChain", IS_SERIALIZABLE,
				!IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://rcp-company.com/schemas/uibindings
		createUibindingsAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://rcp-company.com/schemas/uibindings</b>. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createUibindingsAnnotations() {
		final String source = "http://rcp-company.com/schemas/uibindings";
		addAnnotation(countryEClass, source, new String[] { "featureName", "abbreviation" });
	}

} // ShopPackageImpl
