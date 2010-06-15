package com.rcpcompany.uibindings.internal.decorators;

import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;
import com.rcpcompany.utils.basic.ClassUtils;

public class GenericClassNameDecorator extends SimpleUIBindingDecorator implements IUIBindingDecorator {

	public GenericClassNameDecorator() {
	}

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

		return ClassUtils.getLastClassName(cls.getName());
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		return null;
	}
}
