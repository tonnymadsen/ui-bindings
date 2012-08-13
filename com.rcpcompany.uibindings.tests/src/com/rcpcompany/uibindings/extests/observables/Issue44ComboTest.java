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

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Test case for http://code.google.com/p/rcp-company-uibindings/issues/detail?id=44: Combo and
 * CCombo is cleared when underlying list is changed
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class Issue44ComboTest {

	private UIBTestView myTestView;
	private Shop shop;
	private Contact contact;
	private List<Country> countries;
	private String otherAbbreviation;
	private Country otherCountry;
	private String contactAbbreviation;
	private Country blankCountry;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		myTestView = BaseUIBTestUtils.createUIBTestView(this);
		shop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());
		contact = shop.getContacts().get(0);
		contactAbbreviation = contact.getCountry().getAbbreviation();
		countries = shop.getCountries();

		blankCountry = ShopFactory.eINSTANCE.createCountry();
		blankCountry.setName("");
		blankCountry.setAbbreviation("");
		countries.add(blankCountry);

		for (final Country c : countries) {
			if (c != contact.getCountry()) {
				otherCountry = c;
				break;
			}
		}
		otherAbbreviation = otherCountry.getAbbreviation();
	}

	@After
	public void disposeView() {
		if (myTestView != null) {
			myTestView.getSite().getPage().hideView(myTestView);
		}
	}

	@After
	public void teardown() {
		otherCountry.setAbbreviation(otherAbbreviation);
		countries.remove(blankCountry);
	}

	@Test
	public void test() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final Composite body = myTestView.getBody();

				final Combo combo = new Combo(body, SWT.DROP_DOWN);
				combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

				// The bindings
				final IBindingContext context = IBindingContext.Factory.createContext(body);

				context.addBinding(combo, contact, ShopPackage.Literals.CONTACT__COUNTRY).validValues(shop,
						ShopPackage.Literals.SHOP__COUNTRIES);

				context.finish();
				yield();

				// Tests
				// assertEquals(countries.indexOf(contact.getCountry()), combo.getSelectionIndex());
				assertEquals(contactAbbreviation, combo.getText());

				// final Country ge = ShopFactory.eINSTANCE.createCountry();
				// ge.setName("Germany");
				// ge.setAbbreviation("ge");
				//
				// countries.add(ge);
				otherCountry.setAbbreviation("xx");

				yield();

				assertEquals(contactAbbreviation, combo.getText());
			}
		});
	}

}
