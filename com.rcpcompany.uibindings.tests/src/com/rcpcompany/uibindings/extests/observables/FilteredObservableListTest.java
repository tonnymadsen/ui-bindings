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
package com.rcpcompany.uibindings.extests.observables;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.observables.FilteredObservableList;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItemDescription;
import com.rcpcompany.uibindings.tests.shop.ShopItemURL;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;

/**
 * Test of {@link FilteredObservableList}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FilteredObservableListTest {
	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
	}

	int events = 0;
	private final IListChangeListener listener = new IListChangeListener() {
		@Override
		public void handleListChange(ListChangeEvent event) {
			if (event.diff.isEmpty()) return;
			events++;
		}
	};

	/**
	 * Tests the basic add/remove with the filter
	 */
	@Test
	public void testBasics() {
		final IObservableList master = new WritableList(new ArrayList<Object>(), EcorePackage.Literals.EINT);
		master.add(1);
		master.add(2);
		master.add(3);
		master.add(4);
		master.add(5);
		final FilteredObservableList l = new FilteredObservableList(master, new FilteredObservableList.IFilter() {
			@Override
			public boolean isIncluded(Object element) {
				return ((Integer) element) % 2 == 0;
			}
		});

		assertEquals(2, l.size());
		assertEquals(2, l.get(0));
		assertEquals(4, l.get(1));

		assertEquals(EcorePackage.Literals.EINT, l.getElementType());

		l.addListChangeListener(listener);
		assertEquals(0, events);

		master.add(7);

		assertEquals(2, l.size());
		assertEquals(2, l.get(0));
		assertEquals(4, l.get(1));

		assertEquals(0, events);

		master.add(8);

		assertEquals(3, l.size());
		assertEquals(2, l.get(0));
		assertEquals(4, l.get(1));
		assertEquals(8, l.get(2));

		assertEquals(1, events);

		master.remove(0); // = 1

		assertEquals(3, l.size());
		assertEquals(2, l.get(0));
		assertEquals(4, l.get(1));
		assertEquals(8, l.get(2));

		assertEquals(1, events);

		master.remove(2); // = 4

		assertEquals(2, l.size());
		assertEquals(2, l.get(0));
		assertEquals(8, l.get(1));

		assertEquals(2, events);

		master.clear();

		assertEquals(0, l.size());

		assertEquals(3, events);
	}

	@Test
	public void readOnly() {
		final IObservableList master = new WritableList(new ArrayList<Object>(), EcorePackage.Literals.EINT);
		master.add(1);
		master.add(2);
		master.add(3);
		master.add(4);
		master.add(5);
		final FilteredObservableList l = new FilteredObservableList(master, new FilteredObservableList.IFilter() {
			@Override
			public boolean isIncluded(Object element) {
				return ((Integer) element) % 2 == 0;
			}
		});

		try {
			l.add(9);
			fail();
		} catch (final UnsupportedOperationException ex) {
			// OK
		} catch (final Exception ex) {
			fail();
		}

		try {
			l.remove(0);
			fail();
		} catch (final UnsupportedOperationException ex) {
			// OK
		} catch (final Exception ex) {
			fail();
		}

		try {
			l.clear();
			fail();
		} catch (final UnsupportedOperationException ex) {
			// OK
		} catch (final Exception ex) {
			fail();
		}
	}

	@Test
	public void testSubclassFilter() {
		final IObservableList master = new WritableList(new ArrayList<Object>(), ShopPackage.Literals.SHOP_INFORMATION);
		final ShopItemDescription d0 = ShopFactory.eINSTANCE.createShopItemDescription();
		final ShopItemURL d1 = ShopFactory.eINSTANCE.createShopItemURL();
		final ShopItemURL d2 = ShopFactory.eINSTANCE.createShopItemURL();
		final ShopItemURL d3 = ShopFactory.eINSTANCE.createShopItemURL();
		final ShopItemDescription d4 = ShopFactory.eINSTANCE.createShopItemDescription();
		master.add(d0);
		master.add(d1);
		master.add(d2);
		master.add(d3);
		master.add(d4);

		final FilteredObservableList l0 = new FilteredObservableList(master, ShopPackage.Literals.SHOP_ITEM_DESCRIPTION);
		assertEquals(2, l0.size());
		assertEquals(d0, l0.get(0));
		assertEquals(d4, l0.get(1));
		assertEquals(ShopPackage.Literals.SHOP_ITEM_DESCRIPTION, l0.getElementType());

		final FilteredObservableList l1 = new FilteredObservableList(master, ShopPackage.Literals.SHOP_ITEM_INFORMATION);
		assertEquals(5, l1.size());
		assertEquals(d0, l1.get(0));
		assertEquals(d1, l1.get(1));
		assertEquals(d2, l1.get(2));
		assertEquals(d3, l1.get(3));
		assertEquals(d4, l1.get(4));
		assertEquals(ShopPackage.Literals.SHOP_ITEM_INFORMATION, l1.getElementType());
	}

	@Test
	public void testErrorInFilter() {
		final IObservableList master = new WritableList(new ArrayList<Object>(), ShopPackage.Literals.SHOP_INFORMATION);
		final ShopItemDescription d0 = ShopFactory.eINSTANCE.createShopItemDescription();
		final ShopItemURL d1 = ShopFactory.eINSTANCE.createShopItemURL();
		master.add(d0);
		master.add(d1);

		final FilteredObservableList listref[] = new FilteredObservableList[] { null };

		assertOneLog(new Runnable() {
			@Override
			public void run() {
				listref[0] = new FilteredObservableList(master, new FilteredObservableList.IFilter() {
					@Override
					public boolean isIncluded(Object element) {
						if (element == d1) throw new NullPointerException();
						return true;
					}
				});
			}
		});

		final FilteredObservableList list = listref[0];
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(d0, list.get(0));

		assertOneLog(new Runnable() {
			@Override
			public void run() {
				list.updateList();
			}
		});
	}
}
