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

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IChildCreationSpecification;
import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tests of {@link IViewerBinding#getElementParentage(org.eclipse.emf.ecore.EObject)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ChildCreationSpecificationTest {
	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	private Shop myShop;
	private ShopItem myShopItem1;
	private ShopItem myShopItem2;
	private UIBTestView myView;
	private IFormCreator myForm;
	private Contact myContact;
	private Country myCountry;

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myShopItem1 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem1.setName("item 1");
		myShopItem1.setPrice(1f);
		myShopItem1.setForSale(true);
		myShopItem1.setShop(myShop);

		myShopItem2 = ShopFactory.eINSTANCE.createShopItem();
		myShopItem2.setName("item 2");
		myShopItem2.setPrice(2f);
		myShopItem2.setForSale(false);
		myShopItem2.setShop(myShop);

		myCountry = ShopFactory.eINSTANCE.createCountry();
		myCountry.setName("Denmark");
		myCountry.setAbbreviation("DK");
		myCountry.setShop(myShop);

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("NN");
		myContact.setCountry(myCountry);
		myContact.setShop(myShop);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
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
				final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(null, null);

				assertNotNull(specs);
				assertEquals(1, specs.size());
				final IChildCreationSpecification sp = specs.get(0);
				assertEquals(myShop, sp.getParent());
				assertEquals(ShopPackage.Literals.SHOP__SHOP_ITEMS, sp.getReference());
				assertEquals(ShopPackage.Literals.SHOP_ITEM, sp.getChildType());
				assertEquals(-1, sp.getIndex());
			}
		});
	}

	@Test
	public void testTableSibling() {
		myForm = myView.createFormCreator(myShop);

		final ITableCreator table = myForm.addTableCreator(ShopPackage.Literals.SHOP__SHOP_ITEMS, true, SWT.NONE);

		table.addColumn("name(w=200)");
		myForm.finish();
		yield();

		final IViewerBinding vb = table.getBinding();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(null, myShopItem1);

				assertNotNull(specs);
				assertEquals(1, specs.size());
				final IChildCreationSpecification sp = specs.get(0);
				assertEquals(myShop, sp.getParent());
				assertEquals(ShopPackage.Literals.SHOP__SHOP_ITEMS, sp.getReference());
				assertEquals(ShopPackage.Literals.SHOP_ITEM, sp.getChildType());
				assertEquals(0, sp.getIndex());
			}
		});
	}

	/**
	 * Tests that the returned items are filtered by the {@link Constants#ARG_NEW_ALLOWED} argument.
	 */
	@Test
	public void testTableFilteredNEW_ALLOWED() {
		myForm = myView.createFormCreator(myCountry);

		final ITableCreator table = myForm.addTableCreator(ShopPackage.Literals.COUNTRY__CONTACTS, true, SWT.NONE);

		table.addColumn("name(w=200)");
		myForm.finish();
		yield();

		final IViewerBinding vb = table.getBinding();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(null, null);

				assertNotNull(specs);
				for (final IChildCreationSpecification s : specs) {
					LogUtils.debug(this, s.getReference().getEContainingClass().getName() + "."
							+ s.getReference().getName());
				}
				/*
				 * contacts should be filtered out
				 */
				assertEquals(0, specs.size());
			}
		});
	}

	@Test
	public void testTableMultiple() {
		myForm = myView.createFormCreator(myShop);

		final ITableCreator table = myForm.addTableCreator(ShopPackage.Literals.SHOP__INFOS, true, SWT.NONE);

		table.addColumn("name(w=200)");
		myForm.finish();
		yield();

		final IViewerBinding vb = table.getBinding();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(null, null);

				assertNotNull(specs);
				assertEquals(2, specs.size());

				IChildCreationSpecification sp;

				sp = specs.get(0);
				assertEquals(myShop, sp.getParent());
				assertEquals(ShopPackage.Literals.SHOP__INFOS, sp.getReference());
				assertEquals(ShopPackage.Literals.SHOP_URL, sp.getChildType());

				sp = specs.get(1);
				assertEquals(myShop, sp.getParent());
				assertEquals(ShopPackage.Literals.SHOP__INFOS, sp.getReference());
				assertEquals(ShopPackage.Literals.SHOP_ADDRESS, sp.getChildType());
				assertEquals(-1, sp.getIndex());
			}
		});
	}

	/**
	 * Tests that when a sibling is specified, then only the specification where the sibling is
	 * present is reported.
	 */
	@Test
	public void testTableMultipleSibling() {
		myForm = myView.createFormCreator(myShop);

		final ITableCreator table = myForm.addTableCreator(ShopPackage.Literals.SHOP__INFOS, true, SWT.NONE);

		table.addColumn("name(w=200)");
		myForm.finish();
		yield();

		final IViewerBinding vb = table.getBinding();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(null, myShopItem1);

				assertNotNull(specs);
				assertEquals(0, specs.size());
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

		/*
		 * Top-level item as parent
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(myShop, null);

				assertNotNull(specs);
				assertEquals(2, specs.size());

				IChildCreationSpecification sp;

				sp = specs.get(0);
				assertEquals(myShop, sp.getParent());
				assertEquals(ShopPackage.Literals.SHOP__CONTACTS, sp.getReference());
				assertEquals(ShopPackage.Literals.CONTACT, sp.getChildType());
				assertEquals(-1, sp.getIndex());

				sp = specs.get(1);
				assertEquals(myShop, sp.getParent());
				assertEquals(ShopPackage.Literals.SHOP__SHOP_ITEMS, sp.getReference());
				assertEquals(ShopPackage.Literals.SHOP_ITEM, sp.getChildType());
				assertEquals(-1, sp.getIndex());
			}
		});

		/*
		 * Top-level item as parent and sibling
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(myShop, myShopItem2);

				assertNotNull(specs);
				assertEquals(1, specs.size());

				IChildCreationSpecification sp;

				sp = specs.get(0);
				assertEquals(myShop, sp.getParent());
				assertEquals(ShopPackage.Literals.SHOP__SHOP_ITEMS, sp.getReference());
				assertEquals(ShopPackage.Literals.SHOP_ITEM, sp.getChildType());
				assertEquals(1, sp.getIndex());
			}
		});

		/*
		 * null as parent
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(null, null);

				assertNotNull(specs);
				assertEquals(0, specs.size());
			}
		});

		/*
		 * null as parent and non-null sibling
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(null, myShopItem2);

				assertNotNull(specs);
				assertEquals(1, specs.size());

				IChildCreationSpecification sp;

				sp = specs.get(0);
				assertEquals(myShop, sp.getParent());
				assertEquals(ShopPackage.Literals.SHOP__SHOP_ITEMS, sp.getReference());
				assertEquals(ShopPackage.Literals.SHOP_ITEM, sp.getChildType());
				assertEquals(1, sp.getIndex());
			}
		});

		/*
		 * Child as parent
		 */
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				// TODO SVTB
				final TreeViewer tv = (TreeViewer) vb.getViewer();
				assertNotNull(tv);
				tv.expandAll();
				final Tree tree = tv.getTree();
				assertNotNull(tree);

				TreeItem item;
				item = tree.getItem(0);
				assertNotNull(item);
				item = item.getItem(0);
				assertNotNull(item);

				final Object data = item.getData();
				assertNotNull(data);
				assertTrue(data instanceof IConstantTreeItem);
				final IConstantTreeItem i = (IConstantTreeItem) data;

				final List<IChildCreationSpecification> specs = vb.getPossibleChildObjects(i, null);

				assertNotNull(specs);
				assertEquals(1, specs.size());

				IChildCreationSpecification sp;

				sp = specs.get(0);
				assertEquals(myShop, sp.getParent());
				assertEquals(ShopPackage.Literals.SHOP__CONTACTS, sp.getReference());
				assertEquals(ShopPackage.Literals.CONTACT, sp.getChildType());
				assertEquals(-1, sp.getIndex());
			}
		});
	}
}
