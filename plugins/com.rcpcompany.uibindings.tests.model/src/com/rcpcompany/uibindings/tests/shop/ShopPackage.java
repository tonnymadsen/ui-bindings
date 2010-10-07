/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.rcpcompany.uibindings.moao.IMOAOPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopFactory
 * @generated
 */
public interface ShopPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "shop";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://rcp-company.com/schemas/shop.ecore";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "shop";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ShopPackage eINSTANCE = com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.impl.ShopImpl
	 * <em>Shop</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShop()
	 * @generated
	 */
	int SHOP = 0;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__MESSAGES = IMOAOPackage.NAMED_OBJECT__MESSAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__NAME = IMOAOPackage.NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__DESCRIPTION = IMOAOPackage.NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__UUID = IMOAOPackage.NAMED_OBJECT__UUID;

	/**
	 * The feature id for the '<em><b>Next Order No</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__NEXT_ORDER_NO = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Next Customer No</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__NEXT_CUSTOMER_NO = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tmp Dir</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__TMP_DIR = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Countries</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__COUNTRIES = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Contacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__CONTACTS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Shop Items</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__SHOP_ITEMS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Orders</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__ORDERS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Customers</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__CUSTOMERS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Shop Groups</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__SHOP_GROUPS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP__INFOS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Shop</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_FEATURE_COUNT = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.impl.CustomerImpl
	 * <em>Customer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.CustomerImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 1;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__MESSAGES = IMOAOPackage.MOAO__MESSAGES;

	/**
	 * The feature id for the '<em><b>Shop</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__SHOP = IMOAOPackage.MOAO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contact</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__CONTACT = IMOAOPackage.MOAO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Orders</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__ORDERS = IMOAOPackage.MOAO_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Loyalty</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__LOYALTY = IMOAOPackage.MOAO_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Logo File Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__LOGO_FILE_NAME = IMOAOPackage.MOAO_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Customer</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = IMOAOPackage.MOAO_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl
	 * <em>Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItem()
	 * @generated
	 */
	int SHOP_ITEM = 2;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__MESSAGES = IMOAOPackage.NAMED_OBJECT__MESSAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__NAME = IMOAOPackage.NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__DESCRIPTION = IMOAOPackage.NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__UUID = IMOAOPackage.NAMED_OBJECT__UUID;

	/**
	 * The feature id for the '<em><b>Shop</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__SHOP = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Price</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__PRICE = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Order Items</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__ORDER_ITEMS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>For Sale</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__FOR_SALE = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Information</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__INFORMATION = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Group</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__GROUP = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Locations</b></em>' attribute list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__LOCATIONS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM__PROPERTIES = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Item</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_FEATURE_COUNT = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemPropertiesImpl
	 * <em>Item Properties</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemPropertiesImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItemProperties()
	 * @generated
	 */
	int SHOP_ITEM_PROPERTIES = 3;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_PROPERTIES__MESSAGES = IMOAOPackage.NAMED_OBJECT__MESSAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_PROPERTIES__NAME = IMOAOPackage.NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_PROPERTIES__DESCRIPTION = IMOAOPackage.NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_PROPERTIES__UUID = IMOAOPackage.NAMED_OBJECT__UUID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_PROPERTIES__VALUE = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_PROPERTIES__ITEM = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Item Properties</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_PROPERTIES_FEATURE_COUNT = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemGroupImpl <em>Item Group</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemGroupImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItemGroup()
	 * @generated
	 */
	int SHOP_ITEM_GROUP = 4;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_GROUP__MESSAGES = IMOAOPackage.NAMED_OBJECT__MESSAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_GROUP__NAME = IMOAOPackage.NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_GROUP__DESCRIPTION = IMOAOPackage.NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_GROUP__UUID = IMOAOPackage.NAMED_OBJECT__UUID;

	/**
	 * The feature id for the '<em><b>Items</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_GROUP__ITEMS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shop</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_GROUP__SHOP = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Item Group</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_GROUP_FEATURE_COUNT = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.impl.OrderImpl
	 * <em>Order</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.OrderImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getOrder()
	 * @generated
	 */
	int ORDER = 5;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER__MESSAGES = IMOAOPackage.MOAO__MESSAGES;

	/**
	 * The feature id for the '<em><b>No</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER__NO = IMOAOPackage.MOAO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Shop</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER__SHOP = IMOAOPackage.MOAO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER__CUSTOMER = IMOAOPackage.MOAO_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Price</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER__PRICE = IMOAOPackage.MOAO_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER__ITEMS = IMOAOPackage.MOAO_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Discount</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER__DISCOUNT = IMOAOPackage.MOAO_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Order</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER_FEATURE_COUNT = IMOAOPackage.MOAO_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.impl.OrderItemImpl
	 * <em>Order Item</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.OrderItemImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getOrderItem()
	 * @generated
	 */
	int ORDER_ITEM = 6;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER_ITEM__MESSAGES = IMOAOPackage.MOAO__MESSAGES;

	/**
	 * The feature id for the '<em><b>No</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER_ITEM__NO = IMOAOPackage.MOAO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Order</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER_ITEM__ORDER = IMOAOPackage.MOAO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER_ITEM__ITEM = IMOAOPackage.MOAO_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER_ITEM__COUNT = IMOAOPackage.MOAO_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER_ITEM__ID = IMOAOPackage.MOAO_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Order Item</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ORDER_ITEM_FEATURE_COUNT = IMOAOPackage.MOAO_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl
	 * <em>Contact</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ContactImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getContact()
	 * @generated
	 */
	int CONTACT = 7;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__MESSAGES = IMOAOPackage.NAMED_OBJECT__MESSAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__NAME = IMOAOPackage.NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__DESCRIPTION = IMOAOPackage.NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__UUID = IMOAOPackage.NAMED_OBJECT__UUID;

	/**
	 * The feature id for the '<em><b>Shop</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__SHOP = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__ADDRESS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>City</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__CITY = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Zip</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__ZIP = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Country</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__COUNTRY = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Customer</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__CUSTOMER = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Newsletter</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__NEWSLETTER = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Birthday</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT__BIRTHDAY = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Contact</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTACT_FEATURE_COUNT = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.impl.CountryImpl
	 * <em>Country</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.CountryImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getCountry()
	 * @generated
	 */
	int COUNTRY = 8;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COUNTRY__MESSAGES = IMOAOPackage.NAMED_OBJECT__MESSAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COUNTRY__NAME = IMOAOPackage.NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COUNTRY__DESCRIPTION = IMOAOPackage.NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COUNTRY__UUID = IMOAOPackage.NAMED_OBJECT__UUID;

	/**
	 * The feature id for the '<em><b>Shop</b></em>' container reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COUNTRY__SHOP = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Abbreviation</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COUNTRY__ABBREVIATION = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Contacts</b></em>' reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COUNTRY__CONTACTS = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Country</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COUNTRY_FEATURE_COUNT = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemInformationImpl
	 * <em>Item Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemInformationImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItemInformation()
	 * @generated
	 */
	int SHOP_ITEM_INFORMATION = 9;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_INFORMATION__MESSAGES = IMOAOPackage.MOAO__MESSAGES;

	/**
	 * The number of structural features of the '<em>Item Information</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_INFORMATION_FEATURE_COUNT = IMOAOPackage.MOAO_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemDescriptionImpl
	 * <em>Item Description</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemDescriptionImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItemDescription()
	 * @generated
	 */
	int SHOP_ITEM_DESCRIPTION = 10;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_DESCRIPTION__MESSAGES = SHOP_ITEM_INFORMATION__MESSAGES;

	/**
	 * The number of structural features of the '<em>Item Description</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_DESCRIPTION_FEATURE_COUNT = SHOP_ITEM_INFORMATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemURLImpl
	 * <em>Item URL</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemURLImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItemURL()
	 * @generated
	 */
	int SHOP_ITEM_URL = 11;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_URL__MESSAGES = SHOP_ITEM_INFORMATION__MESSAGES;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_URL__URL = SHOP_ITEM_INFORMATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Item URL</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ITEM_URL_FEATURE_COUNT = SHOP_ITEM_INFORMATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopInformationImpl <em>Information</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopInformationImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopInformation()
	 * @generated
	 */
	int SHOP_INFORMATION = 12;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_INFORMATION__MESSAGES = IMOAOPackage.NAMED_OBJECT__MESSAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_INFORMATION__NAME = IMOAOPackage.NAMED_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_INFORMATION__DESCRIPTION = IMOAOPackage.NAMED_OBJECT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_INFORMATION__UUID = IMOAOPackage.NAMED_OBJECT__UUID;

	/**
	 * The number of structural features of the '<em>Information</em>' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_INFORMATION_FEATURE_COUNT = IMOAOPackage.NAMED_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.impl.ShopURLImpl
	 * <em>URL</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopURLImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopURL()
	 * @generated
	 */
	int SHOP_URL = 13;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_URL__MESSAGES = SHOP_INFORMATION__MESSAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_URL__NAME = SHOP_INFORMATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_URL__DESCRIPTION = SHOP_INFORMATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_URL__UUID = SHOP_INFORMATION__UUID;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_URL__URL = SHOP_INFORMATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>URL</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_URL_FEATURE_COUNT = SHOP_INFORMATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.impl.ShopAddressImpl
	 * <em>Address</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopAddressImpl
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopAddress()
	 * @generated
	 */
	int SHOP_ADDRESS = 14;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ADDRESS__MESSAGES = SHOP_INFORMATION__MESSAGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ADDRESS__NAME = SHOP_INFORMATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ADDRESS__DESCRIPTION = SHOP_INFORMATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Uuid</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ADDRESS__UUID = SHOP_INFORMATION__UUID;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ADDRESS__URL = SHOP_INFORMATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Address</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SHOP_ADDRESS_FEATURE_COUNT = SHOP_INFORMATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.rcpcompany.uibindings.tests.shop.CustomerType
	 * <em>Customer Type</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.rcpcompany.uibindings.tests.shop.CustomerType
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getCustomerType()
	 * @generated
	 */
	int CUSTOMER_TYPE = 15;

	/**
	 * The meta object id for the '<em>Diagnostic Chain</em>' data type. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.common.util.DiagnosticChain
	 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getDiagnosticChain()
	 * @generated
	 */
	int DIAGNOSTIC_CHAIN = 16;

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.Shop
	 * <em>Shop</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Shop</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop
	 * @generated
	 */
	EClass getShop();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getNextOrderNo <em>Next Order No</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Next Order No</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getNextOrderNo()
	 * @see #getShop()
	 * @generated
	 */
	EAttribute getShop_NextOrderNo();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getNextCustomerNo <em>Next Customer No</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Next Customer No</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getNextCustomerNo()
	 * @see #getShop()
	 * @generated
	 */
	EAttribute getShop_NextCustomerNo();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getTmpDir <em>Tmp Dir</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Tmp Dir</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getTmpDir()
	 * @see #getShop()
	 * @generated
	 */
	EAttribute getShop_TmpDir();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getCountries <em>Countries</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Countries</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getCountries()
	 * @see #getShop()
	 * @generated
	 */
	EReference getShop_Countries();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getContacts <em>Contacts</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Contacts</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getContacts()
	 * @see #getShop()
	 * @generated
	 */
	EReference getShop_Contacts();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getShopItems <em>Shop Items</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Shop Items</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getShopItems()
	 * @see #getShop()
	 * @generated
	 */
	EReference getShop_ShopItems();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getOrders <em>Orders</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Orders</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getOrders()
	 * @see #getShop()
	 * @generated
	 */
	EReference getShop_Orders();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getCustomers <em>Customers</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Customers</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getCustomers()
	 * @see #getShop()
	 * @generated
	 */
	EReference getShop_Customers();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getShopGroups <em>Shop Groups</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Shop Groups</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getShopGroups()
	 * @see #getShop()
	 * @generated
	 */
	EReference getShop_ShopGroups();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getInfos <em>Infos</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Infos</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getInfos()
	 * @see #getShop()
	 * @generated
	 */
	EReference getShop_Infos();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.Customer
	 * <em>Customer</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.Customer#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Shop</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Customer#getShop()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Shop();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.Customer#getContact <em>Contact</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Contact</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Customer#getContact()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Contact();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.Customer#getOrders <em>Orders</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Orders</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Customer#getOrders()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Orders();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Customer#getLoyalty <em>Loyalty</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Loyalty</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Customer#getLoyalty()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Loyalty();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Customer#getLogoFileName <em>Logo File Name</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Logo File Name</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Customer#getLogoFileName()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_LogoFileName();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.ShopItem
	 * <em>Item</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Item</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem
	 * @generated
	 */
	EClass getShopItem();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItem#getPrice <em>Price</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Price</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getPrice()
	 * @see #getShopItem()
	 * @generated
	 */
	EAttribute getShopItem_Price();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItem#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Shop</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getShop()
	 * @see #getShopItem()
	 * @generated
	 */
	EReference getShopItem_Shop();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItem#getOrderItems <em>Order Items</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Order Items</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getOrderItems()
	 * @see #getShopItem()
	 * @generated
	 */
	EReference getShopItem_OrderItems();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItem#isForSale <em>For Sale</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>For Sale</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#isForSale()
	 * @see #getShopItem()
	 * @generated
	 */
	EAttribute getShopItem_ForSale();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItem#getInformation <em>Information</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Information</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getInformation()
	 * @see #getShopItem()
	 * @generated
	 */
	EReference getShopItem_Information();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItem#getGroup <em>Group</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Group</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getGroup()
	 * @see #getShopItem()
	 * @generated
	 */
	EReference getShopItem_Group();

	/**
	 * Returns the meta object for the attribute list '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItem#getLocations <em>Locations</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Locations</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getLocations()
	 * @see #getShopItem()
	 * @generated
	 */
	EAttribute getShopItem_Locations();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItem#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItem#getProperties()
	 * @see #getShopItem()
	 * @generated
	 */
	EReference getShopItem_Properties();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemProperties <em>Item Properties</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Item Properties</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemProperties
	 * @generated
	 */
	EClass getShopItemProperties();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemProperties#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemProperties#getValue()
	 * @see #getShopItemProperties()
	 * @generated
	 */
	EAttribute getShopItemProperties_Value();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemProperties#getItem <em>Item</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Item</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemProperties#getItem()
	 * @see #getShopItemProperties()
	 * @generated
	 */
	EReference getShopItemProperties_Item();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup
	 * <em>Item Group</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Item Group</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemGroup
	 * @generated
	 */
	EClass getShopItemGroup();

	/**
	 * Returns the meta object for the reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getItems <em>Items</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Items</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getItems()
	 * @see #getShopItemGroup()
	 * @generated
	 */
	EReference getShopItemGroup_Items();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Shop</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemGroup#getShop()
	 * @see #getShopItemGroup()
	 * @generated
	 */
	EReference getShopItemGroup_Shop();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.Order
	 * <em>Order</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Order</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Order
	 * @generated
	 */
	EClass getOrder();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Order#getNo <em>No</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>No</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Order#getNo()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_No();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.Order#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Shop</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Order#getShop()
	 * @see #getOrder()
	 * @generated
	 */
	EReference getOrder_Shop();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.Order#getCustomer <em>Customer</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Customer</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Order#getCustomer()
	 * @see #getOrder()
	 * @generated
	 */
	EReference getOrder_Customer();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Order#getPrice <em>Price</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Price</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Order#getPrice()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_Price();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link com.rcpcompany.uibindings.tests.shop.Order#getItems <em>Items</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Order#getItems()
	 * @see #getOrder()
	 * @generated
	 */
	EReference getOrder_Items();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Order#getDiscount <em>Discount</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Discount</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Order#getDiscount()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_Discount();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.OrderItem
	 * <em>Order Item</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Order Item</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.OrderItem
	 * @generated
	 */
	EClass getOrderItem();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.OrderItem#getNo <em>No</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>No</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.OrderItem#getNo()
	 * @see #getOrderItem()
	 * @generated
	 */
	EAttribute getOrderItem_No();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.OrderItem#getOrder <em>Order</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Order</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.OrderItem#getOrder()
	 * @see #getOrderItem()
	 * @generated
	 */
	EReference getOrderItem_Order();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.OrderItem#getItem <em>Item</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Item</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.OrderItem#getItem()
	 * @see #getOrderItem()
	 * @generated
	 */
	EReference getOrderItem_Item();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.OrderItem#getCount <em>Count</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.OrderItem#getCount()
	 * @see #getOrderItem()
	 * @generated
	 */
	EAttribute getOrderItem_Count();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.OrderItem#getId <em>Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.OrderItem#getId()
	 * @see #getOrderItem()
	 * @generated
	 */
	EAttribute getOrderItem_Id();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.Contact
	 * <em>Contact</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Contact</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Contact
	 * @generated
	 */
	EClass getContact();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Contact#getAddress <em>Address</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#getAddress()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Address();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Contact#getCity <em>City</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>City</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#getCity()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_City();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Contact#getZip <em>Zip</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Zip</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#getZip()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Zip();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.Contact#getCountry <em>Country</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Country</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#getCountry()
	 * @see #getContact()
	 * @generated
	 */
	EReference getContact_Country();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.Contact#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Shop</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#getShop()
	 * @see #getContact()
	 * @generated
	 */
	EReference getContact_Shop();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.Contact#getCustomer <em>Customer</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Customer</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#getCustomer()
	 * @see #getContact()
	 * @generated
	 */
	EReference getContact_Customer();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Contact#isNewsletter <em>Newsletter</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Newsletter</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#isNewsletter()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Newsletter();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Contact#getBirthday <em>Birthday</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Birthday</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#getBirthday()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Birthday();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.Country
	 * <em>Country</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Country</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Country
	 * @generated
	 */
	EClass getCountry();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.Country#getAbbreviation <em>Abbreviation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Abbreviation</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Country#getAbbreviation()
	 * @see #getCountry()
	 * @generated
	 */
	EAttribute getCountry_Abbreviation();

	/**
	 * Returns the meta object for the reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.Country#getContacts <em>Contacts</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Contacts</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Country#getContacts()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_Contacts();

	/**
	 * Returns the meta object for the container reference '
	 * {@link com.rcpcompany.uibindings.tests.shop.Country#getShop <em>Shop</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Shop</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.Country#getShop()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_Shop();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemInformation <em>Item Information</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Item Information</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemInformation
	 * @generated
	 */
	EClass getShopItemInformation();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemDescription <em>Item Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Item Description</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemDescription
	 * @generated
	 */
	EClass getShopItemDescription();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.ShopItemURL
	 * <em>Item URL</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Item URL</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemURL
	 * @generated
	 */
	EClass getShopItemURL();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopItemURL#getUrl <em>Url</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopItemURL#getUrl()
	 * @see #getShopItemURL()
	 * @generated
	 */
	EAttribute getShopItemURL_Url();

	/**
	 * Returns the meta object for class '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopInformation <em>Information</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Information</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopInformation
	 * @generated
	 */
	EClass getShopInformation();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.ShopURL
	 * <em>URL</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>URL</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopURL
	 * @generated
	 */
	EClass getShopURL();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopURL#getUrl <em>Url</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopURL#getUrl()
	 * @see #getShopURL()
	 * @generated
	 */
	EAttribute getShopURL_Url();

	/**
	 * Returns the meta object for class '{@link com.rcpcompany.uibindings.tests.shop.ShopAddress
	 * <em>Address</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Address</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopAddress
	 * @generated
	 */
	EClass getShopAddress();

	/**
	 * Returns the meta object for the attribute '
	 * {@link com.rcpcompany.uibindings.tests.shop.ShopAddress#getUrl <em>Url</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopAddress#getUrl()
	 * @see #getShopAddress()
	 * @generated
	 */
	EAttribute getShopAddress_Url();

	/**
	 * Returns the meta object for enum '{@link com.rcpcompany.uibindings.tests.shop.CustomerType
	 * <em>Customer Type</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Customer Type</em>'.
	 * @see com.rcpcompany.uibindings.tests.shop.CustomerType
	 * @generated
	 */
	EEnum getCustomerType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.DiagnosticChain
	 * <em>Diagnostic Chain</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Diagnostic Chain</em>'.
	 * @see org.eclipse.emf.common.util.DiagnosticChain
	 * @generated
	 */
	EDataType getDiagnosticChain();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ShopFactory getShopFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopImpl <em>Shop</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShop()
		 * @generated
		 */
		EClass SHOP = eINSTANCE.getShop();

		/**
		 * The meta object literal for the '<em><b>Next Order No</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SHOP__NEXT_ORDER_NO = eINSTANCE.getShop_NextOrderNo();

		/**
		 * The meta object literal for the '<em><b>Next Customer No</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SHOP__NEXT_CUSTOMER_NO = eINSTANCE.getShop_NextCustomerNo();

		/**
		 * The meta object literal for the '<em><b>Tmp Dir</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SHOP__TMP_DIR = eINSTANCE.getShop_TmpDir();

		/**
		 * The meta object literal for the '<em><b>Countries</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP__COUNTRIES = eINSTANCE.getShop_Countries();

		/**
		 * The meta object literal for the '<em><b>Contacts</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP__CONTACTS = eINSTANCE.getShop_Contacts();

		/**
		 * The meta object literal for the '<em><b>Shop Items</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP__SHOP_ITEMS = eINSTANCE.getShop_ShopItems();

		/**
		 * The meta object literal for the '<em><b>Orders</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP__ORDERS = eINSTANCE.getShop_Orders();

		/**
		 * The meta object literal for the '<em><b>Customers</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP__CUSTOMERS = eINSTANCE.getShop_Customers();

		/**
		 * The meta object literal for the '<em><b>Shop Groups</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP__SHOP_GROUPS = eINSTANCE.getShop_ShopGroups();

		/**
		 * The meta object literal for the '<em><b>Infos</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP__INFOS = eINSTANCE.getShop_Infos();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.CustomerImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em><b>Shop</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CUSTOMER__SHOP = eINSTANCE.getCustomer_Shop();

		/**
		 * The meta object literal for the '<em><b>Contact</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CUSTOMER__CONTACT = eINSTANCE.getCustomer_Contact();

		/**
		 * The meta object literal for the '<em><b>Orders</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CUSTOMER__ORDERS = eINSTANCE.getCustomer_Orders();

		/**
		 * The meta object literal for the '<em><b>Loyalty</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CUSTOMER__LOYALTY = eINSTANCE.getCustomer_Loyalty();

		/**
		 * The meta object literal for the '<em><b>Logo File Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CUSTOMER__LOGO_FILE_NAME = eINSTANCE.getCustomer_LogoFileName();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl <em>Item</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItem()
		 * @generated
		 */
		EClass SHOP_ITEM = eINSTANCE.getShopItem();

		/**
		 * The meta object literal for the '<em><b>Price</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SHOP_ITEM__PRICE = eINSTANCE.getShopItem_Price();

		/**
		 * The meta object literal for the '<em><b>Shop</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP_ITEM__SHOP = eINSTANCE.getShopItem_Shop();

		/**
		 * The meta object literal for the '<em><b>Order Items</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP_ITEM__ORDER_ITEMS = eINSTANCE.getShopItem_OrderItems();

		/**
		 * The meta object literal for the '<em><b>For Sale</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SHOP_ITEM__FOR_SALE = eINSTANCE.getShopItem_ForSale();

		/**
		 * The meta object literal for the '<em><b>Information</b></em>' containment reference
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP_ITEM__INFORMATION = eINSTANCE.getShopItem_Information();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP_ITEM__GROUP = eINSTANCE.getShopItem_Group();

		/**
		 * The meta object literal for the '<em><b>Locations</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SHOP_ITEM__LOCATIONS = eINSTANCE.getShopItem_Locations();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP_ITEM__PROPERTIES = eINSTANCE.getShopItem_Properties();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemPropertiesImpl
		 * <em>Item Properties</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemPropertiesImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItemProperties()
		 * @generated
		 */
		EClass SHOP_ITEM_PROPERTIES = eINSTANCE.getShopItemProperties();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SHOP_ITEM_PROPERTIES__VALUE = eINSTANCE.getShopItemProperties_Value();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP_ITEM_PROPERTIES__ITEM = eINSTANCE.getShopItemProperties_Item();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemGroupImpl <em>Item Group</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemGroupImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItemGroup()
		 * @generated
		 */
		EClass SHOP_ITEM_GROUP = eINSTANCE.getShopItemGroup();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP_ITEM_GROUP__ITEMS = eINSTANCE.getShopItemGroup_Items();

		/**
		 * The meta object literal for the '<em><b>Shop</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SHOP_ITEM_GROUP__SHOP = eINSTANCE.getShopItemGroup_Shop();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.OrderImpl <em>Order</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.OrderImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getOrder()
		 * @generated
		 */
		EClass ORDER = eINSTANCE.getOrder();

		/**
		 * The meta object literal for the '<em><b>No</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ORDER__NO = eINSTANCE.getOrder_No();

		/**
		 * The meta object literal for the '<em><b>Shop</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ORDER__SHOP = eINSTANCE.getOrder_Shop();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ORDER__CUSTOMER = eINSTANCE.getOrder_Customer();

		/**
		 * The meta object literal for the '<em><b>Price</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ORDER__PRICE = eINSTANCE.getOrder_Price();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ORDER__ITEMS = eINSTANCE.getOrder_Items();

		/**
		 * The meta object literal for the '<em><b>Discount</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ORDER__DISCOUNT = eINSTANCE.getOrder_Discount();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.OrderItemImpl <em>Order Item</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.OrderItemImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getOrderItem()
		 * @generated
		 */
		EClass ORDER_ITEM = eINSTANCE.getOrderItem();

		/**
		 * The meta object literal for the '<em><b>No</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ORDER_ITEM__NO = eINSTANCE.getOrderItem_No();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ORDER_ITEM__ORDER = eINSTANCE.getOrderItem_Order();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ORDER_ITEM__ITEM = eINSTANCE.getOrderItem_Item();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ORDER_ITEM__COUNT = eINSTANCE.getOrderItem_Count();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ORDER_ITEM__ID = eINSTANCE.getOrderItem_Id();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl <em>Contact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ContactImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getContact()
		 * @generated
		 */
		EClass CONTACT = eINSTANCE.getContact();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONTACT__ADDRESS = eINSTANCE.getContact_Address();

		/**
		 * The meta object literal for the '<em><b>City</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONTACT__CITY = eINSTANCE.getContact_City();

		/**
		 * The meta object literal for the '<em><b>Zip</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONTACT__ZIP = eINSTANCE.getContact_Zip();

		/**
		 * The meta object literal for the '<em><b>Country</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTACT__COUNTRY = eINSTANCE.getContact_Country();

		/**
		 * The meta object literal for the '<em><b>Shop</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTACT__SHOP = eINSTANCE.getContact_Shop();

		/**
		 * The meta object literal for the '<em><b>Customer</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTACT__CUSTOMER = eINSTANCE.getContact_Customer();

		/**
		 * The meta object literal for the '<em><b>Newsletter</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONTACT__NEWSLETTER = eINSTANCE.getContact_Newsletter();

		/**
		 * The meta object literal for the '<em><b>Birthday</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CONTACT__BIRTHDAY = eINSTANCE.getContact_Birthday();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.CountryImpl <em>Country</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.CountryImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getCountry()
		 * @generated
		 */
		EClass COUNTRY = eINSTANCE.getCountry();

		/**
		 * The meta object literal for the '<em><b>Abbreviation</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COUNTRY__ABBREVIATION = eINSTANCE.getCountry_Abbreviation();

		/**
		 * The meta object literal for the '<em><b>Contacts</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COUNTRY__CONTACTS = eINSTANCE.getCountry_Contacts();

		/**
		 * The meta object literal for the '<em><b>Shop</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COUNTRY__SHOP = eINSTANCE.getCountry_Shop();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemInformationImpl
		 * <em>Item Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemInformationImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItemInformation()
		 * @generated
		 */
		EClass SHOP_ITEM_INFORMATION = eINSTANCE.getShopItemInformation();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemDescriptionImpl
		 * <em>Item Description</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemDescriptionImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItemDescription()
		 * @generated
		 */
		EClass SHOP_ITEM_DESCRIPTION = eINSTANCE.getShopItemDescription();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemURLImpl <em>Item URL</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopItemURLImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopItemURL()
		 * @generated
		 */
		EClass SHOP_ITEM_URL = eINSTANCE.getShopItemURL();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SHOP_ITEM_URL__URL = eINSTANCE.getShopItemURL_Url();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopInformationImpl
		 * <em>Information</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopInformationImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopInformation()
		 * @generated
		 */
		EClass SHOP_INFORMATION = eINSTANCE.getShopInformation();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopURLImpl <em>URL</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopURLImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopURL()
		 * @generated
		 */
		EClass SHOP_URL = eINSTANCE.getShopURL();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SHOP_URL__URL = eINSTANCE.getShopURL_Url();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.impl.ShopAddressImpl <em>Address</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopAddressImpl
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getShopAddress()
		 * @generated
		 */
		EClass SHOP_ADDRESS = eINSTANCE.getShopAddress();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SHOP_ADDRESS__URL = eINSTANCE.getShopAddress_Url();

		/**
		 * The meta object literal for the '
		 * {@link com.rcpcompany.uibindings.tests.shop.CustomerType <em>Customer Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.rcpcompany.uibindings.tests.shop.CustomerType
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getCustomerType()
		 * @generated
		 */
		EEnum CUSTOMER_TYPE = eINSTANCE.getCustomerType();

		/**
		 * The meta object literal for the '<em>Diagnostic Chain</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.emf.common.util.DiagnosticChain
		 * @see com.rcpcompany.uibindings.tests.shop.impl.ShopPackageImpl#getDiagnosticChain()
		 * @generated
		 */
		EDataType DIAGNOSTIC_CHAIN = eINSTANCE.getDiagnosticChain();

	}

} // ShopPackage
