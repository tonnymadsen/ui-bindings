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
package com.rcpcompany.uibindings.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Redo handler for the editing domain of the manager.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EditingDomainRedoHandler extends AbstractHandler implements IHandler {
	@Override
	public Object execute(ExecutionEvent event) {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, ""); //$NON-NLS-1$
		}
		final EditingDomain domain = IManager.Factory.getManager().getEditingDomain();
		final CommandStack commandStack = domain.getCommandStack();
		if (commandStack.canRedo()) {
			commandStack.redo();
		}
		return null;
	}
}
