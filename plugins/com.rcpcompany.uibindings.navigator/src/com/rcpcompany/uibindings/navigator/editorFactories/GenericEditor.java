package com.rcpcompany.uibindings.navigator.editorFactories;

import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.utils.IAutoFormCreator;

/**
 * The generic editor, that uses the {@link IAutoFormCreator} to create the editor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GenericEditor implements IEditorPartFactory {

	@Override
	public void createEditorPart(IEditorPartContext context) {
		IAutoFormCreator.Factory.createForm(null, null, null, null);
	}
}
