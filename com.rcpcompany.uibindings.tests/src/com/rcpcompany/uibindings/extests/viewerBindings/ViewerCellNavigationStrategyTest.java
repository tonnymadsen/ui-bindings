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

import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests that we cannot go to the first column of a viewer.
 * <p>
 * Also see <a href="http://jira.marintek.sintef.no/jira/browse/SIMA-1053">SIMA-1053</a>: Status
 * view: IndexOutOfBounds and missing horizontal scrollbar.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerCellNavigationStrategyTest {
	private Shop myShop;

	private UIBTestView myView;

	private ITableCreator myTable;

	private ShopItem myShopItem1;
	private ShopItem myShopItem2;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();

		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	@After
	public void after() {
		BaseUIBTestUtils.resetAll();
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myShopItem1 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem1.setName("item 0");
		myShopItem1.setPrice(5f);
		myShopItem1.setForSale(true);
		myShop.getShopItems().add(myShopItem1);

		myShopItem2 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem2.setName("item 1");
		myShopItem2.setPrice(20f);
		myShopItem2.setForSale(false);

		myShop.getShopItems().add(myShopItem2);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);

		final IFormCreator form = myView.createFormCreator(myShop);
		myTable = form.addTableCreator(ShopPackage.Literals.SHOP__SHOP_ITEMS, true, SWT.NONE);
		myTable.addColumn("name(w=100)");
		myTable.addColumn("price(w=100)");

		form.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void goToFirstColumn() {
		testOne(null, 0, myShopItem1);
		testOne("ARROW_RIGHT", 1, myShopItem1);
		testOne("ARROW_LEFT", 0, myShopItem1);
		testOne("ARROW_LEFT", 0, myShopItem1);
		testOne("ARROW_RIGHT", 1, myShopItem1);
		testOne("ARROW_RIGHT", 1, myShopItem1);
	}

	private void testOne(String stroke, int columnNo, ShopItem si) {
		final ColumnViewerEditor editor = myTable.getBinding().getViewer().getColumnViewerEditor();

		if (stroke != null) {
			final Table t = (Table) myTable.getBinding().getControl();
			postKeyStroke(t, stroke);
		}
		yield();
		assertEquals(myTable.getBinding().getFirstTableColumnOffset() + columnNo, editor.getFocusCell()
				.getColumnIndex());
		assertEquals(si, editor.getFocusCell().getElement());
	}
}
