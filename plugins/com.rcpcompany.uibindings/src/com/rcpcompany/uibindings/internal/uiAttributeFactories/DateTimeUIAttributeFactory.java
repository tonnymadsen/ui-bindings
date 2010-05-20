package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.DateTimeObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class DateTimeUIAttributeFactory implements IUIAttributeFactory {
	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new SimpleUIAttribute(widget, attribute, new DateTimeObservableValue((DateTime) widget), true);
	}
}
