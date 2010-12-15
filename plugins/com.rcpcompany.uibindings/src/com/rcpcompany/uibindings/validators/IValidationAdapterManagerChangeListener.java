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
package com.rcpcompany.uibindings.validators;

/**
 * Listener interface for changes in {@link IValidatorAdapterManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IValidationAdapterManagerChangeListener {
	/**
	 * Signals that the state of the {@link IValidatorAdapterManager} has changed. Specific objects
	 * have either gotten additional messages, changed messages or "lost" messages.
	 * 
	 * @param event a description of the current state
	 */
	void affectedObjectsChanged(IValidationAdapterManagerChangeEvent event);
}
