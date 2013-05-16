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
package com.rcpcompany.uibindings.navigator.extests.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.navigator.IEditorInformation;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.internal.NavigatorConstants;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;

/**
 * Tests the basic properties of the {@link IEditorManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NavigatorModelManagerTest {
	/**
	 * Tests that there are exactly one manager
	 */
	@Test
	public void oneAndOnlyOne() {
		final INavigatorManager manager = INavigatorManager.Factory.getManager();
		assertNotNull(manager);

		assertEquals(manager, INavigatorManager.Factory.getManager());
	}

	@Test
	public void testExtensionReader() {
		final List<IConfigurationElement> editorList = new ArrayList<IConfigurationElement>();
		final List<IConfigurationElement> navigatorList = new ArrayList<IConfigurationElement>();

		final IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		for (final IConfigurationElement element : extensionRegistry
				.getConfigurationElementsFor(NavigatorConstants.EDITORS_EXTENSION_POINT)) {
			if (element.getName().equals(NavigatorConstants.EDITOR_TAG)) {
				editorList.add(element);
			} else if (element.getName().equals(NavigatorConstants.NAVIGATOR_TAG)) {
				navigatorList.add(element);
			} else if (element.getName().equals(NavigatorConstants.PREFERENCE_MODEL_TYPE_TAG)) {
				// navigatorList.add(element);
			} else {
				fail("Unknown element " + element.getName());
			}
		}

		assertEquals(9, editorList.size());
		assertEquals(2, navigatorList.size());

		final INavigatorManager manager = INavigatorManager.Factory.getManager();

		assertNotNull(manager);

		final EList<IEditorPartDescriptor> editors = manager.getDescriptors();
		assertNotNull(editors);
		assertEquals(9, editors.size());

		final EList<IEditorInformation> eis = manager.getEditorInformations();
		assertNotNull(eis);
		/*
		 * Can grow over time based on other configuration - so it depends on the test sequence
		 */
		assertTrue(eis.size() >= 4);

		boolean shopSeen = false;
		boolean countrySeen = false;

		for (final IEditorInformation mt : manager.getEditorInformations()) {
			final String modelType = mt.getModelType();
			if (modelType == null) {
				continue;
			}
			if (modelType.equals(Shop.class.getName())) {
				assertEquals(Shop.class.getName(), modelType);
				final EList<IEditorPartDescriptor> shopEditors = mt.getEditors();
				assertEquals(3, shopEditors.size());
				shopSeen = true;
			}
			if (modelType.equals(Country.class.getName())) {
				assertEquals(Country.class.getName(), modelType);
				final EList<IEditorPartDescriptor> countryEditors = mt.getEditors();
				assertEquals(1, countryEditors.size());
				final IEditorPartDescriptor countryED = countryEditors.get(0);
				assertNotNull(countryED.getFactory());
				assertEquals("Generic Information (country)", countryED.getName());
				countrySeen = true;
			}
		}

		assertTrue(shopSeen);
		assertTrue(countrySeen);
	}

	/**
	 * Tests {@link INavigatorManager#getEditorInformation(String)}.
	 */
	@Test
	public void testGetInformationContainer() {
		final IManager manager = IManager.Factory.getManager();
		final INavigatorManager nmanager = INavigatorManager.Factory.getManager();

		assertNotNull(manager.getTreeItem("com.rcpcompany.uibindings.shop.treeItems.contactFolder"));
		// for (final ITreeItemDescriptor i : manager.getTreeItems()) {
		// LogUtils.debug(this, "i: " + i.getId());
		// }

		final IEditorInformation i = nmanager
				.getEditorInformation("com.rcpcompany.uibindings.shop.treeItems.contactFolder");
		assertNotNull(i);

		assertEquals(1, i.getEditors().size());

		final IEditorPartDescriptor desc = i.getEditors().get(0);
		assertEquals("Test (com.rcpcompany.uibindings.shop.treeItems.contactFolder)", desc.getName());
	}
}
