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
package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.ComboSelectionObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class ComboSelectionUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public final IUIAttribute create(final Widget widget, final String attribute) {
		return new SimpleUIAttribute(widget, attribute, new ComboSelectionObservableValue((Combo) widget));
	}
}
