/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.utils;

import org.eclipse.ui.IMemento;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.BindingContextPersistence;

/**
 * This utility class is used to ease the persistence of configuration data for a set of
 * {@link IBindingContext IBindingContexts}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IBindingContextPersistence extends IDisposable {
	/**
	 * The factory methods for {@link IBindingContextPersistence}.
	 */
	final class Factory {
		private Factory() {
		}

		/**
		 * 
		 * @param context
		 * @return
		 */
		public static IBindingContextPersistence create() {
			return new BindingContextPersistence();
		}
	}

	/**
	 * Saves all state for the specified context.
	 * 
	 * @param memento the memento to save state into
	 */
	void saveState(IMemento memento);

	/**
	 * Restores all state for the specified context.
	 * 
	 * @param memento the memento to restore state from
	 */
	void restoreState(IMemento memento);
}
