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
