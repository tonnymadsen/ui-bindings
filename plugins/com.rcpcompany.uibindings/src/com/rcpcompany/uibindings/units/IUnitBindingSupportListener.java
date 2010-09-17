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
package com.rcpcompany.uibindings.units;

/**
 * Interface used by listeners for changes in the {@link IUnitBindingSupport unit support for
 * bindings}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IUnitBindingSupportListener {
	/**
	 * Invoked to notify the listener that units might have changed that is relevant for listener.
	 */
	void unitsChanged();
}
