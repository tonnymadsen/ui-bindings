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
package com.rcpcompany.uibindings.navigator;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * {@link IEditorPartFactory} aimed at {@link IFormCreator} based editor parts.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class FormEditorPartFactory extends AbstractEditorPartFactory implements IEditorPartFactory {
	@Override
	public final IEditorPart createEditorPart(IEditorPartContext context) {
		final IFormCreator form = IFormCreator.Factory.createScrolledForm(context.getCurrentValue(),
				context.getParent(), context.getDescriptor().getName());
		form.getContext().addBinding().ui(form.getScrolledForm()).model(context.getCurrentValue())
				.arg(Constants.ARG_MESSAGE_FORMAT, "{0} - " + context.getDescriptor().getName()).readonly();
		createForm(context, form);
		form.finish();

		/*
		 * IBindingContextSelectionProvider is automatically disposed with the context..
		 */
		IBindingContextSelectionProvider.Factory.adapt(form.getContext(), context.getWorkbenchPart().getSite());
		return new FormEditorPart(form);
	}

	/**
	 * {@link IEditorPart} used for {@link FormEditorPartFactory} and sub-classes.
	 */
	public final class FormEditorPart implements IEditorPart {
		private final IFormCreator myForm;

		/**
		 * Returns the form of this part.
		 * 
		 * @return the form
		 */
		public IFormCreator getForm() {
			return myForm;
		}

		/**
		 * Constructs and returns a new part for the specified form.
		 * 
		 * @param form the form
		 */
		public FormEditorPart(IFormCreator form) {
			myForm = form;
		}

		@Override
		public void dispose() {
			myForm.dispose();
		}
	}

	/**
	 * Creates the content of the editor part based on a {@link IFormCreator}.
	 * 
	 * @param context the context
	 * @param form the form
	 */
	protected abstract void createForm(IEditorPartContext context, IFormCreator form);
}
