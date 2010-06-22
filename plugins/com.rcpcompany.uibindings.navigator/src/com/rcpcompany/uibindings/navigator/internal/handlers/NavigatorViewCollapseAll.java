package com.rcpcompany.uibindings.navigator.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.navigator.views.NavigatorBaseView;

/**
 * Handler for
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class NavigatorViewCollapseAll extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchPart workbenchPart = HandlerUtil.getActivePartChecked(event);
		if (!(workbenchPart instanceof NavigatorBaseView)) return null;

		final NavigatorBaseView navigator = (NavigatorBaseView) workbenchPart;
		navigator.collapseAll();

		return null;
	}
}
