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
package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

/**
 * 
 */
public class ListObservableList extends MySWTObservableList {

	private final List list;

	/**
	 * @param list
	 */
	public ListObservableList(List list) {
		super(SWTObservables.getRealm(list.getDisplay()));
		this.list = list;

		init();
	}

	@Override
	protected void setItems(String[] newItems) {
		list.getDisplay().addFilter(SWT.Modify, myModifyFilter);
		final String[] text = list.getSelection();
		list.setItems(newItems);
		list.setSelection(text);
		list.getDisplay().removeFilter(SWT.Modify, myModifyFilter);
	}

	@Override
	protected String[] getItems() {
		return list.getItems();
	}

	private final Listener myModifyFilter = new Listener() {
		@Override
		public void handleEvent(Event event) {
			if (event.type == SWT.Modify) {
				event.type = SWT.None;
			}
		}
	};
}
