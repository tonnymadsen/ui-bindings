package com.rcpcompany.uibindings.scripting.internal;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Preference initializer for local preferences.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setDefault(Activator.SHOW_SCRIPT_IN_BINDINGS_PREFERENCE, true);
	}

}
