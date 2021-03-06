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
package com.rcpcompany.uibindings.model.utils.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.test.utils.EMFTestUtils;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.model.utils.BasicUtils;
import com.rcpcompany.uibindings.model.utils.EcoreExtendedUtils;
import com.rcpcompany.uibindings.model.utils.EcoreExtendedUtils.SyncController;
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
public class EcoreExtendedUtilsSyncTest {
	/**
	 * Check a few constraints on the model is correct
	 */
	@Before
	public void modelRequirements() {
		final EReference ref = ShopPackage.Literals.SHOP__SHOP_ITEMS;
		assertNotNull(ref);
		final List<EAttribute> keys = ref.getEKeys();
		assertNotNull(keys);
		assertEquals(1, keys.size());
		assertEquals("name", keys.get(0).getName());
	}

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

		sync(target, source, null, IMOAOPackage.Literals.NAMED_OBJECT__NAME, ShopPackage.Literals.CONTACT__COUNTRY,
				ShopPackage.Literals.CONTACT__COUNTRY); // Country: s -> null ->
														// t

		assertEquals("Tonny", target.getName());
		assertEquals("cba", targetCountry.getName());// NOT CHANGED! Not
														// containment
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
	 * Test sync of mixed containment/non-containment references.
	 * <p>
	 * contact1 is new and moved to target. BUT the country of the contact (reference) must be updated to country2
	 */
	@Test
	public void testContainmentMixedSync() {
		final Shop source = ShopFactory.eINSTANCE.createShop();
		final Country country1 = ShopFactory.eINSTANCE.createCountry();
		country1.setAbbreviation("DK");
		country1.setName("Denmark");
		country1.setShop(source);

		final Contact contact1 = ShopFactory.eINSTANCE.createContact();
		contact1.setName("Tonny");
		contact1.setCountry(country1);
		contact1.setShop(source);

		final Shop target = ShopFactory.eINSTANCE.createShop();
		final Country country2 = ShopFactory.eINSTANCE.createCountry();
		country2.setAbbreviation("DK");
		country2.setName("Danmark");
		country2.setShop(target);

		sync(target, source, null, IMOAOPackage.Literals.NAMED_OBJECT__NAME, ShopPackage.Literals.SHOP__CONTACTS,
				ShopPackage.Literals.CONTACT__COUNTRY, ShopPackage.Literals.COUNTRY__CONTACTS);

		assertEquals(1, target.getCountries().size());
		assertEquals(1, target.getContacts().size());
		assertEquals(target, country2.getShop());
		assertEquals(target, contact1.getShop());
		assertEquals(country2, contact1.getCountry());
		assertEquals("Denmark", country2.getName());
	}

