/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.moao.internal.NamedObjectImpl;
import com.rcpcompany.uibindings.model.utils.EValidatorAdapterUtils;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.shop.util.ShopValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Country</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.CountryImpl#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.CountryImpl#getAbbreviation <em>Abbreviation
 * </em>}</li>
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CountryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.COUNTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getAbbreviation() {
		return abbreviation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setAbbreviation(String newAbbreviation) {
		final String oldAbbreviation = abbreviation;
		abbreviation = newAbbreviation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.COUNTRY__ABBREVIATION, oldAbbreviation,
					abbreviation));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Shop getShop() {
		if (eContainerFeatureID() != ShopPackage.COUNTRY__SHOP) return null;
		return (Shop) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetShop(Shop newShop, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newShop, ShopPackage.COUNTRY__SHOP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setShop(Shop newShop) {
		if (newShop != eInternalContainer() || (eContainerFeatureID() != ShopPackage.COUNTRY__SHOP && newShop != null)) {
			if (EcoreUtil.isAncestor(this, newShop))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newShop != null) {
				msgs = ((InternalEObject) newShop).eInverseAdd(this, ShopPackage.SHOP__COUNTRIES, Shop.class, msgs);
			}
			msgs = basicSetShop(newShop, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.COUNTRY__SHOP, newShop, newShop));
		}
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
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ShopPackage.COUNTRY__SHOP:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetShop((Shop) otherEnd, msgs);
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
		case ShopPackage.COUNTRY__SHOP:
			return basicSetShop(null, msgs);
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
		case ShopPackage.COUNTRY__SHOP:
			return eInternalContainer().eInverseRemove(this, ShopPackage.SHOP__COUNTRIES, Shop.class, msgs);
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
		case ShopPackage.COUNTRY__SHOP:
			return getShop();
		case ShopPackage.COUNTRY__ABBREVIATION:
			return getAbbreviation();
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
		case ShopPackage.COUNTRY__SHOP:
			setShop((Shop) newValue);
			return;
		case ShopPackage.COUNTRY__ABBREVIATION:
			setAbbreviation((String) newValue);
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
		case ShopPackage.COUNTRY__SHOP:
			setShop((Shop) null);
			return;
		case ShopPackage.COUNTRY__ABBREVIATION:
			setAbbreviation(ABBREVIATION_EDEFAULT);
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
		case ShopPackage.COUNTRY__SHOP:
			return getShop() != null;
		case ShopPackage.COUNTRY__ABBREVIATION:
			return ABBREVIATION_EDEFAULT == null ? abbreviation != null : !ABBREVIATION_EDEFAULT.equals(abbreviation);
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
		result.append(" (abbreviation: ");
		result.append(abbreviation);
		result.append(')');
		return result.toString();
	}

} // CountryImpl
