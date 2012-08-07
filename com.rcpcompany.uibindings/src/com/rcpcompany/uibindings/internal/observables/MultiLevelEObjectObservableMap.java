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
package com.rcpcompany.uibindings.internal.observables;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.map.ComputedObservableMap;
import org.eclipse.core.databinding.observable.map.MapDiff;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Virtual observable map that maps from a set of {@link EObject EObjects} to an attribute value
 * specified as a chain of structural features.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class MultiLevelEObjectObservableMap extends ComputedObservableMap {
	/**
	 * Array with the references leading up the last feature. Never empty.
	 */
	protected final EStructuralFeature[] myChainReferences;

	/**
	 * The last feature.
	 */
	protected final EStructuralFeature myLastFeature;

	/**
	 * Constructs and returns a new map for the specified object set and specified feature.
	 * 
	 * @param objects the objects of the map
	 * @param feature the feature that map to the map value
	 */
	public MultiLevelEObjectObservableMap(IObservableSet objects, EStructuralFeature feature) {
		this(objects, new EStructuralFeature[] { feature });
	}

	/**
	 * Constructs and returns a new map for the specified object set and the feature array.
	 * 
	 * @param objects the objects of the map
	 * @param features the features that map to the map value
	 */
	public MultiLevelEObjectObservableMap(IObservableSet objects, EStructuralFeature[] features) {
		super(objects);
		final int l = features.length;
		// Some sanity checks:
		final Object type = objects.getElementType();
		EClass prevEClass = null;
		if (type instanceof EClass) {
			prevEClass = (EClass) type;
		} else if (type instanceof EReference) {
			prevEClass = ((EReference) type).getEReferenceType();
		} else {
			// Unfortunately ObservableListContentProvider.getKnownElements()
			// returns null always :-(
			//
			// Assert.isLegal(false, "Set element type must be EClass or EReference, was " + type);
		}
		for (int i = 0; i < l - 1; i++) {
			Assert.isTrue(features[i] instanceof EReference, "Intermidiate features must before references");
			final EReference ref = (EReference) features[i];
			if (prevEClass != null) {
				Assert.isTrue(ref.getEContainingClass().isSuperTypeOf(prevEClass), "Reference " + ref
						+ " not applicable for class " + prevEClass);
			}
			prevEClass = ref.getEReferenceType();
		}
		myLastFeature = features[l - 1];
		if (prevEClass != null) {
			Assert.isTrue(myLastFeature.getEContainingClass().isSuperTypeOf(prevEClass), "Feature " + myLastFeature
					+ " not applicable for class " + prevEClass);
		}

		myChainReferences = new EStructuralFeature[l];
		System.arraycopy(features, 0, myChainReferences, 0, l);
		init();
	}

	/**
	 * Private class that represents the a single key value in the map.
	 * <p>
	 * Keeps an array with all the intermediate {@link EObject EObjects} that matches the
	 * myChainReferences array.
	 * <p>
	 * An adapter (<code>this</code>) is added to all of these objects. Changes are perceived to be
	 * seldom, so the complete set of adpters are unhooked with all changes in the surveyed objects.
	 */
	protected class ChainAdapter extends AdapterImpl {
		protected EObject[] chain = new EObject[myChainReferences.length];

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;
			for (int i = 0; i < myChainReferences.length; i++) {
				if (chain[i] == msg.getNotifier() && myChainReferences[i] == msg.getFeature()) {
					/*
					 * TODO: This assumes we only get a SET notification, which isn't a good
					 * assumption.
					 */
					final MapDiff diff = Diffs
							.createMapDiffSingleChange(chain[0], msg.getOldValue(), msg.getNewValue());
					getRealm().exec(new Runnable() {
						@Override
						public void run() {
							fireMapChange(diff);
						}
					});
					unhookListener(chain[0]);
					hookListener(chain[0]);
					break;
				}
			}
		}

		public void hookListener(Object domainElement) {
			chain[0] = (EObject) domainElement;
			EObject next = chain[0];
			if (next != null) {
				next.eAdapters().add(this);
			}
			for (int i = 0; i < myChainReferences.length - 1 && next != null; i++) {
				next = (EObject) next.eGet(myChainReferences[i]);
				chain[i + 1] = next;
				if (next != null) {
					next.eAdapters().add(this);
				}
			}
		}

		public void unhookListener(Object domainElement) {
			for (final EObject o : chain) {
				if (o != null) {
					o.eAdapters().remove(this);
				}
			}
		}

		public Object getValue() {
			return chain[chain.length - 1].eGet(myLastFeature);
		}

		public Object setValue(Object value) {
			final EObject eObject = chain[chain.length - 1];
			final Object result = eObject.eGet(myLastFeature);
			eObject.eSet(myLastFeature, value);
			return result;
		}
	};

	Map<Object, ChainAdapter> listeners = new HashMap<Object, ChainAdapter>();

	@Override
	protected void hookListener(Object domainElement) {
		final ChainAdapter vi = new ChainAdapter();
		vi.hookListener(domainElement);
	}

	@Override
	protected void unhookListener(Object domainElement) {
		final ChainAdapter vi = listeners.remove(domainElement);
		if (vi != null) {
			vi.unhookListener(domainElement);
		}
	}

	@Override
	protected Object doGet(Object key) {
		final ChainAdapter vi = listeners.get(key);
		if (vi == null) return null;
		return vi.getValue();
	}

	@Override
	protected Object doPut(Object key, Object value) {
		final ChainAdapter vi = listeners.get(key);
		if (vi == null) return null;
		return vi.setValue(value);
	}
}
