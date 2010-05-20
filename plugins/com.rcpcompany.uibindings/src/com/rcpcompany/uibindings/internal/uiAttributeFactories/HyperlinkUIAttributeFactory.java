package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.Hyperlink;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.HyperlinkObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class HyperlinkUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new SimpleUIAttribute(widget, attribute, new HyperlinkObservableValue((Hyperlink) widget));
	}
}
