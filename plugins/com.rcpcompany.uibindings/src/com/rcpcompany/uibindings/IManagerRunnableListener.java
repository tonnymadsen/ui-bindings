package com.rcpcompany.uibindings;

/**
 * Listener interface for {@link IManagerRunnable}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IManagerRunnableListener {
	/**
	 * The runnable was canceled explicitly via {@link IManager#cancelAsyncExec(IManagerRunnable)}.
	 * 
	 * @param runnable the canceled runnable
	 */
	void runnableCancelled(IManagerRunnable runnable);

	/**
	 * The runnable was executed.
	 * 
	 * @param runnable the executed runnable
	 */
	void runnableExecuted(IManagerRunnable runnable);

	/**
	 * The runnable was replaced with another runnable with the same type and key.
	 * 
	 * @param type the type of the replaced runnable
	 * @param key the object of the replaced runnable
	 * @param runnable the replaced runnable
	 */
	void runnableReplaced(String type, Object key, IManagerRunnable runnable);
}
