package com.rcpcompany.uibindings.extests;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
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
import org.osgi.framework.Bundle;

import com.rcpcompany.uibindings.internal.Activator;

/**
 * Test the setup of specified bundles.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class PluginSpecificationTest {
	private final static Bundle testBundle = Activator.getDefault().getBundle();

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
			if ("org.junit4".equals(bsName)) {
				assertTrue(!bs.isOptional());
			}

		}
	}
}
