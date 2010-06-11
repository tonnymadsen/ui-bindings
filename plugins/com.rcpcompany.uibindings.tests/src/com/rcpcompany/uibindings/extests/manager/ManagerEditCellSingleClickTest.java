package com.rcpcompany.uibindings.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.UIBindingPreferences;

public class ManagerEditCellSingleClickTest extends AbstractPreferenceStoreBooleanTest {

	@Override
	public boolean getDefault() {
		return true;
	}

	@Override
	public EStructuralFeature getFeature() {
		return IUIBindingsPackage.Literals.MANAGER__EDIT_CELL_SINGLE_CLICK;
	}

	@Override
	public String getPreferenceName() {
		return UIBindingPreferences.PREF_EDIT_CELL_SINGLE_CLICK;
	}
}
