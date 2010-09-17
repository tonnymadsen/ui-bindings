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

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.CComboSelectionObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class CComboSelectionUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public final IUIAttribute create(final Widget widget, final String attribute) {
		return new SimpleUIAttribute(widget, attribute, new CComboSelectionObservableValue((CCombo) widget));
	}
}
