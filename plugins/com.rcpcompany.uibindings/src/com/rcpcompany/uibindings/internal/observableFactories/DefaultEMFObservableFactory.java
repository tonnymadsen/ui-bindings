package com.rcpcompany.uibindings.internal.observableFactories;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.edit.EditingDomainEObjectObservableList;
import org.eclipse.emf.databinding.edit.EditingDomainEObjectObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.AbstractEMFObservableFactory;
import com.rcpcompany.uibindings.IEMFObservableFactory;
import com.rcpcompany.uibindings.IManager;

/**
 * Default implementation of {@link IEMFObservableFactory} that uses the editing domain of the
 * manager.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DefaultEMFObservableFactory extends AbstractEMFObservableFactory implements IEMFObservableFactory {
	@Override
	public IObservableList observeList(Realm realm, EditingDomain editingDomain, EObject object,
			EStructuralFeature structuralFeature) {
		if (editingDomain == null) {
			editingDomain = IManager.Factory.getManager().getEditingDomain();
		}
		return new EditingDomainEObjectObservableList(realm, editingDomain, object, structuralFeature);
	}

	@Override
	public IObservableValue observeValue(Realm realm, EditingDomain editingDomain, EObject object,
			EStructuralFeature structuralFeature) {
		if (editingDomain == null) {
			editingDomain = IManager.Factory.getManager().getEditingDomain();
		}
		return new MyEditingDomainEObjectObservableValue(realm, editingDomain, object, structuralFeature);
	}

	/**
	 * Version of {@link EditingDomainEObjectObservableValue} that will shortcut
	 * {@link #setValue(Object)} if the new value is equal to the current value
	 * 
	 * @author Tonny Madsen, The RCP Company
	 */
	public static class MyEditingDomainEObjectObservableValue extends EditingDomainEObjectObservableValue {
		/**
		 * Constructs and returns a new value.
		 * 
		 * @param realm the realm
		 * @param domain the editing domain
		 * @param eObject the object
		 * @param eStructuralFeature the feature
		 */
		public MyEditingDomainEObjectObservableValue(Realm realm, EditingDomain domain, EObject eObject,
				EStructuralFeature eStructuralFeature) {
			super(realm, domain, eObject, eStructuralFeature);
		}

		@Override
		protected void doSetValue(Object value) {
			final Object oldValue = eObject.eGet(eStructuralFeature);
			if (oldValue == null ? value == null : oldValue.equals(value)) return;
			super.doSetValue(value);
		}
	}
}
