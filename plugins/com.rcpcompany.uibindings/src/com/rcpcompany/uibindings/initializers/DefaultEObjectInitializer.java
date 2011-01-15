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
package com.rcpcompany.uibindings.initializers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.participants.IInitializationParticipant;
import com.rcpcompany.uibindings.participants.IInitializationParticipantContext;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Default object initializer for {@link EObject}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DefaultEObjectInitializer implements IInitializationParticipant {

	@Override
	public void initialize(IInitializationParticipantContext context, Object facet) {
		if (!(facet instanceof EClass)) return;
		final EClass cls = (EClass) facet;

		for (final EStructuralFeature sf : cls.getEAllStructuralFeatures()) {
			final IBindingDataType dt = IBindingDataType.Factory.create(context.getObject().eClass(), sf);

			final IInitializationParticipant initializer = dt.getArgument(Constants.ARG_INITIALIZER, null,
					IInitializationParticipant.class, null);
			if (initializer != null) {
				try {
					initializer.initialize(context, sf);
				} catch (final Exception ex) {
					LogUtils.error(initializer, ex);
				}
			}
		}
	}
}
