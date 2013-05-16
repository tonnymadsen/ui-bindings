/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.scripting.internal.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.scripting.internal.Activator;

/**
 * The implementation of <code>com.rcpcompany.uibindings.scripting.commands.ToggleShowScriptInBinding</code>.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ToggleShowScriptInBindingHandler extends AbstractHandler implements org.eclipse.core.commands.IHandler,
		IElementUpdater {

	/**
	 * The global command service.
	 */
	protected final ICommandService myCommandService;

	@SuppressWarnings("unchecked")
	@Override
	public void updateElement(UIElement element, Map parameters) {
		element.setChecked(Activator.getDefault().getShowScriptInBindings());
	}

	/**
	 * Construct the handler and sets up all needed listeners.
	 */
	public ToggleShowScriptInBindingHandler() {
		final IServiceLocator locator = PlatformUI.getWorkbench();

		myCommandService = (ICommandService) locator.getService(ICommandService.class);
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final boolean b = Activator.getDefault().getShowScriptInBindings();
		Activator.getDefault().setShowScriptInBindings(!b);

		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		if (window instanceof ApplicationWindow) {
			final ApplicationWindow applWindow = (ApplicationWindow) window;
			applWindow.setStatus(b ? "Show scripts" : "Show values");
		}
		return null;
	}
}
