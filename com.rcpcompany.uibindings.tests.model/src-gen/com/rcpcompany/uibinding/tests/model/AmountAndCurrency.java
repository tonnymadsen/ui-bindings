/**
 */
package com.rcpcompany.uibinding.tests.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Amount And Currency</b></em>
 * '. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.AmountAndCurrency#getAmount <em>Amount</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.AmountAndCurrency#getCurrency <em>Currency</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getAmountAndCurrency()
 * @generated
 */
public interface AmountAndCurrency extends EObject {
	/**
	 * Returns the value of the '<em><b>Amount</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Amount</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Amount</em>' attribute.
	 * @see #setAmount(float)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getAmountAndCurrency_Amount()
	 * @generated
	 */
	float getAmount();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibinding.tests.model.AmountAndCurrency#getAmount <em>Amount</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Amount</em>' attribute.
	 * @see #getAmount()
	 * @generated
	 */
	void setAmount(float value);

	/**
	 * Returns the value of the '<em><b>Currency</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Currency</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Currency</em>' attribute.
	 * @see #setCurrency(String)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getAmountAndCurrency_Currency()
	 * @generated
	 */
	String getCurrency();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibinding.tests.model.AmountAndCurrency#getCurrency <em>Currency</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Currency</em>' attribute.
	 * @see #getCurrency()
	 * @generated
	 */
	void setCurrency(String value);

} // AmountAndCurrency
