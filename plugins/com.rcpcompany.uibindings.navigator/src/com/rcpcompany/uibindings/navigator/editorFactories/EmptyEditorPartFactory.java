package com.rcpcompany.uibindings.navigator.editorFactories;

import com.rcpcompany.uibindings.navigator.AbstractEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPart;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;

/**
 * The generic editor, that shows... nothing.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EmptyEditorPartFactory extends AbstractEditorPartFactory implements IEditorPartFactory {

	@Override
	public IEditorPart createEditorPart(IEditorPartContext context) {
		return new IEditorPart() {
			@Override
			public void dispose() {
			}
		};
	}
}
