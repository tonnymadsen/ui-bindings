/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.grid.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellEditor.LayoutData;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.nebula.widgets.grid.GridEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.ICellEditorFactory;
import com.rcpcompany.uibindings.ICellEditorFactoryContext;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.grid.IGridBinding;
import com.rcpcompany.uibindings.grid.IGridBindingCellEditor;
import com.rcpcompany.uibindings.grid.IGridBindingCellInformation;
import com.rcpcompany.uibindings.grid.IGridPackage;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.cellEditors.SimpleCellEditorFactory;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Binding Cell Editor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellEditorImpl#getGrid <em>Grid
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellEditorImpl#getGridEditor <em>
 * Grid Editor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.grid.internal.GridBindingCellEditorImpl#getActiveEditCell
 * <em>Active Edit Cell </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GridBindingCellEditorImpl extends EObjectImpl implements IGridBindingCellEditor {
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
	 * The default value of the '{@link #getGridEditor() <em>Grid Editor</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGridEditor()
	 * @generated
	 * @ordered
	 */
	protected static final GridEditor GRID_EDITOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGridEditor() <em>Grid Editor</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGridEditor()
	 * @generated
	 * @ordered
	 */
	protected GridEditor gridEditor = GRID_EDITOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActiveEditCell() <em>Active Edit Cell</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getActiveEditCell()
	 * @generated
	 * @ordered
	 */
	protected IGridBindingCellInformation activeEditCell;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GridBindingCellEditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IGridPackage.Literals.GRID_BINDING_CELL_EDITOR;
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
	 * @generated NOT
	 */
	public NotificationChain basicSetGrid(IGridBinding newGrid, NotificationChain msgs) {
		if (gridEditor != null) {
			gridEditor.dispose();
			gridEditor = null;
		}
		if (newGrid != null) {
			gridEditor = new GridEditor(newGrid.getGrid());
		}

		return basicSetGridGen(newGrid, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGridGen(IGridBinding newGrid, NotificationChain msgs) {
		final IGridBinding oldGrid = grid;
		grid = newGrid;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING_CELL_EDITOR__GRID, oldGrid, newGrid);
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
	 * @generated NOT
	 */
	private static final int EOFFSET_CORRECTION_CELL_EDITOR_OPPOSITE = IGridPackage.Literals.GRID_BINDING
			.getFeatureID(IGridPackage.Literals.GRID_BINDING__NO_COLUMN_HEADERS)
			- IGridPackage.GRID_BINDING__NO_COLUMN_HEADERS;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setGrid(IGridBinding newGrid) {
		if (newGrid != grid) {
			NotificationChain msgs = null;
			if (grid != null) {
				msgs = ((InternalEObject) grid).eInverseRemove(this, IGridPackage.GRID_BINDING__CELL_EDITOR
						+ EOFFSET_CORRECTION_CELL_EDITOR_OPPOSITE, IGridBinding.class, msgs);
			}
			if (newGrid != null) {
				msgs = ((InternalEObject) newGrid).eInverseAdd(this, IGridPackage.GRID_BINDING__CELL_EDITOR
						+ EOFFSET_CORRECTION_CELL_EDITOR_OPPOSITE, IGridBinding.class, msgs);
			}
			msgs = basicSetGrid(newGrid, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IGridPackage.GRID_BINDING_CELL_EDITOR__GRID, newGrid,
					newGrid));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public GridEditor getGridEditor() {
		return gridEditor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IGridBindingCellInformation getActiveEditCell() {
		return activeEditCell;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setActiveEditCell(IGridBindingCellInformation newActiveEditCell) {
		final IGridBindingCellInformation oldActiveEditCell = activeEditCell;
		activeEditCell = newActiveEditCell;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IGridPackage.GRID_BINDING_CELL_EDITOR__ACTIVE_EDIT_CELL, oldActiveEditCell, activeEditCell));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IGridPackage.GRID_BINDING_CELL_EDITOR__GRID:
			if (grid != null) {
				msgs = ((InternalEObject) grid).eInverseRemove(this, IGridPackage.GRID_BINDING__CELL_EDITOR
						+ EOFFSET_CORRECTION_CELL_EDITOR_OPPOSITE, IGridBinding.class, msgs);
			}
			return basicSetGrid((IGridBinding) otherEnd, msgs);
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
		switch (featureID) {
		case IGridPackage.GRID_BINDING_CELL_EDITOR__GRID:
			return basicSetGrid(null, msgs);
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
		switch (featureID) {
		case IGridPackage.GRID_BINDING_CELL_EDITOR__GRID:
			return getGrid();
		case IGridPackage.GRID_BINDING_CELL_EDITOR__GRID_EDITOR:
			return getGridEditor();
		case IGridPackage.GRID_BINDING_CELL_EDITOR__ACTIVE_EDIT_CELL:
			return getActiveEditCell();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IGridPackage.GRID_BINDING_CELL_EDITOR__GRID:
			setGrid((IGridBinding) newValue);
			return;
		case IGridPackage.GRID_BINDING_CELL_EDITOR__ACTIVE_EDIT_CELL:
			setActiveEditCell((IGridBindingCellInformation) newValue);
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
		switch (featureID) {
		case IGridPackage.GRID_BINDING_CELL_EDITOR__GRID:
			setGrid((IGridBinding) null);
			return;
		case IGridPackage.GRID_BINDING_CELL_EDITOR__ACTIVE_EDIT_CELL:
			setActiveEditCell((IGridBindingCellInformation) null);
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
		switch (featureID) {
		case IGridPackage.GRID_BINDING_CELL_EDITOR__GRID:
			return grid != null;
		case IGridPackage.GRID_BINDING_CELL_EDITOR__GRID_EDITOR:
			return GRID_EDITOR_EDEFAULT == null ? gridEditor != null : !GRID_EDITOR_EDEFAULT.equals(gridEditor);
		case IGridPackage.GRID_BINDING_CELL_EDITOR__ACTIVE_EDIT_CELL:
			return activeEditCell != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (gridEditor: ");
		result.append(gridEditor);
		result.append(')');
		return result.toString();
	}

	/**
	 * The cell editor used in the current edit session.
	 */
	private CellEditor myCE;

	@Override
	public void editCell(final IGridBindingCellInformation cell, final ColumnViewerEditorActivationEvent event) {
		if (getActiveEditCell() == cell) return;
		if (getActiveEditCell() != null) {
			cancelEdit();
		}
		setActiveEditCell(cell);

		// LogUtils.debug(this, "cell=" + cell);

		final GridEditor editorControl = getGridEditor();
		// TODO: factory
		myCE = createCellEditor(cell);
		final Control control = myCE.getControl();

		// Layout the cell
		final LayoutData layoutData = myCE.getLayoutData();
		gridEditor.grabHorizontal = layoutData.grabHorizontal;
		gridEditor.horizontalAlignment = layoutData.horizontalAlignment;
		gridEditor.minimumWidth = layoutData.minimumWidth;

		gridEditor.verticalAlignment = layoutData.verticalAlignment;
		gridEditor.minimumHeight = layoutData.minimumHeight;

		// Set the grid editor
		editorControl.setEditor(control, cell.getRow().getGridItem(),
				getGrid().getGrid().indexOf(cell.getColumn().getGridColumn()));

		/*
		 * Set focus - after the binding
		 */
		myCE.setFocus();

		/*
		 * Activation
		 */
		myCE.activate(event);

		myMouseListener = new MouseAdapter() {
			final int activationTime = event.time + Display.getCurrent().getDoubleClickTime();

			@Override
			public void mouseDown(MouseEvent e) {
				if (control.isDisposed()) return;
				// time wrap?
				// check for expiration of doubleClickTime
				if (shouldFireDoubleClick(activationTime, e.time, event) && e.button == 1) {
					control.removeMouseListener(this);
					cancelEdit();
					// handleDoubleClickEvent();
				} else {
					control.removeMouseListener(this);
				}
			}

			private boolean shouldFireDoubleClick(int activationTime, int mouseTime,
					ColumnViewerEditorActivationEvent activationEvent) {
				return mouseTime <= activationTime
						&& activationEvent.eventType != ColumnViewerEditorActivationEvent.KEY_PRESSED
						&& activationEvent.eventType != ColumnViewerEditorActivationEvent.PROGRAMMATIC
						&& activationEvent.eventType != ColumnViewerEditorActivationEvent.TRAVERSAL;
			}
		};
		control.addTraverseListener(myTabEditingListener);
		control.addMouseListener(myMouseListener);
		control.addDisposeListener(myDisposeListener);
		myCE.addListener(myCellEditorListener);
	}

	protected CellEditor createCellEditor(final IGridBindingCellInformation cell) {
		if (Activator.getDefault().TRACE_LIFECYCLE_COLUMN_EDITORS) {
			LogUtils.debug(this, "cell=" + cell);
		}

		/*
		 * Find the cell editor to use form the binding. Defaults to a text widget
		 */
		final ICellEditorFactory factory = cell.getLabelBinding().getArgument(
				Constants.ARG_PREFERRED_CELL_EDITOR_FACTORY, ICellEditorFactory.class,
				SimpleCellEditorFactory.Factory.getFactory());

		/*
		 * Context used for the editor creation.
		 */
		final ICellEditorFactoryContext context = new ICellEditorFactoryContext() {
			@Override
			public IValueBindingCell getCell() {
				return cell;
			}

			@Override
			public Composite getParent() {
				return cell.getColumn().getGrid().getGrid();
			}
		};

		return factory.create(context);
	}

	/**
	 * Ends the current edit session.
	 */
	protected void endEditing() {
		// LogUtils.debug(this, "commit=" + commitChanges);
		final IGridBindingCellInformation cell = getActiveEditCell();
		if (cell == null) return;
		setActiveEditCell(null);
		if (myCE == null) return;
		final Control control = myCE.getControl();

		// Deactivate
		myCE.deactivate();

		if (getGrid().getGrid().isDisposed()) {
			getGridEditor().setEditor(null, null, 0);
		}

		control.removeTraverseListener(myTabEditingListener);
		control.removeMouseListener(myMouseListener);
		myMouseListener = null;
		control.removeDisposeListener(myDisposeListener);
		myCE.removeListener(myCellEditorListener);

		myCE.dispose();
		myCE = null;
	}

	@Override
	public void acceptEdit() {
		endEditing();
	}

	@Override
	public void cancelEdit() {
		endEditing();
	}

	/**
	 * Traverse listener for the edit control.
	 */
	protected final TraverseListener myTabEditingListener = new TraverseListener() {
		@Override
		public void keyTraversed(TraverseEvent e) {
			if (!e.doit) return;
			switch (e.detail) {
			case SWT.TRAVERSE_ESCAPE:
				break;
			default:
				acceptEdit();
				break;
			}

			// final IGridBinding g = getGrid();
			// final IGridBindingCellInformation currentCell = g.getFocusCell();
			// g.getGrid().traverse(e.detail);
			// final IGridBindingCellInformation newCell = g.getFocusCell();
			// if (newCell != currentCell) {
			// editCell(newCell, new ColumnViewerEditorActivationEvent(MyViewerCell.INSTANCE, e));
			// }
		}
	};

	/**
	 * Dispose listener for the edit control.
	 */
	protected final DisposeListener myDisposeListener = new DisposeListener() {
		@Override
		public void widgetDisposed(DisposeEvent e) {
			cancelEdit();
		}
	};

	/**
	 * Mouse listener used to weed out double clicks. Recreated for each editor.
	 */
	protected MouseListener myMouseListener;

	/**
	 * Cell Editor Listener
	 */
	protected ICellEditorListener myCellEditorListener = new ICellEditorListener() {
		@Override
		public void editorValueChanged(boolean oldValidState, boolean newValidState) {
			// NOP
		}

		@Override
		public void cancelEditor() {
			cancelEdit();
		}

		@Override
		public void applyEditorValue() {
			acceptEdit();
		}
	};
} // GridBindingCellEditorImpl
