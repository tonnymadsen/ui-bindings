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
	public void testAttributeAllSequence() {
		testOneAttributeSequence(ARG + "-all", "extender", null, "bindingDecorator.simple",
				"TestObject.text (annotation)", "TestObject.text", "java.lang.String", "java.lang.CharSequence",
				"TestObject (annotation)", "TestObject", "IArgumentProvider1", "IArgumentProvider2");
		// TODO: missing "SubTestObject (annotation)"
	}

	/**
	 * Tests the values are fetched in the correct sequence for attributes.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testAttributeDefaultSequence() {
		testOneAttributeSequence(ARG + "-default", "extender", null, "bindingDecorator.simple",
				"TestObject.text (annotation)", "TestObject.text", "TestObject (annotation)", "TestObject",
				"IArgumentProvider1", "IArgumentProvider2");
	}

	/**
	 * Tests the values are fetched in the correct sequence for attributes.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testAttributeParentSequence() {
		testOneAttributeSequence(ARG + "-parent", "extender", null, "bindingDecorator.simple",
				"TestObject.text (annotation)", "TestObject.text", "IArgumentProvider1", "IArgumentProvider2");
	}

	/**
	 * Tests the values are fetched in the correct sequence for attributes.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testAttributeTargetTypeSequence() {
		testOneAttributeSequence(ARG + "-targetType", "extender", null, "bindingDecorator.simple",
				"TestObject.text (annotation)", "TestObject.text", "java.lang.String", "java.lang.CharSequence",
				"IArgumentProvider1", "IArgumentProvider2");
	}

	/**
	 * Tests the values are fetched in the correct sequence for attributes.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testAttributeContainingClassSequence() {
		testOneAttributeSequence(ARG + "-containingClass", "extender", null, "bindingDecorator.simple",
				"TestObject.text (annotation)", "TestObject.text", "TestObject (annotation)", "TestObject",
				"IArgumentProvider1", "IArgumentProvider2");
	}

	private void testOneAttributeSequence(final String arg, final String... results) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IFormCreator form = myView.createFormCreator(myObject);
				final IValueBinding binding = form.addField("text").type("argumentScopeTest").arg("extender", "foobar")
						.arg(arg, null);
				binding.getExtraArgumentProviders().add(new IArgumentProvider() {
					@Override
					public boolean hasArguments() {
						return true;
					}

					@Override
					public Map<String, Object> getArguments() {
						final HashMap<String, Object> m = new HashMap<String, Object>();
						m.put(arg, "IArgumentProvider1");

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
						m.put(arg, "IArgumentProvider2");

						return m;
					}
				});

				form.finish();
				yield();

				final List<IArgumentValue<String>> list = binding.getArguments(arg, String.class, false);
				assertNotNull(list);

				printList(list);

				assertEquals(results.length, list.size());
				for (int i = 0; i < results.length; i++) {
					assertEquals(results[i], list.get(i).getValue());
				}
			}
		});
	}

	/**
	 * Tests the values are fetched in the correct sequence for cells in viewers.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testCellAllSequence() {
		testOneCellSequence(ARG + "-all", "extender", "bindingDecorator.simple", "column arg",
				"TestObject.text (annotation)", "TestObject.text", "java.lang.String", "java.lang.CharSequence",
				"TestObject (annotation)", "TestObject", "IArgumentProvider1", "IArgumentProvider2");
	}

	/**
	 * Tests the values are fetched in the correct sequence for cells in viewers.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testCellDefaultSequence() {
		testOneCellSequence(ARG + "-default", "extender", "bindingDecorator.simple", "column arg",
				"TestObject.text (annotation)", "TestObject.text", "TestObject (annotation)", "TestObject",
				"IArgumentProvider1", "IArgumentProvider2");
	}

	/**
	 * Tests the values are fetched in the correct sequence for cells in viewers.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testCellParentSequence() {
		testOneCellSequence(ARG + "-parent", "extender", "bindingDecorator.simple", "column arg",
				"TestObject.text (annotation)", "TestObject.text", "IArgumentProvider1", "IArgumentProvider2");
	}

	/**
	 * Tests the values are fetched in the correct sequence for cells in viewers.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testCellTargetTypeSequence() {
		testOneCellSequence(ARG + "-targetType", "extender", "bindingDecorator.simple", "TestObject.text (annotation)",
				"TestObject.text", "java.lang.String", "java.lang.CharSequence", "IArgumentProvider1",
				"IArgumentProvider2");
	}

	/**
	 * Tests the values are fetched in the correct sequence for cells in viewers.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testCellContainingClassSequence() {
		testOneCellSequence(ARG + "-containingClass", "extender", "bindingDecorator.simple",
				"TestObject.text (annotation)", "TestObject.text", "TestObject (annotation)", "TestObject",
				"IArgumentProvider1", "IArgumentProvider2");
	}

	private void testOneCellSequence(final String arg, final String... results) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IFormCreator form = myView.createFormCreator(myModel);
				final ITableCreator table = form.addTableCreator(TestModelPackage.Literals.TEST_CONTAINER__CHILDREN,
						false, SWT.NONE);
				final IColumnBinding column = table.addColumn("text(w=200)").type("argumentScopeTest")
						.arg("extender", "foobar").arg(arg, "column arg");
				column.getExtraArgumentProviders().add(new IArgumentProvider() {
					@Override
					public boolean hasArguments() {
						return true;
					}

					@Override
					public Map<String, Object> getArguments() {
						final HashMap<String, Object> m = new HashMap<String, Object>();
						m.put(arg, "IArgumentProvider1");

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
						m.put(arg, "IArgumentProvider2");

						return m;
					}
				});

				form.finish();
				yield();

				final IColumnBindingCellInformation cell = table.getBinding().getCell(0, myModel.getChildren().get(0));
				assertNotNull(cell);
				final IValueBinding binding = cell.getLabelBinding();
				assertNotNull(binding);

				final List<IArgumentValue<String>> list = binding.getArguments(arg, String.class, false);
				assertNotNull(list);

				printList(list);

				assertEquals(results.length, list.size());
				for (int i = 0; i < results.length; i++) {
					assertEquals(results[i], list.get(i).getValue());
				}
			}
		});
	}

	/**
	 * Tests the values are fetched in the correct sequence for references.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testReferenceAllSequence() {
		testOneReferenceSequence(ARG + "-all", "extender", "direct arg", "bindingDecorator.eobject",
				"TestContainer.current (annotation)", "TestContainer.current", "TestObject (annotation)", "TestObject",
				"EObject", "TestContainer (annotation)", "TestContainer", "IArgumentProvider1", "IArgumentProvider2");

		// TODO: missing "SubTestObject (annotation)"
	}

	/**
	 * Tests the values are fetched in the correct sequence for references.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testReferenceDefaultSequence() {
		testOneReferenceSequence(ARG + "-default", "extender", "direct arg", "bindingDecorator.eobject",
				"TestContainer.current (annotation)", "TestContainer.current", "TestObject (annotation)", "TestObject",
				"EObject", "IArgumentProvider1", "IArgumentProvider2");

		// TODO: missing "SubTestObject (annotation)"
	}

	/**
	 * Tests the values are fetched in the correct sequence for references.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testReferenceParentSequence() {
		testOneReferenceSequence(ARG + "-parent", "extender", "direct arg", "bindingDecorator.eobject",
				"TestContainer.current (annotation)", "TestContainer.current", "IArgumentProvider1",
				"IArgumentProvider2");

		// TODO: missing "SubTestObject (annotation)"
	}

	/**
	 * Tests the values are fetched in the correct sequence for references.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testReferenceTargetTypeSequence() {
		testOneReferenceSequence(ARG + "-targetType", "extender", "direct arg", "bindingDecorator.eobject",
				"TestContainer.current (annotation)", "TestContainer.current", "TestObject (annotation)", "TestObject",
				"EObject", "IArgumentProvider1", "IArgumentProvider2");

		// TODO: missing "SubTestObject (annotation)"
	}

	/**
	 * Tests the values are fetched in the correct sequence for references.
	 * <p>
	 * Test data: all over EX.ecore, fragment.xml, etc
	 */
	@Test
	public void testReferenceContainingClassSequence() {
		testOneReferenceSequence(ARG + "-containingClass", "extender", "direct arg", "bindingDecorator.eobject",
				"TestContainer.current (annotation)", "TestContainer.current", "TestContainer (annotation)",
				"TestContainer", "IArgumentProvider1", "IArgumentProvider2");

		// TODO: missing "SubTestObject (annotation)"
	}

	private void testOneReferenceSequence(final String arg, final String... results) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IFormCreator form = myView.createFormCreator(myModel);
				final IValueBinding binding = form.addField("current").type("argumentScopeTest")
						.arg("extender", "foobar").arg(arg, "direct arg")
						.validValues(myModel, TestModelPackage.Literals.TEST_CONTAINER__CHILDREN);

				binding.getExtraArgumentProviders().add(new IArgumentProvider() {
					@Override
					public boolean hasArguments() {
						return true;
					}

					@Override
					public Map<String, Object> getArguments() {
						final HashMap<String, Object> m = new HashMap<String, Object>();
						m.put(arg, "IArgumentProvider1");

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
						m.put(arg, "IArgumentProvider2");

						return m;
					}
				});

				form.finish();
				yield();

				final List<IArgumentValue<String>> list = binding.getArguments(arg, String.class, false);
				assertNotNull(list);

				printList(list);

				assertEquals(results.length, list.size());
				for (int i = 0; i < results.length; i++) {
					assertEquals(results[i], list.get(i).getValue());
				}
			}
		});
	}

	/**
	 * @param list
	 */
	private void printList(final List<IArgumentValue<String>> list) {
//		System.out.println("Test:");
//		for (final IArgumentValue<String> a : list) {
//			System.out.println("    '" + a.getValue() + "' " + a.getSource());
//		}
	}
}
