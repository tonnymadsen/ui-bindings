package com.rcpcompany.uibindings.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.handlers.HandlerUtil;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.internal.utils.UIHandlerUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Moves the current item up one row.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MoveItemHandler extends AbstractHandler implements IHandler, IExecutableExtension {

	@Override
	public Object execute(ExecutionEvent ee) throws ExecutionException {
		if (Activator.getDefault().TRACE_HANDLERS) {
			LogUtils.debug(this, "delta=" + delta);
		}
		// The binding
		final IBinding bb = (IBinding) HandlerUtil.getVariableChecked(ee, Constants.SOURCES_ACTIVE_CONTAINER_BINDING);
		if (!(bb instanceof IViewerBinding)) throw new ExecutionException("Not in container");
		// The viewer
		final IViewerBinding vb = (IViewerBinding) bb;
		// Then find the current object
		final EObject element = (EObject) HandlerUtil.getVariableChecked(ee, Constants.SOURCES_ACTIVE_VIEWER_ELEMENT);

		if (!UIHandlerUtils.moveElement(vb, element, delta, false)) return null;

		return null;
	}

	/**
	 * The delta to move an item in the parent table
	 */
	private int delta = 1;

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		try {
			delta = Integer.parseInt((String) data);
		} catch (final NumberFormatException ex) {
			LogUtils.error(this, ex);
		}
	}
}
