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
package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests that the editing domain of a context is correct.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ContextEditingDomainTest {

	private TestView myView;
	private IFormCreator myForm;

	@Before
	public void before() {
		resetAll();

		createView();

		myView.getSite().getPage().activate(myView);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);

		final Shop shop = ShopFactory.eINSTANCE.createShop();

		myForm = myView.createFormCreator(shop);
		myForm.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testED() {
		final IManager manager = IManager.Factory.getManager();
		final IBindingContext context = myForm.getContext();

		assertEquals(manager.getEditingDomain(), context.getEditingDomain());

		final EditingDomain newManagerEditingDomain = UIBindingsUtils.createEditingDomain();
		assertNotSame(newManagerEditingDomain, manager.getEditingDomain());

		manager.setEditingDomain(newManagerEditingDomain);
		assertEquals(newManagerEditingDomain, manager.getEditingDomain());
		assertEquals(manager.getEditingDomain(), context.getEditingDomain());

		final EditingDomain newContextEditingDomain = UIBindingsUtils.createEditingDomain();
		assertNotSame(newContextEditingDomain, manager.getEditingDomain());

		context.setEditingDomain(newContextEditingDomain);
		assertEquals(newContextEditingDomain, context.getEditingDomain());
		assertNotSame(manager.getEditingDomain(), context.getEditingDomain());

		context.setEditingDomain(null);
		assertEquals(manager.getEditingDomain(), context.getEditingDomain());
	}
}
