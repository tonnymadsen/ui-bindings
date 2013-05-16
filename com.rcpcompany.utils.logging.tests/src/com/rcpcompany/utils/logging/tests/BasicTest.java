package com.rcpcompany.utils.logging.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * Basic tests of logging..
 * 
 * @author Tonny Madsen, tonny.madsen@gmail.com
 */
public class BasicTest {
	@Test
	public void testMehods() {
		try {
			LogUtils.debug(this, "hello");
		} catch (final Exception ex) {
			ex.printStackTrace(System.err);
			fail("debug: " + ex);
		}
	}
}
