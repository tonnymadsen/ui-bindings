package com.rcpcompany.utils.basic.tests;

import static org.junit.Assert.*;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.junit.Test;

import com.rcpcompany.utils.basic.TSRegistryUtils;

/**
 * Tests of {@link TSRegistryUtils}.
 * 
 * @author Tonny Madsen, tonny.madsen@gmail.com
 */
public class TSRegistryUtilsTest {
	/**
	 * Tests of some basic registry entries
	 */
	@Test
	public void testStandardEntries() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		assertNotNull(registry);

		final IExtension extension = registry.getExtension(
				"org.eclipse.core.runtime.adapters", "test.V1");
		assertNotNull(extension);

		final IConfigurationElement[] ce1 = extension
				.getConfigurationElements();
		assertNotNull(ce1);
		assertEquals(1, ce1.length);
		assertEquals("factory", ce1[0].getName());
		assertEquals(
				"{com.rcpcompany.utils.basic.tests/org.eclipse.core.runtime.adapters[id=test.V1]/factory[class=com.rcpcompany.utils.basic.tests.AdapterFactory1]}",
				TSRegistryUtils.toString(ce1[0]));

		final IConfigurationElement[] ce2 = ce1[0].getChildren();
		assertNotNull(ce2);
		assertEquals(1, ce2.length);
		assertEquals("adapter", ce2[0].getName());
		assertEquals(
				"{com.rcpcompany.utils.basic.tests/org.eclipse.core.runtime.adapters[id=test.V1]/factory[class=com.rcpcompany.utils.basic.tests.AdapterFactory1]/adapter[type=com.rcpcompany.utils.basic.tests.Adapter1]}",
				TSRegistryUtils.toString(ce2[0]));
	}
}
