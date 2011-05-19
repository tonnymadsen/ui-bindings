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

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.internal.handlers.ViewerCopyHandler;
import com.rcpcompany.uibindings.internal.handlers.ViewerPasteHandler;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Test cut and paste works in a viewer.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CopyPasteInViewerTest {
	private Shop myShop;
	private ShopItem myItem1;
	private ShopItem myItem2;

	private UIBTestView myView;
	private Composite myBody;
	private TableViewer myTableViewer;
	private TableViewerColumn myNameColumn;
	private TableViewerColumn myPriceColumn;
	private TableViewerColumn myGroupColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private Table myTable;
	private ShopItemGroup myGroup1;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
		myBody.layout();
	}

	@After
	public void after() {
		IManager.Factory.getManager().setEditCellSingleClick(true);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myItem1 = ShopFactory.eINSTANCE.createShopItem();
		myItem1.setName("item 0");
		myItem1.setPrice(5f);
		myShop.getShopItems().add(myItem1);

		myItem2 = ShopFactory.eINSTANCE.createShopItem();
		myItem2.setName("item 1");
		myItem2.setPrice(10f);
		myShop.getShopItems().add(myItem2);

		myGroup1 = ShopFactory.eINSTANCE.createShopItemGroup();
		myGroup1.setName("group");
		myShop.getShopGroups().add(myGroup1);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myTableViewer = new TableViewer(myBody, SWT.FULL_SELECTION);
		myTable = myTableViewer.getTable();
		myTable.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		myTable.setHeaderVisible(true);

		myNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myNameColumn.getColumn().setWidth(100);

		myPriceColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myPriceColumn.getColumn().setWidth(100);

		myGroupColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myGroupColumn.getColumn().setWidth(100);

		// final IHandlerService hs = (IHandlerService)
		// myView.getSite().getService(IHandlerService.class);
		// final ICommandService cs = (ICommandService)
		// myView.getSite().getService(ICommandService.class);
		// final ParameterizedCommand command = cs.deserialize("org.eclipse.ui.edit.paste");
		// command.getCommand().addCommandListener(new ICommandListener() {
		// @Override
		// public void commandChanged(CommandEvent commandEvent) {
		// commandEvent.
		// }
		// });
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Binds the UI
	 */
	public void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myViewerBinding = myContext.addViewer(myTableViewer, myShop, ShopPackage.Literals.SHOP__SHOP_ITEMS);
		myViewerBinding.addColumn(myNameColumn, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
		myViewerBinding.addColumn(myPriceColumn, ShopPackage.Literals.SHOP_ITEM__PRICE).type("##.#");
		myViewerBinding.addColumn(myGroupColumn, ShopPackage.Literals.SHOP_ITEM__GROUP).validValues(myShop,
				ShopPackage.Literals.SHOP__SHOP_GROUPS);

		myContext.finish();
		yield();
	}

	/**
	 * Tests the normal OK cases: number to number and number to string.
	 */
	@Test
	public void testOK() {
		final ColumnViewerEditor columnViewerEditor = myTableViewer.getColumnViewerEditor();
		final EList<IBinding> bindings = myContext.getBindings();
		final Clipboard clipboard = IManager.Factory.getManager().getClipboard();

		/*
		 * Check initial state
		 */
		yield();
		assertEquals("" + myItem1.getName(), myViewerBinding.getCell(0, 0, true).getDisplayText());
		assertEquals(String.format("%,.2f", myItem1.getPrice()), myViewerBinding.getCell(1, 0, true).getDisplayText());
		assertEquals("" + myItem2.getName(), myViewerBinding.getCell(0, 1, true).getDisplayText());
		assertEquals(String.format("%,.2f", myItem2.getPrice()), myViewerBinding.getCell(1, 1, true).getDisplayText());

		/*
		 * - focus on the table
		 */
		assertTrue(myTable.setFocus());
		postMouse(myTable, 1 + myViewerBinding.getFirstTableColumnOffset(), 0);
		yield();
		assertEquals(0, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());
		assertEquals(1 + myViewerBinding.getFirstTableColumnOffset(), columnViewerEditor.getFocusCell()
				.getColumnIndex());

		/*
		 * Copy the the price from item 1 to item 2
		 */
		postKeyStroke(myTable, "M1+C", myView.getSite(), ViewerCopyHandler.class);
		yield();
		assertEquals(0, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());
		assertEquals(1 + myViewerBinding.getFirstTableColumnOffset(), columnViewerEditor.getFocusCell()
				.getColumnIndex());
		// assertEquals("" + myShopItem1.getPrice(),
		// clipboard.getContents(TextTransfer.getInstance()));
		postKeyStroke(myTable, "ARROW_DOWN");
		yield();
		assertEquals(1, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());
		assertEquals(1 + myViewerBinding.getFirstTableColumnOffset(), columnViewerEditor.getFocusCell()
				.getColumnIndex());
		postKeyStroke(myTable, "M1+V", myView.getSite(), ViewerPasteHandler.class);
		yield();
		assertEquals(1, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());
		assertEquals(1 + myViewerBinding.getFirstTableColumnOffset(), columnViewerEditor.getFocusCell()
				.getColumnIndex());

		assertEquals(myItem1.getPrice(), myItem2.getPrice(), 0.001);

		assertEquals("" + myItem1.getName(), myViewerBinding.getCell(0, 0, true).getDisplayText());
		assertEquals(String.format("%,.2f", myItem1.getPrice()), myViewerBinding.getCell(1, 0, true).getDisplayText());
		assertEquals("" + myItem2.getName(), myViewerBinding.getCell(0, 1, true).getDisplayText());
		assertEquals(String.format("%,.2f", myItem2.getPrice()), myViewerBinding.getCell(1, 1, true).getDisplayText());

		/*
		 * Copy the the price from item 2 to the name of item 2
		 */
		postKeyStroke(myTable, "M1+C", myView.getSite(), ViewerCopyHandler.class);
		assertEquals(String.format("%,.2f", myItem2.getPrice()), clipboard.getContents(TextTransfer.getInstance()));
		postKeyStroke(myTable, "ARROW_LEFT");
		yield();
		assertEquals(1, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());
		assertEquals(0 + myViewerBinding.getFirstTableColumnOffset(), columnViewerEditor.getFocusCell()
				.getColumnIndex());
		postKeyStroke(myTable, "M1+V", myView.getSite(), ViewerPasteHandler.class);
		assertEquals(1, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());

		assertEquals(String.format("%,.2f", myItem2.getPrice()), myItem2.getName());

		assertEquals("" + myItem1.getName(), myViewerBinding.getCell(0, 0, true).getDisplayText());
		assertEquals(String.format("%,.2f", myItem1.getPrice()), myViewerBinding.getCell(0, 1, true).getDisplayText());
		assertEquals("" + myItem2.getName(), myViewerBinding.getCell(1, 0, true).getDisplayText());
		assertEquals(String.format("%,.2f", myItem2.getPrice()), myViewerBinding.getCell(1, 1, true).getDisplayText());
	}

	/**
	 * Tests copy to relation with valid name
	 */
	@Test
	public void testCopyToRelationOK() {
		copyToRelation(myGroup1.getName(), myGroup1);
	}

	/**
	 * Tests copy to relation with invalid name
	 */
	@Test
	public void testCopyToRelationError() {
		copyToRelation("*no group*", null);
	}

	/**
	 * Tests copy to relation with empty string
	 */
	@Test
	public void testCopyToRelationEmpty() {
		copyToRelation("", null);
	}

	protected void copyToRelation(String name, ShopItemGroup expectedGroup) {
		final ColumnViewerEditor columnViewerEditor = myTableViewer.getColumnViewerEditor();
		final EList<IBinding> bindings = myContext.getBindings();
		final Clipboard clipboard = IManager.Factory.getManager().getClipboard();

		myItem1.setName(name);
		/*
		 * Check initial state
		 */
		yield();
		// TODO: does not work any more!
		assertEquals(name, myViewerBinding.getCell(0, 0, true).getDisplayText());

		/*
		 * - focus on the table
		 */
		assertTrue(myTable.setFocus());
		postMouse(myTable, 0 + myViewerBinding.getFirstTableColumnOffset(), 0);
		yield();
		assertEquals(0, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());
		assertEquals(0 + myViewerBinding.getFirstTableColumnOffset(), columnViewerEditor.getFocusCell()
				.getColumnIndex());

		/*
		 * Copy the name to the group for item 1 Should be OK.
		 */
		postKeyStroke(myTable, "M1+C", myView.getSite(), ViewerCopyHandler.class);
		yield();
		assertEquals(0, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());
		assertEquals(0 + myViewerBinding.getFirstTableColumnOffset(), columnViewerEditor.getFocusCell()
				.getColumnIndex());
		Object contents = clipboard.getContents(TextTransfer.getInstance());
		if (contents == null) {
			contents = "";
		}
		assertEquals(name, contents);
		postKeyStroke(myTable, "ARROW_RIGHT");
		yield();
		postKeyStroke(myTable, "ARROW_RIGHT");
		yield();
		assertEquals(0, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());
		assertEquals(2 + myViewerBinding.getFirstTableColumnOffset(), columnViewerEditor.getFocusCell()
				.getColumnIndex());
		postKeyStroke(myTable, "M1+V", myView.getSite(), ViewerPasteHandler.class);
		yield();
		assertEquals(0, myTable.getSelectionIndex());
		assertNotNull(columnViewerEditor.getFocusCell());
		assertEquals(2 + myViewerBinding.getFirstTableColumnOffset(), columnViewerEditor.getFocusCell()
				.getColumnIndex());

		assertEquals(expectedGroup, myItem1.getGroup());
	}
}
