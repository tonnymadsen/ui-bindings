package com.rcpcompany.uibindings.navigator.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;

/**
 * Handler for the "Clone Editor" command.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CloneEditorHandler extends AbstractHandler implements IHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final IWorkbenchPart activePart = HandlerUtil.getActivePartChecked(event);
		if (!(activePart instanceof IEditorPartView)) return null;
		final IEditorPartView view = (IEditorPartView) activePart;

		INavigatorManager.Factory.getManager().openView(view.getCurrentObject(), true);
		return null;
	}
}
