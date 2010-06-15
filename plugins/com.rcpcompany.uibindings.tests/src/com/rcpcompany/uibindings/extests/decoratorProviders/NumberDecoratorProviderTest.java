package com.rcpcompany.uibindings.extests.decoratorProviders;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.createTestView;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.yield;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;

@RunWith(Parameterized.class)
public class NumberDecoratorProviderTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] {

						{
								TestModelPackage.Literals.TEST_OBJECT__BYTE,
								"",
								new Object[][] { { (byte) 0, "0" }, { (byte) 10, "10" }, { (byte) -110, "-110" },
										{ Byte.MAX_VALUE, "127" }, { Byte.MIN_VALUE, "-128" } },
								new Object[][] { { "0", (byte) 0 }, { "123", (byte) 123 }, { "127", Byte.MAX_VALUE },
										{ "-128", Byte.MIN_VALUE }, },
								new Object[][] { { "10.2", "Illegal .* '10.2' at position 3: '.'" },
										{ "1,23", "Illegal .* '1,23' at position 2: ','" },
										{ "1123e4", ".* '1123e4' outside native range .max 127." },
										{ "999999999999", ".* '999999999999' outside native range .max 127." },
										{ "128", ".* '128' outside native range .max 127." },
										{ "-129", ".* '-129' outside native range .min -128." }, }

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__SHORT,
								"",
								new Object[][] { { (short) 0, "0" }, { (short) 10, "10" }, { (short) -1110, "-1110" },
										{ Short.MAX_VALUE, "32767" }, { Short.MIN_VALUE, "-32768" } },
								new Object[][] { { "0", (short) 0 }, { "123", (short) 123 },
										{ "32767", Short.MAX_VALUE }, { "-32768", Short.MIN_VALUE }, },
								new Object[][] { { "1,23", "Illegal .* '1,23' at position 2: ','" },
										{ "10.2", "Illegal .* '10.2' at position 3: '.'" },
										{ "1123e4", ".* '1123e4' outside native range .max 32,767." },
										{ "999999999999", ".* '999999999999' outside native range .max 32,767." },
										{ "32768", ".* '32768' outside native range .max 32,767." },
										{ "-32769", ".* '-32769' outside native range .min -32,768." }, }

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__NUMBER,
								"",
								new Object[][] { { 0, "0" }, { 10, "10" }, { -210, "-210" },
										{ Integer.MAX_VALUE, "2147483647" }, { Integer.MIN_VALUE, "-2147483648" } },
								new Object[][] { { "0", 0 }, { "1234", 1234 }, { "2147483647", Integer.MAX_VALUE },
										{ "-2147483648", Integer.MIN_VALUE }, },
								new Object[][] {
										{ "123,5", "Illegal .* '123,5' at position 4: ','" },
										{ "10.2", "Illegal .* '10.2' at position 3: '.'" },
										{ "1123e8", ".* '1123e8' outside native range .max 2,147,483,647." },
										{ "999999999999", ".* '999999999999' outside native range .max 2,147,483,647." },
										{ "2147483648", ".* '2147483648' outside native range .max 2,147,483,647." },
										{ "-2147483649", ".* '-2147483649' outside native range .min -2,147,483,648." }, }

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__NUMBER,
								"limited",
								new Object[][] { { 0, "0" }, { 10, "10" }, { -210, "-210" },
										{ Integer.MAX_VALUE, "2147483647" }, { Integer.MIN_VALUE, "-2147483648" } },
								new Object[][] { { "0", 0 }, { "10", 10 }, },
								new Object[][] {
										{ "-1", ".* '-1' outside declared range .0; 10." },
										{ "1,23", "Illegal .* '1,23' at position 2: ','" },
										{ "11", ".* '11' outside declared range .0; 10." },
										{ "-10.2", "Illegal .* '-10.2' at position 4: '.'" },
										{ "1123e4", ".* '1123e4' outside declared range .0; 10." },
										{ "999999999999", ".* '999999999999' outside native range .max 2,147,483,647." },
										{ "2147483648", ".* '2147483648' outside native range .max 2,147,483,647." },
										{ "-2147483649", ".* '-2147483649' outside native range .min -2,147,483,648." }, }

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__NUMBER,
								"range",
								new Object[][] { { 0, "0" }, { 10, "10" }, { -210, "-210" },
										{ Integer.MAX_VALUE, "2147483647" }, { Integer.MIN_VALUE, "-2147483648" } },
								new Object[][] { { "0", 0 }, { "8", 8 }, },
								new Object[][] {
										{ "-1", ".* '-1' outside declared range .0; 8." },
										{ "1,23", "Illegal .* '1,23' at position 2: ','" },
										{ "9", ".* '9' outside declared range .0; 8." },
										{ "-10.2", "Illegal .* '-10.2' at position 4: '.'" },
										{ "1123e4", ".* '1123e4' outside declared range .0; 8." },
										{ "999999999999", ".* '999999999999' outside native range .max 2,147,483,647." },
										{ "2147483648", ".* '2147483648' outside native range .max 2,147,483,647." },
										{ "-2147483649", ".* '-2147483649' outside native range .min -2,147,483,648." }, }

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__LONG,
								"",
								new Object[][] { { (long) 0, "0" }, { (long) 10, "10" }, { (long) -210, "-210" },
										{ Long.MAX_VALUE, "9223372036854775807" },
										{ Long.MIN_VALUE, "-9223372036854775808" } },
								new Object[][] { { "0", (long) 0 }, { "1234", (long) 1234 },
										{ "9223372036854775807", Long.MAX_VALUE },
										{ "-9223372036854775808", Long.MIN_VALUE }, },
								new Object[][] { { "123,5", "Illegal .* '123,5' at position 4: ','" },
										{ "10.2", "Illegal .* '10.2' at position 3: '.'" },
										{ "1123e32", ".* '1123e32' outside native range .max 9,.*,807." },
										{ "999999999999999999999", ".* '999.*999' outside native range .max 9.*807." },
										{ "9223372036854775808", ".* '9.*808' outside native range .max 9.*807." },
										{ "-9223372036854775809", ".* '-9.*809' outside native range .min -9.*808." }, }

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__F,
								"",
								new Object[][] { { 0.0f, "0.00" }, { 10.33f, "10.33" }, { 1e8f, "100000000.00" },
										{ Float.MAX_VALUE, "340282346638528860000000000000000000000.00" },
										{ -Float.MAX_VALUE, "-340282346638528860000000000000000000000.00" },
										{ Float.POSITIVE_INFINITY, "Infinity" },
										{ Float.NEGATIVE_INFINITY, "-Infinity" }, { Float.NaN, "NaN" } },
								new Object[][] { { "0", 0.0f }, { "1234", 1234.0f }, { "12.35E2", 1235.0f },
										{ "14.35e+2", 1435.0f }, { "12.37e3", 12370.0f },
										{ "340282346638528859811704183484516925440.00", new Float(Float.MAX_VALUE) },
										{ "-340282346638528859811704183484516925440.00", new Float(-Float.MAX_VALUE) },

								/*
								 * { "?" , Float . POSITIVE_INFINITY } , { "-?" , Float .
								 * NEGATIVE_INFINITY } , { "nan" , Float . NaN }
								 */

								},
								new Object[][] {
										{ "1,23", "Illegal .* '1,23' at position 2: ','" },
										{ "123,5.6", "Illegal .* '123,5.6' at position 4: ','" },
										{ "10..2", "Illegal .* '10..2' at position 4: '.'" },
										{ "1123ee4", "Illegal .* '1123ee4' at position 5: 'e'" },
										{ "340282346638528859811704183484516926002",
												".* '340.*002' outside native range .max 340.*440." }, }

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__F,
								"currency",
								new Object[][] { { 0.0f, "0.00" }, { 10.33f, "10.33" }, { 1e8f, "100,000,000.00" },
										{ Float.MAX_VALUE, "340,282,346,638,528,860,000,000,000,000,000,000,000.00" },
										{ -Float.MAX_VALUE, "-340,282,346,638,528,860,000,000,000,000,000,000,000.00" } },
								new Object[][] { { "1,23", (float) 123 }, { "1,,23", (float) 123 }, },
								new Object[][] {}

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__F,
								"scientific",
								new Object[][] { { 0.0f, "0.000" }, { 10.33f, "10.33" }, { 1e8f, "1.000e+08" },
										{ 10330000.0f, "1.033e+07" }, { 0.001033f, "0.001033" },
										{ 10e8f, "1.000e+09" }, { Float.MAX_VALUE, "3.403e+38" },
										{ -Float.MAX_VALUE, "-3.403e+38" } },
								new Object[][] { { "1.234", 1.234f }, { "0", 0.0f }, { "10E4", 10.0e4f },
										{ "10.33", 10.33f }, { "13.98", 13.98f }, { "113.98", 113.98f },
										{ "1.033E1", 10.33f }, { "103.3E-1", 10.33f }, },
								new Object[][] { { "1,2", "Illegal .* '1,2' at position 2: ','" } }

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__D,
								"",
								new Object[][] {
										{ 0.0, "0.00" },
										{ 10.33, "10.33" },
										{ 1e8, "100000000.00" },
										{
												Double.MAX_VALUE,
												"179769313486231570000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.00" },
										{
												-Double.MAX_VALUE,
												"-179769313486231570000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000.00" } },
								new Object[][] { { "0", 0.0 }, { "1234", 1234.0 }, { "14.35e+2", 1435.0 },
										{ "2147483647", new Double(Integer.MAX_VALUE) },
										{ "-2147483648", new Double(Integer.MIN_VALUE) }, },
								new Object[][] {
										{ "123,5.6", "Illegal .* '123,5.6' at position 4: ','" },
										{ "10..2", "Illegal .* '10..2' at position 4: '.'" },
										{ "1123ee4", "Illegal .* '1123ee4' at position 5: 'e'" },
										{
												"17976931348623157000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000",
												".* '179.*000' outside native range .max 179,.*,368." }, }

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__D,
								"currency",
								new Object[][] {
										{ 0.0, "0.00" },
										{ 10.33, "10.33" },
										{ 1e8, "100,000,000.00" },
										{
												Double.MAX_VALUE,
												"179,769,313,486,231,570,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000.00" },
										{
												-Double.MAX_VALUE,
												"-179,769,313,486,231,570,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000,000.00" } },
								new Object[][] {}, new Object[][] {}

						},

