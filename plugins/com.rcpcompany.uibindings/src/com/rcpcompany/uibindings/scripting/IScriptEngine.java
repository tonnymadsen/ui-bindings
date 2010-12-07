/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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
