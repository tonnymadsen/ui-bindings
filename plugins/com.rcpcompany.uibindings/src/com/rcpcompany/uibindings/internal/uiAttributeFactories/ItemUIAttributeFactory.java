package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.ItemObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class ItemUIAttributeFactory implements IUIAttributeFactory {
	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new ItemUIAttribute(widget, attribute);
	}

	protected static IObservableValue createValue(Item c, String attribute) {
		if (Constants.ATTR_TEXT.equals(attribute) || attribute.length() == 0) {
			return new ItemObservableValue(c, attribute);
		} else if (Constants.ATTR_IMAGE.equals(attribute)) {
			return new ItemObservableValue(c, attribute);
		} else if (Constants.ATTR_ALIGNMENT.equals(attribute)) {
			return new ItemObservableValue(c, attribute);
		} else if (Constants.ATTR_TOOLTIP.equals(attribute)) {
			return new ItemObservableValue(c, attribute);
		} else if (Constants.ATTR_WIDTH.equals(attribute)) {
			return new ItemObservableValue(c, attribute);
		} else if (Constants.ATTR_ENABLED.equals(attribute)) {
			return new ItemObservableValue(c, attribute);
		}
		return null;
	}

	private static class ItemUIAttribute extends SimpleUIAttribute {
		public ItemUIAttribute(Widget widget, String attribute) {
			super(widget, attribute, createValue((Item) widget, attribute), true);
		}

	}

}
