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
package com.rcpcompany.uibindings.extests.manager;

import static com.rcpcompany.test.utils.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.preference.IPreferenceStore;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;

public abstract class AbstractPreferenceStoreBooleanTest {

	/**
	 * Returns the default value for this boolean in the preference store.
	 * 
	 * @return the default value
	 */
	public abstract boolean getDefault();

	/**
	 * Returns the structural feature of this enumeration.
	 * 
	 * @return the feature
	 */
	public abstract EStructuralFeature getFeature();

	/**
	 * Returns the preference name for the enumeration
	 * 
	 * @return the name
	 */
	public abstract String getPreferenceName();

	private final class TestAdapter extends AdapterImpl {
		public int called = 0;
		private final boolean myOldValue;
		private final boolean myNewValue;

		private TestAdapter(boolean oldValue, boolean newValue) {
			myOldValue = oldValue;
			myNewValue = newValue;
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.getEventType() == Notification.REMOVING_ADAPTER) return;
			assertEquals(Notification.SET, msg.getEventType());
			assertEquals(getFeature(), msg.getFeature());
			assertEquals(myOldValue, msg.getOldValue());
			assertEquals(myNewValue, msg.getNewValue());

			called++;
		}
	}

	private IManager m;

	@Before
	public void setup() {
		BaseUIBTestUtils.resetAll();
		m = IManager.Factory.getManager();
	}

	public void testPS2M(final boolean newValue) {
		final boolean oldValue = (Boolean) m.eGet(getFeature());
		final TestAdapter adapter = new TestAdapter(oldValue, newValue);

		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				m.eAdapters().add(adapter);
				ps.setValue(getPreferenceName(), newValue);
				assertEquals(oldValue + " -> " + newValue, 1, adapter.called);
				m.eAdapters().remove(adapter);

			}
		});
		assertEquals(newValue, m.eGet(getFeature()));
	}

	/**
	 * Tests for {@link IManager#getE()}.
	 */
	@Test
	public void testGet() {
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		assertNotNull(ps);

		final boolean value = ps.getBoolean(getPreferenceName());
		assertEquals(getDefault(), value);
		assertEquals(getDefault(), m.eGet(getFeature()));

		testPS2M(!value);
		testPS2M(value);
		testPS2M(!value);
		ps.setValue(getPreferenceName(), getDefault());
	}

	public void testM2PS(final boolean newValue) {
		final boolean oldValue = (Boolean) m.eGet(getFeature());
		final TestAdapter adapter = new TestAdapter(oldValue, newValue);

		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();

		assertNoLog(new Runnable() {
			@Override
			public void run() {
				m.eAdapters().add(adapter);
				m.eSet(getFeature(), newValue);
				assertEquals(1, adapter.called);
				m.eAdapters().remove(adapter);

			}
		});
		final boolean s = ps.getBoolean(getPreferenceName());
		assertEquals(newValue, s);
		assertEquals(newValue, m.eGet(getFeature()));
	}

	/**
	 * Tests of {@link IManager#setE(boolean)}.
	 */
	@Test
	public void testSet() {
		final boolean value = getDefault();
		testM2PS(!value);
		testM2PS(value);
		testM2PS(!value);

		m.eSet(getFeature(), value);
	}
}
