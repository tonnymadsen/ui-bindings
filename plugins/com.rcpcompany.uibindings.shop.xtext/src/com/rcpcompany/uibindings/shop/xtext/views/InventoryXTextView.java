/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.shop.xtext.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.part.ViewPart;

import com.google.inject.Module;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.bindings.xtext.UIBXtextUtils;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IDnDSupport;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;
import com.rcpcompany.uibindings.xtext.tests.ui.SimpleDSLActivator;

/**
 * The inventory view with XText support.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class InventoryXTextView extends ViewPart {

	private Table myTable;
	private IFormCreator myForm;

	@Override
	public void createPartControl(Composite parent) {
		myForm = IFormCreator.Factory.createScrolledForm(
				ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain()), parent, "Inventory");

		final ITableCreator table = myForm.addTableCreator(ShopPackage.Literals.SHOP__SHOP_ITEMS, true,
				ITableCreator.FILTER | ITableCreator.RESIZE);
		table.addColumn("name(w=20em)");
		table.addColumn("price(w=10em)");

		final IFormCreator detailsForm = myForm.addSection("Details", table.getBinding().getSingleSelection());
		detailsForm.addObjectMessages();

		detailsForm.addField("name(w=20em)");
		detailsForm.addField("price(w=10em)");
		final IValueBinding advPriceBinding = UIBXtextUtils.createEditorBinding(detailsForm, "advancedPrice",
				getXTextInjectorModule());

		myForm.finish();
		IBindingContextSelectionProvider.Factory.adapt(myForm.getContext(), getSite());
		IDnDSupport.Factory.installOn(myForm.getContext());
	}

	private Module getXTextInjectorModule() {
		return SimpleDSLActivator.getInstance().getInjectorModule();
	}

	@Override
	public void setFocus() {
		myForm.setFocus();
	}
}
