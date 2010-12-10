/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.compositeform;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Descriptor</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getManager <em>
 * Manager</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getId <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getParts <em>Parts
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormDescriptor()
 * @generated
 */
public interface ICompositeFormDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Manager</b></em>' container reference. It is bidirectional
	 * and its opposite is '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormManager#getForms <em>Forms</em>}
	 * '. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager</em>' container reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Manager</em>' container reference.
	 * @see #setManager(ICompositeFormManager)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormDescriptor_Manager()
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormManager#getForms
	 * @generated
	 */
	ICompositeFormManager getManager();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getManager
	 * <em>Manager</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Manager</em>' container reference.
	 * @see #getManager()
	 * @generated
	 */
	void setManager(ICompositeFormManager value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormDescriptor_Id()
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getId <em>Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list. The list
	 * contents are of type
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getForm
	 * <em>Form</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormDescriptor_Parts()
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getForm
	 * @generated
	 */
	EList<ICompositeFormPartDescriptor> getParts();

} // ICompositeFormDescriptor
