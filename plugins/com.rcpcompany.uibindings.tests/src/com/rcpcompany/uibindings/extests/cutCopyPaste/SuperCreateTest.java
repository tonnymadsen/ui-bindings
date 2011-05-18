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
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.CustomerType;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.ExtendedCommandStack;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Test super paste.
 * <p>
 * Tests parse into string, enum, reference and boolean.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SuperCreateTest {

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

	private TestView myView;

	private Shop myShop;

	private Country myDKCountry;
	private Country mySECountry;
	private Country myNOCountry;

	private Contact myContact0;
	private Contact myContact1;
	private Contact myContact2;

	private Customer myCustomer1;
	private Customer myCustomer2;

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myDKCountry = ShopFactory.eINSTANCE.createCountry();
		myDKCountry.setName("Denmark");
		myDKCountry.setAbbreviation("DK");
		myDKCountry.setShop(myShop);

		mySECountry = ShopFactory.eINSTANCE.createCountry();
		mySECountry.setName("Sweden");
		mySECountry.setAbbreviation("SE");
		mySECountry.setShop(myShop);

		myNOCountry = ShopFactory.eINSTANCE.createCountry();
		myNOCountry.setName("Norway");
		myNOCountry.setAbbreviation("NO");
		myNOCountry.setShop(myShop);

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
	public void testCreate() {
		final IFormCreator form = myView.createFormCreator(myShop);
		final ITableCreator table = form.addTableCreator(ShopPackage.Literals.SHOP__CONTACTS, true, SWT.NONE);

		table.addColumn("name(w=50)");
		table.addColumn("newsletter(w=50)");
		table.addColumn("country(w=50)").validValues(myShop, ShopPackage.Literals.SHOP__COUNTRIES);

		form.finish();
		setClipboarText("aa;yes;DK\nbb;-;SE");

		postMouse(table.getTable(), 0, 1);

		final IWorkbench workbench = PlatformUI.getWorkbench();
		final ICommandService cs = (ICommandService) workbench.getService(ICommandService.class);
		final IHandlerService hs = (IHandlerService) workbench.getService(IHandlerService.class);

		final ExtendedCommandStack commandStack = (ExtendedCommandStack) IManager.Factory.getManager()
				.getEditingDomain().getCommandStack();
		assertEquals(0, commandStack.getCommands().size());

		try {
			final ParameterizedCommand c = cs.deserialize("com.rcpcompany.uibindings.commands.SuperCreate");

			hs.executeCommand(c, null);
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}

		yield();
		assertEquals(1, commandStack.getCommands().size());
		// sleep(10000);

		assertEquals(2, myShop.getCustomers().size());
		assertEquals(5, myShop.getContacts().size());

		assertEquals(myContact0, myShop.getContacts().get(0));
		assertEquals(myContact1, myShop.getContacts().get(3));
		assertEquals(myContact2, myShop.getContacts().get(4));

		assertEquals("start", myContact0.getName());
		assertEquals("AA", myContact1.getName());
		assertEquals("BB", myContact2.getName());

		final Contact caa = myShop.getContacts().get(1);
		final Contact cbb = myShop.getContacts().get(2);

		assertEquals("aa", caa.getName());
		assertEquals(true, caa.isNewsletter());
		assertEquals(myDKCountry, caa.getCountry());

		assertEquals("bb", cbb.getName());
		assertEquals(false, cbb.isNewsletter());
		assertEquals(mySECountry, cbb.getCountry());
	}

	private void setClipboarText(String t) {
		final Clipboard clipboard = IManager.Factory.getManager().getClipboard();

		final Object[] data = new Object[] { t };
		final Transfer[] dataTypes = new Transfer[] { TextTransfer.getInstance() };
		clipboard.setContents(data, dataTypes);
	}
}
