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
package com.rcpcompany.uibindings.model.utils;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.Diagnostician;

import com.rcpcompany.utils.logging.LogUtils;

/**
 * This class provides an adapter interface between the {@link EValidator} interface of Ecore and
 * XXX
 * <p>
 * The validator is based on {@link Diagnostician} and will only run after a certain time of
 * inactivity.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EValidatorAdapterUtils {
	/**
	 * Adds a new diagnostic for the specified object and feature.
	 * 
	 * @param diagnostics the dianostics chain
	 * @param severity the severity - one of {@link Diagnostic#INFO}, {@link Diagnostic#WARNING} or
	 *            {@link Diagnostic#ERROR}
	 * @param message the message for the diagnostics
	 * @param obj the object
	 * @param feature the feature possible <code>null</code>
	 */
	public static void addDiagnostic(DiagnosticChain diagnostics, int severity, String message, EObject obj,
			EStructuralFeature feature) {
		addDiagnostic(diagnostics, null, 0, severity, message, obj, feature);
	}

	/**
	 * Adds a new diagnostic for the specified object and feature.
	 * <p>
	 * The data associated with the the diagnostic describes a set of objects, features and possibly
	 * keys of objects that are associated with the diagnostic. The data object is an array where
	 * each element is either an {@link EObject} - if the diagnostic is associated with the object -
	 * or an array with an {@link EObject}, a {@link EStructuralFeature} and optionally a key - if
	 * the diagnostic is associated with the specific feature of the object.
	 * <p>
	 * Thus, if data is
	 * 
	 * <pre>
	 * [obj1,
	 *  [obj2],
	 *  [obj3, sf3],
	 *  [obj4, sf4, key4]
	 *  ]
	 * </pre>
	 * 
	 * then the diagnostic is associated with the following data:
	 * <ul>
	 * <li>the object <code>obj1</code></li>
	 * <li>the object <code>obj2</code></li>
	 * <li>the structural feature <code>sf3</code> of the object <code>obj3</code></li>
	 * <li>the key <code>key4</code> of the structural feature <code>sf4</code> of the object
	 * <code>obj4</code></li>
	 * </ul>
	 * <p>
	 * The meaning of the key is opaque to the code.
	 * 
	 * @param diagnostics the diagnostics chain
	 * @param source the source name space
	 * @param code the code in the name space
	 * @param severity the severity - one of {@link Diagnostic#INFO}, {@link Diagnostic#WARNING} or
	 *            {@link Diagnostic#ERROR}
	 * @param message the message for the diagnostics
	 * @param data the data associated with the diagnostic
	 */
	public static void addDiagnostic(DiagnosticChain diagnostics, String source, int code, int severity,
			String message, Object[] data) {
		/*
		 * Checking the data object
		 */
		for (final Object o : data) {
			if (o == null) {
				LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
				return;
			}
			if (o instanceof EObject) {
				continue;
			}
			if (!(o instanceof Object[])) {
				LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
				return;
			}
			final Object[] a = (Object[]) o;
			if (a.length < 1 || 3 < a.length) {
				LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
				return;
			}
			if (!(a[0] instanceof EObject)) {
				LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
				return;
			}
			if (a.length > 1 && !(a[1] == null || a[1] instanceof EStructuralFeature)) {
				LogUtils.error(data, "The data elements must be either EObject or [EObject EStructuralFeature]");
				return;
			}
			final EObject obj = (EObject) a[0];
			final EStructuralFeature feature = a.length > 1 ? (EStructuralFeature) a[1] : null;

			if (feature != null && !obj.eClass().getEAllStructuralFeatures().contains(feature)) {
				LogUtils.DEBUG_STRACK_LEVELS = 4;
				LogUtils.error(obj, "Reported problem with feature " + feature.getContainerClass().getSimpleName()
						+ "." + feature.getName() + " which is not a feature of " + obj.getClass().getSimpleName());
				LogUtils.DEBUG_STRACK_LEVELS = 0;
				return;
			}
		}
		final BasicDiagnostic diagnostic = new BasicDiagnostic(severity, source, code, message, data);
		diagnostics.add(diagnostic);
	}

	/**
	 * Adds a new diagnostic for the specified object and feature.
	 * 
	 * @param diagnostics the diagnostics chain
	 * @param source the source name space
	 * @param code the code in the name space
	 * @param severity the severity - one of {@link Diagnostic#INFO}, {@link Diagnostic#WARNING} or
	 *            {@link Diagnostic#ERROR}
	 * @param message the message for the diagnostics
	 * @param obj the object
	 * @param feature the feature possible <code>null</code>
	 */
	public static void addDiagnostic(DiagnosticChain diagnostics, String source, int code, int severity,
			String message, EObject obj, EStructuralFeature feature) {
		addDiagnostic(diagnostics, source, code, severity, message, new Object[][] { { obj, feature } });
	}

	/**
	 * Adds a new error diagnostic for the specified object and feature.
	 * 
	 * @param diagnostics the diagnostics chain
	 * @param source the source name space
	 * @param code the code in the name space
	 * @param message the message for the diagnostics
	 * @param obj the object
	 * @param feature the feature possible <code>null</code>
	 */
	public static void addError(DiagnosticChain diagnostics, String source, int code, String message, EObject obj,
			EStructuralFeature feature) {
		addDiagnostic(diagnostics, source, code, Diagnostic.ERROR, message, obj, feature);
	}

	/**
	 * Adds a new warning diagnostic for the specified object and feature.
	 * 
	 * @param diagnostics the diagnostics chain
	 * @param source the source name space
	 * @param code the code in the name space
	 * @param message the message for the diagnostics
	 * @param obj the object
	 * @param feature the feature possible <code>null</code>
	 */
	public static void addWarning(DiagnosticChain diagnostics, String source, int code, String message, EObject obj,
			EStructuralFeature feature) {
		addDiagnostic(diagnostics, source, code, Diagnostic.WARNING, message, obj, feature);
	}
}
