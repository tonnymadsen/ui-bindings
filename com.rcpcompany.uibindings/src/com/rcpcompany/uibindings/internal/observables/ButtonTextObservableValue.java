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
import org.eclipse.swt.widgets.Button;

/**
 * Adapted from LinkObservableValue for use with {@link Button}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ButtonTextObservableValue extends AbstractSWTObservableValue {

	private final Button button;

	/**
	 * @param button the form
	 */
	public ButtonTextObservableValue(Button button) {
		super(button);
		this.button = button;
	}

	@Override
	public void doSetValue(final Object value) {
		final String oldValue = button.getText();
		button.setText(value == null ? "" : value.toString()); //$NON-NLS-1$
		fireValueChange(Diffs.createValueDiff(oldValue, button.getText()));
	}

	@Override
	public Object doGetValue() {
		return button.getText();
	}

	@Override
	public Object getValueType() {
		return String.class;
	}
}
