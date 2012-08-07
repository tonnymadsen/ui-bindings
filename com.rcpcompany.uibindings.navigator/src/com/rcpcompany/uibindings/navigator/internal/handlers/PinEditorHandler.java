/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.navigator.internal.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;
import org.eclipse.ui.services.IServiceLocator;

import com.rcpcompany.uibindings.navigator.IEditorPartView;

/**
 * Handler for the "Pin Editor" command.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PinEditorHandler extends AbstractHandler implements IHandler, IElementUpdater {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		final IWorkbenchPart activePart = HandlerUtil.getActivePartChecked(event);
		if (!(activePart instanceof IEditorPartView)) return null;
		final IEditorPartView view = (IEditorPartView) activePart;

		view.setPinned(!view.isPinned());
		final ICommandService commandService = (ICommandService) window.getService(ICommandService.class);
		commandService.refreshElements(event.getCommand().getId(), null);
		return null;
	}

	@Override
	public void updateElement(UIElement element, Map parameters) {
		final IServiceLocator serviceLocator = element.getServiceLocator();

		final IWorkbenchPartSite site = (IWorkbenchPartSite) serviceLocator.getService(IWorkbenchPartSite.class);
		if (site == null) return;
		final IWorkbenchPart part = site.getPart();
		if (part == null) return;
		if (!(part instanceof IEditorPartView)) return;
		final IEditorPartView view = (IEditorPartView) part;

		element.setChecked(view.isPinned());
	}
}
