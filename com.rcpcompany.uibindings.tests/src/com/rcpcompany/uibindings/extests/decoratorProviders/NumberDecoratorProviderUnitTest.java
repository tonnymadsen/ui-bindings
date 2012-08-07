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

import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.units.AbstractUnitBindingSupport;
import com.rcpcompany.uibindings.units.IUnitBindingSupportContext;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests of {@link IUnitBindingSupport} for {@link NumberBindingDecorator}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NumberDecoratorProviderUnitTest {
	private UIBTestView myView;
	private IFormCreator myForm;

	private IValueBinding myFBinding;
	private IValueBinding myDBinding;

	private TestObject myTestObject;

	private UnitSupport myFUnitSupport;
	private UnitSupport myDUnitSupport;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setEditCellSingleClick(false);
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);

		myTestObject = TestModelFactory.eINSTANCE.createTestObject();

		myView = UIBindingsTestUtils.createUIBTestView(this);
		myForm = myView.createFormCreator(myTestObject);

		myFBinding = myForm.addField("f").arg(Constants.ARG_TOOL_TIP_TEXT, "ff");
		myFUnitSupport = new UnitSupport(myFBinding);
		myFUnitSupport.setFactor(1.0);
		myFBinding.arg(Constants.ARG_UNIT_SUPPORT, myFUnitSupport);

		myDBinding = myForm.addField("d").arg(Constants.ARG_TOOL_TIP_TEXT, "dd");
		myDUnitSupport = new UnitSupport(myDBinding);
		myDUnitSupport.setFactor(1.0);
		myDBinding.arg(Constants.ARG_UNIT_SUPPORT, myDUnitSupport);

		myForm.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests that units are properly shown for float number fields
	 */
	@Test
	public void testFloatBinding() {
		yield();

		final Text t = (Text) myFBinding.getControl();
		assertNotNull(t);

		// Initial value
		myTestObject.setF(10.0f);
		yield();
		assertEquals("10.00", t.getText());
		assertEquals("ff [Unit1.0]", t.getToolTipText());

		// Model to UI (factor 1.0)
		myTestObject.setF(20.0f);
		yield();
		assertEquals("20.00", t.getText());
		assertEquals("ff [Unit1.0]", t.getToolTipText());

		// UI to Model (factor 1.0)
		t.setText("50");
		yield();
		assertEquals(50.0, myTestObject.getF(), 0.1);
		assertEquals("ff [Unit1.0]", t.getToolTipText());

		// Change is factor
		myFUnitSupport.setFactor(2.0);
		yield();
		assertEquals("100.00", t.getText());
		assertEquals("ff [Unit2.0]", t.getToolTipText());

		// Model to UI (factor 2.0)
		myTestObject.setF(15.0f);
		yield();
		assertEquals("30.00", t.getText());
		assertEquals("ff [Unit2.0]", t.getToolTipText());

		// UI to Model (factor 2.0)
		t.setText("40");
		yield();
		assertEquals(20.0, myTestObject.getF(), 0.1);
		assertEquals("ff [Unit2.0]", t.getToolTipText());
	}

	/**
	 * Tests that units are properly shown for double number fields
	 */
	@Test
	public void testDoubleBinding() {
		yield();

		final Text t = (Text) myDBinding.getControl();
		assertNotNull(t);

		// Initial value
		myTestObject.setD(10.0);
		yield();
		assertEquals("10.00", t.getText());
		assertEquals("dd [Unit1.0]", t.getToolTipText());

		// Model to UI (factor 1.0)
		myTestObject.setD(20.0);
		yield();
		assertEquals("20.00", t.getText());
		assertEquals("dd [Unit1.0]", t.getToolTipText());

		// Change the factor
		myDUnitSupport.setFactor(0.001);
		yield();
		assertEquals("0.02", t.getText());
		assertEquals("dd [Unit0.0010]", t.getToolTipText());

		// UI to Model (factor 0.001)
		t.setText("4.0");
		yield();
		assertEquals(4000.0, myTestObject.getD(), 0.01);
		assertEquals("dd [Unit0.0010]", t.getToolTipText());

		// UI to Model (factor 0.001)
		t.setText("5");
		yield();
		assertEquals(5000.0, myTestObject.getD(), 0.01);
		assertEquals("dd [Unit0.0010]", t.getToolTipText());
	}

	/**
	 * Tests that units are properly shown for double number fields
	 */
	@Test
	public void testDoubleBinding2() {
		yield();

		final Text t = (Text) myDBinding.getControl();
		assertNotNull(t);

		// Initial value
		myTestObject.setD(10.0);
		yield();
		assertEquals("10.00", t.getText());
		assertEquals("dd [Unit1.0]", t.getToolTipText());

		// Model to UI (factor 1.0)
		myTestObject.setD(20.0);
		yield();
		assertEquals("20.00", t.getText());
		assertEquals("dd [Unit1.0]", t.getToolTipText());

		// UI to Model (factor 1.0)
		t.setText("50");
		yield();
		assertEquals(50.0, myTestObject.getD(), 0.1);
		assertEquals("dd [Unit1.0]", t.getToolTipText());

		// Change the factor
		myDUnitSupport.setFactor(2.0);
		yield();
		assertEquals("100.00", t.getText());
		assertEquals("dd [Unit2.0]", t.getToolTipText());

		// Model to UI (factor 2.0)
		myTestObject.setD(15.0);
		yield();
		assertEquals("30.00", t.getText());
		assertEquals("dd [Unit2.0]", t.getToolTipText());

		// UI to Model (factor 2.0)
		t.setText("40");
		yield();
		assertEquals(20.0, myTestObject.getD(), 0.1);
		assertEquals("dd [Unit2.0]", t.getToolTipText());

		// Change the factor
		myDUnitSupport.setFactor(0.001);
		yield();
		assertEquals("0.02", t.getText());
		assertEquals("dd [Unit0.0010]", t.getToolTipText());

		// Model to UI (factor 0.001)
		myTestObject.setD(3000.0);
		yield();
		assertEquals("3.00", t.getText());
		assertEquals("dd [Unit0.0010]", t.getToolTipText());

		// UI to Model (factor 0.001)
		t.setText("4.0");
		yield();
		assertEquals(4000.0, myTestObject.getD(), 0.01);
		assertEquals("dd [Unit0.0010]", t.getToolTipText());

		// UI to Model (factor 0.001)
		t.setText("5");
		yield();
		assertEquals(5000.0, myTestObject.getD(), 0.01);
		assertEquals("dd [Unit0.0010]", t.getToolTipText());
	}

	public class UnitSupport extends AbstractUnitBindingSupport {
		private final IBinding myBinding;

		public UnitSupport(IBinding binding) {
			myBinding = binding;

		}

		private double myFactor = 1.0;

		@Override
		public double getFactor(IUnitBindingSupportContext context) {
			final IValueBinding binding = context.getBinding();
			assertEquals(myBinding, binding);

			return myFactor;
		}

		@Override
		public String getUnitDescription(IUnitBindingSupportContext context) {
			return "Unit" + myFactor;
		}

		/**
		 * @param factor the factor to set
		 */
		public void setFactor(double factor) {
			myFactor = factor;

			fireUnitsChanged();
		}

		/**
		 * @return the factor
		 */
		public double getFactor() {
			return myFactor;
		}
	}
}
