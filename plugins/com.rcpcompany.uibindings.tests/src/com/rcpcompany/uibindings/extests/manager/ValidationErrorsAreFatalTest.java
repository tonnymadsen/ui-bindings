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
package com.rcpcompany.uibindings.extests.manager;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Test functionality of {@link IManager#setValidationErrorsAreFatal(boolean)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ValidationErrorsAreFatalTest {
	private TestView myView;
	private Shop myShop;
	private Composite myBody;
	private Table myTable;
	private IBindingContext myContext;
	private final boolean myEAF;
	private ShopItem mySI;
	private IViewerBinding myViewerBinding;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ true }, { false },

		});
	}

	public ValidationErrorsAreFatalTest(boolean enable) {
		myEAF = enable;
	}

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(true);
		IManager.Factory.getManager().setValidationErrorsAreFatal(myEAF);
		createShop();
		createView();
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		mySI = ShopFactory.eINSTANCE.createShopItem();
		mySI.setName("A");
		mySI.setPrice(10f);
		myShop.getShopItems().add(mySI);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		final ITableCreator creator = ITableCreator.Factory.create(myContext, myBody, SWT.NONE, myShop,
				ShopPackage.Literals.SHOP__SHOP_ITEMS);
		myViewerBinding = creator.getBinding();

		myTable = creator.getTable();

		creator.addColumn("name(w=10em)");
		creator.addColumn("price(w=10em)");

		myContext.finish();
		yield();

		myView.getSite().getPage().activate(myView);
		// myView.getParent().layout();
	}

	@After
	public void disposeView() {
		IManager.Factory.getManager().setValidationErrorsAreFatal(true);
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void warningTest() {
		postMouse(myTable, 1 + myViewerBinding.getFirstTableColumnOffset(), 0);

		postKeyStroke(myTable, "-");
		postKeyStroke(myTable, "1");

		postKeyStroke(myTable, "ENTER");

		if (myEAF) {
			assertEquals(10.0, mySI.getPrice(), .0001);
		} else {
			assertEquals(-1.0, mySI.getPrice(), .0001);
		}
	}
}
