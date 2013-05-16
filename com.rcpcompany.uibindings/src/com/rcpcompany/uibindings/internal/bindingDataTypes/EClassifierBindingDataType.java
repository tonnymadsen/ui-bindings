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

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IArgumentProvider;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.internal.BindingDataTypeImpl;

/**
 * {@link IBindingDataType} for {@link EClassifier}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EClassifierBindingDataType extends BindingDataTypeImpl {
	private final EClassifier myClass;

	/**
	 * Constructs and returns a new data type for the specified classifier.
	 * 
	 * @param cls the classifier
	 */
	public EClassifierBindingDataType(EClassifier cls) {
		myClass = cls;
	}

	@Override
	public Class<?> getDataType() {
		return myClass.getInstanceClass();
	}

	@Override
	public EAnnotation getEAnnotation() {
		return myClass.getEAnnotation(Constants.EMF_ANNOTATION_SOURCE);
	}

	@Override
	public IArgumentProvider getArgumentProvider(String type) {
		final IManager manager = IManager.Factory.getManager();
		manager.runModelArgumentMediators(myClass);
		return manager.getModelClassInfo(myClass.getInstanceClassName(), type, false);
	};

	@Override
	public Object getValueType() {
		return myClass;
	}

	@Override
	public EClassifier getEType() {
		return myClass;
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
