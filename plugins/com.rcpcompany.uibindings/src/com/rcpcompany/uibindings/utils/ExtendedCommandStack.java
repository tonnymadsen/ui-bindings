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
