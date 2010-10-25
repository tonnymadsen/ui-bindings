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

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IModelFeatureInfo;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.validators.ConstraintValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapter;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * Tests {@link Constants#ARG_CONSTRAINTS_VALIDATE} and {@link ConstraintValidatorAdapter}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
@RunWith(Parameterized.class)
public class ConstraintValidationAdapterCollectionTest {

	private final Boolean myValidate;
	private final int myNoErrors;

	@Parameters
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] {

		{ null, 1 },

		{ false, 0 },

		{ true, 1 }

		});
	}

	public ConstraintValidationAdapterCollectionTest(Boolean validate, int noErrors) {
		myValidate = validate;
		myNoErrors = noErrors;

	}

	private static final int VD = 200;
	private IValidatorAdapterManager myManager;
	private Shop myShop;
	private IValidatorAdapter myValidationAdapter;

	@Before
	public void before() {
		resetAll();
		IManager.Factory.getManager().setValidationDelay(VD);

		myShop = ShopFactory.eINSTANCE.createShop();
		myShop.setName("xx");
		myShop.setNextOrderNo(1);

		myManager = IValidatorAdapterManager.Factory.getManager();
		myValidationAdapter = new ConstraintValidatorAdapter();
	}

	@Test
	public void testEnabled() {
		final IManager mng = IManager.Factory.getManager();
		final IModelFeatureInfo info = mng.getModelFeatureInfo(Shop.class.getName(),
				ShopPackage.Literals.SHOP__NEXT_ORDER_NO.getName(), null, true);
		try {
			if (myValidate != null) {
				info.getArguments().put(Constants.ARG_CONSTRAINTS_VALIDATE, myValidate);
			}
			/*
			 * Initial situation
			 */
			sleep(2 * VD);
			assertEquals(0, myManager.getUnboundMessages().size());
			assertEquals(0, myManager.getUnboundMessagesOL().size());

			myManager.addRoot(myShop, myValidationAdapter);

			sleep(2 * VD);
			// all ok
			assertEquals(0, myManager.getUnboundMessages().size());

			/*
			 * Setting the
			 */
			myShop.setNextOrderNo(-1);

			sleep(2 * VD);
			// nextOrderNo wrong
			assertEquals(myNoErrors, myManager.getUnboundMessages().size());
		} finally {
			info.getArguments().remove(Constants.ARG_CONSTRAINTS_VALIDATE);
		}
	}
}
