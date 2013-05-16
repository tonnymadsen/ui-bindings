/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.extests.bindings;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;

/**
 * Tests that bindings are disposed, when the control is...
 * <p>
 * Depends on:
 * <ul>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingControlDisposeTest {

	private Shop myShop;
	private UIBTestView myView;
	private ScrolledForm myScrolledForm;
	private Text myText;
	private IObservableValue myBoolOV;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();
		createView();
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("NWS");
		myBoolOV = WritableValue.withValueType(EcorePackage.Literals.EBOOLEAN);
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);

		myScrolledForm = myView.getScrolledForm();

		myText = new Text(myScrolledForm.getBody(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		myText.setText("");
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	/**
	 * Tests the bindings are properly disposed - both the primary binding and any additional
	 * bindings
	 */
	@Test
	public void testControlDispose() {
		final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

		final IValueBinding binding1 = context.addBinding(myText, myShop, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
		final IValueBinding binding2 = context.addBinding().ui(myText, Constants.ATTR_ENABLED).model(myBoolOV);
		context.finish();
		yield();

		assertEquals(BindingState.OK, binding1.getState());
		assertEquals(BindingState.OK, binding2.getState());

		myText.dispose();
		yield();

		assertEquals(BindingState.DISPOSED, binding1.getState());
		assertEquals(BindingState.DISPOSED, binding2.getState());
	}
}
