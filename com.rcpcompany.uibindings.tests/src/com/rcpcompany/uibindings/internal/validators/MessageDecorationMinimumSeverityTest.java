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
package com.rcpcompany.uibindings.internal.validators;

import static com.rcpcompany.test.utils.ui.UITestUtils.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.validators.EValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests function of {@link IManager#getMessageDecorationMinimumSeverity()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class MessageDecorationMinimumSeverityTest {

	private final BindingMessageSeverity myMinSeverity;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ BindingMessageSeverity.INFORMATION },

		{ BindingMessageSeverity.WARNING },

		{ BindingMessageSeverity.ERROR },

		});
	}

	public MessageDecorationMinimumSeverityTest(BindingMessageSeverity severity) {
		myMinSeverity = severity;
	}

	private UIBTestView myView;
	private IFormCreator myForm;

	private Country myCountry;
	private IValueBinding myAbbrev;
	private Text myAbbreText;

	private IValidatorAdapterManager myManager;
	private static final int VD = 200;
	private IValidatorAdapter myValidationAdapter;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setMessageDecorationMinimumSeverity(myMinSeverity);
		IManager.Factory.getManager().setValidationDelay(VD);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		createModel();

		myManager = IValidatorAdapterManager.Factory.getManager();
		myValidationAdapter = new EValidatorAdapter();
		myManager.addRoot(myCountry, myValidationAdapter);

		createView();
	}

	private void createModel() {
		myCountry = ShopFactory.eINSTANCE.createCountry();
		myCountry.setAbbreviation("DK");
	}

	private void createView() {
		myView = BaseUIBTestUtils.createUIBTestView(this);
		myForm = myView.createFormCreator(myCountry);

		myAbbrev = myForm.addField("abbreviation");

		myForm.finish();

		myAbbreText = (Text) myAbbrev.getControl();
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@After
	public void after() {
		myManager.removeRoot(myCountry, myValidationAdapter);
	}

	@Test
	public void testValue() {
		sleep(2 * VD);
		assertNotNull(myAbbrev);
		assertNotNull(myAbbreText);

		final ValueBindingMessageImageDecorator decorator = myAbbrev
				.getService(ValueBindingMessageImageDecorator.class);
		assertNotNull(decorator);
		final List<IBindingMessage> messages = decorator.getMessages();
		assertNotNull(messages);

		myAbbrev.setFocus();

		assertEquals(0, messages.size());

		myAbbreText.setText("n");
		sleep(2 * VD);

		assertEquals(1, messages.size());

		myAbbreText.setText("no");
		sleep(2 * VD);

		assertEquals(myMinSeverity == BindingMessageSeverity.ERROR ? 0 : 1, messages.size());

		myAbbreText.setText("n");
		sleep(2 * VD);

		assertEquals(1, messages.size());

		myAbbreText.setText("NO");
		sleep(2 * VD);

		assertEquals(0, messages.size());
	}
}
