package com.rcpcompany.uibindings.navigator.extests;

import static org.junit.Assert.fail;

import org.eclipse.emf.ecore.EClass;

import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;

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
		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();
		manager.closeAllViews();

		for (final IEditorModelType mt : manager.getModelTypes()) {
			mt.setPreferredEditor(mt.getEditors().get(0));
		}
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
	public static IEditorPartDescriptor findDescriptor(Class cls, String id) {
		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();
		for (final IEditorModelType mt : manager.getModelTypes()) {
			if (mt.getModelType().equals(cls.getName())) {
				for (final IEditorPartDescriptor d : mt.getEditors()) {
					if (d.getId().equals(id)) return d;
				}
			}
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
	public static void setPreferred(Class cls, String id) {
		final IEditorPartDescriptor descriptor = findDescriptor(cls, id);
		descriptor.getModelType().setPreferredEditor(descriptor);
	}

	public static IEditorModelType getMultipleEditorModelType() {
		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();
		for (final IEditorModelType m : manager.getModelTypes()) {
			if (m.getEditors().size() > 1) return m;
		}
		fail("no EditorModelType found with multiple editors");
		return null;
	}
}
