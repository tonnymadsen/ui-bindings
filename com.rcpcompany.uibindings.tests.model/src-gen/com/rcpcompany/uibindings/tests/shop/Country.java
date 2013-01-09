/**
 */
package com.rcpcompany.uibindings.tests.shop;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import com.rcpcompany.uibindings.moao.INamedObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Country</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.Country#getShop <em>Shop</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.Country#getAbbreviation <em>Abbreviation</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.Country#getContacts <em>Contacts</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.tests.shop.Country#getInformation <em>Information</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountry()
 * @generated
 */
public interface Country extends INamedObject {

	/**
	 * Returns the value of the '<em><b>Shop</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.tests.shop.Shop#getCountries <em>Countries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shop</em>' container reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shop</em>' container reference.
	 * @see #setShop(Shop)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountry_Shop()
	 * @see com.rcpcompany.uibindings.tests.shop.Shop#getCountries
	 * @generated
	 */
	Shop getShop();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Country#getShop <em>Shop</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shop</em>' container reference.
	 * @see #getShop()
	 * @generated
	 */
	void setShop(Shop value);

	/**
	 * Returns the value of the '<em><b>Abbreviation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abbreviation</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abbreviation</em>' attribute.
	 * @see #setAbbreviation(String)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountry_Abbreviation()
	 * @generated
	 */
	String getAbbreviation();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Country#getAbbreviation <em>Abbreviation</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abbreviation</em>' attribute.
	 * @see #getAbbreviation()
	 * @generated
	 */
	void setAbbreviation(String value);

	/**
	 * Returns the value of the '<em><b>Contacts</b></em>' reference list.
	 * The list contents are of type {@link com.rcpcompany.uibindings.tests.shop.Contact}.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.tests.shop.Contact#getCountry <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contacts</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contacts</em>' reference list.
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountry_Contacts()
	 * @see com.rcpcompany.uibindings.tests.shop.Contact#getCountry
	 * @generated
	 */
	EList<Contact> getContacts();

	/**
	 * Returns the value of the '<em><b>Information</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Information</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Information</em>' containment reference.
	 * @see #setInformation(CountryInfo)
	 * @see com.rcpcompany.uibindings.tests.shop.ShopPackage#getCountry_Information()
	 * @generated
	 */
	CountryInfo getInformation();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.tests.shop.Country#getInformation <em>Information</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Information</em>' containment reference.
	 * @see #getInformation()
	 * @generated
	 */
	void setInformation(CountryInfo value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	boolean abbreviationLengthOK(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	boolean abbreviationCaseOK(DiagnosticChain diagnostics, Map<Object, Object> context);
} // Country
