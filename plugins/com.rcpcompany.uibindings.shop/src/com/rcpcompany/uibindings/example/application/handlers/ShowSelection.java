/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.example.application.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;

import com.rcpcompany.uibindings.Constants;

public class ShowSelection extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		final Shell shell = HandlerUtil.getActiveShellChecked(event);

		final IWorkbenchSite site = HandlerUtil.getActiveSiteChecked(event);
		final ISourceProviderService sourceProviders = (ISourceProviderService) site
				.getService(ISourceProviderService.class);
		final ISourceProvider bindingSourceProvider = sourceProviders
				.getSourceProvider(Constants.SOURCES_ACTIVE_BINDING);
		final String[] sourceNames = bindingSourceProvider.getProvidedSourceNames();

		final StringBuilder sb = new StringBuilder();
		for (String n : sourceNames) {
			final Object variable = HandlerUtil.getVariable(event.getApplicationContext(), n);
			if (variable == null) {
				continue;
			}

			n = n.replace(Constants.SOURCES, "");

			sb.append(n).append(" = ").append(variable.toString()).append("\n");
		}

		String header = event.getParameter("header");
		if (header == null) {
			header = "Information about " + selection;
		}

		MessageDialog.openInformation(shell, header, sb.toString());

		return null;
	}
}
