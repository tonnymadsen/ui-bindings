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
package com.rcpcompany.uibindings.scripting;

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.IDisposable;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Script Engine</b></em>'.
 * <!-- end-user-doc -->
 * 
 * 
 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptEngine()
 * @generated
 */
public interface IScriptEngine extends EObject, IDisposable {

	/**
	 * Executes the specified expression.
	 * 
	 * @param expression the script expression to evaluate
	 */
	void evaluate(IScriptExpression expression);
} // IScriptEngine
