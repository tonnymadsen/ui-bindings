package com.rcpcompany.uibindings.internal.scripting.simple;

import java.util.Map;

import com.rcpcompany.uibindings.scripting.AbstractScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;

/**
 * The {@link IScriptEngine} for {@link IScriptManager#LANGUAGE_SIMPLE}.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class SimpleScriptEngine extends AbstractScriptEngine implements IScriptEngine {
	@Override
	public void dispose() {

	}

	@Override
	public void evaluate(IScriptExpression expression) {
		final Map<String, Object> variables = expression.getEvaluationContext().collectVariables();

		final String varName = expression.getScript();

		if (!variables.containsKey(varName)) {
			expression.setCurrentValue(null);
			expression.setErrorMessage("Unknown variable: '" + varName + "'");
			return;
		}

		expression.setCurrentValue(variables.get(varName));
	}
}
