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

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IUIBindingDecorator;
import com.rcpcompany.uibindings.decorators.SimpleUIBindingDecorator;
import com.rcpcompany.utils.basic.ToStringUtils;

/**
 * Identity type decorator for {@link MOAO} objects.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MOAOIdentBD extends SimpleUIBindingDecorator implements IUIBindingDecorator {

	public MOAOIdentBD() {
	}

	/*
	 * At least for now.
	 */
	@Override
	public boolean isChangeable() {
		return false;
	}

	/**
	 * Returns the label for the class of specified object based on
	 * <ul>
	 * <li>the {@link IBindingDataType data type} {@link IBinding#ARG_LABEL}.</li>
	 * <li>a human readable version of the class name</li>
	 * </ul>
	 * 
	 * @param o the object
	 * @return the label
	 */
	protected String getClassLabel(Object o) {
		if (o == null) return "null";
		final Class<? extends Object> cls = o.getClass();

		// TODO: use IBindingObjectInformation
		final IBindingDataType dataType = IBindingDataType.Factory.create(cls);
		if (dataType != null) {
			final String l = dataType.getArgument(Constants.ARG_LABEL, getBinding().getType(), String.class, null);
			if (l != null) return l;
		}

		String l = cls.getSimpleName();
		if (o instanceof EObject && l.endsWith("Impl")) {
			l = l.substring(0, l.length() - 4);
		}
		return ToStringUtils.formatHumanReadable(l);
	}

	@Override
	protected Object convertModelToUI(Object fromObject) {
		if (fromObject == null) return "";

		// TODO TM implement
		// if(fromObject instanceof MOAO){
		// MOAO moao = (MOAO) fromObject;
		// String name = NamedObjectUtil.getScriptableName(moao);
		// return name;
		// }
		return fromObject.getClass().getSimpleName();
	}

	@Override
	protected Object convertUIToModel(Object fromObject) {
		return null;
	}
}
