/*******************************************************************************
 * Copyright (c) 2007, 2011 The RCP Company and others.
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

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.WritableList;

/**
 * Abstract base class of CComboObservableList, ComboObservableList, and ListObservableList.
 * <p>
 * Special version that will conserve the current selection and try to cache the result as long as
 * possible to avoid too much interaction with the widget itself.
 */
public abstract class MySWTObservableList extends WritableList {
	/**
	 * Constructs and returns a new {@link IObservableList} for an SWT Widget.
	 * 
	 * @param realm the realm
	 */
	protected MySWTObservableList(Realm realm) {
		super(realm, new ArrayList<String>(), String.class);
	}

	protected void init() {
		/*
		 * Sync with background widget..
		 */
		for (final String s : getItems()) {
			add(s);
		}
	}

	/**
	 * Runnable used to write back changes to the widget...
	 */
	private Runnable myWriteBackRunnable = null;

	private boolean myWriteBackRunnableOutstanding = false;

	@Override
	protected void fireListChange(ListDiff diff) {
		if (!myWriteBackRunnableOutstanding) {
			if (myWriteBackRunnable == null) {
				myWriteBackRunnable = new Runnable() {
					@Override
					public void run() {
						if (isDisposed()) return;
						myWriteBackRunnableOutstanding = false;
						setItems((String[]) toArray(new String[size()]));
					}
				};
			}
			getRealm().asyncExec(myWriteBackRunnable);
			myWriteBackRunnableOutstanding = true;
		}

		super.fireListChange(diff);
	}

	/**
	 * @return the items
	 */
	protected abstract String[] getItems();

	/**
	 * @param newItems
	 */
	protected abstract void setItems(String[] newItems);

}
