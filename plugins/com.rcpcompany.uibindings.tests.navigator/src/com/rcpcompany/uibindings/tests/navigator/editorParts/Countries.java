package com.rcpcompany.uibindings.tests.navigator.editorParts;

import org.eclipse.swt.SWT;

import com.rcpcompany.uibindings.navigator.FormEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * Editor Part for Countries.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class Countries extends FormEditorPartFactory implements IEditorPartFactory {
	@Override
	protected void createForm(IEditorPartContext context, IFormCreator form) {
		final ITableCreator table = form.addTableCreator(ShopPackage.Literals.SHOP__COUNTRIES, true, SWT.NONE);

		table.addColumn("name");
	}
}
