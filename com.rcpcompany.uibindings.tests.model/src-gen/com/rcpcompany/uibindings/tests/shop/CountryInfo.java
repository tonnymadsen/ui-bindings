/**
 */
package com.rcpcompany.uibindings.tests.shop;

import com.rcpcompany.uibindings.moao.IMOAO;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Country Info</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.CountryInfo#getPopulation <em>Population</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.CountryInfo#getCurrency <em>Currency</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountryInfo()
 * @generated
 */
public interface CountryInfo extends IMOAO {

	/**
	 * Returns the value of the '<em><b>Population</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Population</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Population</em>' attribute.
	 * @see #setPopulation(int)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountryInfo_Population()
	 * @generated
	 */
	int getPopulation();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.CountryInfo#getPopulation <em>Population</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Population</em>' attribute.
	 * @see #getPopulation()
	 * @generated
	 */
	void setPopulation(int value);

	/**
	 * Returns the value of the '<em><b>Currency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Currency</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Currency</em>' attribute.
	 * @see #setCurrency(String)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountryInfo_Currency()
	 * @generated
	 */
	String getCurrency();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.CountryInfo#getCurrency <em>Currency</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Currency</em>' attribute.
	 * @see #getCurrency()
	 * @generated
	 */
	void setCurrency(String value);
} // CountryInfo
