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
package com.rcpcompany.uibindings.internal.validators;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.extests.views.TestView;
import com.rcpcompany.uibindings.internal.bindingMessages.ValueBindingMessageImageDecorator;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.validators.EValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests that {@link DiagnosticChain} messages are correctly interpreted...
 * <p>
 * Depends on:
 * <ul>
 * <li>{@link ShopItem#nameOK(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)}</li>
 * <li>{@link ShopItem#namePriceOK(DiagnosticChain, java.util.Map)}</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DiagnosticChainTest {

	private static final int VD = 500;
	private Shop myShop;
	private TestView myView;
	private Composite myBody;
	private ShopItem myItem;
	private String myOldName;
	private IBindingContext myContext;
	private IValueBinding myBinding;
	private ValueBindingMessageImageDecorator myMessageDecorator;
	private ValidatorAdapterManager myValidatorManager;
	private final EValidatorAdapter myValidationAdapter = new EValidatorAdapter();

	/**
	 * 
	 */
	@Before
	public void setup() {
		IValidatorAdapterManager.Factory.getManager().reset();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(VD);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		myShop = ShopFactory.eINSTANCE.getShop(IManager.Factory.getManager().getEditingDomain());
		myItem = myShop.getShopItems().get(0);
		myOldName = myItem.getName();

		myView = createTestView(this);
		myBody = myView.getBody();

		final Text text = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myValidatorManager = (ValidatorAdapterManager) IValidatorAdapterManager.Factory.getManager();

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myBinding = myContext.addBinding(text, myItem, IMOAOPackage.Literals.NAMED_OBJECT__NAME);

		myContext.finish();
		yield();

		myMessageDecorator = myBinding.getService(ValueBindingMessageImageDecorator.class);

		myValidatorManager.addRoot(myShop, myValidationAdapter);
	}

	@After
	public void disposeView() {
		if (myView != null) {
			myView.getSite().getPage().hideView(myView);
		}
	}

	@After
	public void after() {
		myItem.setName(myOldName);
		myValidatorManager.removeRoot(myShop, myValidationAdapter);
	}

	@Test
	public void testValue() {
		assertNotNull(myValidatorManager);
		assertNotNull(myMessageDecorator);

		final int noUnboundMessages = myValidatorManager.getUnboundMessages().size();

		final List<IBindingMessage> messages = myMessageDecorator.getMessages();
		assertNotNull(messages);

		assertEquals(0, messages.size());

		myItem.setName("x");
		sleep(2 * VD);

		assertEquals(noUnboundMessages + 1, myValidatorManager.getUnboundMessages().size());
		// Still no messages assigned to the name as the feature of the diagnostic is missing
		assertEquals(0, messages.size());

		myItem.setName(myOldName);
		sleep(2 * VD);

		assertEquals(noUnboundMessages, myValidatorManager.getUnboundMessages().size());
		assertEquals(0, messages.size());
	}
}