	/**
	 * Test sync of containment reference
	 */
	@Test
	public void testContainmentListSync1() {
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

	/**
	 * Test sync of containment reference (based on problem from 3Dfacto)
	 */
	@Test
	public void testContainmentListSync4() {
		final Shop source = ShopFactory.eINSTANCE.createShop();
		source.setName("source");
		final ShopItem shopItem1a = ShopFactory.eINSTANCE.createShopItem();
		shopItem1a.setName("1");
		shopItem1a.setPrice(100f);
		shopItem1a.setShop(source);
		final ShopItem shopItem2a = ShopFactory.eINSTANCE.createShopItem();
		shopItem2a.setName("2");
		shopItem2a.setPrice(100f);
		shopItem2a.setShop(source);
		final ShopItem shopItem3a = ShopFactory.eINSTANCE.createShopItem();
		shopItem3a.setName("3");
		shopItem3a.setPrice(100f);
		shopItem3a.setShop(source);
		final ShopItem shopItem4a = ShopFactory.eINSTANCE.createShopItem();
		shopItem4a.setName("4");
		shopItem4a.setPrice(100f);
		shopItem4a.setShop(source);

		final Shop target = ShopFactory.eINSTANCE.createShop();
		target.setName("target");
		final ShopItem shopItem1b = ShopFactory.eINSTANCE.createShopItem();
		shopItem1b.setName("1");
		shopItem1b.setPrice(100f);
		shopItem1b.setShop(target);
		final ShopItem shopItem3b = ShopFactory.eINSTANCE.createShopItem();
		shopItem3b.setName("3");
		shopItem3b.setPrice(100f);
		shopItem3b.setShop(target);
		final ShopItem shopItem2b = ShopFactory.eINSTANCE.createShopItem();
		shopItem2b.setName("2");
		shopItem2b.setPrice(100f);
		shopItem2b.setShop(target);

		sync(target, target.getShopItems(), source.getShopItems(), null, ShopPackage.Literals.SHOP__SHOP_ITEMS,
				ShopPackage.Literals.SHOP__SHOP_ITEMS);

		assertEquals(4, target.getShopItems().size());
		assertEquals(target, shopItem1b.getShop());
		assertEquals(target, shopItem2b.getShop());
		assertEquals(target, shopItem3b.getShop());
		assertEquals(target, shopItem4a.getShop());
	}

	private final List<EStructuralFeature> myChanges = new ArrayList<EStructuralFeature>();
	private final EContentAdapter myChangeListener = new EContentAdapter() {
		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);
			if (msg.isTouch())
				return;
			final EStructuralFeature sf = (EStructuralFeature) msg.getFeature();
			if (sf == null)
				return;
			// LogUtils.debug(this,
			// ">>> " + sf.getContainerClass().getName() + "." + sf.getName() + ": " + TSEMFUtils.toString(msg));
			myChanges.add(sf);
		}
	};

	private <T extends EObject> void sync(T target, T source, Object[] expectedRemovedObjects,
			EStructuralFeature... expectedFeatureChanges) {
		SyncController controller = null;
		try {
			myChanges.clear();
			target.eAdapters().add(myChangeListener);
			controller = EcoreExtendedUtils.sync(null, target, source);
		} finally {
			target.eAdapters().remove(myChangeListener);
		}

		final EStructuralFeature[] actualFeatureChanges = myChanges.toArray(new EStructuralFeature[myChanges.size()]);
		Arrays.sort(expectedFeatureChanges, EMFTestUtils.SF_COMPARATOR);
		Arrays.sort(actualFeatureChanges, EMFTestUtils.SF_COMPARATOR);
		assertArrayEquals(expectedFeatureChanges, actualFeatureChanges);

		if (expectedRemovedObjects == null) {
			assertEquals(null, controller.getRemovedObjects());
		} else {
			assertNotNull(controller.getRemovedObjects());
			final Object[] actualRemovedObjects = controller.getRemovedObjects().toArray(new Object[0]);
			Arrays.sort(expectedRemovedObjects, BasicUtils.OBJECT_COMPARATOR);
			Arrays.sort(actualRemovedObjects, BasicUtils.OBJECT_COMPARATOR);
			assertArrayEquals(expectedFeatureChanges, actualFeatureChanges);
		}
	}

	private <T extends EObject> void sync(EObject targetOwner, EList<T> target, EList<T> source,
			Object[] expectedRemovedObjects, EStructuralFeature... expectedFeatureChanges) {
		SyncController controller = null;
		try {
			myChanges.clear();
			targetOwner.eAdapters().add(myChangeListener);
			controller = EcoreExtendedUtils.sync(null, target, source);
		} finally {
			targetOwner.eAdapters().remove(myChangeListener);
		}

		final EStructuralFeature[] actualFeatureChanges = myChanges.toArray(new EStructuralFeature[myChanges.size()]);
		Arrays.sort(expectedFeatureChanges, EMFTestUtils.SF_COMPARATOR);
		Arrays.sort(actualFeatureChanges, EMFTestUtils.SF_COMPARATOR);
		assertArrayEquals(expectedFeatureChanges, actualFeatureChanges);

		final List<EObject> removedObjects = controller.getRemovedObjects();
		if (expectedRemovedObjects == null || expectedRemovedObjects.length == 0) {
			assertEquals(null, removedObjects);
		} else {
			assertNotNull(removedObjects);
			final Object[] actualRemovedObjects = removedObjects.toArray(new Object[0]);
			Arrays.sort(expectedRemovedObjects, BasicUtils.OBJECT_COMPARATOR);
			Arrays.sort(actualRemovedObjects, BasicUtils.OBJECT_COMPARATOR);
			assertArrayEquals(expectedFeatureChanges, actualFeatureChanges);
		}
	}

}
