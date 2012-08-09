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
package com.rcpcompany.uibindings.navigator.extests.editors;

import static org.junit.Assert.*;

import java.util.Collection;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.test.utils.UITestUtils;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.extests.NavigatorTestUtils;
import com.rcpcompany.uibindings.navigator.internal.handlers.OpenHandler;
import com.rcpcompany.uibindings.navigator.internal.propertyTesters.EObjectPropertyTester;
import com.rcpcompany.uibindings.navigator.views.NavigatorBaseView;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Tests {@link OpenHandler} and {@link EObjectPropertyTester} used for
 * <code>com.rcpcompany.uibindings.commands.openBinding</code>.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OpenBindingTest {
	private INavigatorManager myManager;
	private Shop myShop;
	private ShopItem myShopItem;
	private Country myCountry;
	private NavigatorBaseView myNavigatorView;
	private ICommandService myCS;
	private IHandlerService myHS;
	private ParameterizedCommand myCommand;

	@Before
	public void before() {
		NavigatorTestUtils.resetAll();
		myManager = INavigatorManager.Factory.getManager();

		myShop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());

		myCountry = myShop.getCountries().get(0);

		myShopItem = myShop.getShopItems().get(0);

		myNavigatorView = (NavigatorBaseView) UITestUtils
				.showView("com.rcpcompany.uibindings.navigator.extests.NavigatorView");
		assertNotNull(myNavigatorView);
		myCS = (ICommandService) myNavigatorView.getSite().getService(ICommandService.class);
		assertNotNull(myCS);
		myHS = (IHandlerService) myNavigatorView.getSite().getService(IHandlerService.class);
		assertNotNull(myHS);
		try {
			myCommand = myCS.deserialize("com.rcpcompany.uibindings.commands.openBinding");
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		assertNotNull(myCommand);
	}

	/**
	 * Test the open command is enabled and opens the correct view.
	 */
	@Test
	public void openShopTest() {
		assertEquals(0, myManager.getAllViews().size());
		myNavigatorView.selectReveal(new StructuredSelection(myShop));

		assertTrue(myCommand.getCommand().isHandled());

		try {
			myHS.executeCommand(myCommand, null);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}

		final Collection<IEditorPartView> views = myManager.getAllViews();
		assertEquals(1, views.size());

		final IEditorPartView view = views.iterator().next();
		assertEquals(myShop, view.getCurrentObject());
	}

	/**
	 * Test the open command is disabled and does not execute...
	 */
	@Test
	public void openShopItemTest() {
		assertEquals(0, myManager.getAllViews().size());
		myNavigatorView.selectReveal(new StructuredSelection(myShopItem));

		assertTrue(!myCommand.getCommand().isHandled());

		try {
			myHS.executeCommand(myCommand, null);
			fail();
		} catch (final Exception ex) {
		}

		assertEquals(0, myManager.getAllViews().size());
	}
}
