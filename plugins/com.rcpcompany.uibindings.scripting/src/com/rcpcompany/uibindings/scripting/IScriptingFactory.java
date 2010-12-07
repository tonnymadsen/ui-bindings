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
 * 
 * @see com.rcpcompany.uibindings.scripting.IScriptingPackage
 * @generated
 */
public interface IScriptingFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	IScriptingFactory eINSTANCE = com.rcpcompany.uibindings.scripting.internal.ScriptingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Feature Script</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Feature Script</em>'.
	 * @generated
	 */
	IFeatureScript createFeatureScript();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	IScriptingPackage getScriptingPackage();

} // IScriptingFactory
