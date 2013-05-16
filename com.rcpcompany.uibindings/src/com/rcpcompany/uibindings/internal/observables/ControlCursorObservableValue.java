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

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.widgets.Control;

/**
 * {@link IObservableValue} for {@link Control#setCursor(Cursor)}
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ControlCursorObservableValue extends AbstractSWTObservableValue {

	private final Control control;

	/**
	 * @param control the control
	 */
	public ControlCursorObservableValue(Control control) {
		super(control);
		this.control = control;
	}

	@Override
	public void doSetValue(final Object value) {
		final Cursor oldValue = control.getCursor();
		if (oldValue != null ? oldValue.equals(value) : value == null) return;
		control.setCursor((Cursor) value);
		fireValueChange(Diffs.createValueDiff(oldValue, control.getCursor()));
	}

	@Override
	public Object doGetValue() {
		return control.getCursor();
	}

	@Override
	public Object getValueType() {
		return Cursor.class;
	}

}
