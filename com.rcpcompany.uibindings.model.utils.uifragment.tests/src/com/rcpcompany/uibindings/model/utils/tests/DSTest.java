package com.rcpcompany.uibindings.model.utils.tests;

import org.junit.Test;
import org.junit.rules.Timeout;

import com.rcpcompany.test.utils.DSTestUtils;

/**
 * Tests that all the XML files in OSGI-INF is listed in the MANIFEST.MF.
 * 
 * @author Tonny Madsen, tma@bording.dk
 */
public class DSTest {
	// @Rule
	public Timeout globalTimeout = new Timeout(60000); // 60 seconds max per method tested

	@Test
	public void testDSFilesPresent() {
		DSTestUtils.checkDSFiles("com.rcpcompany.uibindings.model.utils");
	}
}
