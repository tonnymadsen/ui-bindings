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
package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessage.FeatureMatchingAlgorithm;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.contextAdapters.ContextMessageDecorator;
import com.rcpcompany.uibindings.extests.TestObjectValidatorAdapter;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
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
public class FormCreatorObjectMessageCollectionTest {
	protected static final String ERROR_MESSAGE = "This is an error";
	protected int VD;

	private UIBTestView myView;
	protected IFormCreator myForm;

	private IValidatorAdapterManager myValidatorManager;
	private final TestObjectValidatorAdapter myValidationAdapter = new TestObjectValidatorAdapter();

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		VD = IManager.Factory.getManager().getValidationDelay();

		yield();
		myValidatorManager = IValidatorAdapterManager.Factory.getManager();
		myValidatorManager.addRoot(myValidationAdapter.getShop(), myValidationAdapter);
		myValidationAdapter.getItem().setPrice(10f);
		sleep(VD + 100);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
		myValidatorManager.removeRoot(myValidationAdapter.getShop());
	}

	public void test(Runnable run) {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		assertNoLog(run);
		yield();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertEquals(2, myValidatorManager.getUnboundMessages().size());

				final IBindingContext context = myForm.getContext();
				final ContextMessageDecorator decorator = context.getService(ContextMessageDecorator.class);
				assertNotNull(context);
				final List<IBindingMessage> messages = decorator.getMessages();
				assertNotNull(messages);

				assertEquals(1, messages.size());
				final IBindingMessage message = messages.get(0);
				// assertEquals(myBinding, message.getBinding());
				// assertEquals(myBinding.getControl(), message.getControl());
				assertEquals(IMessageProvider.ERROR, message.getMessageType());
				assertEquals(BindingMessageSeverity.ERROR, message.getSeverity());
				assertTrue(message.matches(myValidationAdapter.getItem(), null, null, FeatureMatchingAlgorithm.EXACT));
				assertEquals(ERROR_MESSAGE + " for item", message.getMessage());
			}
		});
	}

	@Test
	public void objectMessageTest() {
		test(new Runnable() {

			@Override
			public void run() {
				myForm = myView.createFormCreator(myValidationAdapter.getItem());

				myForm.addObjectMessages();

				myForm.finish();
			}
		});
	}

	@Test
	public void objectMessageTestX2() {
		test(new Runnable() {

			@Override
			public void run() {
				myForm = myView.createFormCreator(myValidationAdapter.getItem());

				myForm.addObjectMessages();
				myForm.addObjectMessages();

				myForm.finish();
			}
		});
	}

	// @Test
	public void objectMessageSpecTest() {
		test(new Runnable() {
			@Override
			public void run() {
				myForm = myView.createFormCreator(myValidationAdapter.getShop());

				myForm.addObjectMessages();

				myForm.finish();
			}
		});
	}

	@Test
	public void objectMessageSubformTest() {
		test(new Runnable() {
			@Override
			public void run() {
				myForm = myView.createFormCreator(myValidationAdapter.getShop());
				final IFormCreator section = myForm.addSection("sub", myValidationAdapter.getItem());
				section.addObjectMessages();

				myForm.finish();
			}
		});
	}
}
