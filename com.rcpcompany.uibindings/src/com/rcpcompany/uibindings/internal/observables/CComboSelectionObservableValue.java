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
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Point;

/**
 * Adapted from LinkObservableValue for use with {@link CCombo#getSelection()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CComboSelectionObservableValue extends AbstractSWTObservableValue {

	private final CCombo widget;

	/**
	 * @param widget the Combo
	 */
	public CComboSelectionObservableValue(CCombo widget) {
		super(widget);
		this.widget = widget;
	}

	@Override
	public void doSetValue(final Object value) {
		final Point oldValue = widget.getSelection();
		final Point newValue = value == null ? new Point(0, 0) : (Point) value;
		widget.setSelection(newValue);
		fireValueChange(Diffs.createValueDiff(oldValue, newValue));
	}

	@Override
	public Object doGetValue() {
		return widget.getSelection();
	}

	@Override
	public Object getValueType() {
		return Point.class;
	}
}
