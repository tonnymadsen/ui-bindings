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
	public void testPropertyTester() {
		final EStructuralFeaturePropertyTester tester = new EStructuralFeaturePropertyTester();

		assertOneLog(new Runnable() {
			@Override
			public void run() {
				assertFalse(tester.test(ShopPackage.ORDER, Constants.PROPERTY_HAS_DEFAULT_VALUE, null, new Object[0]));
			}
		});

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertFalse(tester.test(ShopPackage.ORDER__PRICE, Constants.PROPERTY_HAS_DEFAULT_VALUE, null,
						new Object[0]));
				assertTrue(tester.test(ShopPackage.ORDER__DISCOUNT, Constants.PROPERTY_HAS_DEFAULT_VALUE, null,
						new Object[0]));
			}
		});
	}
}
