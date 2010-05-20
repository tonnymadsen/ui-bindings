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
 * @since 1.3
 */
public abstract class AbstractEMFObservableFactory implements IEMFObservableFactory {
	@Override
	public abstract IObservableList observeList(Realm realm, EditingDomain editingDomain, EObject object,
			EStructuralFeature structuralFeature);

	@Override
	public abstract IObservableValue observeValue(Realm realm, EditingDomain editingDomain, EObject object,
			EStructuralFeature structuralFeature);
}
