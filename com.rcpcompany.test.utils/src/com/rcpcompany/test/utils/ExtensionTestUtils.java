package com.rcpcompany.test.utils;

/*******************************************************************************
 * Copyright (c) 2006-2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * Various test methods for the extension registry.
 * <p>
 * Provides a number of convenience methods...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ExtensionTestUtils {
	private ExtensionTestUtils() {
	}

	/**
	 * Returns a list of the configuration element with the specific name.
	 * 
	 * @param epName
	 *            the extension point name
	 * @param elementName
	 *            the name
	 * @return the list of found elements
	 */
	public static List<IConfigurationElement> getElements(String epName, String elementName) {
		final List<IConfigurationElement> list = new ArrayList<IConfigurationElement>();

		final IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		for (final IConfigurationElement element : extensionRegistry.getConfigurationElementsFor(epName)) {
			if (element.getName().equals(elementName)) {
				list.add(element);
			}
		}

		return list;
	}

	/**
	 * Tests that the extension points published by the specified bundle also is present as <code>.exsd</code> files in
	 * the bundle.
	 * 
	 * @param bundleName
	 *            the name of the bundle
	 */
	public static void assertSchemaFiles(String bundleName) {
		final Bundle bundle = Platform.getBundle(bundleName);
		assertNotNull(bundle);

		final List<String> foundSchemaFiles = new ArrayList<String>();
		final Enumeration<String> schemaFileEnumerator = bundle.getEntryPaths("schema");
		assertNotNull("No schema/ files in " + bundleName + " (check build.properties)?", schemaFileEnumerator);
		while (schemaFileEnumerator.hasMoreElements()) {
			final String e = schemaFileEnumerator.nextElement();
			if (e.startsWith(".svn") || e.startsWith(".cvs")) {
				continue;
			}
			if (!e.endsWith(".exsd")) {
				continue;
			}
			foundSchemaFiles.add(e);
		}

		// LogUtilities.debug(bundleName, "found files: " + foundSchemaFiles);

		final IExtensionPoint[] extensionPoints = Platform.getExtensionRegistry().getExtensionPoints();
		final List<String> expectedSchemaFiles = new ArrayList<String>();
		for (final IExtensionPoint ep : extensionPoints) {
			if (ep.getContributor().getName().equals(bundleName)) {
				expectedSchemaFiles.add(ep.getSchemaReference());
			}
		}

		// LogUtils.debug(bundleName, "expected: " + expectedSchemaFiles);

		String problems = "";
		for (final String file : foundSchemaFiles) {
			if (!expectedSchemaFiles.contains(file)) {
				problems += "\n  schema " + file + " not expected";
			}
		}
		for (final String file : expectedSchemaFiles) {
			if (!foundSchemaFiles.contains(file)) {
				problems += "\n  schema " + file + " not found";
			}
		}
		if (problems.length() > 0) {
			fail("Problems with schema files of " + bundleName + ":" + problems);
		}
	}
}
