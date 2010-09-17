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

import org.junit.Test;

import com.rcpcompany.utils.basic.ClassUtils;

/**
 * Tests of {@link ClassUtils}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ClassNameTests {
	private final Object anonymous = new Object() {
	};

	private class Dummy {

	}

	@Test
	public void testGetLastClassNameString() {
		assertEquals("String", ClassUtils.getLastClassName("java.lang.String"));
		assertEquals("Dummy", ClassUtils.getLastClassName(Dummy.class.getName()));
		assertEquals(ClassUtils.getLastClassName(this.getClass().getName()) + "$1",
				ClassUtils.getLastClassName(anonymous.getClass().getName()));
	}

	@Test
	public void testGetLastClassNameObject() {
		assertEquals("Dummy", ClassUtils.getLastClassName(new Dummy()));
		assertEquals(ClassUtils.getLastClassName(this.getClass().getName()) + "$1",
				ClassUtils.getLastClassName(anonymous));
	}
}
