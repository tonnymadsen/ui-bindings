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
package com.rcpcompany.uibindings.extests.uiAttributes;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.nebula.widgets.radiogroup.RadioGroup;
import org.eclipse.nebula.widgets.radiogroup.RadioItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * This test the use of the RadioGroup.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIAttributeRadioGroupTest {

	private UIBTestView myView;
	private ShopItem myItem;
	private WritableList myValidValues;
	private IFormCreator myForm;
	private IValueBinding myBinding;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();

		myValidValues = WritableList.withElementType(String.class);
		myValidValues.add("a");
		myValidValues.add("b");
		myValidValues.add("c");

		myItem = ShopFactory.eINSTANCE.createShopItem();
		myItem.setName("a");

		myView = BaseUIBTestUtils.createUIBTestView(this);
		myForm = myView.createFormCreator(myItem);

		myBinding = myForm.addField("name").validValues(myValidValues)
				.arg(Constants.ARG_PREFERRED_CONTROL, RadioGroup.class.getName());

		myForm.finish();
		myForm.getTop().layout();
	}

	@After
	public void after() {
		myView.getSite().getPage().hideView(myView);
	}

	/**
	 * Tests that radio items are created correctly and with the correct text
	 */
	@Test
	public void testItemCreation() {
		final Control control = myBinding.getControl();
		assertTrue(control instanceof RadioGroup);
		final RadioGroup rg = (RadioGroup) control;

		yield();
		checkItems(rg, myValidValues);

		myValidValues.add("d");
		yield();
		checkItems(rg, myValidValues);

		myValidValues.remove("b");
		yield();
		checkItems(rg, myValidValues);

		myValidValues.move(0, 1);
		yield();
		checkItems(rg, myValidValues);

		myValidValues.set(0, "x");
		yield();
		checkItems(rg, myValidValues);
	}

	/**
	 * Tests that radio items are selected correctly
	 */
	@Test
	public void testItemSelection() {
		final Control control = myBinding.getControl();
		assertTrue(control instanceof RadioGroup);
		final RadioGroup rg = (RadioGroup) control;

		yield();
		checkSelection(rg, myValidValues, myItem);

		myItem.setName("b");
		yield();
		checkSelection(rg, myValidValues, myItem);

		final Control c = rg.getChildren()[2];
		assertTrue(c instanceof Button);
		((Button) c).setSelection(true);
		yield();
		checkSelection(rg, myValidValues, myItem);
	}

	private void checkSelection(RadioGroup rg, WritableList validValues, ShopItem item) {
		assertNotNull(rg.getSelection());
		assertEquals(rg.getSelection().getText(), item.getName());
	}

	private void checkItems(RadioGroup rg, WritableList validValues) {
		final RadioItem[] items = rg.getItems();
		assertEquals(validValues.size(), items.length);
		for (int n = 0; n < items.length; n++) {
			final RadioItem i = items[n];
			assertEquals(validValues.get(n), i.getText());
		}
	}
}
