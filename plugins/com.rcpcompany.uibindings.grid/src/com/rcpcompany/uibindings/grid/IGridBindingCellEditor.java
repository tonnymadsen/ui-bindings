/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.grid;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.nebula.widgets.grid.GridEditor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Binding Cell Editor</b></em>
 * '. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getGrid <em>Grid</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getGridEditor <em>Grid Editor
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getActiveEditCell <em>Active
 * Edit Cell</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellEditor()
 * @generated
 */
public interface IGridBindingCellEditor extends EObject {
	/**
	 * Returns the value of the '<em><b>Grid</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.grid.IGridBinding#getCellEditor
	 * <em>Cell Editor</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid</em>' container reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Grid</em>' reference.
	 * @see #setGrid(IGridBinding)
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellEditor_Grid()
	 * @see com.rcpcompany.uibindings.grid.IGridBinding#getCellEditor
	 * @generated
	 */
	IGridBinding getGrid();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getGrid
	 * <em>Grid</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Grid</em>' reference.
	 * @see #getGrid()
	 * @generated
	 */
	void setGrid(IGridBinding value);

	/**
	 * Returns the value of the '<em><b>Grid Editor</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid Editor</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Grid Editor</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellEditor_GridEditor()
	 * @generated
	 */
	GridEditor getGridEditor();

	/**
	 * Returns the value of the '<em><b>Active Edit Cell</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Active Edit Cell</em>' reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Active Edit Cell</em>' reference.
	 * @see #setActiveEditCell(IGridBindingCellInformation)
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBindingCellEditor_ActiveEditCell()
	 * @generated
	 */
	IGridBindingCellInformation getActiveEditCell();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getActiveEditCell
	 * <em>Active Edit Cell</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Active Edit Cell</em>' reference.
	 * @see #getActiveEditCell()
	 * @generated
	 */
	void setActiveEditCell(IGridBindingCellInformation value);

	/**
	 * Starts editing of the specified cell based on the specified SWT event.
	 * 
	 * @param cell the cell to edit
	 * @param event the SWT event that triggered the editing session
	 */
	void editCell(IGridBindingCellInformation cell, ColumnViewerEditorActivationEvent event);

	/**
	 * Accepts the current value of the current edit session.
	 */
	void acceptEdit();

	/**
	 * Cancels the current value of the current edit session.
	 */
	void cancelEdit();
} // IGridBindingCellEditor
