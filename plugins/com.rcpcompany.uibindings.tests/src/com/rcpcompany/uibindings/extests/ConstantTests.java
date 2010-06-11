package com.rcpcompany.uibindings.extests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rcpcompany.uibindings.internal.InternalConstants;

public class ConstantTests {

	@Test
	public void testExtensionPointConstants() {
		assertEquals("com.rcpcompany.uibindings.uiBindings", InternalConstants.UIBINDINGS_EXTENSION_POINT);
	}
}
