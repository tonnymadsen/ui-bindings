package com.rcpcompany.uibindings.navigator.editorFactories;

import com.rcpcompany.uibindings.navigator.IEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.utils.IAutoFormCreator;

/**
 * The generic editor, that uses the {@link IAutoFormCreator} to create the editor.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class GenericEditorPartFactory implements IEditorPartFactory {

	@Override
	public IEditorPart createEditorPart(IEditorPartContext context) {
		final IAutoFormCreator form = IAutoFormCreator.Factory.createForm(null, null, null, null);
		return new IEditorPart() {
			@Override
			public void dispose() {
				form.dispose();
			}
		};
	}
}
