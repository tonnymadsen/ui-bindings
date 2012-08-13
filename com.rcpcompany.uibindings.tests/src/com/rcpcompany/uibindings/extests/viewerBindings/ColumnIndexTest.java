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

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests {@link IColumnBinding#getIndex(boolean)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ColumnIndexTest {
	private Shop myShop;
	private ShopItem myShopItem1;

	private UIBTestView myView;
	private Composite myBody;

	private ITableCreator form;
	private IColumnBinding myNameColumn;
	private IColumnBinding myPriceColumn;
	private ITableCreator myTable;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();

		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myShopItem1 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem1.setName("item 1");
		myShopItem1.setPrice(1f);
		myShopItem1.setForSale(true);

		myShop.getShopItems().add(myShopItem1);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		final IFormCreator form = myView.createFormCreator(myShop);

		myTable = form.addTableCreator(ShopPackage.Literals.SHOP__SHOP_ITEMS, true, SWT.NONE);

		myNameColumn = myTable.addColumn("name(w=100)");
		myPriceColumn = myTable.addColumn("price(w=87)");

		form.finish();
		yield();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests the values of all cells
	 */
	@Test
	public void testIndex() {
		assertEquals(0, myNameColumn.getIndex(false));
		assertEquals(1, myPriceColumn.getIndex(false));

		assertEquals(0, myNameColumn.getIndex(true));
		assertEquals(1, myPriceColumn.getIndex(true));

		final Table t = (Table) myTable.getBinding().getControl();

		// Remember the hidden column
		assertEquals(1, myTable.getBinding().getFirstTableColumnOffset());
		t.setColumnOrder(new int[] { 0, 2, 1 });

		assertEquals(0, myNameColumn.getIndex(false));
		assertEquals(1, myPriceColumn.getIndex(false));

		assertEquals(1, myNameColumn.getIndex(true));
		assertEquals(0, myPriceColumn.getIndex(true));
	}
}
