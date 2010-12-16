/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.compositeform;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;

import com.rcpcompany.uibindings.utils.IFormCreator;

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
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getTitle <em>Title</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getImage <em>Image</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#isEnabled <em>Enabled</em>}
 * </li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#isOpen <em>Open</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getOperations <em>
 * Operations</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getFormCreator <em>Form
 * Creator</em>}</li>
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
	 * Returns the value of the '<em><b>Title</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPart_Title()
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getTitle <em>Title</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @see #setImage(Image)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPart_Image()
	 * @generated
	 */
	Image getImage();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getImage <em>Image</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(Image value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute. The default value is
	 * <code>"true"</code>. <!-- begin-user-doc -->
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

	/**
	 * Returns the value of the '<em><b>Open</b></em>' attribute. The default value is
	 * <code>"true"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Open</em>' attribute.
	 * @see #setOpen(boolean)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPart_Open()
	 * @generated
	 */
	boolean isOpen();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#isOpen <em>Open</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Open</em>' attribute.
	 * @see #isOpen()
	 * @generated
	 */
	void setOpen(boolean value);

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operations</em>' attribute.
	 * @see #setOperations(ICompositeFormPartOperations)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPart_Operations()
	 * @generated
	 */
	ICompositeFormPartOperations getOperations();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getOperations
	 * <em>Operations</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Operations</em>' attribute.
	 * @see #getOperations()
	 * @generated
	 */
	void setOperations(ICompositeFormPartOperations value);

	/**
	 * Returns the value of the '<em><b>Form Creator</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Form Creator</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Form Creator</em>' attribute.
	 * @see #setFormCreator(IFormCreator)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeFormPart_FormCreator()
	 * @generated
	 */
	IFormCreator getFormCreator();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getFormCreator
	 * <em>Form Creator</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Form Creator</em>' attribute.
	 * @see #getFormCreator()
	 * @generated
	 */
	void setFormCreator(IFormCreator value);

	/**
	 * Updates the visual aspects of this part.
	 */
	void updateUI();

} // ICompositeFormPart
