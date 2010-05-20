package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class TextEditableUIAttributeFactory implements IUIAttributeFactory {
	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new SimpleUIAttribute(widget, attribute, SWTObservables.observeEditable((Control) widget));
	}
}
