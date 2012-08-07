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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IDnDSupport;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * Simple view to show some very basic information about the {@link Shop}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShopNumbersView extends ViewPart {

	private IFormCreator myForm;

	@Override
	public void createPartControl(Composite parent) {
		myForm = IFormCreator.Factory.createScrolledForm(
				ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain()), parent, "Shop Numbers");

		myForm.addField("name");
		myForm.addField("nextOrderNo");
		myForm.addField("nextCustomerNo");
		myForm.addField("tmpDir");

		myForm.finish();
		IBindingContextSelectionProvider.Factory.adapt(myForm.getContext(), getSite());
		IDnDSupport.Factory.installOn(myForm.getContext());
	}

	@Override
	public void setFocus() {
		myForm.setFocus();
	}
}
