/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Contact</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl#getName <em>Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl#getAddress <em>Address</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl#getCity <em>City</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl#getZip <em>Zip</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl#getCountry <em>Country</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl#getCustomer <em>Customer</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl#isNewsletter <em>Newsletter</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.ContactImpl#getBirthday <em>Birthday</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ContactImpl extends EObjectImpl implements Contact {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAddress() <em>Address</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAddress() <em>Address</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getAddress()
	 * @generated
	 * @ordered
	 */
	protected String address = ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getCity() <em>City</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected static final String CITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCity() <em>City</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected String city = CITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getZip() <em>Zip</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getZip()
	 * @generated
	 * @ordered
	 */
	protected static final String ZIP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getZip() <em>Zip</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getZip()
	 * @generated
	 * @ordered
	 */
	protected String zip = ZIP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCountry() <em>Country</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getCountry()
	 * @generated
	 * @ordered
	 */
	protected Country country;

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
	 * The default value of the '{@link #isNewsletter() <em>Newsletter</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isNewsletter()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEWSLETTER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNewsletter() <em>Newsletter</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isNewsletter()
	 * @generated
	 * @ordered
	 */
	protected boolean newsletter = NEWSLETTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getBirthday() <em>Birthday</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBirthday()
	 * @generated
	 * @ordered
	 */
	protected static final Date BIRTHDAY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBirthday() <em>Birthday</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBirthday()
	 * @generated
	 * @ordered
	 */
	protected Date birthday = BIRTHDAY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ContactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.CONTACT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		final String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CONTACT__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAddress(String newAddress) {
		final String oldAddress = address;
		address = newAddress;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CONTACT__ADDRESS, oldAddress, address));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCity(String newCity) {
		final String oldCity = city;
		city = newCity;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CONTACT__CITY, oldCity, city));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setZip(String newZip) {
		final String oldZip = zip;
		zip = newZip;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CONTACT__ZIP, oldZip, zip));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCountry(Country newCountry) {
		final Country oldCountry = country;
		country = newCountry;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CONTACT__COUNTRY, oldCountry, country));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Shop getShop() {
		if (eContainerFeatureID() != ShopPackage.CONTACT__SHOP) {
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
		msgs = eBasicSetContainer((InternalEObject) newShop, ShopPackage.CONTACT__SHOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setShop(Shop newShop) {
		if (newShop != eInternalContainer() || (eContainerFeatureID() != ShopPackage.CONTACT__SHOP && newShop != null)) {
			if (EcoreUtil.isAncestor(this, newShop)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newShop != null) {
				msgs = ((InternalEObject) newShop).eInverseAdd(this, ShopPackage.SHOP__CONTACTS, Shop.class, msgs);
			}
			msgs = basicSetShop(newShop, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CONTACT__SHOP, newShop, newShop));
		}
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
					ShopPackage.CONTACT__CUSTOMER, oldCustomer, newCustomer);
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
				msgs = ((InternalEObject) customer).eInverseRemove(this, ShopPackage.CUSTOMER__CONTACT, Customer.class,
						msgs);
			}
			if (newCustomer != null) {
				msgs = ((InternalEObject) newCustomer).eInverseAdd(this, ShopPackage.CUSTOMER__CONTACT, Customer.class,
						msgs);
			}
			msgs = basicSetCustomer(newCustomer, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CONTACT__CUSTOMER, newCustomer,
					newCustomer));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isNewsletter() {
		return newsletter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNewsletter(boolean newNewsletter) {
		final boolean oldNewsletter = newsletter;
		newsletter = newNewsletter;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CONTACT__NEWSLETTER, oldNewsletter,
					newsletter));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBirthday(Date newBirthday) {
		final Date oldBirthday = birthday;
		birthday = newBirthday;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.CONTACT__BIRTHDAY, oldBirthday, birthday));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ShopPackage.CONTACT__SHOP:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetShop((Shop) otherEnd, msgs);
		case ShopPackage.CONTACT__CUSTOMER:
			if (customer != null) {
				msgs = ((InternalEObject) customer).eInverseRemove(this, ShopPackage.CUSTOMER__CONTACT, Customer.class,
						msgs);
			}
			return basicSetCustomer((Customer) otherEnd, msgs);
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
		case ShopPackage.CONTACT__SHOP:
			return basicSetShop(null, msgs);
		case ShopPackage.CONTACT__CUSTOMER:
			return basicSetCustomer(null, msgs);
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
		case ShopPackage.CONTACT__SHOP:
			return eInternalContainer().eInverseRemove(this, ShopPackage.SHOP__CONTACTS, Shop.class, msgs);
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
		case ShopPackage.CONTACT__SHOP:
			return getShop();
		case ShopPackage.CONTACT__NAME:
			return getName();
		case ShopPackage.CONTACT__ADDRESS:
			return getAddress();
		case ShopPackage.CONTACT__CITY:
			return getCity();
		case ShopPackage.CONTACT__ZIP:
			return getZip();
		case ShopPackage.CONTACT__COUNTRY:
			return getCountry();
		case ShopPackage.CONTACT__CUSTOMER:
			return getCustomer();
		case ShopPackage.CONTACT__NEWSLETTER:
			return isNewsletter();
		case ShopPackage.CONTACT__BIRTHDAY:
			return getBirthday();
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
		case ShopPackage.CONTACT__SHOP:
			setShop((Shop) newValue);
			return;
		case ShopPackage.CONTACT__NAME:
			setName((String) newValue);
			return;
		case ShopPackage.CONTACT__ADDRESS:
			setAddress((String) newValue);
			return;
		case ShopPackage.CONTACT__CITY:
			setCity((String) newValue);
			return;
		case ShopPackage.CONTACT__ZIP:
			setZip((String) newValue);
			return;
		case ShopPackage.CONTACT__COUNTRY:
			setCountry((Country) newValue);
			return;
		case ShopPackage.CONTACT__CUSTOMER:
			setCustomer((Customer) newValue);
			return;
		case ShopPackage.CONTACT__NEWSLETTER:
			setNewsletter((Boolean) newValue);
			return;
		case ShopPackage.CONTACT__BIRTHDAY:
			setBirthday((Date) newValue);
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
		case ShopPackage.CONTACT__SHOP:
			setShop((Shop) null);
			return;
		case ShopPackage.CONTACT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ShopPackage.CONTACT__ADDRESS:
			setAddress(ADDRESS_EDEFAULT);
			return;
		case ShopPackage.CONTACT__CITY:
			setCity(CITY_EDEFAULT);
			return;
		case ShopPackage.CONTACT__ZIP:
			setZip(ZIP_EDEFAULT);
			return;
		case ShopPackage.CONTACT__COUNTRY:
			setCountry((Country) null);
			return;
		case ShopPackage.CONTACT__CUSTOMER:
			setCustomer((Customer) null);
			return;
		case ShopPackage.CONTACT__NEWSLETTER:
			setNewsletter(NEWSLETTER_EDEFAULT);
			return;
		case ShopPackage.CONTACT__BIRTHDAY:
			setBirthday(BIRTHDAY_EDEFAULT);
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
		case ShopPackage.CONTACT__SHOP:
			return getShop() != null;
		case ShopPackage.CONTACT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ShopPackage.CONTACT__ADDRESS:
			return ADDRESS_EDEFAULT == null ? address != null : !ADDRESS_EDEFAULT.equals(address);
		case ShopPackage.CONTACT__CITY:
			return CITY_EDEFAULT == null ? city != null : !CITY_EDEFAULT.equals(city);
		case ShopPackage.CONTACT__ZIP:
			return ZIP_EDEFAULT == null ? zip != null : !ZIP_EDEFAULT.equals(zip);
		case ShopPackage.CONTACT__COUNTRY:
			return country != null;
		case ShopPackage.CONTACT__CUSTOMER:
			return customer != null;
		case ShopPackage.CONTACT__NEWSLETTER:
			return newsletter != NEWSLETTER_EDEFAULT;
		case ShopPackage.CONTACT__BIRTHDAY:
			return BIRTHDAY_EDEFAULT == null ? birthday != null : !BIRTHDAY_EDEFAULT.equals(birthday);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", address: ");
		result.append(address);
		result.append(", city: ");
		result.append(city);
		result.append(", zip: ");
		result.append(zip);
		result.append(", newsletter: ");
		result.append(newsletter);
		result.append(", birthday: ");
		result.append(birthday);
		result.append(')');
		return result.toString();
	}

} // ContactImpl
