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

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.ViewerBindingTreeFactory;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Performance tests {@link ViewerBindingTreeFactory}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ViewerBindingTreeFactoryPerformanceTest {
	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);
	}

	private Shop createModel(int size) {
		final long startTime = System.currentTimeMillis();
		int noObjs = 0;

		final Shop shop = ShopFactory.eINSTANCE.createShop();
		noObjs++;
		shop.setName("my shop");

		final Country country = ShopFactory.eINSTANCE.createCountry();
		noObjs++;
		country.setName("name");
		country.setName("abbreviation");
		country.setShop(shop);

		for (int i = 0; i < size; i++) {
			final Contact c = ShopFactory.eINSTANCE.createContact();
			noObjs++;
			c.setName("name " + i);
			c.setCountry(country);
			c.setShop(shop);
		}

		final long endTime = System.currentTimeMillis();
		LogUtils.debug(this, "model: " + (endTime - startTime) + "ms for " + noObjs + " objects");

		return shop;
	}

	private static final int[] SIZES = new int[] { 10, 100, 1000, 10000 };

	/**
	 * Tests that the construction time and retrieval is linear and not exponential
	 */
	@Test
	public void testConstructionTime() {
		for (final int size : SIZES) {
			final Shop shop = createModel(size);
			final IObservableList shopList = WritableList.withElementType(ShopPackage.Literals.SHOP);
			shopList.add(shop);

			final long t1 = System.currentTimeMillis();
			/*
			 * Construction
			 */
			final ViewerBindingTreeFactory factory = new ViewerBindingTreeFactory(shopList, null);
			final long t2 = System.currentTimeMillis();

			/*
			 * 1st level child is a folder
			 */
			final IObservableList list1 = (IObservableList) factory.createObservable(shop);
			assertEquals(1, list1.size());
			final long t3 = System.currentTimeMillis();

			/*
			 * 2nd level children is all contacts
			 */
			final IObservableList list2 = (IObservableList) factory.createObservable(list1.get(0));
			assertEquals(size, list2.size());
			final long t4 = System.currentTimeMillis();

			LogUtils.debug(this, " - construction " + (t2 - t1) + "ms");
			LogUtils.debug(this, " - 1st level get " + (t3 - t2) + "ms");
			LogUtils.debug(this, " - 2nd level get " + (t4 - t3) + "ms");
		}
	}

	/**
	 * Tests that the time to remove and add elements is linear and not exponential
	 */
	@Test
	public void testRecalcTime() {
		for (final int size : SIZES) {
			final Shop shop = createModel(size);
			final IObservableList shopList = WritableList.withElementType(ShopPackage.Literals.SHOP);
			shopList.add(shop);

			final ViewerBindingTreeFactory factory = new ViewerBindingTreeFactory(shopList, null);
			final IObservableList list1 = (IObservableList) factory.createObservable(shop);
			assertEquals(1, list1.size());
			final IObservableList list2 = (IObservableList) factory.createObservable(list1.get(0));
			assertEquals(size, list2.size());

			/*
			 * Remove and add half of the contacts
			 */
			final List<Contact> halfList = new ArrayList<Contact>(shop.getContacts().subList(0, size / 2));
			final long t1 = System.currentTimeMillis();
			for (final Contact c : halfList) {
				c.setShop(null);
			}
			final long t2 = System.currentTimeMillis();
			for (final Contact c : halfList) {
				c.setShop(shop);
			}
			final long t3 = System.currentTimeMillis();

			LogUtils.debug(this, " - remove ½ " + (t2 - t1) + "ms");
			LogUtils.debug(this, " - re-add ½ " + (t3 - t2) + "ms");
		}
	}
}
