package com.rcpcompany.uibindings.navigator.extests.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.junit.Test;

import com.rcpcompany.uibindings.navigator.IEditiorModelType;
import com.rcpcompany.uibindings.navigator.IEditorDescriptor;
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

		assertEquals(4, list.size());

		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();

		assertNotNull(manager);

		final EMap<String, IEditiorModelType> modelTypes = manager.getModelTypes();
		assertNotNull(modelTypes);
		assertEquals(2, modelTypes.size());

		final IEditiorModelType shopModelType = modelTypes.get(Shop.class.getName());
		assertNotNull(shopModelType);
		assertEquals(Shop.class.getName(), shopModelType.getModelType());
		final EList<IEditorDescriptor> shopEditors = shopModelType.getEditors();
		assertEquals(3, shopEditors.size());

		final IEditiorModelType countryModelType = modelTypes.get(Country.class.getName());
		assertNotNull(countryModelType);
		assertEquals(Country.class.getName(), countryModelType.getModelType());
		final EList<IEditorDescriptor> countryEditors = countryModelType.getEditors();
		assertEquals(1, countryEditors.size());
		final IEditorDescriptor countryED = countryEditors.get(0);
		assertNotNull(countryED.getFactory());
		assertEquals("Generic Information (country)", countryED.getName());
	}
}
