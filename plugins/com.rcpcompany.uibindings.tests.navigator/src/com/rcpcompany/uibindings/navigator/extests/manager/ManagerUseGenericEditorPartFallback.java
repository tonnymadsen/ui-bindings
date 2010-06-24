package com.rcpcompany.uibindings.navigator.extests.manager;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.navigator.INavigatorModelPackage;
import com.rcpcompany.uibindings.navigator.internal.NavigatorConstants;

public class ManagerUseGenericEditorPartFallback extends AbstractPreferenceStoreBooleanTest {

	@Override
	public boolean getDefault() {
		return true;
	}

	@Override
	public EStructuralFeature getFeature() {
		return INavigatorModelPackage.Literals.NAVIGATOR_MANAGER__USE_GENERIC_EDITOR_PART_FALLBACK;
	}

	@Override
	public String getPreferenceName() {
		return NavigatorConstants.PREF_USE_GENERIC_EDITOR_PART_FALLBACK;
	}
}
