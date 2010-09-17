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

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * 
 */
public class CComboObservableList extends MySWTObservableList {

	private final CCombo ccombo;

	/**
	 * Constructs and returns a new obserable list for the specified combo.
	 * 
	 * @param ccombo the combo of the list
	 */
	public CComboObservableList(CCombo ccombo) {
		super(SWTObservables.getRealm(ccombo.getDisplay()));
		this.ccombo = ccombo;
	}

	@Override
	protected int getItemCount() {
		return ccombo.getItemCount();
	}

	@Override
	protected void setItems(String[] newItems) {
		ccombo.getDisplay().addFilter(SWT.Modify, myModifyFilter);
		final String text = ccombo.getText();
		ccombo.setItems(newItems);
		ccombo.setText(text);
		ccombo.getDisplay().removeFilter(SWT.Modify, myModifyFilter);
	}

	@Override
	protected String[] getItems() {
		return ccombo.getItems();
	}

	@Override
	protected String getItem(int index) {
		return ccombo.getItem(index);
	}

	@Override
	protected void setItem(int index, String string) {
		ccombo.getDisplay().addFilter(SWT.Modify, myModifyFilter);
		final String text = ccombo.getText();
		ccombo.setItem(index, string);
		ccombo.setText(text);
		ccombo.getDisplay().removeFilter(SWT.Modify, myModifyFilter);
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
