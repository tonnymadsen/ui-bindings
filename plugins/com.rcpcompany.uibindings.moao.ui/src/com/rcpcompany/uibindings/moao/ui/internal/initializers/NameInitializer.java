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
package com.rcpcompany.uibindings.moao.ui.internal.initializers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.moao.INamedObject;
import com.rcpcompany.uibindings.participants.IInitializationParticipant;
import com.rcpcompany.uibindings.participants.IInitializationParticipantContext;
import com.rcpcompany.uibindings.utils.IBindingObjectInformation;

/**
 * Initializer for {@link INamedObject#getName()}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NameInitializer implements IInitializationParticipant {
	private static int lastNo = 0;

	@Override
	public void initialize(IInitializationParticipantContext context, Object facet) {
		final EObject obj = context.getObject();
		final EStructuralFeature sf = (EStructuralFeature) facet;
		final String label = IBindingObjectInformation.Factory.getLabel(obj.eClass());

		// TODO: possibly use validValues to check for exiting objects

		context.setStructuralFeature(sf, label + (lastNo++));
	}
}
