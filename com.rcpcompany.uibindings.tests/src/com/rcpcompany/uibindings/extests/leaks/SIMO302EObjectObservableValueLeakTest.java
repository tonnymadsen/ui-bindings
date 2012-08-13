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
package com.rcpcompany.uibindings.extests.leaks;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.CustomerType;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Test of the Marintek Issue
 * "SIMO-302: Missing dispose of org.eclipse.emf.databinding.EObjectObservableValue objects".
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SIMO302EObjectObservableValueLeakTest {
	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setAutoApplySingleQuickfix(true);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
	}

	private Shop myShop;
	private UIBTestView myTestView;
	private ITableCreator myTableCreator;
	private Customer myCustomer1;
	private Customer myCustomer2;

	private void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		final Contact contact = ShopFactory.eINSTANCE.createContact();
		contact.setName("me");
		myShop.getContacts().add(contact);

		myCustomer1 = ShopFactory.eINSTANCE.createCustomer();
		myCustomer1.setContact(contact);
		myCustomer1.setLoyalty(CustomerType.BRONCE);
		myShop.getCustomers().add(myCustomer1);

		myCustomer2 = ShopFactory.eINSTANCE.createCustomer();
		myCustomer2.setContact(contact);
		myCustomer2.setLoyalty(CustomerType.GOLD);
		myShop.getCustomers().add(myCustomer2);
	}

	private void createView() {
		myTestView = BaseUIBTestUtils.createUIBTestView(this);

		final IBindingContext context = IBindingContext.Factory.createContext(myTestView.getScrolledForm());
		myTableCreator = ITableCreator.Factory.create(context, myTestView.getBody(), SWT.NONE, myShop,
				ShopPackage.Literals.SHOP__CUSTOMERS);
		myTableCreator.addColumn("contact.name(w=10em)");
		myTableCreator.addColumn("loyalty(w=5em)");

		context.finish();
		yield();
	}

	@After
	public void disposeView() {
		if (myTestView != null) {
			myTestView.getSite().getPage().hideView(myTestView);
		}
	}

	@Test
	public void testLeak() {
		final int beforeCount = countAdapters(myShop);

		/*
		 * Open the view
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				createView();
			}
		});

		/*
		 * Recount
		 */
		final int middleCount = countAdapters(myShop);

		assertTrue(beforeCount != middleCount);

		/*
		 * Close it again
		 */
		myTestView.getSite().getPage().hideView(myTestView);

		/*
		 * Recount
		 */
		final int afterCount = countAdapters(myShop);

		assertEquals(beforeCount, afterCount);
	}

	public int countAdapters(EObject obj) {
		int no = obj.eAdapters().size();
		for (final EObject c : obj.eContents()) {
			no += countAdapters(c);
		}
		return no;
	}
}
