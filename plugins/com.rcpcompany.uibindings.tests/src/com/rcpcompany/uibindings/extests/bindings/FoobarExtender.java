package com.rcpcompany.uibindings.extests.bindings;

import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;

/**
 * Dummy extender for use in {@link ArgumentsScopeTest#testDecoratorExtender()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FoobarExtender extends AbstractUIBindingDecoratorExtender implements IUIBindingDecoratorExtender {

	public FoobarExtender() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isEnabled(IValueBinding binding) {
		return "foobar".equals(binding.getArgument("extender"));
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		// TODO Auto-generated method stub

	}

}
