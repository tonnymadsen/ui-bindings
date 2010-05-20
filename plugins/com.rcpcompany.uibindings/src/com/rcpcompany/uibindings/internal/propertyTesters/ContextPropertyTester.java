package com.rcpcompany.uibindings.internal.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Property tester for {@link IBindingContext}.
 * <p>
 * Supported properties:
 * <ul>
 * <li>state</li>
 * <li></li>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ContextPropertyTester extends PropertyTester {
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (!(receiver instanceof IBindingContext)) {
			return false;
		}
		final IBindingContext context = (IBindingContext) receiver;

		if ("state".equals(property)) {
			final BindingState bindingState = BindingState.get((String) expectedValue);
			if (bindingState == null) {
				LogUtils.error(this, "Unknown state: '" + expectedValue + "'");
				return false;
			}
			return context.getState() == bindingState;
		}
		return false;
	}

}
