package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.FormTextObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

/**
 * {@link IUIAttributeFactory} for {@link ScrolledForm}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScrolledFormUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new SimpleUIAttribute(widget, attribute, new FormTextObservableValue(((ScrolledForm) widget).getForm()),
				false);
	}
}
