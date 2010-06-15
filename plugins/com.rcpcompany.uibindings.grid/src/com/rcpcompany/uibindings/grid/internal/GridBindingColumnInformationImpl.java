/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.grid.internal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;

import com.rcpcompany.uibindings.grid.GridUtils;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.IGridBindingColumnInformation;
import com.rcpcompany.uibindings.grid.IGridBindingRowInformation;
import com.rcpcompany.uibindings.grid.IGridFactory;
import com.rcpcompany.uibindings.grid.IGridPackage;
import com.rcpcompany.uibindings.grid.internal.renderers.UIPainterCellRenderer;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Binding Column Information</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingColumnInformationImpl#getGrid <em>
 * Grid</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingColumnInformationImpl#getId <em>Id
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingColumnInformationImpl#getRowCells
 * <em>Row Cells</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.grid.internal.GridBindingColumnInformationImpl#getGridColumn
 * <em>Grid Column </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GridBindingColumnInformationImpl extends EObjectImpl implements IGridBindingColumnInformation {
	/**
	 * The cached value of the '{@link #getGrid() <em>Grid</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGrid()
	 * @generated
	 * @ordered
	 */
	protected IGridBinding grid;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Object ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Object id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRowCells() <em>Row Cells</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRowCells()
	 * @generated
	 * @ordered
	 */
	protected EList<IGridBindingCellInformation> rowCells;

	/**
	 * The default value of the '{@link #getGridColumn() <em>Grid Column</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGridColumn()
	 * @generated
	 * @ordered
	 */
	protected static final GridColumn GRID_COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGridColumn() <em>Grid Column</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGridColumn()
	 * @generated
	 * @ordered
	 */
	protected GridColumn gridColumn = GRID_COLUMN_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int EOFFSET_CORRECTION = IGridPackage.Literals.GRID_BINDING_COLUMN_INFORMATION
			.getFeatureID(IGridPackage.Literals.GRID_BINDING_COLUMN_INFORMATION__GRID)
			- IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int EOFFSET_CORRECTION_ROW_CELLS_OPPOSITE = IGridPackage.Literals.GRID_BINDING_CELL_INFORMATION
			.getFeatureID(IGridPackage.Literals.GRID_BINDING_CELL_INFORMATION__COLUMN)
			- IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GridBindingColumnInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IGridPackage.Literals.GRID_BINDING_COLUMN_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IGridBinding getGrid() {
		return grid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGrid(IGridBinding newGrid) {
		final IGridBinding oldGrid = grid;
		grid = newGrid;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID
					+ EOFFSET_CORRECTION, oldGrid, grid));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IGridBindingCellInformation> getRowCells() {
		if (rowCells == null) {
			rowCells = new EObjectWithInverseEList<IGridBindingCellInformation>(IGridBindingCellInformation.class,
					this, IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS + EOFFSET_CORRECTION,
					IGridPackage.GRID_BINDING_CELL_INFORMATION__COLUMN + EOFFSET_CORRECTION_ROW_CELLS_OPPOSITE);
		}
		return rowCells;
	}

	@Override
	public IGridBindingCellInformation getCell(GridItem item) {
		for (final IGridBindingCellInformation c : getRowCells()) {
			if (c.getRow().getGridItem() == item) return c;
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public GridColumn getGridColumn() {
		return gridColumn;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGridColumn(GridColumn newGridColumn) {
		final GridColumn oldGridColumn = gridColumn;
		gridColumn = newGridColumn;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID_COLUMN + EOFFSET_CORRECTION, oldGridColumn,
					gridColumn));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRowCells()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS:
			return ((InternalEList<?>) getRowCells()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID:
			return getGrid();
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ID:
			return getId();
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS:
			return getRowCells();
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID_COLUMN:
			return getGridColumn();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID:
			setGrid((IGridBinding) newValue);
			return;
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS:
			getRowCells().clear();
			getRowCells().addAll((Collection<? extends IGridBindingCellInformation>) newValue);
			return;
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID_COLUMN:
			setGridColumn((GridColumn) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID:
			setGrid((IGridBinding) null);
			return;
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS:
			getRowCells().clear();
			return;
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID_COLUMN:
			setGridColumn(GRID_COLUMN_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID:
			return grid != null;
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS:
			return rowCells != null && !rowCells.isEmpty();
		case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID_COLUMN:
			return GRID_COLUMN_EDEFAULT == null ? gridColumn != null : !GRID_COLUMN_EDEFAULT.equals(gridColumn);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IGridBindingColumnInformation.class) {
			switch (baseFeatureID - EOFFSET_CORRECTION) {
			case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID:
				return IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ID:
				return IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ID + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS:
				return IGridPackage.GRID_BINDING_COLUMN_INFORMATION__ROW_CELLS + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID_COLUMN:
				return IGridPackage.GRID_BINDING_COLUMN_INFORMATION__GRID_COLUMN + EOFFSET_CORRECTION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", gridColumn: ");
		result.append(gridColumn);
		result.append(')');
		return result.toString();
	}

	@Override
	public void dispose() {
		getGrid().updateFocusCellDelayed();
		/*
		 * Remove all cells from column
		 */
		for (final IGridBindingCellInformation cell : getRowCells().toArray(
				new IGridBindingCellInformation[getRowCells().size()])) {
			cell.dispose();
		}
		if (getGridColumn() != null) {
			getGridColumn().dispose();
		}
		getGrid().getColumns().removeKey(getId());
		// TODO Auto-generated method stub

	}

	/**
	 * Initializes the column object
	 * 
	 * @param grid the grind binding
	 * @param columnID the column ID object
	 * @param index the index of the new column
	 */
	public void init(IGridBinding grid, Object columnID, int index) {
		this.grid = grid;
		id = columnID;
		grid.getColumns().put(getId(), this);

		if (!GridUtils.isHeader(getId())) {
			gridColumn = new GridColumn(getGrid().getGrid(), SWT.CENTER, index);
			gridColumn.setCheckable(true);
			gridColumn.setMoveable(true);
			gridColumn.setResizeable(true);
			// TODO gridColumn.setVisible(false);
			// TODO gridColumn.setWidth(index);
			gridColumn.setCellRenderer(new UIPainterCellRenderer(this));
		}

		for (final IGridBindingRowInformation row : grid.getRows().values()) {
			IGridFactory.eINSTANCE.createGridBindingCellInformation(this, row);
		}
	}

} // GridBindingColumnInformationImpl
