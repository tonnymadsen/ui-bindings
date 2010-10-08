package com.rcpcompany.uibindings.utils;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IManager.Factory;
import com.rcpcompany.uibindings.internal.utils.ManagerRunnableManager;

/**
 * The manager interface for {@link IManagerRunnable}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IManagerRunnableManager extends IDisposable {
	/**
	 * Factory for a number of objects including the manager itself.
	 */
	final class Factory {
		private Factory() {
		}

		/**
		 * Returns the manager singleton.
		 * 
		 * @return the manager
		 */
		public static IManagerRunnableManager getManager() {
			final IManager manager = IManager.Factory.getManager();
			IManagerRunnableManager smanager = manager.getService(IManagerRunnableManager.class);
			if (smanager == null) {
				smanager = new ManagerRunnableManager();
			}
			return smanager;
		}
	}

	/**
	 * Queues a {@link IManagerRunnable} or {@link Runnable} to be run at the first possible moment
	 * on the event queue of the workbench.
	 * <p>
	 * Each Runnable is keyed by a combination of a type (a <code>String</code>) and an object and
	 * any new addition will replace any older Runnable with the same key. This behavior can be
	 * disabled by using the type <code>null</code>.
	 * <p>
	 * If the runnable is a {@link IManagerRunnable}, the addition can be canceled with
	 * <code>cancelAsyncExec</code> and operation can be monitored with
	 * {@link IManagerRunnableListener listeners}.
	 * 
	 * @param type the type of the runnable or <code>null</code>
	 * @param key the key object
	 * @param runnable the runnable
	 */
	void asyncExec(String type, Object key, Runnable runnable);

	/**
	 * Cancels a previously registered runnable from {@link #asyncExec(String, Object, Runnable)}.
	 * 
	 * @param type the type of the runnable or <code>null</code>
	 * @param key the key object
	 */
	void cancelAsyncExec(String type, Object key);
}
