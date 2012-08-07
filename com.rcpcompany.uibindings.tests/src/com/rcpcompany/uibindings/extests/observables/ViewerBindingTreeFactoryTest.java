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
package com.rcpcompany.uibindings.extests.observables;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IConstantTreeItem;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingsFactory;
import com.rcpcompany.uibindings.internal.ViewerBindingTreeFactory;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests {@link ViewerBindingTreeFactory}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerBindingTreeFactoryTest {

	private final static IManager MANAGER = IManager.Factory.getManager();

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("my shop");

		final Country country = ShopFactory.eINSTANCE.createCountry();
		country.setName("name");
		country.setName("abbreviation");
		country.setShop(myShop);

		for (int i = 0; i < 10; i++) {
			final Contact c = ShopFactory.eINSTANCE.createContact();
			c.setName("name " + i);
			c.setCountry(country);
			c.setShop(myShop);
		}

		for (int i = 0; i < 10; i++) {
			final ShopItem si = ShopFactory.eINSTANCE.createShopItem();
			si.setName("name " + i);
			si.setPrice(100f);
			si.setShop(myShop);
		}
	}

	private Shop myShop;

	/**
	 * Test that the correct items are created for a <code>null</code> type factory.
	 */
	@Test
	public void testNullType() {
		final List<EObject> expectedItems = new ArrayList<EObject>();
		final IConstantTreeItem folder = IUIBindingsFactory.eINSTANCE.createConstantTreeItem();
		folder.setDescriptor(MANAGER.getTreeItem("com.rcpcompany.uibindings.shop.treeItems.contactFolder"));
		expectedItems.add(folder);
		expectedItems.addAll(myShop.getShopItems());
		testOne(null, expectedItems);
	}

	/**
	 * Test that the correct items are created for a <code>""</code> type factory.
	 */
	@Test
	public void testEmptyType() {
		final List<EObject> expectedItems = new ArrayList<EObject>();
		final IConstantTreeItem folder = IUIBindingsFactory.eINSTANCE.createConstantTreeItem();
		folder.setDescriptor(MANAGER.getTreeItem("com.rcpcompany.uibindings.shop.treeItems.contactFolder"));
		expectedItems.add(folder);
		expectedItems.addAll(myShop.getShopItems());
		testOne("", expectedItems);
	}

	/**
	 * Test that the correct items are created for a <code>"contacts"</code> type factory.
	 */
	@Test
	public void testContactsType() {
		final List<EObject> expectedItems = new ArrayList<EObject>();
		final IConstantTreeItem folder = IUIBindingsFactory.eINSTANCE.createConstantTreeItem();
		folder.setDescriptor(MANAGER.getTreeItem("com.rcpcompany.uibindings.shop.treeItems.contactFolder"));
		expectedItems.add(folder);
		testOne("contacts", expectedItems);
	}

	/**
	 * Test that the correct items are created for a <code>"doesNotExist"</code> type factory.
	 */
	@Test
	public void testDoesNotExistType() {
		final List<EObject> expectedItems = new ArrayList<EObject>();
		testOne("doesNotExist", expectedItems);
	}

	/**
	 * Tests that the specified tree ID results in the specified tree items.
	 * 
	 * @param id the tree id
	 * @param expectedItems the expected items
	 */
	private void testOne(final String id, final List<EObject> expectedItems) {
		final IObservableList shopList = WritableList.withElementType(ShopPackage.Literals.SHOP);
		shopList.add(myShop);

		final ViewerBindingTreeFactory factory = new ViewerBindingTreeFactory(shopList, id);
		final IObservableList list1 = (IObservableList) factory.createObservable(myShop);

		assertEquals(expectedItems.size(), list1.size());
		for (int i = 0; i < expectedItems.size(); i++) {
			final String what = "Item[" + i + "]";
			final EObject e = expectedItems.get(i);
			final EObject a = (EObject) list1.get(i);

			if (e instanceof IConstantTreeItem) {
				assertTrue(what, a instanceof IConstantTreeItem);
				assertEquals(what, ((IConstantTreeItem) e).getDescriptor(), ((IConstantTreeItem) a).getDescriptor());
			} else {
				assertEquals(what, e, a);
			}
		}
	}
}
