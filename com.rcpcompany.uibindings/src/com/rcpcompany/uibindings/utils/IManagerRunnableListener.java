/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.utils;

import com.rcpcompany.uibindings.IManager;

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
