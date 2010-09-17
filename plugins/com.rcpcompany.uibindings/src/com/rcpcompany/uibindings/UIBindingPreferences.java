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
package com.rcpcompany.uibindings;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IExecutableExtensionFactory;

import com.rcpcompany.uibindings.internal.preferencePages.DefaultUIBindingsTopPreferencePage;
import com.rcpcompany.uibindings.internal.preferencePages.DefaultUIBindingsValidationPreferencePage;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Preferences supported by the UI Bindings framework that are not related directly to the bindings
 * themselves.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public class UIBindingPreferences implements IExecutableExtension, IExecutableExtensionFactory {
	/**
	 * The preference name to specify whether cell editing is automatically started when any
	 * character is typed in a cell.
	 * <p>
	 * <code>true</code> means any character will start cell editing; <code>false</code> means only
	 * <code>F2</code> and <code>Return</code> will start cell editing.
	 */
	public static final String PREF_EDIT_CELL_ANY_KEY = "EditCellAnyKey"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether cell editing is automatically started when any
	 * character is typed in a cell.
	 * <p>
	 * <code>true</code> means any character will start cell editing; <code>false</code> means only
	 * <code>F2</code> and <code>Return</code> will start cell editing.
	 */
	public static final String PREF_EDIT_CELL_SINGLE_CLICK = "EditCellSingleClick"; //$NON-NLS-1$

	/**
	 * The preference name for the text commit strategy.
	 * <p>
	 * Can have the value specified via the {@link TextCommitStrategy} enumeration.
	 */
	public static final String PREF_TEXT_COMMIT_STRATEGY = "TextCommitStrategy"; //$NON-NLS-1$

	/**
	 * The preference name for the delay used for {@link TextCommitStrategy#ON_MODIFY_DELAY}.
	 * <p>
	 * In milliseconds.
	 */
	public static final String PREF_TEXT_COMMIT_STRATEGY_DELAY = "TextCommitStrategyDelay"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether a single quick fix is applied automatically.
	 * <p>
	 * <code>true</code> means a single quick fix should be applied automatically;
	 * <code>false</code> means even a single quick fix should be presented in a popup menu.
	 */
	public static final String PREF_AUTO_APPLY_QUICKFIX = "AutoApplyQuickfix"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether rows in tables should have alternating row background
	 * colors.
	 * <p>
	 * <code>true</code> means every other row have another background color; <code>false</code>
	 * means all rows have the same background color.
	 */
	public static final String PREF_ALTERNATE_ROW_COLORS = "AlternateRowColors"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether basic validation errors are fatal in the bindings.
	 * <p>
	 * When validation errors are <em>not</em> fatal, it means that numeric values outside their
	 * ranges can be committed anyway.
	 * <p>
	 * <code>true</code> means every validation errors are fatal.
	 */
	public static final String PREF_VALIDATION_ERRORS_ARE_FATAL = "ValidationErrorsAreFatal"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether the "required" image decoration is shown.
	 * <p>
	 * <code>true</code> means the decoration is shown.
	 */
	public static final String PREF_REQUIRED_VBID_SHOWN = "RequiredVBIDShown"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether the "required" image decoration is shown.
	 * <p>
	 * <code>true</code> means the decoration is shown.
	 */
	public static final String PREF_QUICKFIX_VBID_SHOWN = "QuickfixVBIDShown"; //$NON-NLS-1$

	/**
	 * The preference name to specify whether the "required" image decoration is shown.
	 * <p>
	 * <code>true</code> means the decoration is shown.
	 */
	public static final String PREF_ASSIST_VBID_SHOWN = "AssistVBIDShown"; //$NON-NLS-1$

	/**
	 * The preference name to specify that changes in the view are recorded by
	 * {@link IGlobalNavigationManager}.
	 * <p>
	 * <code>true</code> means the changes are recorded.
	 */
	public static final String PREF_VIEW_NAVIGATION_RECORDED = "ViewNavigationRecorded"; //$NON-NLS-1$

	/**
	 * The preference name to specify where on a widget a message decoration is placed.
	 * <p>
	 * One of the literal values of {@link DecorationPosition}.
	 */
	public static final String PREF_MESSAGE_DECORATION_POSITION = "MessageDecorationPosition"; //$NON-NLS-1$

	/**
	 * The preference name to specify the minimum severity showed in a message decoration.
	 * <p>
	 * One of the literal values of {@link BindingMessageSeverity}.
	 */
	public static final String PREF_MESSAGE_DECORATION_MINIMUM_SEVERITY = "MessageDecorationMinimumSeverity"; //$NON-NLS-1$

	/**
	 * The preference name to specify where on a widget an alternative decoration is placed.
	 * <p>
	 * One of the literal values of {@link DecorationPosition}.
	 */
	public static final String PREF_ALTERNATIVE_DECORATION_POSITION = "AlternativeDecorationPosition"; //$NON-NLS-1$

	/**
	 * The preference name for the delay used between a change is detected in the model and a
	 * validator is kicked off.
	 * <p>
	 * In milliseconds.
	 */
	public static final String PREF_VALIDATION_DELAY = "ValidationDelay"; //$NON-NLS-1$

	/**
	 * The preference name for the the size of the window after a validator is kicked off where no
	 * new validation will be started.
	 * <p>
	 * In milliseconds.
	 */
	public static final String PREF_VALIDATION_DELAY_WINDOW = "ValidationDelayWindow"; //$NON-NLS-1$

	/**
	 * The data string to use to create the basic top-level preference page.
	 * <p>
	 * Use by setting class to
	 * <code>com.rcpcompany.uibindings.UIBindingPreferences:basicPreferencePage</code>.
	 */
	public static final String TOP_PREF_PAGE = "basicPreferencePage"; //$NON-NLS-1$

	/**
	 * The data string to use to create the basic validation preference page.
	 * <p>
	 * Use by setting class to
	 * <code>com.rcpcompany.uibindings.UIBindingPreferences:validationPreferencePage</code>.
	 */
	public static final String VALIDATION_PREF_PAGE = "validationPreferencePage"; //$NON-NLS-1$

	private String myType;

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		myType = (String) data;
	}

	@Override
	public Object create() throws CoreException {
		if (TOP_PREF_PAGE.equals(myType)) return new DefaultUIBindingsTopPreferencePage();
		if (VALIDATION_PREF_PAGE.equals(myType)) return new DefaultUIBindingsValidationPreferencePage();
		LogUtils.error(this, "Unknown type name specified: " + myType); //$NON-NLS-1$
		return null;
	}
}
