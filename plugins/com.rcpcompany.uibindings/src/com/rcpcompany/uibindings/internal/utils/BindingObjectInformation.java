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
package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.uiAttributes.VirtualUIAttribute;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;

/**
 * Implementation of {@link IBindingObjectInformation}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingObjectInformation implements IBindingObjectInformation {
	private final EObject myObj;
	private IBindingContext myContext;
	private VirtualUIAttribute myAttribute;

	/**
	 * Constructs and returns a new name object for the specified object and binding type.
	 * 
	 * @param obj the object
	 * @param type the binding type - defaults to {@link Constants#TYPE_LONG_NAME}
	 */
	public BindingObjectInformation(EObject obj, String type) {
		myObj = obj;
		if (myObj != null) {
			if (type == null) {
				type = Constants.TYPE_LONG_NAME;
			}

			myContext = IBindingContext.Factory.createContext();

			myAttribute = new VirtualUIAttribute(String.class);
			final WritableValue value = new WritableValue(myObj, myObj.eClass());
			myContext.addBinding().model(value).ui(myAttribute).type(type);

			myContext.finish();
		}
	}

	@Override
	public String getName() {
		if (myContext == null) return "<null>";
		return (String) myAttribute.getCurrentValue().getValue();
	}

	@Override
	public Image getImage() {
		if (myContext == null) return null;
		return (Image) myAttribute.getImageValue().getValue();
	}

	@Override
	public void dispose() {
		if (myContext != null) {
			myContext.dispose();
			myContext = null;
		}
	}
}
