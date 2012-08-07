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

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.utils.IFeatureListMonitor;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implmentation of {@link IFeatureListMonitor}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class FeatureListMonitor implements IFeatureListMonitor {

	private final EObject myObj;
	private final EReference myListReference;
	private final EStructuralFeature myDetailFeature;
	private final Runnable myRunnable;
	private final Adapter myAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			changed(msg);
		};
	};

	/**
	 * Constructs and returns a new monitor for the specified list of the object for changes in the
	 * detail feature.
	 * 
	 * @param obj the object to monitor
	 * @param listReference the reference for the list
	 * @param detailFeature the feature for the detail of the list element
	 * @param runnable the runnable to run
	 */
	public FeatureListMonitor(EObject obj, EReference listReference, EStructuralFeature detailFeature, Runnable runnable) {
		myObj = obj;
		myListReference = listReference;
		myDetailFeature = detailFeature;
		myRunnable = runnable;

		if (!obj.eClass().getEAllReferences().contains(listReference)) {
			LogUtils.throwException(obj, "reference not in " + obj, null);
		}

		obj.eAdapters().add(myAdapter);
		for (final EObject e : (List<EObject>) obj.eGet(myListReference)) {
			e.eAdapters().add(myAdapter);
		}
	}

	protected void changed(Notification msg) {
		if (msg.isTouch()) return;

		if (msg.getFeature() == myListReference) {
			switch (msg.getEventType()) {
			case Notification.REMOVE:
			case Notification.SET:
				final EObject entry = (EObject) msg.getOldValue();
				entry.eAdapters().remove(myAdapter);
				break;
			case Notification.REMOVE_MANY:
				final List<EObject> entries = (List<EObject>) msg.getOldValue();
				for (final EObject e : entries) {
					e.eAdapters().remove(myAdapter);
				}
				break;
			}
			switch (msg.getEventType()) {
			case Notification.ADD:
			case Notification.SET:
				final EObject entry = (EObject) msg.getNewValue();
				entry.eAdapters().add(myAdapter);
				break;
			case Notification.ADD_MANY:
				final List<EObject> entries = (List<EObject>) msg.getNewValue();
				for (final EObject e : entries) {
					e.eAdapters().add(myAdapter);
				}
				break;
			}
			run();
		}
		if (msg.getFeature() == myDetailFeature) {
			run();
		}
	}

	/**
	 * 
	 */
	private void run() {
		try {
			myRunnable.run();
		} catch (final Exception ex) {
			LogUtils.error(myRunnable, ex);
		}
	}

	@Override
	public void dispose() {
		for (final EObject e : (List<EObject>) myObj.eGet(myListReference)) {
			e.eAdapters().remove(myAdapter);
		}
		myObj.eAdapters().remove(myAdapter);
	}
}
