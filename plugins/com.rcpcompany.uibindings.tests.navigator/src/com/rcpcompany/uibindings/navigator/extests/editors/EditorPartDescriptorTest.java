package com.rcpcompany.uibindings.navigator.extests.editors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.Test;

import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;

/**
 * Tests retrieval of {@link IEditorPartDescriptor}
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EditorPartDescriptorTest {
	/**
	 * Tests <code>null</code> return <code>null</code>
	 */
	@Test
	public void test() {
		testOne(null, null);
		testOne(null, EcoreFactory.eINSTANCE.createEObject());
		testOne("com.rcpcompany.uibindings.tests.editors.editors.basic", ShopFactory.eINSTANCE.createShop());
		testOne("com.rcpcompany.uibindings.tests.editors.editors.generic.country",
				ShopFactory.eINSTANCE.createCountry());
		testOne("com.rcpcompany.uibindings.tests.editors.editors.generic.shopinformation",
				ShopFactory.eINSTANCE.createShopItemURL());
	}

	/**
	 * Tests a single object against a specific ID...
	 * 
	 * @param id the expected object or <code>null</code> if no descriptor should be found
	 * @param obj the object to find
	 */
	private void testOne(String id, EObject obj) {
		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();

		final IEditorPartDescriptor desc = manager.getEditorPartDescriptor(obj);
		if (id == null) {
			assertEquals(null, desc);
		} else {
			assertNotNull("Description missing for " + id, desc);
			assertEquals(id, desc.getId());
		}
	}
}
