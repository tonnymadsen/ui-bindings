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
package com.rcpcompany.uibindings.extests.quickfixes;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.commands.common.CommandException;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.handlers.IHandlerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.internal.handlers.QuickFixHandler;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests the basic quickfix functionality with focus on the handler: apply quick fix, no quick fix
 * and quick fixes not supported.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BasicQuickfixTest {

	private Shop myShop;
	private TestView myTestView;
	private Composite myBody;
	private Text myBoundText;
	private Text myUnboundText;
	private IBindingContext myContext;
	private Country myCountry;
	private Contact myContact;
	private IValueBinding myCountryVB;

	@Before
	public void setup() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setAutoApplySingleQuickfix(true);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();
		bindUI();
	}

	private void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myCountry = ShopFactory.eINSTANCE.createCountry();
		myCountry.setAbbreviation("AA");
		myShop.getCountries().add(myCountry);

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("me");
		myShop.getContacts().add(myContact);
	}

	private void createView() {
		myTestView = createTestView(this);
		myBody = myTestView.getBody();

		myBoundText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myBoundText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myUnboundText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myUnboundText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	@After
	public void disposeView() {
		if (myTestView != null) {
			myTestView.getSite().getPage().hideView(myTestView);
		}
	}

	private void bindUI() {
		myContext = IBindingContext.Factory.createContext(myTestView.getScrolledForm());
		final IObservableList countryList = UIBindingsEMFObservables.observeList(myContext.getEditingDomain(), myShop,
				ShopPackage.Literals.SHOP__COUNTRIES);
		myCountryVB = myContext.addBinding(myBoundText, myContact, ShopPackage.Literals.CONTACT__COUNTRY).validValues(
				countryList);
		myContext.finish();
		yield();
	}

	@After
	public void teardown() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setAutoApplySingleQuickfix(false);
	}

	@Test
	public void testOKQuickfix() {
		assertNotNull(myBoundText);

		final ValueBindingMessageImageDecorator decorator = myCountryVB
				.getService(ValueBindingMessageImageDecorator.class);
		assertNotNull(decorator);
		assertNotNull(decorator.getQuickfixes());
		assertTrue(myBoundText.setFocus());
		yield();
		assertEquals("", myBoundText.getText());

		assertEquals(0, decorator.getQuickfixes().size());

		myBoundText.setText(myCountry.getAbbreviation().toLowerCase());

		yield();
		assertEquals(null, myContact.getCountry());
		assertEquals(1, decorator.getQuickfixes().size());

		final IHandlerService bs = (IHandlerService) myTestView.getSite().getService(IHandlerService.class);
		assertNotNull(bs);

		try {
			bs.executeCommand("com.rcpcompany.uibindings.commands.QuickFix", null);
		} catch (final CommandException ex) {
			fail(ex.getMessage());
		}
		yield();
		assertEquals(myCountry.getAbbreviation(), myBoundText.getText());
		assertEquals(myCountry, myContact.getCountry());
		assertEquals(0, decorator.getQuickfixes().size());
	}

	@Test
	public void testQuickfixPopup() {
		IManager.Factory.getManager().setAutoApplySingleQuickfix(false);
		assertNotNull(myBoundText);

		final ValueBindingMessageImageDecorator decorator = myCountryVB
				.getService(ValueBindingMessageImageDecorator.class);
		assertNotNull(decorator);
		assertNotNull(decorator.getQuickfixes());
		assertTrue(myBoundText.setFocus());
		yield();
		assertEquals("", myBoundText.getText());

		assertEquals(0, decorator.getQuickfixes().size());

		myBoundText.setText(myCountry.getAbbreviation().toLowerCase());

		yield();
		assertEquals(null, myContact.getCountry());
		assertEquals(1, decorator.getQuickfixes().size());

		final int noShells = myBoundText.getDisplay().getShells().length;

		postKeyStroke(myBoundText, "CTRL+1", myTestView.getSite(), QuickFixHandler.class);

		sleep(300);
		assertEquals(noShells + 1, myBoundText.getDisplay().getShells().length);
		postKeyStroke(myBoundText, "CR");
		sleep(300);
		assertEquals(noShells, myBoundText.getDisplay().getShells().length);

		assertEquals(myCountry.getAbbreviation(), myBoundText.getText());
		assertEquals(myCountry, myContact.getCountry());
		assertEquals(0, decorator.getQuickfixes().size());
	}

	@Test
	public void testNoQuickfix() {
		assertNotNull(myBoundText);

		final ValueBindingMessageImageDecorator decorator = myCountryVB
				.getService(ValueBindingMessageImageDecorator.class);
		assertNotNull(decorator);
		assertNotNull(decorator.getQuickfixes());
		assertTrue(myBoundText.setFocus());
		yield();
		assertEquals("", myBoundText.getText());

		assertEquals(0, decorator.getQuickfixes().size());

		myBoundText.setText(myCountry.getAbbreviation());

		yield();
		assertEquals(myCountry, myContact.getCountry());
		assertEquals(0, decorator.getQuickfixes().size());

		final IHandlerService bs = (IHandlerService) myTestView.getSite().getService(IHandlerService.class);
		assertNotNull(bs);

		try {
			bs.executeCommand("com.rcpcompany.uibindings.commands.QuickFix", null);
		} catch (final CommandException ex) {
			fail(ex.getMessage());
		}
		yield();
		assertEquals(myCountry.getAbbreviation(), myBoundText.getText());
		assertEquals(myCountry, myContact.getCountry());
		assertEquals(0, decorator.getQuickfixes().size());
	}

	@Test
	public void testQuickfixNotPossible() {
		assertTrue(myUnboundText.setFocus());
		yield();

		final IHandlerService bs = (IHandlerService) myTestView.getSite().getService(IHandlerService.class);
		assertNotNull(bs);

		try {
			bs.executeCommand("com.rcpcompany.uibindings.commands.QuickFix", null);
			fail("Should get an exception");
		} catch (final CommandException ex) {
			// OK
		}
		yield();
	}
}
