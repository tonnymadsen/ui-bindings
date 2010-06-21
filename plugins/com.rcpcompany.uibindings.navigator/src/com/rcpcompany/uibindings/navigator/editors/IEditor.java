package com.rcpcompany.uibindings.navigator.editors;


/**
 * Interface for editors.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IEditor {
	/**
	 * Creates the new editor in the specified form
	 * 
	 * @param context the context for the creation
	 */
	void createEditor(IEditorContext context);
}
