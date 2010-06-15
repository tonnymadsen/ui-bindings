/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * <p>
 * This interface is used by all class that can have arguments declared in <code>plugin.xml</code>.
 * </p>
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IArgumentProvider#getDeclaredArguments <em>Declared
 * Arguments</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getArgumentProvider()
 * @generated
 */
public interface IArgumentProvider extends EObject {
	/**
	 * Returns the value of the '<em><b>Declared Arguments</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.Object}, <!--
	 * begin-user-doc -->
	 * <p>
	 * The map contains all the defined arguments in the <code>plugin.xml</code> - the exact
	 * declarations used depends on the object with the arguments.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Declared Arguments</em>' map.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getArgumentProvider_DeclaredArguments()
	 * @generated
	 */
	EMap<String, Object> getDeclaredArguments();

} // IArgumentProvider
