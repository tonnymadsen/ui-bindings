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
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;

import com.rcpcompany.uibindings.grid.GridUtils;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.IGridBindingColumnInformation;
import com.rcpcompany.uibindings.grid.IGridBindingRowInformation;
import com.rcpcompany.uibindings.grid.IGridFactory;
import com.rcpcompany.uibindings.grid.IGridPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Binding Row Information</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingRowInformationImpl#getGrid <em>Grid
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingRowInformationImpl#getId <em>Id
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingRowInformationImpl#getColumnCells
 * <em>Column Cells</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingRowInformationImpl#getGridItem <em>
 * Grid Item</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GridBindingRowInformationImpl extends EObjectImpl implements IGridBindingRowInformation {
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
	 * The cached value of the '{@link #getColumnCells() <em>Column Cells</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getColumnCells()
	 * @generated
	 * @ordered
	 */
	protected EList<IGridBindingCellInformation> columnCells;

	/**
	 * The default value of the '{@link #getGridItem() <em>Grid Item</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGridItem()
	 * @generated
	 * @ordered
	 */
	protected static final GridItem GRID_ITEM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGridItem() <em>Grid Item</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGridItem()
	 * @generated
	 * @ordered
	 */
	protected GridItem gridItem = GRID_ITEM_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int EOFFSET_CORRECTION = IGridPackage.Literals.GRID_BINDING_ROW_INFORMATION
			.getFeatureID(IGridPackage.Literals.GRID_BINDING_ROW_INFORMATION__GRID)
			- IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int EOFFSET_CORRECTION_COLUMN_CELLS_OPPOSITE = IGridPackage.Literals.GRID_BINDING_CELL_INFORMATION
			.getFeatureID(IGridPackage.Literals.GRID_BINDING_CELL_INFORMATION__ROW)
			- IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GridBindingRowInformationImpl() {
		super();
	}

	public GridBindingRowInformationImpl(Object rowID) {
		id = rowID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IGridPackage.Literals.GRID_BINDING_ROW_INFORMATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID
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
	public EList<IGridBindingCellInformation> getColumnCells() {
		if (columnCells == null) {
			columnCells = new EObjectWithInverseEList<IGridBindingCellInformation>(IGridBindingCellInformation.class,
					this, IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS + EOFFSET_CORRECTION,
					IGridPackage.GRID_BINDING_CELL_INFORMATION__ROW + EOFFSET_CORRECTION_COLUMN_CELLS_OPPOSITE);
		}
		return columnCells;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public GridItem getGridItem() {
		return gridItem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGridItem(GridItem newGridItem) {
		final GridItem oldGridItem = gridItem;
		gridItem = newGridItem;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID_ITEM
					+ EOFFSET_CORRECTION, oldGridItem, gridItem));
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
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getColumnCells()).basicAdd(otherEnd, msgs);
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
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS:
			return ((InternalEList<?>) getColumnCells()).basicRemove(otherEnd, msgs);
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
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID:
			return getGrid();
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__ID:
			return getId();
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS:
			return getColumnCells();
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID_ITEM:
			return getGridItem();
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
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID:
			setGrid((IGridBinding) newValue);
			return;
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS:
			getColumnCells().clear();
			getColumnCells().addAll((Collection<? extends IGridBindingCellInformation>) newValue);
			return;
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID_ITEM:
			setGridItem((GridItem) newValue);
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
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID:
			setGrid((IGridBinding) null);
			return;
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS:
			getColumnCells().clear();
			return;
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID_ITEM:
			setGridItem(GRID_ITEM_EDEFAULT);
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
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID:
			return grid != null;
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS:
			return columnCells != null && !columnCells.isEmpty();
		case IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID_ITEM:
			return GRID_ITEM_EDEFAULT == null ? gridItem != null : !GRID_ITEM_EDEFAULT.equals(gridItem);
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
		if (baseClass == IGridBindingRowInformation.class) {
			switch (baseFeatureID - EOFFSET_CORRECTION) {
			case IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID:
				return IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_ROW_INFORMATION__ID:
				return IGridPackage.GRID_BINDING_ROW_INFORMATION__ID + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS:
				return IGridPackage.GRID_BINDING_ROW_INFORMATION__COLUMN_CELLS + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID_ITEM:
				return IGridPackage.GRID_BINDING_ROW_INFORMATION__GRID_ITEM + EOFFSET_CORRECTION;
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
		result.append(", gridItem: ");
		result.append(gridItem);
		result.append(')');
		return result.toString();
	}

	@Override
	public void dispose() {
		getGrid().updateFocusCellDelayed();
		/*
		 * Remove all cells from row
		 */
		for (final IGridBindingCellInformation cell : getColumnCells().toArray(
				new IGridBindingCellInformation[getColumnCells().size()])) {
			cell.dispose();
		}
		getGridItem().dispose();
		getGrid().getRows().removeKey(getId());
	}

	/**
	 * Initializes the row object.
	 * 
	 * @param binding the grid binding
	 * @param rowID the row ID object
	 * @param index the index of the new row
	 */
	public void init(IGridBinding binding, Object rowID, int index) {
		this.grid = binding;
		id = rowID;
		binding.getRows().put(getId(), this);

		if (!GridUtils.isHeader(getId())) {
			gridItem = new GridItem(getGrid().getGrid(), SWT.NONE, index);
		}

		for (final IGridBindingColumnInformation column : binding.getColumns().values()) {
			IGridFactory.eINSTANCE.createGridBindingCellInformation(column, this);
		}
	}
} // GridBindingRowInformationImpl
