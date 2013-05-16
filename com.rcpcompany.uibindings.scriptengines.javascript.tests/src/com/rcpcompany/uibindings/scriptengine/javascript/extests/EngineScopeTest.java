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
package com.rcpcompany.uibindings.scriptengine.javascript.extests;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

public class EngineScopeTest {

	public static void main(String[] args) throws ScriptException {
		final ScriptEngineManager manager = new ScriptEngineManager();
		final ScriptEngine engine = manager.getEngineByName("js");

		final SimpleBindings bindings = new SimpleBindings();
		bindings.put("name", "World");

		engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);

		final SimpleBindings evalBindings = new SimpleBindings();
		evalBindings.put("name", "Another world");

		System.out.println(engine.eval("\"Hello \"+name")); // Default scope
		System.out.println(engine.eval("\"Hello \"+name", evalBindings));
	}
}
