package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.UIBindingPreferences;

public class ManagerAutoApplyQuickfixTest extends AbstractPreferenceStoreBooleanTest {

	@Override
	public boolean getDefault() {
		return false;
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__AUTO_APPLY_SINGLE_QUICKFIX;
	}

	@Override
	public String getPreferenceName() {
		return UIBindingPreferences.PREF_AUTO_APPLY_QUICKFIX;
	}
}
