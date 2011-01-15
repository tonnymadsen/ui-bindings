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
package com.rcpcompany.uibindings.internal.validators;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessage.FeatureMatchingAlgorithm;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Tests that messages are added to the {@link ValueBindingMessageImageDecorator} at the right time
 * in viewers..
 * <p>
 * Depends on:
 * <ul>
 * <li> {@link ShopItem#getPrice()} have the binding type "price"</li>
 * </ul>
 * 
 * TODO test of {@link IBindingMessageTarget#getModelKey()}
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ViewerBindingMessageCollectionTest {
	private final boolean myEIV;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				// ValidationErrorsAreFatal

				{ true },

				{ false },

		});
	}

	public ViewerBindingMessageCollectionTest(boolean eiv) {
		myEIV = eiv;
	}

	private static final int VD = 500;
	private TestView myView;
	private ShopItem myItem;
	private ValueBindingMessageImageDecorator myMessageDecorator;
	private IValidatorAdapterManager myValidatorManager;
	private final IValidatorAdapter myValidationAdapter = new ConstraintValidatorAdapter();
	private Shop myShop;
	private IColumnBinding myPriceColumn;
	private ITableCreator myTable;
	private IColumnBindingCellInformation myCellInformation;
	private IValueBinding myBinding;

	@Before
	public void before() {
		resetAll();

		myValidatorManager = IValidatorAdapterManager.Factory.getManager();

		final IManager manager = IManager.Factory.getManager();
		manager.setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		manager.setValidationErrorsAreFatal(myEIV);
		manager.setValidationDelay(VD);
		manager.setEditCellSingleClick(false);

		createModel();
		createView();
	}

	/**
	 * 
	 */
	private void createView() {
		myView = createTestView(this);

		final IFormCreator form = myView.createFormCreator(myShop);

		myTable = form.addTableCreator(ShopPackage.Literals.SHOP__SHOP_ITEMS, true, SWT.NONE);
		myTable.addColumn("name (w=200)");
		myPriceColumn = myTable.addColumn("price (w=200)");

		form.finish();
		yield();

		myCellInformation = myPriceColumn.getCellInformation(myItem);
		myBinding = myCellInformation.getLabelBinding();
		myMessageDecorator = myBinding.getService(ValueBindingMessageImageDecorator.class);
	}

	/**
	 * 
	 */
	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myItem = ShopFactory.eINSTANCE.createShopItem();
		myItem.setPrice(200f);
		myItem.setShop(myShop);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
		myValidatorManager.removeRoot(myShop, myValidationAdapter);
	}

	@Test
	public void testCellError() {
		assertNotNull(myValidatorManager);
		assertNotNull(myMessageDecorator);

		final int initNoUnboundMessage = myValidatorManager.getUnboundMessages().size();
		assertEquals(0, initNoUnboundMessage);

		myValidatorManager.addRoot(myShop, myValidationAdapter);

		final int noUnboundMessage = myValidatorManager.getUnboundMessages().size();
		assertTrue(noUnboundMessage >= initNoUnboundMessage);

		final List<IBindingMessage> messages = myMessageDecorator.getMessages();
		assertNotNull(messages);

		/*
		 * No errors - color according to row
		 */
		assertEquals(0, messages.size());

		final Table t = (Table) myTable.getBinding().getControl();
		final Rectangle cellBounds = t.getItem(0).getBounds(1 + myTable.getBinding().getFirstTableColumnOffset());
		assertTrue(cellBounds.height > 0);
		cellBounds.x += -4;
		cellBounds.y += cellBounds.height - 8;
		assertPixelColor("", t, cellBounds.x, cellBounds.y, new RGB(227, 236, 246));

		/*
		 * Error - colors according to error icon
		 * 
		 * Delayed!
		 */
		myItem.setPrice(-1.0f);
		assertEquals(noUnboundMessage, myValidatorManager.getUnboundMessages().size());
		assertEquals(0, messages.size());
		assertPixelColor("", t, cellBounds.x, cellBounds.y, new RGB(227, 236, 246));

		// Test before the validation delay - problem already found due to the binding
		sleep(VD - 150);
		assertEquals(noUnboundMessage, myValidatorManager.getUnboundMessages().size());
		assertEquals(0, messages.size());
		assertPixelColor("", t, cellBounds.x, cellBounds.y, new RGB(227, 236, 246));

		// Test after the validation delay
		sleep(300);
		assertEquals(noUnboundMessage + 1, myValidatorManager.getUnboundMessages().size());
		// Still just one error, and the two are colapsed into one
		assertEquals(1, messages.size());
		assertPixelColor("", t, cellBounds.x, cellBounds.y, new RGB(216, 66, 79));

		final IBindingMessage message = messages.get(0);
		assertEquals(myBinding, message.getBinding());
		assertEquals(null, message.getControl());
		assertEquals(IMessageProvider.ERROR, message.getMessageType());
		assertEquals(BindingMessageSeverity.ERROR, message.getSeverity());
		assertTrue(message.matches(myItem, ShopPackage.Literals.SHOP_ITEM__PRICE, null, FeatureMatchingAlgorithm.EXACT));
		assertEquals(myPriceColumn.getColumnAdapter().getText() + ": ", message.getPrefix());

		/*
		 * Clean error
		 */
		myItem.setPrice(100f);
		// assertEquals(noUnboundMessage + 1, myValidatorManager.getUnboundMessages().size());
		assertEquals(1, messages.size());
		assertEquals(message, messages.get(0));
		assertPixelColor("", t, cellBounds.x, cellBounds.y, new RGB(216, 66, 79));

		// Test before the validation delay
		sleep(VD - 100);
		assertEquals(noUnboundMessage + 1, myValidatorManager.getUnboundMessages().size());
		assertEquals(1, messages.size());
		assertEquals(message, messages.get(0));
		assertPixelColor("", t, cellBounds.x, cellBounds.y, new RGB(216, 66, 79));

		// Test after the validation delay
		sleep(300);
		assertEquals(noUnboundMessage, myValidatorManager.getUnboundMessages().size());
		assertEquals(0, messages.size());
		assertPixelColor("", t, cellBounds.x, cellBounds.y, new RGB(227, 236, 246));

		assertEquals(initNoUnboundMessage, myValidatorManager.getUnboundMessages().size());
	}

	/**
	 * Tests that when a row is deleted any decorations on the last row are cleared properly
	 */
	@Test
	public void testCellErrorWithRowDelete() {
		myValidatorManager.addRoot(myShop, myValidationAdapter);

		final Table t = (Table) myTable.getBinding().getControl();
		final Rectangle cellBounds = t.getItem(0).getBounds(1 + myTable.getBinding().getFirstTableColumnOffset());
		assertTrue(cellBounds.height > 0);
		cellBounds.x += -4;
		cellBounds.y += cellBounds.height - 8;

		/*
		 * No errors - color according to row
		 */
		assertPixelColor("", t, cellBounds.x, cellBounds.y, new RGB(227, 236, 246));

		/*
		 * Error - colors according to error icon
		 * 
		 * Delayed!
		 */
		myItem.setPrice(-1.0f);
		sleep(VD + 150);
		assertPixelColor("", t, cellBounds.x, cellBounds.y, new RGB(216, 66, 79));

		/*
		 * Delete row
		 */
		LogUtils.debug(this, "before set");
		myItem.setShop(null);
		sleep(VD + 250);
		LogUtils.debug(this, "after sleep");
		assertPixelColor("", t, cellBounds.x, cellBounds.y, new RGB(255, 255, 255));
	}

	/**
	 * Checks that messages are correctly recalulated.
	 */
	@Test
	public void testBasicUpdateOfMessage() {
		myValidatorManager.addRoot(myShop, myValidationAdapter);
		/*
		 * Initial situation
		 */
		sleep(2 * VD);
		assertEquals(0, myValidatorManager.getUnboundMessages().size());

		/*
		 * Negative price
		 */
		myItem.setPrice(-1f);
		sleep(2 * VD);
		assertEquals(1, myValidatorManager.getUnboundMessages().size());
		final IBindingMessage message1 = myValidatorManager.getUnboundMessages().get(0);
		assertTrue(message1.getMessage().contains("'-1'"));

		/*
		 * Change the price and check the message is changed as well.
		 */
		myItem.setPrice(-10f);
		sleep(2 * VD);
		assertEquals(1, myValidatorManager.getUnboundMessages().size());
		final IBindingMessage message2 = myValidatorManager.getUnboundMessages().get(0);
		assertTrue(message2.getMessage().contains("'-10'"));

		/*
		 * Change abbreviation to something correct.
		 */
		myItem.setPrice(10f);
		sleep(2 * VD);
		assertEquals(0, myValidatorManager.getUnboundMessages().size());
	}

}
