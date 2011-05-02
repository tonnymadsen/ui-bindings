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
package com.rcpcompany.uibindings.extests.propertyTesters;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.internal.propertyTesters.EStructuralFeaturePropertyTester;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests {@link EStructuralFeaturePropertyTester}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EStructuralFeaturePropertyTesterTests {
	@Test
	public void testPropertyTesterHasDefaultValue() {
		final EStructuralFeaturePropertyTester tester = new EStructuralFeaturePropertyTester();

		assertOneLog(new Runnable() {
			@Override
			public void run() {
				assertFalse(tester.test(ShopPackage.Literals.ORDER, Constants.PROPERTY_HAS_DEFAULT_VALUE,
						new Object[0], null));
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertFalse(tester.test(ShopPackage.Literals.ORDER__PRICE, Constants.PROPERTY_HAS_DEFAULT_VALUE,
						new Object[0], null));
				assertTrue(tester.test(ShopPackage.Literals.ORDER__DISCOUNT, Constants.PROPERTY_HAS_DEFAULT_VALUE,
						new Object[0], null));
			}
		});
	}

	@Test
	public void testPropertyTesterHasType() {
		final EStructuralFeaturePropertyTester tester = new EStructuralFeaturePropertyTester();

		assertOneLog(new Runnable() {
			@Override
			public void run() {
				assertFalse(tester.test(ShopPackage.Literals.ORDER, Constants.PROPERTY_HAS_TYPE, new Object[0], null));
			}
		});

		assertOneLog(new Runnable() {
			@Override
			public void run() {
				/*
				 * Missing arguments
				 */
				assertFalse(tester.test(ShopPackage.Literals.ORDER_ITEM__ID, Constants.PROPERTY_HAS_TYPE,
						new Object[0], null));
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertFalse(tester.test(ShopPackage.Literals.ORDER__PRICE, Constants.PROPERTY_HAS_TYPE,
						new Object[] { "int" }, null));
				assertTrue(tester.test(ShopPackage.Literals.ORDER__PRICE, Constants.PROPERTY_HAS_TYPE,
						new Object[] { "float" }, null));
				assertFalse(tester.test(ShopPackage.Literals.CUSTOMER__LOYALTY, Constants.PROPERTY_HAS_TYPE,
						new Object[] { "float" }, null));
				assertTrue(tester.test(ShopPackage.Literals.CUSTOMER__LOYALTY, Constants.PROPERTY_HAS_TYPE,
						new Object[] { "float", "java.lang.Enum" }, null));
			}
		});
	}
}
