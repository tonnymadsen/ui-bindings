package com.rcpcompany.uibindings.navigator.extests.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.jface.preference.IPreferenceStore;
import org.junit.Test;

import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.navigator.internal.Activator;

/**
 * Tests the preferences for the registrered mode types.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PreferenceTests {

	/**
	 * Tests that the defaults and the current values are all correct.
	 */
	@Test
	public void testDefaults() {
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();

		for (final IEditorModelType mt : manager.getModelTypes()) {
			final String c = mt.getModelType();
			final String def = ps.getDefaultString(c);

			assertEquals(mt.getEditors().get(0).getId(), def);
			assertEquals(ps.getString(c), def);
			assertEquals(mt.getEditors().get(0), mt.getPreferredEditor());
		}
	}

	/**
	 * Tests that setting the preferred will change the preferences
	 */
	@Test
	public void testPreferred() {
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();

		/*
		 * Find the model type with multiple editors.
		 */
		IEditorModelType mt = null;
		for (final IEditorModelType m : manager.getModelTypes()) {
			if (m.getEditors().size() > 1) {
				mt = m;
				break;
			}
		}
		assertNotNull(mt);

		final IEditorPartDescriptor first = mt.getEditors().get(0);
		final IEditorPartDescriptor second = mt.getEditors().get(1);

		assertEquals(first, mt.getPreferredEditor());
		assertEquals(first.getId(), ps.getString(mt.getModelType()));

		mt.setPreferredEditor(second);

		assertEquals(second, mt.getPreferredEditor());
		assertEquals(second.getId(), ps.getString(mt.getModelType()));

		mt.setPreferredEditor(first);

		assertEquals(first, mt.getPreferredEditor());
		assertEquals(first.getId(), ps.getString(mt.getModelType()));
	}
}
