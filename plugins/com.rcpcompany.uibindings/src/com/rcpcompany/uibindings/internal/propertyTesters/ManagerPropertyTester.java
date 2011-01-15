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
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Property tester for the manager state.
 * 
 * TODO TEST
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerPropertyTester extends PropertyTester {
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
			LogUtils.debug(this, Constants.PREFIX + property + "(" + receiver + ")");
		}
		if (!(receiver instanceof IManager)) {
			LogUtils.error(this, "Receiver not IManager: " + receiver);
			return false;
		}

		if (Constants.PROPERTY_CAN_UNDO.equals(property)) {
			final EditingDomain ed = EditingDomainUtils.getEditingDomain();
			final CommandStack cs = ed.getCommandStack();
			return cs.canUndo();
		}
		if (Constants.PROPERTY_CAN_REDO.equals(property)) {
			final EditingDomain ed = EditingDomainUtils.getEditingDomain();
			final CommandStack cs = ed.getCommandStack();
			return cs.canRedo();
		}

		return false;
	}

}
