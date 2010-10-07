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
package com.rcpcompany.uibindings.internal.decorators.extenders;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.forms.IFormColors;

import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;

/**
 * Extender that will mark a binding as "default" if the model attribute is an unsettable primitive.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class UnsettableExtender extends AbstractUIBindingDecoratorExtender {

	@Override
	public boolean isEnabled(IValueBinding binding) {
		final IBindingDataType dataType = binding.getDataType();
		return dataType.isUnsettable();
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		final IValueBinding binding = context.getBinding();
		final IBindingDataType dataType = binding.getDataType();
		if (!dataType.isUnsettable()) return;

		if (!dataType.getDataType().isPrimitive()) return;

		final EObject obj = binding.getModelObject();
		final EStructuralFeature feature = binding.getModelFeature();
		if (obj == null || feature == null) return;

		if (!obj.eIsSet(feature)) {
			context.setBackgound(IManager.Factory.getManager().getFormToolkit().getColors()
					.getColor(IFormColors.H_GRADIENT_START));
			context.appendTooltip("[Set to Default]");
//			context.setEnabled(false);
//			context.setMessageFormat("Default");
		}
	}
}
