/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.tests.shop;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Country</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Country#getShop <em>Shop</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Country#getName <em>Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.tests.shop.Country#getAbbreviation <em>Abbreviation</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountry()
 * @model annotation="http://rcp-company.com/schemas/uibindings featureName='abbreviation'"
 * @generated
 */
public interface Country extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountry_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Country#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Abbreviation</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abbreviation</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Abbreviation</em>' attribute.
	 * @see #setAbbreviation(String)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountry_Abbreviation()
	 * @model required="true"
	 * @generated
	 */
	String getAbbreviation();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Country#getAbbreviation <em>Abbreviation</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Abbreviation</em>' attribute.
	 * @see #getAbbreviation()
	 * @generated
	 */
	void setAbbreviation(String value);

	/**
	 * Returns the value of the '<em><b>Shop</b></em>' container reference. It is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.tests.shop.Shop#getCountries <em>Countries</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shop</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Shop</em>' container reference.
	 * @see #setShop(Shop)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountry_Shop()
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getCountries
	 * @model opposite="countries" resolveProxies="false" required="true" transient="false"
	 * @generated
	 */
	Shop getShop();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Country#getShop <em>Shop</em>}' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Shop</em>' container reference.
	 * @see #getShop()
	 * @generated
	 */
	void setShop(Shop value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model diagnosticsDataType="com.rcpcompany.uibindings.tests.shop.DiagnosticChain" diagnosticsRequired="true"
	 * @generated
	 */
	boolean abbreviationLengthOK(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model diagnosticsDataType="com.rcpcompany.uibindings.tests.shop.DiagnosticChain" diagnosticsRequired="true"
	 * @generated
	 */
	boolean abbreviationCaseOK(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Country
