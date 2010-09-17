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

import org.eclipse.core.databinding.observable.list.AbstractObservableList;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.nebula.widgets.radiogroup.RadioGroup;
import org.eclipse.nebula.widgets.radiogroup.RadioItem;
import org.eclipse.swt.SWT;

/**
 * {@link IObservableList} for the items in a {@link RadioGroup}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class RadioGroupObservableList extends AbstractObservableList {

	private final RadioGroup myRadioGroup;

	/**
	 * Constructs and returns a new obserable list for the specified radio group.
	 * 
	 * @param rg the radio group of the list
	 */
	public RadioGroupObservableList(RadioGroup rg) {
		super(SWTObservables.getRealm(rg.getDisplay()));
		this.myRadioGroup = rg;
	}

	@Override
	protected int doGetSize() {
		return myRadioGroup.getItemCount();
	}

	@Override
	public Object get(int index) {
		return myRadioGroup.getItems()[index].getText();
	}

	@Override
	public void add(int index, Object element) {
		final RadioItem item = new RadioItem(myRadioGroup, SWT.NONE, index);
		item.setText((String) element);
	}

	@Override
	public Object remove(int index) {
		final Object oldValue = get(index);
		myRadioGroup.remove(index);
		return oldValue;
	}

	@Override
	public Object set(int index, Object element) {
		final Object oldValue = get(index);
		myRadioGroup.getItems()[index].setText((String) element);
		return oldValue;
	};

	@Override
	public Object getElementType() {
		return String.class;
	}
}
