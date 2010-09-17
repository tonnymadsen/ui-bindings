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
package com.rcpcompany.uibindings.utils;

import org.eclipse.core.databinding.observable.value.IObservableValue;

/**
 * This interface is used by {@link IFormChooser} to create new forms based on {@link IFormCreator}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IFormCreatorChooserCreator {
	/**
	 * Creates a new form with the specified parent.
	 * <p>
	 * The form is automatically {@link IFormCreator#finish() finished} when the call has returned.
	 * 
	 * @param discriminant the discriminant value that resulted in the form
	 * @param form the form for the chooser
	 */
	void createForm(IObservableValue discriminant, IFormCreator form);
}
