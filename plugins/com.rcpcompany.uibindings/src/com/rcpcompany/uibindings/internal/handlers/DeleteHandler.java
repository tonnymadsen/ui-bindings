package com.rcpcompany.uibindings.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.utils.UIHandlerUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Deletes the current object in a viewer.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DeleteHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent ee) throws ExecutionException {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "");
		}
		// The binding
		final IBinding bb = (IBinding) HandlerUtil.getVariableChecked(ee, Constants.SOURCES_ACTIVE_BINDING);
		if (!(bb instanceof IViewerBinding)) return null;
		// The viewer
		final IViewerBinding vb = (IViewerBinding) bb;
		// Then find the current object
		final EObject element = (EObject) HandlerUtil.getVariableChecked(ee, Constants.SOURCES_ACTIVE_VIEWER_ELEMENT);

		if (!UIHandlerUtils.deleteElement(vb, element, false)) return null;

		return null;
	}
}
