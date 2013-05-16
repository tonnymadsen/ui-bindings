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
package com.rcpcompany.uibindings.extests.utils;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Test;

import com.rcpcompany.uibindings.model.utils.BasicUtils;
import com.rcpcompany.uibindings.model.utils.EcoreExtendedUtils;

/**
 * Tests {@link EcoreExtUtils#getSubClasses(EClass)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EcoreExtUtilsSubclassesTest {
	@Test
	public void testResults() {
		testOneResult(EcorePackage.Literals.ECLASS);
		testOneResult(EcorePackage.Literals.ESTRUCTURAL_FEATURE, EcorePackage.Literals.EATTRIBUTE,
				EcorePackage.Literals.EREFERENCE);
	}

	public void testOneResult(EClass sc, EClass... expectedSubClasses) {
		final Collection<EClass> subClasses = EcoreExtendedUtils.getSubClasses(sc);
		// LogUtils.debug(this, sc.getName() + ": " + subClasses);
		if (expectedSubClasses.length == 0) {
			assertEquals(null, subClasses);
			return;
		}
		final EClass[] foundSubClasses = subClasses.toArray(new EClass[subClasses.size()]);
		Arrays.sort(expectedSubClasses, BasicUtils.OBJECT_COMPARATOR);
		Arrays.sort(foundSubClasses, BasicUtils.OBJECT_COMPARATOR);

		assertArrayEquals(expectedSubClasses, foundSubClasses);
	}
}
