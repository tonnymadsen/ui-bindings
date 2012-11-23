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
package com.rcpcompany.uibindings.internal.validators;

import static com.rcpcompany.test.utils.EMFTestUtils.*;
import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.uibindings.validators.EValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests the basic functionality of {@link ValidatorAdapterManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ValidationAdapterManagerTest {

	private Shop myShop;
	private ShopItem myItem;

	@Before
	public void reset() {
		IValidatorAdapterManager.Factory.getManager().reset();

		myShop = ShopFactory.eINSTANCE.createShop();
		myItem = ShopFactory.eINSTANCE.createShopItem();
		myItem.setName("no name");
		myItem.setPrice(200f);
		myItem.setShop(myShop);
	}

	@Test
	public void testSingleton() {
		final ValidatorAdapterManager manager = (ValidatorAdapterManager) IValidatorAdapterManager.Factory.getManager();
		assertNotNull(manager);
		assertEquals(manager, IValidatorAdapterManager.Factory.getManager());
		assertEquals(manager, IManager.Factory.getManager().getService(ValidatorAdapterManager.class));
	}

	@Test
	public void addRemoveValidatorAdapters() {
		final EValidatorAdapter validationAdapter = new EValidatorAdapter();
		final EValidatorAdapter altValidationAdapter = new EValidatorAdapter();

		final ValidatorAdapterManager vam = (ValidatorAdapterManager) IValidatorAdapterManager.Factory.getManager();
		final int initValidationAdapters = vam.myValidationRoots.size();

		final int initShopAdapterCount = myShop.eAdapters().size();
		final int initItemAdapterCount = myItem.eAdapters().size();

		/*
		 * Add adapter: one more root and one more adapter on all objects
		 */
		vam.addRoot(myShop, validationAdapter);
		assertEquals(initValidationAdapters + 1, vam.myValidationRoots.size());

		final int shopAdapterCount = myShop.eAdapters().size();
		final int itemAdapterCount = myItem.eAdapters().size();

		assertTrue(initShopAdapterCount < shopAdapterCount);
		assertTrue(initItemAdapterCount < itemAdapterCount);

		/*
		 * Add extra adapter: no change
		 */
		vam.addRoot(myShop, altValidationAdapter);
		assertEquals(initValidationAdapters + 1, vam.myValidationRoots.size());

		assertAdapters(shopAdapterCount, myShop);
		assertAdapters(itemAdapterCount, myItem);

		/*
		 * remove adapter: no change
		 */
		vam.removeRoot(myShop, altValidationAdapter);
		assertEquals(initValidationAdapters + 1, vam.myValidationRoots.size());

		assertAdapters(shopAdapterCount, myShop);
		assertAdapters(itemAdapterCount, myItem);

		/*
		 * remove last adapter: root and adapters removed
		 */
		vam.removeRoot(myShop, validationAdapter);
		assertEquals(initValidationAdapters, vam.myValidationRoots.size());

		assertAdapters(initShopAdapterCount, myShop);
		assertAdapters(initItemAdapterCount, myItem);

		/*
		 * Add two adapters: root and adapters added again
		 */
		vam.addRoot(myShop, validationAdapter);
		vam.addRoot(myShop, altValidationAdapter);
		assertEquals(initValidationAdapters + 1, vam.myValidationRoots.size());

		assertAdapters(shopAdapterCount, myShop);
		assertAdapters(itemAdapterCount, myItem);

		/*
		 * remove all adapters: root and adapters removed
		 */
		vam.removeRoot(myShop);
		assertEquals(initValidationAdapters, vam.myValidationRoots.size());

		assertAdapters(initShopAdapterCount, myShop);
		assertAdapters(initItemAdapterCount, myItem);
	}

	/**
	 * Tests {@link IValidatorAdapterManager#executeWithoutValidation(Runnable)}
	 */
	@Test
	public void testWithoutValidation1() {
		testOneWithoutValidation(false);
	}

	/**
	 * Tests {@link IValidatorAdapterManager#executeWithoutValidation(Runnable)}
	 */
	@Test
	public void testWithoutValidation2() {
		testOneWithoutValidation(true);
	}

	/**
	 * 
	 */
	private void testOneWithoutValidation(boolean setBeforeRunnable) {
		final int VD = IManager.Factory.getManager().getValidationDelay();
		final ValidatorAdapterManager vam = (ValidatorAdapterManager) IValidatorAdapterManager.Factory.getManager();
		vam.addRoot(myShop, new ConstraintValidatorAdapter());

		sleep(2 * VD);
		assertEquals(0, vam.getUnboundMessages().size());

		if (setBeforeRunnable) {
			myItem.setPrice(-2.0f);
		}
		vam.executeWithoutValidation(new Runnable() {
			@Override
			public void run() {
				assertEquals(0, vam.getUnboundMessages().size());
				myItem.setPrice(-1.0f);
				sleep(2 * VD);
				assertEquals(0, vam.getUnboundMessages().size());
			}
		});
		assertEquals(0, vam.getUnboundMessages().size());
		sleep(2 * VD);
		assertEquals(1, vam.getUnboundMessages().size());
	}
}
