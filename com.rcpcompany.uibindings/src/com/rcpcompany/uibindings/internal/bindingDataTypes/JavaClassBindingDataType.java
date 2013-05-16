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
package com.rcpcompany.uibindings.internal.bindingDataTypes;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;

import com.rcpcompany.uibindings.IArgumentProvider;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.BindingDataTypeImpl;

/**
 * {@link IBindingDataType} for plain Java {@link Class}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class JavaClassBindingDataType extends BindingDataTypeImpl {

	private final Class<?> myClass;

	/**
	 * Constructs and returns a new data type for the specified class.
	 * 
	 * @param cls the class
	 */
	public JavaClassBindingDataType(Class<?> cls) {
		myClass = cls;
	}

	@Override
	public Class<?> getDataType() {
		return myClass;
	}

	@Override
	public EAnnotation getEAnnotation() {
		return null;
	}

	@Override
	public IArgumentProvider getArgumentProvider(String type) {
		return IManager.Factory.getManager().getModelClassInfo(myClass.getName(), type, false);
	};

	@Override
	public Object getValueType() {
		return myClass;
	}

	@Override
	public EClassifier getEType() {
		return null;
	}

	@Override
	public String getName() {
		return myClass.getName();
	}

	@Override
	public String getBaseType() {
		return myClass.getName();
	}
}
