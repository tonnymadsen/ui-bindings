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
package com.rcpcompany.uibindings.internal.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IDisposable;

/**
 * Support class for {@link ISupportListener label providers} used to handle updates of the labels.
 * <p>
 * This version only supports EMF based models.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class LabelProviderEventSupport implements IDisposable {

	/**
	 * This label provider of this event support object.
	 */
	protected final ISupportListener myProvider;

	/**
	 * Constructs and returns a new event support object for the specified label provider.
	 * 
	 * @param provider the label provider
	 */
	public LabelProviderEventSupport(ISupportListener provider) {
		myProvider = provider;
	}

	/**
	 * Disposes this support object by disposing of all the monitored objects.
	 */
	@Override
	public void dispose() {
		while (myObjects.values().size() > 0) {
			myObjects.values().iterator().next().dispose();
		}
	};

	public interface ISupportListener {
		void objectsChanged(Object[] elements);
	}

	/**
	 * Adds a new object to this event support object that monitors changes to the specified
	 * {@link EObject} with the specified chain of features.
	 * 
	 * @param object the object
	 * @param features the chain of features
	 */
	public void addObject(EObject object, EStructuralFeature[] features) {
		final MonitoredObject o = myObjects.get(object);
		if (o == null) {
			new MonitoredObject(object, features);
		}
	}

	/**
	 * Removes a previously added object.
	 * 
	 * @param object the object to remove
	 */
	public void removeObject(EObject object) {
		final MonitoredObject o = myObjects.get(object);
		if (o != null) {
			o.dispose();
		}
	}

	/**
	 * Map with all monitored objects.
	 */
	protected Map<EObject, MonitoredObject> myObjects = new HashMap<EObject, MonitoredObject>();

	/**
	 * Private class that represents the a single key value in the map.
	 * <p>
	 * Keeps an array with all the intermediate {@link EObject EObjects} that matches the
	 * myChainReferences array.
	 * <p>
	 * An adapter (<code>this</code>) is added to all of these objects. Changes are perceived to be
	 * seldom, so the complete set of adapters are re-hooked with all changes in the surveyed
	 * objects.
	 */
	private class MonitoredObject extends AdapterImpl implements IDisposable {
		/**
		 * Array with all features.
		 */
		protected final EStructuralFeature[] myReferencesChain;

		/**
		 * Array of the objects in the feature chain.
		 */
		protected final EObject[] myObjectChain;

		/**
		 * The base object of this key...
		 */
		private final EObject myObject;

		/**
		 * Constructs and returns a new monitored object.
		 * 
		 * @param object the object to monitor
		 * @param features the features to monitor
		 */
		private MonitoredObject(EObject object, EStructuralFeature[] features) {
			myObject = object;
			final int l = features.length;

			// Some sanity checks:
			EClass prevEClass = myObject.eClass();

			for (int i = 0; i < l - 1; i++) {
				Assert.isTrue(features[i] instanceof EReference, "Intermidiate features must before references");
				final EReference ref = (EReference) features[i];
				if (prevEClass != null) {
					Assert.isTrue(ref.getEContainingClass().isSuperTypeOf(prevEClass), "Reference "
							+ ref.getEContainingClass().getName() + "." + ref.getName() + " not applicable for class "
							+ prevEClass.getName());
				}
				prevEClass = ref.getEReferenceType();
			}
			final EStructuralFeature lastFeature = features[l - 1];
			if (prevEClass != null) {
				Assert.isTrue(lastFeature.getEContainingClass().isSuperTypeOf(prevEClass), "Feature "
						+ lastFeature.getEContainingClass().getName() + "." + lastFeature.getName()
						+ " not applicable for class " + prevEClass.getName());
			}

			myReferencesChain = new EStructuralFeature[l];
			myObjectChain = new EObject[myReferencesChain.length];

			System.arraycopy(features, 0, myReferencesChain, 0, l);

			myObjects.put(myObject, this);

			hookListeners();
		}

		@Override
		public void dispose() {
			unhookListeners();
			myObjects.remove(myObject);
		}

		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;
			for (int i = 0; i < myReferencesChain.length; i++) {
				if (myObjectChain[i] == msg.getNotifier() && myReferencesChain[i] == msg.getFeature()) {
					myProvider.objectsChanged(new Object[] { myObject });

					unhookListeners();
					hookListeners();
					break;
				}
			}
		}

		public void hookListeners() {
			myObjectChain[0] = myObject;
			EObject next = myObjectChain[0];
			if (next != null) {
				next.eAdapters().add(this);
			}
			for (int i = 0; i < myReferencesChain.length - 1 && next != null; i++) {
				next = (EObject) next.eGet(myReferencesChain[i]);
				myObjectChain[i + 1] = next;
				if (next != null) {
					next.eAdapters().add(this);
				}
			}
		}

		public void unhookListeners() {
			for (final EObject o : myObjectChain) {
				if (o != null) {
					o.eAdapters().remove(this);
				}
			}
		}
	}
}
