package com.rcpcompany.uibindings.tests.navigator.editorParts;

import com.rcpcompany.uibindings.navigator.FormEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Editor Part for the basic Shop information.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BasicShopInfo extends FormEditorPartFactory implements IEditorPartFactory {
	@Override
	protected void createForm(IEditorPartContext context, IFormCreator form) {
		form.addField("name");
		form.addField("nextOrderNo");
		form.addField("tmpDir");
	}
}
