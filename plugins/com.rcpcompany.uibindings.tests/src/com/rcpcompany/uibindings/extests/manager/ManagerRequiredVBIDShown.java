package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.UIBindingPreferences;

public class ManagerRequiredVBIDShown extends AbstractPreferenceStoreBooleanTest {

	@Override
	public boolean getDefault() {
		return true;
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__REQUIRED_VB_IMAGE_DECORATION_SHOWN;
	}

	@Override
	public String getPreferenceName() {
		return UIBindingPreferences.PREF_REQUIRED_VBID_SHOWN;
	}
}
