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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.SubTestObject;
import com.rcpcompany.uibinding.tests.model.TestContainer;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IArgumentProvider;
import com.rcpcompany.uibindings.IArgumentValue;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IColumnBinding;
import com.rcpcompany.uibindings.IColumnBindingCellInformation;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * This test is about the different ways arguments can be specified for bindings according to the
 * comment of {@link IBinding#getArguments(String, Class, boolean)}.
 * <p>
 * This covers {@link IBinding#getArgument(String, Class, Object)} and
 * {@link IBinding#getArguments(String, Class, boolean)}.
 * <p>
 * Please notice that there are a lot of annotations for "foobar-Sequence" both in the test EMF
 * model and in the uibindings extension point of this fragment.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ArgumentsSequenceTest {
	private TestView myView;

	public static final String ARG = "foobar-Sequence";
	private TestContainer myModel;
	private TestObject myObject;
	private SubTestObject mySubObject;

	@Before
	public void setup() {
		resetAll();
		myView = createTestView(this);

		myModel = TestModelFactory.eINSTANCE.getTestContainer();
		myObject = myModel.getChildren().get(1);
		mySubObject = TestModelFactory.eINSTANCE.createSubTestObject();
		myModel.setCurrent(mySubObject);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests the values are fetched in the correct sequence for attributes.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testAttributeSequence() {
		final IFormCreator form = myView.createFormCreator(myObject);
		final IValueBinding binding = form.addField("text").type("argumentScopeTest").arg("extender", "foobar")
				.arg(ARG, "direct arg");
		binding.getExtraArgumentProviders().add(new IArgumentProvider() {
			@Override
			public boolean hasArguments() {
				return true;
			}

			@Override
			public Map<String, Object> getArguments() {
				final HashMap<String, Object> m = new HashMap<String, Object>();
				m.put(ARG, "IArgumentProvider1");

				return m;
			}
		});
		binding.getExtraArgumentProviders().add(new IArgumentProvider() {
			@Override
			public boolean hasArguments() {
				return true;
			}

			@Override
			public Map<String, Object> getArguments() {
				final HashMap<String, Object> m = new HashMap<String, Object>();
				m.put(ARG, "IArgumentProvider2");

				return m;
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				form.finish();
				yield();
			}
		});

		/*
		 * Test of getArguments(...)
		 */
		final List<IArgumentValue<String>> list = binding.getArguments(ARG, String.class, false);
		assertNotNull(list);

		System.out.println("Test:");
		for (final IArgumentValue<String> a : list) {
			System.out.println("    '" + a.getValue() + "' " + a.getSource());
		}

		assertEquals(11, list.size());
		assertEquals("extender", list.get(0).getValue());
		assertEquals("direct arg", list.get(1).getValue());
		assertEquals("bindingDecorator.simple", list.get(2).getValue());
		assertEquals("TestObject.text (annotation)", list.get(3).getValue());
		assertEquals("TestObject.text", list.get(4).getValue());
		assertEquals("java.lang.String", list.get(5).getValue());
		assertEquals("java.lang.CharSequence", list.get(6).getValue());
		assertEquals("TestObject (annotation)", list.get(7).getValue());
		assertEquals("TestObject", list.get(8).getValue());
		assertEquals("IArgumentProvider1", list.get(9).getValue());
		assertEquals("IArgumentProvider2", list.get(10).getValue());

		// TODO: missing "SubTestObject (annotation)"
	}

	/**
	 * Tests the values are fetched in the correct sequence for cells in viewers.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testCellSequence() {
		final IFormCreator form = myView.createFormCreator(myModel);
		final ITableCreator table = form.addTableCreator(TestModelPackage.Literals.TEST_CONTAINER__CHILDREN, false,
				SWT.NONE);
		final IColumnBinding column = table.addColumn("text(w=200)").type("argumentScopeTest")
				.arg("extender", "foobar").arg(ARG, "column arg");
		column.getExtraArgumentProviders().add(new IArgumentProvider() {
			@Override
			public boolean hasArguments() {
				return true;
			}

			@Override
			public Map<String, Object> getArguments() {
				final HashMap<String, Object> m = new HashMap<String, Object>();
				m.put(ARG, "IArgumentProvider1");

				return m;
			}
		});
		column.getExtraArgumentProviders().add(new IArgumentProvider() {
			@Override
			public boolean hasArguments() {
				return true;
			}

			@Override
			public Map<String, Object> getArguments() {
				final HashMap<String, Object> m = new HashMap<String, Object>();
				m.put(ARG, "IArgumentProvider2");

				return m;
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				form.finish();
				yield();
			}
		});

		final IColumnBindingCellInformation cell = table.getBinding().getCell(0, myModel.getChildren().get(0));
		assertNotNull(cell);
		final IValueBinding binding = cell.getLabelBinding();
		assertNotNull(binding);

		/*
		 * Test of getArguments(...)
		 */
		final List<IArgumentValue<String>> list = binding.getArguments(ARG, String.class, false);
		assertNotNull(list);

		System.out.println("Test:");
		for (final IArgumentValue<String> a : list) {
			System.out.println("    '" + a.getValue() + "' " + a.getSource());
		}

		assertEquals(11, list.size());
		assertEquals("extender", list.get(0).getValue());
		// No direct label binding arguments
		assertEquals("bindingDecorator.simple", list.get(1).getValue());
		assertEquals("column arg", list.get(2).getValue());
		assertEquals("TestObject.text (annotation)", list.get(3).getValue());
		assertEquals("TestObject.text", list.get(4).getValue());
		assertEquals("java.lang.String", list.get(5).getValue());
		assertEquals("java.lang.CharSequence", list.get(6).getValue());
		assertEquals("TestObject (annotation)", list.get(7).getValue());
		assertEquals("TestObject", list.get(8).getValue());
		assertEquals("IArgumentProvider1", list.get(9).getValue());
		assertEquals("IArgumentProvider2", list.get(10).getValue());
		// assertEquals("", list.get(11).getValue());
		// assertEquals("", list.get(12).getValue());

		// TODO: missing "SubTestObject (annotation)"
	}

	/**
	 * Tests the values are fetched in the correct sequence for references.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testReferenceSequence() {
		final IFormCreator form = myView.createFormCreator(myModel);
		final IValueBinding binding = form.addField("current").type("argumentScopeTest").arg("extender", "foobar")
				.arg(ARG, "direct arg");

		binding.getExtraArgumentProviders().add(new IArgumentProvider() {
			@Override
			public boolean hasArguments() {
				return true;
			}

			@Override
			public Map<String, Object> getArguments() {
				final HashMap<String, Object> m = new HashMap<String, Object>();
				m.put(ARG, "IArgumentProvider1");

				return m;
			}
		});
		binding.getExtraArgumentProviders().add(new IArgumentProvider() {
			@Override
			public boolean hasArguments() {
				return true;
			}

			@Override
			public Map<String, Object> getArguments() {
				final HashMap<String, Object> m = new HashMap<String, Object>();
				m.put(ARG, "IArgumentProvider2");

				return m;
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				form.finish();
				yield();
			}
		}, new String[] { ".*Binding cannot be changed.*" });

		/*
		 * Test of getArguments(...)
		 */
		final List<IArgumentValue<String>> list = binding.getArguments(ARG, String.class, false);
		assertNotNull(list);

		System.out.println("Test:");
		for (final IArgumentValue<String> a : list) {
			System.out.println("    '" + a.getValue() + "' " + a.getSource());
		}

		assertEquals(12, list.size());
		assertEquals("extender", list.get(0).getValue());
		assertEquals("direct arg", list.get(1).getValue());
		assertEquals("bindingDecorator.eobject", list.get(2).getValue());
		assertEquals("TestContainer.current (annotation)", list.get(3).getValue());
		assertEquals("TestContainer.current", list.get(4).getValue());
		assertEquals("TestObject (annotation)", list.get(5).getValue());
		assertEquals("TestObject", list.get(6).getValue());
		assertEquals("EObject", list.get(7).getValue());
		assertEquals("TestContainer (annotation)", list.get(8).getValue());
		assertEquals("TestContainer", list.get(9).getValue());
		assertEquals("IArgumentProvider1", list.get(10).getValue());
		assertEquals("IArgumentProvider2", list.get(11).getValue());

		// TODO: missing "SubTestObject (annotation)"
	}

	/**
	 * Checks that the arguments are correct.
	 * 
	 * @param binding the base binding
	 * @param name the argument name
	 * @param expectedValue the expected value
	 * @param expectedSource the class of the source for the primary result
	 * @param expectedResults the expected number of results
	 */
	public void check(IValueBinding binding, String name, String expectedValue, Class<?> expectedSource,
			int expectedResults) {
		assertNotNull(binding);
		/*
		 * Test of getArguments(...)
		 */
		final List<IArgumentValue<String>> list = binding.getArguments(name, String.class, false);
		assertNotNull(list);
		System.out.println("Test: " + expectedValue + ":");
		for (final IArgumentValue<String> a : list) {
			System.out.println("    '" + a.getValue() + "' " + a.getSource());
		}

		assertEquals(expectedResults, list.size());
		assertEquals(expectedValue, list.get(0).getValue());

		if (expectedSource == null) {
			assertEquals(expectedSource, list.get(0).getSource());
		} else {
			assertTrue(expectedSource.isInstance(list.get(0).getSource()));
		}

		for (int i = 1; i < expectedResults; i++) {
			assertTrue("missing 'not used' prefix", list.get(i).getValue().startsWith("not used"));
		}

		/*
		 * Test of getArgument(...)
		 */
		assertEquals(expectedValue, binding.getArgument(name, String.class, ""));
	}
}
