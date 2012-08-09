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

import java.util.ArrayList;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Before;
import org.junit.Test;

import com.rcpcompany.uibindings.internal.observables.ListIndexObservableValue;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;

/**
 * Test of {@link ListIndexObservableValue}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ListIndexObservableValueTest {
	@Before
	public void before() {
		BaseUIBTestUtils.resetAll();
	}

	int events = 0;
	private final IChangeListener listener = new IChangeListener() {
		@Override
		public void handleChange(ChangeEvent event) {
			events++;
		}
	};

	/**
	 * Tests the basic functionality
	 */
	@Test
	public void testBasics() {
		final IObservableList master = new WritableList(new ArrayList<Object>(), EcorePackage.Literals.ESTRING);
		master.add("a");
		master.add("b");
		master.add("c");
		final ListIndexObservableValue v = new ListIndexObservableValue(master, "b");

		assertEquals(1, v.getValue());
		assertEquals(EcorePackage.Literals.EINT, v.getValueType());

		v.addChangeListener(listener);
		assertEquals(0, events);

		master.add("d");

		assertEquals(1, v.getValue());
		assertEquals(0, events);

		master.add(0, "g");

		assertEquals(2, v.getValue());
		assertEquals(1, events);

		master.remove(3);

		assertEquals(2, v.getValue());
		assertEquals(1, events);

		master.remove(0);

		assertEquals(1, v.getValue());
		assertEquals(2, events);

		master.remove(1);

		assertEquals(-1, v.getValue());
		assertEquals(3, events);

		master.add("b");

		assertEquals(2, v.getValue());
		assertEquals(4, events);
	}
}
