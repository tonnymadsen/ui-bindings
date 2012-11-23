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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;
import com.rcpcompany.uibindings.tests.utils.views.UIBTestView;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests that messages are added to the context header at the right time..
 * <p>
 * Depends on:
 * <ul>
 * <li>{@link ShopItem#priceOK(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)}</li>
 * <li>{@link ShopItem#nameOK(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)}</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ContextAdapterCollectionTest {

	private static final int VD = 500;
	private Shop myShop;
	private UIBTestView myView;
	private Composite myBody;
	private ShopItem myItem;
	private String myOldName;
	private float myOldPrice;
	private IBindingContext myContext;
	private ValidatorAdapterManager myValidatorManager;

	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
		IManager.Factory.getManager().setTextCommitStrategy(TextCommitStrategy.ON_MODIFY);
		IManager.Factory.getManager().setValidationDelay(VD);
		IManager.Factory.getManager().setEditCellSingleClick(false);

		myShop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());
		myItem = myShop.getShopItems().get(0);
		myOldName = myItem.getName();
		myOldPrice = myItem.getPrice();

		myView = BaseUIBTestUtils.createUIBTestView(this);
		myBody = myView.getBody();

		final Text nameText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Text priceText = new Text(myBody, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		priceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		myValidatorManager = (ValidatorAdapterManager) IValidatorAdapterManager.Factory.getManager();

		myContext = IBindingContext.Factory.createContext(myView.getScrolledForm());
		myContext.addBinding(nameText, myItem, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
		myContext.addBinding(priceText, myItem, ShopPackage.Literals.SHOP_ITEM__PRICE);

		myContext.finish();
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
		myItem.setPrice(myOldPrice);
		myValidatorManager.removeRoot(myShop);
	}

	@Test
	public void testValue() {
		assertNotNull(myValidatorManager);

		final int initNoMessageFactories = myValidatorManager.getUnboundMessages().size();
		final int initValidationAdapters = myValidatorManager.myValidationRoots.size();

		final int shopAdapterCount = myShop.eAdapters().size();
		final int itemAdapterCount = myItem.eAdapters().size();
		myValidatorManager.addRoot(myShop, new ConstraintValidatorAdapter());
		assertTrue(shopAdapterCount < myShop.eAdapters().size());
		assertTrue(itemAdapterCount < myItem.eAdapters().size());
		assertEquals(initValidationAdapters + 1, myValidatorManager.myValidationRoots.size());

		final int noMessageFactories = myValidatorManager.getUnboundMessages().size();
		assertTrue(noMessageFactories >= initNoMessageFactories);

		myItem.setPrice(-1.0f);
		assertEquals(noMessageFactories, myValidatorManager.getUnboundMessages().size());

		// Test before the validation delay
		sleep(VD - 100);
		assertEquals(noMessageFactories, myValidatorManager.getUnboundMessages().size());

		// Test after the validation delay
		sleep(300);
		assertEquals(noMessageFactories + 1, myValidatorManager.getUnboundMessages().size());

		myItem.setPrice(myOldPrice);
		assertEquals(noMessageFactories + 1, myValidatorManager.getUnboundMessages().size());

		// Test before the validation delay
		sleep(VD - 100);
		assertEquals(noMessageFactories + 1, myValidatorManager.getUnboundMessages().size());

		// Test after the validation delay
		sleep(300);
		assertEquals(noMessageFactories, myValidatorManager.getUnboundMessages().size());

		myValidatorManager.removeRoot(myShop);
		assertEquals(shopAdapterCount, myShop.eAdapters().size());
		assertEquals(itemAdapterCount, myItem.eAdapters().size());
		assertEquals(initNoMessageFactories, myValidatorManager.getUnboundMessages().size());
		assertEquals(initValidationAdapters, myValidatorManager.myValidationRoots.size());
	}
}