						{
								TestModelPackage.Literals.TEST_OBJECT__D,
								"scientific",
								new Object[][] { { 0.0, "0.000" }, { 10.33, "10.33" }, { 1e8, "1.000e+08" },
										{ 10330000.0, "1.033e+07" }, { 0.001033, "0.001033" }, { 10e8, "1.000e+09" },
										{ Double.MAX_VALUE, "1.798e+308" }, { -Double.MAX_VALUE, "-1.798e+308" } },
								new Object[][] { { "1.234", 1.234 }, { "0", 0.0 }, { "10E4", 10.0e4 },
										{ "10.33", 10.33 }, { "13.98", 13.98 }, { "113.98", 113.98 },
										{ "1.033E1", 10.33 }, { "103.3E-1", 10.33 }, },
								new Object[][] { { "1,2", "Illegal .* '1,2' at position 2: ','" } }

						},

				// TODO TEST BigInteger

				// TODO TEST BigDecimal

				});
	}

	final private EStructuralFeature myFeature;
	private final String myType;
	private final Object[][] myM2UIOK;
	private final Object[][] myUI2MOK;
	private final Object[][] myUI2MError;

	public NumberDecoratorProviderTest(EStructuralFeature feature, String type, Object[][] m2uiOK, Object[][] ui2mOK,
			Object[][] ui2mError) {
		myFeature = feature;
		myType = type;
		myM2UIOK = m2uiOK;
		myUI2MOK = ui2mOK;
		myUI2MError = ui2mError;
	}

	// public NumberDecoratorProviderTest() {
	// myFeature = TestModelPackage.Literals.TEST_OBJECT__NUMBER;
	// }

	private TestView myView;
	private Composite myBody;

	private IBindingContext myContext;

	private Text myText;
	private IValueBinding myBinding;

	private TestObject myTestObject;

	@Before
	public void before() {
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(500);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
		bindUI();
	}

	private void createModel() {
		myTestObject = TestModelFactory.eINSTANCE.createTestObject();
	}

	private void createView() {
		myView = createTestView(this);
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

	private void bindUI() {
		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myBinding = (IValueBinding) myContext.addBinding(myText, myTestObject, myFeature).type(myType);

		myContext.finish();
		yield();
	}

	@Test
	public void testM2UIValues() {
		for (final Object[] v : myM2UIOK) {
			final Number n = (Number) v[0];
			final String expectedResult = (String) v[1];
			testM2UI(n, expectedResult);
		}
	}

	@Test
	public void testUI2MValues() {
		for (final Object[] v : myUI2MOK) {
			final String s = (String) v[0];
			final Number expectedResult = (Number) v[1];
			testUI2M(s, expectedResult);
		}
	}

	@Test
	public void testUI2MErrorValues() {
		for (final Object[] v : myUI2MError) {
			final String s = (String) v[0];
			final String expectedResult = (String) v[1];
			testUI2MError(s, expectedResult);
		}
	}

	private void testM2UI(final Number value, String expectedResult) {
		final String what = "(" + myFeature.getName() + "/" + myType + ": " + value + " ["
				+ value.getClass().getSimpleName() + "])";
		assertNoLog(new Runnable() {
			public void run() {
				myTestObject.eSet(myFeature, value);
			}
		});
		assertNoLog(new Runnable() {
			public void run() {
				yield();
			}
		});
		assertEquals(what, expectedResult, myText.getText());
	}

	private void testUI2M(final String string, Number expectedResult) {
		final String what = "(" + myFeature.getName() + "/" + myType + ": " + string + ")";
		assertNoLog(new Runnable() {
			public void run() {
				myText.setText(string);
			}
		});
		assertNoLog(new Runnable() {
			public void run() {
				yield();
			}
		});
		final ValueBindingMessageImageDecorator decorator = myBinding
				.getService(ValueBindingMessageImageDecorator.class);
		// System.out.println(what + "=" + decorator.getMessages());
		assertEquals(what, 0, decorator.getMessages().size());
		final Object object = myTestObject.eGet(myFeature);
		assertEquals(what, expectedResult, object);
	}

	private void testUI2MError(final String string, String expectedError) {
		final String what = "(" + myFeature.getName() + "/" + myType + ": " + string + ")";
		assertNoLog(new Runnable() {
			public void run() {
				myText.setText(string);
			}
		});
		assertNoLog(new Runnable() {
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
		assertTrue(what + " had '" + message.getMessage() + "' - no match for '" + expectedError + "'", message
				.getMessage().matches(expectedError));
	}
}
