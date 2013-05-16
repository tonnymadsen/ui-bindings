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
package com.rcpcompany.uibindings.navigator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IDnDSupport;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * {@link IEditorPartFactory} aimed at editor parts designed with SWT Designer.
 * 
 * @author Tonny Madsen, The RCP Company
 */

public abstract class SWTDesignerEditorPartFactory extends ViewPart implements IEditorPartFactory {
	/**
	 * True if a scrolled form header should be created for the editor. To be moved to a utility
	 * class. And a preference.
	 */
	final boolean myCreateScrolledForm = false;

	/**
	 * The editor part context for this factory.
	 */
	private IEditorPartContext myEditorPartContext;

	/**
	 * Returns the editor part context for this factory.
	 * 
	 * @return the context
	 */
	public IEditorPartContext getEditorPartContext() {
		return myEditorPartContext;
	}

	/**
	 * Sets the object of the editor
	 */
	public abstract void setObject(EObject obj);

	@Override
	public abstract void createPartControl(Composite parent);

	/**
	 * Binds any controls in the editor using the specified context.
	 * 
	 * @param context the context to use for binding
	 */
	public abstract void bindControls(IBindingContext context);

	@Override
	public IEditorPart createEditorPart(IEditorPartContext context) {
		myEditorPartContext = context;

		final IBindingContext bindingContext;
		final IEditorPart part;

		if (myCreateScrolledForm) {
			final IFormCreator form;
			form = IFormCreator.Factory.createScrolledForm(context.getCurrentValue(), context.getParent(), context
					.getDescriptor().getName());
			form.getContext().addBinding().ui(form.getScrolledForm()).model(context.getCurrentValue())
					.arg(Constants.ARG_MESSAGE_FORMAT, "{0} - " + context.getDescriptor().getName()).readonly();
			bindingContext = form.getContext();

			setObject((EObject) context.getCurrentValue().getValue());
			createPartControl(form.addComposite(true, true));
			bindControls(bindingContext);
			form.finish();

			part = new FormEditorPart(form);
		} else {
			bindingContext = IBindingContext.Factory.createContext(context.getParent());

			setObject((EObject) context.getCurrentValue().getValue());
			createPartControl(context.getParent());
			bindControls(bindingContext);
			bindingContext.finish();

			part = new EditorPart(bindingContext);
		}

		/*
		 * IBindingContextSelectionProvider is automatically disposed with the context..
		 */
		IBindingContextSelectionProvider.Factory.adapt(bindingContext, context.getWorkbenchPart().getSite());
		IDnDSupport.Factory.installOn(bindingContext);
		return part;
	}

	@Override
	public void setFocus() {
	}

	/**
	 * {@link IEditorPart} used for {@link FormEditorPartFactory} and sub-classes.
	 */
	public final class FormEditorPart extends AbstractEditorPart {
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

		@Override
		public boolean canAcceptObjectChanges() {
			return SWTDesignerEditorPartFactory.this.canAcceptObjectChanges();
		}
	}

	/**
	 * {@link IEditorPart} used for {@link FormEditorPartFactory} and sub-classes.
	 */
	public final class EditorPart extends AbstractEditorPart {
		private final IBindingContext myContext;

		/**
		 * Constructs and returns a new part for the specified form.
		 * 
		 * @param context the form
		 */
		public EditorPart(IBindingContext context) {
			myContext = context;
		}

		@Override
		public void dispose() {
			myContext.dispose();
		}

		@Override
		public boolean canAcceptObjectChanges() {
			return SWTDesignerEditorPartFactory.this.canAcceptObjectChanges();
		}
	}

	/**
	 * Returns whether this editor can accept changes in the object of the editor without
	 * re-creating the editor.
	 * <p>
	 * Some editors - e.g. the generic one - build the UI based on the current object and these
	 * cannot easily accept changes in the object as the UI is not changed in the same moment.
	 * 
	 * @return <code>true</code> if the object can be changed
	 */
	public boolean canAcceptObjectChanges() {
		return false;
	}
}
