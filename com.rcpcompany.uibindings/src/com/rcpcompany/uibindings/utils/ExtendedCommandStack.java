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
package com.rcpcompany.uibindings.utils;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;

import com.rcpcompany.uibindings.model.utils.ICommandStackWithCollect;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Extended command stack that supports a number of extra methods plus the ability to collect a
 * number of commands in a new compound command that will be at the top of the stack
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ExtendedCommandStack extends BasicCommandStack implements CommandStack, ICommandStackWithCollect {
	/**
	 * Whether commands are collected.
	 * 
	 * @see #setCollectCommandMode(boolean)
	 */
	private boolean myCollectCommandMode = false;

	/**
	 * {@link CompoundCommand} used when in collect mode.
	 * 
	 * @see #setCollectCommandMode(boolean)
	 */
	private CompoundCommand myCollectCompoundCommand = null;

	/**
	 * Returns an unmodifiable list of commands from this stack.
	 * 
	 * @return the list of commands
	 */
	public List<Command> getCommands() {
		return Collections.unmodifiableList(commandList);
	}

	@Override
	public void setCollectCommandMode(boolean collect) {
		myCollectCommandMode = collect;

		if (!myCollectCommandMode && myCollectCompoundCommand != null) {
			myCollectCompoundCommand = null;
		}
	}

	@Override
	public void execute(Command command) {
		if (!myCollectCommandMode) {
			super.execute(command);
			return;
		}

		if (myCollectCompoundCommand == null) {
			myCollectCompoundCommand = new CompoundCommand();
			myCollectCompoundCommand.append(IdentityCommand.INSTANCE);
			super.execute(myCollectCompoundCommand);
		}
		myCollectCompoundCommand.appendAndExecute(command);
	}

	@Override
	public void undo() {
		setCollectCommandMode(false);
		super.undo();
	}

	@Override
	public void redo() {
		setCollectCommandMode(false);
		super.redo();
	}

	@Override
	protected void handleError(Exception exception) {
		LogUtils.error(this, exception);
	}
}
