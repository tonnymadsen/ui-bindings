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
 * Undo handler for the editing domain of the manager.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EditingDomainUndoHandler extends AbstractHandler implements IHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, ""); //$NON-NLS-1$
		}
		final EditingDomain domain = IManager.Factory.getManager().getEditingDomain();
		final CommandStack commandStack = domain.getCommandStack();
		if (commandStack.canUndo()) {
			commandStack.undo();
		}
		return null;
	}
}
