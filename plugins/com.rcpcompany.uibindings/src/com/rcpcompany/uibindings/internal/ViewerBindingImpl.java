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
package com.rcpcompany.uibindings.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jface.databinding.viewers.IViewerValueProperty;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.CellNavigationStrategy;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.MyTableViewerEditor;
import org.eclipse.jface.viewers.MyTableViewerFocusCellManager;
import org.eclipse.jface.viewers.MyTreeViewerFocusCellManager;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.ContainerCellType;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IChildCreationSpecification;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IElementParentage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ISourceProviderStateContext;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.bindingMessages.ValidationLabelDecorator;
import com.rcpcompany.uibindings.internal.observables.properties.MySelectionProviderSingleSelectionProperty;
import com.rcpcompany.uibindings.internal.utils.DoubleClickAdapter;
import com.rcpcompany.uibindings.internal.utils.UIHandlerUtils;
import com.rcpcompany.uibindings.utils.IManagerRunnable;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Viewer Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ViewerBindingImpl#getColumns <em>Columns</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ViewerBindingImpl#getList <em>List</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ViewerBindingImpl#getElements <em>Elements</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ViewerBindingImpl#getMultipleSelection <em>Multiple
 * Selection</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ViewerBindingImpl#getViewer <em>Viewer</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ViewerBindingImpl#getFirstTableColumnOffset <em>
 * First Table Column Offset</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ViewerBindingImpl extends ContainerBindingImpl implements IViewerBinding {
	@Override
	public IViewerBinding viewer(ColumnViewer viewer) {
		assertTrue(viewer != null, "viewer must be non-null");
		setViewer(viewer);

		if (getControl() instanceof Table) {
			/*
			 * Add an empty first column to the table to avoid alignment problems
			 */
			final Table table = (Table) getControl();
			final TableColumn column = new TableColumn(table, SWT.NONE, 0);
			setFirstTableColumnOffset(1);
			column.setText("__SPARE__"); //$NON-NLS-1$
			column.setWidth(0);
			column.setMoveable(false);
			column.setResizable(false);
		}

		return this;
	}

	@Override
	public IViewerBinding viewer(Table t) {
		assertTrue(t != null, "viewer must be non-null");
		return viewer(new TableViewer(t));
	}

	@Override
	public IViewerBinding viewer(Tree t) {
		assertTrue(t != null, "viewer must be non-null");
		return viewer(new TreeViewer(t));
	}

	private IViewerBinding model(IObservableList list, IBindingDataType dataType, boolean disposeList) {
		assertTrue(list != null, "The list must be non-null");
		assertTrue(dataType != null, "The data type must be non-null");
		setList(list);
		setStaticDataType(dataType);
		for (final Object o : list) {
			assertTrue(o instanceof EObject, "Only EObjects are allowed in root elements of tree: " + o);
		}
		assertTrue(getModelEType() instanceof EClass, "The data type must be an EClass (and not an EDataType): "
				+ getModelEType());
		myListDispose = disposeList;
		return this;
	}

	@Override
	public IViewerBinding model(IObservableList list) {
		assertTrue(list != null, "List must be non-null");
		return model(list, IBindingDataType.Factory.create(list), false);
	}

	@Override
	public IViewerBinding model(EObject object, EReference reference) {
		assertTrue(object != null, "Object must be non-null");
		assertTrue(reference != null, "Reference must be non-null");
		assertTrue(reference.isMany(), "Reference for viewer must be to-many: " + reference.getName());
		return model(UIBindingsEMFObservables.observeList(null, getEditingDomain(), object, reference),
				IBindingDataType.Factory.create(object.eClass(), reference), true);
	}

	@Override
	public IViewerBinding model(IObservableValue value, EReference reference) {
		assertTrue(value != null, "Value must be non-null");
		assertTrue(reference != null, "Reference must be non-null");
		assertTrue(reference.isMany(), "Reference for viewer must be to-many: " + reference.getName());
		return model(UIBindingsEMFObservables.observeDetailList(value, reference),
				IBindingDataType.Factory.create(value, reference), true);
	}

	@Override
	public IColumnBinding addColumn() {
		final IColumnBinding column = IUIBindingsFactory.eINSTANCE.createColumnBinding();
		column.setContext(getContext());
		column.setViewerBinding(this);
		return column;
	}

	@Override
	public IColumnBinding addColumn(ViewerColumn column, EStructuralFeature feature) {
		return addColumn().column(column).model(feature);
	}

	@Override
	public IColumnBinding addColumn(TableColumn column, EStructuralFeature feature) {
		return addColumn().column(column).model(feature);
	}

	@Override
	public IColumnBinding addColumn(TreeColumn column, EStructuralFeature feature) {
		return addColumn().column(column).model(feature);
	}

	@Override
	public IViewerBinding arg(String name, Object value) {
		assertTrue(name != null, "name must be non-null"); //$NON-NLS-1$
		getArguments().put(name.intern(), value);
		return this;
	}

	@Override
	public IViewerBinding args(Map<String, Object> arguments) {
		setArguments(arguments);
		return this;
	}

	@Override
	public IViewerBinding readonly() {
		return arg(Constants.ARG_READONLY, true);
	}

	@Override
	public IViewerBinding id(String id) {
		setId(id);
		return this;
	}

	@Override
	public IViewerBinding type(String type) {
		return arg(Constants.ARG_TYPE, type);
	}

	@Override
	public boolean isChangeable() {
		if (getArgument(Constants.ARG_READONLY, Boolean.class, Boolean.FALSE) == Boolean.TRUE) return false;

		return true;
	}

	/**
	 * Adapter for the manager that insures the table is re-drawn when certain changes are made.
	 */
	private final Adapter myManagerAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;
			if (msg.getFeature() == IUIBindingsPackage.Literals.MANAGER__ALTERNATE_ROW_COLORS) {
				IManagerRunnable.Factory.asyncExec("refresh", getViewer(), new Runnable() {
					@Override
					public void run() {
						// TODO SWTB
						getViewer().refresh();
					}
				});
			}
		}
	};

	/**
	 * Private {@link CellNavigationStrategy}, which will not permit us to go to the first column!
	 */
	private final CellNavigationStrategy theCellNavigationStrategy = new CellNavigationStrategy() {
		@Override
		public ViewerCell findSelectedCell(ColumnViewer viewer, ViewerCell currentSelectedCell, Event event) {
			switch (event.keyCode) {
			case SWT.ARROW_LEFT:
				// TODO: get IViewerBinding from control and turn this into a static
				if (currentSelectedCell != null && currentSelectedCell.getColumnIndex() <= getFirstTableColumnOffset())
					return currentSelectedCell;
				break;
			default:
				break;
			}

			return super.findSelectedCell(viewer, currentSelectedCell, event);
		}

	};

	/**
	 * A {@link ILabelDecorator} (possibly <code>null</code>) for use in the viewer. The decorator
	 * decorates with the current validation state.
	 */
	private ValidationLabelDecorator myValidationLabelDecorator;

	@Override
	public ValidationLabelDecorator getValidationLabelDecorator() {
		return myValidationLabelDecorator;
	}

	@Override
	public Class<?> getUIType() {
		// Not used
		return null;
	}

	@Override
	public void finish1() {
		final ColumnViewer viewer = getViewer(); // TODO SWTB
		assertTrue(viewer != null, "No viewer set"); //$NON-NLS-1$
		assertTrue(getList() != null, "No model list"); //$NON-NLS-1$
		assertTrue(!getColumns().isEmpty(), "No columns in viewer"); //$NON-NLS-1$

		final Control control = getControl();
		assertTrue((control.getStyle() & SWT.FULL_SELECTION) != 0, "Viewer must have SWT.FULL_SELECTION set"); //$NON-NLS-1$
		// SWTEventUtils.swtListen(control);

		if (viewer instanceof TableViewer) {
			final ObservableListContentProvider contentProvider = new ObservableListContentProvider();
			viewer.setContentProvider(contentProvider);
			setElements(contentProvider.getKnownElements());
		} else if (viewer instanceof TreeViewer) {
			myTreeFactory = new ViewerBindingTreeFactory(getList(), getArgument(ARG_TREE_ID, String.class, null));
			final ObservableListTreeContentProvider contentProvider = new ObservableListTreeContentProvider(
					myTreeFactory, myTreeFactory);
			viewer.setContentProvider(contentProvider);
			myValidationLabelDecorator = new ValidationLabelDecorator();
			myValidationLabelDecorator.setPropagationAdapter(new ValidationLabelDecorator.IPropagationAdapter() {
				@Override
				public Object getParent(Object object) {
					if (isDisposed()) return null;
					return contentProvider.getParent(object);
				}
			});
			setElements(contentProvider.getKnownElements());
		} else {
			assertTrue(false, "Viewer not a Table or a Tree?"); //$NON-NLS-1$
		}

		IManager.Factory.getManager().eAdapters().add(myManagerAdapter);
		control.addListener(SWT.PaintItem, myPaintItemListener);
		if ((control.getStyle() & SWT.SINGLE) == SWT.SINGLE) {
			mySelectionChangedListener = new ISelectionChangedListener() {
				@Override
				public void selectionChanged(SelectionChangedEvent event) {
					myLastReportedSelectedElement = ((IStructuredSelection) event.getSelection()).getFirstElement();
				}
			};
			viewer.addSelectionChangedListener(mySelectionChangedListener);
		}
		registerWidget(control);

		/*
		 * More or less adapted (read "stolen") from Snippet026TreeViewerTabEditing...
		 * 
		 * Actually it is more and more less and less...
		 */
		final ColumnViewerEditorActivationStrategy actSupport = new CellEditorActivationStrategy(this);

		final FocusCellOwnerDrawHighlighter focusDrawingDelegate = new FocusCellOwnerDrawHighlighter(viewer);
		final int feature = ColumnViewerEditor.TABBING_HORIZONTAL | ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
				| ColumnViewerEditor.TABBING_VERTICAL | ColumnViewerEditor.KEYBOARD_ACTIVATION;
		if (viewer instanceof TableViewer) {
			myMyTableViewerFocusCellManager = new MyTableViewerFocusCellManager((TableViewer) viewer,
					focusDrawingDelegate, theCellNavigationStrategy);
			MyTableViewerEditor.create((TableViewer) viewer, myMyTableViewerFocusCellManager, actSupport, feature);
		} else if (viewer instanceof TreeViewer) {
			myMyTreeViewerFocusCellManager = new MyTreeViewerFocusCellManager((TreeViewer) viewer,
					focusDrawingDelegate, theCellNavigationStrategy);
			TreeViewerEditor.create((TreeViewer) viewer, myMyTreeViewerFocusCellManager, actSupport, feature);
		} else {
			// Not supported
		}

		ColumnViewerToolTipSupport.enableFor(viewer);
		DoubleClickAdapter.adapt(this);
	}

	/**
	 * Listener that will request a re-flow of the context if/when the elements of the viewer
	 * changes.
	 * 
	 * TODO TEST
	 */
	private final ISetChangeListener myElementsListener = new ISetChangeListener() {
		@Override
		public void handleSetChange(SetChangeEvent event) {
			/*
			 * SIMA-182: Bug in UIBinding for table cell editor?
			 * (http://jira.marintek.sintef.no/jira/browse/SIMA-182)
			 * 
			 * If a row is updated with a new row element, then item.data is properly updated, but
			 * ViewerCell.element is not! This is a fix for that. Note it is only possible if the
			 */
			final ViewerCell focusCell = getViewer().getColumnViewerEditor().getFocusCell();
			if (focusCell != null) {
				updateFocusCell();
				if (focusCell.getElement() != focusCell.getViewerRow().getElement()) {
					LogUtils.debug(this, "FATAL ISSUE\ncell.element=" + focusCell.getElement() + "\nitem.date=" //$NON-NLS-1$ //$NON-NLS-2$
							+ focusCell.getViewerRow().getElement());
				}
			}

			if (getViewer().getSelection().isEmpty() && !getList().isDisposed() && getList().size() > 0) {
				final EObject element = (EObject) getList().get(0);
				getViewer().setSelection(new StructuredSelection(element), true);
				setFocus(0 + getFirstTableColumnOffset(), element);
				// TODO SWTB: setFocusCell(0,0);
			}

			/*
			 * Reflow the context if the number of entries has changed
			 */
			getContext().reflow();
			// if (event != null && event.diff != null) {
			// final Set<?> additions = event.diff.getAdditions();
			// final Set<?> removals = event.diff.getRemovals();
			// if (additions == null || removals == null || additions.size() != removals.size()) {
			// getContext().reflow();
			// }
			// }
		}
	};

	@Override
	public void finish3() {
		if (getViewer() instanceof TreeViewer) {
			getViewer().setInput(ViewerBindingTreeFactory.ROOT_ELEMENT); // TODO SWTB
		} else {
			getViewer().setInput(getList()); // TODO SWTB
		}

		getElements().addSetChangeListener(myElementsListener);
		myElementsListener.handleSetChange(null);
	}

	/**
	 * The last element reported as selected - only used for viewers with style {@link SWT#SINGLE}.
	 */
	private Object myLastReportedSelectedElement = null;

	/**
	 * Listener to update {@link #myLastReportedSelectedElement}.
	 */
	private ISelectionChangedListener mySelectionChangedListener = null;

	/**
	 * The {@link SWT#PaintItem} listener is used to synchronize the current focus cell based on the
	 * cell that is painted using the detail {@link SWT#SELECTED}.
	 * <p>
	 * See <a href="http://jira.marintek.sintef.no/jira/browse/SIMA-582">SIMA-582</a>: Selection is
	 * not displayed properly in tables
	 */
	private final Listener myPaintItemListener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			if ((event.detail & SWT.SELECTED) != SWT.SELECTED) return;
			final Object element = event.item.getData();
			/*
			 * If the viewer is based on a single selection, then check if the selection is in fact
			 * the current element
			 * 
			 * This happens when the selection is set directly on the control rather than via the
			 * viewer.
			 */
			if (mySelectionChangedListener != null && myLastReportedSelectedElement != element) {
				getViewer().setSelection(new StructuredSelection(element), false); // TODO SWTB
			}
		}
	};

	@Override
	public IElementParentage getElementParentage(final EObject element) {
		if (getControl() instanceof Table) {
			if (!getList().contains(element)) return null;
			return new IElementParentage() {
				@Override
				public EReference getReference() {
					final IObservableList l = getList();
					if (l.getElementType() instanceof EReference) return (EReference) l.getElementType();
					return null;
				}

				@Override
				public EObject getParent() {
					final IObservableList l = getList();
					if (l instanceof IObserving) return (EObject) ((IObserving) l).getObserved();
					return null;
				}

				@Override
				public EObject getElement() {
					return element;
				}
			};
		}
		if (getControl() instanceof Tree) return myTreeFactory.getElementParentage(element);
		return null;
	};

	@Override
	public List<IChildCreationSpecification> getPossibleChildObjects(EObject parent, EObject sibling) {
		final Control control = getControl();
		if (control instanceof Table) return UIBindingsUtils.getPossibleTopLevelChildObjects(getList(), sibling);
		if (control instanceof Tree) {
			if (parent == null && sibling != null) {
				final IElementParentage parentage = getElementParentage(sibling);
				if (parentage != null) {
					parent = parentage.getParent();
				}
			}
			if (parent == null) return UIBindingsUtils.getPossibleTopLevelChildObjects(getList(), sibling);
			return myTreeFactory.getPossibleChildObjects(parent, sibling);
		}
		return null;
	}

	@Override
	public void setFocus(int column, EObject element) {
		if (getControl().isDisposed()) return;
		if (myMyTableViewerFocusCellManager != null) {
			myMyTableViewerFocusCellManager.setFocusCell(element, column);
			return;
		}
		if (myMyTreeViewerFocusCellManager != null) {
			myMyTreeViewerFocusCellManager.setFocusCell(element, column);
			return;
		}
	}

	/**
	 * Updates the current focus cell of the viewer.
	 */
	public void updateFocusCell() {
		if (getControl().isDisposed()) return;
		if (myMyTableViewerFocusCellManager != null) {
			myMyTableViewerFocusCellManager.updateFocusCell();
			return;
		}
		if (myMyTreeViewerFocusCellManager != null) {
			myMyTreeViewerFocusCellManager.updateFocusCell();
			return;
		}
	}

	@Override
	public void dispose() {
		if (isDisposed()) return;
		setState(BindingState.DISPOSE_PENDING);
		disposeServices();
		final Control control = getControl();
		if (!control.isDisposed()) {
			unregisterWidget(control);
			control.removeListener(SWT.PaintItem, myPaintItemListener);
		}
		IManager.Factory.getManager().eAdapters().remove(myManagerAdapter);
		if (mySelectionChangedListener != null) {
			getViewer().removeSelectionChangedListener(mySelectionChangedListener); // TODO SWTB -
																					// change to
																					// widget
																					// listener
			mySelectionChangedListener = null;
		}

		/*
		 * Let the viewer clean up before we dispose the input list
		 */
		if (getViewer().getContentProvider() != null) { // TODO SWTB
			getViewer().setInput(null);
		}
		if (myListDispose) {
			getList().dispose();
		}

		if (getElements() != null) {
			getElements().dispose();
		}
		if (eIsSet(IUIBindingsPackage.Literals.CONTAINER_BINDING__SINGLE_SELECTION)) {
			getSingleSelection().dispose();
		}
		if (eIsSet(IUIBindingsPackage.Literals.VIEWER_BINDING__MULTIPLE_SELECTION)) {
			getMultipleSelection().dispose();
		}

		for (final IColumnBinding b : getColumns().toArray(new IColumnBinding[getColumns().size()])) {
			b.dispose();
		}

		super.dispose();
	}

	@Override
	public Control getControl() {
		return getViewer().getControl();
	}

	@Override
	public IValueBindingCell getCell(int column, int row, boolean visualModel) {
		if (getList().size() <= row) return null;
		if (getColumns().size() <= column) return null;
		final IColumnBinding cb = getColumns().get(column);
		return cb.getCellInformation(getList().get(row));
	}

	@Override
	public IColumnBindingCellInformation getCell(int columnNo, Object element) {
		final EList<IColumnBinding> cols = getColumns();
		if (columnNo < 0) return null;
		if (columnNo > cols.size()) return null;
		if (element == null) return null;
		// Based on the model column order
		final IColumnBinding column = cols.get(columnNo);
		final IColumnBindingCellInformation ci = column.getCellInformation(element);
		return ci;
	}

	/**
	 * The cached value of the '{@link #getColumns() <em>Columns</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<IColumnBinding> columns;

	/**
	 * The default value of the '{@link #getList() <em>List</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getList()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableList LIST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getList() <em>List</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getList()
	 * @generated
	 * @ordered
	 */
	protected IObservableList list = LIST_EDEFAULT;
	/**
	 * <code>true</code> if {@link #list} should be disposed by {@link #dispose()}.
	 */
	private boolean myListDispose = true;

	/**
	 * The default value of the '{@link #getElements() <em>Elements</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableSet ELEMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected IObservableSet elements = ELEMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMultipleSelection() <em>Multiple Selection</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMultipleSelection()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableList MULTIPLE_SELECTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMultipleSelection() <em>Multiple Selection</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMultipleSelection()
	 * @generated
	 * @ordered
	 */
	protected IObservableList multipleSelection = MULTIPLE_SELECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getViewer() <em>Viewer</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getViewer()
	 * @generated
	 * @ordered
	 */
	protected static final ColumnViewer VIEWER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewer() <em>Viewer</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getViewer()
	 * @generated
	 * @ordered
	 */
	protected ColumnViewer viewer = VIEWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstTableColumnOffset()
	 * <em>First Table Column Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFirstTableColumnOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int FIRST_TABLE_COLUMN_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFirstTableColumnOffset()
	 * <em>First Table Column Offset</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFirstTableColumnOffset()
	 * @generated
	 * @ordered
	 */
	protected int firstTableColumnOffset = FIRST_TABLE_COLUMN_OFFSET_EDEFAULT;

	/**
	 * Adapter used to track the current cursor to use in the viewer.
	 */
	private final Adapter myCursorAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;

			if (msg.getFeature() == IUIBindingsPackage.Literals.VIEWER_BINDING__COLUMNS) {
				switch (msg.getEventType()) {
				case Notification.REMOVE:
				case Notification.SET:
					final IColumnBinding c = (IColumnBinding) msg.getOldValue();
					c.eAdapters().remove(this);
					break;
				default:
					break;
				}
				switch (msg.getEventType()) {
				case Notification.ADD:
				case Notification.SET:
					final IColumnBinding c = (IColumnBinding) msg.getNewValue();
					c.eAdapters().add(this);
					break;
				default:
					break;
				}
				updateCursor();
			} else if (msg.getFeature() == IUIBindingsPackage.Literals.COLUMN_BINDING__CURSOR) {
				updateCursor();
			}
		};

		public void updateCursor() {
			getControl().getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					for (final IColumnBinding col : getColumns()) {
						final Cursor c = col.getCursor();
						if (c != null) {
							getControl().setCursor(c);
							return;
						}
					}
					getControl().setCursor(null);
				}
			});
		}
	};

	private MyTableViewerFocusCellManager myMyTableViewerFocusCellManager;
	private MyTreeViewerFocusCellManager myMyTreeViewerFocusCellManager;

	private ViewerBindingTreeFactory myTreeFactory;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ViewerBindingImpl() {
		super();

		eAdapters().add(myCursorAdapter);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.VIEWER_BINDING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IColumnBinding> getColumns() {
		if (columns == null) {
			columns = new EObjectWithInverseEList<IColumnBinding>(IColumnBinding.class, this,
					IUIBindingsPackage.VIEWER_BINDING__COLUMNS, IUIBindingsPackage.COLUMN_BINDING__VIEWER_BINDING);
		}
		return columns;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IObservableList getList() {
		return list;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setList(IObservableList newList) {
		final IObservableList oldList = list;
		list = newList;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.VIEWER_BINDING__LIST, oldList,
					list));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IObservableSet getElements() {
		return elements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElements(IObservableSet newElements) {
		final IObservableSet oldElements = elements;
		elements = newElements;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.VIEWER_BINDING__ELEMENTS,
					oldElements, elements));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IObservableValue getSingleSelection() {
		// TODO SWTB
		if (super.getSingleSelection() == null) {
			final IViewerValueProperty property = new MySelectionProviderSingleSelectionProperty() {
				@Override
				public Object getValueType() {
					return getList().getElementType();
				}
			};
			singleSelection = property.observe(viewer);
		}
		return super.getSingleSelection();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IObservableList getMultipleSelection() {
		// TODO SWTB
		if (multipleSelection == null) {
			multipleSelection = ViewersObservables.observeMultiSelection(getViewer());
		}
		return multipleSelection;
	}

	@Override
	public Collection<EObject> getSelection() {
		if (getControl() instanceof Table) {
			final Table t = (Table) getControl();
			final Collection<EObject> s = new ArrayList<EObject>(t.getSelectionCount());
			for (final int i : t.getSelectionIndices()) {
				s.add((EObject) getList().get(i));
			}

			return s;
		}
		if (getControl() instanceof Tree) {
			final Tree t = (Tree) getControl();
			final Collection<EObject> s = new ArrayList<EObject>(t.getSelectionCount());
			for (final TreeItem i : t.getSelection()) {
				s.add((EObject) i.getData());
			}

			return s;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @deprecated will be removed
	 */
	@Deprecated
	@Override
	public ColumnViewer getViewer() {
		return viewer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setViewer(ColumnViewer newViewer) {
		final ColumnViewer oldViewer = viewer;
		viewer = newViewer;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.VIEWER_BINDING__VIEWER, oldViewer,
					viewer));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getFirstTableColumnOffset() {
		return firstTableColumnOffset;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFirstTableColumnOffset(int newFirstTableColumnOffset) {
		final int oldFirstTableColumnOffset = firstTableColumnOffset;
		firstTableColumnOffset = newFirstTableColumnOffset;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.VIEWER_BINDING__FIRST_TABLE_COLUMN_OFFSET, oldFirstTableColumnOffset,
					firstTableColumnOffset));
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
		switch (featureID) {
		case IUIBindingsPackage.VIEWER_BINDING__COLUMNS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getColumns()).basicAdd(otherEnd, msgs);
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
		case IUIBindingsPackage.VIEWER_BINDING__COLUMNS:
			return ((InternalEList<?>) getColumns()).basicRemove(otherEnd, msgs);
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
		case IUIBindingsPackage.VIEWER_BINDING__COLUMNS:
			return getColumns();
		case IUIBindingsPackage.VIEWER_BINDING__LIST:
			return getList();
		case IUIBindingsPackage.VIEWER_BINDING__ELEMENTS:
			return getElements();
		case IUIBindingsPackage.VIEWER_BINDING__MULTIPLE_SELECTION:
			return getMultipleSelection();
		case IUIBindingsPackage.VIEWER_BINDING__VIEWER:
			return getViewer();
		case IUIBindingsPackage.VIEWER_BINDING__FIRST_TABLE_COLUMN_OFFSET:
			return getFirstTableColumnOffset();
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
		switch (featureID) {
		case IUIBindingsPackage.VIEWER_BINDING__COLUMNS:
			getColumns().clear();
			getColumns().addAll((Collection<? extends IColumnBinding>) newValue);
			return;
		case IUIBindingsPackage.VIEWER_BINDING__LIST:
			setList((IObservableList) newValue);
			return;
		case IUIBindingsPackage.VIEWER_BINDING__ELEMENTS:
			setElements((IObservableSet) newValue);
			return;
		case IUIBindingsPackage.VIEWER_BINDING__VIEWER:
			setViewer((ColumnViewer) newValue);
			return;
		case IUIBindingsPackage.VIEWER_BINDING__FIRST_TABLE_COLUMN_OFFSET:
			setFirstTableColumnOffset((Integer) newValue);
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
		case IUIBindingsPackage.VIEWER_BINDING__COLUMNS:
			getColumns().clear();
			return;
		case IUIBindingsPackage.VIEWER_BINDING__LIST:
			setList(LIST_EDEFAULT);
			return;
		case IUIBindingsPackage.VIEWER_BINDING__ELEMENTS:
			setElements(ELEMENTS_EDEFAULT);
			return;
		case IUIBindingsPackage.VIEWER_BINDING__VIEWER:
			setViewer(VIEWER_EDEFAULT);
			return;
		case IUIBindingsPackage.VIEWER_BINDING__FIRST_TABLE_COLUMN_OFFSET:
			setFirstTableColumnOffset(FIRST_TABLE_COLUMN_OFFSET_EDEFAULT);
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
		case IUIBindingsPackage.VIEWER_BINDING__COLUMNS:
			return columns != null && !columns.isEmpty();
		case IUIBindingsPackage.VIEWER_BINDING__LIST:
			return LIST_EDEFAULT == null ? list != null : !LIST_EDEFAULT.equals(list);
		case IUIBindingsPackage.VIEWER_BINDING__ELEMENTS:
			return ELEMENTS_EDEFAULT == null ? elements != null : !ELEMENTS_EDEFAULT.equals(elements);
		case IUIBindingsPackage.VIEWER_BINDING__MULTIPLE_SELECTION:
			return MULTIPLE_SELECTION_EDEFAULT == null ? multipleSelection != null : !MULTIPLE_SELECTION_EDEFAULT
					.equals(multipleSelection);
		case IUIBindingsPackage.VIEWER_BINDING__VIEWER:
			return VIEWER_EDEFAULT == null ? viewer != null : !VIEWER_EDEFAULT.equals(viewer);
		case IUIBindingsPackage.VIEWER_BINDING__FIRST_TABLE_COLUMN_OFFSET:
			return firstTableColumnOffset != FIRST_TABLE_COLUMN_OFFSET_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public Widget getWidget() {
		return getControl();
	}

	@Override
	public IBinding dynamic() {
		return this;
	}

	@Override
	public IBinding label(String label) {
		return this;
	}

	@Override
	public IBinding validValues(IObservableList list) {
		return this;
	}

	@Override
	public IBinding validValues(EObject obj, EReference reference) {
		return null;
	}

	@Override
	public void updateSourceProviderState(ISourceProviderStateContext context) {
		final ColumnViewer viewer = getViewer();

		context.putSourceValue(Constants.SOURCES_ACTIVE_CONTAINER_BINDING, this);
		context.putSourceValue(Constants.SOURCES_ACTIVE_CONTAINER_BINDING_NO_CAF,
				(viewer.getComparator() == null && viewer.getFilters().length == 0));

		context.putSourceValue(Constants.SOURCES_ACTIVE_VIEWER_ELEMENT_TYPE, getModelType());

		EObject element = null;
		int columnIndex = -1;
		ContainerCellType type = null;

		ViewerCell cell;
		/*
		 * If no specific position is specified in the event (x,y) = (0,0), then try using the
		 * current focus cell. This is needed when navigating in the table.
		 * 
		 * Also do this if the widget of the event is not this viewers control. That happens when
		 * extra widgets are mapped to this binding with IBinding.registerWidget()
		 */
		final Event event = context.getEvent();
		final Point point = context.getLocation();
		if (event.x == 0 && event.y == 0 || event.widget != getControl()) {
			cell = viewer.getColumnViewerEditor().getFocusCell();
		} else {
			cell = viewer.getCell(point);
		}
		if (cell != null) {
			element = (EObject) cell.getElement();
			columnIndex = cell.getColumnIndex();
			type = ContainerCellType.DATA;
		} else {
			final Control c = viewer.getControl();
			if (c instanceof Table) {
				final Table t = (Table) c;
				final TableItem item = t.getItem(point);
				if (item != null) {
					element = (EObject) item.getData();
					type = ContainerCellType.ROW_TRAILER;
				} else {
					/*
					 * Below or above the table?
					 */
					if (point.y < 0) {
						type = ContainerCellType.COLUMN_HEADER;
					} else {
						type = ContainerCellType.COLUMN_TRAILER;
					}
				}
			}
			if (c instanceof Tree) {
				final Tree t = (Tree) c;
				final TreeItem item = t.getItem(point);
				if (item != null) {
					element = (EObject) item.getData();
					type = ContainerCellType.ROW_TRAILER;
				} else {
					/*
					 * Below or above the tree?
					 */
					if (point.y < 0) {
						type = ContainerCellType.COLUMN_HEADER;
					} else {
						type = ContainerCellType.COLUMN_TRAILER;
					}
				}
			}
		}

		if (type != null) {
			context.putSourceValue(Constants.SOURCES_ACTIVE_CONTAINER_CELL_TYPE, type.toString());
		}
		if (element != null) {
			context.putSourceValue(Constants.SOURCES_ACTIVE_VIEWER_ELEMENT, element);
			context.putSourceValue(Constants.SOURCES_ACTIVE_VIEWER_ELEMENT_MOVE_UP,
					UIHandlerUtils.moveElement(this, element, -1, true));
			context.putSourceValue(Constants.SOURCES_ACTIVE_VIEWER_ELEMENT_MOVE_DOWN,
					UIHandlerUtils.moveElement(this, element, 1, true));
		}

		if (columnIndex >= getFirstTableColumnOffset() && element != null) {
			final IColumnBindingCellInformation ci = getCell(columnIndex - getFirstTableColumnOffset(), element);
			final IObservableValue objectValue = ci.getObjectValue();
			final Object value = objectValue.getValue();

			final IValueBinding labelBinding = ci.getLabelBinding();
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING, labelBinding);
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_RO, !ci.isChangeable());
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_VALUE, value);
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_TYPE, ""); //$NON-NLS-1$
			if (labelBinding != null) {
				context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, labelBinding.getModelObject());
				context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_FEATURE, labelBinding.getModelFeature());
				context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_UNSETTABLE, labelBinding.getDataType()
						.isUnsettable());
			}
			context.putSourceValue(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, ci.getDisplayText());

			context.addObservedValue(ci.getLabelUIAttribute().getCurrentValue());
		}

		context.setSelectionProvider(getViewer());
	}

	@Override
	public IContainerDropContext getDropContext(final DropTargetEvent event) {
		final Control control = getControl();
		final Point point = control.toControl(new Point(event.x, event.y));
		final ViewerCell vcell = getViewer().getCell(point);
		if (vcell == null) //
			return null;
		final IColumnBindingCellInformation cell = getCell(vcell.getColumnIndex() - getFirstTableColumnOffset(),
				vcell.getElement());

		return new IContainerDropContext() {
			@Override
			public EObject getDropTargetObject() {
				final IObservableValue valueOV = cell.getSourceValue();
				if (valueOV == null) return null;
				final Object value = valueOV.getValue();
				if (value instanceof EObject) return (EObject) value;
				return null;
				// final Widget item = event.item;
				// if (item == null) return null;
				// if (item.getData() instanceof EObject) return (EObject) item.getData();
				// return null;
			}

			@Override
			public float getDropLocation() {
				final Control control = getControl();
				final Point point = control.toControl(new Point(event.x, event.y));
				final Rectangle bounds;
				if (event.item instanceof TreeItem) {
					bounds = ((TreeItem) event.item).getBounds();
				} else if (event.item instanceof TableItem) {
					bounds = ((TableItem) event.item).getBounds(0);
				} else
					return 0.0F;

				return (float) (point.y - bounds.y) / (float) bounds.height;
			}

			@Override
			public IValueBindingCell getDropCell() {
				return cell;
			}

			@Override
			public List<IChildCreationSpecification> getPossibleChildObjects(EObject parent, EObject sibling) {
				return ViewerBindingImpl.this.getPossibleChildObjects(parent, sibling);
			}
		};
	}
} // ViewerBindingImpl
