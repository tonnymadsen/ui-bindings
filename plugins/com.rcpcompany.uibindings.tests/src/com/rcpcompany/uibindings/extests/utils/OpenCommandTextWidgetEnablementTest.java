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
package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.UIBindingsEMFObservables;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests the correct selection is used in the "show view" command and handler.
 * <p>
 * Depends on:
 * <ul>
 * <li>{@link ShowViewSelectionTestView}</li>
 * <li>openCommand</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class OpenCommandTextWidgetEnablementTest {
	public final static String TEST_VIEW_ID = ShowViewSelectionTestView.class.getName();

	/**
	 * Command used for test
	 */
	private static final String SHOW_VIEW_COMMAND = "com.rcpcompany.uibindings.commands.showView(viewId="
			+ TEST_VIEW_ID + ")";

	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;
	private Contact myContact1;
	private Contact myContact2;

	private UIBTestView myView;

	private IFormCreator myForm;
	private IValueBinding myNameField;
	private IValueBinding myCountryOKField;
	private IValueBinding myCountryNOKField;
	private IValueBinding myCountryEmptyField;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createShop();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		myCountry1 = ShopFactory.eINSTANCE.createCountry();
		myCountry1.setName("1");
		myCountry1.setAbbreviation("1");
		myShop.getCountries().add(myCountry1);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setName("");
		myShop.getCountries().add(myCountry2);

		myContact1 = ShopFactory.eINSTANCE.createContact();
		myContact1.setName("NN 1");
		myContact1.setCountry(myCountry1);
		myShop.getContacts().add(myContact1);

		myContact2 = ShopFactory.eINSTANCE.createContact();
		myContact2.setName("NN 2");
		myShop.getContacts().add(myContact2);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myContact1);

		final IObservableList countries = UIBindingsEMFObservables.observeList(Realm.getDefault(), myForm.getContext()
				.getEditingDomain(), myShop, ShopPackage.Literals.SHOP__COUNTRIES);

		myNameField = myForm.addField(myContact1, IMOAOPackage.Literals.NAMED_OBJECT__NAME, SWT.NONE);
		myCountryOKField = myForm.addField(myContact1, ShopPackage.Literals.CONTACT__COUNTRY, SWT.NONE)
				.arg(Constants.ARG_OPEN_COMMAND, SHOW_VIEW_COMMAND).validValues(countries);
		myCountryNOKField = myForm.addField(myContact1, ShopPackage.Literals.CONTACT__COUNTRY, SWT.NONE)
				.arg(Constants.ARG_OPEN_COMMAND, null).validValues(countries);
		myCountryEmptyField = myForm.addField(myContact2, ShopPackage.Literals.CONTACT__COUNTRY, SWT.NONE)
				.arg(Constants.ARG_OPEN_COMMAND, SHOW_VIEW_COMMAND).validValues(countries);

		myForm.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Test the {@link #myNameField} does not have an open command
	 */
	@Test
	public void nameNameTest() {
		testColumnBinding(myNameField, false);
	}

	/**
	 * Test the {@link #myCountryOKField} does have an open command
	 * <p>
	 * Test Data: see binding above
	 */
	@Test
	public void countryOKTest() {
		testColumnBinding(myCountryOKField, true);
	}

	/**
	 * Test the {@link #myCountryNOKField} does not have an open command
	 */
	@Test
	public void countryNotOKTest() {
		testColumnBinding(myCountryNOKField, false);
	}

	/**
	 * Test the {@link #myContact2} does not have an open command
	 */
	@Test
	public void countryEmptyTest() {
		testColumnBinding(myCountryEmptyField, false);
	}

	private void testColumnBinding(IValueBinding binding, boolean openEnabled) {
		final Listener listener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				// System.out.println(">>>" + ToStringUtils.toString(event));
			}
		};
		for (int i = SWT.None; i < SWT.ImeComposition; i++) {
			Display.getCurrent().addFilter(i, listener);
		}

		final Control control = binding.getControl();
		final Rectangle bounds = control.getBounds();
		final Point p = new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
		postMouseMove(control.getParent(), p);

		final Cursor initCursor = control.getCursor();

		control.setFocus();

		Event event;
		event = new Event();
		event.type = SWT.KeyDown;
		event.stateMask = 0;
		event.keyCode = SWT.CTRL;
		event.widget = control;

		assertTrue(control.getDisplay().post(event));
		yield();

		p.x += 1;
		postMouseMove(control.getParent(), p);
		p.x -= 1;

		final Cursor cursor = control.getCursor();
		assertEquals(openEnabled, cursor != null);

		event = new Event();
		event.type = SWT.KeyUp;
		event.stateMask = 0;
		event.keyCode = SWT.CTRL;
		event.widget = control;

		assertTrue(control.getDisplay().post(event));
		yield();

		postMouseMove(control.getParent(), p);

		final Cursor cursor2 = control.getCursor();
		assertEquals(initCursor, cursor2);
	}
}
