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
package com.rcpcompany.uibindings.shop.editorPartFactories;

import org.eclipse.swt.SWT;

import com.rcpcompany.uibindings.navigator.FormEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.tests.shop.Shop;
import com.rcpcompany.uibindings.tests.shop.ShopPackage;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.ITableCreator;

/**
 * {@link IEditorPartFactory} for the countries of a {@link Shop}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ShopCountries extends FormEditorPartFactory implements IEditorPartFactory {
	@Override
	protected void createForm(IEditorPartContext context, IFormCreator form) {
		final ITableCreator table = form.addTableCreator(ShopPackage.Literals.SHOP__COUNTRIES, true, SWT.NONE);

		table.addColumn("name(w=200)");
		table.addColumn("abbreviation(w=100)");
	}
}
