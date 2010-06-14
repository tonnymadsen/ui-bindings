/*******************************************************************************
 * Copyright (c) 2008, 2009 The RCP Company and Others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.tests.utils.basic.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.rcpcompany.utils.basic.ClassUtils;

public class ClassNameTests {
	private Object anonymous = new Object() {
	};

	private class Dummy {

	}

	@Test
	public void testGetLastClassNameString() {
		assertEquals("String", ClassUtils.getLastClassName("java.lang.String"));
		assertEquals("Dummy", ClassUtils.getLastClassName(Dummy.class.getName()));
		assertEquals(ClassUtils.getLastClassName(this.getClass().getName()) + "$1", ClassUtils
				.getLastClassName(anonymous.getClass().getName()));
	}

	@Test
	public void testGetLastClassNameObject() {
		assertEquals("Dummy", ClassUtils.getLastClassName(new Dummy()));
		assertEquals(ClassUtils.getLastClassName(this.getClass().getName()) + "$1", ClassUtils
				.getLastClassName(anonymous));
	}
}
