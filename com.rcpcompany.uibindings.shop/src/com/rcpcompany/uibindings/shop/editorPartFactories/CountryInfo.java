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
package com.rcpcompany.uibindings.shop.editorPartFactories;

import com.rcpcompany.uibindings.navigator.FormEditorPartFactory;
import com.rcpcompany.uibindings.navigator.IEditorPartContext;
import com.rcpcompany.uibindings.navigator.IEditorPartFactory;
import com.rcpcompany.uibindings.tests.shop.Country;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * {@link IEditorPartFactory} for one {@link Country}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CountryInfo extends FormEditorPartFactory implements IEditorPartFactory {
	@Override
	protected void createForm(IEditorPartContext context, IFormCreator form) {
		form.addField("name(w=200)");
		form.addField("abbreviation(w=100)");

		form.addField("information.population(w=100)");
		form.addField("information.currency(w=100)");
	}
}
