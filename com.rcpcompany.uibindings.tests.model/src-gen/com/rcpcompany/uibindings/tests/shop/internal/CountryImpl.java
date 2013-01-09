/**
 */
package com.rcpcompany.uibindings.tests.shop.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.moao.internal.NamedObjectImpl;
import com.rcpcompany.uibindings.model.utils.EValidatorAdapterUtils;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.CountryInfo;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.shop.util.ShopValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Country</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.CountryImpl#getShop <em>Shop</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.CountryImpl#getAbbreviation <em>Abbreviation</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.CountryImpl#getContacts <em>Contacts</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.internal.CountryImpl#getInformation <em>Information</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CountryImpl extends NamedObjectImpl implements Country {
	/**
	 * The default value of the '{@link #getAbbreviation() <em>Abbreviation</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAbbreviation()
	 * @generated
	 * @ordered
	 */
	protected static final String ABBREVIATION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAbbreviation() <em>Abbreviation</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAbbreviation()
	 * @generated
	 * @ordered
	 */
	protected String abbreviation = ABBREVIATION_EDEFAULT;
	/**
	 * The cached value of the '{@link #getContacts() <em>Contacts</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getContacts()
	 * @generated
	 * @ordered
	 */
	protected EList<Contact> contacts;
	/**
	 * The cached value of the '{@link #getInformation() <em>Information</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInformation()
	 * @generated
	 * @ordered
	 */
	protected CountryInfo information;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CountryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.COUNTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Shop getShop() {
		if (eContainerFeatureID() != ShopPackage.COUNTRY__SHOP) return null;
		return (Shop) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShop(Shop newShop, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newShop, ShopPackage.COUNTRY__SHOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setShop(Shop newShop) {
		if (newShop != eInternalContainer() || (eContainerFeatureID() != ShopPackage.COUNTRY__SHOP && newShop != null)) {
			if (EcoreUtil.isAncestor(this, newShop))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
			NotificationChain msgs = null;
			if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
			if (newShop != null)
				msgs = ((InternalEObject) newShop).eInverseAdd(this, ShopPackage.SHOP__COUNTRIES, Shop.class, msgs);
			msgs = basicSetShop(newShop, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.COUNTRY__SHOP, newShop, newShop));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAbbreviation(String newAbbreviation) {
		String oldAbbreviation = abbreviation;
		abbreviation = newAbbreviation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.COUNTRY__ABBREVIATION, oldAbbreviation,
					abbreviation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Contact> getContacts() {
		if (contacts == null) {
			contacts = new EObjectWithInverseResolvingEList<Contact>(Contact.class, this,
					ShopPackage.COUNTRY__CONTACTS, ShopPackage.CONTACT__COUNTRY);
		}
		return contacts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CountryInfo getInformation() {
		return information;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInformation(CountryInfo newInformation, NotificationChain msgs) {
		CountryInfo oldInformation = information;
		information = newInformation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ShopPackage.COUNTRY__INFORMATION, oldInformation, newInformation);
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
	@Override
	public void setInformation(CountryInfo newInformation) {
		if (newInformation != information) {
			NotificationChain msgs = null;
			if (information != null)
				msgs = ((InternalEObject) information).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- ShopPackage.COUNTRY__INFORMATION, null, msgs);
			if (newInformation != null)
				msgs = ((InternalEObject) newInformation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- ShopPackage.COUNTRY__INFORMATION, null, msgs);
			msgs = basicSetInformation(newInformation, msgs);
			if (msgs != null) msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.COUNTRY__INFORMATION, newInformation,
					newInformation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean abbreviationLengthOK(DiagnosticChain diagnostics, Map<Object, Object> context) {
		final String a = getAbbreviation();
		if (a != null && a.length() != 2) {
			EValidatorAdapterUtils.addError(diagnostics, ShopValidator.DIAGNOSTIC_SOURCE,
					ShopValidator.COUNTRY__ABBREVIATION_LENGTH_OK, "The country abbreviation must be 2 letters", this,
					ShopPackage.Literals.COUNTRY__ABBREVIATION);
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
	public boolean abbreviationCaseOK(DiagnosticChain diagnostics, Map<Object, Object> context) {
		final String a = getAbbreviation();
		if (a != null) {
			for (int i = 0; i < a.length(); i++) {
				if (!Character.isUpperCase(a.charAt(i))) {
					EValidatorAdapterUtils.addWarning(diagnostics, ShopValidator.DIAGNOSTIC_SOURCE,
							ShopValidator.COUNTRY__ABBREVIATION_CASE_OK, "The country abbreviation '" + a
									+ "' should be in uppercase letters only", this,
							ShopPackage.Literals.COUNTRY__ABBREVIATION);
					return false;
				}
			}
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
		case ShopPackage.COUNTRY__SHOP:
			if (eInternalContainer() != null) msgs = eBasicRemoveFromContainer(msgs);
			return basicSetShop((Shop) otherEnd, msgs);
		case ShopPackage.COUNTRY__CONTACTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getContacts()).basicAdd(otherEnd, msgs);
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
		case ShopPackage.COUNTRY__SHOP:
			return basicSetShop(null, msgs);
		case ShopPackage.COUNTRY__CONTACTS:
			return ((InternalEList<?>) getContacts()).basicRemove(otherEnd, msgs);
		case ShopPackage.COUNTRY__INFORMATION:
			return basicSetInformation(null, msgs);
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
		case ShopPackage.COUNTRY__SHOP:
			return eInternalContainer().eInverseRemove(this, ShopPackage.SHOP__COUNTRIES, Shop.class, msgs);
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
		case ShopPackage.COUNTRY__SHOP:
			return getShop();
		case ShopPackage.COUNTRY__ABBREVIATION:
			return getAbbreviation();
		case ShopPackage.COUNTRY__CONTACTS:
			return getContacts();
		case ShopPackage.COUNTRY__INFORMATION:
			return getInformation();
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
		case ShopPackage.COUNTRY__SHOP:
			setShop((Shop) newValue);
			return;
		case ShopPackage.COUNTRY__ABBREVIATION:
			setAbbreviation((String) newValue);
			return;
		case ShopPackage.COUNTRY__CONTACTS:
			getContacts().clear();
			getContacts().addAll((Collection<? extends Contact>) newValue);
			return;
		case ShopPackage.COUNTRY__INFORMATION:
			setInformation((CountryInfo) newValue);
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
		case ShopPackage.COUNTRY__SHOP:
			setShop((Shop) null);
			return;
		case ShopPackage.COUNTRY__ABBREVIATION:
			setAbbreviation(ABBREVIATION_EDEFAULT);
			return;
		case ShopPackage.COUNTRY__CONTACTS:
			getContacts().clear();
			return;
		case ShopPackage.COUNTRY__INFORMATION:
			setInformation((CountryInfo) null);
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
		case ShopPackage.COUNTRY__SHOP:
			return getShop() != null;
		case ShopPackage.COUNTRY__ABBREVIATION:
			return ABBREVIATION_EDEFAULT == null ? abbreviation != null : !ABBREVIATION_EDEFAULT.equals(abbreviation);
		case ShopPackage.COUNTRY__CONTACTS:
			return contacts != null && !contacts.isEmpty();
		case ShopPackage.COUNTRY__INFORMATION:
			return information != null;
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
		case ShopPackage.COUNTRY___ABBREVIATION_LENGTH_OK__DIAGNOSTICCHAIN_MAP:
			return abbreviationLengthOK((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
		case ShopPackage.COUNTRY___ABBREVIATION_CASE_OK__DIAGNOSTICCHAIN_MAP:
			return abbreviationCaseOK((DiagnosticChain) arguments.get(0), (Map<Object, Object>) arguments.get(1));
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
		result.append(" (abbreviation: "); //$NON-NLS-1$
		result.append(abbreviation);
		result.append(')');
		return result.toString();
	}

} // CountryImpl
