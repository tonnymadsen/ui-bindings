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
package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObservablesListener;
import org.eclipse.core.databinding.observable.ObservableEvent;

/**
 * Event for {@link IDelayedChangeListener}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DelayedChangeEvent extends ObservableEvent {

	/**
	 * Creates a new event.
	 * 
	 * @param source the source observable
	 */
	public DelayedChangeEvent(IObservable source) {
		super(source);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3491012225431471077L;

	static final Object TYPE = new Object();

	@Override
	protected void dispatch(IObservablesListener listener) {
		((IDelayedChangeListener) listener).handleDelayedChange(this);
	}

	@Override
	protected Object getListenerType() {
		return TYPE;
	}
}
