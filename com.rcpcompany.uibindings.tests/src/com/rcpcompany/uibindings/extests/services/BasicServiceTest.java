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
package com.rcpcompany.uibindings.extests.services;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IServiceRegistry;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Tests the basic {@link IServiceRegistry} functionality
 * 
 * TODO TEST disposeServices()
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BasicServiceTest {

	private UIBTestView myTestView;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		myTestView = UIBindingsTestUtils.createUIBTestView(this);
	}

	@After
	public void disposeView() {
		if (myTestView != null) {
			myTestView.getSite().getPage().hideView(myTestView);
		}
	}

	@Test
	public void testContextValue() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final Composite body = myTestView.getBody();

				final IBindingContext context = IBindingContext.Factory.createContext(body);

				testServiceInterface(context);
			}
		});
	}

	@Test
	public void testManager() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				testServiceInterface(IManager.Factory.getManager());
			}
		});
	}

	@Test
	public void testBaseBindingValue() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final Composite body = myTestView.getBody();

				final Text text = new Text(body, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
				text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
				text.setText("");

				final IBindingContext context = IBindingContext.Factory.createContext(body);
				final IValueBinding binding = context.addBinding(text,
						ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain()),
						IMOAOPackage.Literals.NAMED_OBJECT__NAME);

				testServiceInterface(binding);
			}
		});
	}

	private void testServiceInterface(final IServiceRegistry register) {
		final A a = new A();
		final B b = new B();

		register.registerService(a);
		register.registerService(b);

		assertEquals(a, register.getService(A.class));
		assertEquals(a, register.getService(I.class));
		assertEquals(b, register.getService(B.class));

		register.unregisterService(a);

		assertEquals(null, register.getService(A.class));
		assertEquals(null, register.getService(I.class));
	}

	private interface I {

	}

	private class A implements I {

	}

	private class B {

	}
}
