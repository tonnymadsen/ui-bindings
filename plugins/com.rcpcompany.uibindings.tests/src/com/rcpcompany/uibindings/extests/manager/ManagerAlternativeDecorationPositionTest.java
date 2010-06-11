package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.UIBindingPreferences;

public class ManagerAlternativeDecorationPositionTest extends AbstractPreferenceStoreEnumTest<DecorationPosition> {

	@Override
	public DecorationPosition getDefault() {
		return DecorationPosition.TOP_LEFT;
	}

	@Override
	public DecorationPosition[] getValues() {
		return DecorationPosition.values();
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__ALTERNATIVE_DECORATION_POSITION;
	}

	@Override
	public String getPreferenceName() {
		return UIBindingPreferences.PREF_ALTERNATIVE_DECORATION_POSITION;
	}
}
