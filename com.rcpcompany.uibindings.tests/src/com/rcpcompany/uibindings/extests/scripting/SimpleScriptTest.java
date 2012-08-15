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

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.Ignore;
import org.junit.Test;

import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;
import com.rcpcompany.uibindings.scripting.ScriptEngineException;
import com.rcpcompany.uibindings.tests.utils.BaseUIBTestUtils;

/**
 * Tests the basic operation of the script functionality with the simple script engine.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class SimpleScriptTest {
	/**
	 * Tests the use of an unknown engine
	 */
	@Test
	public void testUnknownEngine() {
		BaseUIBTestUtils.resetAll();

		final IScriptManager manager = IScriptManager.Factory.getManager();

		try {
			IScriptManager.Factory.addScript("ddddddd", "a", null, null, null);
			fail();
		} catch (final ScriptEngineException ex) {
		}
	}

	/**
	 * Tests the basic creation of a script context
	 */
	@Test
	public void testBasicCreation() {
		BaseUIBTestUtils.resetAll();

		final IScriptManager manager = IScriptManager.Factory.getManager();

		final IScriptEvaluationContext globalEvaluationContext = manager.getGlobalEvaluationContext();

		IScriptExpression c = null;
		try {
			c = IScriptManager.Factory.addScript(IScriptManager.LANGUAGE_SIMPLE, "a", String.class, null, null);
		} catch (final ScriptEngineException ex) {
			fail(ex.getMessage());
		}

		assertNotNull(c);
		assertEquals("a", c.getScript());
		assertEquals(String.class, c.getExpectedValueClass());
		assertEquals(manager.getEngines().get(IScriptManager.LANGUAGE_SIMPLE), c.getEngine());
		assertEquals(globalEvaluationContext, c.getEvaluationContext());

		assertEquals(null, c.getCurrentValue());
		final IObservableValue ov = c.getObservableValue();
		assertNotNull(ov);
		assertEquals(EcorePackage.Literals.ESTRING, ov.getValueType());
		assertEquals(null, ov.getValue());
	}

	/**
	 * Tests script is properly re-evaluated when the evaluation context changes..
	 */
	@Test
	@Ignore
	public void testVariableReevaluation() {
		BaseUIBTestUtils.resetAll();

		final IScriptManager manager = IScriptManager.Factory.getManager();

		final IScriptEvaluationContext globalEvaluationContext = manager.getGlobalEvaluationContext();

		IScriptExpression c = null;
		try {
			c = IScriptManager.Factory.addScript(IScriptManager.LANGUAGE_SIMPLE, "a", String.class, null, null);
		} catch (final ScriptEngineException ex) {
			fail(ex.getMessage());
		}

		assertNotNull(c);

		assertEquals(null, c.getCurrentValue());
		final IObservableValue ov = c.getObservableValue();
		assertNotNull(ov);
		assertEquals(null, ov.getValue());

		assertNotNull(c.getErrorMessage());

		/*
		 * New value
		 */
		globalEvaluationContext.getVariables().put("a", "abc");

		assertEquals("abc", c.getCurrentValue());
		// TODO notification
		assertEquals("abc", ov.getValue());
		assertEquals(null, c.getErrorMessage());

		/*
		 * Changed value
		 */
		globalEvaluationContext.getVariables().put("a", "123");

		assertEquals("123", c.getCurrentValue());
		// TODO notification
		assertEquals("123", ov.getValue());
		assertEquals(null, c.getErrorMessage());

		/*
		 * Remove value
		 */
		globalEvaluationContext.getVariables().remove("a");

		assertEquals(null, c.getCurrentValue());
		assertEquals(null, ov.getValue());
		assertNotNull(c.getErrorMessage());
	}
}
