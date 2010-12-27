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
package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.ui.IMemento;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.utils.IBindingContextPersistence;

/**
 * Implementation of {@link IBindingContextPersistence}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingContextPersistence implements IBindingContextPersistence, IDisposable {
	/**
	 * Constructs and initializes a new sorter...
	 * 
	 * @param context the binding
	 */
	public BindingContextPersistence() {
		init();
	}

	/**
	 * Initializes this sorter.
	 */
	protected void init() {
	}

	/**
	 * Removes the sorting functionality again.
	 */
	@Override
	public void dispose() {
	}

	/**
	 * Saves the current state of the binding in the specified {@link IMemento} under the name of
	 * the viewer.
	 * 
	 * @param memento the memento
	 * @param name the name used for the configuration information - defaults to the name of the
	 *            viewer
	 */
	@Override
	public void saveState(IMemento memento) {
		// TODO see issue 58
	}

	/**
	 * Restores the state of the binding from the specified {@link IMemento} using the name of the
	 * viewer.
	 * 
	 * @param memento the memento
	 * @param name the name used for the configuration information - defaults to the name of the
	 *            viewer
	 */
	@Override
	public void restoreState(IMemento memento) {
		// TODO see issue 58
	}
}
