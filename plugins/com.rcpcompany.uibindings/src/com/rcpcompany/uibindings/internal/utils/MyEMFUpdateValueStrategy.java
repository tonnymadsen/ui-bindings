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

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.ecore.EAttribute;

/**
 * {@link UpdateValueStrategy} for EMF objects that simply normalizes the types before using the
 * normal {@link #createValidator(Object, Object)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MyEMFUpdateValueStrategy extends UpdateValueStrategy {
	/**
	 * Constructs a new strategy.
	 */
	public MyEMFUpdateValueStrategy() {
		this(true, POLICY_UPDATE);
	}

	/**
	 * Constructs a new strategy.
	 */
	public MyEMFUpdateValueStrategy(int updatePolicy) {
		this(true, updatePolicy);
	}

	/**
	 * Constructs a new strategy.
	 */
	public MyEMFUpdateValueStrategy(boolean provideDefaults, int updatePolicy) {
		super(provideDefaults, updatePolicy);
	}

	@Override
	protected IConverter createConverter(Object fromType, Object toType) {
		if (fromType instanceof EAttribute) {
			fromType = ((EAttribute) fromType).getEAttributeType().getInstanceClass();
		}
		if (toType instanceof EAttribute) {
			toType = ((EAttribute) toType).getEAttributeType().getInstanceClass();
		}
		return super.createConverter(fromType, toType);
	}
}
