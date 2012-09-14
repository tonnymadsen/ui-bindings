/**
 */
package com.rcpcompany.uibinding.tests.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Grid Cell</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibinding.tests.model.TestGridCell#getDetails <em>Details</em>}</li>
 *   <li>{@link com.rcpcompany.uibinding.tests.model.TestGridCell#getPrice <em>Price</em>}</li>
 *   <li>{@link com.rcpcompany.uibinding.tests.model.TestGridCell#getColumn <em>Column</em>}</li>
 *   <li>{@link com.rcpcompany.uibinding.tests.model.TestGridCell#getRow <em>Row</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridCell()
 * @generated
 */
public interface TestGridCell extends EObject {
	/**
	 * Returns the value of the '<em><b>Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details</em>' attribute.
	 * @see #setDetails(String)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridCell_Details()
	 * @generated
	 */
	String getDetails();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestGridCell#getDetails <em>Details</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Details</em>' attribute.
	 * @see #getDetails()
	 * @generated
	 */
	void setDetails(String value);

	/**
	 * Returns the value of the '<em><b>Price</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Price</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Price</em>' attribute.
	 * @see #setPrice(float)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridCell_Price()
	 * @generated
	 */
	float getPrice();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestGridCell#getPrice <em>Price</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Price</em>' attribute.
	 * @see #getPrice()
	 * @generated
	 */
	void setPrice(float value);

	/**
	 * Returns the value of the '<em><b>Column</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibinding.tests.model.TestGridColumn#getCells <em>Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' reference.
	 * @see #setColumn(TestGridColumn)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridCell_Column()
	 * @see com.rcpcompany.uibinding.tests.model.TestGridColumn#getCells
	 * @generated
	 */
	TestGridColumn getColumn();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestGridCell#getColumn <em>Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' reference.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(TestGridColumn value);

	/**
	 * Returns the value of the '<em><b>Row</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibinding.tests.model.TestGridRow#getCells <em>Cells</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row</em>' reference.
	 * @see #setRow(TestGridRow)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridCell_Row()
	 * @see com.rcpcompany.uibinding.tests.model.TestGridRow#getCells
	 * @generated
	 */
	TestGridRow getRow();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestGridCell#getRow <em>Row</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row</em>' reference.
	 * @see #getRow()
	 * @generated
	 */
	void setRow(TestGridRow value);

} // TestGridCell
