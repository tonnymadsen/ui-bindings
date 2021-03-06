/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Test of {@link DoubleClickAdapter}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DoubleClickAdapterTest {
	private Shop myShop;
	private Country a;
	private Country b;

	private UIBTestView myView;
	private Composite myBody;

	private Table myTable;

	private IBindingContext myContext;
	private ITableCreator myCreator;
	private IColumnBinding myNameColumnBinding;
	private IColumnBinding myAbbrevColumnBinding;
	protected String myHandlerParameter;

	protected static DoubleClickAdapterTest theTestObject = null;

	public DoubleClickAdapterTest() {
	}

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		theTestObject = this;

		createShop();
		createView();

		myBody.layout();
		myView.getSite().getPage().activate(myView);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myShop = ShopFactory.eINSTANCE.createShop();

		a = ShopFactory.eINSTANCE.createCountry();
		a.setName("A");
		a.setAbbreviation("AA");
		myShop.getCountries().add(a);

		b = ShopFactory.eINSTANCE.createCountry();
		b.setName("2A");
		b.setAbbreviation("CC");
		myShop.getCountries().add(b);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myCreator = ITableCreator.Factory.create(myContext, myBody, SWT.NONE, myShop,
				ShopPackage.Literals.SHOP__COUNTRIES);
		myCreator.getBinding().arg(Constants.ARG_DOUBLE_CLICK_COMMAND,
				"com.rcpcompany.uibindings.tests.commands.DoubleClickCommand(p=2)");
		myNameColumnBinding = myCreator.addColumn("name(w=100)").arg(Constants.ARG_DOUBLE_CLICK_COMMAND,
				"com.rcpcompany.uibindings.tests.commands.DoubleClickCommand(p=1)");
		myAbbrevColumnBinding = myCreator.addColumn("abbreviation(w=100)");

		myTable = myCreator.getTable();

		myContext.finish();
		yield();
	}

	@After
	public void disposeView() {
		theTestObject = null;
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests that all listeners are removed on dispose
	 * 
	 * TODO HMM
	 */
	@Test
	public void disposeTest() {
	}

	/**
	 * Tests the executed command as defined on a column
	 */
	@Test
	public void columnValueTest() {
		test(myNameColumnBinding, 0, "1");
	}

	/**
	 * Tests the executed command as defined on the viewer, as the column does not have an
	 * associated command
	 */
	@Test
	public void viewerValueTest() {
		test(myAbbrevColumnBinding, 1, "2");
	}

	private void test(IColumnBinding nameColumnBinding, int columnNo, String expectedValue) {
		myHandlerParameter = null;
		postMouse(myTable, columnNo + myCreator.getBinding().getFirstTableColumnOffset(), 0, 2);
		yield();

		assertEquals(expectedValue, myHandlerParameter);
	}

	public static class DoubleClickHandler extends AbstractHandler {

		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			final String value = event.getParameter("p");
			DoubleClickAdapterTest.theTestObject.setHandlerParameter(value);
			return null;
		}
	}

	public void setHandlerParameter(String value) {
		myHandlerParameter = value;
	}
}
