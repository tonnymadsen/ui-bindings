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
package com.rcpcompany.uibindings.extests.issues;

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ContextMessageDecorator;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests of <a href="http://jira.marintek.sintef.no/jira/browse/SIMA-621">SIMA-621</a>: Reported
 * issues seems to increase when navigating in table
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SIMA621ProblemsIncreases {
	private Shop myShop;
	private ShopItem myShopItem1;
	private ShopItem myShopItem2;

	private UIBTestView myView;
	private Composite myBody;
	private TableViewer myTableViewer;
	private TableViewerColumn myNameColumn;
	private TableViewerColumn myPriceColumn;

	private IBindingContext myContext;
	private IViewerBinding myViewerBinding;
	private Table myTable;
	private IValidatorAdapterManager myVAM;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(false);
		IManager.Factory.getManager().setEditCellSingleClick(true);

		createShop();
		createView();
		bindUI();

		myVAM = IValidatorAdapterManager.Factory.getManager();
		myVAM.addRoot(myShop, new ConstraintValidatorAdapter());

		myView.getSite().getPage().activate(myView);
		myBody.layout();

		// final Listener listener = new Listener() {
		// @Override
		// public void handleEvent(Event event) {
		// LogUtils.debug(this, ToStringUtils.toString(event));
		// }
		// };
		// for (int i = SWT.None; i <= SWT.ImeComposition; i++) {
		// myTable.getDisplay().addFilter(i, listener);
		// }
		//
		// myTableViewer.getColumnViewerEditor().addEditorActivationListener(new
		// ColumnViewerEditorActivationListener()
		// {
		//
		// @Override
		// public void beforeEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
		// LogUtils.debug(this, "");
		// }
		//
		// @Override
		// public void beforeEditorActivated(ColumnViewerEditorActivationEvent event) {
		// LogUtils.debug(this, "");
		// }
		//
		// @Override
		// public void afterEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
		// LogUtils.debug(this, "");
		// }
		//
		// @Override
		// public void afterEditorActivated(ColumnViewerEditorActivationEvent event) {
		// LogUtils.debug(this, "");
		// }
		// });
	}

	@After
	public void after() {
		myVAM.reset();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellAnyKey(false);
		IManager.Factory.getManager().setEditCellSingleClick(true);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myShopItem1 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem1.setName("item 0");
		myShopItem1.setPrice(-1f);
		myShopItem1.setForSale(true);

		myShopItem2 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem2.setName("item 1");
		myShopItem2.setPrice(10f);
		myShopItem2.setForSale(false);

		myShop.getShopItems().add(myShopItem1);
		myShop.getShopItems().add(myShopItem2);
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
		myViewerBinding.addColumn(myPriceColumn, ShopPackage.Literals.SHOP_ITEM__PRICE).type("currency");

		myContext.finish();
		yield();
	}

	/**
	 * Test clocking around
	 */
	@Test
	public void testClicks() {
		for (int i = 1; i <= 3; i++) {
			editCell(0, 0);
			editCell(1, 1);
			editCell(0, 1);
		}
	}

	public void editCell(int row, int column) {
		postMouse(myTable, column + myViewerBinding.getFirstTableColumnOffset(), row);
		sleep(250);
		postKeyStroke(myTable, "ESCAPE");
		sleep(250);

		final ContextMessageDecorator service = myContext.getService(ContextMessageDecorator.class);
		assertEquals(1, service.getMessages().size());
	}
}
