/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;

/**
 * Tests the automatic reflow of forms when the size of a viewer changes.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerReflowTest {
	private Shop myShop;

	private UIBTestView myView;
	private Composite myBody;
	private TableViewer myTableViewer;
	private TableViewerColumn myNameColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private Table myTable;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
		myBody.layout();
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();
		myBody.setLayout(new TableWrapLayout());

		myTableViewer = new TableViewer(myBody, SWT.FULL_SELECTION | SWT.BORDER);
		myTable = myTableViewer.getTable();
		myTable.setLayoutData(new TableWrapData(TableWrapData.FILL));
		myTable.setHeaderVisible(true);

		myNameColumn = new TableViewerColumn(myTableViewer, SWT.NONE);
		myNameColumn.getColumn().setWidth(100);
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

		myContext.finish();
		yield();
	}

	/**
	 * Create a form with a viewer and test that the form get bigger as elements are added to the
	 * viewer.
	 */
	@Test
	public void testSize() {
		yield();
		final Rectangle initialBounds = myTable.getBounds();
		assertTrue(initialBounds.height > 0);
		assertTrue(initialBounds.width > 0);

		/*
		 * - add two new items
		 */
		ShopItem si;
		si = ShopFactory.eINSTANCE.createShopItem();
		si.setName("item 1");
		myShop.getShopItems().add(si);
		si = ShopFactory.eINSTANCE.createShopItem();
		si.setName("item 2");
		myShop.getShopItems().add(si);
		si = ShopFactory.eINSTANCE.createShopItem();
		si.setName("item 3");
		myShop.getShopItems().add(si);
		si = ShopFactory.eINSTANCE.createShopItem();
		si.setName("item 4");
		myShop.getShopItems().add(si);
		si = ShopFactory.eINSTANCE.createShopItem();
		si.setName("item 5");
		myShop.getShopItems().add(si);

		yield();
		Rectangle newBounds = myTable.getBounds();
		assertTrue(newBounds.height > initialBounds.height);
		assertTrue(newBounds.width == initialBounds.width);

		/*
		 * - remove the items
		 */
		myShop.getShopItems().clear();

		yield();
		newBounds = myTable.getBounds();
		assertTrue(newBounds.height == initialBounds.height);
		assertTrue(newBounds.width == initialBounds.width);
	}
}
