/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.scripting;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Script Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getObject <em>Object</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getFeature <em>Feature</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptDependency()
 * @generated
 */
public interface IScriptDependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptDependency_Object()
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EStructuralFeature)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptDependency_Feature()
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' reference list.
	 * The list contents are of type {@link com.rcpcompany.uibindings.scripting.IScriptExpression}.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.scripting.IScriptExpression#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' reference list.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptDependency_Expressions()
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getDependencies
	 * @generated
	 */
	EList<IScriptExpression> getExpressions();

} // IScriptDependency
