/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
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
import org.eclipse.emf.common.command.Command;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.handlers.DeleteHandler;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Property tester for {@link IViewerBinding}.
 * 
 * TODO TEST
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class IViewerBindingPropertyTester extends PropertyTester {
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
			LogUtils.debug(this, Constants.PREFIX + property + "(" + receiver + ")");
		}
		if (!(receiver instanceof IViewerBinding)) return false;
		final IViewerBinding vb = (IViewerBinding) receiver;

		if (Constants.PROPERTY_CAN_DELETE_SELECTED_OBJECTS.equals(property)) {
			final Command cmd = DeleteHandler.createCommand(vb);
			final boolean res = cmd != null && cmd.canExecute();
			if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
				LogUtils.debug(this, "->> " + res);
			}
			return res;
		}

		return false;
	}

}
