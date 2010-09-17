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
package com.rcpcompany.utils.jface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * This class includes a number of utility classes that can make it easier to develop and test SWT
 * based applications.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class SWTEventUtils {
	private SWTEventUtils() {

	}

	public final static Listener SWT_EVENT_LISTENER = new Listener() {
		@Override
		public void handleEvent(Event event) {
			// LogUtils.debug(this, ToStringUtils.toString(event));
		}
	};

	/**
	 * Logs all SWT events on the specified control.
	 * 
	 * @param c the control in question
	 */
	public static void swtListen(Control c) {
		for (int i = SWT.None; i < SWT.ImeComposition; i++) {
			c.addListener(i, SWT_EVENT_LISTENER);
		}
	}

	/**
	 * Runs the specified {@link Runnable} while debugging the SWT events.
	 * 
	 * @param runnable the {@link Runnable} to run
	 */
	public static void swtDisplayListen(Runnable runnable) {
		try {
			for (int i = SWT.None; i < SWT.ImeComposition; i++) {
				Display.getCurrent().addFilter(i, SWT_EVENT_LISTENER);
			}
			runnable.run();
		} finally {
			for (int i = SWT.None; i < SWT.ImeComposition; i++) {
				Display.getCurrent().removeFilter(i, SWT_EVENT_LISTENER);
			}
		}
	}
}
