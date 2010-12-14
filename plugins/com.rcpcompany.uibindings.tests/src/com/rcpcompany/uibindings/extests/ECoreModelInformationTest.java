package com.rcpcompany.uibindings.extests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EPackage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ECoreModelInformationTest {

	private final IConfigurationElement myCE;

	@Parameters
	public static List<Object[]> data() {
		final List<Object[]> ces = new ArrayList<Object[]>();

		for (final IConfigurationElement ce : Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.emf.ecore.generated_package")) {
			if (!"package".equals(ce.getName())) {
				continue;
			}
			final String pluginName = ce.getContributor().getName();
			if (!pluginName.startsWith("com.rcpcompany.uibindings")) {
				continue;
			}

			ces.add(new Object[] { ce });
		}

		return ces;
	}

	public ECoreModelInformationTest(IConfigurationElement ce) {
		myCE = ce;
	}

	@Test
	public void testModelInfo() {
		final String pluginName = myCE.getContributor().getName();
		final String nsURI = myCE.getAttribute("uri");
		assertNotNull(nsURI);
		EPackage ePackage = null;
		try {
			ePackage = EPackage.Registry.INSTANCE.getEPackage(nsURI);
		} catch (final WrappedException ex) {
			fail(ex.getMessage());
		}
		assertNotNull(ePackage);
		// LogUtils.debug(pluginName, "checking " + ePackage.getName() + " from " + pluginName);
		assertTrue("Inconsistent URI: " + nsURI, nsURI.startsWith("http://rcp-company.com/schemas/uibindings/"));
	}
}
