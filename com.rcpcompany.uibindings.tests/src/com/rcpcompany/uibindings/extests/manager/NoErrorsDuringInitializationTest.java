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

import com.rcpcompany.uibindings.tests.utils.StartActivator;

/**
 * Tests that there was no errors during the initialization of this application.
 * <p>
 * Depends on:
 * <ul>
 * <li> {@link Activator#myLogListener}</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NoErrorsDuringInitializationTest {

	@Test
	public void testNoErrors() {
		assertEquals(0, StartActivator.noMessages);
	}
}
