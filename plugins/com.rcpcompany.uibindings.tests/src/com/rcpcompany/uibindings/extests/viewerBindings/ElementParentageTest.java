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

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IElementParentage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests of {@link IViewerBinding#getElementParentage(org.eclipse.emf.ecore.EObject)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ElementParentageTest {
	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	private Shop myShop;
	private ShopItem myShopItem1;
	private ShopItem myShopItem2;
	private TestView myView;
	private IFormCreator myForm;
	private Contact myContact;

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

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("NN");
		myContact.setShop(myShop);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testTable() {
		myForm = myView.createFormCreator(myShop);

		final ITableCreator table = myForm.addTableCreator(ShopPackage.Literals.SHOP__SHOP_ITEMS, true, SWT.NONE);

		table.addColumn("name(w=200)");
		myForm.finish();
		yield();

		final IViewerBinding vb = table.getBinding();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IElementParentage ep = vb.getElementParentage(myShopItem1);

				assertNotNull(ep);
				assertEquals(myShopItem1, ep.getElement());
				assertEquals(ShopPackage.Literals.SHOP__SHOP_ITEMS, ep.getReference());
				assertEquals(myShop, ep.getParent());
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IElementParentage ep = vb.getElementParentage(myShop);

				assertSame(null, ep);
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IElementParentage ep = vb.getElementParentage(myContact);

				assertSame(null, ep);
			}
		});
	}

	@Test
	public void testTree() {
		myForm = myView.createFormCreator(myShop);

		final Tree tree = new Tree(myForm.addComposite(), SWT.SINGLE | SWT.FULL_SELECTION);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);

		final TreeColumn treeColumn = new TreeColumn(tree, SWT.LEAD);
		treeColumn.setText("");

		final IObservableList list = WritableList.withElementType(ShopPackage.Literals.SHOP);
		list.add(myShop);
		final IViewerBinding vb = myForm.getContext().addViewer().viewer(tree).model(list);

		vb.addColumn().model(SpecialBinding.TREE_ITEM).column(treeColumn);

		myForm.finish();
		yield();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IElementParentage ep = vb.getElementParentage(myShopItem1);

				assertNotNull(ep);
				assertEquals(myShopItem1, ep.getElement());
				assertEquals(ShopPackage.Literals.SHOP__SHOP_ITEMS, ep.getReference());
				assertEquals(myShop, ep.getParent());
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IElementParentage ep = vb.getElementParentage(myShop);

				assertSame(null, ep);
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IElementParentage ep = vb.getElementParentage(myContact);

				assertSame(null, ep);
			}
		});
	}
}
