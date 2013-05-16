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
package com.rcpcompany.uibindings.internal.decorators.extenders;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DecorationContext;
import org.eclipse.jface.viewers.IColorDecorator;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.IFontDecorator;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;

/**
 * This extender supports label decorations using
 * <code>PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator())</code>.
 * <p>
 * <em>NOTE:</em> Most methods and variables have default visibility for testing purposes.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class WorkbenchLabelDecoratorExtender extends AbstractUIBindingDecoratorExtender implements
		ILabelProviderListener {

	public WorkbenchLabelDecoratorExtender() {
		WORKBENCH_DECORATOR.addListener(this);
	}

	@Override
	public void dispose() {
		WORKBENCH_DECORATOR.removeListener(this);
		super.dispose();
	}

	@Override
	public boolean isEnabled(IValueBinding binding) {
		return binding.getArgument(Constants.ARG_LABEL_DECORATOR, Boolean.class, false);
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final EObject element = context.getBinding().getModelObject();
		// final Object element = context.getDecoratedValue().getValue();

		// Text

		final Image image = context.getImage();
		Image decorated = null;
		if (WORKBENCH_DECORATOR instanceof LabelDecorator) {
			decorated = ((LabelDecorator) WORKBENCH_DECORATOR).decorateImage(image, element, getDecorationContext());
		} else {
			decorated = WORKBENCH_DECORATOR.decorateImage(image, element);
		}
		if (decorated != null) {
			context.setImage(decorated);
		}

		if (WORKBENCH_DECORATOR instanceof IColorDecorator) {
			final Color foreground = ((IColorDecorator) WORKBENCH_DECORATOR).decorateForeground(element);
			if (foreground != null) {
				context.setForegound(foreground);
			}
			final Color background = ((IColorDecorator) WORKBENCH_DECORATOR).decorateBackground(element);
			if (background != null) {
				context.setBackgound(background);
			}
		}
		if (WORKBENCH_DECORATOR instanceof IFontDecorator) {
			final Font font = ((IFontDecorator) WORKBENCH_DECORATOR).decorateFont(element);
			if (font != null) {
				context.setFont(font);
			}
		}

	}

	/* package */static final ILabelDecorator WORKBENCH_DECORATOR = PlatformUI.getWorkbench().getDecoratorManager()
			.getLabelDecorator();

	/* package */final IDecorationContext myDecorationContext = DecorationContext.DEFAULT_CONTEXT;;

	/**
	 * Returns the decoration context associated with this label provider. It will be passed to the
	 * decorator if the decorator is an instance of {@link LabelDecorator}.
	 * 
	 * @return the decoration context associated with this label provider
	 */
	public IDecorationContext getDecorationContext() {
		return myDecorationContext;
	}

	@Override
	public void labelProviderChanged(LabelProviderChangedEvent event) {
		IManager.Factory.getManager().updateBindings(event.getElements());
	}
}
