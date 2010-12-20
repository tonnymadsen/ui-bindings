/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.utils.IBindingHighlightContext;

/**
 * Setup of the preference defaults...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {
	@Override
	public void initializeDefaultPreferences() {

		final IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();

		preferenceStore.setDefault(Constants.PREF_EDIT_CELL_ANY_KEY, ManagerImpl.EDIT_CELL_ANY_KEY_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_EDIT_CELL_SINGLE_CLICK, ManagerImpl.EDIT_CELL_SINGLE_CLICK_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_TEXT_COMMIT_STRATEGY,
				ManagerImpl.TEXT_COMMIT_STRATEGY_EDEFAULT.getLiteral());
		preferenceStore.setDefault(Constants.PREF_TEXT_COMMIT_STRATEGY_DELAY,
				ManagerImpl.TEXT_COMMIT_STRATEGY_DELAY_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_AUTO_APPLY_QUICKFIX, ManagerImpl.AUTO_APPLY_SINGLE_QUICKFIX_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_ALTERNATE_ROW_COLORS, ManagerImpl.ALTERNATE_ROW_COLORS_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_MESSAGE_DECORATION_POSITION,
				ManagerImpl.MESSAGE_DECORATION_POSITION_EDEFAULT.getLiteral());
		preferenceStore.setDefault(Constants.PREF_MESSAGE_DECORATION_MINIMUM_SEVERITY,
				ManagerImpl.MESSAGE_DECORATION_MINIMUM_SEVERITY_EDEFAULT.getLiteral());
		preferenceStore.setDefault(Constants.PREF_ALTERNATIVE_DECORATION_POSITION,
				ManagerImpl.ALTERNATIVE_DECORATION_POSITION_EDEFAULT.getLiteral());
		preferenceStore.setDefault(Constants.PREF_VALIDATION_DELAY, ManagerImpl.VALIDATION_DELAY_EDEFAULT);
		preferenceStore
				.setDefault(Constants.PREF_VALIDATION_DELAY_WINDOW, ManagerImpl.VALIDATION_DELAY_WINDOW_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_VALIDATION_ERRORS_ARE_FATAL,
				ManagerImpl.VALIDATION_ERRORS_ARE_FATAL_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_REQUIRED_VBID_SHOWN,
				ManagerImpl.REQUIRED_VB_IMAGE_DECORATION_SHOWN_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_ASSIST_VBID_SHOWN,
				ManagerImpl.ASSIST_VB_IMAGE_DECORATION_SHOWN_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_QUICKFIX_VBID_SHOWN,
				ManagerImpl.QUICKFIX_VB_IMAGE_DECORATION_SHOWN_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_VIEW_NAVIGATION_RECORDED,
				ManagerImpl.VIEW_NAVIGATION_RECORDED_EDEFAULT);
		preferenceStore.setDefault(Constants.PREF_DELETE_HANDLER_CHECK_ENABLED,
				ManagerImpl.DELETE_HANDLER_CHECK_ENABLED_EDEFAULT);

		preferenceStore
				.setDefault(Constants.PREF_HIGHLIGHT_FADE_IN_TIME, IBindingHighlightContext.DEFAULT_FADE_IN_TIME);
		preferenceStore.setDefault(Constants.PREF_HIGHLIGHT_FADE_OUT_TIME,
				IBindingHighlightContext.DEFAULT_FADE_OUT_TIME);
		preferenceStore.setDefault(Constants.PREF_HIGHLIGHT_ACTIVE_TIME, IBindingHighlightContext.DEFAULT_ACTIVE_TIME);
	}
}
