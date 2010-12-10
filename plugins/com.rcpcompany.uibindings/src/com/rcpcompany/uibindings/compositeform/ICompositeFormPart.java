/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.compositeform;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Part</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getForm <em>Form</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getDescriptor <em>
 * Descriptor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#isEnabled <em>Enabled</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPart()
 * @generated
 */
public interface ICompositeFormPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Form</b></em>' container reference. It is bidirectional and
	 * its opposite is '{@link com.rcpcompany.uibindings.compositeform.ICompositeForm#getParts
	 * <em>Parts</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form</em>' container reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Form</em>' container reference.
	 * @see #setForm(ICompositeForm)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPart_Form()
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeForm#getParts
	 * @generated
	 */
	ICompositeForm getForm();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getForm <em>Form</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Form</em>' container reference.
	 * @see #getForm()
	 * @generated
	 */
	void setForm(ICompositeForm value);

	/**
	 * Returns the value of the '<em><b>Descriptor</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Descriptor</em>' reference.
	 * @see #setDescriptor(ICompositeFormPartDescriptor)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPart_Descriptor()
	 * @generated
	 */
	ICompositeFormPartDescriptor getDescriptor();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getDescriptor
	 * <em>Descriptor</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Descriptor</em>' reference.
	 * @see #getDescriptor()
	 * @generated
	 */
	void setDescriptor(ICompositeFormPartDescriptor value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPart_Enabled()
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#isEnabled <em>Enabled</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

} // ICompositeFormPart
