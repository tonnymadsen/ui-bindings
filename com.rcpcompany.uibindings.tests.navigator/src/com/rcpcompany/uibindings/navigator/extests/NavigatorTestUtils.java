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
package com.rcpcompany.uibindings.navigator.extests;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.navigator.IEditorInformation;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * Various test utilities for this test fragment
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NavigatorTestUtils {
	/**
	 * Resets the internal state to the base..
	 */
	public static void resetAll() {
		/*
		 * provoke that the Shop package is properly initialized
		 */
		final EClass shop = ShopPackage.Literals.SHOP;

		final INavigatorManager manager = INavigatorManager.Factory.getManager();
		manager.eUnset(INavigatorModelPackage.Literals.NAVIGATOR_MANAGER__USE_GENERIC_EDITOR_PART_FALLBACK);

		manager.closeAllViews();
		for (final IEditorInformation mt : manager.getEditorInformations().toArray(new IEditorInformation[0])) {
			mt.setPreferredEditor(mt.getEditors().get(0));
		}
	}

	/**
	 * Returns the {@link IEditorInformation} for the specified class.
	 * <p>
	 * May fail.
	 * 
	 * @param cls the class of the model object
	 * @return the model type
	 */
	public static IEditorInformation findEditorInformation(Class<?> cls) {
		final INavigatorManager manager = INavigatorManager.Factory.getManager();
		for (final IEditorInformation mt : manager.getEditorInformations()) {
			if (mt.getModelType().equals(cls.getName())) return mt;
		}

		fail("Cannot find IEMT for " + cls.getSimpleName());
		return null;
	}

	/**
	 * Returns the {@link IEditorPartDescriptor} for the specified class and id.
	 * <p>
	 * May fail.
	 * 
	 * @param cls the class of the model object
	 * @param id the id of the editor part
	 * @return the editor part
	 */
	public static IEditorPartDescriptor findDescriptor(Class<?> cls, String id) {
		final IEditorInformation mt = findEditorInformation(cls);
		for (final IEditorPartDescriptor d : mt.getEditors()) {
			if (d.getId().equals(id)) return d;
		}

		fail("Cannot find IEPD for " + cls.getSimpleName() + " id " + id);
		return null;
	}

	/**
	 * Sets the preferred editor for the specified class to the editor with the specified id.
	 * <p>
	 * May fail.
	 * 
	 * @param cls the class of the model object
	 * @param id the id of the editor part
	 */
	public static void setPreferred(Class<?> cls, String id) {
		final IEditorInformation mt = findEditorInformation(cls);
		final IEditorPartDescriptor d = findDescriptor(cls, id);
		mt.setPreferredEditor(d);
	}

	public static IEditorInformation getMultipleEditorModelType() {
		final INavigatorManager manager = INavigatorManager.Factory.getManager();
		for (final CEObjectHolder<EObject> h : manager.getPreferenceModelTypes()) {
			final IEditorInformation mt = manager.getEditorInformation(h.getObjectClass());
			if (mt.getEditors().size() > 1) return mt;
		}
		fail("no EditorInformation found with multiple editors");
		return null;
	}
}
