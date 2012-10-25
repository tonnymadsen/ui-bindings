/**
 */
package com.rcpcompany.uibindings.tests.shop.internal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.internal.NamedObjectImpl;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.CustomerGroup;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopInformation;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.shop.util.ShopValidator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Shop</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getNextOrderNo <em>Next Order No</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getNextCustomerNo <em>Next Customer No</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getTmpDir <em>Tmp Dir</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getCountries <em>Countries</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getContacts <em>Contacts</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getShopItems <em>Shop Items</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getOrders <em>Orders</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getCustomers <em>Customers</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getCustomerGroups <em>Customer Groups</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getShopGroups <em>Shop Groups</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.ShopImpl#getInfos <em>Infos</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ShopImpl extends NamedObjectImpl implements Shop {
	/**
	 * The default value of the '{@link #getNextOrderNo() <em>Next Order No</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNextOrderNo()
	 * @generated
	 * @ordered
	 */
	protected static final int NEXT_ORDER_NO_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getNextOrderNo() <em>Next Order No</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNextOrderNo()
	 * @generated
	 * @ordered
	 */
	protected int nextOrderNo = NEXT_ORDER_NO_EDEFAULT;
	/**
	 * The default value of the '{@link #getNextCustomerNo() <em>Next Customer No</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNextCustomerNo()
	 * @generated
	 * @ordered
	 */
	protected static final int NEXT_CUSTOMER_NO_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getNextCustomerNo() <em>Next Customer No</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNextCustomerNo()
	 * @generated
	 * @ordered
	 */
	protected int nextCustomerNo = NEXT_CUSTOMER_NO_EDEFAULT;
	/**
	 * The default value of the '{@link #getTmpDir() <em>Tmp Dir</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTmpDir()
	 * @generated
	 * @ordered
	 */
	protected static final String TMP_DIR_EDEFAULT = "C:\\Windows\\Temp"; //$NON-NLS-1$
	/**
	 * The cached value of the '{@link #getTmpDir() <em>Tmp Dir</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTmpDir()
	 * @generated
	 * @ordered
	 */
	protected String tmpDir = TMP_DIR_EDEFAULT;
	/**
	 * The cached value of the '{@link #getCountries() <em>Countries</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCountries()
	 * @generated
	 * @ordered
	 */
	protected EList<Country> countries;
	/**
	 * The cached value of the '{@link #getContacts() <em>Contacts</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContacts()
	 * @generated
	 * @ordered
	 */
	protected EList<Contact> contacts;
	/**
	 * The cached value of the '{@link #getShopItems() <em>Shop Items</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getShopItems()
	 * @generated
	 * @ordered
	 */
	protected EList<ShopItem> shopItems;
	/**
	 * The cached value of the '{@link #getOrders() <em>Orders</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOrders()
	 * @generated
	 * @ordered
	 */
	protected EList<Order> orders;
	/**
	 * The cached value of the '{@link #getCustomers() <em>Customers</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCustomers()
	 * @generated
	 * @ordered
	 */
	protected EList<Customer> customers;
	/**
	 * The cached value of the '{@link #getCustomerGroups() <em>Customer Groups</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCustomerGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<CustomerGroup> customerGroups;
	/**
	 * The cached value of the '{@link #getShopGroups() <em>Shop Groups</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getShopGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<ShopItemGroup> shopGroups;
	/**
	 * The cached value of the '{@link #getInfos() <em>Infos</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<ShopInformation> infos;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ShopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.SHOP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getNextOrderNo() {
		return nextOrderNo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextOrderNo(int newNextOrderNo) {
		int oldNextOrderNo = nextOrderNo;
		nextOrderNo = newNextOrderNo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP__NEXT_ORDER_NO, oldNextOrderNo,
					nextOrderNo));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getNextCustomerNo() {
		return nextCustomerNo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextCustomerNo(int newNextCustomerNo) {
		int oldNextCustomerNo = nextCustomerNo;
		nextCustomerNo = newNextCustomerNo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP__NEXT_CUSTOMER_NO,
					oldNextCustomerNo, nextCustomerNo));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTmpDir() {
		return tmpDir;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTmpDir(String newTmpDir) {
		String oldTmpDir = tmpDir;
		tmpDir = newTmpDir;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.SHOP__TMP_DIR, oldTmpDir, tmpDir));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Country> getCountries() {
		if (countries == null) {
			countries = new EObjectContainmentWithInverseEList<Country>(Country.class, this,
					ShopPackage.SHOP__COUNTRIES, ShopPackage.COUNTRY__SHOP);
		}
		return countries;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Contact> getContacts() {
		if (contacts == null) {
			contacts = new EObjectContainmentWithInverseEList<Contact>(Contact.class, this, ShopPackage.SHOP__CONTACTS,
					ShopPackage.CONTACT__SHOP);
		}
		return contacts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ShopItem> getShopItems() {
		if (shopItems == null) {
			shopItems = new EObjectContainmentWithInverseEList<ShopItem>(ShopItem.class, this,
					ShopPackage.SHOP__SHOP_ITEMS, ShopPackage.SHOP_ITEM__SHOP);
		}
		return shopItems;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Order> getOrders() {
		if (orders == null) {
			orders = new EObjectContainmentWithInverseEList<Order>(Order.class, this, ShopPackage.SHOP__ORDERS,
					ShopPackage.ORDER__SHOP);
		}
		return orders;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Customer> getCustomers() {
		if (customers == null) {
			customers = new EObjectContainmentWithInverseEList<Customer>(Customer.class, this,
					ShopPackage.SHOP__CUSTOMERS, ShopPackage.CUSTOMER__SHOP);
		}
		return customers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CustomerGroup> getCustomerGroups() {
		if (customerGroups == null) {
			customerGroups = new EObjectContainmentWithInverseEList<CustomerGroup>(CustomerGroup.class, this,
					ShopPackage.SHOP__CUSTOMER_GROUPS, ShopPackage.CUSTOMER_GROUP__SHOP);
		}
		return customerGroups;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ShopItemGroup> getShopGroups() {
		if (shopGroups == null) {
			shopGroups = new EObjectContainmentWithInverseEList<ShopItemGroup>(ShopItemGroup.class, this,
					ShopPackage.SHOP__SHOP_GROUPS, ShopPackage.SHOP_ITEM_GROUP__SHOP);
		}
		return shopGroups;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ShopInformation> getInfos() {
		if (infos == null) {
			infos = new EObjectContainmentEList<ShopInformation>(ShopInformation.class, this, ShopPackage.SHOP__INFOS);
		}
		return infos;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void save() {
		try {
			eResource().save(null);
		} catch (final IOException ex) {
			LogUtils.error(this, ex);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean nameLengthOK(DiagnosticChain diagnostics, Map<Object, Object> context) {
		final String a = getName();
		if (a != null && a.length() < 2) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, ShopValidator.DIAGNOSTIC_SOURCE,
						ShopValidator.SHOP__NAME_LENGTH_OK, "The name must be at least 2 letters", new Object[] { this,
								IMOAOPackage.Literals.NAMED_OBJECT__NAME }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ShopPackage.SHOP__COUNTRIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getCountries()).basicAdd(otherEnd, msgs);
		case ShopPackage.SHOP__CONTACTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getContacts()).basicAdd(otherEnd, msgs);
		case ShopPackage.SHOP__SHOP_ITEMS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getShopItems()).basicAdd(otherEnd, msgs);
		case ShopPackage.SHOP__ORDERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getOrders()).basicAdd(otherEnd, msgs);
		case ShopPackage.SHOP__CUSTOMERS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getCustomers()).basicAdd(otherEnd, msgs);
		case ShopPackage.SHOP__CUSTOMER_GROUPS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getCustomerGroups()).basicAdd(otherEnd, msgs);
		case ShopPackage.SHOP__SHOP_GROUPS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getShopGroups()).basicAdd(otherEnd, msgs);
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
		case ShopPackage.SHOP__COUNTRIES:
			return ((InternalEList<?>) getCountries()).basicRemove(otherEnd, msgs);
		case ShopPackage.SHOP__CONTACTS:
			return ((InternalEList<?>) getContacts()).basicRemove(otherEnd, msgs);
		case ShopPackage.SHOP__SHOP_ITEMS:
			return ((InternalEList<?>) getShopItems()).basicRemove(otherEnd, msgs);
		case ShopPackage.SHOP__ORDERS:
			return ((InternalEList<?>) getOrders()).basicRemove(otherEnd, msgs);
		case ShopPackage.SHOP__CUSTOMERS:
			return ((InternalEList<?>) getCustomers()).basicRemove(otherEnd, msgs);
		case ShopPackage.SHOP__CUSTOMER_GROUPS:
			return ((InternalEList<?>) getCustomerGroups()).basicRemove(otherEnd, msgs);
		case ShopPackage.SHOP__SHOP_GROUPS:
			return ((InternalEList<?>) getShopGroups()).basicRemove(otherEnd, msgs);
		case ShopPackage.SHOP__INFOS:
			return ((InternalEList<?>) getInfos()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ShopPackage.SHOP__NEXT_ORDER_NO:
			return getNextOrderNo();
		case ShopPackage.SHOP__NEXT_CUSTOMER_NO:
			return getNextCustomerNo();
		case ShopPackage.SHOP__TMP_DIR:
			return getTmpDir();
		case ShopPackage.SHOP__COUNTRIES:
			return getCountries();
		case ShopPackage.SHOP__CONTACTS:
			return getContacts();
		case ShopPackage.SHOP__SHOP_ITEMS:
			return getShopItems();
		case ShopPackage.SHOP__ORDERS:
			return getOrders();
		case ShopPackage.SHOP__CUSTOMERS:
			return getCustomers();
		case ShopPackage.SHOP__CUSTOMER_GROUPS:
			return getCustomerGroups();
		case ShopPackage.SHOP__SHOP_GROUPS:
			return getShopGroups();
		case ShopPackage.SHOP__INFOS:
			return getInfos();
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
		case ShopPackage.SHOP__NEXT_ORDER_NO:
			setNextOrderNo((Integer) newValue);
			return;
		case ShopPackage.SHOP__NEXT_CUSTOMER_NO:
			setNextCustomerNo((Integer) newValue);
			return;
		case ShopPackage.SHOP__TMP_DIR:
			setTmpDir((String) newValue);
			return;
		case ShopPackage.SHOP__COUNTRIES:
			getCountries().clear();
			getCountries().addAll((Collection<? extends Country>) newValue);
			return;
		case ShopPackage.SHOP__CONTACTS:
			getContacts().clear();
			getContacts().addAll((Collection<? extends Contact>) newValue);
			return;
		case ShopPackage.SHOP__SHOP_ITEMS:
			getShopItems().clear();
			getShopItems().addAll((Collection<? extends ShopItem>) newValue);
			return;
		case ShopPackage.SHOP__ORDERS:
			getOrders().clear();
			getOrders().addAll((Collection<? extends Order>) newValue);
			return;
		case ShopPackage.SHOP__CUSTOMERS:
			getCustomers().clear();
			getCustomers().addAll((Collection<? extends Customer>) newValue);
			return;
		case ShopPackage.SHOP__CUSTOMER_GROUPS:
			getCustomerGroups().clear();
			getCustomerGroups().addAll((Collection<? extends CustomerGroup>) newValue);
			return;
		case ShopPackage.SHOP__SHOP_GROUPS:
			getShopGroups().clear();
			getShopGroups().addAll((Collection<? extends ShopItemGroup>) newValue);
			return;
		case ShopPackage.SHOP__INFOS:
			getInfos().clear();
			getInfos().addAll((Collection<? extends ShopInformation>) newValue);
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
		case ShopPackage.SHOP__NEXT_ORDER_NO:
			setNextOrderNo(NEXT_ORDER_NO_EDEFAULT);
			return;
		case ShopPackage.SHOP__NEXT_CUSTOMER_NO:
			setNextCustomerNo(NEXT_CUSTOMER_NO_EDEFAULT);
			return;
		case ShopPackage.SHOP__TMP_DIR:
			setTmpDir(TMP_DIR_EDEFAULT);
			return;
		case ShopPackage.SHOP__COUNTRIES:
			getCountries().clear();
			return;
		case ShopPackage.SHOP__CONTACTS:
			getContacts().clear();
			return;
		case ShopPackage.SHOP__SHOP_ITEMS:
			getShopItems().clear();
			return;
		case ShopPackage.SHOP__ORDERS:
			getOrders().clear();
			return;
		case ShopPackage.SHOP__CUSTOMERS:
			getCustomers().clear();
			return;
		case ShopPackage.SHOP__CUSTOMER_GROUPS:
			getCustomerGroups().clear();
			return;
		case ShopPackage.SHOP__SHOP_GROUPS:
			getShopGroups().clear();
			return;
		case ShopPackage.SHOP__INFOS:
			getInfos().clear();
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
		case ShopPackage.SHOP__NEXT_ORDER_NO:
			return nextOrderNo != NEXT_ORDER_NO_EDEFAULT;
		case ShopPackage.SHOP__NEXT_CUSTOMER_NO:
			return nextCustomerNo != NEXT_CUSTOMER_NO_EDEFAULT;
		case ShopPackage.SHOP__TMP_DIR:
			return TMP_DIR_EDEFAULT == null ? tmpDir != null : !TMP_DIR_EDEFAULT.equals(tmpDir);
		case ShopPackage.SHOP__COUNTRIES:
			return countries != null && !countries.isEmpty();
		case ShopPackage.SHOP__CONTACTS:
			return contacts != null && !contacts.isEmpty();
		case ShopPackage.SHOP__SHOP_ITEMS:
			return shopItems != null && !shopItems.isEmpty();
		case ShopPackage.SHOP__ORDERS:
			return orders != null && !orders.isEmpty();
		case ShopPackage.SHOP__CUSTOMERS:
			return customers != null && !customers.isEmpty();
		case ShopPackage.SHOP__CUSTOMER_GROUPS:
			return customerGroups != null && !customerGroups.isEmpty();
		case ShopPackage.SHOP__SHOP_GROUPS:
			return shopGroups != null && !shopGroups.isEmpty();
		case ShopPackage.SHOP__INFOS:
			return infos != null && !infos.isEmpty();
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
		case ShopPackage.SHOP___SAVE:
			save();
			return null;
		case ShopPackage.SHOP___NAME_LENGTH_OK__DIAGNOSTICCHAIN_MAP:
			return nameLengthOK((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
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
		result.append(" (nextOrderNo: "); //$NON-NLS-1$
		result.append(nextOrderNo);
		result.append(", nextCustomerNo: "); //$NON-NLS-1$
		result.append(nextCustomerNo);
		result.append(", tmpDir: "); //$NON-NLS-1$
		result.append(tmpDir);
		result.append(')');
		return result.toString();
	}

} // ShopImpl
