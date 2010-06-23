package com.rcpcompany.uibindings.navigator.extests.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
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
		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();
		assertNotNull(manager);

		assertEquals(manager, INavigatorModelFactory.eINSTANCE.getManager());
	}

	@Test
	public void testExtensionReader() {
		final List<IConfigurationElement> list = new ArrayList<IConfigurationElement>();

		final IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		for (final IConfigurationElement element : extensionRegistry
				.getConfigurationElementsFor(NavigatorConstants.EDITORS_EXTENSION_POINT)) {
			if (element.getName().equals(NavigatorConstants.EDITOR_TAG)) {
				list.add(element);
			}
		}

		assertEquals(7, list.size());

		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();

		assertNotNull(manager);

		final EList<IEditorModelType> modelTypes = manager.getModelTypes();
		assertNotNull(modelTypes);
		assertEquals(4, modelTypes.size());

		for (final IEditorModelType mt : manager.getModelTypes()) {
			if (mt.getModelType().equals(Shop.class.getName())) {
				assertEquals(Shop.class.getName(), mt.getModelType());
				final EList<IEditorPartDescriptor> shopEditors = mt.getEditors();
				assertEquals(3, shopEditors.size());
			}
			if (mt.getModelType().equals(Country.class.getName())) {
				assertEquals(Country.class.getName(), mt.getModelType());
				final EList<IEditorPartDescriptor> countryEditors = mt.getEditors();
				assertEquals(1, countryEditors.size());
				final IEditorPartDescriptor countryED = countryEditors.get(0);
				assertNotNull(countryED.getFactory());
				assertEquals("Generic Information (country)", countryED.getName());
			}
		}
	}
}
