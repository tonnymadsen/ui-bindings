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
package com.rcpcompany.uibindings.bindings.xtext.internal.validators;

import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.validators.IConstraintValidatorAdapterConstraint;
import com.rcpcompany.uibindings.validators.IConstraintValidatorAdapterConstraintProvider;
import com.rcpcompany.uibindings.validators.IValidatorAdapterManager;

/**
 * This class provides an adapter interface between the constraint specified in the uibindings extension point and
 * {@link IValidatorAdapterManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UIBXTextConstraintProvider implements IConstraintValidatorAdapterConstraintProvider {

	@Override
	public IConstraintValidatorAdapterConstraint getConstraint(IValueBinding binding) {
		// TODO
		return null;
	}
}
