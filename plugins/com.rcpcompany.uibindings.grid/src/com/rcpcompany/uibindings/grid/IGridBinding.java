/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.grid;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;

import com.rcpcompany.uibindings.IArgumentProvider;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.grid.internal.GridBindingImpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Binding</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBinding#getNoColumnHeaders <em>No Column Headers
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBinding#getColumns <em>Columns</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBinding#getNoRowHeaders <em>No Row Headers</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBinding#getRows <em>Rows</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBinding#getGrid <em>Grid</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBinding#getModel <em>Model</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBinding#getFocusCell <em>Focus Cell</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.IGridBinding#getCellEditor <em>Cell Editor</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBinding()
 * @generated
 */
public interface IGridBinding extends IContainerBinding, IArgumentProvider {
	/**
	 * Returns the value of the '<em><b>No Column Headers</b></em>' attribute. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>No Column Headers</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>No Column Headers</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBinding_NoColumnHeaders()
	 * @generated
	 */
	int getNoColumnHeaders();

	/**
	 * Returns the value of the '<em><b>Cell Editor</b></em>' containment reference. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getGrid <em>Grid</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cell Editor</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cell Editor</em>' containment reference.
	 * @see #setCellEditor(IGridBindingCellEditor)
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBinding_CellEditor()
	 * @see com.rcpcompany.uibindings.grid.IGridBindingCellEditor#getGrid
	 * @model opposite="grid" containment="true" transient="true"
	 * @generated
	 */
	IGridBindingCellEditor getCellEditor();

	/**
	 * Returns whether this grid is currently being edited.
	 * 
	 * @return <code>true</code> if the grid is being edited, <code>false</code> otherwise
	 */
	boolean isEditing();

	/**
	 * Starts editing of the specified cell based on the specified SWT event.
	 * 
	 * @param cell the cell to edit
	 * @param event the SWT event that triggered the editing session
	 */
	void editCell(IGridBindingCellInformation cell, ColumnViewerEditorActivationEvent event);

	/**
	 * Returns the value of the '<em><b>Rows</b></em>' map. The key is of type
	 * {@link java.lang.Object}, and the value is of type
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingRowInformation}, <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Rows</em>' map.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBinding_Rows()
	 * @generated
	 */
	EMap<Object, IGridBindingRowInformation> getRows();

	/**
	 * Returns the value of the '<em><b>Grid</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grid</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Grid</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBinding_Grid()
	 * @generated
	 */
	Grid getGrid();

	/**
	 * Returns the value of the '<em><b>Model</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBinding_Model()
	 * @generated
	 */
	IGridModel getModel();

	/**
	 * Returns the value of the '<em><b>Focus Cell</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Focus Cell</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Focus Cell</em>' reference.
	 * @see #setFocusCell(IGridBindingCellInformation)
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBinding_FocusCell()
	 * @generated
	 */
	IGridBindingCellInformation getFocusCell();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.grid.IGridBinding#getFocusCell
	 * <em>Focus Cell</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Focus Cell</em>' reference.
	 * @see #getFocusCell()
	 * @generated
	 */
	void setFocusCell(IGridBindingCellInformation value);

	/**
	 * Sets the focus cell to the cell at the specified point if possible.
	 * 
	 * @param point the point for the new focus cell.
	 */
	void setFocusCell(Point point);

	/**
	 * Sets the focus cell to the cell at the specified column and row.
	 * <p>
	 * The operation is delayed via {@link Display#asyncExec(Runnable)} to allow all changes to the
	 * grid to be made first.
	 * <p>
	 * If the column or row is after the current set of columns or rows, the last column or row is
	 * selected.
	 * 
	 * @param column the wanted column
	 * @param row the wanted row
	 */
	void setFocusCellDelayed(int column, int row);

	/**
	 * Updates the focus cell of the grid.
	 * <p>
	 * The cell is updated to the same position as the current focus cell - ignoring any removed
	 * columns or row.
	 * <p>
	 * The operation is delayed.
	 */
	void updateFocusCellDelayed();

	/**
	 * Returns the value of the '<em><b>Columns</b></em>' map. The key is of type
	 * {@link java.lang.Object}, and the value is of type
	 * {@link com.rcpcompany.uibindings.grid.IGridBindingColumnInformation}, <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Columns</em>' map.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBinding_Columns()
	 * @generated
	 */
	EMap<Object, IGridBindingColumnInformation> getColumns();

	/**
	 * Returns the value of the '<em><b>No Row Headers</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Row Headers</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>No Row Headers</em>' attribute.
	 * @see com.rcpcompany.uibindings.grid.IGridPackage#getGridBinding_NoRowHeaders()
	 * @generated
	 */
	int getNoRowHeaders();

	/**
	 * The factory methods for {@link IGridBinding}.
	 */
	static final class Factory {
		private Factory() {
		}

		/**
		 * Creates a new grid.
		 * 
		 * @param context the binding context to use
		 * @return the created form creator
		 */
		public static IGridBinding createGrid(IBindingContext context) {
			return new GridBindingImpl(context);
		}

		/**
		 * Creates a new grid with the specified model and grid control.
		 * 
		 * @param context the binding context to use
		 * @param grid the grid control
		 * @param model the grid model
		 * @return the created form creator
		 */
		public static IGridBinding createGrid(IBindingContext context, Grid grid, IGridModel model) {
			return createGrid(context).grid(grid).model(model);
		}
	}

	/**
	 * Sets the grid control of the binding.
	 * 
	 * @param grid the grid control
	 * @return <code>this</code>
	 */
	IGridBinding grid(Grid grid);

	/**
	 * Sets the model of the binding.
	 * 
	 * @param model the grid
	 * @return <code>this</code>
	 */
	IGridBinding model(IGridModel model);

	/**
	 * Returns the cell at the specified coordinates.
	 * 
	 * @param column the column number
	 * @param row the row number
	 * @return the cell or <code>null</code> if no cell is found
	 */
	IGridBindingCellInformation getCell(int column, int row);

	/**
	 * Returns the cell at the specified column and row IDs.
	 * 
	 * @param columnID the column ID
	 * @param rowID the row ID
	 * @return the cell or <code>null</code> if no cell is found
	 */
	IGridBindingCellInformation getCell(Object columnID, Object rowID);
} // IGridBinding
