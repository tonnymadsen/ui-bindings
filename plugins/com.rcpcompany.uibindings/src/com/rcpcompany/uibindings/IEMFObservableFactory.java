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
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * This interface is used to create EMF based observables.
 * <p>
 * The interface is used to allow observables to respect an editing domain for an EMF based model.
 * Implementations of this interface is defined via the com.rcpcompany.uibindings.uibindings/
 * <p>
 * The default implementation just delegates the creation to {@link EMFObservables}.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IEMFObservableFactory {
	/**
	 * Returns an observable value for the given feature of the object.
	 * <p>
	 * {@link IObservableValue#getValueType()} of the observable value must return
	 * <code>eStructuralFeature.getEType().getInstanceClass()</code>.
	 * 
	 * @param realm the realm in which to observe.
	 * @param editingDomain the editing domain to use or <code>null</code> to use the default from
	 *            {@link IManager}
	 * @param eObject the object to observe.
	 * @param eStructuralFeature the feature of the object to observe.
	 * 
	 * @return an observable value for the given feature of the object.
	 */
	IObservableValue observeValue(Realm realm, EditingDomain editingDomain, EObject eObject,
			EStructuralFeature eStructuralFeature);

	/**
	 * Returns an observable list for the given multi-valued feature of the object.
	 * <p>
	 * {@link IObservableList#getElementType()} of the observable value must return
	 * <code>eStructuralFeature.getEType().getInstanceClass()</code>.
	 * 
	 * @param realm the realm in which to observe.
	 * @param editingDomain the editing domain to use or <code>null</code> to use the default from
	 *            {@link IManager}
	 * @param eObject the object to observe.
	 * @param eStructuralFeature the feature of the object to observe.
	 * @return an observable list for the given multi-valued feature of the object.
	 */
	IObservableList observeList(Realm realm, EditingDomain editingDomain, EObject eObject,
			EStructuralFeature eStructuralFeature);
}
