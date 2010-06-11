package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.UIBindingPreferences;

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
		return UIBindingPreferences.PREF_TEXT_COMMIT_STRATEGY;
	}
}
