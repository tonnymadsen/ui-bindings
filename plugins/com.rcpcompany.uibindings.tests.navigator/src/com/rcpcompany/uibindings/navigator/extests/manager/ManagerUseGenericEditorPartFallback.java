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
package com.rcpcompany.uibindings.navigator.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;
import com.rcpcompany.uibindings.navigator.internal.NavigatorConstants;

public class ManagerUseGenericEditorPartFallback extends AbstractPreferenceStoreBooleanTest {

	@Override
	public boolean getDefault() {
		return true;
	}

	@Override
	public EStructuralFeature getFeature() {
		return INavigatorModelPackage.Literals.NAVIGATOR_MANAGER__USE_GENERIC_EDITOR_PART_FALLBACK;
	}

	@Override
	public String getPreferenceName() {
		return NavigatorConstants.PREF_USE_GENERIC_EDITOR_PART_FALLBACK;
	}
}
