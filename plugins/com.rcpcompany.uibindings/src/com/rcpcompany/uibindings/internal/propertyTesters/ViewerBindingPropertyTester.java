package com.rcpcompany.uibindings.internal.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Property tester for {@link ViewerBinding}.
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
public class ViewerBindingPropertyTester extends PropertyTester {
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
			LogUtils.debug(this, Constants.PREFIX + property + "(" + receiver + ")");
		}
		if (!(receiver instanceof IViewerBinding)) return false;
		final IViewerBinding binding = (IViewerBinding) receiver;

		if ("state".equals(property)) {
			final BindingState bindingState = BindingState.get((String) expectedValue);
			if (bindingState == null) {
				LogUtils.error(this, "Unknown state: '" + expectedValue + "'");
				return false;
			}
			return binding.getState() == bindingState;
		}

		return false;
	}
}
