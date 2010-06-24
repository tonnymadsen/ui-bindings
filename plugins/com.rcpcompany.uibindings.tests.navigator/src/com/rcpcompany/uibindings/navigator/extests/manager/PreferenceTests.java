package com.rcpcompany.uibindings.navigator.extests.manager;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertOneLog;
import static org.junit.Assert.assertEquals;

import org.eclipse.jface.preference.IPreferenceStore;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.navigator.extests.NavigatorTestUtils;
import com.rcpcompany.uibindings.navigator.internal.Activator;

/**
 * Tests the preferences for the registrered mode types.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PreferenceTests {
	@Before
	public void before() {
		NavigatorTestUtils.resetAll();
	}

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
	public void testPreferredToPreference() {
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();

		/*
		 * Find the model type with multiple editors.
		 */
		final IEditorModelType mt = NavigatorTestUtils.getMultipleEditorModelType();

		final IEditorPartDescriptor first = mt.getEditors().get(0);
		final IEditorPartDescriptor second = mt.getEditors().get(1);

		assertEquals(first, mt.getPreferredEditor());
		assertEquals(first.getId(), ps.getString(mt.getModelType()));

		assertNoLog(new Runnable() {
			public void run() {
				mt.setPreferredEditor(second);
			}
		});

		assertEquals(second, mt.getPreferredEditor());
		assertEquals(second.getId(), ps.getString(mt.getModelType()));

		assertNoLog(new Runnable() {
			public void run() {
				mt.setPreferredEditor(null);
			}
		});

		assertEquals(first, mt.getPreferredEditor());
		assertEquals(first.getId(), ps.getString(mt.getModelType()));
	}

	/**
	 * Tests that setting the preference will change the preferred
	 */
	@Test
	public void testPreferenceToPreferred() {
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();

		/*
		 * Find the model type with multiple editors.
		 */
		final IEditorModelType mt = NavigatorTestUtils.getMultipleEditorModelType();

		final IEditorPartDescriptor first = mt.getEditors().get(0);
		final IEditorPartDescriptor second = mt.getEditors().get(1);

		assertEquals(first, mt.getPreferredEditor());
		assertEquals(first.getId(), ps.getString(mt.getModelType()));

		assertNoLog(new Runnable() {
			public void run() {
				ps.setValue(mt.getModelType(), second.getId());
			}
		});

		assertEquals(second, mt.getPreferredEditor());
		assertEquals(second.getId(), ps.getString(mt.getModelType()));

		// Wrong value defaults to first..
		assertOneLog(new Runnable() {
			@Override
			public void run() {
				ps.setValue(mt.getModelType(), "aaa");
			}
		});

		assertEquals(first, mt.getPreferredEditor());
		assertEquals(first.getId(), ps.getString(mt.getModelType()));
	}
}
