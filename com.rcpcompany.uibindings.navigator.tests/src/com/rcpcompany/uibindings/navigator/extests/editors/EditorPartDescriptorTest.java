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
package com.rcpcompany.uibindings.navigator.extests.editors;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.navigator.IEditorInformation;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.extests.NavigatorTestUtils;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;

/**
 * Tests retrieval of {@link IEditorPartDescriptor}
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class EditorPartDescriptorTest {
	private INavigatorManager myManager;
	private final boolean myUseGenericEditorPartFallback;

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] {

				// useGenericEditorPartFallback
				{ false }, { true }

		});
	}

	public EditorPartDescriptorTest(boolean useGenericEditorPartFallback) {
		myUseGenericEditorPartFallback = useGenericEditorPartFallback;

	}

	@Before
	public void before() {
		NavigatorTestUtils.resetAll();
		myManager = INavigatorManager.Factory.getManager();
		myManager.setUseGenericEditorPartFallback(myUseGenericEditorPartFallback);
	}

	/**
	 * Tests <code>null</code> return <code>null</code>
	 */
	@Test
	public void test() {
		testOne(null, null);
		if (myUseGenericEditorPartFallback) {
			testOne("org.eclipse.emf.ecore.EObject.generic", EcoreFactory.eINSTANCE.createEObject());
		} else {
			testOne(null, EcoreFactory.eINSTANCE.createEObject());
		}
		testOne("com.rcpcompany.uibindings.tests.editors.editors.basic", ShopFactory.eINSTANCE.createShop());
		testOne("com.rcpcompany.uibindings.tests.editors.editors.generic.country",
				ShopFactory.eINSTANCE.createCountry());
		testOne("com.rcpcompany.uibindings.tests.editors.editors.generic.shopinformation",
				ShopFactory.eINSTANCE.createShopItemURL());
	}

	/**
	 * Tests a single object against a specific ID...
	 * 
	 * @param id the expected object or <code>null</code> if no descriptor should be found
	 * @param obj the object to find
	 */
	private void testOne(String id, EObject obj) {
		final IEditorPartDescriptor desc = myManager.getEditorPartDescriptor(obj);
		if (id == null) {
			assertEquals(null, desc);
		} else {
			assertNotNull("Description missing for " + id, desc);
			assertEquals(id, desc.getId());
		}
	}

	/**
	 * Tests {@link IEditorInformation#getPreferredEditor()}.
	 */
	@Test
	public void testPreferred() {
		/*
		 * Find the model type with multiple editors.
		 */
		IEditorInformation mt = null;
		for (final IEditorInformation m : myManager.getEditorInformations()) {
			if (m.getEditors().size() > 1) {
				mt = m;
				break;
			}
		}
		assertNotNull(mt);

		final IEditorPartDescriptor first = mt.getEditors().get(0);
		final IEditorPartDescriptor second = mt.getEditors().get(1);

		assertEquals(first, mt.getPreferredEditor());

		mt.setPreferredEditor(second);
		assertEquals(second, mt.getPreferredEditor());

		mt.setPreferredEditor(null);
		assertEquals(first, mt.getPreferredEditor());
	}
}
