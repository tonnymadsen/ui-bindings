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
package com.rcpcompany.uibindings.internal.preferencePages;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.IBindingHighlightContext;

/**
 * The default preference page for {@link IBindingHighlightContext}.
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

		fe = new IntegerFieldEditor(Constants.PREF_HIGHLIGHT_FADE_IN_TIME, "Fade &In Time (ms)", getFieldEditorParent());
		addField(fe);

		fe = new IntegerFieldEditor(Constants.PREF_HIGHLIGHT_FADE_OUT_TIME, "Fade &Out Time (ms)",
				getFieldEditorParent());
		addField(fe);

		fe = new IntegerFieldEditor(Constants.PREF_HIGHLIGHT_ACTIVE_TIME, "Default &Active Time (ms)",
				getFieldEditorParent());
		addField(fe);
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}
