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
package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingContextFinalizer;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests of {@link IBindingContextFinalizer}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingContextFinalizerTest {
	private UIBTestView myView;
	private TestObject myTO;
	private IBindingContext myContext;

	@Before
	public void before() {
		myView = UIBindingsTestUtils.createUIBTestView(this);

		myTO = TestModelFactory.eINSTANCE.createTestObject();
	}

	@After
	public void after() {
		myView.getSite().getPage().hideView(myView);
	}

	/**
	 * Tests that the {@link IBindingContext#getFinalizers()} list is only created when needed.
	 */
	@Test
	public void testNone() {
		myContext = IBindingContext.Factory.createContext(myView.getBody());

		final Text text1 = new Text(myView.getBody(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text1.setText("");

		myContext.addBinding(text1, myTO, TestModelPackage.Literals.TEST_OBJECT__NUMBER);

		myContext.finish();
		assertFalse(myContext.eIsSet(IUIBindingsPackage.Literals.BINDING_CONTEXT__FINALIZERS));
	}

	/**
	 * Tests the use of the simple interface
	 */
	@Test
	public void testSimpleFalse() {
		testSimpleOne(false);
	}

	@Test
	public void testSimpleTrue() {
		testSimpleOne(true);
	}

	private void testSimpleOne(boolean remove) {
		myContext = IBindingContext.Factory.createContext(myView.getBody());

		final Finalizer fin = new Finalizer(remove);
		myContext.getFinalizers().add(fin);

		assertEquals(0, fin.called);

		final Text text1 = new Text(myView.getBody(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text1.setText("");

		myContext.addBinding(text1, myTO, TestModelPackage.Literals.TEST_OBJECT__NUMBER);
		assertEquals(0, fin.called);

		myContext.finish();
		assertEquals(1, fin.called);

		if (remove) {
			assertFalse(myContext.getFinalizers().contains(fin));
		} else {
			assertTrue(myContext.getFinalizers().contains(fin));
		}

		final Text text2 = new Text(myView.getBody(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text2.setText("");

		myContext.addBinding(text2, myTO, TestModelPackage.Literals.TEST_OBJECT__NUMBER);
		assertEquals(1, fin.called);

		myContext.finish();
		if (remove) {
			assertEquals(1, fin.called);
		} else {
			assertEquals(2, fin.called);
		}
	}

	/**
	 * Tests the use of {@link IFormCreator}.
	 */

	int formFinalizerCalled = 0;

	@Test
	public void testForm() {
		final IFormCreator form = myView.createFormCreator(myTO);
		myContext = form.getContext();

		form.addFinalizer(new Runnable() {
			@Override
			public void run() {
				formFinalizerCalled++;
			}
		});
		assertEquals(1, myContext.getFinalizers().size());
		assertEquals(0, formFinalizerCalled);

		form.addField("number(w=100)");
		assertEquals(0, formFinalizerCalled);

		myContext.finish();
		assertEquals(1, formFinalizerCalled);
		assertEquals(0, myContext.getFinalizers().size());

		form.addField("number(w=100)");
		assertEquals(1, formFinalizerCalled);

		myContext.finish();
		assertEquals(1, formFinalizerCalled);
		assertEquals(0, myContext.getFinalizers().size());
	}

	public class Finalizer implements IBindingContextFinalizer {
		int called = 0;
		private final boolean myRemoveAfterRun;

		public Finalizer(boolean removeAfterRun) {
			myRemoveAfterRun = removeAfterRun;
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run(IBindingContext context) {
			assertEquals(myContext, context);
			assertTrue(myContext.getFinalizers().contains(this));

			called++;

			if (myRemoveAfterRun) {
				context.getFinalizers().remove(this);
			}
		}
	}
}
