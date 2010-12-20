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
package com.rcpcompany.uibindings.internal.preferencePages;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.TextCommitStrategy;
import com.rcpcompany.uibindings.internal.Activator;

/**
 * The basic preference page.
 * <p>
 * Contains preferences for:
 * <ul>
 * <li>text commit strategy</li>
 * <li></li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */

public class DefaultUIBindingsTopPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	/**
	 * Constructs and returns a new initialized preference page.
	 */
	public DefaultUIBindingsTopPreferencePage() {
		super(FieldEditorPreferencePage.FLAT);

		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {
		FieldEditor fe = null;
		fe = new ComboFieldEditor(Constants.PREF_TEXT_COMMIT_STRATEGY, "&Commit strategy for text fields",
				new String[][] { { "modify", TextCommitStrategy.ON_MODIFY.name() },
						{ "focus out", TextCommitStrategy.ON_FOCUS_OUT.name() },
						{ "delayed modify", TextCommitStrategy.ON_MODIFY_DELAY.name() }, }, getFieldEditorParent());
		addField(fe);

		// TODO add enable/disable based on strategy field
		fe = new IntegerFieldEditor(Constants.PREF_TEXT_COMMIT_STRATEGY_DELAY, "&Delay for 'delayed modify'",
				getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(Constants.PREF_EDIT_CELL_ANY_KEY, "&Any key will start cell editing",
				getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(Constants.PREF_EDIT_CELL_SINGLE_CLICK, "&Single click will start cell editing",
				getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(Constants.PREF_ALTERNATE_ROW_COLORS, "Alternate &row colors in tables",
				getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(Constants.PREF_AUTO_APPLY_QUICKFIX, "Auto-apply lone &quick fix",
				getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(Constants.PREF_VIEW_NAVIGATION_RECORDED,
				"&Record view navigation in the navigation history", getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(Constants.PREF_DELETE_HANDLER_CHECK_ENABLED,
				"&Delete Handler enabled state calculated (potentially expensive)", getFieldEditorParent());
		addField(fe);
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}
