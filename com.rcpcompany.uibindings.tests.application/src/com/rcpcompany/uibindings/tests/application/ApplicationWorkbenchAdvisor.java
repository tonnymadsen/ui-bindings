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
package com.rcpcompany.uibindings.tests.application;

import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "com.rcpcompany.uibindings.tests.application.Perspective";

	@Override
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		return new ApplicationWorkbenchWindowAdvisor(configurer);
	}

	@Override
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
	//
	// @Override
	// public void postStartup() {
	// super.postStartup();
	//
	// final Listener listener = new Listener() {
	// @Override
	// public void handleEvent(Event event) {
	// LogUtils.debug(this, ToStringUtils.toString(event));
	// }
	// };
	// for (int i = SWT.None; i <= SWT.ImeComposition; i++) {
	// PlatformUI.getWorkbench().getDisplay().addFilter(i, listener);
	// }
	// }
}
