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

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * Observable value that will return and monitor the index of an element in a list.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ListIndexObservableValue extends AbstractObservableValue {

	private final int myOffset;

	/**
	 * Constructs and returns a new observable value that will return and monitor the index of an
	 * element in a list.
	 * 
	 * @param list the list
	 * @param element the element
	 */
	public ListIndexObservableValue(IObservableList list, Object element) {
		this(list, element, 0);
	}

	/**
	 * Constructs and returns a new observable value that will return and monitor the index of an
	 * element in a list.
	 * 
	 * @param list the list
	 * @param element the element
	 * @param offset an offset of add to the index
	 */
	public ListIndexObservableValue(IObservableList list, Object element, int offset) {
		super(list.getRealm());
		myList = list;
		myElement = element;
		myOffset = offset;

		myIndex = calculateIndex();
	}

	private final IObservableList myList;
	private final Object myElement;

	/**
	 * The currently known index of the element
	 */
	protected int myIndex;
	private final IListChangeListener myListListener = new IListChangeListener() {
		@Override
		public void handleListChange(ListChangeEvent event) {
			/*
			 * Real ugly, but... the problem is that ChangeManager.fireEvent() holds on to the "old"
			 * list of listeners while firing events. So when changes are made to the list -
			 * especially some that invalidate the objects that are referenced - this leads to
			 * problem later...
			 */
			if (getRealm() == null) return;

			final int newIndex = calculateIndex();
			if (myIndex == newIndex) return;

			final ValueDiff diff = Diffs.createValueDiff(myIndex, newIndex);

			myIndex = newIndex;
			getRealm().exec(new Runnable() {
				@Override
				public void run() {
					fireValueChange(diff);
				}
			});
		}
	};

	@Override
	public synchronized void dispose() {
		if (hasListeners()) {
			lastListenerRemoved();
		}
		super.dispose();
	}

	@Override
	protected void firstListenerAdded() {
		super.firstListenerAdded();
		myList.addListChangeListener(myListListener);
	}

	@Override
	protected void lastListenerRemoved() {
		myList.removeListChangeListener(myListListener);
		super.lastListenerRemoved();
	}

	protected int calculateIndex() {
		return myList.indexOf(myElement) + myOffset;
	}

	@Override
	protected Object doGetValue() {
		return myIndex;
	}

	@Override
	public Object getValueType() {
		return EcorePackage.Literals.EINT;
	}
}
