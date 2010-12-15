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
package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * The abstract common implementation of {@link IEMFObservableFactory}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractEMFObservableFactory implements IEMFObservableFactory {
	@Override
	public abstract IObservableList observeList(Realm realm, EditingDomain editingDomain, EObject object,
			EStructuralFeature structuralFeature);

	@Override
	public abstract IObservableValue observeValue(Realm realm, EditingDomain editingDomain, EObject object,
			EStructuralFeature structuralFeature);
}
