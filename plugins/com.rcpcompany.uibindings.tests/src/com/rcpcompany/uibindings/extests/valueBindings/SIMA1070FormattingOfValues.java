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

import java.util.Arrays;
import java.util.Collection;

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
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests <a href="http://jira.marintek.sintef.no/jira/browse/SIMA-1070">SIMA-1070</a>: Formatting of
 * double values are reflected to model.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class SIMA1070FormattingOfValues {
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

	public SIMA1070FormattingOfValues(TextCommitStrategy strategy) {
		myStrategy = strategy;
	}

	private UIBTestView myView;

	private ShopItem mySI;

	@Before
	public void setup() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(myStrategy);

		createModel();
		createView();
	}

	private void createModel() {
		mySI = ShopFactory.eINSTANCE.createShopItem();
		mySI.setPrice(1.2356789f);
	}

	private void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void test() {
		final float origPrice = mySI.getPrice();

		final IFormCreator creator = myView.createFormCreator(mySI);

		final IValueBinding priceBinding = creator.addField("price");
		final IValueBinding nameBinding = creator.addField("name");

		creator.finish();
		yield();

		final Text text = (Text) priceBinding.getControl();
		assertNotNull(text);
		/*
		 * Initial state
		 */
		assertEquals("1.24", text.getText());
		assertEquals(origPrice, mySI.getPrice(), 0.000001);

		/*
		 * Set the new value via the model
		 */
		mySI.setPrice(origPrice + 1f);
		yield();
		assertEquals("2.24", text.getText());
		assertEquals(origPrice + 1f, mySI.getPrice(), 0.000001);

		/*
		 * Set the new value via the widget
		 */
		text.setFocus();
		text.selectAll();
		postKeyStroke(text, "3");
		postKeyStroke(text, ".");
		postKeyStroke(text, "2");
		postKeyStroke(text, "3");
		postKeyStroke(text, "5");
		postKeyStroke(text, "6");
		postKeyStroke(text, "7");
		postKeyStroke(text, "8");
		postKeyStroke(text, "9");
		nameBinding.setFocus();
		yield();

		assertEquals("3.24", text.getText());
		assertEquals(origPrice + 2f, mySI.getPrice(), 0.000001);

		/*
		 * Dispose of text...
		 */
		text.dispose();
		assertEquals(origPrice + 2f, mySI.getPrice(), 0.000001);
	}
}
