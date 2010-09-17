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

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests that setting a value adds a new item to the command stack.
 * <p>
 * Parameterized by whether to create a private editing domain or not
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ContextEditingDomainCommitTest {
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ false }, { true },

		});
	}

	private Country myCountry;
	private Contact myContact1;

	private TestView myView;

	private final boolean myPrivateEditingDomain;

	private CommandStack myCommandStack;
	private IValueBinding myBinding;

	public ContextEditingDomainCommitTest(boolean privateEditingDomain) {
		myPrivateEditingDomain = privateEditingDomain;
	}

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);

		createShop();
		createView();

		myCommandStack = IManager.Factory.getManager().getEditingDomain().getCommandStack();
		myCommandStack.flush();

		myView.getSite().getPage().activate(myView);
	}

	/**
	 * Creates the shop itself
	 */
	public void createShop() {
		myCountry = ShopFactory.eINSTANCE.createCountry();
		myCountry.setName("1");

		myContact1 = ShopFactory.eINSTANCE.createContact();
		myContact1.setName("NN 1");
		myContact1.setCountry(myCountry);
	}

	/**
	 * Creates the view
	 */
	public void createView() {
		myView = createTestView(this);

		final IFormCreator form = myView.createFormCreator(myContact1);
		if (myPrivateEditingDomain) {
			form.getContext().setEditingDomain(UIBindingsUtils.createEditingDomain());
		}
		myBinding = form.addField("name").arg(Constants.ARG_PREFERRED_CONTROL, Text.class.getName());
		form.finish();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@Test
	public void testChange() {
		assertEquals(null, myCommandStack.getMostRecentCommand());
		final Text t = (Text) myBinding.getControl();
		t.setText("xxx");

		assertEquals("xxx", myContact1.getName());
		if (myPrivateEditingDomain) {
			assertEquals(null, myCommandStack.getMostRecentCommand());
		} else {
			assertNotNull(myCommandStack.getMostRecentCommand());
		}
	}
}
