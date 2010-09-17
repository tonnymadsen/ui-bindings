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
package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.UIBindingPreferences;

public class ManagerValidationErrorsAreFatal extends AbstractPreferenceStoreBooleanTest {

	@Override
	public boolean getDefault() {
		return false;
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__VALIDATION_ERRORS_ARE_FATAL;
	}

	@Override
	public String getPreferenceName() {
		return UIBindingPreferences.PREF_VALIDATION_ERRORS_ARE_FATAL;
	}
}
