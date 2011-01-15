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
package com.rcpcompany.uibindings.utils;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.widgets.Composite;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.FormCreatorChooser;
import com.rcpcompany.uibindings.utils.IFormChooser.IFormChooserTester;

/**
 * This interface is used to ease the creating of forms based on the value of a field.
 * <p>
 * The field is named the discriminant in the chooser and a number of forms is added that will test
 * the current value of the discriminant and based on the result create a new form in the specified
 * top {@link Composite}.
 * <p>
 * Please note that the top {@link Composite} will be cleaned completely of all children every time
 * a new form is created.
 * 
 * @author Tonny Madsen, The RCP Company
 * @noimplement
 */
public interface IFormCreatorChooser extends IDisposable {
	final class Factory {
		private Factory() {

		}

		/**
		 * Constructs and returns a new form creator.
		 * 
		 * @param context the context
		 * @param discriminant the discriminant used to decide on the chosen form
		 * @param top the top level {@link Composite} that will parent all forms created by the
		 *            chooser
		 * @return the returned form
		 */
		public static IFormCreatorChooser create(IFormCreator form, IObservableValue discriminant) {
			return create(form, discriminant, form.addComposite(true, true));
		}

		/**
		 * Constructs and returns a new form creator.
		 * 
		 * @param context the context
		 * @param object the object with the feature used to choose the form
		 * @param feature the feature for the form
		 * @param top the top level {@link Composite} that will parent all forms created by the
		 *            chooser
		 * @return the returned form
		 */
		public static IFormCreatorChooser create(IFormCreator form, IObservableValue discriminant, Composite top) {
			return new FormCreatorChooser(form, discriminant, top);
		}
	}

	/**
	 * Adds a new form to this chooser, that will be choosen if the tester evaluates
	 * <code>true</code> for the current discriminant value.
	 * 
	 * @param tester the test object
	 * @param creator the forms creator
	 */
	void addForm(IFormChooserTester tester, IFormCreatorChooserCreator creator);

	/**
	 * Adds a new form to this chooser, that will be chosen if the value of the discriminant equals
	 * the specified value.
	 * 
	 * @param value the value
	 * @param creator the forms creator
	 */
	void addFormValue(Object value, IFormCreatorChooserCreator creator);

	/**
	 * Adds a new form to this chooser, that will be chosen if the value of the discriminant is an
	 * instance of the specified class.
	 * 
	 * @param clz the class
	 * @param creator the forms creator
	 */
	void addFormInstanceof(Class<?> clz, IFormCreatorChooserCreator creator);

	/**
	 * Adds a new form to this chooser, that will be chosen if the value of the discriminant has the
	 * specified EClass.
	 * 
	 * @param clz the class
	 * @param creator the forms creator
	 */
	void addFormExactEClass(EClass clz, IFormCreatorChooserCreator creator);

	/**
	 * Adds a new form to this chooser, that will be chosen if the value of the discriminant is an
	 * instance of the specified EClass.
	 * 
	 * @param clz the class
	 * @param creator the forms creator
	 */
	void addFormEClass(EClass clz, IFormCreatorChooserCreator creator);
}
