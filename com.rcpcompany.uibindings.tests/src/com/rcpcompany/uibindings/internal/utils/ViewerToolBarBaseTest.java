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
package com.rcpcompany.uibindings.internal.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.utils.IViewerToolBar;

/**
 * Tests of {@link IViewerToolBar}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerToolBarBaseTest {
	/**
	 * Tests that all the different style constants of {@link IViewerToolBar} does not overlap.
	 */
	@Test
	public void testConstants() {
		for (int i = 0; i < IViewerToolBar.STYLES.length; i++) {
			final int s = IViewerToolBar.STYLES[i];

			for (int j = 0; j < IViewerToolBar.STYLES.length; j++) {
				final int t = IViewerToolBar.STYLES[j];

				if (i == j) {
					continue;
				}

				assertTrue("Comparing " + s + " and " + t, (s & t) == 0);
			}
		}
	}
}
