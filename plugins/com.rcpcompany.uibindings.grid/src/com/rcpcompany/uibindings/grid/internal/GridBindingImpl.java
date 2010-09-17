/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.grid.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ISourceProviderStateContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellEditor;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.IGridBindingColumnInformation;
import com.rcpcompany.uibindings.grid.IGridBindingRowInformation;
import com.rcpcompany.uibindings.grid.IGridFactory;
import com.rcpcompany.uibindings.grid.IGridModel;
import com.rcpcompany.uibindings.grid.IGridPackage;
import com.rcpcompany.uibindings.internal.ContainerBindingImpl;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Binding</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getNoColumnHeaders <em>No
 * Column Headers</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getColumns <em>Columns</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getNoRowHeaders <em>No Row
 * Headers</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getRows <em>Rows</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getGrid <em>Grid</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getModel <em>Model</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getFocusCell <em>Focus Cell
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getCellEditor <em>Cell Editor
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GridBindingImpl extends ContainerBindingImpl implements IGridBinding {
	/**
	 * The default value of the '{@link #getNoColumnHeaders() <em>No Column Headers</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNoColumnHeaders()
	 * @generated
	 * @ordered
	 */
	protected static final int NO_COLUMN_HEADERS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNoColumnHeaders() <em>No Column Headers</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNoColumnHeaders()
	 * @generated
	 * @ordered
	 */
	protected int noColumnHeaders = NO_COLUMN_HEADERS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' map. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
	protected EMap<Object, IGridBindingColumnInformation> columns;

	/**
	 * The default value of the '{@link #getNoRowHeaders() <em>No Row Headers</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNoRowHeaders()
	 * @generated
	 * @ordered
	 */
	protected static final int NO_ROW_HEADERS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNoRowHeaders() <em>No Row Headers</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNoRowHeaders()
	 * @generated
	 * @ordered
	 */
	protected int noRowHeaders = NO_ROW_HEADERS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRows() <em>Rows</em>}' map. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getRows()
	 * @generated
	 * @ordered
	 */
	protected EMap<Object, IGridBindingRowInformation> rows;

	/**
	 * The default value of the '{@link #getGrid() <em>Grid</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getGrid()
	 * @generated
	 * @ordered
	 */
	protected static final Grid GRID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGrid() <em>Grid</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGrid()
	 * @generated
	 * @ordered
	 */
	protected Grid grid = GRID_EDEFAULT;

	/**
	 * The default value of the '{@link #getModel() <em>Model</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected static final IGridModel MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected IGridModel model = MODEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFocusCell() <em>Focus Cell</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFocusCell()
	 * @generated
	 * @ordered
	 */
	protected IGridBindingCellInformation focusCell;

	/**
	 * The cached value of the '{@link #getCellEditor() <em>Cell Editor</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCellEditor()
	 * @generated
	 * @ordered
	 */
	protected IGridBindingCellEditor cellEditor;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final int EOFFSET_CORRECTION = IGridPackage.Literals.GRID_BINDING
			.getFeatureID(IGridPackage.Literals.GRID_BINDING__NO_COLUMN_HEADERS)
			- IGridPackage.GRID_BINDING__NO_COLUMN_HEADERS;

	/**
	 * List with all column IDs.
	 */
	protected IObservableList myColumnIDs;

	/**
	 * List with all row IDs.
	 */
	protected IObservableList myRowIDs;

	/**
	 * Listener that handles changes to the columns and rows
	 */
	private final IChangeListener myStructureChangeListener = new IChangeListener() {
		@Override
		public void handleChange(ChangeEvent event) {
			asyncUpdateGridStructure();
		}
	};

	/**
	 * Forwards events for grid cells.
	 */
	protected Listener myCellEventListener = new Listener() {

		@Override
		public void handleEvent(Event event) {
			// LogUtils.debug(this, "e=" + ToStringUtils.toString(event));
			switch (event.type) {
			case SWT.Selection:
				updateFocusCellFromGrid();
				break;
			case SWT.KeyDown:
				/*
				 * Special handling
				 */
				switch (event.keyCode) {
				case SWT.TAB:
					final Point p = getGrid().getFocusCell();
					p.x++;
					if (p.x == getColumns().size()) {
						p.x = 0;
						p.y++;
					}
					final IGridBindingCellInformation c = getCell(p.x, p.y);
					if (c != null) {
						setFocusCell(c);
					}
					break;
				}
			}
			final IGridBindingCellInformation cell = getFocusCell();
			if (cell != null) {
				cell.handleEvent(event);
			}
		}
	};

	private final MySelectionProvider mySelectionProvider = new MySelectionProvider();

	/**
	 * Dummy {@link ISelectionProvider} for use in
	 * {@link GridBindingImpl#updateSourceProviderState(ISourceProviderStateContext)}.
	 * <p>
	 * Can handle exactly one listener.
	 */
	private class MySelectionProvider implements ISelectionProvider {
		private ISelectionChangedListener myListener = null;

		@Override
		public void addSelectionChangedListener(ISelectionChangedListener listener) {
			if (myListener != null) {
				LogUtils.error(listener, "Multiple listeners added!");
			}
			myListener = listener;
		}

		@Override
		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			if (myListener != listener) {
				LogUtils.error(listener, "Wrong listener removed!");
				return;
			}
			myListener = null;
		}

		public void fireSelectionChange() {
			if (myListener != null) {
				try {
					myListener.selectionChanged(null);
				} catch (final Exception ex) {
					LogUtils.error(myListener, ex);
				}
			}
		}

		@Override
		public ISelection getSelection() {
			return null;
		}

		@Override
		public void setSelection(ISelection selection) {
		}
	}

	/**
	 * Updates the focus cell based on the current focus cell of the grid itself.
	 */
	protected void updateFocusCellFromGrid() {
		final Point p = getGrid().getFocusCell();
		if (p == null) return;
		if (p.x < 0 || p.y < 0) return;

		final IGridBindingCellInformation cell = getCell(p.x, p.y);
		if (cell == null) return;
		setFocusCell(cell);

		mySelectionProvider.fireSelectionChange();
	}

	/**
	 * Adds a new column at the specified index.
	 * 
	 * @param columnID the ID of the new column
	 * @param index the index of the new column
	 */
	protected void addColumn(Object columnID, int index) {
		if (Activator.getDefault().TRACE_SOURCE_MODEL) {
			LogUtils.debug(getModel(), "Model[" + getGrid().hashCode() + "]: addColumn(" + columnID + ", " + index
					+ ")");
		}
		IGridFactory.eINSTANCE.createGridBindingColumnInformation(this, columnID, index);
		getContext().reflow();
		if (getFocusCell() == null) {
			setFocusCellDelayed(0, 0);
		}
	};

	/**
	 * Removes an existing column.
	 * 
	 * @param columnID the column ID of the column to remove
	 */
	protected void removeColumn(Object columnID) {
		if (Activator.getDefault().TRACE_SOURCE_MODEL) {
			LogUtils.debug(getModel(), "Model[" + getGrid().hashCode() + "]: removeColumn(" + columnID + ")");
		}
		final IGridBindingColumnInformation column = getColumns().get(columnID);
		column.dispose();
		getContext().reflow();
	}

	/**
	 * Adds a new row at the specified index.
	 * 
	 * @param rowID the ID of the new row
	 * @param index the index of the new row
	 */
	protected void addRow(Object rowID, int index) {
		if (Activator.getDefault().TRACE_SOURCE_MODEL) {
			LogUtils.debug(getModel(), "Model[" + getGrid().hashCode() + "]: addRow(" + rowID + ", " + index + ")");
		}
		IGridFactory.eINSTANCE.createGridBindingRowInformation(this, rowID, index);
		getContext().reflow();
		if (getFocusCell() == null) {
			setFocusCellDelayed(0, 0);
		}
	};

	/**
	 * Removes an existing row.
	 * 
	 * @param rowID the row ID of the row to remove
	 */
	protected void removeRow(Object rowID) {
		if (Activator.getDefault().TRACE_SOURCE_MODEL) {
			LogUtils.debug(getModel(), "Model[" + getGrid().hashCode() + "]: removeRow(" + rowID + ")");
		}
		final IGridBindingRowInformation row = getRows().get(rowID);
		row.dispose();
		getContext().reflow();
	}

	@Override
	public boolean isChangeable() {
		if (getArgument(Constants.ARG_READONLY, Boolean.class, Boolean.FALSE) == Boolean.TRUE) return false;

		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	private GridBindingImpl() {
		super();
	}

	/**
	 * Constructs and return a new binding.
	 * 
	 * @param context the context
	 */
	public GridBindingImpl(IBindingContext context) {
		setContext(context);
	}

	@Override
	public void dispose() {
		setState(BindingState.DISPOSE_PENDING);
		getGrid().removeListener(SWT.MouseDown, myCellEventListener);
		getGrid().removeListener(SWT.MouseDoubleClick, myCellEventListener);
		getGrid().removeListener(SWT.KeyDown, myCellEventListener);
		getGrid().removeListener(SWT.Selection, myCellEventListener);
		if (getModel() != null) {
			try {
				if (Activator.getDefault().TRACE_SOURCE_MODEL) {
					LogUtils.debug(getModel(), "Model[" + getGrid().hashCode() + "]: dispose");
				}
				getModel().dispose();
			} catch (final Exception ex) {
				// Ignore
			}
		}
		super.dispose();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IGridPackage.Literals.GRID_BINDING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getNoColumnHeaders() {
		return noColumnHeaders;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IGridBindingCellEditor getCellEditor() {
		if (cellEditor == null) {
			setCellEditor(IGridFactory.eINSTANCE.createGridBindingCellEditor());
		}
		return cellEditor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IGridBindingCellEditor basicGetCellEditor() {
		return cellEditor;
	}

	@Override
	public void editCell(IGridBindingCellInformation cell, ColumnViewerEditorActivationEvent event) {
		if (!cell.isChangeable()) return;
		if (!IManager.Factory.getManager().isEditorActivationEvent(event, cell)) return;
		setFocusCell(cell);
		getCellEditor().editCell(cell, event);
	}

	@Override
	public boolean isEditing() {
		return cellEditor != null && cellEditor.getActiveEditCell() != null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetCellEditor(IGridBindingCellEditor newCellEditor, NotificationChain msgs) {
		final IGridBindingCellEditor oldCellEditor = cellEditor;
		cellEditor = newCellEditor;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING__CELL_EDITOR + EOFFSET_CORRECTION, oldCellEditor, newCellEditor);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCellEditor(IGridBindingCellEditor newCellEditor) {
		if (newCellEditor != cellEditor) {
			NotificationChain msgs = null;
			if (cellEditor != null) {
				msgs = ((InternalEObject) cellEditor).eInverseRemove(this, IGridPackage.GRID_BINDING_CELL_EDITOR__GRID,
						IGridBindingCellEditor.class, msgs);
			}
			if (newCellEditor != null) {
				msgs = ((InternalEObject) newCellEditor).eInverseAdd(this, IGridPackage.GRID_BINDING_CELL_EDITOR__GRID,
						IGridBindingCellEditor.class, msgs);
			}
			msgs = basicSetCellEditor(newCellEditor, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING__CELL_EDITOR
					+ EOFFSET_CORRECTION, newCellEditor, newCellEditor));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<Object, IGridBindingRowInformation> getRows() {
		if (rows == null) {
			rows = new EcoreEMap<Object, IGridBindingRowInformation>(IGridPackage.Literals.OBJECT_TO_ROW_MAP_ENTRY,
					ObjectToRowMapEntryImpl.class, this, IGridPackage.GRID_BINDING__ROWS + EOFFSET_CORRECTION);
		}
		return rows;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Grid getGrid() {
		return grid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGrid(Grid newGrid) {
		final Grid oldGrid = grid;
		grid = newGrid;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING__GRID + EOFFSET_CORRECTION,
					oldGrid, grid));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IGridModel getModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setModel(IGridModel newModel) {
		final IGridModel oldModel = model;
		model = newModel;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING__MODEL + EOFFSET_CORRECTION, oldModel, model));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IGridBindingCellInformation getFocusCell() {
		return focusCell;
	}

	@Override
	public void setFocusCellDelayed(final int column, final int row) {
		getGrid().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				int c = column;
				int r = row;

				if (c >= getColumns().size()) {
					c = getColumns().size() - 1;
				}
				if (r >= getRows().size()) {
					r = getRows().size() - 1;
				}

				if (c <= 0 || r <= 0) {
					setFocusCell((IGridBindingCellInformation) null);
					return;
				}
				setFocusCell(getCell(c, r));
			}
		});
	}

	@Override
	public void updateFocusCellDelayed() {
		final IGridBindingCellInformation cell = getFocusCell();
		if (cell == null) {
			setFocusCellDelayed(0, 0);
			return;
		}

		final int columnNo = getColumns().indexOf(cell.getColumn());
		final int rowNo = getRows().indexOf(cell.getRow());
		setFocusCellDelayed(columnNo, rowNo);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setFocusCell(IGridBindingCellInformation newFocusCell) {
		if (newFocusCell == null) {
			if (getColumns().size() > 0 && getRows().size() > 0) {
				newFocusCell = getCell(0, 0);
			}
		}
		setFocusCellGen(newFocusCell);
		if (newFocusCell != null) {
			getGrid().setFocusColumn(newFocusCell.getColumn().getGridColumn());
			getGrid().setFocusItem(newFocusCell.getRow().getGridItem());
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFocusCellGen(IGridBindingCellInformation newFocusCell) {
		final IGridBindingCellInformation oldFocusCell = focusCell;
		focusCell = newFocusCell;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING__FOCUS_CELL
					+ EOFFSET_CORRECTION, oldFocusCell, focusCell));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING__CELL_EDITOR:
			if (cellEditor != null) {
				msgs = ((InternalEObject) cellEditor).eInverseRemove(this, IGridPackage.GRID_BINDING_CELL_EDITOR__GRID,
						IGridBindingCellEditor.class, msgs);
			}
			return basicSetCellEditor((IGridBindingCellEditor) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<Object, IGridBindingColumnInformation> getColumns() {
		if (columns == null) {
			columns = new EcoreEMap<Object, IGridBindingColumnInformation>(
					IGridPackage.Literals.OBJECT_TO_COLUMN_MAP_ENTRY, ObjectToColumnMapEntryImpl.class, this,
					IGridPackage.GRID_BINDING__COLUMNS + EOFFSET_CORRECTION);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getNoRowHeaders() {
		return noRowHeaders;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID - EOFFSET_CORRECTION) {
		case IGridPackage.GRID_BINDING__COLUMNS:
			return ((InternalEList<?>) getColumns()).basicRemove(otherEnd, msgs);
		case IGridPackage.GRID_BINDING__ROWS:
			return ((InternalEList<?>) getRows()).basicRemove(otherEnd, msgs);
		case IGridPackage.GRID_BINDING__CELL_EDITOR:
			return basicSetCellEditor(null, msgs);
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
		case IGridPackage.GRID_BINDING__NO_COLUMN_HEADERS:
			return getNoColumnHeaders();
		case IGridPackage.GRID_BINDING__COLUMNS:
			if (coreType)
				return getColumns();
			else
				return getColumns().map();
		case IGridPackage.GRID_BINDING__NO_ROW_HEADERS:
			return getNoRowHeaders();
		case IGridPackage.GRID_BINDING__ROWS:
			if (coreType)
				return getRows();
			else
				return getRows().map();
		case IGridPackage.GRID_BINDING__GRID:
			return getGrid();
		case IGridPackage.GRID_BINDING__MODEL:
			return getModel();
		case IGridPackage.GRID_BINDING__FOCUS_CELL:
			return getFocusCell();
		case IGridPackage.GRID_BINDING__CELL_EDITOR:
			if (resolve) return getCellEditor();
			return basicGetCellEditor();
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
		case IGridPackage.GRID_BINDING__COLUMNS:
			((EStructuralFeature.Setting) getColumns()).set(newValue);
			return;
		case IGridPackage.GRID_BINDING__ROWS:
			((EStructuralFeature.Setting) getRows()).set(newValue);
			return;
		case IGridPackage.GRID_BINDING__GRID:
			setGrid((Grid) newValue);
			return;
		case IGridPackage.GRID_BINDING__MODEL:
			setModel((IGridModel) newValue);
			return;
		case IGridPackage.GRID_BINDING__FOCUS_CELL:
			setFocusCell((IGridBindingCellInformation) newValue);
			return;
		case IGridPackage.GRID_BINDING__CELL_EDITOR:
			setCellEditor((IGridBindingCellEditor) newValue);
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
		case IGridPackage.GRID_BINDING__COLUMNS:
			getColumns().clear();
			return;
		case IGridPackage.GRID_BINDING__ROWS:
			getRows().clear();
			return;
		case IGridPackage.GRID_BINDING__GRID:
			setGrid(GRID_EDEFAULT);
			return;
		case IGridPackage.GRID_BINDING__MODEL:
			setModel(MODEL_EDEFAULT);
			return;
		case IGridPackage.GRID_BINDING__FOCUS_CELL:
			setFocusCell((IGridBindingCellInformation) null);
			return;
		case IGridPackage.GRID_BINDING__CELL_EDITOR:
			setCellEditor((IGridBindingCellEditor) null);
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
		case IGridPackage.GRID_BINDING__NO_COLUMN_HEADERS:
			return noColumnHeaders != NO_COLUMN_HEADERS_EDEFAULT;
		case IGridPackage.GRID_BINDING__COLUMNS:
			return columns != null && !columns.isEmpty();
		case IGridPackage.GRID_BINDING__NO_ROW_HEADERS:
			return noRowHeaders != NO_ROW_HEADERS_EDEFAULT;
		case IGridPackage.GRID_BINDING__ROWS:
			return rows != null && !rows.isEmpty();
		case IGridPackage.GRID_BINDING__GRID:
			return GRID_EDEFAULT == null ? grid != null : !GRID_EDEFAULT.equals(grid);
		case IGridPackage.GRID_BINDING__MODEL:
			return MODEL_EDEFAULT == null ? model != null : !MODEL_EDEFAULT.equals(model);
		case IGridPackage.GRID_BINDING__FOCUS_CELL:
			return focusCell != null;
		case IGridPackage.GRID_BINDING__CELL_EDITOR:
			return cellEditor != null;
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
		if (baseClass == IGridBinding.class) {
			switch (baseFeatureID - EOFFSET_CORRECTION) {
			case IGridPackage.GRID_BINDING__NO_COLUMN_HEADERS:
				return IGridPackage.GRID_BINDING__NO_COLUMN_HEADERS + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING__COLUMNS:
				return IGridPackage.GRID_BINDING__COLUMNS + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING__NO_ROW_HEADERS:
				return IGridPackage.GRID_BINDING__NO_ROW_HEADERS + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING__ROWS:
				return IGridPackage.GRID_BINDING__ROWS + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING__GRID:
				return IGridPackage.GRID_BINDING__GRID + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING__MODEL:
				return IGridPackage.GRID_BINDING__MODEL + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING__FOCUS_CELL:
				return IGridPackage.GRID_BINDING__FOCUS_CELL + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING__CELL_EDITOR:
				return IGridPackage.GRID_BINDING__CELL_EDITOR + EOFFSET_CORRECTION;
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
		result.append(" (noColumnHeaders: ");
		result.append(noColumnHeaders);
		result.append(", noRowHeaders: ");
		result.append(noRowHeaders);
		result.append(", grid: ");
		result.append(grid);
		result.append(", model: ");
		result.append(model);
		result.append(')');
		return result.toString();
	}

	@Override
	public void finish1() {
		try {
			final Grid g = getGrid();
			assertTrue(g != null, "Grid control not set");
			assertTrue(getModel() != null, "Model not set");

			registerWidget(g);

			g.setHeaderVisible(true);
			// g.setCellHeaderSelectionBackground(JFaceResources.getColorRegistry().get(
			// "com.rcpcompany.uibindings.colorDefinitions.EvenRowBackground")); // TODO
			g.setCellSelectionEnabled(true);
			g.setRowHeaderVisible(true);
			g.setAutoHeight(true);
			g.setAutoWidth(true);
			g.setLinesVisible(true);

			g.addListener(SWT.MouseDown, myCellEventListener);
			g.addListener(SWT.MouseDoubleClick, myCellEventListener);
			g.addListener(SWT.KeyDown, myCellEventListener);
			g.addListener(SWT.Selection, myCellEventListener);

			if (Activator.getDefault().TRACE_SOURCE_MODEL) {
				LogUtils.debug(getModel(), "Model[" + getGrid().hashCode() + "]: getColumnIDs");
			}
			myColumnIDs = getModel().getColumnIDs();
			myColumnIDs.addChangeListener(myStructureChangeListener);
			if (Activator.getDefault().TRACE_SOURCE_MODEL) {
				LogUtils.debug(getModel(), "Model: >>> " + myColumnIDs);
			}

			if (Activator.getDefault().TRACE_SOURCE_MODEL) {
				LogUtils.debug(getModel(), "Model[" + getGrid().hashCode() + "]: getColumnIDs");
			}
			myRowIDs = getModel().getRowIDs();
			myRowIDs.addChangeListener(myStructureChangeListener);
			if (Activator.getDefault().TRACE_SOURCE_MODEL) {
				LogUtils.debug(getModel(), "Model: >>> " + myRowIDs);
			}

			/*
			 * Query the model for the number of column and row headers
			 * 
			 * TODO: query model
			 */
			noColumnHeaders = 1;
			noRowHeaders = 1;

			/*
			 * Create the column and row headers
			 */
			grid.getDisplay().asyncExec(new Runnable() {
				@Override
				public void run() {
					addColumn(IGridModel.HEADER1, 0);
					addRow(IGridModel.HEADER1, 0);
				}
			});
			asyncUpdateGridStructure();
		} catch (final Exception ex) {
			dispose();
			LogUtils.error(this, ex);
		}
	}

	/**
	 * Runnable used to update the structure of a grid
	 */
	protected final Runnable asyncUpdateGridStructureRunnable = new Runnable() {
		protected final ListDiffVisitor columnVisitor = new ListDiffVisitor() {
			@Override
			public void handleRemove(int index, Object element) {
				removeColumn(element);
			}

			@Override
			public void handleAdd(int index, Object element) {
				addColumn(element, index);
			}

			@Override
			public void handleMove(int oldIndex, int newIndex, Object element) {
				// TODO: use grid methods
				removeColumn(element);
				addColumn(element, newIndex);
			}

			@Override
			public void handleReplace(int index, Object oldElement, Object newElement) {
				removeColumn(oldElement);
				addColumn(newElement, index);
			}
		};
		protected final ListDiffVisitor rowVisitor = new ListDiffVisitor() {
			@Override
			public void handleRemove(int index, Object element) {
				removeRow(element);
			}

			@Override
			public void handleAdd(int index, Object element) {
				addRow(element, index);
			}

			@Override
			public void handleMove(int oldIndex, int newIndex, Object element) {
				// TODO: use grid methods
				removeRow(element);
				addRow(element, newIndex);
			}

			@Override
			public void handleReplace(int index, Object oldElement, Object newElement) {
				removeRow(oldElement);
				addRow(newElement, index);
			}
		};

		protected List<Object> myOldColumns = Collections.emptyList();
		protected List<Object> myOldRows = Collections.emptyList();

		@Override
		public void run() {
			/*
			 * Strategy:
			 * 
			 * 1) copy the current column and row IDs
			 * 
			 * 2) add/remove columns and rows
			 * 
			 * 3) set the "old" columns and rows to the copied ones
			 */
			asyncUpdateGridStructure = false;

			final List<Object> newColumns = new ArrayList<Object>(myColumnIDs);
			final List<Object> newRows = new ArrayList<Object>(myRowIDs);

			Diffs.computeListDiff(myOldColumns, newColumns).accept(columnVisitor);
			Diffs.computeListDiff(myOldRows, newRows).accept(rowVisitor);

			myOldColumns = newColumns;
			myOldRows = newRows;
		}
	};
	protected boolean asyncUpdateGridStructure = false;

	/**
	 * Asynchronously updates the structure of the grid
	 */
	protected void asyncUpdateGridStructure() {
		if (asyncUpdateGridStructure) return;
		asyncUpdateGridStructure = true;
		if (getGrid().isDisposed()) {
			LogUtils.debug(this, "Grid is disposed");
			return;
		}

		getGrid().getDisplay().asyncExec(asyncUpdateGridStructureRunnable);
	}

	@Override
	public Control getControl() {
		return getGrid();
	}

	@Override
	public Class<?> getUIType() {
		// Not used
		return null;
	}

	@Override
	public Widget getWidget() {
		return getGrid();
	}

	@Override
	public IBinding arg(String name, Object value) {
		assertTrue(name != null, "name must be non-null"); //$NON-NLS-1$
		getArguments().put(name, value);
		return this;
	}

	@Override
	public IBinding args(Map<String, Object> arguments) {
		setArguments(arguments);
		return this;
	}

	@Override
	public IBinding dynamic() {
		return this;
	}

	@Override
	public IBinding id(String id) {
		setId(id);
		return this;
	}

	@Override
	public IBinding label(String label) {
		return this;
	}

	@Override
	public IBinding readonly() {
		return arg(Constants.ARG_READONLY, true);
	}

	@Override
	public IBinding type(String type) {
		return arg(Constants.ARG_TYPE, type);
	}

	@Override
	public IBinding validValues(IObservableList list) {
		return this;
	}

	@Override
	public IGridBinding grid(Grid grid) {
		assertTrue(this.grid == null, "grid already set");
		assertTrue(grid != null, "grid must be non-null");
		this.grid = grid;
		return this;
	}

	@Override
	public IGridBinding model(IGridModel model) {
		assertTrue(getModel() == null, "model already set");
		assertTrue(model != null, "model must be non-null");
		setModel(model);
		return this;
	}

	@Override
	public void updateSourceProviderState(ISourceProviderStateContext context) {
		context.putSourceValue(Constants.SOURCES_ACTIVE_CONTAINER_BINDING, this);
		// state.put(Constants.ACTIVE_VIEWER_BINDING_NO_CAF, (viewer.getComparator() == null &&
		// viewer.getFilters().length == 0));

		// state.put(Constants.ACTIVE_VIEWER_ELEMENT_TYPE, getModelType());

		// TODO: find an ISelectionProvider
		context.setSelectionProvider(null);

		IGridBindingCellInformation currentCell;
		/*
		 * If a specific position is specified in the event (x,y) then use this to focus.
		 */
		final Event event = context.getEvent();
		if ((event.x != 0 || event.y != 0) && event.widget == getControl()) {
			setFocusCell(new Point(event.x, event.y));
		}
		currentCell = getFocusCell();
		if (currentCell != null) {
			final IBindingDataType dataType = currentCell.getDataType();
			final IObservableValue objectValue = currentCell.getObjectValue();
			final Object value = objectValue.getValue();
			final IValueBinding labelBinding = currentCell.getLabelBinding();

			if (labelBinding != null) {
				context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING, labelBinding);
				context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_TYPE, labelBinding.getType());
				context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, dataType.getDataType());
				context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_FEATURE, labelBinding.getModelFeature());
			}
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_RO, !currentCell.isChangeable());
			if (dataType != null) {
				context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_UNSETTABLE, dataType.isUnsettable());
				context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, dataType.getDataType());
			}
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_VALUE, value);
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, currentCell.getDisplayText());

			context.addObservedValue(currentCell.getLabelUIAttribute().getCurrentValue());
		}
	}

	@Override
	public void setFocusCell(Point point) {
		final Point cellCoordinates = getGrid().getCell(point);
		if (cellCoordinates != null) {
			setFocusCell(getCell(cellCoordinates.x, cellCoordinates.y));
		}
	}

	@Override
	public IGridBindingCellInformation getCell(Object columnID, Object rowID) {
		IGridBindingColumnInformation ci = null;
		IGridBindingRowInformation ri = null;

		for (final IGridBindingColumnInformation c : getColumns().values()) {
			if (c.getId() == columnID) {
				ci = c;
			}
		}
		if (ci == null) return null;

		for (final IGridBindingRowInformation r : getRows().values()) {
			if (r.getId() == rowID) {
				ri = r;
			}
		}
		if (ri == null) return null;

		for (final IGridBindingCellInformation cell : ci.getRowCells()) {
			if (cell.getRow() == ri) return cell;
		}
		LogUtils.throwException(this, "Cell not found - inconsistency", getCreationPoint());
		return null;
	}

	@Override
	public IValueBindingCell getCell(int column, int row, boolean visualModel) {
		return getCell(column, row);
	}

	@Override
	public IGridBindingCellInformation getCell(int column, int row) {
		final GridColumn gridColumn;
		final GridItem gridRow;
		if (column < 0 || getGrid().getColumnCount() <= column) return null;
		if (row < 0 || getGrid().getItemCount() <= row) return null;

		try {
			gridColumn = getGrid().getColumn(column);
			gridRow = getGrid().getItem(row);
		} catch (final IllegalArgumentException ex) {
			// Argument out of range
			LogUtils.error(this, "Cell not found - inconsistency", getCreationPoint());
			return null;
		}
		IGridBindingColumnInformation ci = null;
		IGridBindingRowInformation ri = null;

		for (final IGridBindingColumnInformation c : getColumns().values()) {
			if (c.getGridColumn() == gridColumn) {
				ci = c;
			}
		}
		if (ci == null) return null;
		for (final IGridBindingRowInformation r : getRows().values()) {
			if (r.getGridItem() == gridRow) {
				ri = r;
			}
		}
		if (ri == null) return null;

		for (final IGridBindingCellInformation cell : ci.getRowCells()) {
			if (cell.getRow() == ri) return cell;
		}
		LogUtils.throwException(this, "Cell not found - inconsistency", getCreationPoint());
		return null;
	}

	/**
	 * Returns the grid cell for the specified grid item and column index.
	 * 
	 * @param column the column index
	 * @param item the grid item
	 * 
	 * @return the cell or <code>null</code>
	 */
	protected IGridBindingCellInformation getCell(int column, GridItem item) {
		// TODO there must be a more effective way for this
		return getCell(column, getGrid().indexOf(item));
	}

}
