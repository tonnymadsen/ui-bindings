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
package com.rcpcompany.uibindings.internal.utils;

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ToolItem;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;
import com.rcpcompany.uibindings.utils.IViewerToolBar;

/**
 * Tests of the {@link ToolBar} item functionality of {@link IViewerToolBar}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerToolBarFunctionTest {
	private UIBTestView myView;

	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;

	private IFormCreator myForm;

	private ITableCreator myTable;

	private IViewerBinding myTableBinding;

	private IViewerToolBar myToolBar;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		myShop = ShopFactory.eINSTANCE.createShop();
		myCountry1 = ShopFactory.eINSTANCE.createCountry();
		myCountry1.setAbbreviation("AB");
		myCountry1.setShop(myShop);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setAbbreviation("AB");
		myCountry2.setShop(myShop);

		myView = BaseUIBTestUtils.createUIBTestView(this);
		myForm = myView.createFormCreator(myShop);

		myTable = myForm.addTableCreator(ShopPackage.Literals.SHOP__COUNTRIES, true, SWT.NONE);
		myTable.addColumn("abbreviation(w=100)");
		myTableBinding = myTable.getBinding();

		myForm.finish();
	}

	/**
	 * Tests that the correct command is executed for ADD.
	 */
	@Test
	@Ignore
	public void testButtonFunctionADD() {
		createItem(IViewerToolBar.ADD, "");
	}

	/**
	 * Tests that the correct command is executed for DELETE.
	 */
	@Test
	public void testButtonFunctionDELETE() {
		final ToolItem item = createItem(IViewerToolBar.DELETE, "org.eclipse.ui.edit.delete");
		yield();

		postMouse(myTable.getTable(), myTable.getBinding().getFirstTableColumnOffset(),
				myShop.getCountries().size() - 1);
		yield();
		assertTrue(item.isEnabled());

		postMouse(myTable.getTable(), myTable.getBinding().getFirstTableColumnOffset(), 0);
		yield();
		assertTrue(item.isEnabled());

		postMouse(item.getParent(), item.getBounds());

		assertEquals(1, myShop.getCountries().size());
		assertEquals(myCountry2, myShop.getCountries().get(0));
	}

	/**
	 * Tests that the correct command is executed for UP.
	 */
	@Test
	public void testButtonFunctionUP() {
		final ToolItem item = createItem(IViewerToolBar.UP, "com.rcpcompany.uibindings.commands.moveItemUp");
		yield();

		postMouse(myTable.getTable(), myTable.getBinding().getFirstTableColumnOffset(), 0);
		yield();
		assertTrue(!item.isEnabled());

		postMouse(myTable.getTable(), myTable.getBinding().getFirstTableColumnOffset(),
				myShop.getCountries().size() - 1);
		yield();
		assertTrue(item.isEnabled());

		postMouse(item.getParent(), item.getBounds());

		assertEquals(myShop.getCountries().get(0), myCountry2);
	}

	/**
	 * Tests that the correct command is executed for DOWN.
	 */
	@Test
	public void testButtonFunctionDOWN() {
		final ToolItem item = createItem(IViewerToolBar.DOWN, "com.rcpcompany.uibindings.commands.moveItemDown");
		yield();

		postMouse(myTable.getTable(), myTable.getBinding().getFirstTableColumnOffset(),
				myShop.getCountries().size() - 1);
		yield();
		assertTrue(!item.isEnabled());

		postMouse(myTable.getTable(), myTable.getBinding().getFirstTableColumnOffset(), 0);
		yield();
		assertTrue(item.isEnabled());

		postMouse(item.getParent(), item.getBounds());

		assertEquals(myShop.getCountries().get(0), myCountry2);
	}

	/**
	 * Tests that the specified button executes the specified command.
	 * 
	 * @param itemID the button ID
	 * @param commandID the command string
	 * @return the created {@link ToolBar} item
	 */
	private ToolItem createItem(int itemID, String commandID) {
		myToolBar = IViewerToolBar.Factory.addToolBar(myTableBinding, itemID);

		for (final int s : new int[] { IViewerToolBar.ADD, IViewerToolBar.DELETE, IViewerToolBar.UP,
				IViewerToolBar.DOWN }) {
			final ToolItem item = myToolBar.getItem(s);
			if (s == itemID) {
				assertNotNull(item);
			} else {
				assertEquals(null, item);
			}
		}

		return myToolBar.getItem(itemID);
	}
}
