package com.rcpcompany.uibindings.navigator.extests.editors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.navigator.AbstractEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.navigator.extests.NavigatorTestUtils;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;

/**
 * Tests of the lifecycle of {@link IEditorPart}.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class EditorPartLifecycleTests {
	protected static INavigatorManager myManager;
	protected static ShopItemGroup myGroup;

	@Before
	public void before() {
		NavigatorTestUtils.resetAll();
		myManager = INavigatorModelFactory.eINSTANCE.getManager();

		myGroup = ShopFactory.eINSTANCE.createShopItemGroup();

		NavigatorTestUtils.setPreferred(ShopItemGroup.class,
				"com.rcpcompany.uibindings.navigator.extests.editors.EditorPartLifecycleTests.GroupEditorPartFactory");
	}

	/**
	 * Tests {@link IEditorPartContext}.
	 */
	@Test
	public void testLifecycle() {
		assertEquals(false, GroupEditorPartFactory.constructed);
		final IEditorPartView view = myManager.getView(myGroup);
		assertNotNull(view);
		assertEquals(true, GroupEditorPartFactory.constructed);
		myManager.closeAllViews();
		assertEquals(false, GroupEditorPartFactory.constructed);
	}

	/**
	 * {@link IEditorPartFactory} for {@link EditorPartLifecycleTests#testLifecycle()}.
	 */
	public static class GroupEditorPartFactory extends AbstractEditorPartFactory implements IEditorPartFactory {
		public static boolean constructed = false;

		@Override
		public IEditorPart createEditorPart(IEditorPartContext context) {
			constructed = true;
			return new IEditorPart() {
				@Override
				public void dispose() {
					constructed = false;
				}
			};
		}

	}
}
