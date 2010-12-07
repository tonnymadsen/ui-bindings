/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.scripting;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc -->
 * 
 * The description of a single scripting engine.
 * 
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getLanguage <em>Language
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getExpressions <em>
 * Expressions</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getEngine <em>Engine</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptEngineDescriptor()
 * @generated
 */
public interface IScriptEngineDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * The name of the language of this engine.
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptEngineDescriptor_Language()
	 * @generated
	 */
	String getLanguage();

	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.scripting.IScriptExpression}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptExpression#getEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptEngineDescriptor_Expressions()
	 * @see com.rcpcompany.uibindings.scripting.IScriptExpression#getEngine
	 * @generated
	 */
	EList<IScriptExpression> getExpressions();

	/**
	 * Returns the value of the '<em><b>Engine</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Engine</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Engine</em>' attribute.
	 * @see #setEngine(CEObjectHolder)
	 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage#getScriptEngineDescriptor_Engine()
	 * @generated
	 */
	CEObjectHolder<IScriptEngine> getEngine();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor#getEngine <em>Engine</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Engine</em>' attribute.
	 * @see #getEngine()
	 * @generated
	 */
	void setEngine(CEObjectHolder<IScriptEngine> value);

	/**
	 * Initializes the engine from the configuration.
	 * 
	 * @param language the language
	 * @param ce the configuration element
	 */
	void init(String language, IConfigurationElement ce);

} // IScriptEngine
