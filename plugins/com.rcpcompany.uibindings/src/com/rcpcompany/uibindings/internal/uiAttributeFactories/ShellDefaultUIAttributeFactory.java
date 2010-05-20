package com.rcpcompany.uibindings.internal.uiAttributeFactories;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IUIAttributeFactory;
import com.rcpcompany.uibindings.internal.observables.ShellObservableValue;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

/**
 * {@link IUIAttributeFactory} for {@link Shell}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShellDefaultUIAttributeFactory implements IUIAttributeFactory {

	@Override
	public IUIAttribute create(Widget widget, String attribute) {
		return new SimpleUIAttribute(widget, attribute, new ShellObservableValue((Shell) widget), false);
	}
}
