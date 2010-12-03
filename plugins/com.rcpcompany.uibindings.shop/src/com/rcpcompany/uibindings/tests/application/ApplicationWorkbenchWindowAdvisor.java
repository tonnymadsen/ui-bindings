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
package com.rcpcompany.uibindings.tests.application;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager;
import com.rcpcompany.utils.logging.LogUtils;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	@Override
	public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	@Override
	public void preWindowOpen() {
		final IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(800, 900));
		configurer.setShowCoolBar(true);
		configurer.setShowPerspectiveBar(true);
		configurer.setShowStatusLine(true);
	}

	@Override
	public void postWindowOpen() {
		super.postWindowOpen();

		IGlobalNavigationManager.Factory.createManager(getWindowConfigurer().getWindow());
	}

	@Override
	public boolean preWindowShellClose() {
		final IManager manager = IManager.Factory.getManager();
		final EditingDomain editingDomain = manager.getEditingDomain();
		int res = 1; // == NO
		if (editingDomain.getCommandStack().canUndo()) {
			final IWorkbenchWindow window = getWindowConfigurer().getWindow();
			final MessageDialog dialog = new MessageDialog(window.getShell(), "Save Shop?", null,
					"Changes has been made to the shop. Save these?", MessageDialog.QUESTION, new String[] {
							IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, IDialogConstants.CANCEL_LABEL }, 0);
			res = dialog.open();
			if (res == 0) {
				final ICommandService cs = (ICommandService) window.getService(ICommandService.class);
				final IHandlerService hs = (IHandlerService) window.getService(IHandlerService.class);

				try {
					final String c = manager.getCommandIDs().get(IWorkbenchCommandConstants.FILE_SAVE);
					final ParameterizedCommand command = cs.deserialize(c);
					hs.executeCommand(command, null);
				} catch (final Exception ex) {
					LogUtils.error(this, ex);
				}
			}
		}
		return res != 2;
	}
}
