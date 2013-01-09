/**
 */
package com.rcpcompany.uibindings.tests.shop.internal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.moao.internal.NamedObjectImpl;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Item Group</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemGroupImpl#getShop <em>Shop</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopItemGroupImpl#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ShopItemGroupImpl extends NamedObjectImpl implements ShopItemGroup {
	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<ShopItem> items;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ShopItemGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.SHOP_ITEM_GROUP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Shop getShop() {
		if (eContainerFeatureID() != ShopPackage.SHOP_ITEM_GROUP__SHOP) return null;
		return (Shop) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShop(Shop newShop, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newShop, ShopPackage.SHOP_ITEM_GROUP__SHOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShop(Shop newShop) {
		if (newShop != eInternalContainer()
				|| (eContainerFeatureID() != ShopPackage.SHOP_ITEM_GROUP__SHOP && newShop != null)) {
			if (EcoreUtil.isAncestor(this, newShop))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
			if (newShop != null)
				msgs = ((InternalEObject) newShop).eInverseAdd(this, ShopPackage.SHOP__SHOP_GROUPS, Shop.class, msgs);
			msgs = basicSetShop(newShop, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP_ITEM_GROUP__SHOP, newShop, newShop));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ShopItem> getItems() {
		if (items == null) {
			items = new EObjectWithInverseEList<ShopItem>(ShopItem.class, this, ShopPackage.SHOP_ITEM_GROUP__ITEMS,
					ShopPackage.SHOP_ITEM__GROUP);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ShopPackage.SHOP_ITEM_GROUP__SHOP:
			if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
			return basicSetShop((Shop) otherEnd, msgs);
		case ShopPackage.SHOP_ITEM_GROUP__ITEMS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getItems()).basicAdd(otherEnd, msgs);
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
		case ShopPackage.SHOP_ITEM_GROUP__SHOP:
			return basicSetShop(null, msgs);
		case ShopPackage.SHOP_ITEM_GROUP__ITEMS:
			return ((InternalEList<?>) getItems()).basicRemove(otherEnd, msgs);
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
		case ShopPackage.SHOP_ITEM_GROUP__SHOP:
			return eInternalContainer().eInverseRemove(this, ShopPackage.SHOP__SHOP_GROUPS, Shop.class, msgs);
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
		case ShopPackage.SHOP_ITEM_GROUP__SHOP:
			return getShop();
		case ShopPackage.SHOP_ITEM_GROUP__ITEMS:
			return getItems();
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
		case ShopPackage.SHOP_ITEM_GROUP__SHOP:
			setShop((Shop) newValue);
			return;
		case ShopPackage.SHOP_ITEM_GROUP__ITEMS:
			getItems().clear();
			getItems().addAll((Collection<? extends ShopItem>) newValue);
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
		case ShopPackage.SHOP_ITEM_GROUP__SHOP:
			setShop((Shop) null);
			return;
		case ShopPackage.SHOP_ITEM_GROUP__ITEMS:
			getItems().clear();
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
		case ShopPackage.SHOP_ITEM_GROUP__SHOP:
			return getShop() != null;
		case ShopPackage.SHOP_ITEM_GROUP__ITEMS:
			return items != null && !items.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ShopItemGroupImpl
