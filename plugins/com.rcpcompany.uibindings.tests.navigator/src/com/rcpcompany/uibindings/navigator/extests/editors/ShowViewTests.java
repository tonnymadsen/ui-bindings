package com.rcpcompany.uibindings.navigator.extests.editors;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.extests.NavigatorTestUtils;
import com.rcpcompany.uibindings.navigator.internal.views.BaseEditorView;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItem;

/**
 * Tests that the {@link BaseEditorView} is properly shown.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class ShowViewTests {
	private INavigatorManager myManager;
	private Shop myShop1;
	private Shop myShop2;
	private ShopItem myShopItem;
	private Country myCountry;

	@Before
	public void before() {
		NavigatorTestUtils.resetAll();
		myManager = INavigatorManager.Factory.getManager();

		myShop1 = ShopFactory.eINSTANCE.createShop();
		myShop2 = ShopFactory.eINSTANCE.createShop();

		myCountry = ShopFactory.eINSTANCE.createCountry();

		myShopItem = ShopFactory.eINSTANCE.createShopItem();
	}

	/**
	 * Test that {@link IEditorPartView#isPinned()} is respected in
	 * {@link INavigatorManager#openView(org.eclipse.emf.ecore.EObject)}.
	 */
	@Test
	public void reuseUnpinned() {
		final IEditorPartView shop1View = myManager.openView(myShop1);
		shop1View.setPinned(true);
		final IEditorPartView shop2View = myManager.openView(myShop2);

		// Re-use the view
		assertEquals(shop1View, myManager.openView(myShop1));

		shop1View.setPinned(false);

		// Still re-use the existing view
		assertEquals(shop2View, myManager.openView(myShop2));

		assertEquals(shop1View, myManager.openView(myCountry));
	}
}
