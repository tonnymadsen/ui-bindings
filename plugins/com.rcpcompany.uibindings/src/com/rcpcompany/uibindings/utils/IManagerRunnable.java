package com.rcpcompany.uibindings.utils;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingsFactory;

/**
 * A {@link Runnable} for use with {@link IManager#asyncExec(String, Object, IManagerRunnable)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IManagerRunnable extends Runnable {
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
		public static IManager getManager() {
			return IUIBindingsFactory.eINSTANCE.getManager();
		}

		/**
		 * Queues a {@link IManagerRunnable} or {@link Runnable} to be run at the first possible
		 * moment on the event queue of the workbench.
		 * <p>
		 * Each Runnable is keyed by a combination of a type (a <code>String</code>) and an object
		 * and any new addition will replace any older Runnable with the same key. This behavior can
		 * be disabled by using the type <code>null</code>.
		 * <p>
		 * If the runnable is a {@link IManagerRunnable}, the addition can be cancelled with
		 * {@link #cancelAsyncExec(IManagerRunnable)} and operation can be monitored with
		 * {@link IManagerRunnableListener listeners}.
		 * 
		 * @param type the type of the runnable or <code>null</code>
		 * @param key the key object
		 * @param runnable the runnable
		 */
		public static void asyncExec(String type, Object key, Runnable runnable) {
			IManagerRunnableManager.Factory.getManager().asyncExec(type, key, runnable);
		}

		/**
		 * Cancels a previously registered runnable from
		 * {@link #asyncExec(String, Object, Runnable)}.
		 * 
		 * @param type the type of the runnable
		 * @param key the key object
		 */
		public static void cancelAsyncExec(String type, Object key) {
			IManagerRunnableManager.Factory.getManager().cancelAsyncExec(type, key);
		}
	}

}
