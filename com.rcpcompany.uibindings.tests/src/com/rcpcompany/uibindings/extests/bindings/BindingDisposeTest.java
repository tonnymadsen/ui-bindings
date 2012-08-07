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

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.UIBindingsTestUtils;
import com.rcpcompany.uibindings.extests.views.UIBTestView;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.observables.DisposePendingWritableValue;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.uiAttributes.SimpleUIAttribute;

/**
 * Tests that {@link IBinding#dispose()} works correctly.
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingDisposeTest {

	private Shop myShop;
	private UIBTestView myView;

	@Before
	public void setup() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("NWS");
	}

	private void createView() {
		myView = UIBindingsTestUtils.createUIBTestView(this);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testBindingDispose() {
		final int noInitAdapters = myShop.eAdapters().size();

		final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

		final WritableValue ov = new WritableValue("", String.class);
		final IUIAttribute attribute = new SimpleUIAttribute(null, null, ov, true);
		final IValueBinding binding = context.addBinding().model(myShop, IMOAOPackage.Literals.NAMED_OBJECT__NAME)
				.ui(attribute);
		context.finish();
		yield();

		ov.setValue("New");

		binding.dispose();

		assertEquals(0, context.getBindings().size());
		assertEquals("New", myShop.getName());
		assertTrue(ov.isDisposed());
		assertAdapters(noInitAdapters, myShop);
	}

	@Test
	public void testCurrentValueDispose() {
		final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

		final WritableValue ov = new WritableValue("", String.class);
		final IUIAttribute attribute = new SimpleUIAttribute(null, null, ov, true);

		final DisposePendingWritableValue value = DisposePendingWritableValue
				.withValueType(EcorePackage.Literals.ESTRING);

		final IValueBinding binding = context.addBinding().model(value).ui(attribute);
		context.finish();
		yield();

		ov.setValue("New");

		assertNoLog(new Runnable() {
			public void run() {
				value.fireDisposePending();
				value.dispose();
			}
		});

		assertEquals(0, context.getBindings().size());
		assertTrue(ov.isDisposed());
	}
}
