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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.extests.NavigatorTestUtils;
import com.rcpcompany.uibindings.navigator.internal.views.BaseEditorView;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;

/**
 * Tests that the {@link BaseEditorView} is properly shown.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class ShowViewTest {
	private INavigatorManager myManager;
	private Shop myShop1;
	private Shop myShop2;
	private ShopItem myShopItem;
	private Country myCountry;

	@Before
	public void before() {
		NavigatorTestUtils.resetAll();
		myManager = INavigatorManager.Factory.getManager();

		myShop1 = ShopFactory.eINSTANCE.createShop();
		myShop2 = ShopFactory.eINSTANCE.createShop();

		myCountry = ShopFactory.eINSTANCE.createCountry();

		myShopItem = ShopFactory.eINSTANCE.createShopItem();
	}

	/**
	 * Tests that {@link IEditorPartView#isPinned()} is respected in
	 * {@link INavigatorManager#openView(org.eclipse.emf.ecore.EObject, boolean)}.
	 */
	@Test
	public void reuseUnpinned() {
		final IEditorPartView shop1View = myManager.openView(myShop1, false);
		shop1View.setPinned(true);
		final IEditorPartView shop2View = myManager.openView(myShop2, false);

		// Re-use the view
		assertEquals(shop1View, myManager.openView(myShop1, false));

		shop1View.setPinned(false);

		// Still re-use the existing view
		assertEquals(shop2View, myManager.openView(myShop2, false));

		assertEquals(shop1View, myManager.openView(myCountry, false));
	}

	/**
	 * Tests the menu and toolbar of the view
	 */
	@Test
	public void toolbar() {
		final BaseEditorView shopView = (BaseEditorView) myManager.openView(myShop1, false);
		final IActionBars actionBars = shopView.getViewSite().getActionBars();
		/*
		 * Items of the menu
		 */
		final IMenuManager menu = actionBars.getMenuManager();
		menu.updateAll(true);
		menu.findUsingPath("");

		final IToolBarManager toolBar = actionBars.getToolBarManager();
	}
}
