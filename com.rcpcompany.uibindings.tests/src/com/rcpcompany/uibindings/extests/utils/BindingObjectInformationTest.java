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
package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;

/**
 * Test of {@link IBindingObjectInformation}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingObjectInformationTest {
	protected Shop myShop;
	private TestObject myTO;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("hello");

		myTO = TestModelFactory.eINSTANCE.createTestObject();
		myTO.setNumber(42);
	}

	@Test
	public void testLongNameShopObject() {
		final IBindingObjectInformation nl = IBindingObjectInformation.Factory.createObjectInformation(myShop, null);

		assertEquals("hello", nl.getName());
		assertEquals("Shop", nl.getLabel());

		myShop.setName("ohh no");
		assertEquals("hello", nl.getName());
		assertEquals("Shop", nl.getLabel());

		nl.dispose();
		assertEquals("hello", nl.getName());
		assertEquals("Shop", nl.getLabel());
	}

	@Test
	public void testLongNameTOObject() {
		final IBindingObjectInformation nl = IBindingObjectInformation.Factory.createObjectInformation(myTO, null);

		assertEquals("42", nl.getName());
		assertEquals("Test Object", nl.getLabel());
	}

	@Test
	public void testLongNameString() {
		assertEquals("hello", IBindingObjectInformation.Factory.getLongName(myShop));
		assertEquals("<null>", IBindingObjectInformation.Factory.getLongName((EObject) null));
	}

	@Test
	public void testLongNameSelection() {
		assertEquals("hello, 42",
				IBindingObjectInformation.Factory.getLongName(new StructuredSelection(new Object[] { myShop, myTO })));
		// Ignore non-eobjs
		assertEquals(
				"hello, 42",
				IBindingObjectInformation.Factory.getLongName(new StructuredSelection(new Object[] { myShop, myTO,
						"no way" })));
		assertEquals("42", IBindingObjectInformation.Factory.getLongName(new StructuredSelection(myTO)));
	}
}
