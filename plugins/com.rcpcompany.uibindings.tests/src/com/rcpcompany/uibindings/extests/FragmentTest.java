/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.PlatformAdmin;
import org.eclipse.osgi.service.resolver.State;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.osgi.framework.Bundle;

import com.rcpcompany.uibindings.internal.Activator;

/**
 * Test the needed fragments are enabled
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class FragmentTest {
	private final static Bundle testBundle = Activator.getDefault().getBundle();
	private final static List<String> exceptions = Arrays.asList(new String[] { "" });

	private final String myId;

	@Parameters
	public static List<Object[]> data() {
		final Object[][] res = new Object[][] {

		{ "com.rcpcompany.uibindings.fragments.ecore" },

		{ "com.rcpcompany.uibindings.fragments.jface" },

		};
		return Arrays.asList(res);
	}

	public FragmentTest(String id) {
		myId = id;
	}

	@Test
	public void testFragmentIsEnabled() {
		final PlatformAdmin platformAdmin = getPlatformAdmin();

		final State state = platformAdmin.getState(false);
		final BundleDescription[] bundles = state.getBundles(myId);
		assertEquals(1, bundles.length);

		final BundleDescription b = bundles[0];

		assertNotNull(b.getHost());
		assertTrue(b.isResolved());
	}
}
