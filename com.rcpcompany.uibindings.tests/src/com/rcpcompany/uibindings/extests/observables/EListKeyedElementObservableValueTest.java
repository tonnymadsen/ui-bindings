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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.observables.EListKeyedElementObservableValue;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Test of {@link EListKeyedElementObservableValue}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EListKeyedElementObservableValueTest {
	private Shop myShop1;
	private Contact myContact1a;
	private Contact myContact1b;

	private Shop myShop2;

	@Before
	public void before() {
		resetAll();

		myShop1 = ShopFactory.eINSTANCE.createShop();
		myShop1.setName("1");

		myContact1a = ShopFactory.eINSTANCE.createContact();
		myContact1a.setName("1a");
		myContact1a.setAddress("1A");
		myContact1a.setCity("dummy");

		myContact1b = ShopFactory.eINSTANCE.createContact();
		myContact1b.setName("1b");
		myContact1b.setAddress("1B");
		myContact1b.setCity("dummy");

		myShop2 = ShopFactory.eINSTANCE.createShop();
		myShop2.setName("2");

	}

	protected int changeCount = 0;

	public EditingDomain myEditingDomain = EditingDomainUtils.getEditingDomain();

	@Test
	public void ovTest() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IObservableValue shopOV = WritableValue.withValueType(ShopPackage.Literals.SHOP);

				final EListKeyedElementObservableValue<Contact> ov = new EListKeyedElementObservableValue<Contact>(
						myEditingDomain, shopOV, ShopPackage.Literals.SHOP__CONTACTS,
						IMOAOPackage.Literals.NAMED_OBJECT__NAME, "1b", ShopPackage.Literals.CONTACT__ADDRESS);

				assertEquals(ShopPackage.Literals.CONTACT__ADDRESS, ov.getValueType());
				assertEquals(null, ov.getValue());

				shopOV.setValue(myShop1);

				testSeq(ov, shopOV);
			}
		});
	}

	@Test
	public void eobjTest() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final EListKeyedElementObservableValue<Contact> ov = new EListKeyedElementObservableValue<Contact>(
						myEditingDomain, myShop1, ShopPackage.Literals.SHOP__CONTACTS,
						IMOAOPackage.Literals.NAMED_OBJECT__NAME, "1b", ShopPackage.Literals.CONTACT__ADDRESS);

				testSeq(ov, null);
			}
		});
	}

	/**
	 * @param ov
	 * @param shopOV
	 */
	private void testSeq(final EListKeyedElementObservableValue<Contact> ov, final IObservableValue shopOV) {
		assertEquals(ShopPackage.Literals.CONTACT__ADDRESS, ov.getValueType());
		assertEquals(null, ov.getValue());

		/*
		 * Add elements to the list and see the value change
		 */
		myShop1.getContacts().add(myContact1a);
		assertEquals(null, ov.getValue());

		myShop1.getContacts().add(myContact1b);
		assertEquals("1B", ov.getValue());

		assertEquals(0, myShop1.eAdapters().size());
		assertEquals(0, myContact1a.eAdapters().size());
		assertEquals(0, myContact1b.eAdapters().size());
		assertEquals(0, myShop2.eAdapters().size());

		final IValueChangeListener listener = new IValueChangeListener() {
			@Override
			public void handleValueChange(ValueChangeEvent event) {
				changeCount++;
			}
		};

		/*
		 * Add a listener and see the changes
		 */
		changeCount = 0;
		ov.addValueChangeListener(listener);

		myShop1.getContacts().remove(myContact1a);
		assertEquals(0, changeCount);
		assertEquals("1B", ov.getValue());

		myShop1.getContacts().remove(myContact1b);
		assertEquals(1, changeCount);
		assertEquals(null, ov.getValue());

		/*
		 * Change the value both values
		 */
		myShop1.getContacts().add(myContact1b);
		assertEquals(2, changeCount);
		assertEquals("1B", ov.getValue());

		ov.setValue("1B+");
		assertEquals(3, changeCount);
		assertEquals("1B+", ov.getValue());
		assertEquals("1B+", myContact1b.getAddress());

		myContact1a.setAddress("1A+");
		assertEquals(3, changeCount);
		assertEquals("1B+", ov.getValue());
		assertEquals("1B+", myContact1b.getAddress());

		myShop1.getContacts().add(myContact1a);
		assertEquals(3, changeCount);
		assertEquals("1B+", ov.getValue());

		/*
		 * Change value of base ov
		 */
		if (shopOV != null) {
			changeCount = 0;
			shopOV.setValue(myShop2);
			assertEquals(1, changeCount);
			assertEquals(null, ov.getValue());

			shopOV.setValue(null);
			assertEquals(1, changeCount);
			assertEquals(null, ov.getValue());

			shopOV.setValue(myShop1);
			assertEquals(2, changeCount);
			assertEquals("1B+", ov.getValue());
		}
		/*
		 * Change key of elements
		 */
		changeCount = 0;
		myContact1b.setName("1bold");
		assertEquals(1, changeCount);
		assertEquals(null, ov.getValue());

		myContact1a.setName("1b");
		assertEquals(2, changeCount);
		assertEquals("1A+", ov.getValue());

		myShop1.getContacts().remove(myContact1a);
		assertEquals(3, changeCount);
		assertEquals(null, ov.getValue());

		ov.setValue("new");
		assertEquals(4, changeCount);
		assertEquals("new", ov.getValue());
		assertEquals(2, myShop1.getContacts().size());
		assertEquals(myContact1b, myShop1.getContacts().get(0));
		final Contact newContact = myShop1.getContacts().get(1);
		assertNotSame(null, newContact);
		assertEquals("1b", newContact.getName());
		assertEquals("new", newContact.getAddress());
		assertEquals(null, newContact.getCity());

		/*
		 * Make sure all listeners are properly removed
		 */
		ov.removeValueChangeListener(listener);
		assertEquals(0, myShop1.eAdapters().size());
		assertEquals(0, myContact1a.eAdapters().size());
		assertEquals(0, myContact1b.eAdapters().size());
		assertEquals(0, myShop2.eAdapters().size());

		assertEquals(4, changeCount);
	}
}
