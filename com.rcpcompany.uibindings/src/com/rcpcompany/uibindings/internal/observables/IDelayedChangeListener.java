/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IObservablesListener;
import org.eclipse.core.databinding.observable.IStaleListener;
import org.eclipse.core.databinding.observable.StaleEvent;

import com.rcpcompany.uibindings.TextCommitStrategy;

/**
 * Listener for delayed change events. A listener will receive delayed change events if a change is
 * pending according to the current {@link TextCommitStrategy}, but the change has not been
 * committed yet.
 * <p>
 * As such, this is very similar to {@link IStaleListener}, but {@link StaleEvent} are only fired
 * once for each an observable becomes stale, whereas {@link DelayedChangeEvent} is fired for each
 * change of the observable until a {@link ChangeEvent}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IDelayedChangeListener extends IObservablesListener {

	/**
	 * Notifies the listener that a delayed change is pending.
	 * 
	 * @param event the event
	 */
	void handleDelayedChange(DelayedChangeEvent event);
}
