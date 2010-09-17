/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.shop.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * The contacts view.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ContactsView extends ViewPart {

	private IFormCreator myForm;

	@Override
	public void createPartControl(Composite parent) {
		final Shop shop = ShopFactory.eINSTANCE.getShop(IManager.Factory.getManager().getEditingDomain());
		myForm = IFormCreator.Factory.createScrolledForm(shop, parent, "Contacts");

		final ITableCreator orderTable = myForm.addTableCreator(ShopPackage.Literals.SHOP__CONTACTS, true,
				ITableCreator.FILTER | ITableCreator.RESIZE);

		orderTable.addColumn("__ROW_NO__(w=30)");
		orderTable.addColumn("name(w=100, ww=200)");
		orderTable.addColumn("city(w=100)");
		orderTable.addColumn("country(w=100)");
		orderTable.addColumn("newsletter(w=60,ww=0)");
		orderTable.addColumn("birthday(w=150)");

		final IFormCreator detailsSection = myForm.addSection("Details", orderTable.getBinding().getSingleSelection(),
				true);
		detailsSection.addObjectMessages();

		detailsSection.addField("name");

		myForm.finish();
		IBindingContextSelectionProvider.Factory.adapt(myForm.getContext(), getSite());
	}

	@Override
	public void setFocus() {
		myForm.setFocus();
	}
}
