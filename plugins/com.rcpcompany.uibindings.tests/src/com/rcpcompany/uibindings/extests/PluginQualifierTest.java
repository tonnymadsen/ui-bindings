package com.rcpcompany.uibindings.extests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

import com.rcpcompany.uibindings.internal.Activator;

/**
 * Test the plugins for a valid qualifier: 'qualifier' To prevent failing of nightly build
 * 
 * Some plugins are allowed to have no qualifier string, such as those on the target platform
 * 
 * DO NOT ADD TO ALLTEST! Since the qualifiers are changed by the build script the test is
 * invalidated
 * 
 */
public class PluginQualifierTest {
	private final Bundle testBundle = Activator.getDefault().getBundle();

	@Test
	public void testPlugins() {
		// All plugins in target platform
		final List<String> exceptions = Arrays.asList(new String[] { "" });

		final Bundle[] bundles = testBundle.getBundleContext().getBundles();
		for (final Bundle bundle : bundles) {
			final String symbolicName = bundle.getSymbolicName();
			if (exceptions.contains(symbolicName)) {
				// then this is one of the exceptions
				continue;
			}
			if (symbolicName.startsWith("com.rcpcompany.")) {
				final Version version = bundle.getVersion();
				assertEquals(
						"Plugin " + symbolicName + " does not have the correct qualifier '.qualifier': "
								+ version.getQualifier(), "qualifier", version.getQualifier());
			}
		}
	}
}
