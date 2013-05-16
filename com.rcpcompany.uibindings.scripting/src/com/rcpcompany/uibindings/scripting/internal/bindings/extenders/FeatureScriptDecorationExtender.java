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
package com.rcpcompany.uibindings.scripting.internal.bindings.extenders;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.forms.IFormColors;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.scripting.IFeatureScript;
import com.rcpcompany.uibindings.scripting.internal.Activator;
import com.rcpcompany.uibindings.scripting.util.ScriptingUtils;

/**
 * Extender for Scriptable values.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FeatureScriptDecorationExtender extends AbstractUIBindingDecoratorExtender implements
		IUIBindingDecoratorExtender {

	private IFeatureScript myScript;

	@Override
	public boolean isEnabled(IValueBinding binding) {
		final IObservableValue ov = binding.getModelObservableValue();
		if (ov == null || ov.isDisposed())
			return false;
		if (!(binding.getModelObject() instanceof IMOAO))
			return false;
		final IMOAO moao = (IMOAO) binding.getModelObject();
		final EStructuralFeature feature = binding.getModelFeature();
		if (feature == null)
			return false;

		myScript = ScriptingUtils.getFeatureScript(moao, feature, false);
		return myScript != null;
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		context.setBackgound(IManager.Factory.getManager().getFormToolkit().getColors()
				.getColor(IFormColors.H_GRADIENT_START));
		if (Activator.getDefault().getShowScriptInBindings()) {
			context.setMessageFormat("=" + myScript.getScript());
		} else {
			context.setTooltip("=" + myScript.getScript());
		}
	}
}
