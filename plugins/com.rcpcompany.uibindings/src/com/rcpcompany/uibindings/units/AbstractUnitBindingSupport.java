package com.rcpcompany.uibindings.units;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * Abstract base class for {@link IUnitBindingSupport}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractUnitBindingSupport implements IUnitBindingSupport {
	@Override
	public abstract double getFactor(IUnitBindingSupportContext context);

	@Override
	public abstract String getUnitDescription(IUnitBindingSupportContext context);

	/**
	 * Fires a {@link IUnitBindingSupportListener#unitsChanged()} to all added listeners.
	 */
	public void fireUnitsChanged() {
		if (myListeners == null) return;
		for (final IUnitBindingSupportListener l : myListeners) {
			SafeRunner.run(new ISafeRunnable() {
				@Override
				public void run() throws Exception {
					l.unitsChanged();
				}

				@Override
				public void handleException(Throwable ex) {
					LogUtils.error(l, ex);
				}
			});
		}
	}

	/**
	 * Listeners for this support object.
	 */
	private List<IUnitBindingSupportListener> myListeners = null;

	@Override
	public void addListener(IUnitBindingSupportListener listener) {
		if (myListeners == null) {
			myListeners = new ArrayList<IUnitBindingSupportListener>();
		}
		if (myListeners.contains(listener)) return;
		myListeners.add(listener);
	}

	@Override
	public void removeListener(IUnitBindingSupportListener listener) {
		if (myListeners == null) return;
		myListeners.remove(listener);
		if (myListeners.size() == 0) {
			myListeners = null;
		}
	}
}
