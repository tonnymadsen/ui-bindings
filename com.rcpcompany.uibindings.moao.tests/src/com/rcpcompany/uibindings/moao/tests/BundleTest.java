package com.rcpcompany.uibindings.moao.tests;

import static org.junit.Assert.*;

import java.util.Dictionary;

import org.eclipse.core.runtime.Platform;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * Tests the MOAO bundle is correct - e.g. it may not depend on
 * org.eclipse.ui...
 * 
 * @author Tonny Madsen, tma@bording.dk
 */
public class BundleTest {
	@Test
	public void testBundle() {
		final Bundle bundle = Platform
				.getBundle("com.rcpcompany.uibindings.moao");
		assertNotNull("no bundle", bundle);

		final Dictionary<String, String> headers = bundle.getHeaders();
		assertNotNull("no headers", headers);

		final String value = headers.get("Require-Bundle");
		assertNotNull(value);
		assertTrue("org.eclipse.ui used", !value.contains("org.eclipse.ui"));
	}
}
