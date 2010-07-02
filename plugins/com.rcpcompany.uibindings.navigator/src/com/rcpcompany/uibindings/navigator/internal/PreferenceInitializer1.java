package com.rcpcompany.uibindings.navigator.internal;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import com.rcpcompany.uibindings.navigator.INavigatorManager;

/**
 * Initializes the preference defaults for this plug-in.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PreferenceInitializer1 extends AbstractPreferenceInitializer {
	@Override
	public void initializeDefaultPreferences() {
		INavigatorManager.Factory.getManager();
	}
}
