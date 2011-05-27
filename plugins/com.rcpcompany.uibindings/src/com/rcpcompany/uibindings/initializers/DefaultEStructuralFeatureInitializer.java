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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.participants.IInitializationParticipant;
import com.rcpcompany.uibindings.participants.IInitializationParticipantContext;

/**
 * Default object initializer for {@link EReference structural features}.
 * <p>
 * If the feature in question is required, it is created if possible.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DefaultEStructuralFeatureInitializer implements IInitializationParticipant {

	@Override
	public void initialize(IInitializationParticipantContext context, Object facet) {
		if (!(facet instanceof EReference)) return;
		final EReference ref = (EReference) facet;
		if (!ref.isRequired() || ref.isContainer()) return;

		final EObject object = context.getObject();

		if (ref.getUpperBound() != 1) {
			/*
			 * A list
			 */
			@SuppressWarnings("unchecked")
			final EList<? extends EObject> l = (EList<? extends EObject>) context.getStructuralFeature(ref);
			int missing = ref.getLowerBound() - l.size();
			if (missing < 0) return;

			final List<EObject> newChildren = new ArrayList<EObject>(missing);
			for (; missing > 0; missing--) {
				final EObject newChild = EcoreUtil.create(ref.getEReferenceType());
				context.addCommand(IManager.Factory.getManager().initializeObject(context.getEditingDomain(), object,
						ref, newChild, false));
			}
			context.addCommand(AddCommand.create(context.getEditingDomain(), object, ref, newChildren));
		} else {
			/*
			 * Simple object
			 */
			final Object o = context.getStructuralFeature(ref);
			if (o != null) return;

			final EObject newChild = EcoreUtil.create(ref.getEReferenceType());
			context.addCommand(IManager.Factory.getManager().initializeObject(context.getEditingDomain(), object, ref,
					newChild, true));
		}
	}
}
