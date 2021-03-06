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
import org.eclipse.swt.widgets.Shell;

/**
 * Adapted from LinkObservableValue for use with {@link Shell}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShellObservableValue extends AbstractSWTObservableValue {

	private final Shell shell;

	/**
	 * @param widget the link
	 */
	public ShellObservableValue(Shell widget) {
		super(widget);
		shell = widget;
	}

	@Override
	public void doSetValue(final Object value) {
		final String oldValue = shell.getText();
		shell.setText(value == null ? "" : value.toString()); //$NON-NLS-1$
		fireValueChange(Diffs.createValueDiff(oldValue, shell.getText()));
		shell.layout();
	}

	@Override
	public Object doGetValue() {
		return shell.getText();
	}

	@Override
	public Object getValueType() {
		return String.class;
	}

}
