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
package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.ButtonTextObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class ButtonDefaultUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		final int style = widget.getStyle();
		if (((style & SWT.CHECK) == SWT.CHECK) || ((style & SWT.RADIO) == SWT.RADIO)
				|| ((style & SWT.TOGGLE) == SWT.TOGGLE))
			return new SimpleUIAttribute(widget, attribute, SWTObservables.observeSelection((Control) widget), true);
		else
			return new SimpleUIAttribute(widget, attribute, new ButtonTextObservableValue((Button) widget), true);
	}
}
