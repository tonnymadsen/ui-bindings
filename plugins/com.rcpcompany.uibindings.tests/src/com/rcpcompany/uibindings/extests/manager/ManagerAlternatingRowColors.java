package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.UIBindingPreferences;

public class ManagerAlternatingRowColors extends AbstractPreferenceStoreBooleanTest {

	@Override
	public boolean getDefault() {
		return true;
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__ALTERNATE_ROW_COLORS;
	}

	@Override
	public String getPreferenceName() {
		return UIBindingPreferences.PREF_ALTERNATE_ROW_COLORS;
	}
}
