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
package com.rcpcompany.uibindings.utils;

import org.eclipse.ui.IMemento;

/**
 * A component, service or binding that is persistent.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IPersistentParty {
	/**
	 * The ID of this party.
	 * 
	 * @return the ID or <code>null</code>
	 */
	String getId();

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
