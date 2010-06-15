/*******************************************************************************
 * Copyright (c) 2008 Michael Krauter, Catuno GmbH and others. All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Michael Krauter, Catuno GmbH - initial API and implementation (bug 180223)
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.ui.forms.widgets.Form;

/**
 * Adapted from LinkObservableValue for use with {@link Form}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FormTextObservableValue extends AbstractSWTObservableValue {

	private final Form form;

	/**
	 * @param form the form
	 */
	public FormTextObservableValue(Form form) {
		super(form);
		this.form = form;
	}

	@Override
	public void doSetValue(final Object value) {
		final String oldValue = form.getText();
		form.setText(value == null ? "" : value.toString()); //$NON-NLS-1$
		fireValueChange(Diffs.createValueDiff(oldValue, form.getText()));
		form.layout();
	}

	@Override
	public Object doGetValue() {
		return form.getText();
	}

	@Override
	public Object getValueType() {
		return String.class;
	}

}
