package com.rcpcompany.uibindings.navigator.internal.views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.navigator.AbstractEditorPartFactory;
import com.rcpcompany.uibindings.navigator.FormEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.navigator.extests.NavigatorTestUtils;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;

/**
 * Tests of {@link IEditorPartFactory} and abstract implementations
 * 
 * TODO missing test of {@link FormEditorPartFactory}.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class EditorPartFactoryTests {
	protected static INavigatorManager myManager;
	protected static ShopItemGroup myGroup;

	@Before
	public void before() {
		NavigatorTestUtils.resetAll();
		myManager = INavigatorModelFactory.eINSTANCE.getManager();

		myGroup = ShopFactory.eINSTANCE.createShopItemGroup();

		NavigatorTestUtils.setPreferred(ShopItemGroup.class,
				"com.rcpcompany.uibindings.navigator.internal.views.EditorPartFactoryTests.GroupEditorPartFactory");
	}

	/**
	 * Tests {@link IEditorPartContext}.
	 */
	@Test
	public void testEditorPartContext() {
		final IEditorPartView view = myManager.getView(myGroup);
		assertNotNull(view);
		assertTrue(GroupEditorPartFactory.hasRun);
	}

	/**
	 * {@link IEditorPartFactory} for {@link EditorPartFactoryTests#testEditorPartContext()}.
	 */
	public static class GroupEditorPartFactory extends AbstractEditorPartFactory implements IEditorPartFactory {
		public static boolean hasRun = false;

		@Override
		public IEditorPart createEditorPart(IEditorPartContext context) {
			hasRun = true;

			assertNotNull(context);

			assertTrue(context.getWorkbenchPart() instanceof BaseEditorView);
			final BaseEditorView view = (BaseEditorView) context.getWorkbenchPart();

			assertEquals(view.myParent, context.getParent());

			assertNotNull(context.getCurrentValue());
			assertEquals(view.myCurrentValue, context.getCurrentValue());
			assertEquals(myGroup, context.getCurrentValue().getValue());
			assertEquals(myGroup.eClass(), context.getCurrentValue().getValueType());

			IEditorPartDescriptor desc = null;
			for (final IEditorModelType mt : myManager.getModelTypes()) {
				if (mt.getModelType().equals(ShopItemGroup.class.getName())) {
					assertEquals(2, mt.getEditors().size());
					desc = mt.getEditors().get(0);
				}
			}
			assertEquals(desc, context.getDescriptor());
			assertEquals(view.getCurrentDescriptor(), context.getDescriptor());

			return null;
		}

	}
}
