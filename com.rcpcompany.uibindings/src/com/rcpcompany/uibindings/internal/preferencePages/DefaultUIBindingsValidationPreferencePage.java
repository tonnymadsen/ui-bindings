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
package com.rcpcompany.uibindings.internal.preferencePages;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.rcpcompany.uibindings.BindingMessageSeverity;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.internal.Activator;

/**
 * The validation preference page.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public class DefaultUIBindingsValidationPreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	/**
	 * Constructs and returns a new initialized preference page.
	 */
	public DefaultUIBindingsValidationPreferencePage() {
		super(FieldEditorPreferencePage.FLAT);

		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	@Override
	protected void createFieldEditors() {
		FieldEditor fe = null;

		final String[][] decorationsPositions = new String[][] {
				{ "top left", DecorationPosition.TOP_LEFT.getLiteral() },
				{ "center left", DecorationPosition.CENTER_LEFT.getLiteral() },
				{ "bottom left", DecorationPosition.BOTTOM_LEFT.getLiteral() },
				{ "top right", DecorationPosition.TOP_RIGHT.getLiteral() },
				{ "center right", DecorationPosition.CENTER_RIGHT.getLiteral() },
				{ "bottom right", DecorationPosition.BOTTOM_RIGHT.getLiteral() }, };

		fe = new ComboFieldEditor(Constants.PREF_MESSAGE_DECORATION_POSITION, "&Position of message decorations",
				decorationsPositions, getFieldEditorParent());
		addField(fe);

		fe = new ComboFieldEditor(Constants.PREF_ALTERNATIVE_DECORATION_POSITION,
				"Position of alternative &decorations", decorationsPositions, getFieldEditorParent());
		addField(fe);

		final String[][] severities = new String[][] {
				{ BindingMessageSeverity.INFORMATION.getName(), BindingMessageSeverity.INFORMATION.getLiteral() },
				{ BindingMessageSeverity.WARNING.getName(), BindingMessageSeverity.WARNING.getLiteral() },
				{ BindingMessageSeverity.ERROR.getName(), BindingMessageSeverity.ERROR.getLiteral() }, };

		fe = new ComboFieldEditor(Constants.PREF_MESSAGE_DECORATION_MINIMUM_SEVERITY,
				"&Minimum severity for message decorations", severities, getFieldEditorParent());
		addField(fe);

		fe = new IntegerFieldEditor(Constants.PREF_VALIDATION_DELAY, "Delay for &validation", getFieldEditorParent());
		addField(fe);

		fe = new IntegerFieldEditor(Constants.PREF_VALIDATION_DELAY_WINDOW, "Delay &window for validation",
				getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(Constants.PREF_VALIDATION_ERRORS_ARE_FATAL, "Validation errors are &fatal",
				getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(Constants.PREF_REQUIRED_VBID_SHOWN, "Show \"required\" control decorations",
				getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(Constants.PREF_ASSIST_VBID_SHOWN, "Show \"quick assist\" control decorations",
				getFieldEditorParent());
		addField(fe);

		fe = new BooleanFieldEditor(Constants.PREF_QUICKFIX_VBID_SHOWN, "Show \"quickfix\" control decorations",
				getFieldEditorParent());
		addField(fe);
	}

	@Override
	public void init(IWorkbench workbench) {

	}
}
