package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.UIBindingPreferences;

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
		return UIBindingPreferences.PREF_MESSAGE_DECORATION_MINIMUM_SEVERITY;
	}
}
