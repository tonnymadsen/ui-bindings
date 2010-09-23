/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.junit.Test;

import com.rcpcompany.uibindings.EcoreExtUtils;
import com.rcpcompany.uibindings.EcoreExtUtils.SyncController;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests of {@link EcoreExtUtils#sync(EObject, EObject)} and friends.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class EcoreExtUtilsSyncTest {
	/**
	 * Test sync of a single attribute
	 */
	@Test
	public void testAttributeSync() {
		final Country source = ShopFactory.eINSTANCE.createCountry();
		source.setName("abc");
		source.setAbbreviation("AB");

		final Country target = ShopFactory.eINSTANCE.createCountry();
		target.setName("cba");
		target.setAbbreviation("AB");

		sync(target, source, null, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		assertEquals("abc", target.getName());
		assertEquals("AB", target.getAbbreviation());
	}

	/**
	 * Test sync of a reference
	 */
	@Test
	public void testReferenceSync() {
		final Contact source = ShopFactory.eINSTANCE.createContact();
		source.setName("Tonny");
		final Country sourceCountry = ShopFactory.eINSTANCE.createCountry();
		sourceCountry.setName("abc");
		sourceCountry.setAbbreviation("AB");
		source.setCountry(sourceCountry);

		final Contact target = ShopFactory.eINSTANCE.createContact();
		target.setName("Allan");
		final Country targetCountry = ShopFactory.eINSTANCE.createCountry();
		targetCountry.setName("cba");
		targetCountry.setAbbreviation("AB");
		target.setCountry(targetCountry);

		sync(target, source, null, IMOAOPackage.Literals.NAMED_OBJECT__NAME, ShopPackage.Literals.CONTACT__COUNTRY);

		assertEquals("Tonny", target.getName());
		assertEquals("cba", targetCountry.getName());// NOT CHANGED! Not containment
		assertEquals("AB", targetCountry.getAbbreviation());
	}

	/**
	 * Test sync of many-attribute
	 */
	@Test
	public void testManyAttributeSync1() {
		final ShopItem source = ShopFactory.eINSTANCE.createShopItem();
		source.setName("abc");
		source.getLocations().add("a");
		source.getLocations().add("b");

		final ShopItem target = ShopFactory.eINSTANCE.createShopItem();
		target.setName("abc");

		sync(target, source, null, ShopPackage.Literals.SHOP_ITEM__LOCATIONS, ShopPackage.Literals.SHOP_ITEM__LOCATIONS);

		assertEquals("abc", target.getName());
		assertEquals(2, target.getLocations().size());
		assertEquals("a", target.getLocations().get(0));
		assertEquals("b", target.getLocations().get(1));
	}

	/**
	 * Test sync of many-attribute
	 */
	@Test
	public void testManyAttributeSync2() {
		final ShopItem source = ShopFactory.eINSTANCE.createShopItem();
		source.setName("abc");
		source.getLocations().add("b");
		source.getLocations().add("q");

		final ShopItem target = ShopFactory.eINSTANCE.createShopItem();
		target.setName("abc");
		target.getLocations().add("b");
		target.getLocations().add("c");

		sync(target, source, null, ShopPackage.Literals.SHOP_ITEM__LOCATIONS);

		assertEquals("abc", target.getName());
		assertEquals(2, target.getLocations().size());
		assertEquals("b", target.getLocations().get(0));
		assertEquals("q", target.getLocations().get(1));
	}

	/**
	 * Test sync of many-attribute
	 */
	@Test
	public void testManyAttributeSync3() {
		final ShopItem source = ShopFactory.eINSTANCE.createShopItem();
		source.setName("abc");
		source.getLocations().add("d");
		source.getLocations().add("a");
		source.getLocations().add("b");
		source.getLocations().add("q");

		final ShopItem target = ShopFactory.eINSTANCE.createShopItem();
		target.setName("abc");
		target.getLocations().add("a");
		target.getLocations().add("b");
		target.getLocations().add("c");

		sync(target, source, null, ShopPackage.Literals.SHOP_ITEM__LOCATIONS, ShopPackage.Literals.SHOP_ITEM__LOCATIONS);

		assertEquals("abc", target.getName());
		assertEquals(4, target.getLocations().size());
		assertEquals("d", target.getLocations().get(0));
		assertEquals("a", target.getLocations().get(1));
		assertEquals("b", target.getLocations().get(2));
		assertEquals("q", target.getLocations().get(3));
	}

	/**
	 * Test sync of many-attribute
	 */
	@Test
	public void testManyAttributeSync4() {
		final ShopItem source = ShopFactory.eINSTANCE.createShopItem();
		source.setName("abc");
		source.getLocations().add("c");
		source.getLocations().add("d");

		final ShopItem target = ShopFactory.eINSTANCE.createShopItem();
		target.setName("abc");
		target.getLocations().add("a");
		target.getLocations().add("b");
		target.getLocations().add("c");
		target.getLocations().add("d");

		sync(target, source, null, ShopPackage.Literals.SHOP_ITEM__LOCATIONS, ShopPackage.Literals.SHOP_ITEM__LOCATIONS);

		assertEquals("abc", target.getName());
		assertEquals(2, target.getLocations().size());
		assertEquals("c", target.getLocations().get(0));
		assertEquals("d", target.getLocations().get(1));
	}

	/**
	 * Test sync of containment reference
	 */
	@Test
	public void testContainmentSync() {
		final Shop source = ShopFactory.eINSTANCE.createShop();
		final ShopItem shopItem1 = ShopFactory.eINSTANCE.createShopItem();
		shopItem1.setName("1");
		shopItem1.setPrice(100f);
		shopItem1.setShop(source);
		final ShopItem shopItem2a = ShopFactory.eINSTANCE.createShopItem();
		shopItem2a.setName("2");
		shopItem2a.setPrice(100f);
		shopItem2a.setShop(source);

		final Shop target = ShopFactory.eINSTANCE.createShop();
		final ShopItem shopItem2b = ShopFactory.eINSTANCE.createShopItem();
		shopItem2b.setName("2");
		shopItem2b.setPrice(200f);
		shopItem2b.setShop(target);

		sync(target, source, null, ShopPackage.Literals.SHOP_ITEM__PRICE, ShopPackage.Literals.SHOP__SHOP_ITEMS);

		assertEquals(2, target.getShopItems().size());
		assertEquals(target, shopItem1.getShop());
		assertEquals(target, shopItem2b.getShop());
		assertEquals(100f, shopItem2b.getPrice(), 0.001f);
	}

	/**
	 * Test sync of containment reference
	 */
	@Test
	public void testContainmentListSync() {
		final Shop source = ShopFactory.eINSTANCE.createShop();
		final ShopItem shopItem1 = ShopFactory.eINSTANCE.createShopItem();
		shopItem1.setName("1");
		shopItem1.setPrice(100f);
		shopItem1.setShop(source);
		final ShopItem shopItem2a = ShopFactory.eINSTANCE.createShopItem();
		shopItem2a.setName("2");
		shopItem2a.setPrice(100f);
		shopItem2a.setShop(source);

		final Shop target = ShopFactory.eINSTANCE.createShop();
		final ShopItem shopItem2b = ShopFactory.eINSTANCE.createShopItem();
		shopItem2b.setName("2");
		shopItem2b.setPrice(200f);
		shopItem2b.setShop(target);

		sync(target, target.getShopItems(), source.getShopItems(), null, ShopPackage.Literals.SHOP_ITEM__PRICE,
				ShopPackage.Literals.SHOP__SHOP_ITEMS);

		assertEquals(2, target.getShopItems().size());
		assertEquals(target, shopItem1.getShop());
		assertEquals(target, shopItem2b.getShop());
		assertEquals(100f, shopItem2b.getPrice(), 0.001f);
	}

	/**
	 * Test sync of containment reference
	 */
	@Test
	public void testContainmentListSync2() {
		final EList<ShopItem> sourceList = new BasicEList<ShopItem>();
		final ShopItem shopItem1 = ShopFactory.eINSTANCE.createShopItem();
		shopItem1.setName("1");
		shopItem1.setPrice(100f);
		sourceList.add(shopItem1);
		final ShopItem shopItem2a = ShopFactory.eINSTANCE.createShopItem();
		shopItem2a.setName("2");
		shopItem2a.setPrice(100f);
		sourceList.add(shopItem2a);

		final Shop target = ShopFactory.eINSTANCE.createShop();
		final ShopItem shopItem2b = ShopFactory.eINSTANCE.createShopItem();
		shopItem2b.setName("2");
		shopItem2b.setPrice(200f);
		shopItem2b.setShop(target);
		final ShopItem shopItem3 = ShopFactory.eINSTANCE.createShopItem();
		shopItem3.setName("3");
		shopItem3.setPrice(300f);
		shopItem3.setShop(target);

		sync(target, target.getShopItems(), sourceList, new EObject[] { shopItem3 },
				ShopPackage.Literals.SHOP_ITEM__PRICE, ShopPackage.Literals.SHOP__SHOP_ITEMS,
				ShopPackage.Literals.SHOP_ITEM__SHOP, ShopPackage.Literals.SHOP__SHOP_ITEMS);

		assertEquals(2, target.getShopItems().size());
		assertEquals(target, shopItem1.getShop());
		assertEquals(target, shopItem2b.getShop());
		assertEquals(100f, shopItem2b.getPrice(), 0.001f);
	}

	/**
	 * Test sync of containment reference (based on problem from 3Dfacto)
	 */
	@Test
	public void testContainmentListSync3() {
		final Shop source = ShopFactory.eINSTANCE.createShop();
		source.setName("source");
		final ShopItem shopItem3a = ShopFactory.eINSTANCE.createShopItem();
		shopItem3a.setName("3");
		shopItem3a.setPrice(100f);
		shopItem3a.setShop(source);
		final ShopItem shopItem4a = ShopFactory.eINSTANCE.createShopItem();
		shopItem4a.setName("4");
		shopItem4a.setPrice(120f);
		shopItem4a.setShop(source);

		final Shop target = ShopFactory.eINSTANCE.createShop();
		target.setName("target");
		final ShopItem shopItem1 = ShopFactory.eINSTANCE.createShopItem();
		shopItem1.setName("1");
		shopItem1.setPrice(100f);
		shopItem1.setShop(target);
		final ShopItem shopItem2 = ShopFactory.eINSTANCE.createShopItem();
		shopItem2.setName("2");
		shopItem2.setPrice(100f);
		shopItem2.setShop(target);
		final ShopItem shopItem3b = ShopFactory.eINSTANCE.createShopItem();
		shopItem3b.setName("3");
		shopItem3b.setPrice(200f);
		shopItem3b.setShop(target);
		final ShopItem shopItem4b = ShopFactory.eINSTANCE.createShopItem();
		shopItem4b.setName("4");
		shopItem4b.setPrice(200f);
		shopItem4b.setShop(target);

		sync(target, target.getShopItems(), source.getShopItems(), new EObject[] { shopItem1, shopItem2 },
				ShopPackage.Literals.SHOP__SHOP_ITEMS, ShopPackage.Literals.SHOP_ITEM__SHOP,
				ShopPackage.Literals.SHOP__SHOP_ITEMS, ShopPackage.Literals.SHOP_ITEM__SHOP,
				ShopPackage.Literals.SHOP_ITEM__PRICE, ShopPackage.Literals.SHOP_ITEM__PRICE);

		assertEquals(2, target.getShopItems().size());
		assertEquals(target, shopItem3b.getShop());
		assertEquals(target, shopItem4b.getShop());
		assertEquals(100f, shopItem3b.getPrice(), 0.001f);
		assertEquals(120f, shopItem4b.getPrice(), 0.001f);
	}

	private final List<EStructuralFeature> myChanges = new ArrayList<EStructuralFeature>();
	private final EContentAdapter myChangeListener = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			if (msg.isTouch()) return;
			final EStructuralFeature sf = (EStructuralFeature) msg.getFeature();
			if (sf == null) return;
			// LogUtils.debug(this, ">>> " + sf.getContainerClass().getName() + "." + sf.getName() +
			// ": " + msg);
			myChanges.add(sf);
		}
	};

	private <T extends EObject> void sync(T target, T source, Object[] expectedRemovedObjects,
			EStructuralFeature... expectedFeatureChanges) {
		SyncController controller = null;
		try {
			myChanges.clear();
			target.eAdapters().add(myChangeListener);
			controller = EcoreExtUtils.sync(target, source);
		} finally {
			target.eAdapters().remove(myChangeListener);
		}

		final EStructuralFeature[] actualFeatureChanges = myChanges.toArray(new EStructuralFeature[myChanges.size()]);
		Arrays.sort(expectedFeatureChanges, SF_COMPARATOR);
		Arrays.sort(actualFeatureChanges, SF_COMPARATOR);
		assertArrayEquals(expectedFeatureChanges, actualFeatureChanges);

		if (expectedRemovedObjects == null) {
			assertEquals(null, controller.getRemovedObjects());
		} else {
			assertNotNull(controller.getRemovedObjects());
			final Object[] actualRemovedObjects = controller.getRemovedObjects().toArray(new Object[0]);
			Arrays.sort(expectedRemovedObjects, OBJECT_COMPARATOR);
			Arrays.sort(actualRemovedObjects, OBJECT_COMPARATOR);
			assertArrayEquals(expectedFeatureChanges, actualFeatureChanges);
		}
	}

	private <T extends EObject> void sync(EObject targetOwner, EList<T> target, EList<T> source,
			Object[] expectedRemovedObjects, EStructuralFeature... expectedFeatureChanges) {
		SyncController controller = null;
		try {
			myChanges.clear();
			targetOwner.eAdapters().add(myChangeListener);
			controller = EcoreExtUtils.sync(target, source);
		} finally {
			targetOwner.eAdapters().remove(myChangeListener);
		}

		final EStructuralFeature[] actualFeatureChanges = myChanges.toArray(new EStructuralFeature[myChanges.size()]);
		Arrays.sort(expectedFeatureChanges, SF_COMPARATOR);
		Arrays.sort(actualFeatureChanges, SF_COMPARATOR);
		assertArrayEquals(expectedFeatureChanges, actualFeatureChanges);

		if (expectedRemovedObjects == null) {
			assertEquals(null, controller.getRemovedObjects());
		} else {
			final Object[] actualRemovedObjects = controller.getRemovedObjects().toArray(new Object[0]);
			Arrays.sort(expectedRemovedObjects, OBJECT_COMPARATOR);
			Arrays.sort(actualRemovedObjects, OBJECT_COMPARATOR);
			assertArrayEquals(expectedFeatureChanges, actualFeatureChanges);
		}
	}

	private static final Comparator<EStructuralFeature> SF_COMPARATOR = new Comparator<EStructuralFeature>() {
		@Override
		public int compare(EStructuralFeature sf1, EStructuralFeature sf2) {
			return System.identityHashCode(sf1) - System.identityHashCode(sf2);
		}
	};

	private static final Comparator<Object> OBJECT_COMPARATOR = new Comparator<Object>() {
		@Override
		public int compare(Object sf1, Object sf2) {
			return System.identityHashCode(sf1) - System.identityHashCode(sf2);
		}
	};
}
