package com.rcpcompany.uibindings.scriptengines.javascript;

import java.util.Map;
import java.util.Set;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.rcpcompany.uibindings.scripting.AbstractScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptEngine;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * JavaScript based {@link IScriptEngine}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class JSScriptEngine extends AbstractScriptEngine implements IScriptEngine {

	private final ScriptEngineManager myJScriptManager;
	private final ScriptEngine myJEngine;

	/**
	 * The current script context.
	 */
	private IScriptExpression myCurrentContext = null;

	public JSScriptEngine() {
		myJScriptManager = new ScriptEngineManager();
		myJEngine = myJScriptManager.getEngineByName("JavaScript");
	}

	@Override
	public void dispose() {
	}

	@Override
	public void evaluate(IScriptExpression context) {
		myCurrentContext = context;

		installVariables();
		executeScript();
		updateDependencies();
	}

	/**
	 * Updates the dependencies of the
	 */
	private void updateDependencies() {
		// TODO Auto-generated method stub

	}

	private void executeScript() {
		try {
			final Object newValue = myJEngine.eval(myCurrentContext.getScript());
			myCurrentContext.setCurrentValue(newValue);
		} catch (final ScriptException ex) {
			LogUtils.error(this, ex);
			final String message = ex.getLocalizedMessage();
			myCurrentContext.setErrorMessage(message);
		}
	}

	/**
	 * Install all the variables of the evaluation context - and removes all other bindings.
	 */
	public void installVariables() {
		final Map<String, Object> variables = myCurrentContext.getEvaluationContext().collectVariables();

		final ScriptContext context = myJEngine.getContext();
		final Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);

		bindings.putAll(variables);
		final Set<String> oldVariableNames = bindings.keySet();
		for (final String n : oldVariableNames.toArray(new String[oldVariableNames.size()])) {
			if (variables.containsKey(n)) {
				continue;
			}

			bindings.remove(n);
		}
	}
}
