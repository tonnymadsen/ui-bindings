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
