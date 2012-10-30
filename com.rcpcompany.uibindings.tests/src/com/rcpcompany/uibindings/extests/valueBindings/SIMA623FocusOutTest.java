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

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;

/**
 * Tests end-to-end that a text widget with focus out is handled correct.
 * <p>
 * Depends on:
 * <ul>
 * <li>limited binding decorator</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SIMA623FocusOutTest {
	private ShopItem myItem;

	private UIBTestView myView;
	private Text myPriceText;
	private Text myFOText;

	protected IBindingContext myContext;
	protected IValueBinding myPriceBinding;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_FOCUS_OUT);

		createModel();
		createView();
		bindUI();

		myView.getSite().getPage().activate(myView);
	}

	private void createModel() {
		myItem = ShopFactory.eINSTANCE.createShopItem();
		myItem.setName("NoName");
		myItem.setPrice(0f);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);

		myPriceText = myView.getToolkit().createText(myView.getBody(), "");
		myFOText = myView.getToolkit().createText(myView.getBody(), "");
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Binds the UI
	 */
	public void bindUI() {
		assertNoLog(new Runnable() {

			@Override
			public void run() {
				myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());

				myPriceBinding = myContext.addBinding(myPriceText, myItem, ShopPackage.Literals.SHOP_ITEM__PRICE).type(
						"limited");
				myContext.finish();
				yield();
			}
		});
	}

	@Test
	public void testSetName() {
		final ValueBindingMessageImageDecorator decorator = myPriceBinding
				.getService(ValueBindingMessageImageDecorator.class);
		assertNotNull(decorator);
		final List<IBindingMessage> messages = decorator.getMessages();
		assertNotNull(messages);

		assertEquals(0f, myItem.getPrice(), 0.1f);

		myPriceText.setFocus();
		assertEquals(0, messages.size());

		myPriceText.setText("20");
		sleep(300);
		assertEquals(1, messages.size());
		assertEquals(0f, myItem.getPrice(), 0.1f);

		myPriceText.setText("5.6");
		sleep(300);
		assertEquals(0, messages.size());
		assertEquals(0f, myItem.getPrice(), 0.1f);

		myFOText.setFocus();
		assertEquals(5.6f, myItem.getPrice(), 0.1f);
	}
}
