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

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;

/**
 * Tests of all used property names in the expression related extension points.
 * <p>
 * Only the extension points remotely relevant for RCP plug-ins are included here.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UsedPropertyNamesTest {
	/**
	 * List with all defined property names (UI Bindings, Eclipse, etc)
	 */
	private final List<String> myNames = new ArrayList<String>();

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();

		for (final IConfigurationElement ce : Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.core.expressions.propertyTesters")) {
			if (!ce.getName().equals("propertyTester")) {
				continue;
			}

			final String ns = ce.getAttribute("namespace");
			for (final String p : ce.getAttribute("properties").split(",")) {
				final String prop = ns + "." + p;
				myNames.add(prop);
			}
		}

		final IServiceLocator locator = PlatformUI.getWorkbench();

		final ISourceProviderService sourceProviders = (ISourceProviderService) locator
				.getService(ISourceProviderService.class);

		for (final ISourceProvider sp : sourceProviders.getSourceProviders()) {
			if (!sp.getClass().getName().startsWith(Activator.ID)) {
				continue;
			}
			for (final String n : sp.getProvidedSourceNames()) {
				myNames.add(n);
			}
		}
	}

	/**
	 * Tests used property named in handlers extension point.
	 */
	@Test
	public void testUsedPropertiesUIHandlers() {
		testUsedSources("org.eclipse.ui.handlers");
	}

	/**
	 * Tests used property named in menus extension point.
	 */
	@Test
	public void testUsedPropertiesUIMenus() {
		testUsedSources("org.eclipse.ui.menus");
	}

	/**
	 * Tests used property named in activities extension point.
	 */
	@Test
	public void testUsedPropertiesUIActivities() {
		testUsedSources("org.eclipse.ui.activities");
	}

	/**
	 * Tests used property named in popupMenus extension point.
	 */
	@Test
	public void testUsedPropertiesUIPopupMenus() {
		testUsedSources("org.eclipse.ui.popupMenus");
	}

	/**
	 * Tests used property named in propertyPages extension point.
	 */
	@Test
	public void testUsedPropertiesUIPropertyPages() {
		testUsedSources("org.eclipse.ui.propertyPages");
	}

	/**
	 * Tests used property named in definitions extension point.
	 */
	@Test
	public void testUsedPropertiesExpressionsDefinitions() {
		testUsedSources("org.eclipse.core.expressions.definitions");
	}

	/**
	 * Tests used property named in modelProviders extension point.
	 */
	@Test
	public void testUsedPropertiesModelProviders() {
		testUsedSources("org.eclipse.core.resources.modelProviders");
	}

	/**
	 * Tests used property named in variableResolvers extension point.
	 */
	@Test
	public void testUsedPropertiesVariableResolvers() {
		testUsedSources("org.eclipse.core.resources.variableResolvers");
	}

	private void testUsedSources(String epName) {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();
		for (final IConfigurationElement ce : registry.getConfigurationElementsFor(epName)) {
			if (!ce.getContributor().getName().startsWith(Activator.ID)) {
				continue;
			}
			testUsedSourcesElement(ce);
		}
	}

	private void testUsedSourcesElement(IConfigurationElement ce) {
		if (ce.getName().equals("test")) {
			final String attribute = ce.getAttribute("property");
			if (attribute != null && attribute.length() != 0) {
				assertTrue(attribute + " not present", myNames.contains(attribute));
			}
		}
		for (final IConfigurationElement cce : ce.getChildren()) {
			testUsedSourcesElement(cce);
		}
	}

}
