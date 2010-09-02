package com.rcpcompany.uibindings.internal.decorators.extenders;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.units.IUnitBindingSupport;
import com.rcpcompany.uibindings.units.IUnitBindingSupportContext;

/**
 * {@link IUIBindingDecoratorExtender} that adds unit information to the current tooltip.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UnitSupportLabelDecoratorExtender extends AbstractUIBindingDecoratorExtender implements
		IUIBindingDecoratorExtender {

	@Override
	public boolean isEnabled(IValueBinding binding) {
		return binding.getArgument(Constants.ARG_UNIT_SUPPORT, IUnitBindingSupport.class, null) != null;

	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final IValueBinding binding = context.getBinding();
		final IUnitBindingSupport support = binding.getArgument(Constants.ARG_UNIT_SUPPORT, IUnitBindingSupport.class,
				null);
		if (support == null) return;

		final String unitDescription = support.getUnitDescription(new IUnitBindingSupportContext() {
			@Override
			public IValueBinding getBinding() {
				return binding;
			}
		});

		if (unitDescription == null) return;

		context.appendTooltip("[" + unitDescription + "]");
	}
}
