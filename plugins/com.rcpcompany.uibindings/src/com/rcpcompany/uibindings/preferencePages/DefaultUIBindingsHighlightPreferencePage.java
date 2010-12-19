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
package com.rcpcompany.uibindings.preferencePages;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.UIBindingPreferences;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.IBindingHighlightContext;

/**
 * The {@link IBindingHighlightContext} preference page.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public class DefaultUIBindingsHighlightPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	/**
	 * Constructs and returns a new initialized preference page.
	 */
	public DefaultUIBindingsHighlightPreferencePage() {
		super(FieldEditorPreferencePage.FLAT);

		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {
		FieldEditor fe = null;

		fe = new ColorFieldEditor(Constants.COLOR_DEFINITIONS_DEFAULT_HIGHLIGHT_BACKGROUND, "Default background color",
				getFieldEditorParent());
		addField(fe);

		fe = new IntegerFieldEditor(UIBindingPreferences.PREF_REQUIRED_VBID_SHOWN,
				"Show \"required\" control decorations", getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(UIBindingPreferences.PREF_ASSIST_VBID_SHOWN,
				"Show \"quick assist\" control decorations", getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(UIBindingPreferences.PREF_QUICKFIX_VBID_SHOWN,
				"Show \"quickfix\" control decorations", getFieldEditorParent());
		addField(fe);
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}
