/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Order Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.OrderItemImpl#getNo <em>No</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.OrderItemImpl#getOrder <em>Order</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.OrderItemImpl#getItem <em>Item</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.OrderItemImpl#getCount <em>Count</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.OrderItemImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OrderItemImpl extends EObjectImpl implements OrderItem {
	/**
	 * The default value of the '{@link #getNo() <em>No</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNo()
	 * @generated
	 * @ordered
	 */
	protected static final int NO_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNo() <em>No</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNo()
	 * @generated
	 * @ordered
	 */
	protected int no = NO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItem() <em>Item</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getItem()
	 * @generated
	 * @ordered
	 */
	protected ShopItem item;

	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final int COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected int count = COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OrderItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.ORDER_ITEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getNo() {
		return no;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Order getOrder() {
		if (eContainerFeatureID() != ShopPackage.ORDER_ITEM__ORDER) {
			return null;
		}
		return (Order) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public NotificationChain basicSetOrder(Order newOrder, NotificationChain msgs) {
		msgs = basicSetOrderGen(newOrder, msgs);

		// calculate a new item number
		int n = 0;
		for (final OrderItem i : newOrder.getItems()) {
			if (i == this) {
				continue;
			}
			if (n < i.getNo()) {
				n = i.getNo();
			}
		}
		n++;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ShopPackage.ORDER_ITEM__NO, no, n);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		no = n;

		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetOrderGen(Order newOrder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newOrder, ShopPackage.ORDER_ITEM__ORDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setOrder(Order newOrder) {
		if (newOrder != eInternalContainer()
				|| (eContainerFeatureID() != ShopPackage.ORDER_ITEM__ORDER && newOrder != null)) {
			if (EcoreUtil.isAncestor(this, newOrder)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newOrder != null) {
				msgs = ((InternalEObject) newOrder).eInverseAdd(this, ShopPackage.ORDER__ITEMS, Order.class, msgs);
			}
			msgs = basicSetOrder(newOrder, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER_ITEM__ORDER, newOrder, newOrder));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ShopItem getItem() {
		return item;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetItem(ShopItem newItem, NotificationChain msgs) {
		final ShopItem oldItem = item;
		item = newItem;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ShopPackage.ORDER_ITEM__ITEM, oldItem, newItem);
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
	public void setItem(ShopItem newItem) {
		if (newItem != item) {
			NotificationChain msgs = null;
			if (item != null) {
				msgs = ((InternalEObject) item).eInverseRemove(this, ShopPackage.SHOP_ITEM__ORDER_ITEMS,
						ShopItem.class, msgs);
			}
			if (newItem != null) {
				msgs = ((InternalEObject) newItem).eInverseAdd(this, ShopPackage.SHOP_ITEM__ORDER_ITEMS,
						ShopItem.class, msgs);
			}
			msgs = basicSetItem(newItem, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER_ITEM__ITEM, newItem, newItem));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getCount() {
		return count;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCount(int newCount) {
		final int oldCount = count;
		count = newCount;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER_ITEM__COUNT, oldCount, count));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getId() {
		return getOrder().getNo() + "-" + getNo();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ShopPackage.ORDER_ITEM__ORDER:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetOrder((Order) otherEnd, msgs);
		case ShopPackage.ORDER_ITEM__ITEM:
			if (item != null) {
				msgs = ((InternalEObject) item).eInverseRemove(this, ShopPackage.SHOP_ITEM__ORDER_ITEMS,
						ShopItem.class, msgs);
			}
			return basicSetItem((ShopItem) otherEnd, msgs);
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
		case ShopPackage.ORDER_ITEM__ORDER:
			return basicSetOrder(null, msgs);
		case ShopPackage.ORDER_ITEM__ITEM:
			return basicSetItem(null, msgs);
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
		case ShopPackage.ORDER_ITEM__ORDER:
			return eInternalContainer().eInverseRemove(this, ShopPackage.ORDER__ITEMS, Order.class, msgs);
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
		case ShopPackage.ORDER_ITEM__NO:
			return getNo();
		case ShopPackage.ORDER_ITEM__ORDER:
			return getOrder();
		case ShopPackage.ORDER_ITEM__ITEM:
			return getItem();
		case ShopPackage.ORDER_ITEM__COUNT:
			return getCount();
		case ShopPackage.ORDER_ITEM__ID:
			return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ShopPackage.ORDER_ITEM__ORDER:
			setOrder((Order) newValue);
			return;
		case ShopPackage.ORDER_ITEM__ITEM:
			setItem((ShopItem) newValue);
			return;
		case ShopPackage.ORDER_ITEM__COUNT:
			setCount((Integer) newValue);
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
		case ShopPackage.ORDER_ITEM__ORDER:
			setOrder((Order) null);
			return;
		case ShopPackage.ORDER_ITEM__ITEM:
			setItem((ShopItem) null);
			return;
		case ShopPackage.ORDER_ITEM__COUNT:
			setCount(COUNT_EDEFAULT);
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
		case ShopPackage.ORDER_ITEM__NO:
			return no != NO_EDEFAULT;
		case ShopPackage.ORDER_ITEM__ORDER:
			return getOrder() != null;
		case ShopPackage.ORDER_ITEM__ITEM:
			return item != null;
		case ShopPackage.ORDER_ITEM__COUNT:
			return count != COUNT_EDEFAULT;
		case ShopPackage.ORDER_ITEM__ID:
			return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
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
		if (eIsProxy()) {
			return super.toString();
		}

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (no: ");
		result.append(no);
		result.append(", count: ");
		result.append(count);
		result.append(')');
		return result.toString();
	}

} // OrderItemImpl
