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

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IEMFObservableFactory;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IModelClassInfo;
import com.rcpcompany.uibindings.IModelFeatureInfo;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.internal.InternalConstants;
import com.rcpcompany.uibindings.internal.observableFactories.DefaultEMFObservableFactory;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

public class ManagerBasicFunctionalityTest {

	private IManager m;

	@Before
	public void setup() {
		resetAll();
		m = IManager.Factory.getManager();
	}

	/**
	 * Tests for {@link IManager#getManager()}.
	 */
	@Test
	public void testGetManager() {
		assertNotNull(m);

		final IManager manager2 = IManager.Factory.getManager();
		assertEquals(m, manager2);
	}

	/**
	 * Tests for {@link IManager#getProviders()}.
	 */
	@Test
	public void testGetProviders() {
		final List<IDecoratorProvider> providers = m.getProviders();

		for (final IDecoratorProvider dp : providers) {
			assertNotNull(dp.getId());
			assertNotNull("provider: " + dp.getId(), dp.getType());
			assertNotNull("provider: " + dp.getId(), dp.getProviderCE());
			assertNotNull("provider: " + dp.getId(), dp.getChildCE());
			assertNotNull("provider: " + dp.getId(), dp.getDecorator());
			assertTrue("provider: " + dp.getId(), dp.getModelTypes().size() >= 0);
			assertTrue("provider: " + dp.getId(), dp.getUiTypes().size() > 0);
		}
	}

	@Test
	public void testGetClipboard() {
		final Clipboard clipboard = m.getClipboard();
		assertNotNull(clipboard);
	}

	@Test
	public void testGetEditingDomain() {
		// Has a default value
		final EditingDomain domainOrig = m.getEditingDomain();
		assertNotNull(domainOrig);

		// Automatically reset if nulled
		m.setEditingDomain(null);
		final EditingDomain domain = m.getEditingDomain();
		assertNotNull(domain);
		assertNotSame(domainOrig, domain);

		// But keeps its value...
		final EditingDomain newDomain = UIBindingsUtils.createEditingDomain();
		m.setEditingDomain(newDomain);
		assertEquals(newDomain, m.getEditingDomain());

		// Reset to original value
		m.setEditingDomain(domainOrig);
	}

	@Test
	public void testGetFormToolkit() {
		// Has a default value
		final FormToolkit toolkitOrig = m.getFormToolkit();
		assertNotNull(toolkitOrig);

		// Automatically reset if nulled
		m.setFormToolkit(null);
		final FormToolkit toolkit = m.getFormToolkit();
		assertNotNull(toolkit);
		assertNotSame(toolkitOrig, toolkit);

		// But keeps its value...
		final FormToolkit newToolkit = new FormToolkit(Display.getCurrent());
		m.setFormToolkit(newToolkit);
		assertEquals(newToolkit, m.getFormToolkit());

		// Reset to original value
		m.setFormToolkit(toolkitOrig);
	}

	@Test
	public void testGetObservableFactory() {
		final TestObject to = TestModelFactory.eINSTANCE.createTestObject();
		IEMFObservableFactory factory = m.getObservableFactory(to);
		assertEquals(DefaultEMFObservableFactory.class, factory.getClass());

		final Shop shop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());

		factory = m.getObservableFactory(shop);
		assertEquals(ShopEMFObservableFactory.class, factory.getClass());
	}

	@Test
	public void testGetModelClassInfo() {
		IModelClassInfo ci = m.getModelClassInfo(Contact.class.getName(), null, false);
		assertNotNull(ci);
		final Object object = ci.getArguments().get("hello");
		assertTrue(object instanceof IConfigurationElement);
		assertEquals("olleh", ((IConfigurationElement) object).getAttribute(InternalConstants.VALUE_TAG));

		ci = m.getModelClassInfo(IModelClassInfo.class.getName(), null, false);
		assertEquals(null, ci);
	}

	@Test
	public void testGetModelClassInfoWithType() {
		IModelClassInfo ci = m.getModelClassInfo(Contact.class.getName(), "subtype", false);
		assertNotNull(ci);
		final Object object = ci.getArguments().get("hello");
		assertTrue(object instanceof IConfigurationElement);
		assertEquals("ollehsub", ((IConfigurationElement) object).getAttribute(InternalConstants.VALUE_TAG));

		ci = m.getModelClassInfo(IModelClassInfo.class.getName(), "subtype", false);
		assertEquals(null, ci);
	}

	@Test
	public void testGetModelFeatureInfo() {
		IModelFeatureInfo ci = m.getModelFeatureInfo(Contact.class.getName(),
				ShopPackage.Literals.CONTACT__CITY.getName(), null, false);
		assertNotNull(ci);
		final Object object = ci.getArguments().get("foo");
		assertTrue(object instanceof IConfigurationElement);
		assertEquals("bar", ((IConfigurationElement) object).getAttribute(InternalConstants.VALUE_TAG));

		ci = m.getModelFeatureInfo(IModelClassInfo.class.getName(), ShopPackage.Literals.CONTACT__CITY.getName(), null,
				false);
		assertEquals(null, ci);
	}

	@Test
	public void testGetModelFeatureInfoWithType() {
		IModelFeatureInfo ci = m.getModelFeatureInfo(Contact.class.getName(),
				ShopPackage.Literals.CONTACT__CITY.getName(), "subtype", false);
		assertNotNull(ci);
		final Object object = ci.getArguments().get("foo");
		assertTrue(object instanceof IConfigurationElement);
		assertEquals("barsub", ((IConfigurationElement) object).getAttribute(InternalConstants.VALUE_TAG));

		ci = m.getModelFeatureInfo(IModelClassInfo.class.getName(), ShopPackage.Literals.CONTACT__CITY.getName(),
				"subfeature", false);
		assertEquals(null, ci);
	}

}
