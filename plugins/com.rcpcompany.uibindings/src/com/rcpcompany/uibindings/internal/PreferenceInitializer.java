package com.rcpcompany.uibindings.internal;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.rcpcompany.uibindings.UIBindingPreferences;

/**
 * Setup of the preference defaults...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {
	@Override
	public void initializeDefaultPreferences() {

		final IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();

		preferenceStore.setDefault(UIBindingPreferences.PREF_EDIT_CELL_ANY_KEY, ManagerImpl.EDIT_CELL_ANY_KEY_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_EDIT_CELL_SINGLE_CLICK,
				ManagerImpl.EDIT_CELL_SINGLE_CLICK_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_TEXT_COMMIT_STRATEGY,
				ManagerImpl.TEXT_COMMIT_STRATEGY_EDEFAULT.getLiteral());
		preferenceStore.setDefault(UIBindingPreferences.PREF_TEXT_COMMIT_STRATEGY_DELAY,
				ManagerImpl.TEXT_COMMIT_STRATEGY_DELAY_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_AUTO_APPLY_QUICKFIX,
				ManagerImpl.AUTO_APPLY_SINGLE_QUICKFIX_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_ALTERNATE_ROW_COLORS,
				ManagerImpl.ALTERNATE_ROW_COLORS_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_MESSAGE_DECORATION_POSITION,
				ManagerImpl.MESSAGE_DECORATION_POSITION_EDEFAULT.getLiteral());
		preferenceStore.setDefault(UIBindingPreferences.PREF_MESSAGE_DECORATION_MINIMUM_SEVERITY,
				ManagerImpl.MESSAGE_DECORATION_MINIMUM_SEVERITY_EDEFAULT.getLiteral());
		preferenceStore.setDefault(UIBindingPreferences.PREF_ALTERNATIVE_DECORATION_POSITION,
				ManagerImpl.ALTERNATIVE_DECORATION_POSITION_EDEFAULT.getLiteral());
		preferenceStore.setDefault(UIBindingPreferences.PREF_VALIDATION_DELAY, ManagerImpl.VALIDATION_DELAY_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_VALIDATION_DELAY_WINDOW,
				ManagerImpl.VALIDATION_DELAY_WINDOW_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_VALIDATION_ERRORS_ARE_FATAL,
				ManagerImpl.VALIDATION_ERRORS_ARE_FATAL_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_REQUIRED_VBID_SHOWN,
				ManagerImpl.REQUIRED_VB_IMAGE_DECORATION_SHOWN_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_ASSIST_VBID_SHOWN,
				ManagerImpl.ASSIST_VB_IMAGE_DECORATION_SHOWN_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_QUICKFIX_VBID_SHOWN,
				ManagerImpl.QUICKFIX_VB_IMAGE_DECORATION_SHOWN_EDEFAULT);
		preferenceStore.setDefault(UIBindingPreferences.PREF_VIEW_NAVIGATION_RECORDED,
				ManagerImpl.VIEW_NAVIGATION_RECORDED_EDEFAULT);
	}
}
