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
package com.rcpcompany.uibindings.observables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.BindingException;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.ObservableTracker;
import org.eclipse.core.databinding.observable.list.AbstractObservableList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;

/**
 * {@link IObservableList} for {@link StyledText#setStyleRanges(StyleRange[])}.
 */
public class StyledTextRangesObservableList extends AbstractObservableList {

	private final StyledText myText;
	/**
	 * Cached version of the style ranges of {@link #myText}.
	 */
	private StyleRange[] myRanges;

	/**
	 * Constructs and returns a new obserable list for the specified {@link StyledText}.
	 * 
	 * @param styledText the StyledText of the list
	 */
	public StyledTextRangesObservableList(StyledText styledText) {
		super(SWTObservables.getRealm(styledText.getDisplay()));
		myText = styledText;
		myRanges = myText.getStyleRanges();
	}

	private void getterCalled() {
		ObservableTracker.getterCalled(this);
	}

	@Override
	protected int doGetSize() {
		return myRanges.length;
	}

	@Override
	public Object get(int index) {
		getterCalled();
		return myRanges[index];
	}

	@Override
	public Object set(int index, Object element) {
		final StyleRange old = myRanges[index];
		myRanges[index] = (StyleRange) element;
		myText.setStyleRanges(myRanges);

		return old;
	}

	private void setStyleRanges(StyleRange[] newItems) {
		myRanges = newItems;
		myText.setStyleRanges(myRanges);
	}

	@Override
	public void add(int index, Object element) {
		final int size = doGetSize();
		if (index < 0 || index > size) {
			index = size;
		}
		final StyleRange[] newRanges = new StyleRange[size + 1];
		System.arraycopy(myRanges, 0, newRanges, 0, index);
		newRanges[index] = (StyleRange) element;
		System.arraycopy(myRanges, index, newRanges, index + 1, size - index);

		setStyleRanges(newRanges);
		fireListChange(Diffs.createListDiff(Diffs.createListDiffEntry(index, true, element)));
	}

	@Override
	public Object remove(int index) {
		getterCalled();
		final int size = doGetSize();
		if (index < 0 || index > size - 1)
			throw new BindingException("Request to remove an element out of the collection bounds"); //$NON-NLS-1$

		final StyleRange[] newItems = new StyleRange[size - 1];
		final StyleRange oldElement = myRanges[index];
		if (newItems.length > 0) {
			System.arraycopy(myRanges, 0, newItems, 0, index);
			if (size - 1 > index) {
				System.arraycopy(myRanges, index + 1, newItems, index, size - index - 1);
			}
		}
		setStyleRanges(newItems);
		fireListChange(Diffs.createListDiff(Diffs.createListDiffEntry(index, false, oldElement)));
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

		final StyleRange[] items = myRanges;
		final StyleRange[] newItems = new StyleRange[size];
		final StyleRange element = items[oldIndex];
		if (newItems.length > 0) {
			System.arraycopy(items, 0, newItems, 0, size);
			if (oldIndex < newIndex) {
				System.arraycopy(items, oldIndex + 1, newItems, oldIndex, newIndex - oldIndex);
			} else {
				System.arraycopy(items, newIndex, newItems, newIndex + 1, oldIndex - newIndex);
			}
			newItems[newIndex] = element;
		}
		setStyleRanges(newItems);
		fireListChange(Diffs.createListDiff(Diffs.createListDiffEntry(oldIndex, false, element),
				Diffs.createListDiffEntry(newIndex, true, element)));
		return element;
	}

	@Override
	public boolean removeAll(Collection c) {
		checkRealm();
		final List<StyleRange> oldItems = Arrays.asList(myRanges);
		final List<StyleRange> newItems = new ArrayList<StyleRange>(oldItems);
		final boolean removedAll = newItems.removeAll(c);
		if (removedAll) {
			setStyleRanges(newItems.toArray(new StyleRange[newItems.size()]));
			fireListChange(Diffs.computeListDiff(oldItems, newItems));
		}
		return removedAll;
	}

	@Override
	public boolean retainAll(Collection c) {
		checkRealm();
		final List<StyleRange> oldItems = Arrays.asList(myRanges);
		final List<StyleRange> newItems = new ArrayList<StyleRange>(oldItems);
		final boolean retainedAll = newItems.retainAll(c);
		if (retainedAll) {
			setStyleRanges(newItems.toArray(new StyleRange[newItems.size()]));
			fireListChange(Diffs.computeListDiff(oldItems, newItems));
		}
		return retainedAll;
	}

	@Override
	public Object getElementType() {
		return StyleRange.class;
	}
}
