package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.resetAll;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import com.rcpcompany.uibindings.extests.TestObjectValidatorAdapter;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ContextMessageDecorator;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.internal.validators.BindingMessageCollectionTest;
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

	private TestView myView;
	protected IFormCreator myForm;

	private IValidatorAdapterManager myValidatorManager;
	private final TestObjectValidatorAdapter myValidationAdapter = new TestObjectValidatorAdapter();

	@Before
	public void before() {
		resetAll();
		VD = IManager.Factory.getManager().getValidationDelay();

		yield();
		myValidatorManager = IValidatorAdapterManager.Factory.getManager();
		myValidatorManager.addRoot(myValidationAdapter.getShop(), myValidationAdapter);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
		myValidatorManager.removeRoot(myValidationAdapter.getShop(), myValidationAdapter);
	}

	public void test(Runnable run) {
		myView = createTestView(this);
		assertNoLog(run);
		yield();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IBindingContext context = myForm.getContext();
				final ContextMessageDecorator decorator = context.getService(ContextMessageDecorator.class);
				final List<IBindingMessage> messages = decorator.getMessages();

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
