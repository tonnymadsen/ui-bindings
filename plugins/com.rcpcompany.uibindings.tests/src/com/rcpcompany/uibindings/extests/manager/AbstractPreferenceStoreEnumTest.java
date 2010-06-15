package com.rcpcompany.uibindings.extests.manager;

import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertNoLog;
import static com.rcpcompany.uibindings.extests.BaseTestUtils.assertOneLog;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.preference.IPreferenceStore;
import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.Activator;

public abstract class AbstractPreferenceStoreEnumTest<E extends Enum<E>> {

	/**
	 * Returns the default value for this enumeration in the preference store.
	 * 
	 * @return the default value
	 */
	public abstract E getDefault();

	/**
	 * Returns an array with all the value enumeration values.
	 * 
	 * @return the values
	 */
	public abstract E[] getValues();

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
		private final E myOldValue;
		private final E myNewValue;

		private TestAdapter(E oldValue, E newValue) {
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

	public void testPS2M(final E newValue) {
		final E oldValue = (E) m.eGet(getFeature());
		final TestAdapter adapter = new TestAdapter(oldValue, newValue);

		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();

		m.eAdapters().add(adapter);
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				ps.setValue(getPreferenceName(), newValue.name());
			}
		});
		assertEquals(oldValue + " -> " + newValue, 1, adapter.called);
		m.eAdapters().remove(adapter);
		assertEquals(newValue, m.eGet(getFeature()));
	}

	public void testPS2MError(final String newValue) {
		final E oldValue = (E) m.eGet(getFeature());
		final TestAdapter adapter = new TestAdapter(oldValue, oldValue);

		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();

		m.eAdapters().add(adapter);
		assertOneLog(new Runnable() {
			@Override
			public void run() {
				ps.setValue(getPreferenceName(), newValue);
			}
		});
		assertEquals(oldValue + " -> " + newValue, 0, adapter.called);
		m.eAdapters().remove(adapter);
	}

	/**
	 * Tests for {@link IManager#getE()}.
	 */
	@Test
	public void testGet() {
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				assertNotNull(ps);

				final String value = ps.getString(getPreferenceName());
				assertEquals(getDefault().name(), value);
				assertEquals(getDefault(), m.eGet(getFeature()));

				ps.setValue(getPreferenceName(), getValues()[1].name());

				for (final E s : getValues()) {
					testPS2M(s);
				}
			}
		});
		testPS2MError("sdsdsdsdsd");
		ps.setValue(getPreferenceName(), getDefault().name());
	}

	public void testM2PS(final E newValue) {
		final E oldValue = (E) m.eGet(getFeature());
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
		final String s = ps.getString(getPreferenceName());
		assertEquals(newValue.name(), s);
		assertEquals(newValue, m.eGet(getFeature()));
	}

	/**
	 * Tests of {@link IManager#setE(E)}.
	 */
	@Test
	public void testSet() {
		assertNoLog(new Runnable() {
			@Override
			public void run() {
				for (final E s : getValues()) {
					testM2PS(s);
				}
				m.eSet(getFeature(), getDefault());
			}
		});
	}
}
