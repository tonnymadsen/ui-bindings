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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests the alignment of column headers in viewers.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerColumnHeaderAlignment {
	private Shop myShop;

	private UIBTestView myView;

	private ITableCreator myTable;

	private IFormCreator myForm;

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

		ShopItem si = ShopFactory.eINSTANCE.createShopItem();
		si.setName("item 1");
		si.setPrice(1f);
		si.setForSale(true);

		si = ShopFactory.eINSTANCE.createShopItem();
		si.setName("item 2");
		si.setPrice(2f);
		si.setForSale(false);

		myShop.getShopItems().add(si);
		myShop.getShopItems().add(si);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myShop);
		myTable = myForm.addTableCreator(ShopPackage.Literals.SHOP__SHOP_ITEMS, true, SWT.NONE);
		myTable.addColumn("name(w=100)");
		myTable.addColumn("price(w=100)");

		myForm.finish();
		yield();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests the alignment
	 */
	@Test
	public void testAlignment() {
		final Table table = myTable.getTable();
		final TableColumn[] columns = table.getColumns();
		for (int i = myTable.getBinding().getFirstTableColumnOffset(); i < columns.length; i++) {
			final TableColumn c = columns[i];
			assertEquals(SWT.CENTER, c.getAlignment());
		}
	}
}
