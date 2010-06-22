package com.rcpcompany.uibindings.navigator;

import org.eclipse.ui.IWorkbenchPart;


/**
 * The context for {@link IEditor#createEditor(IEditorContext)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IEditorContext {
	/**
	 * Returns the part for the editor.
	 * 
	 * @return the part
	 */
	IWorkbenchPart getPart();
}
