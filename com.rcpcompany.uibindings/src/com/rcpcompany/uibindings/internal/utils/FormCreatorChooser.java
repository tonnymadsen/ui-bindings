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
package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.widgets.Composite;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.utils.IFormChooser;
import com.rcpcompany.uibindings.utils.IFormChooser.IFormChooserTester;
import com.rcpcompany.uibindings.utils.IFormChooserCreator;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.uibindings.utils.IFormCreatorChooser;
import com.rcpcompany.uibindings.utils.IFormCreatorChooserCreator;

/**
 * The implementation of {@link IFormChooser}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FormCreatorChooser implements IFormCreatorChooser, IDisposable {

	protected final IFormCreator myForm;
	protected final IFormChooser myChooser;

	/**
	 * Constructs and returns a new chooser
	 * 
	 * @param form the form
	 * @param discriminant the discriminant
	 * @param top the top composite for the children
	 */
	public FormCreatorChooser(IFormCreator form, IObservableValue discriminant, Composite top) {
		myForm = form;
		myChooser = IFormChooser.Factory.create(form.getContext(), discriminant, top);
	}

	private IFormChooserCreator createCreator(final IFormCreatorChooserCreator creator) {
		return new IFormChooserCreator() {
			@Override
			public void createForm(IBindingContext context, IObservableValue discriminant, Composite parent) {
				final IFormCreator subForm = myForm.subForm(parent);
				creator.createForm(discriminant, subForm);
				subForm.finish();
			}
		};
	}

	@Override
	public void addForm(IFormChooserTester tester, IFormCreatorChooserCreator creator) {
		myChooser.addForm(tester, createCreator(creator));
	}

	@Override
	public void addFormEClass(EClass clz, IFormCreatorChooserCreator creator) {
		myChooser.addFormEClass(clz, createCreator(creator));
	}

	@Override
	public void addFormExactEClass(EClass clz, IFormCreatorChooserCreator creator) {
		myChooser.addFormExactEClass(clz, createCreator(creator));
	}

	@Override
	public void addFormInstanceof(Class<?> clz, IFormCreatorChooserCreator creator) {
		myChooser.addFormInstanceof(clz, createCreator(creator));

	}

	@Override
	public void addFormValue(Object value, IFormCreatorChooserCreator creator) {
		myChooser.addFormValue(value, createCreator(creator));
	}

	@Override
	public void dispose() {
		myChooser.dispose();
	}
}
