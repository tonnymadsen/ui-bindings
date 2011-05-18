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
package com.rcpcompany.uibindings.extests.decoratorProviders;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;

/**
 * Special test of ranges for {@link INumberDecoratorProvider}.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public class NumberDecoratorProviderRangeTest {

	private TestView myView;
	private Composite myBody;

	private IBindingContext myContext;

	private Text myText;
	private IValueBinding myBinding;

	private TestObject myTestObject;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(500);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
	}

	private void createModel() {
		myTestObject = TestModelFactory.eINSTANCE.createTestObject();
	}

	private void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	private void bindUI(String range) {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myBinding = myContext.addBinding(myText, myTestObject, TestModelPackage.Literals.TEST_OBJECT__D).arg(
				Constants.ARG_RANGE, range);

		myContext.finish();
		yield();
	}

	@Test
	public void testII() {
		testOne("[0;10]", new Object[][] { { "0", 0.0 }, { "10", 10.0 }, }, new Object[][] {
				{ "-0.0001", ".* '-0.0001' outside declared range \\[0; 10\\]" },
				{ "10.0001", ".* '10.0001' outside declared range \\[0; 10\\]" }, });
	}

	@Test
	public void testIE() {
		testOne("[0;10[", new Object[][] { { "0", 0.0 }, { "9.999", 9.999 }, }, new Object[][] {
				{ "-0.0001", ".* '-0.0001' outside declared range \\[0; 10\\[" },
				{ "10", ".* '10' outside declared range \\[0; 10\\[" }, });
	}

	@Test
	public void testEI() {
		testOne("]0;10]", new Object[][] { { "0.0001", 0.0001 }, { "10", 10.0 }, }, new Object[][] {
				{ "0", ".* '0' outside declared range \\]0; 10\\]" },
				{ "10.0001", ".* '10.0001' outside declared range \\]0; 10\\]" }, });
	}

	@Test
	public void testEE() {
		testOne("]0;10[", new Object[][] { { "0.0001", 0.0001 }, { "9.999", 9.999 }, }, new Object[][] {
				{ "0", ".* '0' outside declared range \\]0; 10\\[" },
				{ "10", ".* '10' outside declared range \\]0; 10\\[" }, });
	}

	@Test
	public void testNI() {
		testOne("[;10]", new Object[][] { { "-1", -1.0 }, { "10", 10.0 }, }, new Object[][] { { "10.0001",
				".* '10.0001' outside declared range .max 10." }, });
	}

	@Test
	public void testNE() {
		testOne("[;10[", new Object[][] { { "-1", -1.0 }, { "9.999", 9.999 }, }, new Object[][] { { "10",
				".* '10' outside declared range .less than 10." }, });
	}

	@Test
	public void testNIZ() {
		testOne("[;0]", new Object[][] { { "-1", -1.0 }, { "0", 0.0 }, }, new Object[][] { { "0.0001",
				".* '0.0001' must be negative or zero" }, });
	}

	@Test
	public void testNEZ() {
		testOne("[;0[", new Object[][] { { "-1", -1.0 }, { "-0.001", -0.001 }, }, new Object[][] { { "0",
				".* '0' must be negative" }, });
	}

	@Test
	public void testIN() {
		testOne("[1;]", new Object[][] { { "1", 1.0 }, { "11", 11.0 }, }, new Object[][] { { "0.999",
				".* '0.999' outside declared range .min 1." }, });
	}

	@Test
	public void testEN() {
		testOne("]1;]", new Object[][] { { "1.001", 1.001 }, { "11", 11.0 }, }, new Object[][] { { "1",
				".* '1' outside declared range .greater than 1." }, });
	}

	@Test
	public void testIZN() {
		testOne("[0;]", new Object[][] { { "0", 0.0 }, { "11", 11.0 }, }, new Object[][] { { "-0.0001",
				".* '-0.0001' must be positive or zero" }, });
	}

	@Test
	public void testEZN() {
		testOne("]0;]", new Object[][] { { "0.001", 0.001 }, { "11", 11.0 }, }, new Object[][] { { "0",
				".* '0' must be positive" }, });
	}

	private void testOne(String range, Object[][] ui2mOK, Object[][] ui2mError) {
		bindUI(range);

		for (final Object[] v : ui2mOK) {
			final String s = (String) v[0];
			final double expectedResult = (Double) v[1];
			final String what = "(" + range + ": " + s + ")";

			assertNoLog(new Runnable() {
				@Override
				public void run() {
					myText.setText(s);
				}
			});
			assertNoLog(new Runnable() {
				@Override
				public void run() {
					yield();
				}
			});
			final ValueBindingMessageImageDecorator decorator = myBinding
					.getService(ValueBindingMessageImageDecorator.class);
			// System.out.println(what + "=" + decorator.getMessages());
			assertEquals(what, 0, decorator.getMessages().size());
			final double d = myTestObject.getD();
			assertEquals(what, expectedResult, d, 0.00001);
		}

		for (final Object[] v : ui2mError) {
			final String s = (String) v[0];
			final String expectedError = (String) v[1];
			final String what = "(" + range + ": " + s + ")";

			assertNoLog(new Runnable() {
				@Override
				public void run() {
					myText.setText(s);
				}
			});
			assertNoLog(new Runnable() {
				@Override
				public void run() {
					yield();
				}
			});
			final ValueBindingMessageImageDecorator decorator = myBinding
					.getService(ValueBindingMessageImageDecorator.class);
			// System.out.println(what + "=" + decorator.getMessages());
			assertEquals(what, 1, decorator.getMessages().size());
			final IBindingMessage message = (IBindingMessage) decorator.getMessages().get(0);
			// System.out.println("  \"" + message.getMessage() + "\".matches(\"" + expectedError +
			// "\")");
			assertTrue(what, message.getMessage().matches(expectedError));
		}
	}

	@Test
	public void testErrorEOF1() {
		testOneError("]", ".*Expected ';', got 'Token\\[EOF\\].*");
	}

	@Test
	public void testErrorEOF2() {
		testOneError("];", ".*Expected '\\[' or '\\]', got 'Token\\[EOF\\].*");
	}

	@Test
	public void testErrorEOF3() {
		testOneError("  ", ".*Expected '\\[' or '\\]', got 'Token\\[EOF\\].*");
	}

	@Test
	public void testError1() {
		testOneError("]a;]", ".*Expected ';', got 'Token\\[a\\].*");
	}

	@Test
	public void testError2() {
		testOneError("a[;]", ".*Expected '\\[' or '\\]', got 'Token\\[a\\].*");
	}

	@Test
	public void testError3() {
		testOneError("[;]b", ".*Expected <EOS>, got 'Token\\[b\\].*");
	}

	private void testOneError(final String range, String expectedError) {
		final String what = "(" + range + ")";
		final IStatus status = assertOneLog(new Runnable() {
			@Override
			public void run() {
				bindUI(range);
			}
		});
		// System.out.println("s=" + status.getMessage());
		assertNotNull(status.getException());
		assertTrue(what, status.getException().getMessage().matches(expectedError));
	}
}
