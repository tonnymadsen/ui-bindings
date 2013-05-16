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

import static com.rcpcompany.test.utils.OSGiTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.BundleSpecification;
import org.eclipse.osgi.service.resolver.PlatformAdmin;
import org.eclipse.osgi.service.resolver.State;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Test the setup of specified bundles.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class PluginSpecificationTest {
	private final String myId;

	@Parameters
	public static List<Object[]> data() {
		final Object[][] res = new Object[][] {

		{ "com.rcpcompany.utils.basic" },

		{ "com.rcpcompany.utils.logging" },

		{ "com.rcpcompany.utils.extensionpoints" },

		{ "com.rcpcompany.uibindings.moao" },

		{ "com.rcpcompany.uibindings.model.utils" },

		};
		return Arrays.asList(res);
	}

	public PluginSpecificationTest(String id) {
		myId = id;
	}

	@Test
	public void testDependencies() {
		final PlatformAdmin platformAdmin = getPlatformAdmin();

		final State state = platformAdmin.getState(false);
		final BundleDescription[] bundles = state.getBundles(myId);
		assertEquals(1, bundles.length);

		final BundleDescription b = bundles[0];
		for (final BundleSpecification bs : b.getRequiredBundles()) {
			final String bsName = bs.getName();
			assertNotSame("org.eclipse.ui", bsName);
			if ("org.junit".equals(bsName)) {
				assertTrue(!bs.isOptional());
			}
		}
	}
}
