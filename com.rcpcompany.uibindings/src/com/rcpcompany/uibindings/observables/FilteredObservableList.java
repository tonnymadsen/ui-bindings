/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.observables;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.emf.ecore.EClass;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * A {@link IndexObservableList} that filters the entries of another {@link IObservableList} based
 * on a filter.
 * <p>
 * If the filter changes, it must call #updateList()
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FilteredObservableList extends ObservableList {
	/**
	 * The interface for a filter.
	 */
	public interface IFilter {
		/**
		 * Returns whether the specified element is included in the list.
		 * 
		 * @param element the element to test
		 * @return <code>true</code> if the element is included
		 */
		boolean isIncluded(Object element);
	}

	private final IObservableList myMasterList;
	private final IFilter myFilter;
	private IListChangeListener myListChangeListener = null;

	/**
	 * Constructs and returns a new list for the specified master list and filter.
	 * 
	 * @param masterList the master list
	 * @param filter the filter
	 */
	public FilteredObservableList(IObservableList masterList, IFilter filter) {
		this(masterList, filter, masterList.getElementType());
	}

	/**
	 * Constructs and returns a new list for the specified master list and filter.
	 * 
	 * @param masterList the master list
	 * @param filter the filter
	 */
	public FilteredObservableList(IObservableList masterList, IFilter filter, Object elementType) {
		super(masterList.getRealm(), new ArrayList<Object>(), elementType);
		myMasterList = masterList;
		myFilter = filter;

		updateList();
	}

	/**
	 * Constructs and returns a new list for the specified master list that will include only
	 * elements of the specified class or sub-classes.
	 * 
	 * @param masterList the master list
	 * @param cls the class of the included elements
	 */
	public FilteredObservableList(IObservableList masterList, final EClass cls) {
		this(masterList, new IFilter() {
			@Override
			public boolean isIncluded(Object element) {
				return cls.getInstanceClass().isInstance(element);
			}
		}, cls);
	}

	/**
	 * Constructs and returns a new list for the specified master list that will include only
	 * elements of the specified class or sub-classes.
	 * 
	 * @param masterList the master list
	 * @param cls the class of the included elements
	 */
	public FilteredObservableList(IObservableList masterList, final Class<?> cls) {
		this(masterList, new IFilter() {
			@Override
			public boolean isIncluded(Object element) {
				return cls.isInstance(element);
			}
		});
	}

	public void updateList() {
		final List<Object> newList = new ArrayList<Object>();
		for (final Object o : myMasterList) {
			try {
				if (myFilter.isIncluded(o)) {
					newList.add(o);
				}
			} catch (final Exception ex) {
				LogUtils.error(myFilter, "Filter throws exception. Element ignored.", ex);
			}
		}

		updateWrappedList(newList);
	}

	@Override
	protected void firstListenerAdded() {
		myListChangeListener = new IListChangeListener() {
			@Override
			public void handleListChange(ListChangeEvent event) {
				updateList();
			}
		};
		myMasterList.addListChangeListener(myListChangeListener);
	}

	@Override
	protected void lastListenerRemoved() {
		myMasterList.removeListChangeListener(myListChangeListener);
	}
}
