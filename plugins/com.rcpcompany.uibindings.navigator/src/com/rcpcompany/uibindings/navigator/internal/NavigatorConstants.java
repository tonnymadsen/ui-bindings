package com.rcpcompany.uibindings.navigator.internal;

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

	String ID_TAG = "id";
	String MODEL_TYPE_TAG = "modelType";
	String EDITOR_TAG = "editor";
	String PRIORITY_TAG = "priority";
	String NAME_TAG = "name";
	String IMAGE_TAG = "image";
	String FACTORY_TAG = "factory";
}
