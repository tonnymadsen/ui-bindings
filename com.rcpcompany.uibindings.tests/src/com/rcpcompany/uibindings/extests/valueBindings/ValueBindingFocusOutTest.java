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
package com.rcpcompany.uibindings.extests.valueBindings;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tests that when the model is changed, then the widget is changed as well.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ValueBindingFocusOutTest {
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

	public ValueBindingFocusOutTest(TextCommitStrategy strategy) {
		myStrategy = strategy;
	}

	private UIBTestView myView;

	private ShopItem myItem;

	private IFormCreator myForm;

	private IValueBinding myNameBinding;
	private IValueBinding myPriceBinding;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(myStrategy);
		IManager.Factory.getManager().setTextCommitStrategyDelay(DELAY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
	}

	private void createModel() {
		myItem = ShopFactory.eINSTANCE.createShopItem();
		myItem.setName("abc");
		myItem.setPrice(1f);
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myForm = myView.createFormCreator(myItem);

		myNameBinding = myForm.addField("name");
		myPriceBinding = myForm.addField("price");
		myForm.finish();
		myForm.getTop().layout();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testValue() {
		yield();
		final Control c = myPriceBinding.getControl();
		assertTrue(c instanceof Text);
		final Text text = (Text) c;
		yield();

		assertEquals("1.00", text.getText());

		postMouse(c);
		yield();

		assertTrue(c.isFocusControl());

		// postKeyStroke(c, "b");
		postKeyStroke(c, "M1+A");
		postKeyStroke(c, "2");
		yield();
		assertEquals("2", text.getText());

		switch (myStrategy) {
		case ON_MODIFY:
			assertEquals(2.0f, myItem.getPrice(), 0.001);
			break;
		case ON_MODIFY_DELAY:
			assertEquals(1.0f, myItem.getPrice(), 0.001);
			sleep(2 * DELAY);
			assertEquals(2.0f, myItem.getPrice(), 0.001);
			break;
		case ON_FOCUS_OUT:
			assertEquals(1.0f, myItem.getPrice(), 0.001);
			break;
		}
		yield();
		assertEquals("2", text.getText());

		assertTrue(myNameBinding.getControl().setFocus());
		yield();

		assertEquals("2.00", text.getText());
	}

	/**
	 * @param binding
	 * 
	 */
	private void dump(IValueBinding binding) {
		final Control c = binding.getControl();
		final Rectangle bounds = c.getBounds();
		LogUtils.debug(this,
				binding.getLabel() + ": " + c.hashCode() + " - " + bounds + " - " + c.getDisplay().map(c, null, bounds));
		for (Control d = c; !(d instanceof Shell); d = d.getParent()) {
			LogUtils.debug(this, "  " + d + ": " + d.getBounds() + " - " + c.getDisplay().map(c, d, bounds));
		}
	}
}
