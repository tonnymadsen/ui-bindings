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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * 
 */
public class ComboObservableList extends MySWTObservableList {

	private final Combo combo;

	/**
	 * Constructs and returns a new obserable list for the specified combo.
	 * 
	 * @param combo the combo of the list
	 */
	public ComboObservableList(Combo combo) {
		super(SWTObservables.getRealm(combo.getDisplay()));
		this.combo = combo;
	}

	@Override
	protected int getItemCount() {
		return combo.getItemCount();
	}

	@Override
	protected void setItems(String[] newItems) {
		try {
			combo.getDisplay().addFilter(SWT.Modify, myModifyFilter);
			final String text = combo.getText();
			combo.setItems(newItems);
			combo.setText(text);
		} catch (final Exception ex) {
			LogUtils.error(this, ex);
		} finally {
			combo.getDisplay().removeFilter(SWT.Modify, myModifyFilter);
		}
	}

	@Override
	protected String[] getItems() {
		return combo.getItems();
	}

	@Override
	protected String getItem(int index) {
		return combo.getItem(index);
	}

	@Override
	protected void setItem(int index, String string) {
		try {
			combo.getDisplay().addFilter(SWT.Modify, myModifyFilter);
			final String text = combo.getText();
			combo.setItem(index, string);
			combo.setText(text);
		} catch (final Exception ex) {
			LogUtils.error(this, ex);
		} finally {
			combo.getDisplay().removeFilter(SWT.Modify, myModifyFilter);
		}
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
