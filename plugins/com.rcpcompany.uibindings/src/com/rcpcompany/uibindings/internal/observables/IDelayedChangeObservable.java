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
package com.rcpcompany.uibindings.internal.observables;

import com.rcpcompany.uibindings.TextCommitStrategy;

/**
 * This interface to specify that the observable supports the delayed update of the model
 * observable:
 * <p>
 * When a change is made to the widget of the observable and the {@link TextCommitStrategy commit
 * strategy} means the model data is not updated immediately, then the changes are reported via the
 * {@link IDelayedChangeListener} interface.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IDelayedChangeObservable {
	/**
	 * Adds the given delayed change listener to the list of listeners.
	 * 
	 * @param listener the listener to add
	 */
	void addDelayedChangeListener(IDelayedChangeListener listener);

	/**
	 * Removes the given delayed change listener from the list of listeners. Has no effect if the
	 * given listener is not registered as a listener.
	 * 
	 * @param listener the listener to remove
	 */
	void removeDelayedChangeListener(IDelayedChangeListener listener);
}
