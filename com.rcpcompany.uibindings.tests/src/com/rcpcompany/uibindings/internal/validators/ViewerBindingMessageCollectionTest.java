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

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.resource.JFaceResources;
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
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessage.FeatureMatchingAlgorithm;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.IPaintDecoration;
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
	private UIBTestView myView;
	private ShopItem myItem;
	private ValueBindingMessageImageDecorator myMessageDecorator;
	private IValidatorAdapterManager myValidatorManager;
	private final IValidatorAdapter myValidationAdapter = new ConstraintValidatorAdapter();
	private Shop myShop;
	private IColumnBinding myPriceColumn;
	private ITableCreator myTable;
	private IColumnBindingCellInformation myCellInformation;
	private IValueBinding myBinding;

	protected boolean myMessageChangesAllowed = true;
	private final IChangeListener myMessageListener = new IChangeListener() {
		@Override
		public void handleChange(ChangeEvent event) {
			if (!myMessageChangesAllowed) {
				// fail("Changes not allowed");
			}
		}
	};

	/*
	 * Colors
	 */
	private RGB myNoFocusRGB;
	private RGB myEvenRGB;
	private final RGB myRedRGB = new RGB(216, 66, 79);
	private final RGB myWhiteRGB = new RGB(255, 255, 255);

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();

		myValidatorManager = IValidatorAdapterManager.Factory.getManager();

		final IManager manager = IManager.Factory.getManager();
		manager.setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		manager.setValidationErrorsAreFatal(myEIV);
		manager.setValidationDelay(VD);
		manager.setEditCellSingleClick(false);

		myNoFocusRGB = JFaceResources.getColorRegistry().getRGB(
				Constants.COLOR_DEFINITIONS_SELECTION_NO_FOCUS_BACKGROUND);
		myEvenRGB = JFaceResources.getColorRegistry().getRGB(Constants.COLOR_DEFINITIONS_EVEN_ROW_BACKGROUND);

		createModel();
		createView();
	}

	/**
	 * 
	 */
	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);

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
		myItem.setName("a name");
		myItem.setPrice(200f);
		myItem.setShop(myShop);
	}

	@After
	public void disposeView() {
		/*
		 * Must be before the view disposal.
		 */
		myMessageDecorator.getMessages().removeChangeListener(myMessageListener);
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
		myMessageDecorator.getMessages().addChangeListener(myMessageListener);
		myMessageChangesAllowed = false;

		/*
		 * No errors - color according to row
		 */
		assertEquals(0, messages.size());

		final Table t = (Table) myTable.getBinding().getControl();
		final Rectangle cellBounds = t.getItem(0).getBounds(1 + myTable.getBinding().getFirstTableColumnOffset());
		assertTrue(cellBounds.height > 0);
		cellBounds.x += +3;
		cellBounds.y += cellBounds.height - 8;
		assertPC(t, cellBounds.x, cellBounds.y, myEvenRGB);

		/*
		 * Error - colors according to error icon
		 * 
		 * Delayed!
		 */
		myItem.setPrice(-1.0f);
		yield();
		assertEquals(noUnboundMessage, myValidatorManager.getUnboundMessages().size());
		assertEquals(1, messages.size());
		assertPC(t, cellBounds.x, cellBounds.y, myRedRGB);

		// Test before the validation delay - problem already found due to the binding
		sleep(VD - 300);
		assertEquals(noUnboundMessage, myValidatorManager.getUnboundMessages().size());
		assertEquals(1, messages.size());
		assertPC(t, cellBounds.x, cellBounds.y, myNoFocusRGB);

		// Test after the validation delay
		myMessageChangesAllowed = true;
		sleep(600);
		myMessageChangesAllowed = false;
		assertEquals(noUnboundMessage + 1, myValidatorManager.getUnboundMessages().size());
		// Still just one error, and the two are collapsed into one
		assertEquals(1, messages.size());
		assertPC(t, cellBounds.x, cellBounds.y, myRedRGB);

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
		assertPC(t, cellBounds.x, cellBounds.y, myRedRGB);

		// Test before the validation delay
		sleep(VD - 100);
		assertEquals(noUnboundMessage + 1, myValidatorManager.getUnboundMessages().size());
		assertEquals(1, messages.size());
		assertEquals(message, messages.get(0));
		assertPC(t, cellBounds.x, cellBounds.y, myRedRGB);

		// Test after the validation delay
		myMessageChangesAllowed = true;
		sleep(300);
		myMessageChangesAllowed = false;
		assertEquals(noUnboundMessage, myValidatorManager.getUnboundMessages().size());
		assertEquals(0, messages.size());
		assertPC(t, cellBounds.x, cellBounds.y, myNoFocusRGB);

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
		cellBounds.x += +3;
		cellBounds.y += cellBounds.height - 8;

		/*
		 * No errors - color according to row
		 */
		assertPC(t, cellBounds.x, cellBounds.y, myEvenRGB);

		/*
		 * Error - colors according to error icon
		 * 
		 * Delayed!
		 */
		myItem.setPrice(-1.0f);
		sleep(VD + 150);
		assertPC(t, cellBounds.x, cellBounds.y, new RGB(216, 66, 79));

		/*
		 * Delete row
		 */
		LogUtils.debug(this, "before set");
		myItem.setShop(null);
		sleep(VD + 250);
		LogUtils.debug(this, "after sleep");
		assertPC(t, cellBounds.x, cellBounds.y, myWhiteRGB);
	}

	private void assertPC(Table t, int x, int y, RGB expectedRGB) {
		final IPaintDecoration pd = IPaintDecoration.Factory.addDecoration(t, x, y);
		sleep(600);
		assertPixelColor("", t, x, y, expectedRGB);
		IPaintDecoration.Factory.removeDecoration(pd);
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
