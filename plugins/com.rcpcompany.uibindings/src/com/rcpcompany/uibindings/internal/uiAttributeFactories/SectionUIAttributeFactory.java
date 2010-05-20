package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.Section;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.SectionObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

/**
 * {@link IUIAttributeFactory} for {@link Section}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SectionUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new SimpleUIAttribute(widget, attribute, new SectionObservableValue((Section) widget), false);
	}
}
