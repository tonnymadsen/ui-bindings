/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.compositeform;

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Part Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getForm <em>Form
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getPriority <em>
 * Priority</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getTitle <em>
 * Title</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getImage <em>
 * Image</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getFactory <em>
 * Factory</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPartDescriptor()
 * @generated
 */
public interface ICompositeFormPartDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Form</b></em>' container reference. It is bidirectional and
	 * its opposite is '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getParts
	 * <em>Parts</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form</em>' container reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Form</em>' container reference.
	 * @see #setForm(ICompositeFormDescriptor)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPartDescriptor_Form()
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor#getParts
	 * @generated
	 */
	ICompositeFormDescriptor getForm();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getForm
	 * <em>Form</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Form</em>' container reference.
	 * @see #getForm()
	 * @generated
	 */
	void setForm(ICompositeFormDescriptor value);

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
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPartDescriptor_Priority()
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getPriority
	 * <em>Priority</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Factory</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Factory</em>' attribute.
	 * @see #setFactory(CEObjectHolder)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPartDescriptor_Factory()
	 * @generated
	 */
	CEObjectHolder<ICompositeFormPartFactory> getFactory();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getFactory
	 * <em>Factory</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Factory</em>' attribute.
	 * @see #getFactory()
	 * @generated
	 */
	void setFactory(CEObjectHolder<ICompositeFormPartFactory> value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPartDescriptor_Title()
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getTitle
	 * <em>Title</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see #setImage(CEResourceHolder)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPartDescriptor_Image()
	 * @generated
	 */
	CEResourceHolder getImage();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor#getImage
	 * <em>Image</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(CEResourceHolder value);

} // ICompositeFormPartDescriptor
