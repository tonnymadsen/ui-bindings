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
package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.SubTestObject;
import com.rcpcompany.uibinding.tests.model.TestContainer;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBinding.IArgumentValue;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IDecoratorProvider;
import com.rcpcompany.uibindings.IModelArgumentMediator;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.ModelClassInfoImpl;
import com.rcpcompany.uibindings.internal.ModelFeatureInfoImpl;
import com.rcpcompany.uibindings.internal.bindingDataTypes.EClassifierBindingDataType;
import com.rcpcompany.uibindings.internal.bindingDataTypes.EStructuralFeatureBindingDataType;

/**
 * This test is about the different ways arguments can be specified for bindings.
 * <p>
 * This covers {@link IBinding#getArgument(String, Class, Object)} and
 * {@link IBinding#getArguments(String, Class, boolean)}.
 * <p>
 * Please notice that there are a lot of annotations for "foobar" both in the test EMF model and in
 * the uibindings extension point of this fragment.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ArgumentsScopeTest {
	private TestView myView;
	private Composite myBody;
	private IBindingContext myContext;
	private Text myText;

	public static final String ARG = "foobar";
	private TestContainer myModel;
	private TestObject myObject;
	private SubTestObject mySubObject;

	@Before
	public void setup() {
		resetAll();
		myView = createTestView(this);
		myBody = myView.getBody();

		myText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		myText.setText("hello");

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myModel = TestModelFactory.eINSTANCE.getTestContainer();
		myObject = myModel.getChildren().get(1);
		mySubObject = TestModelFactory.eINSTANCE.createSubTestObject();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Test the {@code IBinding.arg(name, value)} version.
	 * <p>
	 * Test data: uibindings/decoratorExtender(FoobarExtender)/argument(foobar)+Below
	 */
	@Test
	public void testDecoratorExtender() {
		final IValueBinding binding = myContext
				.addBinding(myText, myObject, TestModelPackage.Literals.TEST_OBJECT__TEXT).arg("extender", "foobar")
				.arg(ARG, "not used: a");

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		});

		check(binding, "ex", IUIBindingDecoratorExtenderDescriptor.class, 3);
	}

	/**
	 * Test the {@code IBinding.arg(name, value)} version.
	 * <p>
	 * Test data: Below+EMF
	 * annotation(EX.ecore)/EClass(TestObject)/EStructualFeature(text)/EAnnotation
	 * (uibindings)/detail(foobar)
	 */
	@Test
	public void testIBindingArg() {
		final IValueBinding binding = myContext.addBinding(myText, myObject,
				TestModelPackage.Literals.TEST_OBJECT__TEXT).arg(ARG, "a");

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		});

		final Map<String, Object> arguments = binding.getArguments();
		assertNotNull(arguments);
		assertEquals("a", arguments.get(ARG));

		check(binding, "a", IValueBinding.class, 2);
	}

	/**
	 * Test the EMF Model annotation on feature version.
	 * <p>
	 * Test data: EMF
	 * annotation(EX.ecore)/EClass(TestObject)/EStructualFeature(number)/EAnnotation(uibindings
	 * )/detail(foobar)
	 */
	@Test
	public void testEMFAnnotationFeature() {
		final IValueBinding binding = myContext.addBinding(myText, myObject,
				TestModelPackage.Literals.TEST_OBJECT__NUMBER);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		});

		check(binding, "b", EStructuralFeatureBindingDataType.class, 2);
	}

	/**
	 * Test the EMF Model annotation on feature version for a subclass.
	 * <p>
	 * Test data: EMF
	 * annotation(EX.ecore)/EClass(TestObject)/EStructualFeature(short)/EAnnotation(uibindings
	 * )/detail(foobar)
	 */
	@Test
	public void testEMFAnnotationFeatureSub1() {
		final IValueBinding binding = myContext.addBinding(myText, myObject,
				TestModelPackage.Literals.TEST_OBJECT__SHORT);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		});

		check(binding, "b", EStructuralFeatureBindingDataType.class, 1);
	}

	/**
	 * Test the EMF Model annotation on feature version for a subclass.
	 * <p>
	 * Also tests {@link IModelArgumentMediator}.
	 * <p>
	 * Test data: EMF
	 * annotation(EX.ecore)/EClass(SubTestObject)/EAnnotation(uibindings)/detail(number.foobar)
	 */
	@Test
	@Ignore
	public void testEMFAnnotationFeatureSub2() {
		final IValueBinding binding = myContext.addBinding(myText, mySubObject,
				TestModelPackage.Literals.TEST_OBJECT__NUMBER);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		});

		check(binding, "b.sub", EStructuralFeatureBindingDataType.class, 2);
	}

	/**
	 * Test the uibindings/model feature version.
	 * <p>
	 * Test data: uibindings/model(TestObject)/feature(date)/argument(foobar)
	 */
	@Test
	public void testUIBindingModelFeature() {
		final IValueBinding binding = myContext.addBinding(myText, myObject,
				TestModelPackage.Literals.TEST_OBJECT__DATE);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		});

		check(binding, "ui a", ModelFeatureInfoImpl.class, 2);
	}

	/**
	 * Test the EMF Model annotation on result type version.
	 * <p>
	 * Test data: EMF
	 * annotation(EX.ecore)/EClass(AmountAndCurrencyStruct)/EAnnotation(uibindings)/detail(foobar)
	 */
	@Test
	public void testEMFAnnotationResultType() {
		final IValueBinding binding = myContext.addBinding(myText, myObject, TestModelPackage.Literals.TEST_OBJECT__AC);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		}, new String[] { ".*Binding cannot be changed.*" });

		check(binding, "c", EClassifierBindingDataType.class, 2);
	}

	/**
	 * Test the uibindings/model resultType version.
	 * <p>
	 * Test data: uibindings/model(TestObject)/argument(foobar)
	 */
	@Test
	public void testUIBindingModelResultType() {
		final IValueBinding binding = myContext.addBinding(myText, myModel,
				TestModelPackage.Literals.TEST_CONTAINER__CURRENT);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		}, new String[] { ".*Binding cannot be changed.*" });

		check(binding, "ui b", ModelClassInfoImpl.class, 1);
	}

	/**
	 * Test the uibindings/model resultType superclass/super interface version.
	 * <p>
	 * Test data: uibindings/model(Enumerator)/argument(foobar)
	 */
	@Test
	public void testUIBindingModelSuperClassResultType() {
		final IValueBinding binding = myContext.addBinding(myText, myObject,
				TestModelPackage.Literals.TEST_OBJECT__TIME_UNIT);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		}, new String[] { ".*Binding cannot be changed, but is not read-only" });

		check(binding, "ui tu", ModelClassInfoImpl.class, 1);
	}

	/**
	 * Test the uibindings/model resultType for a primitive type version.
	 * <p>
	 * Test data: uibindings/model(boolean)/argument(foobar)
	 */
	@Test
	public void testUIBindingModelResultTypeBoolean() {
		final IValueBinding binding = myContext.addBinding(myText, myObject, TestModelPackage.Literals.TEST_OBJECT__B);

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		});

		check(binding, "boolean", ModelClassInfoImpl.class, 1);
	}

	/**
	 * Test the decorator argument version.
	 * <p>
	 * Test data: uibindings/bindingDecorator(foobar)
	 */
	@Test
	public void testDecorator() {
		final IValueBinding binding = myContext.addBinding(myText, myObject, TestModelPackage.Literals.TEST_OBJECT__D)
				.type("foobar");

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myContext.finish();
				yield();
			}
		});
		check(binding, "unit-value", IDecoratorProvider.class, 1);
	}

	public void check(IValueBinding binding, String expectedValue, Class<?> expectedSource, int expectedResults) {
		assertNotNull(binding);
		/*
		 * Test of getArguments(...)
		 */
		final List<IArgumentValue<String>> list = binding.getArguments(ARG, String.class, false);
		assertNotNull(list);
		// System.out.println("Test: " + expectedValue + ":");
		// for (final IArgumentValue<String> a : list) {
		// System.out.println("    '" + a.getValue() + "' " + a.getSource());
		// }

		assertEquals(expectedResults, list.size());
		assertEquals(expectedValue, list.get(0).getValue());

		if (expectedSource == null) {
			assertEquals(expectedSource, list.get(0).getSource());
		} else {
			assertTrue(expectedSource.isInstance(list.get(0).getSource()));
		}

		for (int i = 1; i < expectedResults; i++) {
			assertTrue(list.get(i).getValue().startsWith("not used"));
		}

		/*
		 * Test of getArgument(...)
		 */
		assertEquals(expectedValue, binding.getArgument(ARG, String.class, ""));
	}
}
