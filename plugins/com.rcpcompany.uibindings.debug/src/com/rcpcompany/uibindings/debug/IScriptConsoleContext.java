/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.debug;

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.scripting.IScriptExpression;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Script Console Context</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getObject <em>Object</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getLanguage <em>Language</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getScript <em>Script</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getExpression <em>Expression
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getResult <em>Result</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getException <em>Exception</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.debug.IDebugPackage#getScriptConsoleContext()
 * @generated
 */
public interface IScriptConsoleContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see com.rcpcompany.uibindings.debug.IDebugPackage#getScriptConsoleContext_Object()
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getObject <em>Object</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see com.rcpcompany.uibindings.debug.IDebugPackage#getScriptConsoleContext_Language()
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getLanguage <em>Language</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Script</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Script</em>' attribute.
	 * @see #setScript(String)
	 * @see com.rcpcompany.uibindings.debug.IDebugPackage#getScriptConsoleContext_Script()
	 * @generated
	 */
	String getScript();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getScript <em>Script</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Script</em>' attribute.
	 * @see #getScript()
	 * @generated
	 */
	void setScript(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(IScriptExpression)
	 * @see com.rcpcompany.uibindings.debug.IDebugPackage#getScriptConsoleContext_Expression()
	 * @generated
	 */
	IScriptExpression getExpression();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getExpression
	 * <em>Expression</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(IScriptExpression value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(String)
	 * @see com.rcpcompany.uibindings.debug.IDebugPackage#getScriptConsoleContext_Result()
	 * @generated
	 */
	String getResult();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getResult <em>Result</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(String value);

	/**
	 * Returns the value of the '<em><b>Exception</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exception</em>' attribute.
	 * @see #setException(String)
	 * @see com.rcpcompany.uibindings.debug.IDebugPackage#getScriptConsoleContext_Exception()
	 * @generated
	 */
	String getException();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.debug.IScriptConsoleContext#getException <em>Exception</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Exception</em>' attribute.
	 * @see #getException()
	 * @generated
	 */
	void setException(String value);

} // IScriptConsoleContext
