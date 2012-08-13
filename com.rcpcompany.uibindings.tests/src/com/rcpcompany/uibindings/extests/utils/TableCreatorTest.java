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
package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Test of {@link ITableChooser}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class TableCreatorTest {
	private UIBTestView myView;
	private Composite myBody;

	private Shop myShop;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();

		final ShopItemGroup group = ShopFactory.eINSTANCE.createShopItemGroup();
		group.setName("group");
		myShop.getShopGroups().add(group);

		ShopItem i = ShopFactory.eINSTANCE.createShopItem();
		i.setName("item 0");
		i.setPrice(5f);
		i.setForSale(true);
		myShop.getShopItems().add(i);

		i = ShopFactory.eINSTANCE.createShopItem();
		i.setName("item 1");
		i.setPrice(10f);
		i.setForSale(false);
		i.setGroup(group);
		myShop.getShopItems().add(i);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests the basic get/set functionality
	 */
	@Test
	public void testBasicGetSet() {
		final IBindingContext context = IBindingContext.Factory.createContext(myBody);
		final IObservableList items = UIBindingsEMFObservables.observeList(context.getEditingDomain(), myShop,
				ShopPackage.Literals.SHOP__SHOP_ITEMS);

		final ITableCreator creator = ITableCreator.Factory.create(context, myBody, SWT.NONE, items);

		final Table table = creator.getTable();
		final IViewerBinding binding = creator.getBinding();

		assertNotNull(table);
		assertNotNull(binding);
		assertEquals(table, binding.getControl());
		assertEquals(items, binding.getList());
	}

	/**
	 * Tests created columns
	 */
	@Test
	public void testCreateColumns() {
		final IBindingContext context = IBindingContext.Factory.createContext(myBody);
		final IObservableList items = UIBindingsEMFObservables.observeList(context.getEditingDomain(), myShop,
				ShopPackage.Literals.SHOP__SHOP_ITEMS);

		final ITableCreator creator = ITableCreator.Factory.create(context, myBody, SWT.NONE, items);

		creator.addColumn(IMOAOPackage.Literals.NAMED_OBJECT__NAME, 200);
		creator.addColumn(ShopPackage.Literals.SHOP_ITEM__PRICE, 100);

		context.finish();
		yield();

		final Table table = creator.getTable();

		// Remember the invisible first column...
		assertEquals(2, table.getColumnCount() - creator.getBinding().getFirstTableColumnOffset());
		testColumn(table.getColumn(0 + creator.getBinding().getFirstTableColumnOffset()), "Name", 200, SWT.LEFT);
		testColumn(table.getColumn(1 + creator.getBinding().getFirstTableColumnOffset()), "Price", 100, SWT.RIGHT);
	}

	private void testColumn(TableColumn column, String text, int width, int alignment) {
		assertNotNull(column);
		if (text != null) {
			assertEquals(text, column.getText());
		}
		assertEquals(width, column.getWidth());

		// The column itself is always centered. It is the label provider that does the alignment
		// now.
		// assertEquals(alignment, column.getAlignment());
	}

	/**
	 * Tests created text columns
	 */
	@Test
	public void testCreateTextColumns() {
		final IBindingContext context = IBindingContext.Factory.createContext(myBody);
		final IObservableList items = UIBindingsEMFObservables.observeList(context.getEditingDomain(), myShop,
				ShopPackage.Literals.SHOP__SHOP_ITEMS);

		final ITableCreator creator = ITableCreator.Factory.create(context, myBody, SWT.NONE, items);

		final IColumnBinding nameColumn = creator.addColumn("name(w=300)");
		final IColumnBinding priceColumn = creator.addColumn("price(w=50)");
		final IColumnBinding groupNameColumn = creator.addColumn("group.name(w=80,a=c)");
		final IColumnBinding groupDescriptionColumn = creator.addColumn("group.description(w=100)");

		assertNotNull(nameColumn);
		assertNull(nameColumn.getBaseColumn());
		assertNotNull(priceColumn);
		assertNull(priceColumn.getBaseColumn());
		assertNotNull(groupNameColumn);
		assertNotNull(groupNameColumn.getBaseColumn());
		assertNotNull(groupDescriptionColumn);
		assertNotNull(groupDescriptionColumn.getBaseColumn());

		assertEquals(groupNameColumn.getBaseColumn(), groupDescriptionColumn.getBaseColumn());
		yield();

		context.finish();

		final Table table = creator.getTable();

		// Remember the invisible first column...
		assertEquals(5, table.getColumnCount() - creator.getBinding().getFirstTableColumnOffset());
		testColumn(table.getColumn(0 + creator.getBinding().getFirstTableColumnOffset()), "Name", 300, SWT.LEFT);
		testColumn(table.getColumn(1 + creator.getBinding().getFirstTableColumnOffset()), "Price", 50, SWT.RIGHT);
		testColumn(table.getColumn(2 + creator.getBinding().getFirstTableColumnOffset()), null, 0, SWT.LEFT);
		testColumn(table.getColumn(3 + creator.getBinding().getFirstTableColumnOffset()), "Name", 80, SWT.CENTER);
		testColumn(table.getColumn(4 + creator.getBinding().getFirstTableColumnOffset()), "Description", 100, SWT.LEFT);
	}

	/**
	 * Test that the extra FILTER style of {@link ITableCreator} does not overlap with any other
	 * styles for {@link Table}.
	 */
	@Test
	public void testStylesFILTER() {
		testStyle(ITableCreator.FILTER);
	}

	/**
	 * Test that the extra RESIZE style of {@link ITableCreator} does not overlap with any other
	 * styles for {@link Table}.
	 */
	@Test
	public void testStylesRESIZE() {
		testStyle(ITableCreator.RESIZE);
	}

	public void testStyle(int style) {
		final int[] tableStyles = { SWT.SINGLE, SWT.MULTI, SWT.CHECK, SWT.FULL_SELECTION, SWT.HIDE_SELECTION,
				SWT.VIRTUAL, SWT.NO_SCROLL, SWT.H_SCROLL, SWT.V_SCROLL };

		for (final int s : tableStyles) {
			assertTrue("Testing " + s, (style & s) == 0);
		}
	}

	/**
	 * Tests created text columns
	 */
	@Test
	@Ignore
	public void testColumnResize() {
		doTestColumnResize(ITableCreator.RESIZE);
	}

	/**
	 * Tests created text columns and a filter box
	 */
	@Test
	@Ignore
	public void testColumnResizeFilter() {
		doTestColumnResize(ITableCreator.RESIZE | ITableCreator.FILTER);
	}

	private void doTestColumnResize(int style) {
		final Composite top = IManager.Factory.getManager().getFormToolkit().createComposite(myBody);
		final IBindingContext context = IBindingContext.Factory.createContext(myBody);
		final IObservableList items = UIBindingsEMFObservables.observeList(context.getEditingDomain(), myShop,
				ShopPackage.Literals.SHOP__SHOP_ITEMS);

		final ITableCreator creator = ITableCreator.Factory.create(context, top, style, items);

		final IColumnBinding noColumn = creator.addColumn("__ROW_NO__(w=10)");
		final IColumnBinding nameColumn = creator.addColumn("name(w=50,ww=200)");
		final IColumnBinding priceColumn = creator.addColumn("price(w=50)");
		final IColumnBinding groupNameColumn = creator.addColumn("group.name(w=80, ww=0)");

		context.finish();
		yield();

		final Composite c = (Composite) top.getChildren()[0];

		// Too small
		c.setSize(150, 300);
		c.layout();
		sleep(200);

		testColumnWidth(noColumn, 10);
		testColumnWidth(nameColumn, 50);
		testColumnWidth(priceColumn, 50);
		testColumnWidth(groupNameColumn, 80);

		// Minimum
		c.setSize(194, 300);
		c.layout();
		sleep(200);

		testColumnWidth(noColumn, 10);
		testColumnWidth(nameColumn, 50);
		testColumnWidth(priceColumn, 50);
		testColumnWidth(groupNameColumn, 80);

		// +30
		c.setSize(504, 300);
		c.layout();
		sleep(200);

		testColumnWidth(noColumn, 10);
		testColumnWidth(nameColumn, 273);
		testColumnWidth(priceColumn, 136);
		testColumnWidth(groupNameColumn, 80);
	}

	private void testColumnWidth(IColumnBinding col, int expectedWidth) {
		assertEquals(expectedWidth, col.getColumnAdapter().getWidth());
	}
}
