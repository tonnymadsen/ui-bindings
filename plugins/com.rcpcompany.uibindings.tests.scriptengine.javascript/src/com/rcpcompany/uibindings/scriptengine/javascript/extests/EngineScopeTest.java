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
