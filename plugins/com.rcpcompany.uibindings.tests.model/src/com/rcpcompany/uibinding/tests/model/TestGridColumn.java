/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibinding.tests.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Test Grid Column</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestGridColumn#getGrid <em>Grid</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestGridColumn#getName <em>Name</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestGridColumn#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridColumn()
 * @model
 * @generated
 */
public interface TestGridColumn extends EObject {
	/**
	 * Returns the value of the '<em><b>Grid</b></em>' reference. It is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGrid#getColumns <em>Columns</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Grid</em>' reference.
	 * @see #setGrid(TestGrid)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridColumn_Grid()
	 * @see com.rcpcompany.uibinding.tests.model.TestGrid#getColumns
	 * @model opposite="columns" resolveProxies="false" transient="true"
	 * @generated
	 */
	TestGrid getGrid();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestGridColumn#getGrid <em>Grid</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Grid</em>' reference.
	 * @see #getGrid()
	 * @generated
	 */
	void setGrid(TestGrid value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridColumn_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestGridColumn#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Cells</b></em>' reference list. The list contents are of type
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridCell}. It is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridCell#getColumn <em>Column</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cells</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cells</em>' reference list.
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGridColumn_Cells()
	 * @see com.rcpcompany.uibinding.tests.model.TestGridCell#getColumn
	 * @model opposite="column" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<TestGridCell> getCells();

} // TestGridColumn
