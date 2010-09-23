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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;

/**
 * Observable value for {@link Image} attributes.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CLabelImageObservableValue extends AbstractSWTObservableValue {

	private final CLabel control;

	/**
	 * @param widget the widget
	 */
	public CLabelImageObservableValue(CLabel widget) {
		super(widget);
		control = widget;
	}

	@Override
	public void doSetValue(final Object value) {
		final Image oldValue = control.getImage();
		control.setImage((Image) value);
		fireValueChange(Diffs.createValueDiff(oldValue, value));
	}

	@Override
	public Object doGetValue() {
		return control.getImage();
	}

	@Override
	public Object getValueType() {
		return Image.class;
	}

}
