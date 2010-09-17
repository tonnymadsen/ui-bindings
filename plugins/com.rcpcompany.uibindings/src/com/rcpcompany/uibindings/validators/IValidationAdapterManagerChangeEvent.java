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

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

/**
 * The event report via {@link IValidationAdapterManagerChangeListener}.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IValidationAdapterManagerChangeEvent {
	/**
	 * Returns a set of all the current objects of {@link IValidatorAdapterManager}.
	 * 
	 * @return the current objects
	 */
	Set<EObject> getCurrentObjects();

	/**
	 * Returns a set of all the changed objects of {@link IValidatorAdapterManager}.
	 * 
	 * @return the changed objects
	 */
	Set<EObject> getChangedObjects();
}
