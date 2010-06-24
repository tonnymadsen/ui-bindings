package com.rcpcompany.uibindings.shop.editorPartFactories;

import com.rcpcompany.uibindings.navigator.FormEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * {@link IEditorPartFactory} for basic {@link Shop} information.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShopBasicInformation extends FormEditorPartFactory implements IEditorPartFactory {

	@Override
	protected void createForm(IEditorPartContext context, IFormCreator form) {
		form.addField("name");
		form.addField("nextOrderNo");
		form.addField("tmpDir");
	}

}
