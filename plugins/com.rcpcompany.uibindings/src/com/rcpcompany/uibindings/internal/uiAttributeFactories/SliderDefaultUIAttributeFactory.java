package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.SliderObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

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
