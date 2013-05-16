/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

import com.rcpcompany.uibindings.internal.Activator;

/**
 * Test the plugins for a valid qualifier: 'qualifier'.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class PluginConfTest {
	private final static Bundle testBundle = Activator.getDefault().getBundle();
	private final static List<String> exceptions = Arrays.asList(new String[] { "" });

	private final Bundle myBundle;

	@Parameters
	public static List<Object[]> data() {
		final List<Object[]> res = new ArrayList<Object[]>();

		// All plugins in target platform

		final Bundle[] bundles = testBundle.getBundleContext().getBundles();
		for (final Bundle bundle : bundles) {
			final String symbolicName = bundle.getSymbolicName();
			if (exceptions.contains(symbolicName)) {
				continue;
			}
			if (!symbolicName.startsWith("com.rcpcompany.")) {
				continue;
			}
			res.add(new Object[] { bundle });
		}

		return res;
	}

	public PluginConfTest(Bundle bundle) {
		myBundle = bundle;
	}

	@Test
	public void testPluginQualifier() {
		final String symbolicName = myBundle.getSymbolicName();
		final Version version = myBundle.getVersion();
		assertEquals("Plugin " + symbolicName + " does not have the correct qualifier '.qualifier': " + version,
				"qualifier", version.getQualifier());
	}
}
