package com.rcpcompany.test.utils;

/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * Base class for all tests.
 * <p>
 * Provides a number of convenience methods...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EMFTestUtils {
	private EMFTestUtils() {
	}

	/**
	 * Tests that the number of "real" adapters on the specified object is as
	 * expected.
	 * <p>
	 * The following {@link Adapter} types are not considered real:
	 * <ul>
	 * <li>sub-classes of {@link ItemProviderAdapter}</li>
	 * <li>
	 * </li>
	 * </ul>
	 * 
	 * @param noExpected
	 *            the expected number of adapters
	 * @param obj
	 *            the objects to test
	 */
	public static void assertAdapters(int noExpected, EObject obj) {
		int no = 0;
		for (final Adapter a : obj.eAdapters()) {
			if (a instanceof ItemProviderAdapter) {
				continue;
			}

			no++;
		}

		assertEquals(noExpected, no);
	}

	public static final Comparator<EStructuralFeature> SF_COMPARATOR = new Comparator<EStructuralFeature>() {
		@Override
		public int compare(EStructuralFeature sf1, EStructuralFeature sf2) {
			return System.identityHashCode(sf1) - System.identityHashCode(sf2);
		}
	};
}
