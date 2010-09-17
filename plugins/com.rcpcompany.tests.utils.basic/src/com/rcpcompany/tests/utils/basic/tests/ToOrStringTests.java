/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.tests.utils.basic.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.rcpcompany.utils.basic.ToStringUtils;

public class ToOrStringTests {

	@Test
	public void testToStringObjectArray() {
		assertEquals("a, b or \"c d\"", ToStringUtils.toOrString(new Object[] { "a", "b", "c d" }));
		assertEquals("0, 0.1 or false", ToStringUtils.toOrString(new Object[] { 0, 0.1f, false }));
		assertEquals("a", ToStringUtils.toOrString(new Object[] { "a" }));
		assertEquals("", ToStringUtils.toOrString(new Object[] {}));
	}

	@Test
	public void testToStringListOfT() {
		final List<Object> l = new ArrayList<Object>();
		l.add("a");
		l.add("b");
		l.add("c d");
		assertEquals("a, b or \"c d\"", ToStringUtils.toOrString(l));

		l.clear();
		l.add(0);
		l.add(0.1f);
		l.add(false);
		assertEquals("0, 0.1 or false", ToStringUtils.toOrString(l));

		l.clear();
		assertEquals("", ToStringUtils.toOrString(l));
	}

	@Test
	public void testFormatHumanReadable() {
		assertEquals("Shop Name", ToStringUtils.formatHumanReadable("shopName"));
		assertEquals("Current Row No", ToStringUtils.formatHumanReadable("currentRowNo"));
		assertEquals("Id", ToStringUtils.formatHumanReadable("id"));
		assertEquals("Active Z", ToStringUtils.formatHumanReadable("activeZ"));
		assertEquals("Active Z", ToStringUtils.formatHumanReadable("ActiveZ"));
		assertEquals("Active ZZ", ToStringUtils.formatHumanReadable("ActiveZZ"));
		assertEquals("Is DNA Available", ToStringUtils.formatHumanReadable("isDNAAvailable"));
		assertEquals("E Shop", ToStringUtils.formatHumanReadable("eShop"));
		assertEquals("E DNA", ToStringUtils.formatHumanReadable("eDNA"));
	}
}
