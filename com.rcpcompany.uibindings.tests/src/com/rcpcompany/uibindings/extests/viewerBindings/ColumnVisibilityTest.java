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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Widget;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnAdapter;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests the basic value of cells.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ColumnVisibilityTest {
	private Shop myShop;
	private ShopItem myShopItem1;
	private ShopItem myShopItem2;

	private UIBTestView myView;
	private Composite myBody;

	private IBindingContext myContext;
	private ITableCreator myCreator;
	private IColumnBinding myPriceBinding;
	private IObservableValue myVisibilityOV;

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

		myShopItem2 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem2.setName("item 2");
		myShopItem2.setPrice(2f);
		myShopItem2.setForSale(false);

		myShop.getShopItems().add(myShopItem1);
		myShop.getShopItems().add(myShopItem2);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myCreator = ITableCreator.Factory.create(myContext, myBody, SWT.NONE, myShop,
				ShopPackage.Literals.SHOP__SHOP_ITEMS);
		myCreator.addColumn("name(w=100)");
		myPriceBinding = myCreator.addColumn("price(w=87)");
		myVisibilityOV = myPriceBinding.getColumnVisibility();

		myContext.finish();
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
	public void testVisibiityType() {
		assertEquals(Boolean.class, myVisibilityOV.getValueType());
	}

	/**
	 * Tests the values of all cells
	 */
	@Test
	public void testVisibilityFunction() {
		final IColumnAdapter adapter = myPriceBinding.getColumnAdapter();
		final Widget w = myPriceBinding.getColumnAdapter().getWidget();
		assertTrue(w instanceof TableColumn);
		final TableColumn tc = (TableColumn) w;

		assertEquals(87, tc.getWidth());
		assertEquals(adapter.getWidth(), tc.getWidth());

		assertEquals(true, myVisibilityOV.getValue());

		myVisibilityOV.setValue(false);

		assertEquals(0, tc.getWidth());
		assertEquals(adapter.getWidth(), tc.getWidth());

		assertEquals(false, myVisibilityOV.getValue());

		myVisibilityOV.setValue(true);

		assertEquals(87, tc.getWidth());
		assertEquals(adapter.getWidth(), tc.getWidth());

		assertEquals(true, myVisibilityOV.getValue());
	}
}
