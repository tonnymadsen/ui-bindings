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
package com.rcpcompany.uibindings.extests.viewerBindings;

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Tests a combo in a {@link ControlCellEditor}.
 * <p>
 * Also see <a href="http://jira.marintek.sintef.no/jira/browse/SIMA-1557">SIMA-1557</a>: Content
 * assist does not work in Combo.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ControlCellEditorTest {
	private IFormCreator myForm;
	private ITableCreator myTable;

	private Shop myShop;
	private Country myCountry1;
	private Country myCountry2;
	private Contact myContact;

	private UIBTestView myView;
	private Composite myBody;

	private IBindingContext myContext;
	private ITableCreator myCreator;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(true);

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
		myCountry1.setAbbreviation("AA");
		myCountry1.setShop(myShop);

		myCountry2 = ShopFactory.eINSTANCE.createCountry();
		myCountry2.setName("2");
		myCountry2.setAbbreviation("BB");
		myCountry2.setShop(myShop);

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setCountry(myCountry1);
		myContact.setShop(myShop);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myShop);

		myTable = myForm.addTableCreator(ShopPackage.Literals.SHOP__CONTACTS, true, SWT.NONE);

		myTable.addColumn("country(w=200)").validValues(myShop, ShopPackage.Literals.SHOP__COUNTRIES);

		myForm.finish();
		yield();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Edit the cell by direct entering the value
	 */
	@Test
	public void testDirectEdit() {
		final IViewerBinding binding = myTable.getBinding();
		final ColumnViewer viewer = binding.getViewer();
		final Table t = myTable.getTable();

		assertEquals(myCountry1, myContact.getCountry());

		postMouse(t, 0 + binding.getFirstTableColumnOffset(), 0);
		yield();

		assertTrue(viewer.isCellEditorActive());

		postKeyStroke(t, "M2+B");
		postKeyStroke(t, "M2+B");
		yield();

		postKeyStroke(t, "ENTER");
		yield();
		assertFalse(viewer.isCellEditorActive());

		assertEquals(myCountry2, myContact.getCountry());
	}

	/**
	 * Edit the cell by using content assist
	 */
	@Test
	public void testChooseViaContentAssist() {
		final IViewerBinding binding = myTable.getBinding();
		final ColumnViewer viewer = binding.getViewer();
		final Table t = myTable.getTable();

		assertEquals(myCountry1, myContact.getCountry());
		myContact.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if (msg.isTouch()) return;
				System.out.println(msg);
			}
		});

		postMouse(t, 0 + binding.getFirstTableColumnOffset(), 0);
		yield();

		assertTrue(viewer.isCellEditorActive());

		postKeyStroke(t, "BACKSPACE");
		yield();
		postKeyStroke(t, "M1+SPACE");
		yield();
		postKeyStroke(t, "B");
		postKeyStroke(t, "B");
		yield();

		postKeyStroke(t, "ENTER");
		yield();
		assertTrue(viewer.isCellEditorActive());

		postKeyStroke(t, "ENTER");
		yield();
		assertFalse(viewer.isCellEditorActive());

		assertEquals(myCountry2, myContact.getCountry());
	}
}
