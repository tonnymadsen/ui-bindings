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
package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;

/**
 * Adapted from LinkObservableValue for use with {@link Combo#getSelection()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ComboSelectionObservableValue extends AbstractSWTObservableValue {

	private final Combo widget;

	/**
	 * @param widget the Combo
	 */
	public ComboSelectionObservableValue(Combo widget) {
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
