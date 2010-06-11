package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.UIBindingPreferences;

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
		return UIBindingPreferences.PREF_TEXT_COMMIT_STRATEGY_DELAY;
	}

	@Override
	public int[] getValues() {
		return new int[] { 1, 100, 2000, 100000 };
	}
}
