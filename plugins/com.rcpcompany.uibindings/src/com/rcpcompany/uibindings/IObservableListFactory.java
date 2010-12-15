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
package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.observable.list.IObservableList;

/**
 * This factory interface is used when a {@link IObservableList} is needed based on an annotation
 * argument argument.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IObservableListFactory {
	/**
	 * Creates and returns a new observable list for the binding.
	 * <p>
	 * The caller must dispose the returned list.
	 * 
	 * @param binding the binding to return a list for
	 * @return the list
	 */
	IObservableList createList(IValueBinding binding);
}
