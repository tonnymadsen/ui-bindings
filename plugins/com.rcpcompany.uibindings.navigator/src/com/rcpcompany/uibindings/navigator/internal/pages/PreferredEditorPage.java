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
package com.rcpcompany.uibindings.navigator.internal.pages;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IModelClassInfo;
import com.rcpcompany.uibindings.navigator.IEditorModelType;
import com.rcpcompany.uibindings.navigator.IEditorPartDescriptor;
import com.rcpcompany.uibindings.navigator.INavigatorManager;
import com.rcpcompany.uibindings.navigator.internal.Activator;
import com.rcpcompany.uibindings.navigator.internal.NavigatorConstants;
import com.rcpcompany.utils.basic.ToStringUtils;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

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
		final INavigatorManager manager = INavigatorManager.Factory.getManager();
		FieldEditor editor;

		final IManager uim = IManager.Factory.getManager();
		for (final CEObjectHolder<EObject> pmt : manager.getPreferenceModelTypes()) {
			final IEditorModelType mt = manager.getModelType(pmt.getObjectClass());

			final String[][] translation = new String[mt.getEditors().size()][];
			for (int i = 0; i < translation.length; i++) {
				final IEditorPartDescriptor d = mt.getEditors().get(i);
				translation[i] = new String[] { d.getName(), d.getId() };
			}

			/*
			 * TODO: change this to use a proper binding
			 * 
			 * IBindingObjectInformation
			 */
			String n = mt.getModelType();
			if (n.lastIndexOf('.') != -1) {
				n = n.substring(n.lastIndexOf('.') + 1);
			}
			if (n.matches("^I[A-Z]")) {
				n = n.substring(1);
			}
			String name = ToStringUtils.formatHumanReadable(n);
			final IModelClassInfo info = uim.getModelClassInfo(mt.getModelType(), null, false);
			if (info != null) {
				final Object l = info.getArguments().get(Constants.ARG_LABEL);
				if (l != null && l instanceof String) {
					name = (String) l;
				}
			}
			editor = new ComboFieldEditor(mt.getModelType(), name, translation, getFieldEditorParent());

			addField(editor);
		}

		editor = new BooleanFieldEditor(NavigatorConstants.PREF_USE_GENERIC_EDITOR_PART_FALLBACK,
				"Fall back on generic editor part", getFieldEditorParent());
		addField(editor);

		editor = new BooleanFieldEditor(NavigatorConstants.PREF_OPEN_MUST_OPEN_NEW,
				"Open command should open new editors", getFieldEditorParent());
		addField(editor);

		editor = new BooleanFieldEditor(NavigatorConstants.PREF_PIN_EDITOR_BY_DEFAULT, "Pin new editors by default",
				getFieldEditorParent());
		addField(editor);
	}

	@Override
	public void init(IWorkbench workbench) {
	}
}
