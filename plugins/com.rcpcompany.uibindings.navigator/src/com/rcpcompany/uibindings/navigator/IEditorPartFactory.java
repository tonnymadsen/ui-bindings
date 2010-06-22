package com.rcpcompany.uibindings.navigator;

/**
 * Factory for an editor part.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IEditorPartFactory {
	/**
	 * Creates and returns the new editor part in the specified form.
	 * 
	 * @param context the context for the creation
	 * @return the created editor part
	 */
	IEditorPart createEditorPart(IEditorPartContext context);
}
