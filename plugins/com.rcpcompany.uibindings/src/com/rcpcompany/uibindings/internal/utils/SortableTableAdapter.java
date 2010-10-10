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

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.IManagerRunnable;
import com.rcpcompany.uibindings.utils.ISortableTableAdapter;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * The implementation of {@link ISortableTableAdapter}.
 * 
 * TODO: SWTB
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SortableTableAdapter implements ISortableTableAdapter, DisposeListener, SelectionListener {

	/**
	 * Constructs and initializes a new sorter...
	 * 
	 * 
	 * @param viewer the binding
	 */
	public SortableTableAdapter(IViewerBinding viewer) {
		myViewerBinding = viewer;
		Assert.isLegal(myViewerBinding.getViewer() instanceof TableViewer, "The column sorter only accepts tables");
		myTableViewer = (TableViewer) myViewerBinding.getViewer();
		myTable = myTableViewer.getTable();

		init();
	}

	/**
	 * initializes this adapter.
	 * <p>
	 * If the binding is not in state OK, then wait...
	 */
	protected void init() {
		if (myViewerBinding.getState() != BindingState.OK) {
			/*
			 * If not in state OK, then wait until we get there...
			 */
			final AdapterImpl l = new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (msg.isTouch()) return;
					if (msg.getFeature() != IUIBindingsPackage.Literals.BINDING__STATE) return;
					switch (myViewerBinding.getState()) {
					case OK:
						init();
						//$FALL-THROUGH$ fallthrough
					case DISPOSED:
						myViewerBinding.eAdapters().remove(this);
						break;
					default:
						break;
					}
				}
			};
			myViewerBinding.eAdapters().add(l);
			return;
		}
		myViewerBinding.registerService(this);
		myTable.addDisposeListener(this);
		for (final IColumnBinding cb : myViewerBinding.getColumns()) {
			addColumn(cb);
		}
		myViewerBinding.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.isTouch()) return;
				if (msg.getFeature() != IUIBindingsPackage.Literals.VIEWER_BINDING__COLUMNS) return;

				switch (msg.getEventType()) {
				case Notification.REMOVE:
				case Notification.SET:
					addColumn((IColumnBinding) msg.getOldValue());
					break;
				}

				switch (msg.getEventType()) {
				case Notification.ADD:
				case Notification.SET:
					removeColumn((IColumnBinding) msg.getNewValue());
					break;
				}
			}
		});

		myViewerBinding.getElements().addSetChangeListener(myViewerSetListener);
	}

	/**
	 * Removes the sorting functionality again.
	 */
	@Override
	public void dispose() {
		myViewerBinding.unregisterService(this);
		if (myTable.isDisposed()) return;
		/*
		 * If the viewer binding is not being disposed, then remove the comparator
		 */
		if (!myViewerBinding.isDisposed()) {
			myTableViewer.setComparator(null);
		}
		myTable.removeDisposeListener(this);
		for (final IColumnBinding cb : myViewerBinding.getColumns()) {
			removeColumn(cb);
		}
	}

	protected void addColumn(final IColumnBinding cb) {
		cb.getColumnAdapter().addSelectionListener(this);
	}

	protected void removeColumn(final IColumnBinding cb) {
		cb.getColumnAdapter().removeSelectionListener(this);
	}

	/**
	 * The binding for the viewer
	 * 
	 * TODO make this an interface
	 */
	protected final IViewerBinding myViewerBinding;

	/**
	 * The table viewer
	 */
	protected final TableViewer myTableViewer;

	/**
	 * The raw SWT table
	 */
	protected final Table myTable;

	/**
	 * Monitor of the viewer list.
	 */
	private final ISetChangeListener myViewerSetListener = new ISetChangeListener() {
		@Override
		public void handleSetChange(SetChangeEvent event) {
			refreshViewer();
		}
	};

	/**
	 * The sorter for the table
	 */
	protected ViewerComparator myViewerComparator = new ViewerComparator() {
		@Override
		public void sort(Viewer viewer, Object[] elements) {
			final TableColumn sortColumn = myTable.getSortColumn();
			if (Activator.getDefault().TRACE_SORTING) {
				LogUtils.debug(this, ">> " + Arrays.toString(elements) + "\ncolumn=" + sortColumn);
			}
			if (sortColumn == null) return;
			final int dir = myTable.getSortDirection() == SWT.UP ? 1 : -1;

			final IColumnBinding column = (IColumnBinding) IBindingContext.Factory.getBindingForWidget(sortColumn);
			if (column == null) {
				LogUtils.error(SortableTableAdapter.this, "Cannot find Binding from TableColumn");
				return;
			}

			// Map all the strings to strings, so it is easier to sort them
			final Map<Object, Object> values = new HashMap<Object, Object>();
			Comparator<Object> comparator = null;

			final Class<?> columnType = column.getDataType().getDataType();
			if (columnType == Byte.TYPE) {
				for (final Object o : elements) {
					values.put(o, column.getValue(o).getValue());
				}
				comparator = new Comparator<Object>() {
					@Override
					public int compare(Object o1, Object o2) {
						final Byte s1 = (Byte) values.get(o1);
						final Byte s2 = (Byte) values.get(o2);
						if (s1 == null || s2 == null) return 0;
						return dir * (s2 - s1);
					}
				};
			} else if (columnType == Short.TYPE) {
				for (final Object o : elements) {
					values.put(o, column.getValue(o).getValue());
				}
				comparator = new Comparator<Object>() {
					@Override
					public int compare(Object o1, Object o2) {
						final Short s1 = (Short) values.get(o1);
						final Short s2 = (Short) values.get(o2);
						if (s1 == null || s2 == null) return 0;
						return dir * (s2 - s1);
					}
				};
			} else if (columnType == Integer.TYPE) {
				for (final Object o : elements) {
					values.put(o, column.getValue(o).getValue());
				}
				comparator = new Comparator<Object>() {
					@Override
					public int compare(Object o1, Object o2) {
						final Integer s1 = (Integer) values.get(o1);
						final Integer s2 = (Integer) values.get(o2);
						if (s1 == null || s2 == null) return 0;
						return dir * (s2 - s1);
					}
				};
			} else if (columnType == Long.TYPE) {
				for (final Object o : elements) {
					values.put(o, column.getValue(o).getValue());
				}
				comparator = new Comparator<Object>() {
					@Override
					public int compare(Object o1, Object o2) {
						final Long s1 = (Long) values.get(o1);
						final Long s2 = (Long) values.get(o2);
						if (s1 == null || s2 == null) return 0;
						final long d = s2 - s1;
						if (d == 0) return 0;
						return dir * (d < 0 ? 1 : -1);
					}
				};
			} else if (columnType == Float.TYPE) {
				for (final Object o : elements) {
					values.put(o, column.getValue(o).getValue());
				}
				comparator = new Comparator<Object>() {
					@Override
					public int compare(Object o1, Object o2) {
						final Float s1 = (Float) values.get(o1);
						final Float s2 = (Float) values.get(o2);
						if (s1 == null || s2 == null) return 0;
						final float d = s2 - s1;
						if (d == 0) return 0;
						return dir * (d < 0 ? 1 : -1);
					}
				};
			} else if (columnType == Double.TYPE) {
				for (final Object o : elements) {
					values.put(o, column.getValue(o).getValue());
				}
				comparator = new Comparator<Object>() {
					@Override
					public int compare(Object o1, Object o2) {
						final Double s1 = (Double) values.get(o1);
						final Double s2 = (Double) values.get(o2);
						if (s1 == null || s2 == null) return 0;
						final Double d = s2 - s1;
						if (d == 0) return 0;
						return dir * (d < 0 ? 1 : -1);
					}
				};
			} else {
				for (final Object o : elements) {
					values.put(o, column.getDisplayText(o));
				}
				comparator = new Comparator<Object>() {
					@Override
					public int compare(Object o1, Object o2) {
						final String s1 = (String) values.get(o1);
						final String s2 = (String) values.get(o2);
						if (s1 == null || s2 == null) return 0;
						return dir * s1.compareToIgnoreCase(s2);
					}
				};
			}

			// Sort them
			if (comparator != null) {
				Arrays.sort(elements, comparator);
			}
			if (Activator.getDefault().TRACE_SORTING) {
				LogUtils.debug(this, "<< " + Arrays.toString(elements));
			}
		}
	};

	@Override
	public void widgetDisposed(DisposeEvent e) {
		dispose();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO: change to mouse event or access state

		// determine new sort column and direction
		final TableColumn sortColumn = myTable.getSortColumn();
		TableColumn clickColumn = (TableColumn) e.widget;
		int dir = myTable.getSortDirection();
		if (Activator.getDefault().TRACE_SORTING) {
			LogUtils.debug(this, ">> clickColumn: " + clickColumn + ", sortColumn: " + sortColumn + ", dir: " + dir);
		}

		if (sortColumn == clickColumn) {
			switch (dir) {
			case SWT.UP:
				dir = SWT.DOWN;
				break;
			case SWT.DOWN:
				dir = SWT.NONE;
				clickColumn = null;
				break;
			}
		} else {
			dir = SWT.UP;
		}
		if (Activator.getDefault().TRACE_SORTING) {
			LogUtils.debug(this, "<< new sortColumn: " + clickColumn + ", dir: " + dir);
		}
		myTable.setSortColumn(clickColumn);
		myTable.setSortDirection(dir);
		if (clickColumn != null) {
			if (sortColumn == null) {
				/*
				 * Just started to sort, so we set the comparator - this will implicitly refresh
				 */
				myTableViewer.setComparator(myViewerComparator);
			} else {
				/*
				 * Otherwise refresh
				 */
				myTableViewer.refresh();
			}
		} else {
			myTableViewer.setComparator(null);
		}
	}

	/**
	 * Refreshes the viewer if needed.
	 */
	public void refreshViewer() {
		if (myTableViewer.getComparator() != null) {
			/*
			 * Have to wait with the update as we otherwise end up adding the same element to the
			 * viewer twice..
			 */
			IManagerRunnable.Factory.asyncExec("refresh", myTableViewer, new Runnable() {
				@Override
				public void run() {
					if (!myTableViewer.getTable().isDisposed()) {
						myTableViewer.refresh();
					}
				}
			});
		}
	}
}
