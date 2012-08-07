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
package com.rcpcompany.uibindings.extests.manager;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;

/**
 * Tests the sorting order of decorator extenders from the manager.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerDecoratorExtendersSortTest {
	@Test
	public void testOrder() {
		int p = Integer.MIN_VALUE;

		for (final IUIBindingDecoratorExtenderDescriptor e : IManager.Factory.getManager().getDecoratorExtenders()) {
			assertTrue("non-positive priority?", e.getPriority() > 0);
			assertTrue(p <= e.getPriority());
			p = e.getPriority();
		}
	}
}
