package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.ComboSelectionObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

public class ComboSelectionUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public final IUIAttribute create(final Widget widget, final String attribute) {
		return new SimpleUIAttribute(widget, attribute, new ComboSelectionObservableValue((Combo) widget));
	}
}
