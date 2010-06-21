package com.rcpcompany.uibindings.navigator.editors.builtin;

import com.rcpcompany.uibindings.navigator.editors.IEditor;
import com.rcpcompany.uibindings.navigator.editors.IEditorContext;
import com.rcpcompany.uibindings.utils.IAutoFormCreator;

/**
 * The generic editor, that uses the {@link IAutoFormCreator} to create the editor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GenericEditor implements IEditor {

	@Override
	public void createEditor(IEditorContext context) {
		IAutoFormCreator.Factory.createForm(null, null, null, null);
	}
}
