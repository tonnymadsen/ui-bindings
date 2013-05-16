/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.scripting.internal.preferencePages;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rcpcompany.uibindings.scripting.internal.Activator;

/**
 * Preference page for all scripting related preferences.
 */
public class ScriptingPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Constructs a new page
	 */
	public ScriptingPreferencePage() {
		super(FieldEditorPreferencePage.GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {
		final FieldEditor editor = new BooleanFieldEditor(Activator.SHOW_SCRIPT_IN_BINDINGS_PREFERENCE,
				"Show scripts in bindings", getFieldEditorParent());
		addField(editor);
	}

	@Override
	public void init(IWorkbench workbench) {
	}
}
