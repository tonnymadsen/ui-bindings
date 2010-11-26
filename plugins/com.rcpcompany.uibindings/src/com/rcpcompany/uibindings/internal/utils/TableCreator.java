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
package com.rcpcompany.uibindings.internal.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnAdapter;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.observables.EListKeyedElementObservableValue;
import com.rcpcompany.uibindings.utils.IBindingSpec;
import com.rcpcompany.uibindings.utils.IBindingSpec.BaseType;
import com.rcpcompany.uibindings.utils.IFilteringTableAdapter;
import com.rcpcompany.uibindings.utils.ISortableTableAdapter;
import com.rcpcompany.uibindings.utils.ITableCreator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of {@link ITableCreator}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class TableCreator implements ITableCreator {
	/**
	 * The context used for the bindings.
	 */
	protected final IBindingContext myContext;

	/**
	 * The created table.
	 */
	protected final Table myTable;

	/**
	 * The viewer binding used for the table.
	 */
	protected final IViewerBinding myViewerBinding;

	/**
	 * A filter Text field if wanted.
	 */
	protected Text myFilter = null;

	/**
	 * The table layout used - controlled by the {@link ITableCreator#RESIZE} style.
	 */
	protected MyTableColumnLayout myTableLayout = null;

	/**
	 * Constructs and returns a new table creator.
	 * <p>
	 * Use the style {@link ITableCreator#FILTER} to add a filter box on top of the table.
	 * <p>
	 * The following styles are passed to the
	 * 
	 * @param context the context
	 * @param parent the parent composite of the new table - expected to have a {@link FillLayout}
	 * @param style the style for the new table
	 */
	public TableCreator(IBindingContext context, Composite parent, int style) {
		final IManager manager = IManager.Factory.getManager();

		Composite p = parent;

		// TODO TEST
		if ((style & (SWT.V_SCROLL | SWT.H_SCROLL)) == 0) {
			style |= SWT.NO_SCROLL;
		}

		if ((style & ITableCreator.FILTER) == ITableCreator.FILTER) {
			style &= ~ITableCreator.FILTER;
			p = manager.getFormToolkit().createComposite(p);
			final GridLayout l = new GridLayout();
			l.marginHeight = 0;
			l.marginWidth = 0;
			p.setLayout(l);
			myFilter = IFilteringTableAdapter.Factory.createFilter(p);
		}

		if ((style & ITableCreator.RESIZE) == ITableCreator.RESIZE) {
			style &= ~ITableCreator.RESIZE;
			// p = manager.getFormToolkit().createComposite(p);
			// myTableLayout = new MyTableColumnLayout();
			// p.setLayout(myTableLayout);
			// if (myFilter != null) {
			// p.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			// }
		}

		myTable = manager.getFormToolkit().createTable(p, style | SWT.FULL_SELECTION);
		if (p != parent) {
			myTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		}
		myContext = context;
		myTable.setLinesVisible(true);
		myTable.setHeaderVisible(true);

		myViewerBinding = myContext.addViewer().viewer(myTable);
		ISortableTableAdapter.Factory.adapt(getBinding());
		if (myFilter != null) {
			IFilteringTableAdapter.Factory.adapt(getBinding(), myFilter);
		}
	}

	@Override
	public void setFocus() {
		(myFilter != null ? myFilter : myTable).setFocus();
	}

	@Override
	public void dispose() {
	}

	@Override
	public IViewerBinding setContent(IObservableList list) {
		// TODO check type
		// if (list.getElementType() instanceof EClass)
		return myViewerBinding.model(list);
	}

	@Override
	public IViewerBinding setContent(EObject object, EReference reference) {
		return myViewerBinding.model(object, reference);
	}

	@Override
	public IViewerBinding setContent(IObservableValue object, EReference reference) {
		return myViewerBinding.model(object, reference);
	}

	@Override
	public Table getTable() {
		return myTable;
	}

	@Override
	public IViewerBinding getBinding() {
		return myViewerBinding;
	}

	@Override
	public IColumnBinding addColumn(EStructuralFeature feature, int width) {
		Assert.isNotNull(myViewerBinding);
		final TableColumn column = createColumn(width, SWT.NONE);
		return myViewerBinding.addColumn(column, feature);
	}

	@Override
	public IColumnBinding addColumn(SpecialBinding columnType, int width) {
		Assert.isNotNull(myViewerBinding);
		final TableColumn column = createColumn(width, SWT.RIGHT);
		return myViewerBinding.addColumn().column(column).model(columnType);
	}

	@Override
	public IColumnBinding addColumn(IColumnBinding baseColumn, EStructuralFeature feature, int width) {
		Assert.isNotNull(myViewerBinding);
		final TableColumn column = createColumn(width, SWT.NONE);
		return myViewerBinding.addColumn().column(column).model(baseColumn, feature);
	}

	@Override
	public IColumnBinding addColumn(String spec) {
		final List<IBindingSpec> bspecs = IBindingSpec.Factory.parseSingleSpec(
				(EClass) myViewerBinding.getModelEType(), spec);
		/*
		 * Construct a list of all top-level columns
		 */
		IColumnBinding parentColumn = null;
		List<IColumnBinding> subColumns = new ArrayList<IColumnBinding>(myViewerBinding.getColumns());
		for (final IColumnBinding c : subColumns.toArray(new IColumnBinding[subColumns.size()])) {
			if (c.getBaseColumn() != null) {
				subColumns.remove(c);
			}
		}

		for (final IBindingSpec s : bspecs) {
			/*
			 * Firste create the new column
			 */
			IColumnBinding foundColumn = null;
			final EStructuralFeature feature;
			switch (s.getType()) {
			case NONE:
				final TableColumn column = createColumn(0, SWT.NONE);
				foundColumn = myViewerBinding.addColumn().column(column);
				break;
			case ROW_NO:
				foundColumn = addColumn(SpecialBinding.ROW_NO, 0);
				foundColumn.getColumnAdapter().setAlignment(SWT.RIGHT);
				break;
			case ROW_ELEMENT:
				foundColumn = addColumn(SpecialBinding.ROW_ELEMENT, 0);
				break;
			case FEATURE:
				/*
				 * See if a column already exists for the feature
				 */
				feature = s.getFeature();
				for (final IColumnBinding c : subColumns) {
					if (feature == c.getDataType().getValueType()) {
						foundColumn = c;
						break;
					}
				}
				if (foundColumn == null) {
					if (parentColumn == null) {
						foundColumn = addColumn(feature, 0);
					} else {
						foundColumn = addColumn(parentColumn, feature, 0);
					}
					foundColumn.getColumnAdapter().setResizable(false);
					final int alignment = UIBindingsUtils.defaultAlignment(foundColumn.getDataType().getValueType());
					if (alignment != SWT.NONE) {
						foundColumn.getColumnAdapter().setAlignment(alignment);
					}
				}
				break;
			case KEY_VALUE:
				/*
				 * TODO See if a column already exists for the feature
				 */
				feature = s.getFeature();
				// for (final IColumnBinding c : subColumns) {
				// if (feature == c.getDataType().getValueType()) {
				// foundColumn = c;
				// break;
				// }
				// }
				if (foundColumn == null) {
					final IObservableFactory factory = new IObservableFactory() {
						@Override
						public IObservable createObservable(Object target) {
							return new EListKeyedElementObservableValue<EObject>(getBinding().getContext()
									.getEditingDomain(), (EObject) target, (EReference) feature, s.getKeyFeature(),
									s.getKeyValue(), s.getValueFeature());
						}
					};
					Assert.isNotNull(myViewerBinding);
					final TableColumn newColumn = createColumn(0, SWT.RIGHT);
					if (parentColumn == null) {
						foundColumn = myViewerBinding.addColumn().column(newColumn).model(factory, s.getValueFeature());
					} else {
						foundColumn = myViewerBinding.addColumn().column(newColumn)
								.model(parentColumn, factory, s.getValueFeature());
					}
					foundColumn.getColumnAdapter().setResizable(false);
					final int alignment = UIBindingsUtils.defaultAlignment(foundColumn.getDataType().getValueType());
					if (alignment != SWT.NONE) {
						foundColumn.getColumnAdapter().setAlignment(alignment);
					}
				}
				break;
			default:
				LogUtils.error(this, "Unknown special binding: " + s.getType());
				continue;
			}
			final IColumnAdapter adapter = foundColumn.getColumnAdapter();

			/*
			 * Then apply any arguments
			 */
			final Map<String, Object> arguments = s.getArguments();
			for (final Entry<String, Object> entry : arguments.entrySet()) {
				if (Constants.ARG_WIDTH.equals(entry.getKey())) {
					adapter.setResizable(true);
					final Integer width = (Integer) entry.getValue();
					adapter.setWidth(width);
					if (myTableLayout != null) {
						Integer wwi = (Integer) arguments.get(IBindingSpec.WIDTH_WEIGHT);
						if (wwi == null) {
							wwi = s.getType() == BaseType.ROW_NO ? 0 : 100;
						}
						myTableLayout.setColumnData(adapter.getWidget(), new ColumnWeightData(wwi, width, true));
					}
				} else if (Constants.ARG_ALIGNMENT.equals(entry.getKey())) {
					final String a = (String) entry.getValue();
					if ("l".equals(a)) {
						adapter.setAlignment(SWT.LEAD);
					} else if ("c".equals(a)) {
						adapter.setAlignment(SWT.CENTER);
					} else if ("r".equals(a)) {
						adapter.setAlignment(SWT.TRAIL);
					} else {
						LogUtils.throwException(this, "Alignment must be one of 'l', 'c' or 'r', got '" + a + "'", null);
					}
				} else {
					foundColumn.arg(entry.getKey(), entry.getValue());
				}
			}
			parentColumn = foundColumn;
			subColumns = parentColumn.getSubColumns();
		}
		return parentColumn;
	}

	/**
	 * Creates a new table column...
	 * 
	 * @param width the width
	 * @param style the style
	 * @return the new column
	 */
	private TableColumn createColumn(int width, int style) {
		final TableColumn column = new TableColumn(myTable, style);
		column.setWidth(width);
		column.setMoveable(true);
		if (myTableLayout != null) {
			if (width == 0) {
				myTableLayout.setColumnData(column, new ColumnPixelData(0));
			} else {
				myTableLayout.setColumnData(column, new ColumnWeightData(100, width, true));
			}

		}
		return column;
	}
}
