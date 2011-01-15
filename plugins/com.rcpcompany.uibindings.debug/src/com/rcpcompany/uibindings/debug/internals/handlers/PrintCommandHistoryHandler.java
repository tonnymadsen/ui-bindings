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
package com.rcpcompany.uibindings.debug.internals.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;

import com.rcpcompany.uibindings.EcoreExtUtils;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.utils.ExtendedCommandStack;

/**
 * Handler for <code>com.rcpcompany.uibindings.debug.commands.PrintCommandHistory</code>.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PrintCommandHistoryHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IManager manager = IManager.Factory.getManager();
		final CommandStack commandStack = manager.getEditingDomain().getCommandStack();

		if (!(commandStack instanceof ExtendedCommandStack)) {
			System.out.println("Command not support for current command stack...");
			return null;
		}

		final ExtendedCommandStack cs = (ExtendedCommandStack) commandStack;

		System.out.println("Command History (in execution order):");
		for (final Command c : cs.getCommands()) {
			System.out.println("  " + EcoreExtUtils.toString(c));
		}
		System.out.println(".");

		return null;
	}

}
