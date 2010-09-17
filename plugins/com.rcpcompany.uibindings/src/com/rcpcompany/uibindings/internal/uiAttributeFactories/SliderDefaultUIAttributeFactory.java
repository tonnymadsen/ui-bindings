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
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.SliderObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

/**
 * {@link IUIAttributeFactory} for {@link Slider}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SliderDefaultUIAttributeFactory implements IUIAttributeFactory {
	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new Attribute(widget, attribute);
	}

	private static class Attribute extends SimpleUIAttribute {
		private final IObservableValue myMinValue;
		private final IObservableValue myMaxValue;

		public Attribute(Widget widget, String attribute) {
			super(widget, attribute, new SliderObservableValue((Slider) widget, Constants.ATTR_SELECTION), true);

			myMinValue = new SliderObservableValue((Slider) widget, Constants.ATTR_MIN);
			myMaxValue = new SliderObservableValue((Slider) widget, Constants.ATTR_MAX);
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
