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

import com.rcpcompany.uibindings.internal.scripting.simple.SimpleScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptManager;

/**
 * Tests the model of the script manager is correct.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ScriptManagerModelTest {

	/**
	 * One engine registered.
	 */
	@Test
	public void testModel() {
		final IScriptManager mng = IScriptManager.Factory.getManager();
		assertNotNull(mng);

		assertEquals(1, mng.getEngines().size());
		final IScriptEngineDescriptor engine = mng.getEngines().get(IScriptManager.LANGUAGE_SIMPLE);
		assertNotNull(engine);
		assertEquals(IScriptManager.LANGUAGE_SIMPLE, engine.getLanguage());
		assertNotNull(engine.getEngine());
		final IScriptEngine e = engine.getEngine().getObject();
		assertTrue(e instanceof SimpleScriptEngine);
	}
}
