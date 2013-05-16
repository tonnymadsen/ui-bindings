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
package com.rcpcompany.uibindings.shop.bindings;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;

import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.tests.shop.Contact;

/**
 * Extender for {@link Contact#getName()}.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class ContactExtender extends AbstractUIBindingDecoratorExtender implements IUIBindingDecoratorExtender {

	@Override
	public boolean isEnabled(IValueBinding binding) {
		return binding.isEClassFeature(null, IMOAOPackage.Literals.NAMED_OBJECT__NAME);
	}

	private final Image cornerImage = UIBindingsUtils.getCornerImage(DecorationPosition.BOTTOM_RIGHT, new RGB(0, 255,
			255));

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final EObject value = context.getBinding().getModelObject();
		if (!(value instanceof Contact)) return;

		final Contact c = (Contact) value;
		if (c.getCustomer() != null) {
			context.setDecoratingImage(DecorationPosition.BOTTOM_RIGHT, false, cornerImage, "Contact is a customer");
		}
	}
}
