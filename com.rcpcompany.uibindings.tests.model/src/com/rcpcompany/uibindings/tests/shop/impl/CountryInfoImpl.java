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
package com.rcpcompany.uibindings.tests.shop.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.rcpcompany.uibindings.moao.internal.MOAOImpl;
import com.rcpcompany.uibindings.tests.shop.CountryInfo;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Country Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.CountryInfoImpl#getPopulation <em>Population
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.impl.CountryInfoImpl#getCurrency <em>Currency
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CountryInfoImpl extends MOAOImpl implements CountryInfo {
	/**
	 * The default value of the '{@link #getPopulation() <em>Population</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPopulation()
	 * @generated
	 * @ordered
	 */
	protected static final int POPULATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPopulation() <em>Population</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPopulation()
	 * @generated
	 * @ordered
	 */
	protected int population = POPULATION_EDEFAULT;

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
	protected CountryInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ShopPackage.Literals.COUNTRY_INFO;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getPopulation() {
		return population;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPopulation(int newPopulation) {
		final int oldPopulation = population;
		population = newPopulation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.COUNTRY_INFO__POPULATION, oldPopulation,
					population));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ShopPackage.COUNTRY_INFO__CURRENCY, oldCurrency,
					currency));
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
		case ShopPackage.COUNTRY_INFO__POPULATION:
			return getPopulation();
		case ShopPackage.COUNTRY_INFO__CURRENCY:
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
		case ShopPackage.COUNTRY_INFO__POPULATION:
			setPopulation((Integer) newValue);
			return;
		case ShopPackage.COUNTRY_INFO__CURRENCY:
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
		case ShopPackage.COUNTRY_INFO__POPULATION:
			setPopulation(POPULATION_EDEFAULT);
			return;
		case ShopPackage.COUNTRY_INFO__CURRENCY:
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
		case ShopPackage.COUNTRY_INFO__POPULATION:
			return population != POPULATION_EDEFAULT;
		case ShopPackage.COUNTRY_INFO__CURRENCY:
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
		result.append(" (population: ");
		result.append(population);
		result.append(", currency: ");
		result.append(currency);
		result.append(')');
		return result.toString();
	}

} // CountryInfoImpl
