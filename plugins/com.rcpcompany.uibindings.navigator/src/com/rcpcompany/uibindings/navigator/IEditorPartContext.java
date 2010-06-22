package com.rcpcompany.uibindings.navigator;

import org.eclipse.ui.IWorkbenchPart;

/**
 * The context for {@link IEditorPartFactory#createEditorPart(IEditorPartContext)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IEditorPartContext {
	/**
	 * Returns the part for the editor.
	 * 
	 * @return the part
	 */
	IWorkbenchPart getPart();
}
