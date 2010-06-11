package com.rcpcompany.uibindings.extests;

import static org.junit.Assert.assertNotNull;

import org.eclipse.jface.resource.JFaceResources;
import org.junit.Test;

public class ColorsAndFontsTests {

	@Test
	public void testColors() {
		assertNotNull(JFaceResources.getColorRegistry().get("ACTIVE_HYPERLINK_COLOR"));
		assertNotNull(JFaceResources.getColorRegistry().get(
				"com.rcpcompany.uibindings.colorDefinitions.EvenRowBackground"));
	}
}
