/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.internal.NamedObjectImpl;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopItemInformation;
import com.rcpcompany.uibindings.tests.shop.ShopItemProperties;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.shop.util.ShopValidator;
import com.rcpcompany.uibindings.validators.EValidatorAdapter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Item</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl#getPrice <em>Price</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl#getOrderItems <em>Order Items
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl#isForSale <em>For Sale</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl#getInformation <em>Information
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl#getGroup <em>Group</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl#getLocations <em>Locations
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ShopItemImpl#getProperties <em>Properties
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ShopItemImpl extends NamedObjectImpl implements ShopItem {
	/**
	 * The default value of the '{@link #getPrice() <em>Price</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected static final float PRICE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected float price = PRICE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOrderItems() <em>Order Items</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOrderItems()
	 * @generated
	 * @ordered
	 */
	protected EList<OrderItem> orderItems;

	/**
	 * The default value of the '{@link #isForSale() <em>For Sale</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isForSale()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOR_SALE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isForSale() <em>For Sale</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isForSale()
	 * @generated
	 * @ordered
	 */
	protected boolean forSale = FOR_SALE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInformation() <em>Information</em>}' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInformation()
	 * @generated
	 * @ordered
	 */
	protected ShopItemInformation information;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected ShopItemGroup group;

	/**
	 * The cached value of the '{@link #getLocations() <em>Locations</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLocations()
	 * @generated
	 * @ordered
	 */
	protected EList<String> locations;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected ShopItemProperties properties;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ShopItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.SHOP_ITEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public float getPrice() {
		return price;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPrice(float newPrice) {
		final float oldPrice = price;
		price = newPrice;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__PRICE, oldPrice, price));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Shop getShop() {
		if (eContainerFeatureID() != ShopPackage.SHOP_ITEM__SHOP) return null;
		return (Shop) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetShop(Shop newShop, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newShop, ShopPackage.SHOP_ITEM__SHOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setShop(Shop newShop) {
		if (newShop != eInternalContainer()
				|| (eContainerFeatureID() != ShopPackage.SHOP_ITEM__SHOP && newShop != null)) {
			if (EcoreUtil.isAncestor(this, newShop))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newShop != null) {
				msgs = ((InternalEObject) newShop).eInverseAdd(this, ShopPackage.SHOP__SHOP_ITEMS, Shop.class, msgs);
			}
			msgs = basicSetShop(newShop, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__SHOP, newShop, newShop));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<OrderItem> getOrderItems() {
		if (orderItems == null) {
			orderItems = new EObjectWithInverseEList<OrderItem>(OrderItem.class, this,
					ShopPackage.SHOP_ITEM__ORDER_ITEMS, ShopPackage.ORDER_ITEM__ITEM);
		}
		return orderItems;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isForSale() {
		return forSale;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setForSale(boolean newForSale) {
		final boolean oldForSale = forSale;
		forSale = newForSale;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__FOR_SALE, oldForSale, forSale));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ShopItemInformation getInformation() {
		return information;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetInformation(ShopItemInformation newInformation, NotificationChain msgs) {
		final ShopItemInformation oldInformation = information;
		information = newInformation;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ShopPackage.SHOP_ITEM__INFORMATION, oldInformation, newInformation);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setInformation(ShopItemInformation newInformation) {
		if (newInformation != information) {
			NotificationChain msgs = null;
			if (information != null) {
				msgs = ((InternalEObject) information).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- ShopPackage.SHOP_ITEM__INFORMATION, null, msgs);
			}
			if (newInformation != null) {
				msgs = ((InternalEObject) newInformation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- ShopPackage.SHOP_ITEM__INFORMATION, null, msgs);
			}
			msgs = basicSetInformation(newInformation, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__INFORMATION, newInformation,
					newInformation));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ShopItemGroup getGroup() {
		if (group != null && group.eIsProxy()) {
			final InternalEObject oldGroup = (InternalEObject) group;
			group = (ShopItemGroup) eResolveProxy(oldGroup);
			if (group != oldGroup) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ShopPackage.SHOP_ITEM__GROUP, oldGroup,
							group));
				}
			}
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ShopItemGroup basicGetGroup() {
		return group;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGroup(ShopItemGroup newGroup, NotificationChain msgs) {
		final ShopItemGroup oldGroup = group;
		group = newGroup;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ShopPackage.SHOP_ITEM__GROUP, oldGroup, newGroup);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setGroup(ShopItemGroup newGroup) {
		if (newGroup != group) {
			NotificationChain msgs = null;
			if (group != null) {
				msgs = ((InternalEObject) group).eInverseRemove(this, ShopPackage.SHOP_ITEM_GROUP__ITEMS,
						ShopItemGroup.class, msgs);
			}
			if (newGroup != null) {
				msgs = ((InternalEObject) newGroup).eInverseAdd(this, ShopPackage.SHOP_ITEM_GROUP__ITEMS,
						ShopItemGroup.class, msgs);
			}
			msgs = basicSetGroup(newGroup, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__GROUP, newGroup, newGroup));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<String> getLocations() {
		if (locations == null) {
			locations = new EDataTypeUniqueEList<String>(String.class, this, ShopPackage.SHOP_ITEM__LOCATIONS);
		}
		return locations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ShopItemProperties getProperties() {
		if (properties != null && properties.eIsProxy()) {
			final InternalEObject oldProperties = (InternalEObject) properties;
			properties = (ShopItemProperties) eResolveProxy(oldProperties);
			if (properties != oldProperties) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ShopPackage.SHOP_ITEM__PROPERTIES,
							oldProperties, properties));
				}
			}
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ShopItemProperties basicGetProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetProperties(ShopItemProperties newProperties, NotificationChain msgs) {
		final ShopItemProperties oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ShopPackage.SHOP_ITEM__PROPERTIES, oldProperties, newProperties);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setProperties(ShopItemProperties newProperties) {
		if (newProperties != properties) {
			NotificationChain msgs = null;
			if (properties != null) {
				msgs = ((InternalEObject) properties).eInverseRemove(this, ShopPackage.SHOP_ITEM_PROPERTIES__ITEM,
						ShopItemProperties.class, msgs);
			}
			if (newProperties != null) {
				msgs = ((InternalEObject) newProperties).eInverseAdd(this, ShopPackage.SHOP_ITEM_PROPERTIES__ITEM,
						ShopItemProperties.class, msgs);
			}
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__PROPERTIES, newProperties,
					newProperties));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean namePriceOK(DiagnosticChain diagnostics, Map<Object, Object> context) {
		final String n = getName();
		if (n == null) return true;
		final boolean priceFree = getPrice() >= 0.0f && getPrice() < 0.1f;
		final boolean nameFree = n.contains("FREE");
		if (priceFree && !nameFree) {
			EValidatorAdapter.Factory.addDiagnostic(diagnostics, ShopValidator.DIAGNOSTIC_SOURCE,
					ShopValidator.SHOP_ITEM__NAME_PRICE_OK, Diagnostic.WARNING,
					"Name should include word FREE if price is 0.0", new Object[][] {
							{ this, IMOAOPackage.Literals.NAMED_OBJECT__NAME },
							{ this, ShopPackage.Literals.SHOP_ITEM__PRICE } });
			return false;
		}
		if (!priceFree && nameFree) {
			EValidatorAdapter.Factory.addDiagnostic(diagnostics, ShopValidator.DIAGNOSTIC_SOURCE,
					ShopValidator.SHOP_ITEM__NAME_PRICE_OK, Diagnostic.ERROR, "Only free items may include word FREE",
					new Object[][] { { this, IMOAOPackage.Literals.NAMED_OBJECT__NAME },
							{ this, ShopPackage.Literals.SHOP_ITEM__PRICE } });
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean nameOK(DiagnosticChain diagnostics, Map<Object, Object> context) {
		final String n = getName();
		if (n != null && n.length() < 2) {
			/*
			 * The null feature is on purpose - see DiagnosticChainTest
			 */
			EValidatorAdapter.Factory.addError(diagnostics, ShopValidator.DIAGNOSTIC_SOURCE,
					ShopValidator.SHOP_ITEM__NAME_OK, "Name not correct (at least two characters)", this, null);
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM__SHOP:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetShop((Shop) otherEnd, msgs);
		case ShopPackage.SHOP_ITEM__ORDER_ITEMS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOrderItems()).basicAdd(otherEnd, msgs);
		case ShopPackage.SHOP_ITEM__GROUP:
			if (group != null) {
				msgs = ((InternalEObject) group).eInverseRemove(this, ShopPackage.SHOP_ITEM_GROUP__ITEMS,
						ShopItemGroup.class, msgs);
			}
			return basicSetGroup((ShopItemGroup) otherEnd, msgs);
		case ShopPackage.SHOP_ITEM__PROPERTIES:
			if (properties != null) {
				msgs = ((InternalEObject) properties).eInverseRemove(this, ShopPackage.SHOP_ITEM_PROPERTIES__ITEM,
						ShopItemProperties.class, msgs);
			}
			return basicSetProperties((ShopItemProperties) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM__SHOP:
			return basicSetShop(null, msgs);
		case ShopPackage.SHOP_ITEM__ORDER_ITEMS:
			return ((InternalEList<?>) getOrderItems()).basicRemove(otherEnd, msgs);
		case ShopPackage.SHOP_ITEM__INFORMATION:
			return basicSetInformation(null, msgs);
		case ShopPackage.SHOP_ITEM__GROUP:
			return basicSetGroup(null, msgs);
		case ShopPackage.SHOP_ITEM__PROPERTIES:
			return basicSetProperties(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ShopPackage.SHOP_ITEM__SHOP:
			return eInternalContainer().eInverseRemove(this, ShopPackage.SHOP__SHOP_ITEMS, Shop.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM__SHOP:
			return getShop();
		case ShopPackage.SHOP_ITEM__PRICE:
			return getPrice();
		case ShopPackage.SHOP_ITEM__ORDER_ITEMS:
			return getOrderItems();
		case ShopPackage.SHOP_ITEM__FOR_SALE:
			return isForSale();
		case ShopPackage.SHOP_ITEM__INFORMATION:
			return getInformation();
		case ShopPackage.SHOP_ITEM__GROUP:
			if (resolve) return getGroup();
			return basicGetGroup();
		case ShopPackage.SHOP_ITEM__LOCATIONS:
			return getLocations();
		case ShopPackage.SHOP_ITEM__PROPERTIES:
			if (resolve) return getProperties();
			return basicGetProperties();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM__SHOP:
			setShop((Shop) newValue);
			return;
		case ShopPackage.SHOP_ITEM__PRICE:
			setPrice((Float) newValue);
			return;
		case ShopPackage.SHOP_ITEM__ORDER_ITEMS:
			getOrderItems().clear();
			getOrderItems().addAll((Collection<? extends OrderItem>) newValue);
			return;
		case ShopPackage.SHOP_ITEM__FOR_SALE:
			setForSale((Boolean) newValue);
			return;
		case ShopPackage.SHOP_ITEM__INFORMATION:
			setInformation((ShopItemInformation) newValue);
			return;
		case ShopPackage.SHOP_ITEM__GROUP:
			setGroup((ShopItemGroup) newValue);
			return;
		case ShopPackage.SHOP_ITEM__LOCATIONS:
			getLocations().clear();
			getLocations().addAll((Collection<? extends String>) newValue);
			return;
		case ShopPackage.SHOP_ITEM__PROPERTIES:
			setProperties((ShopItemProperties) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM__SHOP:
			setShop((Shop) null);
			return;
		case ShopPackage.SHOP_ITEM__PRICE:
			setPrice(PRICE_EDEFAULT);
			return;
		case ShopPackage.SHOP_ITEM__ORDER_ITEMS:
			getOrderItems().clear();
			return;
		case ShopPackage.SHOP_ITEM__FOR_SALE:
			setForSale(FOR_SALE_EDEFAULT);
			return;
		case ShopPackage.SHOP_ITEM__INFORMATION:
			setInformation((ShopItemInformation) null);
			return;
		case ShopPackage.SHOP_ITEM__GROUP:
			setGroup((ShopItemGroup) null);
			return;
		case ShopPackage.SHOP_ITEM__LOCATIONS:
			getLocations().clear();
			return;
		case ShopPackage.SHOP_ITEM__PROPERTIES:
			setProperties((ShopItemProperties) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM__SHOP:
			return getShop() != null;
		case ShopPackage.SHOP_ITEM__PRICE:
			return price != PRICE_EDEFAULT;
		case ShopPackage.SHOP_ITEM__ORDER_ITEMS:
			return orderItems != null && !orderItems.isEmpty();
		case ShopPackage.SHOP_ITEM__FOR_SALE:
			return forSale != FOR_SALE_EDEFAULT;
		case ShopPackage.SHOP_ITEM__INFORMATION:
			return information != null;
		case ShopPackage.SHOP_ITEM__GROUP:
			return group != null;
		case ShopPackage.SHOP_ITEM__LOCATIONS:
			return locations != null && !locations.isEmpty();
		case ShopPackage.SHOP_ITEM__PROPERTIES:
			return properties != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (price: ");
		result.append(price);
		result.append(", forSale: ");
		result.append(forSale);
		result.append(", locations: ");
		result.append(locations);
		result.append(')');
		return result.toString();
	}

} // ShopItemImpl
