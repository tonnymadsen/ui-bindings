/*******************************************************************************
 * Copyright (c) 2008 Michael Krauter, Catuno GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Michael Krauter, Catuno GmbH - initial API and implementation (bug 180223)
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.ui.forms.widgets.Hyperlink;

/**
 * Adapted from LinkObservableValue for use with {@link Hyperlink}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class HyperlinkObservableValue extends AbstractSWTObservableValue {

	private final Hyperlink link;

	/**
	 * @param link the link
	 */
	public HyperlinkObservableValue(Hyperlink link) {
		super(link);
		this.link = link;
	}

	@Override
	public void doSetValue(final Object value) {
		final String oldValue = link.getText();
		link.setText(value == null ? "" : value.toString()); //$NON-NLS-1$
		fireValueChange(Diffs.createValueDiff(oldValue, link.getText()));
	}

	@Override
	public Object doGetValue() {
		return link.getText();
	}

	public Object getValueType() {
		return String.class;
	}

}
