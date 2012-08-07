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
package com.rcpcompany.uibindings.extests.scripting;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptManager;

/**
 * Tests of {@link IScriptManager#getGlobalEvaluationContext()} and
 * {@link IScriptManager#getEvaluationContext(IScriptEvaluationContext, Map)}.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class ScriptManagerEvalContextTest {
	IScriptManager MANAGER = IScriptManager.Factory.getManager();

	/**
	 * Tests that the same global context is used .
	 */
	@Test
	public void testGlobalContext() {
		final IScriptEvaluationContext context = MANAGER.getGlobalEvaluationContext();

		assertNotNull(context);
		assertEquals(null, context.getParent());

		final IScriptEvaluationContext c2 = MANAGER.getGlobalEvaluationContext();

		assertEquals(context, c2);
	}

	/**
	 * Test {@link IScriptManager#getEvaluationContext(IScriptEvaluationContext, Map)}.
	 */
	@Test
	public void tesEvalContexts() {
		final IScriptEvaluationContext gc = MANAGER.getGlobalEvaluationContext();

		// global
		final IScriptEvaluationContext c1 = MANAGER.getEvaluationContext(null, null);
		assertEquals(gc, c1);

		// sub of global
		final Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("a", 10);
		final IScriptEvaluationContext c2 = MANAGER.getEvaluationContext(null, m2);
		assertNotSame(gc, c2);
		assertEquals(gc, c2.getParent());
		assertTrue(gc.getChildren().contains(c2));

		assertEquals(1, c2.getVariables().size());
		assertEquals(10, c2.getVariables().get("a"));

		// new sub of global
		final Map<String, Object> m3 = new HashMap<String, Object>();
		m3.put("a", 100);
		final IScriptEvaluationContext c3 = MANAGER.getEvaluationContext(null, m3);
		assertNotSame(gc, c3);
		assertNotSame(c2, c3);
		assertEquals(gc, c3.getParent());
		assertTrue(gc.getChildren().contains(c3));

		assertEquals(1, c3.getVariables().size());
		assertEquals(100, c3.getVariables().get("a"));

		// dup of c2
		final Map<String, Object> m4 = new HashMap<String, Object>();
		m4.put("a", 10);
		final IScriptEvaluationContext c4 = MANAGER.getEvaluationContext(null, m4);
		assertEquals(c2, c4);

		// dup of c3
		c3.getVariables().put("a", 200);
		final Map<String, Object> m5 = new HashMap<String, Object>();
		m5.put("a", 200);
		final IScriptEvaluationContext c5 = MANAGER.getEvaluationContext(null, m5);
		assertEquals(c3, c5);

		// dup of c3
		final IScriptEvaluationContext c6 = MANAGER.getEvaluationContext(c2, m2);
		assertNotNull(c6);
		assertNotSame(gc, c6);
		assertNotSame(c2, c6);

		assertEquals(c2, c6.getParent());
	}
}
