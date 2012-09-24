/**
 */
package com.rcpcompany.uibindings.tests.shop.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.internal.NamedObjectImpl;
import com.rcpcompany.uibindings.model.utils.EValidatorAdapterUtils;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopItemInformation;
import com.rcpcompany.uibindings.tests.shop.ShopItemProperties;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.shop.util.ShopValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Item</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemImpl#getShop <em>Shop</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemImpl#getPrice <em>Price</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemImpl#getAdvancedPrice <em>Advanced Price</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemImpl#getOrderItems <em>Order Items</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemImpl#isForSale <em>For Sale</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemImpl#getInformation <em>Information</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemImpl#getLocations <em>Locations</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ShopItemImpl extends NamedObjectImpl implements ShopItem {
	/**
	 * The default value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected static final float PRICE_EDEFAULT = 0.0F;
	/**
	 * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected float price = PRICE_EDEFAULT;
	/**
	 * The default value of the '{@link #getAdvancedPrice() <em>Advanced Price</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAdvancedPrice()
	 * @generated
	 * @ordered
	 */
	protected static final String ADVANCED_PRICE_EDEFAULT = ""; //$NON-NLS-1$
	/**
	 * The cached value of the '{@link #getAdvancedPrice() <em>Advanced Price</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAdvancedPrice()
	 * @generated
	 * @ordered
	 */
	protected String advancedPrice = ADVANCED_PRICE_EDEFAULT;
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
	 * The cached value of the '{@link #getInformation() <em>Information</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInformation()
	 * @generated
	 * @ordered
	 */
	protected ShopItemInformation information;
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<ShopItemProperties> properties;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ShopItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.SHOP_ITEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Shop getShop() {
		if (eContainerFeatureID() != ShopPackage.SHOP_ITEM__SHOP) return null;
		return (Shop) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShop(Shop newShop, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newShop, ShopPackage.SHOP_ITEM__SHOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setShop(Shop newShop) {
		if (newShop != eInternalContainer()
				|| (eContainerFeatureID() != ShopPackage.SHOP_ITEM__SHOP && newShop != null)) {
			if (EcoreUtil.isAncestor(this, newShop))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
			if (newShop != null)
				msgs = ((InternalEObject) newShop).eInverseAdd(this, ShopPackage.SHOP__SHOP_ITEMS, Shop.class, msgs);
			msgs = basicSetShop(newShop, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__SHOP, newShop, newShop));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrice(float newPrice) {
		float oldPrice = price;
		price = newPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__PRICE, oldPrice, price));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdvancedPrice() {
		return advancedPrice;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdvancedPrice(String newAdvancedPrice) {
		String oldAdvancedPrice = advancedPrice;
		advancedPrice = newAdvancedPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__ADVANCED_PRICE,
					oldAdvancedPrice, advancedPrice));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrderItem> getOrderItems() {
		if (orderItems == null) {
			orderItems = new EObjectResolvingEList<OrderItem>(OrderItem.class, this, ShopPackage.SHOP_ITEM__ORDER_ITEMS);
		}
		return orderItems;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isForSale() {
		return forSale;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setForSale(boolean newForSale) {
		boolean oldForSale = forSale;
		forSale = newForSale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__FOR_SALE, oldForSale, forSale));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopItemInformation getInformation() {
		if (information != null && information.eIsProxy()) {
			InternalEObject oldInformation = (InternalEObject) information;
			information = (ShopItemInformation) eResolveProxy(oldInformation);
			if (information != oldInformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ShopPackage.SHOP_ITEM__INFORMATION,
							oldInformation, information));
			}
		}
		return information;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShopItemInformation basicGetInformation() {
		return information;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInformation(ShopItemInformation newInformation) {
		ShopItemInformation oldInformation = information;
		information = newInformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__INFORMATION, oldInformation,
					information));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ShopItemGroup getGroup() {
		return group;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroup(ShopItemGroup newGroup, NotificationChain msgs) {
		ShopItemGroup oldGroup = group;
		group = newGroup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ShopPackage.SHOP_ITEM__GROUP, oldGroup, newGroup);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(ShopItemGroup newGroup) {
		if (newGroup != group) {
			NotificationChain msgs = null;
			if (group != null)
				msgs = ((InternalEObject) group).eInverseRemove(this, ShopPackage.SHOP_ITEM_GROUP__ITEM,
						ShopItemGroup.class, msgs);
			if (newGroup != null)
				msgs = ((InternalEObject) newGroup).eInverseAdd(this, ShopPackage.SHOP_ITEM_GROUP__ITEM,
						ShopItemGroup.class, msgs);
			msgs = basicSetGroup(newGroup, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM__GROUP, newGroup, newGroup));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getLocations() {
		if (locations == null) {
			locations = new EDataTypeEList<String>(String.class, this, ShopPackage.SHOP_ITEM__LOCATIONS);
		}
		return locations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ShopItemProperties> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentWithInverseEList<ShopItemProperties>(ShopItemProperties.class, this,
					ShopPackage.SHOP_ITEM__PROPERTIES, ShopPackage.SHOP_ITEM_PROPERTIES__ITEM);
		}
		return properties;
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
			EValidatorAdapterUtils.addDiagnostic(diagnostics, ShopValidator.DIAGNOSTIC_SOURCE,
					ShopValidator.SHOP_ITEM__NAME_PRICE_OK, Diagnostic.WARNING,
					"Name should include word FREE if price is 0.0", new Object[][] {
							{ this, IMOAOPackage.Literals.NAMED_OBJECT__NAME },
							{ this, ShopPackage.Literals.SHOP_ITEM__PRICE } });
			return false;
		}
		if (!priceFree && nameFree) {
			EValidatorAdapterUtils.addDiagnostic(diagnostics, ShopValidator.DIAGNOSTIC_SOURCE,
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
			EValidatorAdapterUtils.addError(diagnostics, ShopValidator.DIAGNOSTIC_SOURCE,
					ShopValidator.SHOP_ITEM__NAME_OK, "Name not correct (at least two characters)", this,
					IMOAOPackage.Literals.NAMED_OBJECT__NAME);
			return false;
		}
		return true;
	}

	@Override
	public boolean isValid(DiagnosticChain diagnostic, Map<Object, Object> context) {
		boolean valid = super.isValid(diagnostic, context);

		/*
		 * First build a map which index all properties by name
		 */
		final Map<String, List<ShopItemProperties>> names = new HashMap<String, List<ShopItemProperties>>();

		for (final ShopItemProperties p : getProperties()) {
			List<ShopItemProperties> tcList = names.get(p.getName());
			if (tcList == null) {
				tcList = new ArrayList<ShopItemProperties>();
				names.put(p.getName(), tcList);
			}
			tcList.add(p);
		}

		/*
		 * Then check that only only property exists for each
		 */
		for (final Entry<String, List<ShopItemProperties>> entry : names.entrySet()) {
			if (entry.getValue().size() == 1) {
				continue;
			}

			final List<Object> data = new ArrayList<Object>();
			for (final ShopItemProperties p : entry.getValue()) {
				data.add(new Object[] { this, ShopPackage.Literals.SHOP_ITEM__PROPERTIES, getProperties().indexOf(p) });
			}
			EValidatorAdapterUtils.addDiagnostic(diagnostic, ShopPackage.eNS_URI, 1000, Diagnostic.ERROR,
					"Multiple properties named '" + entry.getKey() + "'", data.toArray());
			valid = false;
		}

		return valid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM__SHOP:
			if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
			return basicSetShop((Shop) otherEnd, msgs);
		case ShopPackage.SHOP_ITEM__GROUP:
			if (group != null)
				msgs = ((InternalEObject) group).eInverseRemove(this, ShopPackage.SHOP_ITEM_GROUP__ITEM,
						ShopItemGroup.class, msgs);
			return basicSetGroup((ShopItemGroup) otherEnd, msgs);
		case ShopPackage.SHOP_ITEM__PROPERTIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getProperties()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM__SHOP:
			return basicSetShop(null, msgs);
		case ShopPackage.SHOP_ITEM__GROUP:
			return basicSetGroup(null, msgs);
		case ShopPackage.SHOP_ITEM__PROPERTIES:
			return ((InternalEList<?>) getProperties()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM__SHOP:
			return getShop();
		case ShopPackage.SHOP_ITEM__PRICE:
			return getPrice();
		case ShopPackage.SHOP_ITEM__ADVANCED_PRICE:
			return getAdvancedPrice();
		case ShopPackage.SHOP_ITEM__ORDER_ITEMS:
			return getOrderItems();
		case ShopPackage.SHOP_ITEM__FOR_SALE:
			return isForSale();
		case ShopPackage.SHOP_ITEM__INFORMATION:
			if (resolve) return getInformation();
			return basicGetInformation();
		case ShopPackage.SHOP_ITEM__GROUP:
			return getGroup();
		case ShopPackage.SHOP_ITEM__LOCATIONS:
			return getLocations();
		case ShopPackage.SHOP_ITEM__PROPERTIES:
			return getProperties();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		case ShopPackage.SHOP_ITEM__ADVANCED_PRICE:
			setAdvancedPrice((String) newValue);
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
			getProperties().clear();
			getProperties().addAll((Collection<? extends ShopItemProperties>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
		case ShopPackage.SHOP_ITEM__ADVANCED_PRICE:
			setAdvancedPrice(ADVANCED_PRICE_EDEFAULT);
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
			getProperties().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM__SHOP:
			return getShop() != null;
		case ShopPackage.SHOP_ITEM__PRICE:
			return price != PRICE_EDEFAULT;
		case ShopPackage.SHOP_ITEM__ADVANCED_PRICE:
			return ADVANCED_PRICE_EDEFAULT == null ? advancedPrice != null : !ADVANCED_PRICE_EDEFAULT
					.equals(advancedPrice);
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
			return properties != null && !properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
		case ShopPackage.SHOP_ITEM___NAME_PRICE_OK__DIAGNOSTICCHAIN_MAP:
			return namePriceOK((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
		case ShopPackage.SHOP_ITEM___NAME_OK__DIAGNOSTICCHAIN_MAP:
			return nameOK((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (price: "); //$NON-NLS-1$
		result.append(price);
		result.append(", advancedPrice: "); //$NON-NLS-1$
		result.append(advancedPrice);
		result.append(", forSale: "); //$NON-NLS-1$
		result.append(forSale);
		result.append(", locations: "); //$NON-NLS-1$
		result.append(locations);
		result.append(')');
		return result.toString();
	}

} // ShopItemImpl
