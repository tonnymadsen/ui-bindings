package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.masterdetail.MasterDetailObservables;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EObjectObservableMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.internal.observables.MyDetailObservableList;
import com.rcpcompany.uibindings.internal.observables.MyDetailObservableValue;

/**
 * UI Bindings version of {@link EMFObservables}.
 * <p>
 * This version uses the registered {@link IEMFObservableFactory observables factories} to create the different
 * observables.
 * 
 * @since 1.3
 */
public class UIBindingsEMFObservables {
	/**
	 * Returns an observable value for the given feature of the object.
	 * 
	 * @param realm the realm in which to observe or null to use the default for the calling thread
	 * @param editingDomain the editing domain to use or <code>null</code> to use the default from {@link IManager}
	 * @param obj the object to observe.
	 * @param feature the feature of the object to observe.
	 * 
	 * @return an observable value for the given feature of the object.
	 */
	public static IObservableValue observeValue(Realm realm, EditingDomain editingDomain, EObject obj,
			EStructuralFeature feature) {
		if (realm == null) {
			realm = Realm.getDefault();
		}
		if (editingDomain == null) {
			editingDomain = IManager.Factory.getManager().getEditingDomain();
		}
		Assert.isNotNull(obj, "observed object may not be null"); //$NON-NLS-1$
		final IEMFObservableFactory factory = IManager.Factory.getManager().getObservableFactory(obj);
		final IObservableValue value = factory.observeValue(realm, editingDomain, obj, feature);
		Assert.isTrue(feature == value.getValueType(), "Expected value not of right type. Expected " + feature //$NON-NLS-1$
				+ ", got " + value.getValueType()); //$NON-NLS-1$
		return value;
	}

	/**
	 * Returns an observable value for the given feature of the object.
	 * 
	 * @param obj the object to observe.
	 * @param feature the feature of the object to observe.
	 * 
	 * @return an observable value for the given feature of the object.
	 */
	public static IObservableValue observeValue(EObject obj, EStructuralFeature feature) {
		return observeValue(null, null, obj, feature);
	}

	/**
	 * Returns an observable list for the given multi-valued feature of the object.
	 * 
	 * @param realm the realm in which to observe.
	 * @param editingDomain the editing domain to use or <code>null</code> to use the default from {@link IManager}
	 * @param eObject the object to observe.
	 * @param eStructuralFeature the feature of the object to observe.
	 * @return an observable list for the given multi-valued feature of the object.
	 */
	public static IObservableList observeList(Realm realm, EditingDomain editingDomain, EObject eObject,
			EStructuralFeature eStructuralFeature) {
		if (realm == null) {
			realm = Realm.getDefault();
		}
		if (editingDomain == null) {
			editingDomain = IManager.Factory.getManager().getEditingDomain();
		}
		final IEMFObservableFactory factory = IManager.Factory.getManager().getObservableFactory(eObject);
		final IObservableList list = factory.observeList(realm, editingDomain, eObject, eStructuralFeature);
		Assert.isTrue(eStructuralFeature == list.getElementType(), "Expected value not of right type. Expected " //$NON-NLS-1$
				+ eStructuralFeature + ", got " + list.getElementType()); //$NON-NLS-1$
		return list;
	}

	/**
	 * Returns an observable list for the given multi-valued feature of the object.
	 * 
	 * @param editingDomain the editing domain to use or <code>null</code> to use the default from {@link IManager}
	 * @param eObject the object to observe.
	 * @param eStructuralFeature the feature of the object to observe.
	 * @return an observable list for the given multi-valued feature of the object.
	 */
	public static IObservableList observeList(EditingDomain editingDomain, EObject eObject,
			EStructuralFeature eStructuralFeature) {
		return observeList(null, editingDomain, eObject, eStructuralFeature);
	}

	/**
	 * Returns an observable map in the default realm tracking the current value of the given feature for each object in
	 * the given set.
	 * 
	 * @param objects the objects to track.
	 * @param eStructuralFeature the feature for which to track the value.
	 * @return an observable map tracking the current value of the given feature for each object in the given set.
	 */
	public static IObservableMap observeMap(IObservableSet objects, EStructuralFeature eStructuralFeature) {
		return new EObjectObservableMap(objects, eStructuralFeature);
	}

	/**
	 * Returns an array of observable maps in the default realm tracking the current value of the given features for
	 * each object in the given set.
	 * 
	 * @param objects the objects to track.
	 * @param eStructuralFeatures the features for which to track the value.
	 * @return an array of observable maps tracking the current value of the given features for each object in the given
	 *         set.
	 */
	public static IObservableMap[] observeMaps(IObservableSet objects, EStructuralFeature[] eStructuralFeatures) {
		final IObservableMap[] result = new IObservableMap[eStructuralFeatures.length];
		for (int i = 0; i < eStructuralFeatures.length; i++) {
			result[i] = observeMap(objects, eStructuralFeatures[i]);
		}
		return result;
	}

