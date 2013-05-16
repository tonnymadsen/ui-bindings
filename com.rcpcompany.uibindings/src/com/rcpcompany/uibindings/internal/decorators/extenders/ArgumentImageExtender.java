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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Extender that will add an image for a binding if known.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ArgumentImageExtender extends AbstractUIBindingDecoratorExtender {

	@Override
	public boolean isEnabled(IValueBinding binding) {
		if (binding.getParentBinding() != null && !binding.getArgument(Constants.ARG_SHOW_IMAGE, Boolean.class, false))
			return false;
		final Control control = binding.getControl();
		/*
		 * Forget about checkboxes and toggles, etc
		 */
		if (control instanceof Button) {
			if ((control.getStyle() & (SWT.CHECK | SWT.TOGGLE | SWT.RADIO)) != 0) return false;
		}
		final ImageDescriptor id = binding.getArgument(Constants.ARG_IMAGE, ImageDescriptor.class, null);
		return id != null;
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final IValueBinding binding = context.getBinding();
		final ImageDescriptor id = binding.getArgument(Constants.ARG_IMAGE, ImageDescriptor.class, null);
		if (id == null) return;

		final Image image = Activator.getDefault().getResourceManager().createImage(id);
		if (image == null) {
			LogUtils.error(binding, "Cannot create image for " + id);
			return;
		}

		context.setImage(image);
	}
}
