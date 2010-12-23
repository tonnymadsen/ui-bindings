package com.rcpcompany.uibindings.extests.observables;

import static org.junit.Assert.*;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.observables.EListElementObservableValue;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

/**
 * Tests of {@link EListElementObservableValue}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EListElementObservableValueTests {
	private EditingDomain myEd;

	private Shop myShop1;
	private Country myC1_0;
	private Country myC1_1;

	private Shop myShop2;
	private Country myC2_0;
	private Country myC2_1;

	private Country myCA;

	@Before
	public void before() {
		myEd = IManager.Factory.getManager().getEditingDomain();

		myShop1 = ShopFactory.eINSTANCE.createShop();

		myC1_0 = ShopFactory.eINSTANCE.createCountry();
		myC1_0.setName("Danmark");
		myC1_0.setShop(myShop1);

		myC1_1 = ShopFactory.eINSTANCE.createCountry();
		myC1_1.setName("Sweden");
		myC1_1.setShop(myShop1);

		myShop2 = ShopFactory.eINSTANCE.createShop();

		myC2_0 = ShopFactory.eINSTANCE.createCountry();
		myC2_0.setName("Danmark");
		myC2_0.setShop(myShop2);

		myC2_1 = ShopFactory.eINSTANCE.createCountry();
		myC2_1.setName("Sweden");
		myC2_1.setShop(myShop2);

		myCA = ShopFactory.eINSTANCE.createCountry();
		myCA.setName("AAA");
	}

	@Test
	public void test() {
		final WritableValue shopOV = WritableValue.withValueType(ShopPackage.Literals.SHOP);
		final EListElementObservableValue v = new EListElementObservableValue(myEd, shopOV,
				ShopPackage.Literals.SHOP__COUNTRIES, 1);

		assertEquals(ShopPackage.Literals.COUNTRY, v.getValueType());
		assertEquals(null, v.getValue());

		shopOV.setValue(myShop1);
		assertEquals(myC1_1, v.getValue());

		shopOV.setValue(myShop2);
		assertEquals(myC2_1, v.getValue());

		myShop2.getCountries().set(1, myCA);
		assertEquals(myCA, v.getValue());

		v.setValue(myC1_1);
		assertEquals(myC1_1, myShop2.getCountries().get(1));
		assertEquals(1, myShop1.getCountries().size());
		assertEquals(myC1_1, v.getValue());

		myShop2.getCountries().remove(0);
		assertEquals(null, v.getValue());
	}
}
