package com.rcpcompany.uibindings.bindings.xtext.internal.xtext;

import org.eclipse.xtext.service.AbstractGenericModule;

import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.bindings.xtext.IUIBXTextBindingContext;

public class EmbeddedXtextEditorModule extends AbstractGenericModule {

	private final IUIBXTextBindingContext myContext;

	public EmbeddedXtextEditorModule(IUIBXTextBindingContext context) {
		myContext = context;
	}

	public IUIBXTextBindingContext bindIUIBXTextBindingContext() {
		return myContext;
	}

	public IValueBinding bindIValueBinding() {
		return myContext.getBinding();
	}
}
