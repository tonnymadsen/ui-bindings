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
package com.rcpcompany.uibindings.internal.controlFactories;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.rcpcompany.uibindings.IControlFactory;
import com.rcpcompany.uibindings.IControlFactoryContext;
import com.rcpcompany.uibindings.IManager;

/**
 * {@link IControlFactory} that creates check box buttons.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CheckBoxControlFactory implements IControlFactory {

	@Override
	public Control create(IControlFactoryContext context) {
		final FormToolkit toolkit = IManager.Factory.getManager().getFormToolkit();
		/*
		 * Remove SWT.READ_ONLY as it also means SWT.PUSH.
		 */
		int s = context.getStyle() & ~(SWT.READ_ONLY);
		/*
		 * Remove BORDER as it doesn't look right
		 */
		s = s & ~(SWT.BORDER);
		final Control button = toolkit.createButton(context.getParent(), "", s | SWT.CHECK);
		if ((context.getStyle() & SWT.READ_ONLY) == SWT.READ_ONLY) {
			button.setEnabled(false);
		}

		return button;
	}

}
