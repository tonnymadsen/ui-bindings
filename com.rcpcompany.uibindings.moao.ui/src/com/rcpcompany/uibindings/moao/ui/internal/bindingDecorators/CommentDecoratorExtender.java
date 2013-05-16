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
package com.rcpcompany.uibindings.moao.ui.internal.bindingDecorators;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;

import com.rcpcompany.uibindings.DecorationPosition;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.decorators.extenders.AbstractUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.IMOAOFacet;
import com.rcpcompany.uibindings.moao.IMOAOMessage;
import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.Severity;

/**
 * {@link IUIBindingDecoratorExtender} that decorates all fields with comments with a small corner
 * image.
 */
public class CommentDecoratorExtender extends AbstractUIBindingDecoratorExtender implements IUIBindingDecoratorExtender {
	/**
	 * The image to use for fields.
	 */
	public final Image cornerImage = UIBindingsUtils.getCornerImage(DecorationPosition.TOP_RIGHT, new RGB(0, 0, 255));

	@Override
	public boolean isEnabled(IValueBinding binding) {
		final EObject modelObject = binding.getModelObject();
		if (!(modelObject instanceof IMOAO)) return false;
		final IMOAO moao = (IMOAO) modelObject;

		final EStructuralFeature sf = binding.getModelFeature();
		if (sf == null) return false;

		if (!moao.eIsSet(IMOAOPackage.Literals.MOAO__FACETS)) return false;
		for (final IMOAOFacet f : moao.getFacets()) {
			if (!(f instanceof IMOAOMessage)) {
				continue;
			}
			final IMOAOMessage s = (IMOAOMessage) f;
			if (s.getSeverity() == Severity.COMMENT && s.getFeature() == sf) return true;
		}
		return false;
	}

	@Override
	public void extend(IUIBindingDecoratorExtenderContext context) {
		context.setDecoratingImage(DecorationPosition.TOP_RIGHT, false, cornerImage, null);
	}
}
