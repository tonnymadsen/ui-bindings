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
package com.rcpcompany.uibindings.extests.observables;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.observables.IndexObservableList;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;

/**
 * Test of {@link IndexObservableList}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class IndexObservableListTest {
	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
	}

	@Test
	public void testValues() {
		final IndexObservableList l = new IndexObservableList(3, 7);

		assertEquals(EcorePackage.Literals.EINTEGER_OBJECT, l.getElementType());
		assertEquals(5, l.size());

		assertEquals(3, l.get(0));
		assertEquals(4, l.get(1));
		assertEquals(5, l.get(2));
		assertEquals(6, l.get(3));
		assertEquals(7, l.get(4));
	}
}
