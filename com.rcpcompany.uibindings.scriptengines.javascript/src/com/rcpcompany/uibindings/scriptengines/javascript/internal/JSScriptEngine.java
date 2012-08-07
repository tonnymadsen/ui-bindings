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
package com.rcpcompany.uibindings.scriptengines.javascript.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.EcmaError;
import org.mozilla.javascript.ImporterTopLevel;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

import com.rcpcompany.uibindings.scripting.AbstractScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptDependency;
import com.rcpcompany.uibindings.scripting.IScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptEngineFactory;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * JavaScript based {@link IScriptEngine}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class JSScriptEngine extends AbstractScriptEngine implements IScriptEngine {
	/**
	 * The context used for our engine.
	 */
	private final Context myContext;

	/**
	 * The global scope where all variables are installed.
	 */
	private final Scriptable myGlobalScope;

	/**
	 * The current script expression.
	 */
	private IScriptExpression myCurrentExpression = null;

	/**
	 * Returns the current script expression.
	 * 
	 * @return the expression
	 */
	public IScriptExpression getCurrentExpression() {
		return myCurrentExpression;
	}

	/**
	 * Sets the current script expression
	 * 
	 * @param expression the new expression
	 */
	public void setCurrentExpression(IScriptExpression expression) {
		myCurrentExpression = expression;
	}

	/**
	 * Constructs and returns a new JavaScript engine.
	 */
	public JSScriptEngine() {
		myContext = ContextFactory.getGlobal().enterContext();
		myContext.setErrorReporter(new MyErrorReporter());
		myContext.setWrapFactory(new EMFWrapFactory());

		myGlobalScope = new MyTopLevel(myContext);
	}

	@Override
	public void dispose() {
	}

	/**
	 * The script dependencies accumulated by {@link #addDependency(EObject, EStructuralFeature)} and friends.
	 */
	private static final List<IScriptDependency> myDependencies = new ArrayList<IScriptDependency>();

	@Override
	public void evaluate(IScriptExpression expression) {
		Object value = null;
		String errorMessage = null;
		try {
			setCurrentExpression(expression);
			myDependencies.clear();

			final String script = expression.getScript();
			if (script == null) {
				return;
			}
			final Context cx = Context.getCurrentContext();
			LogUtils.debug(cx, "cx=" + cx + ": " + script);
			value = cx.evaluateString(myGlobalScope, script, "script", 1, null);
		} catch (final EcmaError ex) {
			errorMessage = ex.getErrorMessage();
		} catch (final RhinoException ex) {
			LogUtils.error(this, ex);
			errorMessage = ex.getLocalizedMessage();
		} finally {
			if (value instanceof Scriptable) {
				if (expression.getExpectedValueClass() == String.class) {
					value = ((Scriptable) value).getDefaultValue(String.class);
				} else if (Number.class.isAssignableFrom(expression.getExpectedValueClass())) {
					value = ((Scriptable) value).getDefaultValue(Number.class);
				} else if (expression.getExpectedValueClass() == Boolean.class) {
					value = ((Scriptable) value).getDefaultValue(Boolean.class);
				} else {
					value = ((Scriptable) value).getDefaultValue(String.class);
				}
			} else if (value == Undefined.instance) {
				value = null;
			} else if (value == Scriptable.NOT_FOUND) {
				value = null;
			}
			expression.setCurrentValue(value);
			expression.setErrorMessage(errorMessage);
			/*
			 * Update the dependencies...
			 */
			expression.updateDependencies(myDependencies);
			setCurrentExpression(null);
		}
	}

	public static void addDependency(EObject obj, EStructuralFeature sf) {
		LogUtils.debug(obj, obj + " - " + sf.getName());
		final IScriptDependency dependency = IScriptEngineFactory.eINSTANCE.createScriptDependency();
		dependency.setObject(obj);
		dependency.setFeature(sf);

		myDependencies.add(dependency);
	}

	public static void addDependency(EObject obj, EStructuralFeature sf, int index) {
		LogUtils.debug(obj, obj + " - " + sf.getName() + "[" + index + "]");
		final IScriptDependency dependency = IScriptEngineFactory.eINSTANCE.createScriptDependency();
		dependency.setObject(obj);
		dependency.setFeature(sf);
		dependency.setIndex(index);

		myDependencies.add(dependency);
	}

	public static void addDependency(EObject obj, EStructuralFeature sf, Object key) {
		LogUtils.debug(obj, obj + " - " + sf.getName() + "[" + key + "]");
		final IScriptDependency dependency = IScriptEngineFactory.eINSTANCE.createScriptDependency();
		dependency.setObject(obj);
		dependency.setFeature(sf);
		dependency.setKey(key);

		myDependencies.add(dependency);
	}

	/**
	 * An {@link ImporterTopLevel} scope that "knows" about {@link IScriptEvaluationContext}
	 */
	public class MyTopLevel extends ImporterTopLevel {

		/**
		 * Constructs and returns a new top-level scope.
		 * 
		 * @param cx the context
		 */
		public MyTopLevel(Context cx) {
			super(cx);
		}

		@Override
		public Object get(String name, Scriptable start) {
			/*
			 * Look for the name first between the current evaluation context variables - and parents
			 */
			final IScriptExpression expression = getCurrentExpression();
			if (expression != null) {
				IScriptEvaluationContext context = expression.getEvaluationContext();
				while (context != null) {
					if (context.getVariables().containsKey(name)) {
						addDependency(context, IScriptEnginePackage.Literals.SCRIPT_EVALUATION_CONTEXT__VARIABLES, name);
						final Object o = context.getVariables().get(name);
						return Context.javaToJS(o, this);
					}
					context = context.getParent();
				}
			}

			/*
			 * Fall back on the "normal" global variables
			 */
			return super.get(name, start);
		}

		@Override
		public Object[] getIds() {
			final Set<Object> contextIDs = new HashSet<Object>(Arrays.asList(super.getIds()));

			final IScriptExpression expression = getCurrentExpression();
			if (expression != null) {
				IScriptEvaluationContext context = expression.getEvaluationContext();
				while (context != null) {
					contextIDs.addAll(context.getVariables().keySet());
					context = context.getParent();
				}
			}

			return contextIDs.toArray();
		}
	}

}
