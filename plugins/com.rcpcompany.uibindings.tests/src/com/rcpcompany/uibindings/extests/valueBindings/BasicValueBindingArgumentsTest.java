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
package com.rcpcompany.uibindings.extests.valueBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests that when the model is changed, then the widget is changed as well.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BasicValueBindingArgumentsTest {

	private static final String MY_HELP_ID = "myHelpID";
	private static final String MY_TOOL_TIP = "my tool tip";
	private TestView myView;
	private Text myCountryText;

	private Shop myShop;
	private Contact myContact;

	private IValueBinding myCountryVB;
	private Country myCountry1;
	private Country myCountry2;
	private Country myCountry3;

	@Before
	public void setup() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myCountry1 = ShopFactory.eINSTANCE.createCountry();
		myCountry1.setAbbreviation("DK");
		myShop.getCountries().add(myCountry1);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setAbbreviation("NO");
		myShop.getCountries().add(myCountry2);

		myCountry3 = ShopFactory.eINSTANCE.createCountry();
		myCountry3.setAbbreviation("SE");
		myShop.getCountries().add(myCountry3);

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setCountry(myCountry2);
		myShop.getContacts().add(myContact);
	}

	private void createView() {
		myView = createTestView(this);
		final Composite body = myView.getBody();

		myCountryText = new Text(body, SWT.NONE);
		final GridData gd_country = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myCountryText.setLayoutData(gd_country);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void bindUI() {
		final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myCountryVB = context.addBinding(myCountryText, myContact, ShopPackage.Literals.CONTACT__COUNTRY)
				.validValues(myShop, ShopPackage.Literals.SHOP__COUNTRIES).arg(Constants.ARG_HELP_ID, MY_HELP_ID)
				.arg(Constants.ARG_TOOL_TIP_TEXT, MY_TOOL_TIP);

		context.finish();
		yield();
	}

	@Test
	public void testHelpID() {
		final Object data = myCountryText.getData("org.eclipse.ui.help");
		assertEquals(MY_HELP_ID, data);
	}

	@Test
	public void testTooltip() {
		assertEquals(MY_TOOL_TIP, myCountryText.getToolTipText());
	}
}
