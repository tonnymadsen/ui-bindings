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
package com.rcpcompany.uibindings.extests.uiAttributeFactories.contentAdapters;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Test of {@link CComboContentAdapter} and {@link StyledTextContentAdapter}.
 * 
 * @author Tonny Madsen, The RCP Company
 * @param <T> the widget class to test
 */
@RunWith(Parameterized.class)
public class ContentAdapterTest<T extends Control> {

	private final Class<T> myWidgetType;
	private final int myStyle;

	private Shop myShop;
	private Contact myContact;
	private Country myDKCountry;
	private Country myNOCountry;

	private TestView myView;
	private Composite myBody;
	private T myWidget;

	private IValueBinding myBinding;
	private ValueBindingMessageImageDecorator myMessageDecorator;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ Text.class, SWT.NONE }, { Combo.class, SWT.NONE }, { CCombo.class, SWT.NONE },
				{ StyledText.class, SWT.NONE },

		});
	}

	public ContentAdapterTest(Class<T> widgetType, int style) {
		myWidgetType = widgetType;
		myStyle = style;
	}

	@Before
	public void setup() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(100);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();
		yield();

		myMessageDecorator = myBinding.getService(ValueBindingMessageImageDecorator.class);
	}

	/**
	 * 
	 */
	private void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myWidget = createWidget(myWidgetType, myStyle);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myNOCountry = ShopFactory.eINSTANCE.createCountry();
		myNOCountry.setAbbreviation("NO");
		myShop.getCountries().add(myNOCountry);

		myDKCountry = ShopFactory.eINSTANCE.createCountry();
		myDKCountry.setAbbreviation("DK");
		myShop.getCountries().add(myDKCountry);

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setCountry(myNOCountry);
		myShop.getContacts().add(myContact);
	}

	private void bindUI() {
		final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myBinding = context.addBinding(myWidget, myContact, ShopPackage.Literals.CONTACT__COUNTRY).validValues(myShop,
				ShopPackage.Literals.SHOP__COUNTRIES);

		context.finish();
		yield();
	}

	@Test
	public void testValue() {
		assertNotNull(myMessageDecorator);
		final List<IBindingMessage> messages = myMessageDecorator.getMessages();
		assertEquals(0, messages.size());

		assertTrue(myWidget.setFocus());
		try {
			final Method method = myWidgetType.getMethod("setText", String.class);
			method.invoke(myWidget, "");
		} catch (final Exception ex) {
			fail(ex.getMessage());
		}
		postKeyStroke(myWidget, "d");
		sleep(300);

		assertEquals(1, messages.size());
		postKeyStroke(myWidget, "Ctrl+Space");
		postKeyStroke(myWidget, "CR");
		sleep(300);

		assertEquals(0, messages.size());
		assertNotNull(myContact.getCountry());
		assertEquals("DK", myContact.getCountry().getAbbreviation());
	}
}
