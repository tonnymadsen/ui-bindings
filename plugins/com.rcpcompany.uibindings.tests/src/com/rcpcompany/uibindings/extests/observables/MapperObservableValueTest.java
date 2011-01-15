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
package com.rcpcompany.uibindings.extests.observables;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.UIBindingsUtils.IClassIdentiferMapper;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.observables.MapperObservableValue;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Test of {@link MapperObservableValue}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class MapperObservableValueTest {
	private Shop myShop;
	private Contact myContact;
	private TestView myView;
	private IValueBinding myBinding;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

				// String fn, String result

				{ null, "contact.name" }, { "address", "contact.address" }, { "shop.name", "shop.name" },

		});
	}

	protected String myFN;
	protected Object myResult;

	public MapperObservableValueTest(String fn, String result) {
		myFN = fn;
		myResult = result;
	}

	@Before
	public void before() {
		resetAll();

		createModel();
		createView();
	}

	private void createView() {
		myView = createTestView(this);

		final Text text = new Text(myView.getBody(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setText("");

		final IBindingContext context = IBindingContext.Factory.createContext(myView.getScrolledForm());

		myBinding = context.addBinding().ui(text)
				.model(Observables.constantObservableValue(myContact, ShopPackage.Literals.CONTACT));
	}

	private void createModel() {
		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("shop.name");

		myContact = ShopFactory.eINSTANCE.createContact();
		myContact.setName("contact.name");
		myContact.setAddress("contact.address");
		myContact.setShop(myShop);
	}

	protected int changeCount = 0;

	@Test
	public void mapperTest() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myBinding.arg(Constants.ARG_FEATURE_NAME, myFN);
				final IClassIdentiferMapper mapper = UIBindingsUtils.createClassIdentiferMapper(myBinding,
						ShopPackage.Literals.CONTACT);
				assertNotNull(mapper);

				final WritableValue base = WritableValue.withValueType(ShopPackage.Literals.CONTACT);
				final MapperObservableValue ov = new MapperObservableValue(base, myBinding.getContext()
						.getEditingDomain(), mapper);

				// No base yet.
				assertEquals(null, ov.getValue());
				assertEquals(null, ov.getObserved());

				base.setValue(myContact);

				assertEquals(myResult, ov.getValue());
				assertEquals(myContact, ov.getObserved());

				final IValueChangeListener listener = new IValueChangeListener() {
					@Override
					public void handleValueChange(ValueChangeEvent event) {
						changeCount++;
					}
				};

				// Get value
				changeCount = 0;
				ov.addValueChangeListener(listener);

				myShop.setName("shop.name-2");
				myContact.setName("contact.name-2");
				myContact.setAddress("contact.address-2");

				ov.removeValueChangeListener(listener);

				assertEquals(1, changeCount);

				assertEquals(myResult + "-2", ov.getValue());

				// Set value
				changeCount = 0;
				ov.addValueChangeListener(listener);
				ov.setValue(myResult + "-3");
				ov.removeValueChangeListener(listener);

				assertEquals(1, changeCount);

				assertEquals(myContact, ov.getObserved());

				if (myResult.equals("shop.name")) {
					assertEquals(myResult + "-3", myShop.getName());
				} else if (myResult.equals("contact.name")) {
					assertEquals(myResult + "-3", myContact.getName());
				} else if (myResult.equals("contact.address")) {
					assertEquals(myResult + "-3", myContact.getAddress());
				} else {
					fail();
				}
			}
		});
	}
}
