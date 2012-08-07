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
package com.rcpcompany.uibindings.extests.manager;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.eclipse.emf.common.util.EMap;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IArgumentInformation;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.InternalConstants;

/**
 * Tests the {@link IManager#getArgumentInfo()} information.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerArgumentInformationTest {
	IArgumentInformation ai;

	/**
	 * Tests a proper error message is used for all unknown argument names
	 */
	@Test
	public void testUnknown() {
		final IManager manager = IManager.Factory.getManager();
		final EMap<String, IArgumentInformation> ais = manager.getArgumentInformation();
		String name = null;
		for (int i = 1000; i < 1000000; i++) {
			name = "unknown" + i;
			if (!ais.containsKey(name)) {
				break;
			}
		}
		final String n = name;
		assertOneLog(new Runnable() {
			@Override
			public void run() {
				ai = manager.getArgumentInformation(n);
			}
		});

		assertNotNull(ai);
		assertEquals(name, ai.getName());
		assertEquals(true, ai.isLookupParent());
		assertEquals(false, ai.isLookupAttributeTargetType());
		assertEquals(true, ai.isLookupAttributeContainingClass());
		assertEquals(true, ai.isLookupReferenceTargetType());
		assertEquals(false, ai.isLookupReferenceContainingClass());

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				ai = manager.getArgumentInformation(n);
			}
		});
	}

	/**
	 * Test values for the format argument
	 */
	@Test
	public void testFormatArgument() {
		final IManager manager = IManager.Factory.getManager();
		final IArgumentInformation ai = manager.getArgumentInformation().get(Constants.ARG_MESSAGE_FORMAT);

		assertNotNull(ai);
		assertEquals("format", ai.getName());
		assertEquals(true, ai.isLookupParent());
		assertEquals(true, ai.isLookupAttributeTargetType());
		assertEquals(false, ai.isLookupAttributeContainingClass());
		assertEquals(false, ai.isLookupReferenceTargetType());
		assertEquals(false, ai.isLookupReferenceContainingClass());
	}

	/**
	 * Test values for the image argument
	 */
	@Test
	public void testImageArgument() {
		final IManager manager = IManager.Factory.getManager();
		final IArgumentInformation ai = manager.getArgumentInformation().get(Constants.ARG_IMAGE);

		assertNotNull(ai);
		assertEquals("image", ai.getName());
		assertEquals(true, ai.isLookupParent());
		assertEquals(false, ai.isLookupAttributeTargetType());
		assertEquals(true, ai.isLookupAttributeContainingClass());
		assertEquals(true, ai.isLookupReferenceTargetType());
		assertEquals(false, ai.isLookupReferenceContainingClass());
	}

	/**
	 * Test all of Constants.ARG_... are present (by reflection)
	 */
	@Test
	public void testARG_Present() {
		for (final Field f : Constants.class.getDeclaredFields()) {
			if (!f.getName().startsWith("ARG_")) {
				continue;
			}

			Object v = null;
			try {
				v = f.get(null);
			} catch (final Exception ex) {
				fail(ex.getMessage());
			}

			assertNotNull("Value of Constants." + f.getName(), v);
			assertTrue("Value of Constants." + f.getName(), v instanceof String);

			final IArgumentInformation ai = IManager.Factory.getManager().getArgumentInformation().get(v);
			assertNotNull(InternalConstants.ARGUMENT_INFO_TAG + " declaration for '" + v + "' missing", ai);
		}
	}

	/**
	 * Test all of Constants.EXT_POINT_ATTRIBUTE_NAMES are present.
	 */
	@Test
	public void testEXT_POINT_ATTRIBUTE_NAMESPresent() {
		for (final String v : Constants.EXT_POINT_ATTRIBUTE_NAMES) {
			final IArgumentInformation ai = IManager.Factory.getManager().getArgumentInformation().get(v);
			assertNotNull(InternalConstants.ARGUMENT_INFO_TAG + " declaration for '" + v + "' missing", ai);
		}
	}
}
