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

/**
 * This interface is used to force an update of the value of an observable.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IUpdatableObservable {
	/**
	 * Used to force an update of the value. Any change in the value will fire an event.
	 */
	void forceUpdateValue();
}
