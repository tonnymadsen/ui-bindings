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
package com.rcpcompany.tests.utils.logging.tests;

import static org.junit.Assert.*;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.junit.After;
import org.junit.Before;

public class BaseTests {

	protected LogListener myLogListener = null;

	private class LogListener implements ILogListener {
		protected IStatus status;

		public void logging(IStatus status, String plugin) {
			this.status = status;
			assertEquals("org.eclipse.core.runtime", plugin);
		}
	}

	public IStatus getLastStatus() {
		assertNotNull(myLogListener);
		return myLogListener.status;
	}

	public void assertLastStatus(int severity, String pluginId, int code, String message, boolean hasException) {
		final IStatus lastStatus = getLastStatus();
		assertNotNull(lastStatus);

		if (severity != -1) {
			assertEquals(severity, lastStatus.getSeverity());
		}
		if (pluginId != null) {
			assertEquals(pluginId, lastStatus.getPlugin());
		}
		if (code != -1) {
			assertEquals(code, lastStatus.getCode());
		}
		if (message != null) {
			String m = lastStatus.getMessage();
			if (m.indexOf("] ") > 0) {
				m = m.substring(m.indexOf("] ") + 2);
			}
			assertEquals(message, m);
		}
		if (hasException) {
			assertNotNull(lastStatus.getException());
		}
	}

	public void assertNoStatus() {
		final IStatus lastStatus = getLastStatus();
		assertNull(lastStatus);
	}

	@Before
	public void setUp() throws Exception {
		myLogListener = new LogListener();
		Platform.addLogListener(myLogListener);
	}

	@After
	public void tearDown() throws Exception {
		Platform.removeLogListener(myLogListener);
	}
}
