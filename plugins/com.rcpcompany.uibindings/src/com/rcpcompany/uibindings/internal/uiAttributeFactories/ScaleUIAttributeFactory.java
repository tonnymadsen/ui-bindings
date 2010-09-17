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

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class ScaleUIAttributeFactory implements IUIAttributeFactory {
	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new Attribute(widget, attribute);
	}

	private static class Attribute extends SimpleUIAttribute {

		private final IObservableValue myMinValue;
		private final IObservableValue myMaxValue;

		public Attribute(Widget widget, String attribute) {
			super(widget, attribute, SWTObservables.observeSelection((Control) widget), true);
			myMinValue = SWTObservables.observeMin((Control) widget);
			myMaxValue = SWTObservables.observeMax((Control) widget);

			addObservable(myMinValue);
			addObservable(myMaxValue);
		}

		@Override
		public IObservableValue getMinValue() {
			return myMinValue;
		}

		@Override
		public IObservableValue getMaxValue() {
			return myMaxValue;
		}

	}
}
