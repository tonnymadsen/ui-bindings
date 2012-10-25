package com.rcpcompany.uibindings.moao.tests;

import static org.junit.Assert.*;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.junit.Test;

import com.rcpcompany.uibindings.moao.IMOAOPackage;

/**
 * Tests of various important aspects of the MOAO model.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MOAOPackageTest {
	/**
	 * Tests the NS URI.
	 */
	@Test
	public void testNS() {
		final String nsURI = IMOAOPackage.eNS_URI;
		assertTrue("NS URI",
				nsURI.startsWith("http://rcp-company.com/schemas/"));
	}

	/**
	 * Tests the org.eclipse.emf.ecore.generated_package extension for the
	 * model.
	 */
	@Test
	public void testExtension() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		for (final IConfigurationElement ce : registry
				.getConfigurationElementsFor("org.eclipse.emf.ecore.generated_package")) {
			if (!ce.getContributor().getName()
					.equals("com.rcpcompany.uibindings.moao")) {
				continue;
			}

			assertEquals("element type", "package", ce.getName());
			assertEquals("URI", IMOAOPackage.eNS_URI, ce.getAttribute("uri"));

			assertEquals("server class", IMOAOPackage.class.getName(),
					ce.getAttribute("class"));
			assertEquals("genModel", "model/moao.xcore",
					ce.getAttribute("genModel"));
		}
	}
}
