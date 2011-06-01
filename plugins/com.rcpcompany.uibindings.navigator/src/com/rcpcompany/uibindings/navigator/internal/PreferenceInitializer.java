/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.navigator.internal;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.rcpcompany.uibindings.navigator.INavigatorManager;

/**
 * Initializes the preference defaults for this plug-in.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {
	@Override
	public void initializeDefaultPreferences() {
		INavigatorManager.Factory.getManager();

		final IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
		ps.setDefault(NavigatorConstants.PREF_SHOW_PIN_EDITOR_CONTRIBUTION, true);
		ps.setDefault(NavigatorConstants.PREF_SHOW_CLONE_EDITOR_CONTRIBUTION, true);
		ps.setDefault(NavigatorConstants.PREF_SHOW_OTHER_CONTRIBUTIONS, true);
	}
}
