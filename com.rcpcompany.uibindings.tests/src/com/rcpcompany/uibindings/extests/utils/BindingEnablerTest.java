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
package com.rcpcompany.uibindings.extests.utils;

import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibinding.tests.model.WeightUnit;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.utils.IBindingEnabler;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests of {@link IBindingEnabler}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingEnablerTest {
	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();

		createModel();
	}

	private TestObject myTestObject;
	private UIBTestView myView;
	private IFormCreator myForm;
	private IValueBinding myBinding;

	private void createModel() {
		myTestObject = TestModelFactory.eINSTANCE.createTestObject();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests {@link IBindingEnabler#dispose()}.
	 */
	@Test
	public void testDispose() {
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myTestObject);

		myBinding = myForm.addField("number(w=200)");
		final IBindingEnabler enabler = IBindingEnabler.Factory.add(myBinding, myForm.getObservableValue(),
				TestModelPackage.Literals.TEST_OBJECT__UNIT, WeightUnit.G);

		assertEquals(1, myForm.getContext().getBindings().size());
		assertTrue(myForm.getContext().getFinalizers().contains(enabler));
		myForm.finish();
		assertFalse(myForm.getContext().getFinalizers().contains(enabler));

		yield();
		assertEquals(2, myForm.getContext().getBindings().size());

		enabler.dispose();
		yield();
		assertEquals(1, myForm.getContext().getBindings().size());
	}

	/**
	 * Tests use of {@link IBindingEnabler} before {@link IBindingContext} when initial is
	 * <code>false</code>.
	 */
	@Test
	public void testBeforeFinishFalse() {
		myTestObject.setUnit(WeightUnit.KG);
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myTestObject);

		myBinding = myForm.addField("number(w=200)");
		final IBindingEnabler enabler = IBindingEnabler.Factory.add(myBinding, myForm.getObservableValue(),
				TestModelPackage.Literals.TEST_OBJECT__UNIT, WeightUnit.G);

		assertEquals(1, myForm.getContext().getBindings().size());
		myForm.finish();

		yield();
		assertEquals(2, myForm.getContext().getBindings().size());
		assertEquals(false, myBinding.getControl().isEnabled());

		myTestObject.setUnit(WeightUnit.G);
		yield();
		assertEquals(2, myForm.getContext().getBindings().size());
		assertEquals(true, myBinding.getControl().isEnabled());
	}

	/**
	 * Tests use of {@link IBindingEnabler} before {@link IBindingContext} when initial is
	 * <code>true</code>.
	 */
	@Test
	public void testBeforeFinishTrue() {
		myTestObject.setUnit(WeightUnit.KG);
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myTestObject);

		myBinding = myForm.addField("number(w=200)");
		final IBindingEnabler enabler = IBindingEnabler.Factory.add(myBinding, myForm.getObservableValue(),
				TestModelPackage.Literals.TEST_OBJECT__UNIT, WeightUnit.KG);

		myForm.finish();
		yield();
		assertEquals(true, myBinding.getControl().isEnabled());

		myTestObject.setUnit(WeightUnit.G);
		yield();
		assertEquals(false, myBinding.getControl().isEnabled());
	}

	/**
	 * Tests use of {@link IBindingEnabler} after {@link IBindingContext} when initial is
	 * <code>false</code>.
	 */
	@Test
	public void testAfterFinishFalse() {
		myTestObject.setUnit(WeightUnit.KG);
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myTestObject);

		myBinding = myForm.addField("number(w=200)");

		assertEquals(1, myForm.getContext().getBindings().size());
		myForm.finish();
		yield();

		final IBindingEnabler enabler = IBindingEnabler.Factory.add(myBinding, myForm.getObservableValue(),
				TestModelPackage.Literals.TEST_OBJECT__UNIT, WeightUnit.G);
		yield();

		assertEquals(2, myForm.getContext().getBindings().size());
		assertEquals(false, myBinding.getControl().isEnabled());

		myTestObject.setUnit(WeightUnit.G);
		yield();
		assertEquals(2, myForm.getContext().getBindings().size());
		assertEquals(true, myBinding.getControl().isEnabled());
	}

	/**
	 * Tests use of {@link IBindingEnabler} after {@link IBindingContext} when initial is
	 * <code>true</code>.
	 */
	@Test
	public void testAfterFinishTrue() {
		myTestObject.setUnit(WeightUnit.KG);
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myTestObject);

		myBinding = myForm.addField("number(w=200)");

		myForm.finish();
		yield();

		final IBindingEnabler enabler = IBindingEnabler.Factory.add(myBinding, myForm.getObservableValue(),
				TestModelPackage.Literals.TEST_OBJECT__UNIT, WeightUnit.KG);
		yield();

		assertEquals(true, myBinding.getControl().isEnabled());

		myTestObject.setUnit(WeightUnit.G);
		yield();
		assertEquals(false, myBinding.getControl().isEnabled());
	}

	/**
	 * Tests use of {@link IBindingEnabler} after {@link IBindingContext} when short form for
	 * add(...).
	 */
	@Test
	public void testAfterFinishShort() {
		myTestObject.setUnit(WeightUnit.KG);
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myTestObject);

		myBinding = myForm.addField("number(w=200)");

		myForm.finish();
		yield();

		final IBindingEnabler enabler = IBindingEnabler.Factory.add(myBinding, myForm.getObservableValue("unit"),
				WeightUnit.KG);
		yield();

		assertEquals(true, myBinding.getControl().isEnabled());

		myTestObject.setUnit(WeightUnit.G);
		yield();
		assertEquals(false, myBinding.getControl().isEnabled());
	}

	/**
	 * Tests use of {@link IBindingEnabler} after {@link IBindingContext} when using multiple
	 * positive values.
	 */
	@Test
	public void testAfterFinishShortTrue() {
		myTestObject.setUnit(WeightUnit.KG);
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myForm = myView.createFormCreator(myTestObject);

		myBinding = myForm.addField("number(w=200)");

		myForm.finish();
		yield();

		final IBindingEnabler enabler = IBindingEnabler.Factory.add(myBinding, myForm.getObservableValue("unit"),
				WeightUnit.KG, WeightUnit.TONNE);
		yield();

		assertEquals(true, myBinding.getControl().isEnabled());

		myTestObject.setUnit(WeightUnit.G);
		yield();
		assertEquals(false, myBinding.getControl().isEnabled());

		myTestObject.setUnit(WeightUnit.TONNE);
		yield();
		assertEquals(true, myBinding.getControl().isEnabled());
	}
}
