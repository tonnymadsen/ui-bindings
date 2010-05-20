/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Enum Decorator Provider</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IEnumDecoratorProvider#isAddingDefaultMappings <em>Adding Default Mappings</em>}
 * </li>
 * <li>{@link com.rcpcompany.uibindings.IEnumDecoratorProvider#getBaseMappings <em>Base Mappings</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getEnumDecoratorProvider()
 * @generated
 */
public interface IEnumDecoratorProvider extends IDecoratorProvider {
	/**
	 * Returns the value of the '<em><b>Adding Default Mappings</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adding Default Mappings</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Adding Default Mappings</em>' attribute.
	 * @see #setAddingDefaultMappings(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getEnumDecoratorProvider_AddingDefaultMappings()
	 * @generated
	 */
	boolean isAddingDefaultMappings();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IEnumDecoratorProvider#isAddingDefaultMappings
	 * <em>Adding Default Mappings</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Adding Default Mappings</em>' attribute.
	 * @see #isAddingDefaultMappings()
	 * @generated
	 */
	void setAddingDefaultMappings(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Mappings</b></em>' containment reference list. The list contents are of
	 * type {@link com.rcpcompany.uibindings.IEnumDecoratorProviderEntry}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Mappings</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Mappings</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getEnumDecoratorProvider_BaseMappings()
	 * @generated
	 */
	EList<IEnumDecoratorProviderEntry> getBaseMappings();

} // IEnumDecoratorProvider
