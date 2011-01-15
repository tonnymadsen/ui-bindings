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
package com.rcpcompany.uibinding.tests.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Test Grid</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestGrid#getColumns <em>Columns</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestGrid#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGrid()
 * @model
 * @generated
 */
public interface TestGrid extends EObject {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' reference list. The list contents are of
	 * type {@link com.rcpcompany.uibinding.tests.model.TestGridColumn}. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibinding.tests.model.TestGridColumn#getGrid
	 * <em>Grid</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Columns</em>' reference list.
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGrid_Columns()
	 * @see com.rcpcompany.uibinding.tests.model.TestGridColumn#getGrid
	 * @model opposite="grid" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<TestGridColumn> getColumns();

	/**
	 * Returns the value of the '<em><b>Rows</b></em>' reference list. The list contents are of type
	 * {@link com.rcpcompany.uibinding.tests.model.TestGridRow}. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibinding.tests.model.TestGridRow#getGrid <em>Grid</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Rows</em>' reference list.
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestGrid_Rows()
	 * @see com.rcpcompany.uibinding.tests.model.TestGridRow#getGrid
	 * @model opposite="grid" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<TestGridRow> getRows();

} // TestGrid
