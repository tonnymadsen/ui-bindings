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

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Test of {@link IFormCreator}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FormCreatorAlignmentTest {
	private Contact myContact;

	private UIBTestView myView;

	private Shop myShop;
	private IFormCreator myForm;
	private IValueBinding myShopName;
	private IFormCreator myContactSection;
	private IValueBinding myContactName;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();

		myView.getSite().getPage().activate(myView);
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("my shop");

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("John Doe");
		myContact.setShop(myShop);

	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myForm = myView.createFormCreator(myShop);
		myForm.setFieldsAligned(true);
		myShopName = myForm.addField("name(label='Shop Name')");

		myContactSection = myForm.addSection("contact", myContact);
		myContactName = myContactSection.addField("name(label='Contact Name')");

		final IFormCreator[] columns = myForm.addColumns(true, true);
		for (final IFormCreator c : columns) {
			c.addField("name(label='Shop Name')");
		}

		myForm.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testAlignment() {
		yield();
		final int shopNameLeft = getLeft(myShopName);
		final int contactNameLeft = getLeft(myContactName);

		assertEquals(shopNameLeft, contactNameLeft);
	}

	private int getLeft(IValueBinding b) {
		final Control c = b.getControl();
		final Composite top = myForm.getTop();
		final Rectangle r = top.getDisplay().map(c.getParent(), top, c.getBounds());
		return r.x;
	}
}
