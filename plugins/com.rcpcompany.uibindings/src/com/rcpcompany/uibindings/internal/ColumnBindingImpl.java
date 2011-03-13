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

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.OwnerDrawLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.ICellEditorFactory;
import com.rcpcompany.uibindings.ICellEditorFactoryContext;
import com.rcpcompany.uibindings.IColumnAdapter;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ISourceProviderStateContext;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.UIBindingsUtils.IClassIdentiferMapper;
import com.rcpcompany.uibindings.internal.cellEditors.SimpleCellEditorFactory;
import com.rcpcompany.uibindings.internal.observables.ListIndexObservableValue;
import com.rcpcompany.uibindings.observables.MapperObservableValue;
import com.rcpcompany.uibindings.uiAttributes.UIAttributePainter;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.uibindings.utils.IColumnChooser;
import com.rcpcompany.uibindings.utils.IManagerRunnable;
import com.rcpcompany.utils.basic.ToStringUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Column Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl#getViewerBinding <em>Viewer
 * Binding</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl#getViewerColumn <em>Viewer Column
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl#getColumnAdapter <em>Column
 * Adapter</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl#getBaseColumn <em>Base Column
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl#getSubColumns <em>Sub Columns
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl#getCells <em>Cells</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl#getSpecialBindingType <em>Special
 * Binding Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl#getFactory <em>Factory</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl#getCursor <em>Cursor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ColumnBindingImpl#getColumnVisibility <em>Column
 * Visibility</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ColumnBindingImpl extends BindingImpl implements IColumnBinding {
	@Override
	public String getDisplayText(Object element) {
		final IColumnBindingCellInformation ci = getCellInformation(element);
		return ci.getDisplayText();
	}

	/**
	 * Returns the viewer used for this column.
	 * 
	 * @return the viewer
	 */
	public ColumnViewer getViewer() {
		return getViewerBinding().getViewer(); // TODO SWTB
	}

	/**
	 * The label provider for the column.
	 */
	private GeneralLabelProvider myLabelProvider;

	@Override
	public IColumnBinding model(EStructuralFeature feature) {
		assertTrue(feature != null, "No feature?"); //$NON-NLS-1$
		return model(UIBindingsEMFObservables.valueFactory(Realm.getDefault(), getEditingDomain(), feature), feature);
	}

	@Override
	public IColumnBinding model(IColumnBinding baseCol, EStructuralFeature feature) {
		assertTrue(baseCol != null, "No base column?"); //$NON-NLS-1$
		assertTrue(baseCol.getViewerBinding() == getViewerBinding(), "Not same viewer"); //$NON-NLS-1$
		setBaseColumn(baseCol);
		return model(feature);
	}

	@Override
	public IColumnBinding model(SpecialBinding specialValue) {
		assertTrue(specialValue != null, "No value?"); //$NON-NLS-1$
		setSpecialBindingType(specialValue);
		switch (specialValue) {
		case ROW_ELEMENT:
			final IObservableFactory rowElementFactory = new IObservableFactory() {
				@Override
				public IObservable createObservable(Object target) {
					return Observables.constantObservableValue(target, EcorePackage.Literals.EOBJECT);
				}
			};
			return model(rowElementFactory, EcorePackage.Literals.EOBJECT).dynamic();
		case ROW_NO:
			final IObservableFactory rowNoFactory = new IObservableFactory() {
				@Override
				public IObservable createObservable(Object target) {
					return new ListIndexObservableValue(getViewerBinding().getList(), target, 1);
				}
			};
			return model(rowNoFactory, EcorePackage.Literals.EINT).label(Messages.ColumnBindingImpl_RowNo_ColumnHeader)
					.readonly().arg(IColumnChooser.ARG_CHOOSABLE, false);
		case TREE_ITEM:
			final IObservableFactory treeItemFactory = new IObservableFactory() {
				private final IObservableValue dummyOV = WritableValue.withValueType(EcorePackage.Literals.EOBJECT);
				private final IUIAttribute dummyAttribute = new VirtualUIAttribute(String.class);
				/*
				 * This binding is finished before first use by the context...
				 */
				private final IValueBinding dummyBinding = getContext().addBinding().ui(dummyAttribute).model(dummyOV)
						.dynamic();

				@Override
				public IObservable createObservable(Object target) {
					if (!(target instanceof EObject)) return null;
					final EObject eobj = (EObject) target;
					final EClass ec = eobj.eClass();

					dummyBinding.getExtraArgumentProviders().clear();
					dummyBinding.clearCachedArguments();
					/*
					 * This is not pretty - or efficient!
					 * 
					 * The problem: to know the value of the argument ARG_FEATURE_NAME, we need a
					 * binding with a observable value with the correct value - but in the
					 * observable factory we don't yet have the correct value...
					 * 
					 * The solution - for now: to have an extra dynamic binding which gets the
					 * correct value and is then asked for the argument :-/
					 */
					dummyOV.setValue(eobj);

					/*
					 * Special case: for ConstantTreeItem, we use the description as an extra
					 * argument provider
					 */
					if (eobj instanceof IConstantTreeItem) {
						dummyBinding.getExtraArgumentProviders().add(((IConstantTreeItem) eobj).getDescriptor());
					}

					/*
					 * Any constant string is used first of all...
					 * 
					 * TODO: Problem: if text is specified, icon and other arguments are ignored!
					 */
					final String constantText = dummyBinding.getArgument(ARG_TEXT, String.class, null);
					if (constantText != null)
						return Observables.constantObservableValue(constantText, EcorePackage.Literals.ESTRING);

					/*
					 * Check for a mapper...
					 */
					final IClassIdentiferMapper mapper = UIBindingsUtils.createClassIdentiferMapper(dummyBinding, ec);

					if (mapper instanceof UIBindingsUtils.DefaultMapper) {
						// LogUtils.debug(ColumnBindingImpl.this, "Default mapper for '" + target +
						// "'");
					}
					final IObservableValue ov = Observables.constantObservableValue(eobj, ec);
					return new MapperObservableValue(ov, getContext().getEditingDomain(), mapper);
				}
			};
			return model(treeItemFactory, EcorePackage.Literals.EJAVA_OBJECT)
					.label(Messages.ColumnBindingImpl_TreeItem_ColumnHeader).dynamic()
					.arg(IColumnChooser.ARG_CHOOSABLE, false);
		default:
			assertTrue(false, "Special value " + specialValue + " not supported for this type of binding"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return this;
	}

	/**
	 * Initializes the factory and dataType fields.
	 * 
	 * @param factory the factory to use
	 * @param dataType the data type to use.
	 * @return <code>this</code>
	 */
	private IColumnBinding model(IObservableFactory factory, IBindingDataType dataType) {
		assertTrue(factory != null, "No factory?"); //$NON-NLS-1$
		assertTrue(dataType != null, "No data type?"); //$NON-NLS-1$
		this.factory = factory;
		setStaticDataType(dataType);
		return this;
	}

	@Override
	public IColumnBinding model(IObservableFactory factory, EClassifier type) {
		assertTrue(factory != null, "No factory?"); //$NON-NLS-1$
		assertTrue(type != null, "No type?"); //$NON-NLS-1$

		return model(factory, IBindingDataType.Factory.create(null, type));
	}

	@Override
	public IColumnBinding model(IObservableFactory factory, EStructuralFeature feature) {
		assertTrue(factory != null, "No factory?"); //$NON-NLS-1$
		assertTrue(feature != null, "No type?"); //$NON-NLS-1$

		return model(factory, IBindingDataType.Factory.create(factory, feature));
	}

	@Override
	public IColumnBinding model(IColumnBinding baseColumn, IObservableFactory factory, EStructuralFeature feature) {
		assertTrue(baseColumn != null, "No base column?"); //$NON-NLS-1$
		assertTrue(baseColumn.getViewerBinding() == getViewerBinding(), "Not same viewer"); //$NON-NLS-1$
		setBaseColumn(baseColumn);
		return model(factory, feature);
	}

	@Override
	public IColumnBinding arg(String name, Object value) {
		assertTrue(name != null, "name must be non-null"); //$NON-NLS-1$
		getArguments().put(name.intern(), value);
		return this;
	}

	@Override
	public IColumnBinding args(Map<String, Object> arguments) {
		setArguments(arguments);
		return this;
	}

	@Override
	public IColumnBinding type(String type) {
		return arg(Constants.ARG_TYPE, type);
	}

	@Override
	public IColumnBinding readonly() {
		return arg(Constants.ARG_READONLY, true);
	}

	@Override
	public IColumnBinding id(String id) {
		setId(id);
		return this;
	}

	@Override
	public IColumnBinding dynamic() {
		return arg(Constants.ARG_DYNAMIC, true);
	}

	@Override
	public IColumnBinding label(String label) {
		return arg(Constants.ARG_LABEL, label);
	}

	@Override
	public IColumnBinding validValues(IObservableList list) {
		return arg(Constants.ARG_VALID_VALUES, list);
	}

	@Override
	public IColumnBinding validValues(EObject obj, EReference reference) {
		return validValues(UIBindingsEMFObservables.observeList(getEditingDomain(), obj, reference));
	}

	@Override
	public IColumnBinding addColumn(ViewerColumn column, EStructuralFeature feature) {
		return getViewerBinding().addColumn().column(column).model(this, feature);
	}

	@Override
	public IColumnBinding addColumn(TableColumn column, EStructuralFeature feature) {
		return getViewerBinding().addColumn().column(column).model(this, feature);
	}

	@Override
	public IColumnBinding addColumn(TreeColumn column, EStructuralFeature feature) {
		return getViewerBinding().addColumn().column(column).model(this, feature);
	}

	@Override
	public IColumnBinding column(ViewerColumn column) {
		assertTrue(column != null, "No column?"); //$NON-NLS-1$
		assertTrue(column.getViewer() == getViewer(), "column does not belong to this viewer"); //$NON-NLS-1$
		setViewerColumn(column);
		if (column instanceof TableViewerColumn) {
			setColumnAdapter(new TableColumnAdapter(((TableViewerColumn) column).getColumn()));
		} else if (column instanceof TreeViewerColumn) {
			setColumnAdapter(new TreeColumnAdapter(((TreeViewerColumn) column).getColumn()));
		} else {
			assertTrue(false, "Viewer Column type not supported"); //$NON-NLS-1$
		}
		return this;
	}

	@Override
	public IColumnBinding column(TableColumn column) {
		assertTrue(column != null, "No column?"); //$NON-NLS-1$
		final ColumnViewer viewer = getViewer();
		assertTrue(viewer instanceof TableViewer, "A TableColumn can only be added to a TableViewer"); //$NON-NLS-1$
		return column(new TableViewerColumn((TableViewer) viewer, column));
	}

	@Override
	public IColumnBinding column(TreeColumn column) {
		assertTrue(column != null, "No column?"); //$NON-NLS-1$
		final ColumnViewer viewer = getViewer();
		assertTrue(viewer instanceof TreeViewer, "A TreeColumn can only be added to a TreeViewer"); //$NON-NLS-1$
		return column(new TreeViewerColumn((TreeViewer) viewer, column));
	}

	@Override
	public Class<?> getUIType() {
		return String.class;
	}

	/**
	 * This will finish the binding and make it effective.
	 * <p>
	 * The idea is to use a proper UI binding to do the conversion of values exactly as for
	 * {@link Text} widgets.
	 * <p>
	 * This entails the following steps:
	 * <ul>
	 * <li>Setting the column header if not already set</li>
	 * <li>finding the {@link #getModelType() model value type}</li>
	 * <li>creating a new {@link IUIAttribute} for this binding</li>
	 * <li>setting up a binding between the two</li>
	 * <li>setting up a column map to track changes in the column and report these via the label
	 * provider
	 * </ul>
	 */
	@Override
	public void finish1() {
		final ViewerColumn c = getViewerColumn();
		assertTrue(c != null, "No column set"); //$NON-NLS-1$
		assertTrue(getStaticDataType() != null, "No column data type set"); //$NON-NLS-1$

		/*
		 * Check that the feature can be used with the source
		 */
		// Object type = source.getValueType();
		// EClass sourceEClass = null;
		// if (type instanceof EClass) {
		// sourceEClass = (EClass) type;
		// } else if (type instanceof EReference) {
		// sourceEClass = ((EReference) type).getEReferenceType();
		// } else {
		// LogUtils.debug(this, "EClass of source unknown");
		// }
		// TODO:XXX possibly add an extended IOF interface, that lets the provider
		// specify a base EC as well.
		// if (sourceEClass != null && myFactory == null) {
		// Assert.isTrue(getFeature().getEContainingClass().isSuperTypeOf(sourceEClass), "Feature "
		// + getFeature().getEContainingClass().getName() + "." + getFeature().getName() +
		// " is not of type "
		// + sourceEClass.getName());
		// }

		if (getColumnAdapter() != null) {
			final Widget widget = getColumnAdapter().getWidget();
			registerWidget(widget);
			/*
			 * The name of the column, if not already set.
			 */
			String name = getColumnAdapter().getText();
			if (name == null || name.length() == 0) {
				name = getLabel();
				getColumnAdapter().setText(name);
			}

			// TODO bind help ID
			String value;
			// value = getArgument(IBinding.ARG_HELP_ID, String.class, null);
			// if (value != null) PlatformUI.getWorkbench().getHelpSystem().setHelp(control, value);

			// bind tool tip
			value = getArgument(Constants.ARG_TOOL_TIP_TEXT, String.class, null);
			if (value != null) {
				getColumnAdapter().setToolTipText(value);
			}

			final Integer align = getArgument(Constants.ARG_ALIGNMENT, Integer.class, null);
			if (align == null) {
				arg(Constants.ARG_ALIGNMENT, getColumnAdapter().getAlignment());
			}
			getColumnAdapter().setAlignment(SWT.CENTER);
		}

		/*
		 * Remove items from the cell information map when they are not shown in the table
		 * anymore...
		 */
		getViewerBinding().getElements().addSetChangeListener(new ISetChangeListener() {
			@Override
			public void handleSetChange(SetChangeEvent event) {
				for (final Object o : event.diff.getRemovals()) {
					final IColumnBindingCellInformation ci = getCellInformation(o, false);
					if (ci != null) {
						ci.dispose();
					}
				}
			}
		});
	}

	@Override
	public void finish2() {
		super.finish2();

		myLabelProvider = new GeneralLabelProvider();
		getViewerColumn().setLabelProvider(myLabelProvider);
		myEditingSupport = new MyEditingSupport();
		getViewerColumn().setEditingSupport(myEditingSupport);
	}

	@Override
	public void dispose() {
		if (isDisposed()) return;
		setState(BindingState.DISPOSE_PENDING);
		disposeServices();
		/*
		 * Dispose any columns first that depends on this column...
		 */
		while (getSubColumns().size() > 0) {
			getSubColumns().get(0).dispose();
		}
		final IColumnBindingCellInformation[] ciArray = getCells().values().toArray(
				new IColumnBindingCellInformation[getCells().values().size()]);
		for (final IColumnBindingCellInformation ci : ciArray) {
			ci.dispose();
		}
		if (getColumnAdapter() != null) {
			final Widget widget = getColumnAdapter().getWidget();
			unregisterWidget(widget);
		}
		setBaseColumn(null);

		if (myLabelProvider != null) {
			myLabelProvider.dispose();
			myLabelProvider = null;
		}
		// EditingSupport need not be disposed.
		super.dispose();
	}

	/**
	 * Taken directly from
	 * http://dev.eclipse.org/viewcvs/index.cgi/org.eclipse.jface.snippets/Eclipse
	 * %20JFace%20Snippets
	 * /org/eclipse/jface/snippets/viewers/Snippet041TableViewerAlternatingColors.java?view=markup
	 */
	protected static class OptimizedIndexSearcher {
		private int lastIndex = 0;

		public boolean isEven(TableItem item) {
			final TableItem[] items = item.getParent().getItems();

			// 1. Search the next ten items
			for (int i = lastIndex; i < items.length && lastIndex + 10 > i; i++) {
				if (items[i] == item) {
					lastIndex = i;
					return lastIndex % 2 == 0;
				}
			}

			// 2. Search the previous ten items
			for (int i = lastIndex; i < items.length && lastIndex - 10 > i; i--) {
				if (items[i] == item) {
					lastIndex = i;
					return lastIndex % 2 == 0;
				}
			}

			// 3. Start from the beginning
			for (int i = 0; i < items.length; i++) {
				if (items[i] == item) {
					lastIndex = i;
					return lastIndex % 2 == 0;
				}
			}

			return false;
		}
	}

	/**
	 * Utility object used to find index number
	 */
	protected final OptimizedIndexSearcher myIndexSearcher = new OptimizedIndexSearcher();

	/**
	 * The {@link ColumnLabelProvider column label provider} used for this column.
	 * <p>
	 * Uses the map to provide {@link LabelProviderChangedEvent label provider changed events}.
	 */
	private class GeneralLabelProvider extends OwnerDrawLabelProvider {

		private GeneralLabelProvider() {
			setOwnerDrawEnabled(getViewer(), getViewerColumn(), true);
		}

		/**
		 * Whether there are an outstanding asyncExec for fireLabelProviderChanged()..
		 */
		protected Set<EObject> myHasOutstandingFireLabelProviderChangedSet = new HashSet<EObject>();

		public void fireChanged(final IColumnBindingCellInformation ci) {
			/*
			 * No need to do anything more if we already have an outstanding request...
			 */
			final Control control = getViewerColumn().getViewer().getControl();
			if (control.isDisposed()) return;
			final EObject element = ci.getElement();
			synchronized (myHasOutstandingFireLabelProviderChangedSet) {
				if (myHasOutstandingFireLabelProviderChangedSet.contains(element)) return;
				myHasOutstandingFireLabelProviderChangedSet.add(element);
			}
			if (Activator.getDefault().TRACE_EVENTS_LABELPROVIDERS) {
				LogUtils.debug(ci.getLabelBinding(), ci.getLabelBinding() + " label changed"); //$NON-NLS-1$
			}
			IManagerRunnable.Factory.asyncExec("labels", this, new Runnable() {
				@Override
				public void run() {
					if (control.isDisposed()) return;
					if (Activator.getDefault().TRACE_EVENTS_LABELPROVIDERS) {
						LogUtils.debug(ci.getLabelBinding(), "label changed (fired)"); //$NON-NLS-1$
					}
					// LogUtils.debug(this, "!!fire " + element);

					Object[] elements;
					synchronized (myHasOutstandingFireLabelProviderChangedSet) {
						elements = myHasOutstandingFireLabelProviderChangedSet.toArray();
						myHasOutstandingFireLabelProviderChangedSet.clear();
					}
					final LabelProviderChangedEvent event = new LabelProviderChangedEvent(GeneralLabelProvider.this,
							elements);
					fireLabelProviderChanged(event);
				}
			});
		}

		@Override
		public String getToolTipText(Object element) {
			final IColumnBindingCellInformation ci = getCellInformation(element);
			return ci.getToolTipText();
		}

		@Override
		public void update(ViewerCell cell) {
			final Object element = cell.getElement();
			final IColumnBindingCellInformation ci = getCellInformation(element);
			if (ci == null) return;
			final IValueBinding labelBinding = ci.getLabelBinding();
			if (Activator.getDefault().TRACE_EVENTS_LABELPROVIDERS) {
				LogUtils.debug(labelBinding, labelBinding + " update: " //$NON-NLS-1$
						+ labelBinding.getUIAttribute().getCurrentValue().getValue());
			}

			/*
			 * Redraw the cell...
			 */
			super.update(cell);

			// TODO possible move this to an extender
			if (labelBinding.eIsSet(IUIBindingsPackage.Literals.BINDING__ERROR_CONDITIONS)) {
				final List<String> errorConditions = labelBinding.getErrorConditions();
				if (errorConditions.size() > 0) {
					final StringBuilder sb = new StringBuilder(200);
					for (final String e : errorConditions) {
						sb.append(e).append('\n');
					}
					cell.setForeground(JFaceColors.getErrorText(Display.getCurrent()));
					cell.setBackground(JFaceColors.getErrorBackground(Display.getCurrent()));
					cell.setText(sb.toString());
					return;
				}
			}

			/*
			 * Map all changes to the label attribute to the cell.
			 */
			final IUIAttribute labelAttribute = ci.getLabelUIAttribute();
			final String tt = labelAttribute.getTooltip();
			if (tt != null) {
				ci.setToolTipText(tt);
			}

			final UIAttributePainter painter = ci.getLabelPainter();
			if (labelBinding.getModelType() == Boolean.class || labelBinding.getModelType() == Boolean.TYPE) {
				painter.setCheckbox((Boolean) labelBinding.getModelObservableValue().getValue());
				painter.setHorizontalAlignment(SWT.CENTER);
			} else {
				painter.setCheckbox(null);
				final Integer align = labelBinding.getArgument(Constants.ARG_ALIGNMENT, Integer.class, null);
				if (align != null) {
					painter.setHorizontalAlignment(align);
				}
			}

			setCursor(labelAttribute.getCursor());

			// For testing
			cell.setText((String) labelAttribute.getCurrentValue().getValue());
			// Removed as Windows behaves strangely!
			// cell.setImage(ci.getLabelUIAttribute().getImage());
		}

		/**
		 * Sets up the painter.
		 * 
		 * @param ci the cell
		 * @param event the event that resulted in the painting
		 */
		private void setupPainter(final IColumnBindingCellInformation ci, Event event) {
			final UIAttributePainter painter = ci.getLabelPainter();
			if (painter == null) return;

			/*
			 * Figure out whether the cell has focus
			 */
			// TODO SVTB
			final ViewerCell focusCell = getViewerBinding().getViewer().getColumnViewerEditor().getFocusCell();
			final boolean hasFocus = focusCell != null && focusCell.getItem() == event.item
					&& focusCell.getColumnIndex() == event.index;
			painter.setFocus(hasFocus);
			// myPainter.setSelected((event.detail & SWT.SELECTED) != 0);
			// myPainter.setFocus((event.detail & SWT.FOCUSED) != 0);
		}

		/**
		 * Handle the erase event. The default implementation does nothing to ensure keep native
		 * selection highlighting working.
		 * 
		 * @param event the erase event
		 * @param element the model object
		 * @see SWT#EraseItem
		 */
		@Override
		protected void erase(Event event, Object element) {
			// info has been set by 'update': announce that we paint ourselves
			event.detail &= ~SWT.FOREGROUND;
			// We handle selected state
			event.detail &= ~SWT.SELECTED;
		}

		@Override
		protected void measure(Event event, Object element) {
			final IColumnBindingCellInformation ci = getCellInformation(element);
			if (ci == null) return;
			setupPainter(ci, event);

			final UIAttributePainter painter = ci.getLabelPainter();
			if (painter != null) {
				event.width = painter.getTextWidthDelta(event.gc);
				if (event.height < UIAttributePainter.getMinHeight()) {
					event.height = UIAttributePainter.getMinHeight();
				}
			}
		}

		@Override
		protected void paint(Event event, Object element) {
			final IColumnBindingCellInformation ci = getCellInformation(element);
			if (ci == null) return;
			final IValueBinding labelBinding = ci.getLabelBinding();
			if (Activator.getDefault().TRACE_EVENTS_LABELPROVIDERS) {
				LogUtils.debug(labelBinding, labelBinding + " paint: " + ci.getDisplayText()); //$NON-NLS-1$
			}
			if (Activator.getDefault().TRACE_EVENTS_LABELPROVIDERS && Activator.getDefault().TRACE_EVENTS_SWT) {
				LogUtils.debug(labelBinding, ToStringUtils.toString(event));
			}

			if (labelBinding.eIsSet(IUIBindingsPackage.Literals.BINDING__ERROR_CONDITIONS)) return;
			setupPainter(ci, event);
			final UIAttributePainter painter = ci.getLabelPainter();
			painter.setDefaultBackground(null);
			if (event.item instanceof TableItem && IManager.Factory.getManager().isAlternateRowColors()) {
				final TableItem item = (TableItem) event.item;
				final boolean even = myIndexSearcher.isEven(item);
				if (even) {
					painter.setDefaultBackground(JFaceResources.getColorRegistry().get(
							Constants.COLOR_DEFINITIONS_EVEN_ROW_BACKGROUND));
				} else {
					painter.setDefaultBackground(getViewer().getControl().getDisplay().getSystemColor(SWT.COLOR_WHITE));
				}
			}

			/*
			 * Find the bounds of the item - depends on Table or Tree
			 */
			final Rectangle innerCellBounds;
			if (event.item instanceof TableItem) {
				innerCellBounds = ((TableItem) event.item).getBounds(event.index);
			} else if (event.item instanceof TreeItem) {
				innerCellBounds = ((TreeItem) event.item).getBounds(event.index);
			} else {
				LogUtils.error(this, "Cannot compute cell bounds. Cell ignored.");
				return;
			}
			final Rectangle outerCellBounds = new Rectangle(innerCellBounds.x + 16, innerCellBounds.y,
					innerCellBounds.width - 2 * 16, innerCellBounds.height);

			/*
			 * Update the image decorations of the label...
			 */
			labelBinding.getUIAttribute().updateImageDecorations(getViewerBinding().getControl(), innerCellBounds,
					outerCellBounds);

			painter.paint(event.gc, innerCellBounds);
		}
	}

	/**
	 * Editing Support for the column.
	 */
	public class MyEditingSupport extends EditingSupport {
		/**
		 * Constructs and returns a new support object for this column.
		 */
		public MyEditingSupport() {
			super(ColumnBindingImpl.this.getViewer());
		}

		@Override
		protected boolean canEdit(Object element) {
			final ViewerCell focusCell = getViewer().getColumnViewerEditor().getFocusCell();
			if (focusCell == null) return false;
			if (focusCell.getElement() != focusCell.getViewerRow().getElement()) {
				LogUtils.debug(ColumnBindingImpl.this, "\ncell.element=" + focusCell.getElement() + "\nitem.data=" //$NON-NLS-1$ //$NON-NLS-2$
						+ focusCell.getViewerRow().getElement());
			}
			final boolean changeable = getCellInformation(element).isChangeable();
			if (Activator.getDefault().TRACE_LIFECYCLE_COLUMN_EDITORS) {
				LogUtils.debug(ColumnBindingImpl.this, "element=" + element + "\nchangeable: " + changeable); //$NON-NLS-1$ //$NON-NLS-2$
			}
			return changeable;
		}

		@Override
		protected void initializeCellEditorValue(CellEditor cellEditor, ViewerCell cell) {
		}

		@Override
		protected void saveCellEditorValue(CellEditor cellEditor, ViewerCell cell) {
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			final ViewerCell focusCell = getViewer().getColumnViewerEditor().getFocusCell();
			if (focusCell == null) return null;
			if (focusCell.getElement() != focusCell.getViewerRow().getElement()) {
				LogUtils.debug(ColumnBindingImpl.this, "\ncell.element=" + focusCell.getElement() + "\nitem.data=" //$NON-NLS-1$ //$NON-NLS-2$
						+ focusCell.getViewerRow().getElement());
			}
			if (Activator.getDefault().TRACE_LIFECYCLE_COLUMN_EDITORS) {
				LogUtils.debug(ColumnBindingImpl.this, "element=" + element); //$NON-NLS-1$
			}
			final IColumnBindingCellInformation ci = getCellInformation(element);

			/*
			 * Find the cell editor to use form the binding. Defaults to a text widget
			 */
			final ICellEditorFactory factory = ci.getLabelBinding().getArgument(
					Constants.ARG_PREFERRED_CELL_EDITOR_FACTORY, ICellEditorFactory.class,
					SimpleCellEditorFactory.Factory.getFactory());

			/*
			 * Context used for the editor creation.
			 */
			final ICellEditorFactoryContext context = new ICellEditorFactoryContext() {
				@Override
				public IValueBindingCell getCell() {
					return ci;
				}

				@Override
				public Composite getParent() {
					/*
					 * We know the control of the viewer is either a Table or a Tree - in both cases
					 * a Composite
					 */
					return (Composite) getViewer().getControl();
				}
			};

			try {
				return factory.create(context);
			} catch (final Exception ex) {
				LogUtils.error(this, ex);
			}
			return null;
		}

		@Override
		protected Object getValue(Object element) {
			// Never used - uses data binding instead
			return null;
		}

		@Override
		protected void setValue(Object element, Object value) {
			// Never used - uses data binding instead
		}
	}

	@Override
	public IObservableValue getValue(Object element) {
		final IColumnBindingCellInformation ci = getCellInformation(element);
		return ci.getObjectValue();
	}

	@Override
	public IBinding getParentBinding() {
		return getViewerBinding();
	}

	/**
	 * The cell information objects for this column.
	 */
	public MyEditingSupport myEditingSupport = null;

	@Override
	public IColumnBindingCellInformation getCellInformation(Object element, boolean create) {
		if (isDisposed()) return null;
		final Object baseElement = element;
		// TODO?
		if (element instanceof IConstantTreeItem) {
			final IConstantTreeItem ti = (IConstantTreeItem) element;
			// baseElement = ti.getTarget();
		}
		IColumnBindingCellInformation ci = getCells().get(baseElement);

		if (ci == null && create) {
			ci = IUIBindingsFactory.eINSTANCE.createColumnBindingCellInformation(this, element);
		}
		return ci;
	}

	@Override
	public IColumnBindingCellInformation getCellInformation(Object element) {
		return getCellInformation(element, true);
	}

	private static class TableColumnAdapter extends ColumnAdapterImpl {
		private final TableColumn myColumn;

		private TableColumnAdapter(TableColumn column) {
			myColumn = column;
		}

		@Override
		public Widget getWidget() {
			return myColumn;
		}

		@Override
		public int getAlignment() {
			return myColumn.getAlignment();
		}

		@Override
		public void setAlignment(int alignment) {
			myColumn.setAlignment(alignment);
		}

		@Override
		public void setImage(Image image) {
			myColumn.setImage(image);
		}

		@Override
		public void setMoveable(boolean moveable) {
			myColumn.setMoveable(moveable);
		}

		@Override
		public void setResizable(boolean resizable) {
			myColumn.setResizable(resizable);
		}

		@Override
		public void setText(String text) {
			myColumn.setText(text);
		}

		@Override
		public void setToolTipText(String text) {
			myColumn.setToolTipText(text);
		}

		@Override
		public void setWidth(int width) {
			myColumn.setWidth(width);
		}

		@Override
		public String getText() {
			return myColumn.getText();
		}

		@Override
		public void addSelectionListener(SelectionListener listener) {
			myColumn.addSelectionListener(listener);
		}

		@Override
		public void removeSelectionListener(SelectionListener listener) {
			myColumn.removeSelectionListener(listener);
		}

		@Override
		public Image getImage() {
			return myColumn.getImage();
		}

		@Override
		public String getToolTipText() {
			return myColumn.getToolTipText();
		}

		@Override
		public int getWidth() {
			return myColumn.getWidth();
		}

		@Override
		public boolean isMoveable() {
			return myColumn.getMoveable();
		}

		@Override
		public boolean isResizable() {
			return myColumn.getResizable();
		}
	}

	private static class TreeColumnAdapter extends ColumnAdapterImpl {

		private final TreeColumn myColumn;

		@Override
		public Widget getWidget() {
			return myColumn;
		}

		private TreeColumnAdapter(TreeColumn column) {
			myColumn = column;
		}

		@Override
		public int getAlignment() {
			return myColumn.getAlignment();
		}

		@Override
		public void setAlignment(int alignment) {
			myColumn.setAlignment(alignment);
		}

		@Override
		public void setImage(Image image) {
			myColumn.setImage(image);
		}

		@Override
		public void setMoveable(boolean moveable) {
			myColumn.setMoveable(moveable);
		}

		@Override
		public void setResizable(boolean resizable) {
			myColumn.setResizable(resizable);
		}

		@Override
		public void setText(String text) {
			myColumn.setText(text);
		}

		@Override
		public void setToolTipText(String text) {
			myColumn.setToolTipText(text);
		}

		@Override
		public void setWidth(int width) {
			myColumn.setWidth(width);
		}

		@Override
		public String getText() {
			return myColumn.getText();
		}

		@Override
		public void addSelectionListener(SelectionListener listener) {
			myColumn.addSelectionListener(listener);
		}

		@Override
		public void removeSelectionListener(SelectionListener listener) {
			myColumn.removeSelectionListener(listener);
		}

		@Override
		public Image getImage() {
			return myColumn.getImage();
		}

		@Override
		public String getToolTipText() {
			return myColumn.getToolTipText();
		}

		@Override
		public int getWidth() {
			return myColumn.getWidth();
		}

		@Override
		public boolean isMoveable() {
			return myColumn.getMoveable();
		}

		@Override
		public boolean isResizable() {
			return myColumn.getResizable();
		}
	}

	/**
	 * The cached value of the '{@link #getViewerBinding() <em>Viewer Binding</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getViewerBinding()
	 * @generated
	 * @ordered
	 */
	protected IViewerBinding viewerBinding;

	/**
	 * The default value of the '{@link #getViewerColumn() <em>Viewer Column</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getViewerColumn()
	 * @generated
	 * @ordered
	 */
	protected static final ViewerColumn VIEWER_COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewerColumn() <em>Viewer Column</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getViewerColumn()
	 * @generated
	 * @ordered
	 */
	protected ViewerColumn viewerColumn = VIEWER_COLUMN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getColumnAdapter() <em>Column Adapter</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getColumnAdapter()
	 * @generated
	 * @ordered
	 */
	protected IColumnAdapter columnAdapter;

	/**
	 * The cached value of the '{@link #getBaseColumn() <em>Base Column</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseColumn()
	 * @generated
	 * @ordered
	 */
	protected IColumnBinding baseColumn;

	/**
	 * The cached value of the '{@link #getSubColumns() <em>Sub Columns</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSubColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<IColumnBinding> subColumns;

	/**
	 * The cached value of the '{@link #getCells() <em>Cells</em>}' map. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCells()
	 * @generated
	 * @ordered
	 */
	protected EMap<EObject, IColumnBindingCellInformation> cells;

	/**
	 * The default value of the '{@link #getSpecialBindingType() <em>Special Binding Type</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSpecialBindingType()
	 * @generated
	 * @ordered
	 */
	protected static final SpecialBinding SPECIAL_BINDING_TYPE_EDEFAULT = SpecialBinding.ROW_NO;

	/**
	 * The cached value of the '{@link #getSpecialBindingType() <em>Special Binding Type</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSpecialBindingType()
	 * @generated
	 * @ordered
	 */
	protected SpecialBinding specialBindingType = SPECIAL_BINDING_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFactory() <em>Factory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactory()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableFactory FACTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFactory() <em>Factory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactory()
	 * @generated
	 * @ordered
	 */
	protected IObservableFactory factory = FACTORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCursor() <em>Cursor</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCursor()
	 * @generated
	 * @ordered
	 */
	protected static final Cursor CURSOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCursor() <em>Cursor</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getCursor()
	 * @generated
	 * @ordered
	 */
	protected Cursor cursor = CURSOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getColumnVisibility() <em>Column Visibility</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getColumnVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue COLUMN_VISIBILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColumnVisibility() <em>Column Visibility</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getColumnVisibility()
	 * @generated
	 * @ordered
	 */
	protected IObservableValue columnVisibility = COLUMN_VISIBILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ColumnBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.COLUMN_BINDING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IViewerBinding getViewerBinding() {
		return viewerBinding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetViewerBinding(IViewerBinding newViewerBinding, NotificationChain msgs) {
		final IViewerBinding oldViewerBinding = viewerBinding;
		viewerBinding = newViewerBinding;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.COLUMN_BINDING__VIEWER_BINDING, oldViewerBinding, newViewerBinding);
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
	@Override
	public void setViewerBinding(IViewerBinding newViewerBinding) {
		if (newViewerBinding != viewerBinding) {
			NotificationChain msgs = null;
			if (viewerBinding != null) {
				msgs = ((InternalEObject) viewerBinding).eInverseRemove(this,
						IUIBindingsPackage.VIEWER_BINDING__COLUMNS, IViewerBinding.class, msgs);
			}
			if (newViewerBinding != null) {
				msgs = ((InternalEObject) newViewerBinding).eInverseAdd(this,
						IUIBindingsPackage.VIEWER_BINDING__COLUMNS, IViewerBinding.class, msgs);
			}
			msgs = basicSetViewerBinding(newViewerBinding, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.COLUMN_BINDING__VIEWER_BINDING,
					newViewerBinding, newViewerBinding));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public ViewerColumn getViewerColumn() {
		assertTrue(viewerColumn != null, "Column has not been set"); //$NON-NLS-1$
		return viewerColumn;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setViewerColumn(ViewerColumn newViewerColumn) {
		final ViewerColumn oldViewerColumn = viewerColumn;
		viewerColumn = newViewerColumn;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.COLUMN_BINDING__VIEWER_COLUMN,
					oldViewerColumn, viewerColumn));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IColumnAdapter getColumnAdapter() {
		return columnAdapter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setColumnAdapter(IColumnAdapter newColumnAdapter) {
		final IColumnAdapter oldColumnAdapter = columnAdapter;
		columnAdapter = newColumnAdapter;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.COLUMN_BINDING__COLUMN_ADAPTER,
					oldColumnAdapter, columnAdapter));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IColumnBinding getBaseColumn() {
		return baseColumn;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetBaseColumn(IColumnBinding newBaseColumn, NotificationChain msgs) {
		final IColumnBinding oldBaseColumn = baseColumn;
		baseColumn = newBaseColumn;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.COLUMN_BINDING__BASE_COLUMN, oldBaseColumn, newBaseColumn);
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
	@Override
	public void setBaseColumn(IColumnBinding newBaseColumn) {
		if (newBaseColumn != baseColumn) {
			NotificationChain msgs = null;
			if (baseColumn != null) {
				msgs = ((InternalEObject) baseColumn).eInverseRemove(this,
						IUIBindingsPackage.COLUMN_BINDING__SUB_COLUMNS, IColumnBinding.class, msgs);
			}
			if (newBaseColumn != null) {
				msgs = ((InternalEObject) newBaseColumn).eInverseAdd(this,
						IUIBindingsPackage.COLUMN_BINDING__SUB_COLUMNS, IColumnBinding.class, msgs);
			}
			msgs = basicSetBaseColumn(newBaseColumn, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.COLUMN_BINDING__BASE_COLUMN,
					newBaseColumn, newBaseColumn));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IColumnBinding> getSubColumns() {
		if (subColumns == null) {
			subColumns = new EObjectWithInverseEList<IColumnBinding>(IColumnBinding.class, this,
					IUIBindingsPackage.COLUMN_BINDING__SUB_COLUMNS, IUIBindingsPackage.COLUMN_BINDING__BASE_COLUMN);
		}
		return subColumns;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<EObject, IColumnBindingCellInformation> getCells() {
		if (cells == null) {
			cells = new EcoreEMap<EObject, IColumnBindingCellInformation>(
					IUIBindingsPackage.Literals.OBJECT_TO_CI_MAP_ENTRY, ObjectToCIMapEntryImpl.class, this,
					IUIBindingsPackage.COLUMN_BINDING__CELLS);
		}
		return cells;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public SpecialBinding getSpecialBindingType() {
		return specialBindingType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setSpecialBindingType(SpecialBinding newSpecialBindingType) {
		final SpecialBinding oldSpecialBindingType = specialBindingType;
		specialBindingType = newSpecialBindingType == null ? SPECIAL_BINDING_TYPE_EDEFAULT : newSpecialBindingType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.COLUMN_BINDING__SPECIAL_BINDING_TYPE, oldSpecialBindingType, specialBindingType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IObservableFactory getFactory() {
		return factory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Cursor getCursor() {
		return cursor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setCursor(Cursor newCursor) {
		final Cursor oldCursor = cursor;
		cursor = newCursor;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.COLUMN_BINDING__CURSOR, oldCursor,
					cursor));
		}
	}

	protected int myOldWidth = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IObservableValue getColumnVisibility() {
		if (columnVisibility == null) {
			columnVisibility = new WritableValue(true, Boolean.class);
			columnVisibility.addValueChangeListener(new IValueChangeListener() {
				@Override
				public void handleValueChange(ValueChangeEvent event) {
					if (getState() != BindingState.OK) return;
					final boolean o = event.diff.getOldValue() == Boolean.TRUE;
					final boolean n = event.diff.getNewValue() == Boolean.TRUE;

					if (o == n) return;
					final IColumnAdapter adapter = getColumnAdapter();
					if (n) {
						adapter.setWidth(myOldWidth > 0 ? myOldWidth : 10);
						adapter.setMoveable(true);
						adapter.setResizable(true);
					} else {
						myOldWidth = adapter.getWidth();
						adapter.setWidth(0);
						adapter.setMoveable(false);
						adapter.setResizable(false);
					}
					/*
					 * The layout might have changed, so reflow the context.
					 */
					getContext().reflow();
				}
			});
		}
		return columnVisibility;
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
		case IUIBindingsPackage.COLUMN_BINDING__VIEWER_BINDING:
			if (viewerBinding != null) {
				msgs = ((InternalEObject) viewerBinding).eInverseRemove(this,
						IUIBindingsPackage.VIEWER_BINDING__COLUMNS, IViewerBinding.class, msgs);
			}
			return basicSetViewerBinding((IViewerBinding) otherEnd, msgs);
		case IUIBindingsPackage.COLUMN_BINDING__BASE_COLUMN:
			if (baseColumn != null) {
				msgs = ((InternalEObject) baseColumn).eInverseRemove(this,
						IUIBindingsPackage.COLUMN_BINDING__SUB_COLUMNS, IColumnBinding.class, msgs);
			}
			return basicSetBaseColumn((IColumnBinding) otherEnd, msgs);
		case IUIBindingsPackage.COLUMN_BINDING__SUB_COLUMNS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSubColumns()).basicAdd(otherEnd, msgs);
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
		case IUIBindingsPackage.COLUMN_BINDING__VIEWER_BINDING:
			return basicSetViewerBinding(null, msgs);
		case IUIBindingsPackage.COLUMN_BINDING__BASE_COLUMN:
			return basicSetBaseColumn(null, msgs);
		case IUIBindingsPackage.COLUMN_BINDING__SUB_COLUMNS:
			return ((InternalEList<?>) getSubColumns()).basicRemove(otherEnd, msgs);
		case IUIBindingsPackage.COLUMN_BINDING__CELLS:
			return ((InternalEList<?>) getCells()).basicRemove(otherEnd, msgs);
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
		case IUIBindingsPackage.COLUMN_BINDING__VIEWER_BINDING:
			return getViewerBinding();
		case IUIBindingsPackage.COLUMN_BINDING__VIEWER_COLUMN:
			return getViewerColumn();
		case IUIBindingsPackage.COLUMN_BINDING__COLUMN_ADAPTER:
			return getColumnAdapter();
		case IUIBindingsPackage.COLUMN_BINDING__BASE_COLUMN:
			return getBaseColumn();
		case IUIBindingsPackage.COLUMN_BINDING__SUB_COLUMNS:
			return getSubColumns();
		case IUIBindingsPackage.COLUMN_BINDING__CELLS:
			if (coreType)
				return getCells();
			else
				return getCells().map();
		case IUIBindingsPackage.COLUMN_BINDING__SPECIAL_BINDING_TYPE:
			return getSpecialBindingType();
		case IUIBindingsPackage.COLUMN_BINDING__FACTORY:
			return getFactory();
		case IUIBindingsPackage.COLUMN_BINDING__CURSOR:
			return getCursor();
		case IUIBindingsPackage.COLUMN_BINDING__COLUMN_VISIBILITY:
			return getColumnVisibility();
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
		case IUIBindingsPackage.COLUMN_BINDING__VIEWER_BINDING:
			setViewerBinding((IViewerBinding) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__VIEWER_COLUMN:
			setViewerColumn((ViewerColumn) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__COLUMN_ADAPTER:
			setColumnAdapter((IColumnAdapter) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__BASE_COLUMN:
			setBaseColumn((IColumnBinding) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__SUB_COLUMNS:
			getSubColumns().clear();
			getSubColumns().addAll((Collection<? extends IColumnBinding>) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__CELLS:
			((EStructuralFeature.Setting) getCells()).set(newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__SPECIAL_BINDING_TYPE:
			setSpecialBindingType((SpecialBinding) newValue);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__CURSOR:
			setCursor((Cursor) newValue);
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
		case IUIBindingsPackage.COLUMN_BINDING__VIEWER_BINDING:
			setViewerBinding((IViewerBinding) null);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__VIEWER_COLUMN:
			setViewerColumn(VIEWER_COLUMN_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__COLUMN_ADAPTER:
			setColumnAdapter((IColumnAdapter) null);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__BASE_COLUMN:
			setBaseColumn((IColumnBinding) null);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__SUB_COLUMNS:
			getSubColumns().clear();
			return;
		case IUIBindingsPackage.COLUMN_BINDING__CELLS:
			getCells().clear();
			return;
		case IUIBindingsPackage.COLUMN_BINDING__SPECIAL_BINDING_TYPE:
			setSpecialBindingType(SPECIAL_BINDING_TYPE_EDEFAULT);
			return;
		case IUIBindingsPackage.COLUMN_BINDING__CURSOR:
			setCursor(CURSOR_EDEFAULT);
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
		case IUIBindingsPackage.COLUMN_BINDING__VIEWER_BINDING:
			return viewerBinding != null;
		case IUIBindingsPackage.COLUMN_BINDING__VIEWER_COLUMN:
			return VIEWER_COLUMN_EDEFAULT == null ? viewerColumn != null : !VIEWER_COLUMN_EDEFAULT.equals(viewerColumn);
		case IUIBindingsPackage.COLUMN_BINDING__COLUMN_ADAPTER:
			return columnAdapter != null;
		case IUIBindingsPackage.COLUMN_BINDING__BASE_COLUMN:
			return baseColumn != null;
		case IUIBindingsPackage.COLUMN_BINDING__SUB_COLUMNS:
			return subColumns != null && !subColumns.isEmpty();
		case IUIBindingsPackage.COLUMN_BINDING__CELLS:
			return cells != null && !cells.isEmpty();
		case IUIBindingsPackage.COLUMN_BINDING__SPECIAL_BINDING_TYPE:
			return specialBindingType != SPECIAL_BINDING_TYPE_EDEFAULT;
		case IUIBindingsPackage.COLUMN_BINDING__FACTORY:
			return FACTORY_EDEFAULT == null ? factory != null : !FACTORY_EDEFAULT.equals(factory);
		case IUIBindingsPackage.COLUMN_BINDING__CURSOR:
			return CURSOR_EDEFAULT == null ? cursor != null : !CURSOR_EDEFAULT.equals(cursor);
		case IUIBindingsPackage.COLUMN_BINDING__COLUMN_VISIBILITY:
			return COLUMN_VISIBILITY_EDEFAULT == null ? columnVisibility != null : !COLUMN_VISIBILITY_EDEFAULT
					.equals(columnVisibility);
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
	public void fireLabelChanged(IColumnBindingCellInformation element) {
		myLabelProvider.fireChanged(element);
	}

	@Override
	public Control getControl() {
		return null;
	}

	@Override
	public Widget getWidget() {
		return null;
	}

	@Override
	public void updateSourceProviderState(ISourceProviderStateContext context) {
		LogUtils.error(this, "Called?");
		// For now this is empty'
		// Should probably contain some of the stuff from ViewerBindingImpl
	}

	@Override
	public Collection<EObject> getSelection() {
		return Collections.emptyList();
	}

	@Override
	public int getIndex(boolean visualModel) {
		final Widget columnItem = getColumnAdapter().getWidget();
		final IViewerBinding viewer = getViewerBinding();
		final Control c = viewer.getControl();

		/*
		 * Find the columns and the column order
		 */
		Widget[] columns = null;
		int[] columnOrder = null;
		if (c instanceof Table) {
			final Table t = (Table) c;
			columns = t.getColumns();
			if (visualModel) {
				columnOrder = t.getColumnOrder();
			}
		} else if (c instanceof Tree) {
			final Tree t = (Tree) c;
			columns = t.getColumns();
			if (visualModel) {
				columnOrder = t.getColumnOrder();
			}
		} else
			return -1;

		/*
		 * Search for the column
		 */
		int columnNo = 0;
		for (columnNo = 0; columnNo < columns.length; columnNo++) {
			if (columns[columnNo] == columnItem) {
				break;
			}
		}
		if (columnNo == columns.length) return -1;

		if (visualModel) {
			columnNo = columnOrder[columnNo];
		}

		return columnNo - viewer.getFirstTableColumnOffset();
	}
} // ColumnBindingImpl
