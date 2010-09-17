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
package com.rcpcompany.uibindings.internal.observables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.BindingException;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.ObservableTracker;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.AbstractObservableList;

/**
 * Abstract base class of CComboObservableList, ComboObservableList, and ListObservableList.
 * <p>
 * Special version that will conserve the current selection
 */
public abstract class MySWTObservableList extends AbstractObservableList {

	/**
	 * 
	 */
	public MySWTObservableList() {
		super();
	}

	/**
	 * @param realm
	 */
	public MySWTObservableList(Realm realm) {
		super(realm);
	}

	@Override
	public void add(int index, Object element) {
		final int size = doGetSize();
		if (index < 0 || index > size) {
			index = size;
		}
		final String[] newItems = new String[size + 1];
		System.arraycopy(getItems(), 0, newItems, 0, index);
		newItems[index] = (String) element;
		System.arraycopy(getItems(), index, newItems, index + 1, size - index);
		setItems(newItems);
		fireListChange(Diffs.createListDiff(Diffs.createListDiffEntry(index, true, element)));
	}

	@Override
	public int doGetSize() {
		return getItemCount();
	}

	@Override
	public Object get(int index) {
		getterCalled();
		return getItem(index);
	}

	@Override
	public Object getElementType() {
		return String.class;
	}

	/**
	 * @param index
	 * @return the item at the given index
	 */
	protected abstract String getItem(int index);

	/**
	 * @return the item count
	 */
	protected abstract int getItemCount();

	/**
	 * @return the items
	 */
	protected abstract String[] getItems();

	private void getterCalled() {
		ObservableTracker.getterCalled(this);
	}

	@Override
	public Object remove(int index) {
		getterCalled();
		final int size = doGetSize();
		if (index < 0 || index > size - 1)
			throw new BindingException("Request to remove an element out of the collection bounds"); //$NON-NLS-1$

		final String[] newItems = new String[size - 1];
		final String oldElement = getItem(index);
		if (newItems.length > 0) {
			System.arraycopy(getItems(), 0, newItems, 0, index);
			if (size - 1 > index) {
				System.arraycopy(getItems(), index + 1, newItems, index, size - index - 1);
			}
		}
		setItems(newItems);
		fireListChange(Diffs.createListDiff(Diffs.createListDiffEntry(index, false, oldElement)));
		return oldElement;
	}

	@Override
	public Object set(int index, Object element) {
		final String oldElement = getItem(index);
		setItem(index, (String) element);
		fireListChange(Diffs.createListDiff(Diffs.createListDiffEntry(index, false, oldElement),
				Diffs.createListDiffEntry(index, true, element)));
		return oldElement;
	}

	@Override
	public Object move(int oldIndex, int newIndex) {
		checkRealm();
		if (oldIndex == newIndex) return get(oldIndex);
		final int size = doGetSize();
		if (oldIndex < 0 || oldIndex >= size)
			throw new IndexOutOfBoundsException("oldIndex: " + oldIndex + ", size:" + size); //$NON-NLS-1$ //$NON-NLS-2$
		if (newIndex < 0 || newIndex >= size)
			throw new IndexOutOfBoundsException("newIndex: " + newIndex + ", size:" + size); //$NON-NLS-1$ //$NON-NLS-2$

		final String[] items = getItems();
		final String[] newItems = new String[size];
		final String element = items[oldIndex];
		if (newItems.length > 0) {
			System.arraycopy(items, 0, newItems, 0, size);
			if (oldIndex < newIndex) {
				System.arraycopy(items, oldIndex + 1, newItems, oldIndex, newIndex - oldIndex);
			} else {
				System.arraycopy(items, newIndex, newItems, newIndex + 1, oldIndex - newIndex);
			}
			newItems[newIndex] = element;
		}
		setItems(newItems);
		fireListChange(Diffs.createListDiff(Diffs.createListDiffEntry(oldIndex, false, element),
				Diffs.createListDiffEntry(newIndex, true, element)));
		return element;
	}

	@Override
	public boolean removeAll(Collection c) {
		checkRealm();
		final List oldItems = Arrays.asList(getItems());
		final List newItems = new ArrayList(oldItems);
		final boolean removedAll = newItems.removeAll(c);
		if (removedAll) {
			setItems((String[]) newItems.toArray(new String[newItems.size()]));
			fireListChange(Diffs.computeListDiff(oldItems, newItems));
		}
		return removedAll;
	}

	@Override
	public boolean retainAll(Collection c) {
		checkRealm();
		final List oldItems = Arrays.asList(getItems());
		final List newItems = new ArrayList(oldItems);
		final boolean retainedAll = newItems.retainAll(c);
		if (retainedAll) {
			setItems((String[]) newItems.toArray(new String[newItems.size()]));
			fireListChange(Diffs.computeListDiff(oldItems, newItems));
		}
		return retainedAll;
	}

	/**
	 * @param index
	 * @param string
	 */
	protected abstract void setItem(int index, String string);

	/**
	 * @param newItems
	 */
	protected abstract void setItems(String[] newItems);

}
