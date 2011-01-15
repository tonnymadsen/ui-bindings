/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibinding.tests.model.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibinding.tests.model.AmountAndCurrency;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Amount And Currency</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.AmountAndCurrencyImpl#getAmount <em>
 * Amount</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.AmountAndCurrencyImpl#getCurrency <em>
 * Currency</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AmountAndCurrencyImpl extends EObjectImpl implements AmountAndCurrency {
	/**
	 * The default value of the '{@link #getAmount() <em>Amount</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAmount()
	 * @generated
	 * @ordered
	 */
	protected static final float AMOUNT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getAmount() <em>Amount</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getAmount()
	 * @generated
	 * @ordered
	 */
	protected float amount = AMOUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrency() <em>Currency</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCurrency()
	 * @generated
	 * @ordered
	 */
	protected static final String CURRENCY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrency() <em>Currency</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCurrency()
	 * @generated
	 * @ordered
	 */
	protected String currency = CURRENCY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AmountAndCurrencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestModelPackage.Literals.AMOUNT_AND_CURRENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public float getAmount() {
		return amount;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setAmount(float newAmount) {
		final float oldAmount = amount;
		amount = newAmount;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.AMOUNT_AND_CURRENCY__AMOUNT,
					oldAmount, amount));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setCurrency(String newCurrency) {
		final String oldCurrency = currency;
		currency = newCurrency;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.AMOUNT_AND_CURRENCY__CURRENCY,
					oldCurrency, currency));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TestModelPackage.AMOUNT_AND_CURRENCY__AMOUNT:
			return getAmount();
		case TestModelPackage.AMOUNT_AND_CURRENCY__CURRENCY:
			return getCurrency();
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
		case TestModelPackage.AMOUNT_AND_CURRENCY__AMOUNT:
			setAmount((Float) newValue);
			return;
		case TestModelPackage.AMOUNT_AND_CURRENCY__CURRENCY:
			setCurrency((String) newValue);
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
		case TestModelPackage.AMOUNT_AND_CURRENCY__AMOUNT:
			setAmount(AMOUNT_EDEFAULT);
			return;
		case TestModelPackage.AMOUNT_AND_CURRENCY__CURRENCY:
			setCurrency(CURRENCY_EDEFAULT);
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
		case TestModelPackage.AMOUNT_AND_CURRENCY__AMOUNT:
			return amount != AMOUNT_EDEFAULT;
		case TestModelPackage.AMOUNT_AND_CURRENCY__CURRENCY:
			return CURRENCY_EDEFAULT == null ? currency != null : !CURRENCY_EDEFAULT.equals(currency);
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
		result.append(" (amount: ");
		result.append(amount);
		result.append(", currency: ");
		result.append(currency);
		result.append(')');
		return result.toString();
	}

} // AmountAndCurrencyImpl
