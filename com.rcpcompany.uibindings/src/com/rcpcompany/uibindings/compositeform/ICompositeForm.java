/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.compositeform;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.internal.compositeform.CompositeFormManagerImpl;
import com.rcpcompany.uibindings.utils.IFormCreator;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Composite Form</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeForm#getDescriptor <em>Descriptor
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeForm#getFormCreator <em>Form Creator
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.compositeform.ICompositeForm#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeForm()
 * @generated
 */
public interface ICompositeForm extends EObject {
	/**
	 * Factory methods for {@link ICompositeFormManager}.
	 */
	public final class Factory {
		private Factory() {
		}

		/**
		 * Creates the composite form for the specified ID.
		 * 
		 * @param form the form that will contain the composite form
		 * @param id the ID of the composite form
		 * @return the sub form
		 */
		public static ICompositeForm createForm(IFormCreator form, String id) {
			return CompositeFormManagerImpl.createForm(form, id);
		}
	}

	/**
	 * Returns the value of the '<em><b>Descriptor</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Descriptor</em>' reference.
	 * @see #setDescriptor(ICompositeFormDescriptor)
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeForm_Descriptor()
	 * @generated
	 */
	ICompositeFormDescriptor getDescriptor();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeForm#getDescriptor
	 * <em>Descriptor</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Descriptor</em>' reference.
	 * @see #getDescriptor()
	 * @generated
	 */
	void setDescriptor(ICompositeFormDescriptor value);

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
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeForm_FormCreator()
	 * @generated
	 */
	IFormCreator getFormCreator();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeForm#getFormCreator
	 * <em>Form Creator</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Form Creator</em>' attribute.
	 * @see #getFormCreator()
	 * @generated
	 */
	void setFormCreator(IFormCreator value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list. The list
	 * contents are of type {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart}. It
	 * is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getForm <em>Form</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPackage#getCompositeForm_Parts()
	 * @see com.rcpcompany.uibindings.compositeform.ICompositeFormPart#getForm
	 * @generated
	 */
	EList<ICompositeFormPart> getParts();

	/**
	 * Creates the composite form.
	 */
	void create();

} // ICompositeForm
