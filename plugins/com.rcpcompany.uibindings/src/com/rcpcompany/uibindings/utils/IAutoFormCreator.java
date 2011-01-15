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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.AutoFormCreator;

/**
 * This utility class is used to create complete forms based on the structure of data.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IAutoFormCreator extends IDisposable {
	/**
	 * The factory methods for {@link IAutoFormCreator}.
	 */
	final class Factory {
		private Factory() {
		}

		/**
		 * Creates a new super form with the specified parent.
		 * 
		 * @param context the binding context to use
		 * @param obj the current object
		 * @param toolkit the {@link FormToolkit} to use
		 * @param parent the parent composite of the new form
		 * @return the created form creator
		 */
		// public static IAutoFormCreator createForm(IBindingContext context, EObject obj,
		// FormToolkit toolkit,
		// Composite parent) {
		// return new AutoFormCreator(context, obj, toolkit, parent, null);
		// }

		/**
		 * Creates a new form with the specified parent.
		 * 
		 * @param value the value for the form
		 * @param title the title of the form
		 * @param parent the parent composite
		 * @param part part for the form
		 * 
		 * @return the created form creator
		 */
		public static IAutoFormCreator createForm(IObservableValue value, String title, Composite parent,
				IWorkbenchPart part) {
			return new AutoFormCreator(value, title, parent, part);
		}

		/**
		 * Creates a new form with the specified parent.
		 * 
		 * @param parent the parent composite of the new form
		 * @return the created form creator
		 */
		// public static ISuperFormCreator createForm(EObject obj, IWizardPage page) {
		// }
	}

	/**
	 * The form creator used for the creation of the underlying form.
	 * 
	 * @return form creator
	 */
	IFormCreator getForm();
}
