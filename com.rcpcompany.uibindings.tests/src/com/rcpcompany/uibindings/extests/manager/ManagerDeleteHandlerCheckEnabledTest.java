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
package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIBindingsPackage;

public class ManagerDeleteHandlerCheckEnabledTest extends AbstractPreferenceStoreBooleanTest {

	@Override
	public boolean getDefault() {
		return false;
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__DELETE_HANDLER_CHECK_ENABLED;
	}

	@Override
	public String getPreferenceName() {
		return Constants.PREF_DELETE_HANDLER_CHECK_ENABLED;
	}
}
