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
package com.rcpcompany.uibindings.navigator.internal.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.navigator.INavigatorManager;

/**
 * {@link PropertyTester} for {@link EObject}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EObjectPropertyTester extends PropertyTester {
	private final INavigatorManager manager = INavigatorManager.Factory.getManager();

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (!(receiver instanceof EObject)) return false;
		final EObject obj = (EObject) receiver;

		if (property.equals("hasEditorPartDescriptor")) return manager.getEditorPartDescriptor(obj) != null;

		return false;
	}
}
