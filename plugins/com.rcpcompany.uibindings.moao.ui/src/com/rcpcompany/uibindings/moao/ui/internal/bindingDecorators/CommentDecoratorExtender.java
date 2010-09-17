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
package com.rcpcompany.uibindings.moao.ui.internal.bindingDecorators;


import org.eclipse.emf.ecore.*;
import org.eclipse.swt.graphics.*;

import com.rcpcompany.uibindings.*;
import com.rcpcompany.uibindings.decorators.extenders.*;
import com.rcpcompany.uibindings.moao.*;

/**
 * {@link IUIBindingDecoratorExtender} that decorates all fields with comments with a small corner image.
 */
public class CommentDecoratorExtender extends AbstractUIBindingDecoratorExtender implements IUIBindingDecoratorExtender {
  /**
   * The image to use for fields
   */
  public final Image cornerImage = UIBindingsUtils.getCornerImage(DecorationPosition.TOP_RIGHT, new RGB(0, 0, 255));

  @Override
  public boolean isEnabled(IValueBinding binding) {
    final EObject modelObject = binding.getModelObject();
    if (!(modelObject instanceof IMOAO)) {
      return false;
    }
    final IMOAO moao = (IMOAO) modelObject;

    final EStructuralFeature sf = binding.getModelFeature();
    if (sf == null) {
      return false;
    }

    for (final IMOAOMessage s : moao.getMessages()) {
      if (s.getSeverity() == Severity.COMMENT && s.getFeature() == sf) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void extend(IUIBindingDecoratorExtenderContext context) {
    context.setDecoratingImage(DecorationPosition.TOP_RIGHT, false, cornerImage, null);
  }
}
