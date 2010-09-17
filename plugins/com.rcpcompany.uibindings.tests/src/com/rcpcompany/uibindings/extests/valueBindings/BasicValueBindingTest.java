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
package com.rcpcompany.uibindings.extests.valueBindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
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
@RunWith(Parameterized.class)
public class BasicValueBindingTest {
	private static final int DELAY = 200;
	private final TextCommitStrategy myStrategy;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ TextCommitStrategy.ON_MODIFY },

		{ TextCommitStrategy.ON_MODIFY_DELAY },

		{ TextCommitStrategy.ON_FOCUS_OUT }

		});
	}

	public BasicValueBindingTest(TextCommitStrategy strategy) {
		myStrategy = strategy;
	}

	private TestView myView;
	private Text myCountryText;

	private Shop myShop;
	private Contact myContact;

	private IValueBinding myCountryVB;
	private Country myCountry1;
	private Country myCountry2;
	private Country myCountry3;
	private Text myDummyText;

	@Before
	public void setup() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(myStrategy);
		IManager.Factory.getManager().setTextCommitStrategyDelay(DELAY);
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

		myDummyText = myView.getToolkit().createText(body, "");
		final GridData gd_f1 = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myDummyText.setLayoutData(gd_f1);

		myCountryText = myView.getToolkit().createText(body, "");
		final GridData gd_f2 = new GridData(SWT.FILL, SWT.CENTER, true, false);
		myCountryText.setLayoutData(gd_f2);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void bindUI() {
		final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

		final IObservableList countries = UIBindingsEMFObservables.observeList(context.getEditingDomain(), myShop,
				ShopPackage.Literals.SHOP__COUNTRIES);

		myCountryVB = context.addBinding(myCountryText, myContact, ShopPackage.Literals.CONTACT__COUNTRY).validValues(
				countries);

		context.finish();
		myView.getBody().layout();
		yield();
	}

	@Test
	public void testValue() {
		final Contact contact = myContact;
		assertNotNull(myCountryVB);
		assertNotNull(contact);

		final Country oldCountry = contact.getCountry();
		assertNotNull(oldCountry);
		assertEquals(myCountry2, oldCountry);

		assertNotNull(myCountryText);

		final ValueBindingMessageImageDecorator decorator = myCountryVB
				.getService(ValueBindingMessageImageDecorator.class);
		assertNotNull(decorator);
		final List<IBindingMessage> messages = decorator.getMessages();
		assertNotNull(messages);
		assertNotNull(decorator.getQuickfixes());
		try {
			myCountryText.setFocus();

			assertEquals(0, messages.size());
			assertEquals(0, decorator.getQuickfixes().size());

			myCountryText.setText("n");
			yield();

			// Execute all outstanding events...
			assertEquals(oldCountry, contact.getCountry());

			assertEquals(1, messages.size());
			assertEquals(0, decorator.getQuickfixes().size());

			myCountryText.setText("no");
			yield();

			assertEquals(oldCountry, contact.getCountry());

			assertEquals(1, messages.size());
			assertEquals(1, decorator.getQuickfixes().size());

			myCountryText.setText("n");
			yield();

			assertEquals(oldCountry, contact.getCountry());

			assertEquals(1, messages.size());
			assertEquals(0, decorator.getQuickfixes().size());

			myCountryText.setText(myCountry1.getAbbreviation());
			yield();

			switch (myStrategy) {
			case ON_MODIFY:
				break;
			case ON_MODIFY_DELAY:
				sleep(2 * DELAY);
				break;
			case ON_FOCUS_OUT:
				myDummyText.setFocus();
				break;
			}
			yield();

			assertNotSame(oldCountry, contact.getCountry());
			assertEquals(myCountry1.getAbbreviation(), contact.getCountry().getAbbreviation());

			assertEquals(0, messages.size());
			assertEquals(0, decorator.getQuickfixes().size());
		} finally {
			contact.setCountry(oldCountry);
		}
	}
}
