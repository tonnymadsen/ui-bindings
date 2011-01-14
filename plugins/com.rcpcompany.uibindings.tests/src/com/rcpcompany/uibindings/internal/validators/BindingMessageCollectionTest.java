/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessage.FeatureMatchingAlgorithm;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests that messages are added to the {@link ValueBindingMessageImageDecorator} at the right
 * time..
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
public class BindingMessageCollectionTest {
	private final boolean myEIV;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				// ValidationErrorsAreFatal

				{ true },

				{ false },

		});
	}

	public BindingMessageCollectionTest(boolean eiv) {
		myEIV = eiv;
	}

	private static final int VD = 500;
	private TestView myView;
	private Composite myBody;
	private ShopItem myItem;
	private IBindingContext myContext;
	private IValueBinding myBinding;
	private ValueBindingMessageImageDecorator myMessageDecorator;
	private ValidatorAdapterManager myValidatorManager;
	private final IValidatorAdapter myValidationAdapter = new ConstraintValidatorAdapter();
	private Text myText;
	private Label myLabel;
	private Shop myShop;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationErrorsAreFatal(myEIV);
		IManager.Factory.getManager().setValidationDelay(VD);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		myValidatorManager = (ValidatorAdapterManager) IValidatorAdapterManager.Factory.getManager();
		bindUI();
		myMessageDecorator = myBinding.getService(ValueBindingMessageImageDecorator.class);
	}

	/**
	 * 
	 */
	private void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myBinding = myContext.addBinding(myText, myItem, ShopPackage.Literals.SHOP_ITEM__PRICE);

		myContext.finish();
		yield();
		myView.getBody().layout();
	}

	/**
	 * 
	 */
	private void createView() {
		myView = createTestView(this);
		myBody = myView.getBody();

		myLabel = new Label(myBody, SWT.NONE);
		myLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		myLabel.setText("lala:");

		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
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
	public void testBinding() {
		yield();

		assertNotNull(myValidatorManager);
		assertNotNull(myMessageDecorator);

		final int initNoUnboundMessage = myValidatorManager.getUnboundMessages().size();
		assertEquals(0, initNoUnboundMessage);

		myValidatorManager.addRoot(myShop, myValidationAdapter);

		final int noUnboundMessage = myValidatorManager.getUnboundMessages().size();
		assertTrue(noUnboundMessage >= initNoUnboundMessage);

		final List<IBindingMessage> messages = myMessageDecorator.getMessages();
		assertNotNull(messages);

		assertEquals(0, messages.size());
		yield();
		final Point size = myText.getSize();
		assertTrue(size.y > 0);
		assertPixelColor("", myText, -4, size.y - 6, new RGB(255, 255, 255));

		myItem.setPrice(-1.0f);
		assertEquals(noUnboundMessage, myValidatorManager.getUnboundMessages().size());
		assertEquals(0, messages.size());
		yield();
		assertPixelColor("", myText, -4, size.y - 6, new RGB(216, 66, 79));

		// Test before the validation delay - problem already found due to the binding
		sleep(VD - 150);
		assertEquals(noUnboundMessage, myValidatorManager.getUnboundMessages().size());
		assertEquals(1, messages.size());

		// Test after the validation delay
		sleep(300);
		assertEquals(noUnboundMessage + 1, myValidatorManager.getUnboundMessages().size());
		// Still just one error, and the two are collapsed into one
		assertEquals(1, messages.size());
		yield();
		assertPixelColor("", myText, -4, size.y - 6, new RGB(216, 66, 79));

		final IBindingMessage message = messages.get(0);
		assertEquals(myBinding, message.getBinding());
		assertEquals(myText, message.getControl());
		assertEquals(IMessageProvider.ERROR, message.getMessageType());
		assertEquals(BindingMessageSeverity.ERROR, message.getSeverity());
		assertTrue(message.matches(myItem, ShopPackage.Literals.SHOP_ITEM__PRICE, null, FeatureMatchingAlgorithm.EXACT));
		assertEquals(myLabel.getText() + " ", message.getPrefix());

		myItem.setPrice(100f);
		// assertEquals(noUnboundMessage + 1, myValidatorManager.getUnboundMessages().size());
		assertEquals(1, messages.size());
		assertEquals(message, messages.get(0));
		yield();
		assertPixelColor("", myText, -4, size.y - 6, new RGB(216, 66, 79));

		// Test before the validation delay
		sleep(VD - 100);
		assertEquals(noUnboundMessage + 1, myValidatorManager.getUnboundMessages().size());
		assertEquals(1, messages.size());
		assertEquals(message, messages.get(0));
		yield();
		assertPixelColor("", myText, -4, size.y - 6, new RGB(216, 66, 79));

		// Test after the validation delay
		sleep(300);
		assertEquals(noUnboundMessage, myValidatorManager.getUnboundMessages().size());
		assertEquals(0, messages.size());
		yield();
		assertPixelColor("", myText, -4, size.y - 6, new RGB(255, 255, 255));

		assertEquals(initNoUnboundMessage, myValidatorManager.getUnboundMessages().size());
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
