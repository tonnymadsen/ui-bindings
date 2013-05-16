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

public class ManagerTextCommitStrategyDelayTest extends AbstractPreferenceStoreIntTest {

	@Override
	public int getDefault() {
		return 400;
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__TEXT_COMMIT_STRATEGY_DELAY;
	}

	@Override
	public String getPreferenceName() {
		return Constants.PREF_TEXT_COMMIT_STRATEGY_DELAY;
	}

	@Override
	public int[] getValues() {
		return new int[] { 1, 100, 2000, 100000 };
	}
}