	/**
	 * Returns an observable value that tracks the current value of the feature of the current value of the master
	 * observable value.
	 * 
	 * @param realm the realm in which to observe.
	 * @param editingDomain the editing domain used for all changes
	 * @param value the master observable value.
	 * @param eStructuralFeature the feature for which to track the value.
	 * @return an observable value that tracks the current value of the named property for the current value of the
	 *         master observable value
	 * @see MasterDetailObservables#detailValue(IObservableValue, IObservableFactory, Object)
	 */
	public static IObservableValue observeDetailValue(Realm realm, EditingDomain editingDomain, IObservableValue value,
			EStructuralFeature eStructuralFeature) {
		return new MyDetailObservableValue(value, valueFactory(realm, editingDomain, eStructuralFeature),
				eStructuralFeature);
	}

	/**
	 * Returns an observable value that tracks the current value of the feature of the current value of the master
	 * observable value.
	 * 
	 * @param editingDomain the editing domain used for all changes
	 * @param value the master observable value.
	 * @param feature the feature for which to track the value.
	 * 
	 * @return an observable value that tracks the current value of the named property for the current value of the
	 *         master observable value
	 * @see MasterDetailObservables#detailValue(IObservableValue, IObservableFactory, Object)
	 */
	public static IObservableValue observeDetailValue(EditingDomain editingDomain, IObservableValue value,
			EStructuralFeature feature) {
		return observeDetailValue(null, editingDomain, value, feature);
	}

	/**
	 * Returns an observable value that tracks the current value of the feature of the current value of the master
	 * observable value.
	 * 
	 * @param value the master observable value.
	 * @param feature the feature for which to track the value.
	 * 
	 * @return an observable value that tracks the current value of the named property for the current value of the
	 *         master observable value
	 * @see MasterDetailObservables#detailValue(IObservableValue, IObservableFactory, Object)
	 */
	public static IObservableValue observeDetailValue(IObservableValue value, EStructuralFeature feature) {
		return observeDetailValue(null, null, value, feature);
	}

	/**
	 * Returns an observable value that tracks the current value of the feature of the current value of the master
	 * observable value.
	 * 
	 * @param realm the realm for the value
	 * @param value the master observable value.
	 * @param feature the feature for which to track the value.
	 * 
	 * @return an observable value that tracks the current value of the named property for the current value of the
	 *         master observable value
	 * @see MasterDetailObservables#detailValue(IObservableValue, IObservableFactory, Object)
	 */
	public static IObservableValue observeDetailValue(Realm realm, IObservableValue value, EStructuralFeature feature) {
		return observeDetailValue(realm, null, value, feature);
	}

	/**
	 * Returns a factory for creating observable values tracking the value of the given feature of a particular
	 * {@link EObject object}.
	 * 
	 * @param realm the realm in which to observe.
	 * @param editingDomain the editing domain to use for changes
	 * @param eStructuralFeature the feature for which to track the value.
	 * @return an observable factory.
	 */
	public static IObservableFactory valueFactory(final Realm realm, final EditingDomain editingDomain,
			final EStructuralFeature eStructuralFeature) {
		return new IObservableFactory() {
			public IObservable createObservable(Object target) {
				return observeValue(realm, editingDomain, (EObject) target, eStructuralFeature);
			}
		};
	}

	/**
	 * Returns an observable list that tracks the current value of the feature of the current value of the master
	 * observable value.
	 * 
	 * @param realm the realm in which to observe.
	 * @param value the master observable value.
	 * @param feature the feature for which to track the value.
	 * @return an observable value that tracks the current value of the named property for the current value of the
	 *         master observable value
	 * @see MasterDetailObservables#detailList(IObservableValue, IObservableFactory, Object)
	 */
	public static IObservableList observeDetailList(Realm realm, IObservableValue value, EStructuralFeature feature) {
		return new MyDetailObservableList(listFactory(realm, feature), value, feature);
	}

	/**
	 * Returns an observable list that tracks the current value of the feature of the current value of the master
	 * observable value.
	 * 
	 * @param value the master observable value.
	 * @param feature the feature for which to track the value.
	 * @return an observable value that tracks the current value of the named property for the current value of the
	 *         master observable value
	 * @see MasterDetailObservables#detailList(IObservableValue, IObservableFactory, Object)
	 */
	public static IObservableList observeDetailList(IObservableValue value, EStructuralFeature feature) {
		return observeDetailList(value.getRealm(), value, feature);
	}

	/**
	 * Returns a factory for creating observable lists tracking the value of the given feature of a particular
	 * {@link EObject object}.
	 * 
	 * @param realm the realm in which to observe.
	 * @param eStructuralFeature the feature for which to track the value.
	 * @return an observable factory.
	 */
	public static IObservableFactory listFactory(final Realm realm, final EStructuralFeature eStructuralFeature) {
		return new IObservableFactory() {
			public IObservable createObservable(Object target) {
				return observeList(realm, null, (EObject) target, eStructuralFeature);
			}
		};
	}

	/**
	 * Returns a factory for creating observable maps tracking the value of the given feature of a particular
	 * {@link EObject object}.
	 * 
	 * @param eStructuralFeature the feature for which to track the value.
	 * @return an observable factory.
	 */
	public static IObservableFactory mapFactory(final EStructuralFeature eStructuralFeature) {
		return new IObservableFactory() {
			public IObservable createObservable(Object target) {
				return observeMap((IObservableSet) target, eStructuralFeature);
			}
		};
	}
}
