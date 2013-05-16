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
package com.rcpcompany.uibindings.observables;

import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IBindingMessageTarget;
import com.rcpcompany.uibindings.IValueBinding;

/**
 * This interface is used for {@link IObservable observables} that that have a key for the current
 * value.
 * <p>
 * The key is primary used to correlate {@link IBindingMessage binding messages} via their
 * {@link IBindingMessageTarget targets} with specific bindings via their
 * {@link IValueBinding#getModelObservable() model observable}.
 * <p>
 * No specific interpretation is put into the key.
 * <p>
 * Examples are:
 * <ul>
 * <li>{@link Map} - where the key is the key in the map</li>
 * <li>{@link List} - where the key is the index in the list</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public interface IKeyedObservable {
	/**
	 * Returns the key for this observable.
	 * 
	 * @return the key
	 */
	Object getObservableKey();
}
