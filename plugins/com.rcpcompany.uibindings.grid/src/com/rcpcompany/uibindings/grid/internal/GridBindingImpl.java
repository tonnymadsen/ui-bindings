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
package com.rcpcompany.uibindings.grid.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IChildCreationSpecification;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ISourceProviderStateContext;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.bindingMessages.ValidationLabelDecorator;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellEditor;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.IGridBindingColumnInformation;
import com.rcpcompany.uibindings.grid.IGridBindingRowInformation;
import com.rcpcompany.uibindings.grid.IGridFactory;
import com.rcpcompany.uibindings.grid.IGridModel;
import com.rcpcompany.uibindings.grid.IGridPackage;
import com.rcpcompany.uibindings.internal.ContainerBindingImpl;
import com.rcpcompany.uibindings.utils.IManagerRunnable;
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
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getColumnIDs <em>Column IDs
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getRowIDs <em>Row IDs</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getFocusCell <em>Focus Cell
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingImpl#getCellEditor <em>Cell Editor
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
@SuppressWarnings("restriction")
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
	 * The default value of the '{@link #getColumnIDs() <em>Column IDs</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getColumnIDs()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableList COLUMN_IDS_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getRowIDs() <em>Row IDs</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRowIDs()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableList ROW_IDS_EDEFAULT = null;

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
					final IGridBindingCellInformation c = (IGridBindingCellInformation) getCell(p.x, p.y, true);
					if (c != null) {
						setFocusCell(c);
					}
					break;
				}
			}
			final IGridBindingCellInformation cell;
			/*
			 * Find the target cell. For some event - like KEY_DOWN - the location is (0, 0), so
			 * there we use the current focus cell (if set).
			 */
			if (event.x == 0 && event.y == 0) {
				cell = getFocusCell();
			} else {
				cell = getCell(new Point(event.x, event.y));
			}
			// LogUtils.debug(this, "cell=" + cell);
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

		final IGridBindingCellInformation cell = (IGridBindingCellInformation) getCell(p.x + getNoRowHeaders(), p.y
				+ getNoColumnHeaders(), true);
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
			setFocusCellDelayed(getNoRowHeaders(), getNoColumnHeaders());
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
			setFocusCellDelayed(getNoRowHeaders(), getNoColumnHeaders());
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
		if (isDisposed()) return;
		setState(BindingState.DISPOSE_PENDING);
		getGrid().removeListener(SWT.MouseDown, myCellEventListener);
		getGrid().removeListener(SWT.MouseDoubleClick, myCellEventListener);
		getGrid().removeListener(SWT.KeyDown, myCellEventListener);
		getGrid().removeListener(SWT.Selection, myCellEventListener);
		if (eIsSet(IUIBindingsPackage.Literals.CONTAINER_BINDING__SINGLE_SELECTION)) {
			getSingleSelection().dispose();
		}
		if (getModel() != null) {
			try {
				if (Activator.getDefault().TRACE_SOURCE_MODEL) {
					LogUtils.debug(getModel(), "Model[" + getGrid().hashCode() + "]: dispose");
				}
				getModel().dispose();
				setModel(null);
			} catch (final Exception ex) {
				LogUtils.error(getModel(), ex);
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
	 * @generated NOT
	 */
	@Override
	public IObservableList getColumnIDs() {
		return myColumnIDs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IObservableList getRowIDs() {
		return myRowIDs;
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
		IManagerRunnable.Factory.asyncExec("setFocus", this, new Runnable() {
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
				setFocusCell((IGridBindingCellInformation) getCell(c, r, true));
			}
		});
	}

	@Override
	public void updateFocusCellDelayed() {
		final IGridBindingCellInformation cell = getFocusCell();
		if (cell == null) {
			setFocusCellDelayed(getNoRowHeaders(), getNoColumnHeaders());
			return;
		}
		final Point position = cell.getPosition(true);
		setFocusCellDelayed(position.x, position.y);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setFocusCell(IGridBindingCellInformation newFocusCell) {
		if (newFocusCell == null) {
			if (getColumnIDs().size() > 0 && getRowIDs().size() > 0) {
				newFocusCell = (IGridBindingCellInformation) getCell(getNoRowHeaders(), getNoColumnHeaders(), true);
			}
		}
		setFocusCellGen(newFocusCell);

		if (newFocusCell == null) return;
		if (newFocusCell.getColumn().getGridColumn() == null || newFocusCell.getRow().getGridItem() == null) return;

		getGrid().setFocusColumn(newFocusCell.getColumn().getGridColumn());
		getGrid().setFocusItem(newFocusCell.getRow().getGridItem());
		getSingleSelection().setValue(newFocusCell.getObjectValue());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IObservableValue getSingleSelection() {
		if (super.getSingleSelection() == null) {
			singleSelection = WritableValue.withValueType(null);
		}
		return super.getSingleSelection();
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
		case IGridPackage.GRID_BINDING__COLUMN_IDS:
			return getColumnIDs();
		case IGridPackage.GRID_BINDING__ROW_IDS:
			return getRowIDs();
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
		case IGridPackage.GRID_BINDING__COLUMN_IDS:
			return COLUMN_IDS_EDEFAULT == null ? getColumnIDs() != null : !COLUMN_IDS_EDEFAULT.equals(getColumnIDs());
		case IGridPackage.GRID_BINDING__ROW_IDS:
			return ROW_IDS_EDEFAULT == null ? getRowIDs() != null : !ROW_IDS_EDEFAULT.equals(getRowIDs());
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
			case IGridPackage.GRID_BINDING__COLUMN_IDS:
				return IGridPackage.GRID_BINDING__COLUMN_IDS + EOFFSET_CORRECTION;
			case IGridPackage.GRID_BINDING__ROW_IDS:
				return IGridPackage.GRID_BINDING__ROW_IDS + EOFFSET_CORRECTION;
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
			IManagerRunnable.Factory.asyncExec(null, this, new Runnable() {
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
	 * Runnable used to update the structure of a grid.
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
			final List<Object> newColumns = new ArrayList<Object>(myColumnIDs);
			final List<Object> newRows = new ArrayList<Object>(myRowIDs);

			Diffs.computeListDiff(myOldColumns, newColumns).accept(columnVisitor);
			Diffs.computeListDiff(myOldRows, newRows).accept(rowVisitor);

			myOldColumns = newColumns;
			myOldRows = newRows;
		}
	};

	/**
	 * Asynchronously updates the structure of the grid.
	 */
	protected void asyncUpdateGridStructure() {
		if (getGrid().isDisposed()) {
			LogUtils.debug(this, "Grid is disposed");
			return;
		}

		IManagerRunnable.Factory.asyncExec("structure", this, asyncUpdateGridStructureRunnable);
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
		assertTrue(false, "Cannot set validValues");
		return this;
	}

	@Override
	public IBinding validValues(EObject obj, EReference reference) {
		assertTrue(false, "Cannot set validValues");
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
		 * If a specific position is specified in the event (x,y) then use this to focus - will only
		 * succeed if the cell is inside the grid (not a header).
		 */
		final Event event = context.getEvent();
		if ((event.x != 0 || event.y != 0) && event.widget == getControl()) {
			setFocusCell(new Point(event.x, event.y));
		}
		currentCell = getFocusCell();
		if (currentCell != null) {
			final IBindingDataType dataType = currentCell.getDataType();
			final IObservableValue objectValue = currentCell.getObjectValue();
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
			if (objectValue != null) {
				context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_VALUE, objectValue.getValue());
			}
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, currentCell.getDisplayText());

			final IUIAttribute la = currentCell.getLabelUIAttribute();
			if (la != null) {
				context.addObservedValue(la.getCurrentValue());
			}
		}
	}

	@Override
	public void setFocusCell(Point point) {
		final IGridBindingCellInformation cell = getCell(point);
		if (cell != null) {
			setFocusCell(cell);
		}
	}

	@Override
	public IGridBindingCellInformation getCell(Point point) {
		final GridColumn gColumn = getGrid().getColumn(point);
		IGridBindingColumnInformation ci = null;
		if (gColumn != null) {
			for (final IGridBindingColumnInformation c : getColumns().values()) {
				if (c.getGridColumn() == gColumn) {
					ci = c;
					break;
				}
			}
		}
		if (ci == null) {
			for (final IGridBindingColumnInformation c : getColumns().values()) {
				if (c.getId() == IGridModel.HEADER1) {
					ci = c;
					break;
				}
			}
		}
		if (ci == null) return null;

		final GridItem gItem = getGrid().getItem(point);
		IGridBindingRowInformation ri = null;
		if (gItem != null) {
			for (final IGridBindingRowInformation r : getRows().values()) {
				if (r.getGridItem() == gItem) {
					ri = r;
					break;
				}
			}
		}
		if (ri == null) {
			for (final IGridBindingRowInformation r : getRows().values()) {
				if (r.getId() == IGridModel.HEADER1) {
					ri = r;
					break;
				}
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
	public IGridBindingCellInformation getCell(Object columnID, Object rowID) {
		IGridBindingColumnInformation ci = null;
		IGridBindingRowInformation ri = null;

		for (final IGridBindingColumnInformation c : getColumns().values()) {
			if (c.getId() == columnID) {
				ci = c;
				break;
			}
		}
		if (ci == null) return null;

		for (final IGridBindingRowInformation r : getRows().values()) {
			if (r.getId() == rowID) {
				ri = r;
				break;
			}
		}
		if (ri == null) return null;

		for (final IGridBindingCellInformation cell : ci.getRowCells()) {
			if (cell.getRow() == ri) return cell;
		}
		LogUtils.throwException(this, "Cell not found - inconsistency", getCreationPoint());
		return null;
	}

	private Object getColumnID(int column, boolean visualModel) {
		if (column == getNoRowHeaders() - 2) return IGridModel.HEADER2;
		if (column == getNoRowHeaders() - 3) return IGridModel.HEADER3;
		if (column == getNoRowHeaders() - 4) return IGridModel.HEADER4;
		if (column == getNoRowHeaders() - 5) return IGridModel.HEADER5;

		column -= getNoRowHeaders();

		if (visualModel) {
			final int[] columnOrder = getGrid().getColumnOrder();
			if (column < columnOrder.length) {
				column = columnOrder[column];
			}
		}

		return getColumnIDs().get(column);
	}

	private Object getRowID(int row, boolean visualModel) {
		if (row == getNoColumnHeaders() - 2) return IGridModel.HEADER2;
		if (row == getNoColumnHeaders() - 3) return IGridModel.HEADER3;
		if (row == getNoColumnHeaders() - 4) return IGridModel.HEADER4;
		if (row == getNoColumnHeaders() - 5) return IGridModel.HEADER5;

		row -= getNoRowHeaders();

		return getRowIDs().get(row);
	}

	@Override
	public IValueBindingCell getCell(int column, int row, boolean visualModel) {
		final Object columnID = getColumnID(column, visualModel);
		final Object rowID = getRowID(row, visualModel);

		final IGridBindingColumnInformation ci = getColumns().get(columnID);
		final IGridBindingRowInformation ri = getRows().get(rowID);

		if (ci == null) return null;
		if (ri == null) return null;

		for (final IGridBindingCellInformation cell : ci.getRowCells()) {
			if (cell.getRow() == ri) return cell;
		}
		LogUtils.throwException(this, "Cell not found - inconsistency", getCreationPoint());
		return null;
	}

	@Override
	public IGridBindingCellInformation getCell(int column, int row) {
		return (IGridBindingCellInformation) getCell(column, row, true);
	}

	@Override
	public ValidationLabelDecorator getValidationLabelDecorator() {
		return null;
	}

	@Override
	public Collection<EObject> getSelection() {
		final Point[] cellSelection = getGrid().getCellSelection();
		final Collection<EObject> selection = new ArrayList<EObject>(cellSelection.length);
		for (final Point p : cellSelection) {
			final IGridBindingCellInformation cell = getCell(p.x + getNoColumnHeaders(), p.y + getNoRowHeaders());
			if (cell == null) {
				continue;
			}
			final IObservableValue valueOV = cell.getObjectValue();
			if (valueOV == null) {
				continue;
			}
			final Object value = valueOV.getValue();
			if (!(value instanceof EObject)) {
				continue;
			}
			selection.add((EObject) valueOV.getValue());
		}
		return selection;
	}

	@Override
	public IContainerDropContext getDropContext(DropTargetEvent event) {
		final Control control = getControl();
		final Point point = control.toControl(new Point(event.x, event.y));
		final IGridBindingCellInformation cell = getCell(point);
		if (cell == null) return null;

		return new IContainerDropContext() {

			@Override
			public EObject getDropTargetObject() {
				final IObservableValue valueOV = cell.getObjectValue();
				if (valueOV == null) return null;
				final Object value = valueOV.getValue();
				if (value instanceof EObject) return (EObject) value;
				return null;
			}

			@Override
			public float getDropLocation() {
				if (cell.getColumn().getId() == IGridModel.HEADER1) {
					final GridItem gridItem = cell.getRow().getGridItem();
					if (gridItem != null) {
						final Rectangle bounds = gridItem.getBounds(0);
						return (float) (point.y - bounds.y) / (float) bounds.height;
					}
				}
				if (cell.getRow().getId() == IGridModel.HEADER1) {
					final GridColumn column = cell.getColumn().getGridColumn();
					if (column != null) {
						final int x = getColumnHeaderXPosition(column);
						final int width = column.getWidth();
						return (float) (point.x - x) / width;
					}
				}

				/*
				 * OK... then we assume we are in the center of the cell
				 */
				return 0.5f;
			}

			/**
			 * Returns the x position of the given column.
			 * 
			 * @param column given column
			 * @return x position
			 */
			private int getColumnHeaderXPosition(GridColumn column) {
				final Grid grid = getGrid();
				int x = 0;

				// x -= grid.getHScrollSelectionInPixels();

				x += grid.getRowHeaderWidth();
				final int[] columnOrder = grid.getColumnOrder();
				for (final int i : columnOrder) {
					final GridColumn c = grid.getColumn(i);
					if (c == column) return x;

					if (!c.isVisible()) {
						continue;
					}

					x += c.getWidth();
				}

				return x;
			}

			@Override
			public IValueBindingCell getDropCell() {
				return cell;
			}

			@Override
			public List<IChildCreationSpecification> getPossibleChildObjects(EObject parent, EObject sibling) {
				if (cell.getColumn().getId() == IGridModel.HEADER1)
					return UIBindingsUtils.getPossibleTopLevelChildObjects(getRowIDs(), parent);
				if (cell.getRow().getId() == IGridModel.HEADER1)
					return UIBindingsUtils.getPossibleTopLevelChildObjects(getColumnIDs(), parent);

				return null;
			}
		};
	}
}
