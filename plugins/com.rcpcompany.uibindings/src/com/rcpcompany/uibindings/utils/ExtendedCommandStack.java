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
package com.rcpcompany.uibindings.utils;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;

/**
 * Extended command stack that supports a number of extra methods...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ExtendedCommandStack extends BasicCommandStack implements CommandStack {
	/**
	 * Returns an unmodifiable list of commands from this stack.
	 * 
	 * @return the list of commands
	 */
	public List<Command> getCommands() {
		return Collections.unmodifiableList(commandList);
	}
}
