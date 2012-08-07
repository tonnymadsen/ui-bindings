/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.internal.Activator;
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
		if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
			LogUtils.debug(this, Constants.PREFIX + property + "(" + receiver + ")");
		}
		if (!(receiver instanceof IBindingContext)) {
			LogUtils.error(this, "Receiver not IBindingContext: " + receiver);
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
