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

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IManager;

/**
 * This adapter interface is used by object validators.
 * <p>
 * During construction a validator adapter must register itself with
 * {@link IManager#getValidatorAdapters()} .
 * <p>
 * All adapters are invoked - after a delay - after all changes in the model objects.
 * <p>
 * Validator adapters are normally created via the service interface with the target Manager.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IValidatorAdapter extends IDisposable {

	/**
	 * Validates the object tree rooted in the specified root and records all found issues in the
	 * specified observable list.
	 * <p>
	 * Care must be taken to not make unneeded changes as these will have severe consequences for
	 * the UI.
	 * <p>
	 * The list contains {@link IBindingMessage messages}.
	 * 
	 * @param root the root of the object tree to validate
	 * @param messages the list to update
	 */
	void validateObjectTree(EObject root, IObservableList messages);
}
