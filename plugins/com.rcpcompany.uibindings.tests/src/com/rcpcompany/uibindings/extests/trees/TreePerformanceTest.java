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
package com.rcpcompany.uibindings.extests.trees;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.Order;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IDnDSupport;

/**
 * Performance tests for trees using {@link TreeViewer#expandAll()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class TreePerformanceTest {
	private final int mySizeFactor;

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] {

				// sizeFactor

				{ 1 }, { 10 },

				{ 50 },

		// { 100 },

				// { 200 },
				//
				// { 500 },
				//
				// { 1000 },

				});
	}

	public TreePerformanceTest(int sizeFactor) {
		mySizeFactor = sizeFactor;
	}

	private Shop myShop;

	private TestView myView;

	private IBindingContext myContext;
	private Tree myTree;
	private TreeColumn myTreeColumn;
	private IViewerBinding myTreeBinding;
	private IColumnBinding myTreeColumnBinding;

	private int myNoShopObjs;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		try {
			myShop = createModel();
		} catch (final OutOfMemoryError ex) {
			fail("factor " + mySizeFactor + ": " + ex.getMessage());
		}
		createView();

		myView.getSite().getPage().activate(myView);
	}

	private Shop createModel() {
		final Runtime runtime = Runtime.getRuntime();
		myNoShopObjs = 0;
		runtime.gc();
		final long startMemory = runtime.totalMemory() - runtime.freeMemory();
		final long startTime = System.currentTimeMillis();

		final Shop shop = ShopFactory.eINSTANCE.createShop();
		myNoShopObjs++;
		shop.setName("my shop");

		final Country country = ShopFactory.eINSTANCE.createCountry();
		myNoShopObjs++;
		country.setName("name");
		country.setName("abbreviation");
		country.setShop(shop);

		for (int i = 0; i < mySizeFactor; i++) {
			final Country c = ShopFactory.eINSTANCE.createCountry();
			myNoShopObjs++;
			c.setName("name " + i);
			c.setAbbreviation("abbreviation " + i);
			c.setShop(shop);
		}

		for (int i = 0; i < mySizeFactor; i++) {
			final Contact c = ShopFactory.eINSTANCE.createContact();
			myNoShopObjs++;
			c.setName("name " + i);
			c.setCountry(country);
			c.setShop(shop);

			final Customer cust = ShopFactory.eINSTANCE.createCustomer();
			myNoShopObjs++;
			cust.setContact(c);
			cust.setShop(shop);

			for (int j = 0; j < mySizeFactor; j++) {
				final Order o = ShopFactory.eINSTANCE.createOrder();
				myNoShopObjs++;
				o.setCustomer(cust);
				o.setDiscount(1000f);
			}
		}

		final long endTime = System.currentTimeMillis();
		runtime.gc();
		final long endMemory = runtime.totalMemory() - runtime.freeMemory();
		final long deltaTime = endTime - startTime;
		final long deltaMemory = endMemory - startMemory;
		System.out.println("model (" + mySizeFactor + "): " + myNoShopObjs + " objects " + deltaTime + " ms "
				+ deltaMemory + " bytes (= " + (1f * deltaTime / myNoShopObjs) + " ms/obj) "
				+ (deltaMemory / myNoShopObjs) + " bytes/obj)");

		return shop;
	}

	/**
	 * Creates the view - pretty real-life
	 */
	public void createView() {
		myView = createTestView(this);

		myContext = IBindingContext.Factory.createContext(myView.getBody());

		myTree = new Tree(myView.getBody(), SWT.SINGLE | SWT.FULL_SELECTION);
		myTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		myTree.setHeaderVisible(true);
		myTreeColumn = new TreeColumn(myTree, SWT.LEAD);
		myTreeColumn.setWidth(300);
		// TODO: use listener to make this column 100%

		final IObservableList list = WritableList.withElementType(ShopPackage.Literals.SHOP);
		list.add(myShop);
		myTreeBinding = myContext.addViewer().viewer(myTree).model(list);
		myTreeColumnBinding = myTreeBinding.addColumn().column(myTreeColumn).model(SpecialBinding.TREE_ITEM);

		myContext.finish();

		IBindingContextSelectionProvider.Factory.adapt(myContext, myView.getSite());
		IDnDSupport.Factory.installOn(myContext);

		myView.getBody().layout();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testPerformance() {
		final TreeViewer viewer = (TreeViewer) myTreeBinding.getViewer();
		yield();

		final long startTime = System.currentTimeMillis();
		/*
		 * Make sure the tree is properly shown
		 */
		viewer.expandAll();
		yield();
		final long endTime = System.currentTimeMillis();

		// sleep(2000);

		System.out.println("expand (" + mySizeFactor + "): " + (endTime - startTime) + " (= "
				+ (1f * (endTime - startTime) / myNoShopObjs) + " ms/obj)");
	}
}
