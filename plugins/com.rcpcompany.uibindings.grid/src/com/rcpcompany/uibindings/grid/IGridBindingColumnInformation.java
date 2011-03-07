/*******************************************************************************
 * Copyright (c) 2007, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.grid;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;

import com.rcpcompany.uibindings.IDisposable;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Binding Column Information</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getGrid <em>Grid</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getId <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getRowCells <em>Row Cells
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation#getGridColumn <em>Grid
 * Column</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingColumnInformation()
 * @generated
 */
public interface IGridBindingColumnInformation extends EObject, IDisposable {
	/**
	 * Returns the value of the '<em><b>Grid</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Grid</em>' reference.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingColumnInformation_Grid()
	 * @generated
	 */
	IGridBinding getGrid();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingColumnInformation_Id()
	 * @generated
	 */
	Object getId();

	/**
	 * Returns the value of the '<em><b>Row Cells</b></em>' reference list. The list contents are of
	 * type {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation}. It is bidirectional
	 * and its opposite is '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getColumn <em>Column</em>}
	 * '. <!-- begin-user-doc -->
	 * <p>
	 * Please note that the order of cells object has no meaning.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Row Cells</em>' reference list.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingColumnInformation_RowCells()
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellInformation#getColumn
	 * @generated
	 */
	EList<IGridBindingCellInformation> getRowCells();

	/**
	 * Returns the value of the '<em><b>Grid Column</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid Column</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Grid Column</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingColumnInformation_GridColumn()
	 * @generated
	 */
	GridColumn getGridColumn();

	/**
	 * Returns the position of this column in the grid. Left column (a header) is <code>0</code>.
	 * <p>
	 * Includes row header columns (<code>GridUtils.isHeader(c.getId())</code>).
	 * 
	 * @param visualModel <code>true</code> if the visual model should be used rather than the
	 *            logical model
	 * 
	 * @return the position
	 */
	int getPosition(boolean visualModel);

	/**
	 * Returns the cell in this column with the specified item.
	 * 
	 * @param item the item to search for
	 * @return the found cell or <code>null</code>
	 */
	IGridBindingCellInformation getCell(GridItem item);
} // IGridBindingColumnInformation
