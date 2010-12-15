package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFeatureListMonitor;

/**
 * Test of {@link IFeatureListMonitor}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FeatureListMonitorTests {
	private final Runnable myRunnable = new Runnable() {

		@Override
		public void run() {
			myRunnableCount++;
		}
	};

	public int myRunnableCount = 0;

	@Test
	public void testMonitor() {
		final Shop shop = ShopFactory.eINSTANCE.createShop();

		final Country c1 = ShopFactory.eINSTANCE.createCountry();
		c1.setName("a");

		c1.setShop(shop);
		assertEquals(0, c1.eAdapters().size());

		assertEquals(0, myRunnableCount);
		final IFeatureListMonitor monitor = IFeatureListMonitor.Factory.monitor(shop,
				ShopPackage.Literals.SHOP__COUNTRIES, IMOAOPackage.Literals.NAMED_OBJECT__NAME, myRunnable);

		assertNotNull(monitor);
		assertEquals(0, myRunnableCount);

		final Country c2 = ShopFactory.eINSTANCE.createCountry();
		c2.setName("b");

		c2.setShop(shop);
		assertEquals(1, myRunnableCount);

		c1.setName("d");
		assertEquals(2, myRunnableCount);

		c1.setShop(null);
		assertEquals(3, myRunnableCount);
		assertEquals(0, c1.eAdapters().size());

		c1.setName("e");
		assertEquals(3, myRunnableCount);

		monitor.dispose();
		assertEquals(0, shop.eAdapters().size());
		assertEquals(0, c2.eAdapters().size());
	}
}
