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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.ControlCursorObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class ControlUIAttributeFactory implements IUIAttributeFactory {
	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new ControlUIAttribute(widget, attribute);
	}

	private static class ControlUIAttribute extends SimpleUIAttribute {
		private ControlUIAttribute(Widget widget, String attribute) {
			super(widget, attribute, createValue((Control) widget, attribute), true);
		}

		private static IObservableValue createValue(Control c, String attribute) {
			if (Constants.ATTR_BACKGROUND.equals(attribute))
				return SWTObservables.observeBackground(c);
			else if (Constants.ATTR_FOREGROUND.equals(attribute))
				return SWTObservables.observeForeground(c);
			else if (Constants.ATTR_FONT.equals(attribute))
				return SWTObservables.observeFont(c);
			else if (Constants.ATTR_ENABLED.equals(attribute))
				return SWTObservables.observeEnabled(c);
			else if (Constants.ATTR_VISIBLE.equals(attribute))
				return SWTObservables.observeVisible(c);
			else if (Constants.ATTR_TOOLTIP.equals(attribute))
				return SWTObservables.observeTooltipText(c);
			else if (Constants.ATTR_CURSOR.equals(attribute)) return new ControlCursorObservableValue(c);
			return null;
		}
	}
}
