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
package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IBindingObjectLongName;

/**
 * Test of {@link IBindingObjectLongName}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingObjectLongNameTest {
	protected Shop myShop;
	private TestObject myTO;

	@Before
	public void before() {
		resetAll();
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("hello");

		myTO = TestModelFactory.eINSTANCE.createTestObject();
		myTO.setNumber(42);
	}

	@Test
	public void testLongNameObject() {
		final IBindingObjectLongName nl = IBindingObjectLongName.Factory.createLongName(myShop, null);

		assertEquals("hello", nl.getName());

		myShop.setName("ohh no");
		assertEquals("ohh no", nl.getName());

		nl.dispose();
		assertEquals("<null>", nl.getName());
	}

	@Test
	public void testLongNameString() {
		assertEquals("hello", IBindingObjectLongName.Factory.getLongName(myShop));
		assertEquals("<null>", IBindingObjectLongName.Factory.getLongName((EObject) null));
	}

	@Test
	public void testLongNameSelection() {
		assertEquals("hello, 42",
				IBindingObjectLongName.Factory.getLongName(new StructuredSelection(new Object[] { myShop, myTO })));
		// Ignore non-eobjs
		assertEquals(
				"hello, 42",
				IBindingObjectLongName.Factory.getLongName(new StructuredSelection(new Object[] { myShop, myTO,
						"no way" })));
		assertEquals("42", IBindingObjectLongName.Factory.getLongName(new StructuredSelection(myTO)));
	}
}
