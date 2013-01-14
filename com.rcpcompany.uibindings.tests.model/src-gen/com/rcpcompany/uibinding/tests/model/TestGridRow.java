/**
 */
package com.rcpcompany.uibinding.tests.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Test Grid Row</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestGridRow#getGrid <em>Grid</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestGridRow#getNumber <em>Number</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestGridRow#getCells <em>Cells</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridRow()
 * @generated
 */
public interface TestGridRow extends EObject {
	/**
	 * Returns the value of the '<em><b>Grid</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibinding.tests.model.TestGrid#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Grid</em>' reference.
	 * @see #setGrid(TestGrid)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridRow_Grid()
	 * @see com.rcpcompany.uibinding.tests.model.TestGrid#getRows
	 * @generated
	 */
	TestGrid getGrid();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestGridRow#getGrid
	 * <em>Grid</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Grid</em>' reference.
	 * @see #getGrid()
	 * @generated
	 */
	void setGrid(TestGrid value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridRow_Number()
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestGridRow#getNumber
	 * <em>Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Cells</b></em>' reference list. The list contents are of
	 * type {@link com.rcpcompany.uibinding.tests.model.TestGridCell}. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibinding.tests.model.TestGridCell#getRow <em>Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cells</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cells</em>' reference list.
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridRow_Cells()
	 * @see com.rcpcompany.uibinding.tests.model.TestGridCell#getRow
	 * @generated
	 */
	EList<TestGridCell> getCells();

} // TestGridRow
