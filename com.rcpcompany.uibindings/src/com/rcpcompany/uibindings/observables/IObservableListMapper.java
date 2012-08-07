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
package com.rcpcompany.uibindings.observables;

/**
 * This interface is used to map the values in one list to the new values in a new parallel list.
 * 
 * @see EMFListAttributeList
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IObservableListMapper {
	/**
	 * Maps the specified value to a new value
	 * 
	 * @param value the original value - can be <code>null</code>
	 * @return the new value
	 */
	Object map(Object value);
}
