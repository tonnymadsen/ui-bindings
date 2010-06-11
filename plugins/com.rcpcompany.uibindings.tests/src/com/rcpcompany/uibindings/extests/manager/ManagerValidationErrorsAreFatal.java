package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.UIBindingPreferences;

public class ManagerValidationErrorsAreFatal extends AbstractPreferenceStoreBooleanTest {

	@Override
	public boolean getDefault() {
		return false;
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__VALIDATION_ERRORS_ARE_FATAL;
	}

	@Override
	public String getPreferenceName() {
		return UIBindingPreferences.PREF_VALIDATION_ERRORS_ARE_FATAL;
	}
}
