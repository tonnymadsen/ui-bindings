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
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.TestObjectValidatorAdapter;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests that <em>object</em> messages are added to the {@link ValueBindingMessageImageDecorator} at
 * the right time..
 * <p>
 * Note that the basic function of {@link ValueBindingMessageImageDecorator} is tested in
 * {@link BindingMessageCollectionTest}.
 * <p>
 * Depends on:
 * <ul>
 * <li>nothing</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class BindingObjectMessageCollectionTest {
	private final Boolean myCollectObjectMessages;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ null }, { Boolean.TRUE }, { Boolean.FALSE },

		});
	}

	public BindingObjectMessageCollectionTest(Boolean collect) {
		myCollectObjectMessages = collect;
	}

	protected int VD;

	private TestView myView;
	private IValueBinding myBinding;

	private ValueBindingMessageImageDecorator myMessageDecorator;
	private ValidatorAdapterManager myValidatorManager;

	private final TestObjectValidatorAdapter myValidationAdapter = new TestObjectValidatorAdapter();

	@Before
	public void before() {
		resetAll();
		VD = IManager.Factory.getManager().getValidationDelay();

		createView();
		yield();
		myValidatorManager = (ValidatorAdapterManager) IValidatorAdapterManager.Factory.getManager();
		myMessageDecorator = myBinding.getService(ValueBindingMessageImageDecorator.class);
	}

	/**
	 * 
	 */
	private void createView() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myView = UIBindingsTestUtils.createUIBTestView(this);
				final IFormCreator form = myView.createFormCreator(myValidationAdapter.getItem());
				myBinding = form.addField("price");
				if (myCollectObjectMessages != null) {
					myBinding.arg(Constants.ARG_MODEL_OBJECT_MESSAGES, myCollectObjectMessages);
				}

				form.finish();
			}
		});
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
		myValidatorManager.removeRoot(myValidationAdapter.getShop(), myValidationAdapter);
	}

	@Test
	public void testBinding() {
		assertNotNull(myValidatorManager);
		assertNotNull(myMessageDecorator);

		final int initNoUnboundMessage = myValidatorManager.getUnboundMessages().size();
		System.out.println(myValidatorManager.getUnboundMessages());
		assertEquals(0, initNoUnboundMessage);

		myValidatorManager.addRoot(myValidationAdapter.getShop(), myValidationAdapter);
		sleep(VD + 100);

		final int noUnboundMessage = myValidatorManager.getUnboundMessages().size();
		assertTrue(noUnboundMessage >= initNoUnboundMessage);

		final List<IBindingMessage> messages = myMessageDecorator.getMessages();
		assertNotNull(messages);

		assertEquals(0, messages.size());

		myValidationAdapter.getItem().setPrice(TestObjectValidatorAdapter.LIMIT - 10f);

		// Test after the validation delay
		sleep(VD + 100);
		assertEquals(noUnboundMessage + 1, myValidatorManager.getUnboundMessages().size());
		if (myCollectObjectMessages == Boolean.TRUE) {
			// If collecting model object messages
			assertEquals(1, messages.size());

			final IBindingMessage message = messages.get(0);
			assertEquals(myBinding, message.getBinding());
			assertEquals(myBinding.getControl(), message.getControl());
			assertEquals(IMessageProvider.ERROR, message.getMessageType());
			assertEquals(BindingMessageSeverity.ERROR, message.getSeverity());
			assertTrue(message.matches(myValidationAdapter.getItem(), null, null, FeatureMatchingAlgorithm.EXACT));
			assertEquals(TestObjectValidatorAdapter.ERROR_MESSAGE + " for item", message.getMessage());
		} else {
			// If not
			assertEquals(0, messages.size());
		}
		myValidationAdapter.getItem().setPrice(TestObjectValidatorAdapter.LIMIT + 10f);

		// Test after the validation delay
		sleep(VD + 100);

		assertEquals(noUnboundMessage, myValidatorManager.getUnboundMessages().size());
		assertEquals(0, messages.size());
	}
}
