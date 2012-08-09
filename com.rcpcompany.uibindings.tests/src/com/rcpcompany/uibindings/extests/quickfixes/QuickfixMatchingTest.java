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
package com.rcpcompany.uibindings.extests.quickfixes;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.bindingMessages.AbstractBindingMessage;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;

/**
 * Tests of how quick fix processors are matched against binding messages.
 * <p>
 * Have quite a bit of uiBindings declarations.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class QuickfixMatchingTest {

	final IManager mng = IManager.Factory.getManager();
	private Shop myShop;
	private ShopItem myShopItem;

	private Contact myContact;
	private Customer myCustomer;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		createShop();
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myShopItem = ShopFactory.eINSTANCE.createShopItem();
		myShopItem.setName("A");
		myShopItem.setPrice(100f);
		myShop.getShopItems().add(myShopItem);

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("A");
		myShop.getContacts().add(myContact);

		myCustomer = ShopFactory.eINSTANCE.createCustomer();
		myCustomer.setContact(myContact);
		myShop.getCustomers().add(myCustomer);
	}

	// @Test
	// public void testMatchingNoMatch() {
	// // no match
	// testQ(0, null, ShopPackage.Literals.CONTACT__CUSTOMER, null, Integer.MIN_VALUE, null);
	// }

	@Test
	public void testMatchingMatchOnModelType() {
		// match on model type
		testQ(1, myCustomer, null, null, Integer.MIN_VALUE, null);
	}

	@Test
	public void testMatchingMatchOnFeature() {
		// match on feature
		testQ(1, null, IMOAOPackage.Literals.NAMED_OBJECT__NAME, null, Integer.MIN_VALUE, null);
	}

	@Test
	public void testMatchingMatchOnIllegalComb() {
		// match on illegal combinations
		testQ(1, myShop, IMOAOPackage.Literals.NAMED_OBJECT__NAME, null, Integer.MIN_VALUE, null);
	}

	@Test
	public void testMatchingMatchOnSource() {
		// match on source
		testQ(1, null, null, "abc", Integer.MIN_VALUE, null);
	}

	@Test
	public void testMatchingMatchOnCode() {
		// match on code
		testQ(1, null, null, null, 12345, null);
	}

	@Test
	public void testMatchingMatchOnSourceAndCode() {
		// match on source and code
		testQ(3, null, null, "abc", 12345, null);
	}

	@Test
	public void testMatchingMatchOnMessagePattern() {
		// match on message pattern
		testQ(1, null, null, null, Integer.MIN_VALUE, "the car is red");
	}

	@Test
	public void testNonExistingProcessor() {
		testQ(-1, null, null, null, Integer.MIN_VALUE, "Reference to missing processor");
	}

	public void testQ(int expectedQuickfixes, EObject modelObject, EStructuralFeature feature, String source, int code,
			String message) {
		final Message m = new Message(null);
		m.addTarget(modelObject, feature, null);
		m.mySource = source;
		m.myCode = code;
		m.myMessage = message;

		final List<IQuickfixProposal> proposals = new ArrayList<IQuickfixProposal>();
		if (expectedQuickfixes >= 0) {
			assertNoLog(new Runnable() {
				@Override
				public void run() {
					mng.getQuickfixes(m, proposals);
				}
			});

			assertEquals(expectedQuickfixes, proposals.size());
		} else {
			assertOneLog(new Runnable() {
				@Override
				public void run() {
					mng.getQuickfixes(m, proposals);
				}
			});

			assertEquals(0, proposals.size());
		}
	}

	private class Message extends AbstractBindingMessage {

		public Message(IValueBinding binding) {
			super(binding);
		}

		public String mySource;
		public int myCode;
		public String myMessage;

		@Override
		public String getSource() {
			return mySource;
		}

		@Override
		public int getCode() {
			return myCode;
		}

		@Override
		public Object getData() {
			return null;
		}

		@Override
		public String getMessage() {
			return myMessage;
		}
	}
}
