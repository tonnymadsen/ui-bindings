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

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.ui.forms.widgets.Section;

/**
 * Adapted from LinkObservableValue for use with {@link Section}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SectionObservableValue extends AbstractSWTObservableValue {

	private final Section section;

	/**
	 * @param link the link
	 */
	public SectionObservableValue(Section link) {
		super(link);
		section = link;
	}

	@Override
	public void doSetValue(final Object value) {
		final String oldValue = section.getText();
		section.setText(value == null ? "" : value.toString()); //$NON-NLS-1$
		fireValueChange(Diffs.createValueDiff(oldValue, section.getText()));
		section.layout();
	}

	@Override
	public Object doGetValue() {
		return section.getText();
	}

	@Override
	public Object getValueType() {
		return String.class;
	}

}
