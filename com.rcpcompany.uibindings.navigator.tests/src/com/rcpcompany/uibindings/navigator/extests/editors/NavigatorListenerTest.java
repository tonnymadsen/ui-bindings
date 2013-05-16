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
package com.rcpcompany.uibindings.navigator.extests.editors;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.junit.Test;

import com.rcpcompany.test.utils.ui.UITestUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tests the navigator does not leave behind any listeners.
 * <p>
 * Heavily use of reflection..
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NavigatorListenerTest {

	/**
	 * Tests the number of listeners in the system is the same before and after the view is shown
	 */
	@Test
	public void openView() {
		testView("com.rcpcompany.uibindings.navigator.extests.NavigatorView", new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * Shows the specified view, runs the {@link Runnable}, close the view and then tests that the
	 * number of listener from the framework is the same before and after
	 * 
	 * @param viewID the ID of the view to show
	 * @param runnable the {@link Runnable} to run
	 */
	public static void testView(String viewID, Runnable runnable) {
		try {
			final IWorkbench workbench = PlatformUI.getWorkbench();

			LogUtils.debug(workbench, "" + Arrays.toString(workbench.getClass().getDeclaredMethods()));
			Method m;
			m = workbench.getClass().getDeclaredMethod("getListeners");
			m.setAccessible(true);
			final ListenerList ll = (ListenerList) m.invoke(workbench);

			final IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();

			final IViewPart view = UITestUtils.showView(viewID);
			try {
				runnable.run();
			} finally {
				view.getSite().getPage().hideView(view);
			}
		} catch (final SecurityException e) {
			fail(e.getMessage());
		} catch (final IllegalArgumentException e) {
			fail(e.getMessage());
		} catch (final IllegalAccessException e) {
			fail(e.getMessage());
		} catch (final NoSuchMethodException e) {
			fail(e.getMessage());
		} catch (final InvocationTargetException e) {
			fail(e.getMessage());
		}
	}
}
