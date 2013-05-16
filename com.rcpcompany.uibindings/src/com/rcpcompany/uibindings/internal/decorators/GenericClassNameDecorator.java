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
package com.rcpcompany.uibindings.internal.decorators;

import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;
import com.rcpcompany.utils.basic.ClassUtils;

public class GenericClassNameDecorator extends SimpleUIBindingDecorator implements IUIBindingDecorator {

	@Override
	public boolean isChangeable() {
		return false;
	}

	@Override
	protected Object convertModelToUI(Object fromObject) {
		if (fromObject == null) return "<null>";
		Class<?> cls;
		if (fromObject instanceof Class<?>) {
			cls = (Class<?>) fromObject;
		} else {
			cls = fromObject.getClass();
		}

		return ClassUtils.getLastClassName(cls);
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		return null;
	}
}
