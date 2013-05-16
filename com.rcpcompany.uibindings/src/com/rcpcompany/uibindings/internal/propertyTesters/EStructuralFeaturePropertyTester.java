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
package com.rcpcompany.uibindings.internal.propertyTesters;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Property tester for {@link EStructuralFeature}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EStructuralFeaturePropertyTester extends PropertyTester {
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
			LogUtils.debug(this, Constants.PREFIX + property + "(" + receiver + ")");
		}
		if (!(receiver instanceof EStructuralFeature)) {
			LogUtils.error(this, "Receiver not EStructuralFeature: " + receiver);
			return false;
		}
		final EStructuralFeature sf = (EStructuralFeature) receiver;

		if (Constants.PROPERTY_HAS_DEFAULT_VALUE.equals(property)) {
			final boolean res = sf.getDefaultValueLiteral() != null;
			if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
				LogUtils.debug(this, "->> " + res);
			}
			return res;
		} else if (Constants.PROPERTY_HAS_TYPE.equals(property)) {
			if (args.length == 0) {
				LogUtils.error(this, "Missing arguments for " + Constants.PREFIX + property);
				return false;
			}
			final Class<?> instanceClass = sf.getEType().getInstanceClass();
			final Class<?>[] sfTypeOrder = Platform.getAdapterManager().computeClassOrder(instanceClass);

			for (final Object s : args) {
				for (final Class<?> c : sfTypeOrder) {
					if (c.getName().equals(s)) {
						if (Activator.getDefault().TRACE_PROPERTY_TESTERS) {
							LogUtils.debug(this, "->> true (" + instanceClass.getName() + " has super-class " + s + ")");
						}
						return true;
					}
				}
			}
			return false;
		}

		return false;
	}
}
