/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.tests.shop.Contact;
import com.rcpcompany.uibindings.tests.shop.Customer;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopFactory;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IDnDSupport;

public class CBasic extends ViewPart {

	public CBasic() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {

		// Controls

		final Composite top = new Composite(parent, SWT.NONE);
		top.setLayout(new GridLayout(2, false));

		final Label countryLabel = new Label(top, SWT.NONE);
		countryLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		countryLabel.setText("Country:");

		final Combo combo = new Combo(top, SWT.DROP_DOWN);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Table table = new Table(top, SWT.SINGLE | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn orderPriceColumn = new TableColumn(table, SWT.LEAD);
		orderPriceColumn.setWidth(100);

		// Bindings

		final IBindingContext context = IBindingContext.Factory.createContext(top);

		final Shop shop = ShopFactory.eINSTANCE.getShop(EditingDomainUtils.getEditingDomain());

		final Customer customer = shop.getCustomers().get(0);
		final Contact contact = customer.getContact();

		context.addBinding(combo, contact, ShopPackage.Literals.CONTACT__COUNTRY).validValues(shop,
				ShopPackage.Literals.SHOP__COUNTRIES);
		final IViewerBinding viewer = context.addViewer(table, customer, ShopPackage.Literals.CUSTOMER__ORDERS);
		viewer.addColumn(orderPriceColumn, ShopPackage.Literals.ORDER__PRICE);

		context.finish();
		IBindingContextSelectionProvider.Factory.adapt(context, getSite());
		IDnDSupport.Factory.installOn(context);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
