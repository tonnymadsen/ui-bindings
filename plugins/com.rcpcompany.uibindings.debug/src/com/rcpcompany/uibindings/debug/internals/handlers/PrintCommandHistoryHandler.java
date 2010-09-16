package com.rcpcompany.uibindings.debug.internals.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;

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

		System.out.println("Command History:");
		for (final Command c : cs.getCommands()) {
			System.out.println("  " + c);
		}
		System.out.println(".");

		return null;
	}

}
