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
package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests deleting elements from a {@link Table} based {@link IViewerBinding}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerTableDeleteElementTest {
	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;
	private ShopItem myShopItem1;

	private TestView myView;

	private IViewerBinding myCountriesVB;
	private IViewerBinding myShopItemsVB;
	private Contact myContact;
	private ResourceSet myResourceSet;
	private Resource myResource;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);
		IManager.Factory.getManager().setEditCellAnyKey(false);

		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	@After
	public void after() {
		IManager.Factory.getManager().setEditCellSingleClick(true);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myCountry1 = ShopFactory.eINSTANCE.createCountry();
		myCountry1.setName("1");
		myShop.getCountries().add(myCountry1);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setName("2");
		myShop.getCountries().add(myCountry2);

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("nn");
		myContact.setCountry(myCountry2);
		myContact.setShop(myShop);

		myShopItem1 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem1.setName("si1");
		myShop.getShopItems().add(myShopItem1);

		myResourceSet = EditingDomainUtils.getEditingDomain().getResourceSet();
		myResource = new ResourceImpl();
		myResourceSet.getResources().add(myResource);

		myResource.getContents().add(myShop);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);
		final IFormCreator form = myView.createFormCreator(myShop);
		ITableCreator table;

		table = form.addTableCreator(ShopPackage.Literals.SHOP__COUNTRIES, true, SWT.NONE);
		table.addColumn("name(w=100)");

		myCountriesVB = table.getBinding();

		table = form.addTableCreator(ShopPackage.Literals.SHOP__SHOP_ITEMS, true, SWT.NONE);
		table.addColumn("name(w=100)");

		myShopItemsVB = table.getBinding();

		form.finish();
	}

	@After
	public void disposeView() {
		myResourceSet.getResources().remove(myResource);
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Checks that the delete command is enabled and disabled when needed
	 */
	@Test
	public void testEnablement() {
		try {
			IManager.Factory.getManager().setEditCellSingleClick(false);
			final ICommandService cs = (ICommandService) myView.getSite().getService(ICommandService.class);
			final IHandlerService hs = (IHandlerService) myView.getSite().getService(IHandlerService.class);

			final ParameterizedCommand deleteCommand = cs.deserialize(ActionFactory.DELETE.getCommandId());
			assertTrue(deleteCommand.getCommand().isDefined());

			/*
			 * First country can be deleted
			 */
			postMouse((Table) myCountriesVB.getControl(), 0 + myCountriesVB.getFirstTableColumnOffset(), 0);
			yield();

			assertTrue(deleteCommand.getCommand().isHandled());
			assertTrue(deleteCommand.getCommand().isEnabled());

			try {
				hs.executeCommand(deleteCommand, null);
			} catch (final ExecutionException ex) {
				fail(ex.getMessage());
			}

			yield();

			/*
			 * Second country cannot be deleted, but... the command is still enabled...
			 * 
			 * Wait a little to void a double click!!
			 */
			sleep(myCountriesVB.getControl().getDisplay().getDoubleClickTime() + 200);
			postMouse((Table) myCountriesVB.getControl(), 0 + myCountriesVB.getFirstTableColumnOffset(), 0);
			yield();

			assertTrue(deleteCommand.getCommand().isHandled());
			assertTrue(!deleteCommand.getCommand().isEnabled());

			/*
			 * Shop item can be deleted
			 */
			myShopItemsVB.getControl().setFocus();
			postMouse((Table) myShopItemsVB.getControl(), 0 + myShopItemsVB.getFirstTableColumnOffset(), 0);
			yield();

			assertTrue(deleteCommand.getCommand().isHandled());
			assertTrue(deleteCommand.getCommand().isEnabled());
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * Checks that the first item is deleted on request.
	 */
	@Test
	public void testFunctionOK() {
		try {
			final ICommandService cs = (ICommandService) myView.getSite().getService(ICommandService.class);
			final IHandlerService hs = (IHandlerService) myView.getSite().getService(IHandlerService.class);

			final ParameterizedCommand deleteCommand = cs.deserialize(ActionFactory.DELETE.getCommandId());

			// myTableViewer1.getTable().setFocus();
			postMouse((Table) myCountriesVB.getControl(), 0 + myCountriesVB.getFirstTableColumnOffset(), 0);
			yield();

			assertEquals(2, myShop.getCountries().size());
			hs.executeCommand(deleteCommand, null);
			assertEquals(1, myShop.getCountries().size());
			assertTrue(myShop.getCountries().contains(myCountry2));
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}

	/**
	 * Checks that the country cannot be deleted as there are a reference from a contact.
	 */
	@Test
	public void testFunctionFail() {
		try {
			final ICommandService cs = (ICommandService) myView.getSite().getService(ICommandService.class);
			final IHandlerService hs = (IHandlerService) myView.getSite().getService(IHandlerService.class);

			final ParameterizedCommand deleteCommand = cs.deserialize(ActionFactory.DELETE.getCommandId());

			// myTableViewer1.getTable().setFocus();
			final Table table = (Table) myCountriesVB.getControl();
			postMouse(table, 0 + myCountriesVB.getFirstTableColumnOffset(), 1);
			yield();

			assertEquals(2, myShop.getCountries().size());
			try {
				table.getDisplay().timerExec(1000, new Runnable() {
					@Override
					public void run() {
						postKeyStroke(Display.getCurrent().getFocusControl(), "ENTER");
					}
				});
				hs.executeCommand(deleteCommand, null);
				sleep(1500);
			} catch (final ExecutionException ex) {
				// do nothing
			}
			assertEquals(2, myShop.getCountries().size());
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
	}
}
