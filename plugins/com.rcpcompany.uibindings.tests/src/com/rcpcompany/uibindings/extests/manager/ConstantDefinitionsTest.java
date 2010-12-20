/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.manager;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.themes.ITheme;
import org.eclipse.ui.themes.IThemeManager;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.internal.Activator;

/**
 * Tests that constants from {@link Constants} and {@link InternalConstants} are correct.
 * <p>
 * Also see {@link ManagerArgumentInformationTest} and {@link ContextActivationTest}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ConstantDefinitionsTest {
	/**
	 * Test all of Constants.COLOR_ are present (by reflection)
	 */
	@Test
	public void testCOLOR_Present() {
		final IThemeManager themeManager = PlatformUI.getWorkbench().getThemeManager();
		final ITheme theme = themeManager.getCurrentTheme();
		for (final Field f : Constants.class.getDeclaredFields()) {
			if (!f.getName().startsWith("COLOR_")) {
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

			final ColorDescriptor cd = theme.getColorRegistry().getColorDescriptor((String) v);
			assertNotNull("Declaration for color '" + v + "' missing", cd);
		}
	}

	/**
	 * Test all of Constants.PROPERTY_... are present (by reflection)
	 */
	@Test
	public void testPROPERTY_Present() {
		final Collection<String> properties = new ArrayList<String>();
		for (final IConfigurationElement ce : Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.core.expressions.propertyTesters")) {
			if (!ce.getContributor().getName().equals(Activator.ID)) {
				continue;
			}

			assertEquals(Activator.ID, ce.getAttribute("namespace"));

			Object t = null;
			try {
				t = ce.createExecutableExtension("class");
			} catch (final Exception ex) {
				fail(ex.getMessage());
			}

			assertTrue(t instanceof PropertyTester);

			final String props = ce.getAttribute("properties");
			assertNotNull(props);
			assertTrue(props.length() > 0);

			properties.addAll(Arrays.asList(props.split(",")));
		}
		for (final Field f : Constants.class.getDeclaredFields()) {
			if (!f.getName().startsWith("PROPERTY_")) {
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

			assertNotNull("Declaration for color '" + v + "' missing", properties.contains(v));
		}
	}
}
