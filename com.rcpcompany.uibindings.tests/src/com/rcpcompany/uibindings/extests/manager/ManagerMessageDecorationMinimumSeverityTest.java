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
package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIBindingsPackage;

public class ManagerMessageDecorationMinimumSeverityTest extends
		AbstractPreferenceStoreEnumTest<BindingMessageSeverity> {

	@Override
	public BindingMessageSeverity getDefault() {
		return BindingMessageSeverity.WARNING;
	}

	@Override
	public BindingMessageSeverity[] getValues() {
		return BindingMessageSeverity.values();
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__MESSAGE_DECORATION_MINIMUM_SEVERITY;
	}

	@Override
	public String getPreferenceName() {
		return Constants.PREF_MESSAGE_DECORATION_MINIMUM_SEVERITY;
	}
}
