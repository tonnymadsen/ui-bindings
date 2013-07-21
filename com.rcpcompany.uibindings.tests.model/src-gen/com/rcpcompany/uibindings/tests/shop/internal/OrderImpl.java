/**
 */
package com.rcpcompany.uibindings.tests.shop.internal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.moao.internal.MOAOImpl;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.OrderItem;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Order</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.internal.OrderImpl#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.internal.OrderImpl#getNo <em>No</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.internal.OrderImpl#getCustomer <em>Customer</em>}
 * </li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.internal.OrderImpl#getPrice <em>Price</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.internal.OrderImpl#getItems <em>Items</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.internal.OrderImpl#getDiscount <em>Discount</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OrderImpl extends MOAOImpl implements Order {
	/**
	 * The default value of the '{@link #getNo() <em>No</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNo()
	 * @generated
	 * @ordered
	 */
	protected static final int NO_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getNo() <em>No</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getNo()
	 * @generated
	 * @ordered
	 */
	protected int no = NO_EDEFAULT;
	/**
	 * The cached value of the '{@link #getCustomer() <em>Customer</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCustomer()
	 * @generated
	 * @ordered
	 */
	protected Customer customer;
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
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<OrderItem> items;
	/**
	 * The default value of the '{@link #getDiscount() <em>Discount</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDiscount()
	 * @generated
	 * @ordered
	 */
	protected static final float DISCOUNT_EDEFAULT = 0.0F;
	/**
	 * The cached value of the '{@link #getDiscount() <em>Discount</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDiscount()
	 * @generated
	 * @ordered
	 */
	protected float discount = DISCOUNT_EDEFAULT;
	/**
	 * This is true if the Discount attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean discountESet;

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
				if (msg.isTouch()) return;
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

		setPrice(p - getDiscount());
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
	@Override
	public Shop getShop() {
		if (eContainerFeatureID() != ShopPackage.ORDER__SHOP) return null;
		return (Shop) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetShop(Shop newShop, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newShop, ShopPackage.ORDER__SHOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setShop(Shop newShop) {
		if (newShop != eInternalContainer() || (eContainerFeatureID() != ShopPackage.ORDER__SHOP && newShop != null)) {
			if (EcoreUtil.isAncestor(this, newShop))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
			if (newShop != null)
				msgs = ((InternalEObject) newShop).eInverseAdd(this, ShopPackage.SHOP__ORDERS, Shop.class, msgs);
			msgs = basicSetShop(newShop, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER__SHOP, newShop, newShop));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getNo() {
		return no;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNo(int newNo) {
		int oldNo = no;
		no = newNo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER__NO, oldNo, no));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetCustomer(Customer newCustomer, NotificationChain msgs) {
		Customer oldCustomer = customer;
		customer = newCustomer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER__CUSTOMER,
					oldCustomer, newCustomer);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setCustomer(Customer newCustomer) {
		if (newCustomer != customer) {
			NotificationChain msgs = null;
			if (customer != null)
				msgs = ((InternalEObject) customer).eInverseRemove(this, ShopPackage.CUSTOMER__ORDERS, Customer.class,
						msgs);
			if (newCustomer != null)
				msgs = ((InternalEObject) newCustomer).eInverseAdd(this, ShopPackage.CUSTOMER__ORDERS, Customer.class,
						msgs);
			msgs = basicSetCustomer(newCustomer, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER__CUSTOMER, newCustomer, newCustomer));
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
		float oldPrice = price;
		price = newPrice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER__PRICE, oldPrice, price));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
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
	@Override
	public float getDiscount() {
		return discount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDiscount(float newDiscount) {
		float oldDiscount = discount;
		discount = newDiscount;
		boolean oldDiscountESet = discountESet;
		discountESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.ORDER__DISCOUNT, oldDiscount, discount,
					!oldDiscountESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void unsetDiscount() {
		float oldDiscount = discount;
		boolean oldDiscountESet = discountESet;
		discount = DISCOUNT_EDEFAULT;
		discountESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ShopPackage.ORDER__DISCOUNT, oldDiscount,
					DISCOUNT_EDEFAULT, oldDiscountESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isSetDiscount() {
		return discountESet;
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
			if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
			return basicSetShop((Shop) otherEnd, msgs);
		case ShopPackage.ORDER__CUSTOMER:
			if (customer != null)
				msgs = ((InternalEObject) customer).eInverseRemove(this, ShopPackage.CUSTOMER__ORDERS, Customer.class,
						msgs);
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
			return basicSetShop(null, msgs);
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
		case ShopPackage.ORDER__SHOP:
			return getShop();
		case ShopPackage.ORDER__NO:
			return getNo();
		case ShopPackage.ORDER__CUSTOMER:
			return getCustomer();
		case ShopPackage.ORDER__PRICE:
			return getPrice();
		case ShopPackage.ORDER__ITEMS:
			return getItems();
		case ShopPackage.ORDER__DISCOUNT:
			return getDiscount();
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
		case ShopPackage.ORDER__SHOP:
			setShop((Shop) newValue);
			return;
		case ShopPackage.ORDER__NO:
			setNo((Integer) newValue);
			return;
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
		case ShopPackage.ORDER__DISCOUNT:
			setDiscount((Float) newValue);
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
		case ShopPackage.ORDER__SHOP:
			setShop((Shop) null);
			return;
		case ShopPackage.ORDER__NO:
			setNo(NO_EDEFAULT);
			return;
		case ShopPackage.ORDER__CUSTOMER:
			setCustomer((Customer) null);
			return;
		case ShopPackage.ORDER__PRICE:
			setPrice(PRICE_EDEFAULT);
			return;
		case ShopPackage.ORDER__ITEMS:
			getItems().clear();
			return;
		case ShopPackage.ORDER__DISCOUNT:
			unsetDiscount();
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
		case ShopPackage.ORDER__SHOP:
			return getShop() != null;
		case ShopPackage.ORDER__NO:
			return no != NO_EDEFAULT;
		case ShopPackage.ORDER__CUSTOMER:
			return customer != null;
		case ShopPackage.ORDER__PRICE:
			return price != PRICE_EDEFAULT;
		case ShopPackage.ORDER__ITEMS:
			return items != null && !items.isEmpty();
		case ShopPackage.ORDER__DISCOUNT:
			return isSetDiscount();
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (no: "); //$NON-NLS-1$
		result.append(no);
		result.append(", price: "); //$NON-NLS-1$
		result.append(price);
		result.append(", discount: "); //$NON-NLS-1$
		if (discountESet)
			result.append(discount);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} // OrderImpl
