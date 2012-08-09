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

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.CustomerType;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Test for leaks when an cell is edited.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerEditorLeakTest {
	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setAutoApplySingleQuickfix(true);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();
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
		myTestView = UIBindingsTestUtils.createUIBTestView(this);

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
		/*
		 * Count number of adapters
		 */
		final int beforeCount = countAdapters(myShop);

		/*
		 * Edit a cell
		 */
		final ColumnViewer viewer = myTableCreator.getBinding().getViewer();
		viewer.editElement(myCustomer1, 0);

		// assertNotNull(column.myEditingSupport);
		// final ValueBinding b = (ValueBinding) column.myEditingSupport.myEditorBinding;
		// assertNotNull(b);
		// final IObservableValue observable = b.getUIObservable();
		//
		// observable.setValue("New name");

		viewer.cancelEditing();

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
