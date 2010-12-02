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
package com.rcpcompany.uibindings.navigator.extests.editors;

import static org.junit.Assert.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.navigator.AbstractEditorPart;
import com.rcpcompany.uibindings.navigator.AbstractEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
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
		myManager = INavigatorManager.Factory.getManager();

		myGroup = ShopFactory.eINSTANCE.createShopItemGroup();

		NavigatorTestUtils.setPreferred(ShopItemGroup.class,
				"com.rcpcompany.uibindings.navigator.extests.editors.EditorPartLifecycleTests.GroupEditorPartFactory");
	}

	/**
	 * Tests life cycle when the view is close - then the editor part is closed.
	 */
	@Test
	public void testLifecycleViewClose() {
		assertEquals(false, GroupEditorPartFactory.constructed);
		final IEditorPartView view = myManager.openView(myGroup, false);
		assertNotNull(view);
		assertEquals(true, GroupEditorPartFactory.constructed);
		assertEquals(false, GroupEditorPartFactory.myText.isDisposed());
		myManager.closeAllViews();
		assertEquals(false, GroupEditorPartFactory.constructed);
		assertEquals(true, GroupEditorPartFactory.myText.isDisposed());
	}

	/**
	 * Tests life cycle when the selection object is changed...
	 */
	@Test
	public void testLifecycleSelectionChanged() {
		assertEquals(false, GroupEditorPartFactory.constructed);
		final IEditorPartView view = myManager.openView(myGroup, false);
		assertNotNull(view);
		assertEquals(true, GroupEditorPartFactory.constructed);
		assertEquals(false, GroupEditorPartFactory.myText.isDisposed());
		final IEditorPartView view2 = myManager.openView(ShopFactory.eINSTANCE.createShop(), false);
		assertEquals(false, GroupEditorPartFactory.constructed);
		assertEquals(true, GroupEditorPartFactory.myText.isDisposed());
		assertEquals(view, view2);
	}

	/**
	 * {@link IEditorPartFactory} for {@link EditorPartLifecycleTests#testLifecycle()}.
	 */
	public static class GroupEditorPartFactory extends AbstractEditorPartFactory implements IEditorPartFactory {
		public static boolean constructed = false;
		public static Text myText;

		@Override
		public IEditorPart createEditorPart(IEditorPartContext context) {
			constructed = true;
			myText = new Text(context.getParent(), SWT.SINGLE | SWT.LEAD | SWT.BORDER);
			myText.setText("Hello world");

			return new AbstractEditorPart() {
				@Override
				public void dispose() {
					constructed = false;
				}
			};
		}
	}
}
