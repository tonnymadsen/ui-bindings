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

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static com.rcpcompany.test.utils.UITestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.internal.decorators.EnumBindingDecorator;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.CustomerType;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Test for {@link IEnumDecoratorProvider}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EnumDecoratorProviderTest {
	private Shop myShop;
	private UIBTestView myView;
	private Composite myBody;

	private IBindingContext myContext;
	private ValueBindingMessageImageDecorator myMessageDecorator;
	private Customer myCustomer;
	private CustomerType myOldLoyalty;

	private Text myBasicText;
	private IValueBinding myBasicBinding;

	private Text mySubWithoutText;
	private IValueBinding mySubWithoutBinding;

	private Text mySubWithText;
	private IValueBinding mySubWithBinding;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(500);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		myShop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());
		myCustomer = myShop.getCustomers().get(0);
		myOldLoyalty = myCustomer.getLoyalty();

		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		myBasicText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		myBasicText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		mySubWithoutText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		mySubWithoutText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		mySubWithText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		mySubWithText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myBasicBinding = myContext.addBinding(myBasicText, myCustomer, ShopPackage.Literals.CUSTOMER__LOYALTY);
		mySubWithoutBinding = myContext
				.addBinding(mySubWithoutText, myCustomer, ShopPackage.Literals.CUSTOMER__LOYALTY).type("sub");
		mySubWithBinding = myContext.addBinding(mySubWithText, myCustomer, ShopPackage.Literals.CUSTOMER__LOYALTY)
				.type("subwith");

		myContext.finish();
		yield();

		myMessageDecorator = myBasicBinding.getService(ValueBindingMessageImageDecorator.class);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@After
	public void after() {
		myCustomer.setLoyalty(myOldLoyalty);
	}

	@Test
	public void testDecoratorType() {
		final IUIBindingDecorator decorator = myBasicBinding.getDecorator();
		assertTrue(decorator instanceof EnumBindingDecorator);
	}

	@Test
	public void testBasicValues() {
		testUIValidList(myBasicBinding, "Bronce", "Silver", "Gold");
		testM2UI(CustomerType.BRONCE, myBasicText, "Bronce");
		testM2UI(CustomerType.SILVER, myBasicText, "Silver");
		testM2UI(CustomerType.GOLD, myBasicText, "Gold");

		testUI2M(myBasicText, "Bronce", CustomerType.BRONCE, myBasicBinding);
		testUI2M(myBasicText, "Silver", CustomerType.SILVER, myBasicBinding);
		testUI2M(myBasicText, "Gold", CustomerType.GOLD, myBasicBinding);
		testUI2MError(myBasicText, "xxx", myBasicBinding);
	}

	@Test
	public void testSubWithoutDefaultsValues() {
		testUIValidList(mySubWithoutBinding, "Level 1", "Level 2");
		testM2UI(CustomerType.BRONCE, mySubWithoutText, "Level 1");
		testM2UI(CustomerType.SILVER, mySubWithoutText, "Level 2");

		// Value does not change
		testM2UI(CustomerType.GOLD, mySubWithoutText, "Level 2");

		testUI2M(mySubWithoutText, "Level 1", CustomerType.BRONCE, mySubWithoutBinding);
		testUI2M(mySubWithoutText, "Level 2", CustomerType.SILVER, mySubWithoutBinding);

		testUI2MError(mySubWithoutText, "Gold", mySubWithoutBinding);
		testUI2MError(mySubWithoutText, "xxx", mySubWithoutBinding);
	}

	@Test
	public void testSubWithDefaultsValues() {
		testUIValidList(mySubWithBinding, "Level 1", "Level 2", "Level 2b", "Bronce", "Silver", "Gold");
		testM2UI(CustomerType.BRONCE, mySubWithText, "Level 1");
		testM2UI(CustomerType.SILVER, mySubWithText, "Level 2");

		testM2UI(CustomerType.GOLD, mySubWithText, "Gold");

		testUI2M(mySubWithText, "Level 1", CustomerType.BRONCE, mySubWithBinding);
		testUI2M(mySubWithText, "Bronce", CustomerType.BRONCE, mySubWithBinding);
		testUI2M(mySubWithText, "Level 2", CustomerType.SILVER, mySubWithBinding);
		testUI2M(mySubWithText, "Level 2b", CustomerType.SILVER, mySubWithBinding);
		testUI2M(mySubWithText, "Silver", CustomerType.SILVER, mySubWithBinding);
		testUI2M(mySubWithText, "Gold", CustomerType.GOLD, mySubWithBinding);

		testUI2MError(mySubWithText, "xxx", mySubWithBinding);
	}

	private void testM2UI(final CustomerType type, final Text text, final String string) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				myCustomer.setLoyalty(type);
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				yield();
			}
		});
		assertEquals(string, text.getText());
	}

	private void testUI2M(final Text text, final String string, final CustomerType type, final IValueBinding binding) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				text.setText(string);
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				yield();
			}
		});
		assertEquals(type, myCustomer.getLoyalty());
		final ValueBindingMessageImageDecorator decorator = binding.getService(ValueBindingMessageImageDecorator.class);
		assertEquals(0, decorator.getMessages().size());
	}

	private void testUI2MError(final Text text, final String string, final IValueBinding binding) {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				text.setText(string);
			}
		});
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				yield();
			}
		});
		final ValueBindingMessageImageDecorator decorator = binding.getService(ValueBindingMessageImageDecorator.class);
		assertEquals(1, decorator.getMessages().size());
	}

	/**
	 * Tests that the values in the validUIList are exactly as specified.
	 * 
	 * @param binding the binding
	 * @param values the exact values
	 */
	private void testUIValidList(IValueBinding binding, String... values) {
		final IObservableList list = binding.getDecorator().getValidUIList();
		assertEquals(values.length, list.size());
		for (int i = 0; i < values.length; i++) {
			assertEquals("index[" + i + "]", values[i], list.get(i));
		}
	}
}
