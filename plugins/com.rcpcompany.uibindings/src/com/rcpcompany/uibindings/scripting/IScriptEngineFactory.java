/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.scripting;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * @see com.rcpcompany.uibindings.scripting.IScriptEnginePackage
 * @generated
 */
public interface IScriptEngineFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	IScriptEngineFactory eINSTANCE = com.rcpcompany.uibindings.internal.scripting.ScriptEngineFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Script Manager</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Script Manager</em>'.
	 * @generated
	 */
	IScriptManager createScriptManager();

	/**
	 * Returns a new object of class '<em>Descriptor</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Descriptor</em>'.
	 * @generated
	 */
	IScriptEngineDescriptor createScriptEngineDescriptor();

	/**
	 * Returns a new object of class '<em>Script Evaluation Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Script Evaluation Context</em>'.
	 * @generated
	 */
	IScriptEvaluationContext createScriptEvaluationContext();

	/**
	 * Returns a new object of class '<em>Script Expression</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Script Expression</em>'.
	 * @generated
	 */
	IScriptExpression createScriptExpression();

	/**
	 * Returns a new object of class '<em>Script Dependency</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return a new object of class '<em>Script Dependency</em>'.
	 * @generated
	 */
	IScriptDependency createScriptDependency();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	IScriptEnginePackage getScriptEnginePackage();

} // IScriptEngineFactory
