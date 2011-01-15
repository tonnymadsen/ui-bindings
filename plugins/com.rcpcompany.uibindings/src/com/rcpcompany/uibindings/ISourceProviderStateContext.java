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
package com.rcpcompany.uibindings;

import java.util.Map;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Event;

import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;

/**
 * State object used when updating the source provider state in {@link BindingSourceProvider}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ISourceProviderStateContext {
	/**
	 * The current state.
	 * 
	 * @return a map with the current state
	 */
	Map<String, Object> getState();

	/**
	 * Sets the current selection provider.
	 * <p>
	 * Used to monitor changes in the selection, which triggers a re-calculation of the current
	 * sources in {@link BindingSourceProvider}.
	 * 
	 * @param provider the new selection provider or <code>null</code>
	 */
	void setSelectionProvider(ISelectionProvider provider);

	/**
	 * Sets the specified source to the specified value.
	 * 
	 * @param name the name of the source - e.g. {@link Constants#SOURCES_ACTIVE_BINDING_FEATURE}
	 * @param value the new value
	 */
	void putSourceValue(String name, Object value);

	/**
	 * The event that triggered the re-evaluatio of the state.
	 * <p>
	 * Can be <code>null</code>.
	 * 
	 * @return the event or <code>null</code>
	 */
	Event getEvent();

	/**
	 * Adds a new {@link IObservableValue} which value must be observed. If the observed value
	 * changes value, then the state must be re-evaluated.
	 * 
	 * @param value the new observed value
	 */
	void addObservedValue(IObservableValue value);
}
