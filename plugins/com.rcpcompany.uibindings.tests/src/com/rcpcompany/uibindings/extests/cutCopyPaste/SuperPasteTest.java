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
package com.rcpcompany.uibindings.extests.cutCopyPaste;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.CustomerType;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Test super paste.
 * <p>
 * Tests parse into string, enum, reference and boolean.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SuperPasteTest {

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	@After
	public void after() {
		IManager.Factory.getManager().setEditCellSingleClick(true);
	}

	private Shop myShop;
	private Contact myContact0;
	private Contact myContact1;
	private Contact myContact2;
	private Customer myCustomer1;
	private UIBTestView myView;
	private Customer myCustomer2;
	private Country myDKCountry;
	private Country mySECountry;
	private Country myNOCountry;

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myDKCountry = ShopFactory.eINSTANCE.createCountry();
		myDKCountry.setName("Denmark");
		myDKCountry.setAbbreviation("DK");

		mySECountry = ShopFactory.eINSTANCE.createCountry();
		mySECountry.setName("Sweden");
		mySECountry.setAbbreviation("SE");

		myNOCountry = ShopFactory.eINSTANCE.createCountry();
		myNOCountry.setName("Norway");
		myNOCountry.setAbbreviation("NO");

		myContact0 = ShopFactory.eINSTANCE.createContact();
		myContact0.setName("start");
		myContact0.setNewsletter(true);
		myContact0.setCountry(myDKCountry);
		myContact0.setShop(myShop);

		myContact1 = ShopFactory.eINSTANCE.createContact();
		myContact1.setName("AA");
		myContact1.setNewsletter(true);
		myContact1.setCountry(mySECountry);
		myContact1.setShop(myShop);

		myContact2 = ShopFactory.eINSTANCE.createContact();
		myContact2.setName("BB");
		myContact2.setNewsletter(true);
		myContact2.setCountry(myNOCountry);
		myContact2.setShop(myShop);

		myCustomer1 = ShopFactory.eINSTANCE.createCustomer();
		myCustomer1.setContact(myContact0);
		myCustomer1.setLoyalty(CustomerType.BRONCE);
		myCustomer1.setLogoFileName("");
		myCustomer1.setShop(myShop);

		myCustomer2 = ShopFactory.eINSTANCE.createCustomer();
		myCustomer2.setContact(myContact0);
		myCustomer2.setLoyalty(CustomerType.BRONCE);
		myCustomer2.setLogoFileName("");
		myCustomer2.setShop(myShop);

	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testPaste1() {
		final IFormCreator form = myView.createFormCreator(myShop);
		final ITableCreator table = form.addTableCreator(ShopPackage.Literals.SHOP__CUSTOMERS, true, SWT.NONE);

		table.addColumn("logoFileName(w=50)");
		table.addColumn("contact(w=50)").validValues(myShop, ShopPackage.Literals.SHOP__CONTACTS);
		table.addColumn("loyalty(w=50)");

		form.finish();

		setClipboarText("c:\\tmp\\a;AA;silver\nc:\\tmp\\b;BB;GOLD");

		postMouse(table.getTable(), 0, 0);

		final IWorkbench workbench = PlatformUI.getWorkbench();
		final ICommandService cs = (ICommandService) workbench.getService(ICommandService.class);
		final IHandlerService hs = (IHandlerService) workbench.getService(IHandlerService.class);

		try {
			final ParameterizedCommand c = cs.deserialize("com.rcpcompany.uibindings.commands.SuperPaste");

			hs.executeCommand(c, null);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}

		yield();
		// sleep(10000);

		assertEquals(2, myShop.getCustomers().size());
		assertEquals(3, myShop.getContacts().size());

		assertEquals("c:\\tmp\\a", myCustomer1.getLogoFileName());
		assertEquals(myContact1, myCustomer1.getContact());
		assertEquals(CustomerType.SILVER, myCustomer1.getLoyalty());

		assertEquals("c:\\tmp\\b", myCustomer2.getLogoFileName());
		assertEquals(myContact2, myCustomer2.getContact());
		assertEquals(CustomerType.GOLD, myCustomer2.getLoyalty());
	}

	@Test
	public void testPaste2() {
		final IFormCreator form = myView.createFormCreator(myShop);
		final ITableCreator table = form.addTableCreator(ShopPackage.Literals.SHOP__CONTACTS, true, SWT.NONE);

		table.addColumn("name(w=50)");
		table.addColumn("newsletter(w=50)");

		form.finish();
		setClipboarText("aa;yes;\nbb;-");

		postMouse(table.getTable(), 0, 1);

		final IWorkbench workbench = PlatformUI.getWorkbench();
		final ICommandService cs = (ICommandService) workbench.getService(ICommandService.class);
		final IHandlerService hs = (IHandlerService) workbench.getService(IHandlerService.class);

		try {
			final ParameterizedCommand c = cs.deserialize("com.rcpcompany.uibindings.commands.SuperPaste");

			hs.executeCommand(c, null);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}

		yield();
		// sleep(10000);

		assertEquals(2, myShop.getCustomers().size());
		assertEquals(3, myShop.getContacts().size());

		assertEquals("start", myContact0.getName());

		assertEquals("aa", myContact1.getName());
		assertEquals(true, myContact1.isNewsletter());

		assertEquals("bb", myContact2.getName());
		assertEquals(false, myContact2.isNewsletter());
	}

	private void setClipboarText(String t) {
		final Clipboard clipboard = IManager.Factory.getManager().getClipboard();

		final Object[] data = new Object[] { t };
		final Transfer[] dataTypes = new Transfer[] { TextTransfer.getInstance() };
		clipboard.setContents(data, dataTypes);
	}
}
