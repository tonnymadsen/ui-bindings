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
package com.rcpcompany.uibindings.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.FeatureListMonitor;

/**
 * This interface is used to monitor a specific feature of an EMF list...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IFeatureListMonitor extends IDisposable {
	/**
	 * Factory methods...
	 */
	public static final class Factory {
		private Factory() {
		}

		/**
		 * Monitors the specified list of the object for changes in the detail feature.
		 * 
		 * @param obj the object to monitor
		 * @param listReference the reference for the list
		 * @param detailFeature the feature for the detail of the list element
		 * @param runnable the runnable to run
		 * @return a new monitor
		 */
		public static IFeatureListMonitor monitor(EObject obj, EReference listReference,
				EStructuralFeature detailFeature, Runnable runnable) {
			return new FeatureListMonitor(obj, listReference, detailFeature, runnable);
		}
	}
}
