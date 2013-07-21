package com.rcpcompany.utils.extensionpoints.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IViewPart;
import org.junit.Rule;
import org.junit.Test;

import com.rcpcompany.test.utils.rap.rules.RAPFixture;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;

public class CEObjectHolderTest {
	@Rule
	public RAPFixture rap = new RAPFixture();

	@Test
	public void testHolders() {
		final IExtension ex = Platform.getExtensionRegistry()
				.getExtension("com.rcpcompany.utils.extensionpoints.tests");
		assertNotNull(ex);
		assertEquals("org.eclipse.ui.views", ex.getExtensionPointUniqueIdentifier());
		for (final IConfigurationElement ce : ex.getConfigurationElements()) {
			final CEObjectHolder<IViewPart> ceoh = new CEObjectHolder<IViewPart>(ce);
			assertEquals(ce, ceoh.getConfigurationElement());
			final IViewPart o = ceoh.getObject();
			assertNotNull(o);
			assertTrue(o instanceof ViewPart1);
			assertEquals(o, ceoh.getObject());

			final CEResourceHolder cerh = new CEResourceHolder(ce, "icon");
			final ImageDescriptor id = cerh.getImageDescriptor();
			assertNotNull(id);
			assertEquals(id, cerh.getImageDescriptor());

			final Image i = cerh.getImage();
			assertNotNull(i);
			assertEquals(i, cerh.getImage());
		}
	}
}
