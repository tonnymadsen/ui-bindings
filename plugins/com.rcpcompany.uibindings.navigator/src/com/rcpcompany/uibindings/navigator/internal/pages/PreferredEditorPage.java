package com.rcpcompany.uibindings.navigator.internal.pages;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;
import com.rcpcompany.uibindings.navigator.internal.Activator;
import com.rcpcompany.uibindings.navigator.internal.NavigatorConstants;

/**
 * Preference page for all things related to the editors of the navigator.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class PreferredEditorPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Constructs and returns a new preference page.
	 */
	public PreferredEditorPage() {
		super("Editor Preferences", FieldEditorPreferencePage.GRID);

		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {
		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();
		FieldEditor editor;

		for (final IEditorModelType mt : manager.getModelTypes()) {
			if (mt.isAutoGenerated()) {
				continue;
			}
			final String[][] translation = new String[mt.getEditors().size()][];
			for (int i = 0; i < translation.length; i++) {
				final IEditorPartDescriptor d = mt.getEditors().get(i);
				translation[i] = new String[] { d.getName(), d.getId() };
			}
			editor = new ComboFieldEditor(mt.getModelType(), "" + mt.getModelType(), translation,
					getFieldEditorParent());

			addField(editor);
		}

		editor = new BooleanFieldEditor(NavigatorConstants.PREF_USE_GENERIC_EDITOR_PART_FALLBACK,
				"Fall back on generic editor part", getFieldEditorParent());
		addField(editor);
	}

	@Override
	public void init(IWorkbench workbench) {
	}
}