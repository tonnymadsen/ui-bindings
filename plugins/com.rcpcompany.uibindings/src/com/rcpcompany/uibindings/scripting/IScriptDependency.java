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
 *   <li>{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getIndex <em>Index</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getKey <em>Key</em>}</li>
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
	 * If the meaning of the '<em>Expressions</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' reference list.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptDependency_Expressions()
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getDependencies
	 * @generated
	 */
	EList<IScriptExpression> getExpressions();

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptDependency_Index()
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(Object)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptDependency_Key()
	 * @generated
	 */
	Object getKey();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.scripting.IScriptDependency#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(Object value);

} // IScriptDependency
