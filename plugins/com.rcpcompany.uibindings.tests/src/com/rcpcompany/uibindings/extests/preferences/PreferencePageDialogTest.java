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
package com.rcpcompany.uibindings.extests.preferences;

import static org.junit.Assert.*;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.Test;

public class PreferencePageDialogTest {
	@Test
	public void testPage() {
		try {
			final IWorkbench workbench = PlatformUI.getWorkbench();
			final Shell[] shells = workbench.getDisplay().getShells();
			final ICommandService cs = (ICommandService) workbench.getService(ICommandService.class);
			final ParameterizedCommand command = cs
					.deserialize("org.eclipse.ui.window.preferences(preferencePageId=com.rcpcompany.uibindings.example.application.pages.basic)");
			assertNotNull(command);

			final IHandlerService hs = (IHandlerService) workbench.getService(IHandlerService.class);
			// Have to use timerExec to get the runnable executed after the dialog is shown
			workbench.getDisplay().timerExec(2000, new Runnable() {
				@Override
				public void run() {
					assertEquals(shells.length + 1, workbench.getDisplay().getShells().length);
					final Shell lastShell = findLastShell(workbench.getDisplay().getShells(), shells);
					assertNotNull(lastShell);
					final Object data = lastShell.getData();
					assertNotNull(data);
					assertTrue(data instanceof PreferenceDialog);
					lastShell.close();

					assertEquals(shells.length, workbench.getDisplay().getShells().length);
				}

				private Shell findLastShell(Shell[] currentShells, Shell[] oldShells) {
					CheckNext: for (final Shell cs : currentShells) {
						for (final Shell os : oldShells) {
							if (os == cs) {
								continue CheckNext;
							}
						}
						return cs;
					}
					return null;
				}
			});
			hs.executeCommand(command, null);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}
}
