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
package com.rcpcompany.uibindings.navigator.internal.views;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EAttribute;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.navigator.FormEditorPartFactory;
import com.rcpcompany.uibindings.navigator.FormEditorPartFactory.FormEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPartView;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.editorFactories.GenericPlainFormEditorPartFactory;
import com.rcpcompany.uibindings.navigator.extests.NavigatorTestUtils;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopItemGroup;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Tests of {@link GenericPlainFormEditorPartFactory}
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class GenericPlainFormEditorPartFactoryTests {
	protected static INavigatorManager myManager;
	protected static ShopItemGroup myGroup;

	@Before
	public void before() {
		NavigatorTestUtils.resetAll();
		myManager = INavigatorManager.Factory.getManager();

		myGroup = ShopFactory.eINSTANCE.createShopItemGroup();

		NavigatorTestUtils.setPreferred(ShopItemGroup.class,
				"com.rcpcompany.uibindings.navigator.extests.editors.GenericPlainFormEditorPartFactoryTests");
	}

	/**
	 * Tests the correct fields are present in the view
	 */
	@Test
	public void testFields() {
		final IEditorPartView view = myManager.openView(myGroup, true);
		yield();
		assertNotNull(view);

		assertTrue(view instanceof BaseEditorView);
		final BaseEditorView editorView = (BaseEditorView) view;

		final IEditorPart part = editorView.myCurrentEditorPart;
		assertTrue(part instanceof FormEditorPart);
		final FormEditorPartFactory.FormEditorPart editorPart = (FormEditorPart) part;

		final IFormCreator form = editorPart.getForm();
		assertNotNull(form);
		final IBindingContext context = form.getContext();
		assertNotNull(context);

		assertEquals(4, context.getBindings().size());

//		for (final IBinding b : context.getBindings()) {
//			System.out.println(b);
//		}

		testOneBinding(context, 1, IMOAOPackage.Literals.NAMED_OBJECT__NAME, true);
		testOneBinding(context, 2, IMOAOPackage.Literals.NAMED_OBJECT__DESCRIPTION, true);
		testOneBinding(context, 3, IMOAOPackage.Literals.NAMED_OBJECT__UUID, false);
	}

	/**
	 * @param context
	 * @param i
	 * @param expectedFeature
	 * @param changeable TODO
	 */
	private void testOneBinding(final IBindingContext context, final int i, final EAttribute expectedFeature,
			boolean expectedChangeable) {
		final IBinding b = context.getBindings().get(i);
		assertTrue(b instanceof IValueBinding);
		assertEquals(expectedFeature, ((IValueBinding) b).getModelFeature());
		assertEquals(expectedChangeable, ((IValueBinding) b).isChangeable());
	}
}
