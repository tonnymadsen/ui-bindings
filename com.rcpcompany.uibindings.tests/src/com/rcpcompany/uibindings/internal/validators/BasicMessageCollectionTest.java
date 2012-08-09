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

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.validators.EValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests the basic collection of messages from {@link IValidatorAdapter validation adapters}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BasicMessageCollectionTest {

	private static final int VD = 200;
	private IValidatorAdapterManager myManager;
	private Shop myShop;
	private Country myCountry;
	private IValidatorAdapter myValidationAdapter;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setValidationDelay(VD);

		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("xx");

		myManager = IValidatorAdapterManager.Factory.getManager();
		myValidationAdapter = new EValidatorAdapter();
		myManager.addRoot(myShop, myValidationAdapter);
	}

	@After
	public void after() {
		myManager.removeRoot(myShop, myValidationAdapter);
	}

	@Test
	public void testDelay() {
		/*
		 * Initial situation
		 */
		sleep(2 * VD);
		// LogUtils.debug(this, "um: " + myManager.getUnboundMessages());
		assertEquals(0, myManager.getUnboundMessages().size());
		assertEquals(0, myManager.getUnboundMessagesOL().size());

		/*
		 * Country added with missing name and abbreviation, which are required
		 */
		myCountry = ShopFactory.eINSTANCE.createCountry();
		myShop.getCountries().add(myCountry);

		sleep(VD / 2);
		assertEquals(0, myManager.getUnboundMessages().size());
		assertEquals(0, myManager.getUnboundMessagesOL().size());

		sleep(2 * VD);
		assertEquals(2, myManager.getUnboundMessages().size());
		assertEquals(2, myManager.getUnboundMessagesOL().size());
	}

	@Test
	public void testBasicCollection() {
		/*
		 * Initial situation
		 */
		sleep(2 * VD);
		assertEquals(0, myManager.getUnboundMessages().size());
		assertEquals(0, myManager.getUnboundMessagesOL().size());

		/*
		 * Country added with missing name and abbreviation, which are required
		 */
		myCountry = ShopFactory.eINSTANCE.createCountry();
		myShop.getCountries().add(myCountry);

		sleep(2 * VD);
		// name and abbreviation required
		assertEquals(2, myManager.getUnboundMessages().size());
		assertEquals(2, myManager.getUnboundMessagesOL().size());

		/*
		 * Country name set - abbreviation still missing.
		 */
		myCountry.setName("no name");

		sleep(2 * VD);
		// abbreviation required
		assertEquals(1, myManager.getUnboundMessages().size());
		assertEquals(1, myManager.getUnboundMessagesOL().size());

		/*
		 * Same
		 */
		myCountry.setName("no name 2");

		sleep(2 * VD);
		// abbreviation required
		assertEquals(1, myManager.getUnboundMessages().size());
		assertEquals(1, myManager.getUnboundMessagesOL().size());
	}

	/**
	 * Checks that messages are correctly recalulated.
	 */
	@Test
	public void testBasicUpdateOfMessage() {
		/*
		 * Initial situation
		 */
		sleep(2 * VD);
		assertEquals(0, myManager.getUnboundMessages().size());

		/*
		 * Country added with lowercase abbreviation
		 */
		myCountry = ShopFactory.eINSTANCE.createCountry();
		myShop.getCountries().add(myCountry);
		myCountry.setName("noname country");

		myCountry.setAbbreviation("nc");
		sleep(2 * VD);
		assertEquals(1, myManager.getUnboundMessages().size());
		final IBindingMessage message1 = myManager.getUnboundMessages().get(0);
		assertTrue(message1.getMessage().contains("'" + myCountry.getAbbreviation() + "'"));

		/*
		 * Change abbreviation and check the message is changed as well.
		 */
		myCountry.setAbbreviation("cn");
		sleep(2 * VD);
		assertEquals(1, myManager.getUnboundMessages().size());
		final IBindingMessage message2 = myManager.getUnboundMessages().get(0);
		assertTrue(message2.getMessage().contains("'" + myCountry.getAbbreviation() + "'"));

		/*
		 * Change abbreviation to something correct.
		 */
		myCountry.setAbbreviation("CN");
		sleep(2 * VD);
		assertEquals(0, myManager.getUnboundMessages().size());
	}
}
