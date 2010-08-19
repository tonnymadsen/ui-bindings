package com.rcpcompany.uibindings.internal.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.utils.IViewerToolBar;

/**
 * Tests of {@link IViewerToolBar}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerToolBarBaseTests {
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
