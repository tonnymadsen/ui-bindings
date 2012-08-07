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
package com.rcpcompany.uibindings.shop.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.SpecialBinding;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IDnDSupport;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * The customer view of the shop application.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CustomerGroupsView extends ViewPart {

	private IFormCreator myForm;

	@Override
	public void createPartControl(Composite parent) {
		final Shop shop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());
		myForm = IFormCreator.Factory.createScrolledForm(shop, parent, "Customers");

		final ITableCreator table = myForm.addTableCreator(ShopPackage.Literals.SHOP__CUSTOMER_GROUPS, true,
				ITableCreator.FILTER);
		table.addColumn(SpecialBinding.ROW_NO, 40);
		table.addColumn("name(w=100)");

		final IFormCreator detailsSection = myForm.addSection("Element", table.getBinding().getSingleSelection());

		final ITableCreator ctable = detailsSection.addTableCreator(ShopPackage.Literals.CUSTOMER_GROUP__CUSTOMERS,
				false, SWT.NONE);
		ctable.addColumn("contact.name(w=200)");

		myForm.finish();
		IBindingContextSelectionProvider.Factory.adapt(myForm.getContext(), getSite());
		IDnDSupport.Factory.installOn(myForm.getContext());
	}

	@Override
	public void setFocus() {
		myForm.setFocus();
	}
}
