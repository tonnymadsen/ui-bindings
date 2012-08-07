package com.rcpcompany.uibindings.bindings.xtext;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;

import com.google.inject.Module;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Various utility methods for use with XText editors.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIBXtextUtils {
	/**
	 * Private constructor to prevent construction...
	 */
	private UIBXtextUtils() {
	}

	public static IValueBinding createEditorBinding(IFormCreator form, String spec, Module module) {
		final IValueBinding binding = createEditorBinding(form.getContext(), form.addComposite(true, true),
				form.getObservableValue(spec), module);

		return binding;
	}

	public static IValueBinding createEditorBinding(IBindingContext context, final Composite parent,
			IObservableValue observable, Module module) {
		Assert.isNotNull(module);
		final VirtualUIAttribute attribute = new VirtualUIAttribute(String.class) {
			@Override
			public Widget getWidget() {
				return parent;
			}
		};
		final IValueBinding binding = context.addBinding().model(observable).ui(attribute).type("xtext")
				.arg(UIBXTextContants.ARG_XTEXT_INJECTOR_MODULE, module);

		return binding;
	}
}
