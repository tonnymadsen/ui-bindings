package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.ButtonImageObservableValue;
import com.rcpcompany.uibindings.internal.observables.CLabelImageObservableValue;
import com.rcpcompany.uibindings.internal.observables.LabelImageObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class ImageUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		IObservableValue ov = null;
		if (widget instanceof Button) {
			ov = new ButtonImageObservableValue((Button) widget);
		} else if (widget instanceof Label) {
			ov = new LabelImageObservableValue((Label) widget);
		} else if (widget instanceof CLabel) {
			ov = new CLabelImageObservableValue((CLabel) widget);
		} else
			throw new IllegalArgumentException("Widget " + widget + " not supported");

		return new SimpleUIAttribute(widget, attribute, ov, false);
	}
}
