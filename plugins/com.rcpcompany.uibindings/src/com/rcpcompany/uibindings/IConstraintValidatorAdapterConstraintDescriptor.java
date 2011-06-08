/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.validators.IConstraintValidatorAdapterConstraintProvider;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Constraint Validator Adapter Constraint Descriptor</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IConstraintValidatorAdapterConstraintDescriptor#getPriority
 * <em>Priority</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IConstraintValidatorAdapterConstraintDescriptor#getProvider
 * <em>Provider</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getConstraintValidatorAdapterConstraintDescriptor()
 * @generated
 */
public interface IConstraintValidatorAdapterConstraintDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getConstraintValidatorAdapterConstraintDescriptor_Priority()
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IConstraintValidatorAdapterConstraintDescriptor#getPriority
	 * <em>Priority</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Provider</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Provider</em>' attribute.
	 * @see #setProvider(CEObjectHolder)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getConstraintValidatorAdapterConstraintDescriptor_Provider()
	 * @generated
	 */
	CEObjectHolder<IConstraintValidatorAdapterConstraintProvider> getProvider();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IConstraintValidatorAdapterConstraintDescriptor#getProvider
	 * <em>Provider</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(CEObjectHolder<IConstraintValidatorAdapterConstraintProvider> value);

} // IConstraintValidatorAdapterConstraintDescriptor
