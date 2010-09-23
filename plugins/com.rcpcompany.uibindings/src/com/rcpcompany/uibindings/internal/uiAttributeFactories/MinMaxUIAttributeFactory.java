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
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.SliderObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class MinMaxUIAttributeFactory implements IUIAttributeFactory {
	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new MinMaxUIAttribute(widget, attribute);
	}

	protected static IObservableValue createObservable(Widget widget, String attribute) {
		if (widget instanceof Slider)
			return new SliderObservableValue(((Slider) widget), attribute);
		else if (Constants.ATTR_MIN.equals(attribute))
			return SWTObservables.observeMin((Control) widget);
		else if (Constants.ATTR_MAX.equals(attribute)) return SWTObservables.observeMax((Control) widget);
		return null;
	}

	private static class MinMaxUIAttribute extends SimpleUIAttribute {

		private MinMaxUIAttribute(Widget widget, String attribute) {
			super(widget, attribute, createObservable(widget, attribute), true);
		}

	}
}
