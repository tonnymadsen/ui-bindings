/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Order</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.OrderImpl#getNo <em>No</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.OrderImpl#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.OrderImpl#getCustomer <em>Customer</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.OrderImpl#getPrice <em>Price</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.OrderImpl#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OrderImpl extends EObjectImpl implements Order {
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
	 * The cached value of the '{@link #getCustomer() <em>Customer</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getCustomer()
	 * @generated
	 * @ordered
	 */
	protected Customer customer;

	/**
	 * The default value of the '{@link #getPrice() <em>Price</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected static final float PRICE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getPrice() <em>Price</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getPrice()
	 * @generated
	 * @ordered
	 */
	protected float price = PRICE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<OrderItem> items;

	private final AdapterImpl myPriceAdapter;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected OrderImpl() {
		super();

		myPriceAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.isTouch()) {
					return;
				}
				if (msg.getFeature() == ShopPackage.Literals.ORDER__ITEMS) {
					switch (msg.getEventType()) {
					case Notification.REMOVE:
					case Notification.SET:
						final OrderItem oi = (OrderItem) msg.getOldValue();
						if (oi != null) {
							oi.eAdapters().remove(this);
							if (oi.getItem() != null) {
								oi.getItem().eAdapters().remove(this);
							}
						}
						break;
					}
					switch (msg.getEventType()) {
					case Notification.ADD:
					case Notification.SET:
						final OrderItem oi = (OrderItem) msg.getNewValue();
						if (oi != null) {
							oi.eAdapters().add(this);
							if (oi.getItem() != null) {
								oi.getItem().eAdapters().add(this);
							}
						}
						break;
					}
				}
				if (msg.getFeature() == ShopPackage.Literals.ORDER_ITEM__ITEM) {
					ShopItem oi = (ShopItem) msg.getOldValue();
					if (oi != null) {
						oi.eAdapters().remove(this);
					}
					oi = (ShopItem) msg.getNewValue();
					if (oi != null) {
						oi.eAdapters().add(this);
					}
				}
				recalcPrice();
			}
		};
		this.eAdapters().add(myPriceAdapter);
		recalcPrice();
	}

	private void recalcPrice() {
		float p = 0;
		for (final OrderItem i : getItems()) {
			final ShopItem si = i.getItem();
			if (si != null) {
				p += i.getCount() * si.getPrice();
			}
		}

		setPrice(p);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.ORDER;
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
	public Shop getShop() {
		if (eContainerFeatureID() != ShopPackage.ORDER__SHOP) {
			return null;
		}
		return (Shop) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetCustomer(Customer newCustomer, NotificationChain msgs) {
		final Customer oldCustomer = customer;
		customer = newCustomer;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ShopPackage.ORDER__CUSTOMER, oldCustomer, newCustomer);
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
	public NotificationChain basicSetCustomerGen(Customer newCustomer, NotificationChain msgs) {
		final Customer oldCustomer = customer;
		customer = newCustomer;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ShopPackage.ORDER__CUSTOMER, oldCustomer, newCustomer);
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
	public void setCustomer(Customer newCustomer) {
		if (newCustomer != customer) {
			NotificationChain msgs = null;
			if (customer != null) {
				msgs = ((InternalEObject) customer).eInverseRemove(this, ShopPackage.CUSTOMER__ORDERS, Customer.class,
						msgs);
			}
			if (newCustomer != null) {
				msgs = ((InternalEObject) newCustomer).eInverseAdd(this, ShopPackage.CUSTOMER__ORDERS, Customer.class,
						msgs);
			}
			msgs = basicSetCustomer(newCustomer, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER__CUSTOMER, newCustomer, newCustomer));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setPrice(float newPrice) {
		if (getPrice() != newPrice) {
			setPriceGen(newPrice);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPriceGen(float newPrice) {
		final float oldPrice = price;
		price = newPrice;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER__PRICE, oldPrice, price));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<OrderItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentWithInverseEList<OrderItem>(OrderItem.class, this, ShopPackage.ORDER__ITEMS,
					ShopPackage.ORDER_ITEM__ORDER);
		}
		return items;
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
		case ShopPackage.ORDER__SHOP:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return eBasicSetContainer(otherEnd, ShopPackage.ORDER__SHOP, msgs);
		case ShopPackage.ORDER__CUSTOMER:
			if (customer != null) {
				msgs = ((InternalEObject) customer).eInverseRemove(this, ShopPackage.CUSTOMER__ORDERS, Customer.class,
						msgs);
			}
			return basicSetCustomer((Customer) otherEnd, msgs);
		case ShopPackage.ORDER__ITEMS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getItems()).basicAdd(otherEnd, msgs);
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
		case ShopPackage.ORDER__SHOP:
			return eBasicSetContainer(null, ShopPackage.ORDER__SHOP, msgs);
		case ShopPackage.ORDER__CUSTOMER:
			return basicSetCustomer(null, msgs);
		case ShopPackage.ORDER__ITEMS:
			return ((InternalEList<?>) getItems()).basicRemove(otherEnd, msgs);
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
		case ShopPackage.ORDER__SHOP:
			return eInternalContainer().eInverseRemove(this, ShopPackage.SHOP__ORDERS, Shop.class, msgs);
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
		case ShopPackage.ORDER__NO:
			return getNo();
		case ShopPackage.ORDER__SHOP:
			return getShop();
		case ShopPackage.ORDER__CUSTOMER:
			return getCustomer();
		case ShopPackage.ORDER__PRICE:
			return getPrice();
		case ShopPackage.ORDER__ITEMS:
			return getItems();
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
		case ShopPackage.ORDER__CUSTOMER:
			setCustomer((Customer) newValue);
			return;
		case ShopPackage.ORDER__PRICE:
			setPrice((Float) newValue);
			return;
		case ShopPackage.ORDER__ITEMS:
			getItems().clear();
			getItems().addAll((Collection<? extends OrderItem>) newValue);
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
		case ShopPackage.ORDER__CUSTOMER:
			setCustomer((Customer) null);
			return;
		case ShopPackage.ORDER__PRICE:
			setPrice(PRICE_EDEFAULT);
			return;
		case ShopPackage.ORDER__ITEMS:
			getItems().clear();
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
		case ShopPackage.ORDER__NO:
			return no != NO_EDEFAULT;
		case ShopPackage.ORDER__SHOP:
			return getShop() != null;
		case ShopPackage.ORDER__CUSTOMER:
			return customer != null;
		case ShopPackage.ORDER__PRICE:
			return price != PRICE_EDEFAULT;
		case ShopPackage.ORDER__ITEMS:
			return items != null && !items.isEmpty();
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
		result.append(", price: ");
		result.append(price);
		result.append(')');
		return result.toString();
	}

} // OrderImpl
