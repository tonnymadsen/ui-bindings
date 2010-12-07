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
