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
package com.rcpcompany.uibindings.extests.scripting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rcpcompany.uibindings.scripting.IScriptManager;

/**
 * Tests existence of the script manager.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScriptManagerBaseTest {

	/**
	 * One manager
	 */
	@Test
	public void testManager() {
		final IScriptManager manager = IScriptManager.Factory.getManager();
		assertNotNull(manager);

		final IScriptManager m2 = IScriptManager.Factory.getManager();
		assertEquals(manager, m2);
	}
}
