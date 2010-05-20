package com.rcpcompany.uibindings.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.internal.spy.BindingSpyDialog;

/**
 * Handler for the Binding spy...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingSpyHandler extends AbstractHandler implements IHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Shell shell = HandlerUtil.getActiveShellChecked(event);
		final IBinding b = (IBinding) HandlerUtil.getVariable(event, Constants.SOURCES_ACTIVE_BINDING);
		if (b == null) {
			return null;
		}
		final BindingSpyDialog d = new BindingSpyDialog(shell, b, event);
		d.create();
		d.open();
		return null;
	}
}
