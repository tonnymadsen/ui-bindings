/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;

/**
 * Implementation of {@link IBindingObjectInformation}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingObjectInformation implements IBindingObjectInformation {
	private final String myName;
	private final Image myImage;
	private final String myLabel;

	/**
	 * Constructs and returns a new name object for the specified object and binding type.
	 * 
	 * @param obj the object
	 * @param cls the class of the object
	 * @param type the binding type - defaults to {@link Constants#TYPE_LONG_NAME}
	 */
	public BindingObjectInformation(EObject obj, EClass cls, String type) {
		IBindingContext context;
		VirtualUIAttribute attribute;
		IValueBinding binding;

		if (type == null) {
			type = Constants.TYPE_LONG_NAME;
		}

		context = IBindingContext.Factory.createContext();

		attribute = new VirtualUIAttribute(String.class);
		final WritableValue value = new WritableValue(obj, cls);
		binding = context.addBinding().model(value).ui(attribute).type(type);

		context.finish();
		/*
		 * Need to provoke a run of all extenders...
		 */
		binding.updateBinding();

		myName = (String) attribute.getCurrentValue().getValue();
		myImage = (Image) attribute.getImageValue().getValue();
		myLabel = binding.getLabel();

		context.dispose();
	}

	@Override
	public String getName() {
		return myName;
	}

	@Override
	public Image getImage() {
		return myImage;
	}

	@Override
	public String getLabel() {
		return myLabel;
	}

	@Override
	public void dispose() {
	}
}
