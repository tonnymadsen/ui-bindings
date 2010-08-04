package com.rcpcompany.uibindings.extests.manager;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.*;
import static org.junit.Assert.*;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.preference.IPreferenceStore;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.Activator;

public abstract class AbstractPreferenceStoreIntTest {

	/**
	 * Returns the default value for this enumeration in the preference store.
	 * 
	 * @return the default value
	 */
	public abstract int getDefault();

	/**
	 * Returns an array with all the value enumeration values.
	 * 
	 * @return the values
	 */
	public abstract int[] getValues();

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

	/**
	 * The manager...
	 */
	public final IManager m = IManager.Factory.getManager();

	private final class TestAdapter extends AdapterImpl {
		public int called = 0;
		private final int myOldValue;
		private final int myNewValue;

		private TestAdapter(int oldValue, int newValue) {
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

			called += 1;
		}
	}

	public void testPS2M(final int newValue) {
		final int oldValue = (Integer) m.eGet(getFeature());
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
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
				assertNotNull(ps);

				final int value = ps.getInt(getPreferenceName());
				assertEquals(getDefault(), value);
				assertEquals(getDefault(), m.eGet(getFeature()));

				ps.setValue(getPreferenceName(), getValues()[1]);

				for (final int s : getValues()) {
					testPS2M(s);
				}
				ps.setValue(getPreferenceName(), getDefault());
			}
		});
	}

	public void testM2PS(final int newValue) {
		final int oldValue = (Integer) m.eGet(getFeature());
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
		final int s = ps.getInt(getPreferenceName());
		assertEquals(newValue, s);
		assertEquals(newValue, m.eGet(getFeature()));
	}

	/**
	 * Tests of {@link IManager#setE(int)}.
	 */
	@Test
	public void testSet() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				for (final int s : getValues()) {
					testM2PS(s);
				}
				m.eSet(getFeature(), getDefault());
			}
		});
	}
}
