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
package com.rcpcompany.utils.basic.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rcpcompany.utils.basic.ClassUtils;

/**
 * Tests of {@link ClassUtils}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ClassNameTest {
	/*
	 * Must be first anonymous class!
	 */
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
		assertEquals("ClassNameTest", ClassUtils.getLastClassName(this));
		assertEquals("Dummy", ClassUtils.getLastClassName(new Dummy()));
		assertEquals(ClassUtils.getLastClassName(this) + "$1", ClassUtils.getLastClassName(anonymous));
	}

	@Test
	public void testCompressedClassNameString() {
		assertEquals("String", ClassUtils.getCompressedClassName("java.lang.String"));
		assertEquals("c.r.u.b.t.ClassNameTest$Dummy", ClassUtils.getCompressedClassName(Dummy.class.getName()));
		assertEquals(ClassUtils.getCompressedClassName(this.getClass().getName()) + "$1",
				ClassUtils.getCompressedClassName(anonymous.getClass().getName()));
	}
}
