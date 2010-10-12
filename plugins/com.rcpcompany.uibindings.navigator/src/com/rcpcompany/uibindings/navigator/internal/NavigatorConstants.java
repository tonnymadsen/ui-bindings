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
package com.rcpcompany.uibindings.navigator.internal;

import com.rcpcompany.uibindings.navigator.INavigatorManager;

/**
 * Various constants used in the navigator plug-in
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface NavigatorConstants {
	/**
	 * The editors extension point.
	 * 
	 * @see EditorManagerImpl#extensionReader()
	 */
	String EDITORS_EXTENSION_POINT = Activator.ID + ".editors"; //$NON-NLS-1$

	/**
	 * The ID of the Generic Editor View.
	 */
	String EDITOR_VIEW_ID = Activator.ID + ".views.BaseEditorView"; //$NON-NLS-1$

	/**
	 * Preference name for {@link INavigatorManager#isUseGenericEditorPartFallback()}.
	 */
	String PREF_USE_GENERIC_EDITOR_PART_FALLBACK = "USE_GENERIC_EDITOR_PART_FALLBACK";

	/**
	 * Preference name for {@link INavigatorManager#isOpenMustOpenNew()}.
	 */
	String PREF_OPEN_MUST_OPEN_NEW = "PREF_OPEN_MUST_OPEN_NEW";

	/**
	 * Preference name for {@link INavigatorManager#isPinEditorByDefault()()}.
	 */
	String PREF_PIN_EDITOR_BY_DEFAULT = "PREF_PIN_EDITOR_BY_DEFAULT";

	String ID_TAG = "id";
	String MODEL_TYPE_TAG = "modelType";
	String EDITOR_TAG = "editor";
	String PRIORITY_TAG = "priority";
	String NAME_TAG = "name";
	String IMAGE_TAG = "image";
	String FACTORY_TAG = "factory";
	String CLASS_TAG = "class";
	String PREFERENCE_MODEL_TYPE_TAG = "preferenceModelType";
	String ENABLED_WHEN_TAG = "enabledWhen";
	String TREE_ITEM_TAG = "treeItem";

	/**
	 * Command ID for the "Select Editor..." command.
	 */
	String SELECT_EDITOR_PART_COMMAND = Activator.ID + ".commands.SelectEditorPart";

	/**
	 * Parameter ID for the <code>editorID</code> parameter of {@link #SELECT_EDITOR_PART_COMMAND}.
	 */
	String EDITOR_ID_PARAMETER = "editorID";

}
