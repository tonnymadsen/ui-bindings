package com.rcpcompany.uibindings.internal.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.utils.ITableButtonBar;

/**
 * Tests of {@link ITableButtonBar}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class TableButtonBarTests {
	private static final int[] CONSTANTS = new int[] { ITableButtonBar.ADD, ITableButtonBar.DELETE, ITableButtonBar.UP,
			ITableButtonBar.DOWN, ITableButtonBar.BORDER, ITableButtonBar.HORIZONTAL, ITableButtonBar.VERTICAL };

	/**
	 * Tests that all the different style constants of {@link ITableButtonBar} does not overlap.
	 */
	@Test
	public void testConstants() {
		for (int i = 0; i < CONSTANTS.length; i++) {
			final int s = CONSTANTS[i];

			for (int j = 0; j < CONSTANTS.length; j++) {
				final int t = CONSTANTS[j];

				if (i == j) {
					continue;
				}

				assertTrue("Comparing " + s + " and " + t, (s & t) == 0);
			}
		}
	}

	/**
	 * Tests that the correct buttons are present for all the combinations of ADD, DELETE, UP and
	 * DOWN.
	 */
	@Test
	public void testButtonPresent() {
		for (int style = 1; style < 16; style++) {

		}
	}
}
