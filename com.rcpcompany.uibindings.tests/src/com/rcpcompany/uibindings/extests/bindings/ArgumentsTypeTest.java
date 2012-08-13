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

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibinding.tests.model.TestContainer;
import com.rcpcompany.uibinding.tests.model.TestModelFactory;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IControlFactory;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.controlFactories.CheckBoxControlFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;

/**
 * This test is about the different data types for arguments.
 * <p>
 * Please notice that there are a lot of annotations for "foobar-dt-<datatype>" both in the test EMF
 * model and in the uibindings extension point of this fragment.
 * <p>
 * Depends on a number of <code>argumentInfo</code> declarations
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ArgumentsTypeTest {
	private UIBTestView myView;
	private Composite myBody;
	private IBindingContext myContext;

	public static final String ARG = "foobar-dt-";
	private TestContainer myModel;
	private TestObject myObject;

	private Text myAttributeText;
	private IValueBinding myAttributeBinding;

	private Text myReferenceText;
	private IValueBinding myReferenceBinding;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myReferenceText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myReferenceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myAttributeText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myAttributeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myModel = TestModelFactory.eINSTANCE.getTestContainer();
		myObject = myModel.getChildren().get(1);

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myReferenceBinding = myContext.addBinding(myReferenceText, myModel,
				TestModelPackage.Literals.TEST_CONTAINER__CURRENT).validValues(myModel,
				TestModelPackage.Literals.TEST_CONTAINER__CHILDREN);
		myAttributeBinding = myContext.addBinding(myAttributeText, myObject,
				TestModelPackage.Literals.TEST_OBJECT__TEXT);

		myContext.finish();
		yield();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Test boolean arguments.
	 */
	@Test
	public void testIBindingBoolean() {
		checkDataTypeEmpty(Boolean.class, "-empty");
		checkDataTypeOK(Boolean.class, "-t", true);
		checkDataTypeOK(Boolean.class, "-f", false);
		checkDataTypeOK(Boolean.class, "-f2", false);
	}

	/**
	 * Test integer arguments.
	 */
	@Test
	public void testIBindingInteger() {
		checkDataTypeEmpty(Integer.class, "-empty");
		checkDataTypeOK(Integer.class, "-1", 1);
		checkDataTypeOK(Integer.class, "--1", -1);
		checkDataTypeOneLog(Integer.class, "-fail1");
	}

	/**
	 * Test {@link IObservableListFactory}
	 */
	@Test
	public void testIBindingIOL() {
		checkDataTypeEmpty(IObservableList.class, "-empty");
		final IObservableList ev = new WritableList(myModel.getChildren(), EObject.class);
		checkDataTypeOK(IObservableList.class, "-1", ev);

		checkDataTypeOneLog(IObservableList.class, "-fail1");
	}

	/**
	 * Test {@link IControlFactory}
	 */
	@Test
	public void testIBindingControlFactory() {
		checkDataTypeEmpty(IControlFactory.class, "-empty");

		final IBindingContext cxt = IBindingContext.Factory.createContext(myBody);
		final IValueBinding b = cxt.addBinding().model(myObject, TestModelPackage.Literals.TEST_OBJECT__B);
		final IControlFactory f = b.getArgument(Constants.ARG_PREFERRED_CONTROL_FACTORY, IControlFactory.class, null);

		assertNotNull(f);
		assertTrue(f instanceof CheckBoxControlFactory);
	}

	/**
	 * Test ImageDescriptor
	 */
	@Test
	public void testIBindingID() {
		checkDataTypeEmpty(ImageDescriptor.class, "-empty");
		final ImageDescriptor ev = AbstractUIPlugin.imageDescriptorFromPlugin("com.rcpcompany.uibindings",
				"images/quickfixes/add_correction.gif");
		checkDataTypeOK(ImageDescriptor.class, "-1", ev);

		checkDataTypeOneLog(ImageDescriptor.class, "-fail1");
	}

	private <T> void checkDataTypeEmpty(final Class<T> cls, String subName) {
		final String name = ARG + cls.getSimpleName() + subName;
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final T val = myAttributeBinding.getArgument(name, cls, null);
				assertEquals(null, val);
			}
		});
	}

	private <T> void checkDataTypeOK(final Class<T> cls, String subName, final T expectedValue) {
		final String name = ARG + cls.getSimpleName() + subName;
		final String what = "name: '" + name + "'";
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IValueBinding vb = cls == IObservableList.class ? myReferenceBinding : myAttributeBinding;
				final T val = vb.getArgument(name, cls, null);

				assertNotNull(what, val);
				assertTrue(what, cls.isInstance(val));
				assertEquals(what, expectedValue, val);

				/*
				 * Repeat the request - should be the same object
				 */
				final T repeat = vb.getArgument(name, cls, null);

				assertTrue(what, repeat == val);
			}
		});
	}

	private <T> void checkDataTypeOneLog(final Class<T> cls, final String subName) {
		assertOneLog(new Runnable() {
			@Override
			public void run() {
				/*
				 * Not really interested in the result...
				 */
				final T val = (cls == IObservableList.class ? myReferenceBinding : myAttributeBinding).getArgument(ARG
						+ cls.getSimpleName() + subName, cls, null);
			}
		});
	}
}
