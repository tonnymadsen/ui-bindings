package com.rcpcompany.uibindings.navigator.internal.pages;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.INavigatorModelFactory;

public class PreferredEditorPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public PreferredEditorPage() {
		super("Editor Preferences", FieldEditorPreferencePage.GRID);
	}

	@Override
	protected void createFieldEditors() {
		final INavigatorManager manager = INavigatorModelFactory.eINSTANCE.getManager();

		for (final IEditorModelType mt : manager.getModelTypes()) {

			final String[][] translation = new String[mt.getEditors().size()][];
			for (int i = 0; i < translation.length; i++) {
				final IEditorPartDescriptor d = mt.getEditors().get(i);
				translation[i] = new String[] { d.getName(), d.getId() };
			}
			final FieldEditor editor = new ComboFieldEditor(mt.getModelType(), "" + mt.getModelType(), translation,
					getFieldEditorParent());

			addField(editor);
		}
	}

	@Override
	public void init(IWorkbench workbench) {
	}
}
