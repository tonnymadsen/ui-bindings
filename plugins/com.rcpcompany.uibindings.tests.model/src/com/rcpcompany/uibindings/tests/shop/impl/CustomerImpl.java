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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.CustomerType;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Customer</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.CustomerImpl#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.CustomerImpl#getContact <em>Contact</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.CustomerImpl#getOrders <em>Orders</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.CustomerImpl#getLoyalty <em>Loyalty</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CustomerImpl extends EObjectImpl implements Customer {
	/**
	 * The cached value of the '{@link #getContact() <em>Contact</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getContact()
	 * @generated
	 * @ordered
	 */
	protected Contact contact;

	/**
	 * The cached value of the '{@link #getOrders() <em>Orders</em>}' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getOrders()
	 * @generated
	 * @ordered
	 */
	protected EList<Order> orders;

	/**
	 * The default value of the '{@link #getLoyalty() <em>Loyalty</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLoyalty()
	 * @generated
	 * @ordered
	 */
	protected static final CustomerType LOYALTY_EDEFAULT = CustomerType.BRONCE;

	/**
	 * The cached value of the '{@link #getLoyalty() <em>Loyalty</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getLoyalty()
	 * @generated
	 * @ordered
	 */
	protected CustomerType loyalty = LOYALTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CustomerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.CUSTOMER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Shop getShop() {
		if (eContainerFeatureID() != ShopPackage.CUSTOMER__SHOP) {
			return null;
		}
		return (Shop) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetShop(Shop newShop, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newShop, ShopPackage.CUSTOMER__SHOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setShop(Shop newShop) {
		if (newShop != eInternalContainer() || (eContainerFeatureID() != ShopPackage.CUSTOMER__SHOP && newShop != null)) {
			if (EcoreUtil.isAncestor(this, newShop)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newShop != null) {
				msgs = ((InternalEObject) newShop).eInverseAdd(this, ShopPackage.SHOP__CUSTOMERS, Shop.class, msgs);
			}
			msgs = basicSetShop(newShop, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CUSTOMER__SHOP, newShop, newShop));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetContact(Contact newContact, NotificationChain msgs) {
		final Contact oldContact = contact;
		contact = newContact;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ShopPackage.CUSTOMER__CONTACT, oldContact, newContact);
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
	public void setContact(Contact newContact) {
		if (newContact != contact) {
			NotificationChain msgs = null;
			if (contact != null) {
				msgs = ((InternalEObject) contact).eInverseRemove(this, ShopPackage.CONTACT__CUSTOMER, Contact.class,
						msgs);
			}
			if (newContact != null) {
				msgs = ((InternalEObject) newContact).eInverseAdd(this, ShopPackage.CONTACT__CUSTOMER, Contact.class,
						msgs);
			}
			msgs = basicSetContact(newContact, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CUSTOMER__CONTACT, newContact, newContact));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Order> getOrders() {
		if (orders == null) {
			orders = new EObjectWithInverseEList<Order>(Order.class, this, ShopPackage.CUSTOMER__ORDERS,
					ShopPackage.ORDER__CUSTOMER);
		}
		return orders;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CustomerType getLoyalty() {
		return loyalty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLoyalty(CustomerType newLoyalty) {
		final CustomerType oldLoyalty = loyalty;
		loyalty = newLoyalty == null ? LOYALTY_EDEFAULT : newLoyalty;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CUSTOMER__LOYALTY, oldLoyalty, loyalty));
		}
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
		case ShopPackage.CUSTOMER__SHOP:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetShop((Shop) otherEnd, msgs);
		case ShopPackage.CUSTOMER__CONTACT:
			if (contact != null) {
				msgs = ((InternalEObject) contact).eInverseRemove(this, ShopPackage.CONTACT__CUSTOMER, Contact.class,
						msgs);
			}
			return basicSetContact((Contact) otherEnd, msgs);
		case ShopPackage.CUSTOMER__ORDERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOrders()).basicAdd(otherEnd, msgs);
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
		case ShopPackage.CUSTOMER__SHOP:
			return basicSetShop(null, msgs);
		case ShopPackage.CUSTOMER__CONTACT:
			return basicSetContact(null, msgs);
		case ShopPackage.CUSTOMER__ORDERS:
			return ((InternalEList<?>) getOrders()).basicRemove(otherEnd, msgs);
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
		case ShopPackage.CUSTOMER__SHOP:
			return eInternalContainer().eInverseRemove(this, ShopPackage.SHOP__CUSTOMERS, Shop.class, msgs);
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
		case ShopPackage.CUSTOMER__SHOP:
			return getShop();
		case ShopPackage.CUSTOMER__CONTACT:
			return getContact();
		case ShopPackage.CUSTOMER__ORDERS:
			return getOrders();
		case ShopPackage.CUSTOMER__LOYALTY:
			return getLoyalty();
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
		case ShopPackage.CUSTOMER__SHOP:
			setShop((Shop) newValue);
			return;
		case ShopPackage.CUSTOMER__CONTACT:
			setContact((Contact) newValue);
			return;
		case ShopPackage.CUSTOMER__ORDERS:
			getOrders().clear();
			getOrders().addAll((Collection<? extends Order>) newValue);
			return;
		case ShopPackage.CUSTOMER__LOYALTY:
			setLoyalty((CustomerType) newValue);
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
		case ShopPackage.CUSTOMER__SHOP:
			setShop((Shop) null);
			return;
		case ShopPackage.CUSTOMER__CONTACT:
			setContact((Contact) null);
			return;
		case ShopPackage.CUSTOMER__ORDERS:
			getOrders().clear();
			return;
		case ShopPackage.CUSTOMER__LOYALTY:
			setLoyalty(LOYALTY_EDEFAULT);
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
		case ShopPackage.CUSTOMER__SHOP:
			return getShop() != null;
		case ShopPackage.CUSTOMER__CONTACT:
			return contact != null;
		case ShopPackage.CUSTOMER__ORDERS:
			return orders != null && !orders.isEmpty();
		case ShopPackage.CUSTOMER__LOYALTY:
			return loyalty != LOYALTY_EDEFAULT;
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
		result.append(" (loyalty: ");
		result.append(loyalty);
		result.append(')');
		return result.toString();
	}

} // CustomerImpl
