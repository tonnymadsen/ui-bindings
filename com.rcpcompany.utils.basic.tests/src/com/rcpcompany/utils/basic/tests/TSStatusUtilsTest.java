package com.rcpcompany.utils.basic.tests;

import static org.junit.Assert.assertEquals;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.junit.Test;

import com.rcpcompany.utils.basic.TSStatusUtils;

/**
 * Tests of {@link TSStatusUtils}.
 * 
 * @author Tonny Madsen, tma@bording.dk
 */
public class TSStatusUtilsTest {
	/**
	 * Tests of the various standard {@link Status} values...
	 */
	@Test
	public void testStandardStatus() {
		assertEquals("STATUS[OK]", TSStatusUtils.toString(Status.OK_STATUS));
		assertEquals("STATUS[CANCEL]",
				TSStatusUtils.toString(Status.CANCEL_STATUS));
	}

	/**
	 * Tests of the simple Status types...
	 */
	@Test
	public void testSimpleStatus() {
		assertEquals("Status[xyz, INFO, \"hello\", 0]",
				TSStatusUtils
						.toString(new Status(IStatus.INFO, "xyz", "hello")));
		// Fragile!!!
		assertEquals(
				"Status[xyz, INFO, \"hello\", 0, java.lang.NullPointerException[TSStatusUtilsTest.java:40]]",
				TSStatusUtils.toString(new Status(IStatus.INFO, "xyz", "hello",
						new NullPointerException())));
		assertEquals("Status[xyz, INFO, \"hello\", 123]",
				TSStatusUtils.toString(new Status(IStatus.INFO, "xyz", 123,
						"hello", null)));
	}

	/**
	 * Tests of the compound Status types...
	 */
	@Test
	public void testCompoundStatus() {
		final Status s1 = new Status(IStatus.INFO, "xyz", "1");
		final Status s2 = new Status(IStatus.WARNING, "xyz", "2");
		final MultiStatus s = new MultiStatus("xyz", 100, "compound", null);

		s.add(s1);
		s.add(s2);

		assertEquals(
				"MultiStatus[xyz, WARNING, \"compound\", 100] contains {\n"
						+ "Status[xyz, INFO, \"1\", 0]\n"
						+ "Status[xyz, WARNING, \"2\", 0]\n" + "}",
				TSStatusUtils.toString(s));
	}
}
