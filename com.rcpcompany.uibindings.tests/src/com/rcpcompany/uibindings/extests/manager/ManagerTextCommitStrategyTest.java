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

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.TextCommitStrategy;

public class ManagerTextCommitStrategyTest extends AbstractPreferenceStoreEnumTest<TextCommitStrategy> {

	@Override
	public TextCommitStrategy getDefault() {
		return TextCommitStrategy.ON_MODIFY_DELAY;
	}

	@Override
	public TextCommitStrategy[] getValues() {
		return TextCommitStrategy.values();
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__TEXT_COMMIT_STRATEGY;
	}

	@Override
	public String getPreferenceName() {
		return Constants.PREF_TEXT_COMMIT_STRATEGY;
	}
}
