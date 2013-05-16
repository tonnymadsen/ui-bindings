package com.rcpcompany.uibindings.moao.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Dictionary;

import org.eclipse.core.runtime.Platform;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.osgi.framework.Bundle;

/**
 * Tests the tested bundle dependencies are correct - e.g. it may not depend on org.eclipse.ui...
 * 
 * @author Tonny Madsen, tonny.madsen@gmail.com
 */
public class BundleTest {
	@Rule
	public Timeout globalTimeout = new Timeout(60000); // 60 seconds max per method tested

	@Test
	public void testBundle() {
		final Bundle bundle = Platform.getBundle(this.getClass().getPackage().getName().replace(".tests", ""));
		assertNotNull("no bundle", bundle);

		final Dictionary<String, String> headers = bundle.getHeaders();
		assertNotNull("no headers", headers);

		final String value = headers.get("Require-Bundle");
		assertNotNull(value);
		assertTrue("org.eclipse.ui used", !value.contains("org.eclipse.ui"));
	}
}
