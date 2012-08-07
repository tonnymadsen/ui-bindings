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
package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.ButtonTextObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class TextUIAttributeFactory implements IUIAttributeFactory {
	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		final boolean changeable = (widget instanceof Combo) || (widget instanceof CCombo);
		if (widget instanceof Button)
			return new SimpleUIAttribute(widget, attribute, new ButtonTextObservableValue((Button) widget), changeable);
		else
			return new SimpleUIAttribute(widget, attribute, SWTObservables.observeText((Control) widget), changeable);
	}
}
