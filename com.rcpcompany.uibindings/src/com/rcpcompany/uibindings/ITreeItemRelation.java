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
package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc -->
 * 
 * This interface describes the relationship between {@link ITreeItemDescriptor tree item
 * descriptors}.
 * 
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemRelation#getParent <em>Parent</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemRelation#getDescriptor <em>Descriptor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemRelation#getFactory <em>Factory</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemRelation#getFeatureName <em>Feature Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemRelation#getPriority <em>Priority</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemRelation#getTreeIDs <em>Tree IDs</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemRelation()
 * @generated
 */
public interface ITreeItemRelation extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.ITreeItemDescriptor#getChildRelations
	 * <em>Child Relations</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(ITreeItemDescriptor)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemRelation_Parent()
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor#getChildRelations
	 * @generated
	 */
	ITreeItemDescriptor getParent();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.ITreeItemRelation#getParent
	 * <em>Parent</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(ITreeItemDescriptor value);

	/**
	 * Returns the value of the '<em><b>Descriptor</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.ITreeItemDescriptor#getParentRelations
	 * <em>Parent Relations</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Descriptor</em>' reference.
	 * @see #setDescriptor(ITreeItemDescriptor)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemRelation_Descriptor()
	 * @see com.rcpcompany.uibindings.ITreeItemDescriptor#getParentRelations
	 * @generated
	 */
	ITreeItemDescriptor getDescriptor();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.ITreeItemRelation#getDescriptor
	 * <em>Descriptor</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Descriptor</em>' reference.
	 * @see #getDescriptor()
	 * @generated
	 */
	void setDescriptor(ITreeItemDescriptor value);

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
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemRelation_Factory()
	 * @generated
	 */
	CEObjectHolder<IObservableFactory> getFactory();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.ITreeItemRelation#getFactory
	 * <em>Factory</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Factory</em>' attribute.
	 * @see #getFactory()
	 * @generated
	 */
	void setFactory(CEObjectHolder<IObservableFactory> value);

	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see #setFeatureName(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemRelation_FeatureName()
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.ITreeItemRelation#getFeatureName
	 * <em>Feature Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

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
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemRelation_Priority()
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.ITreeItemRelation#getPriority
	 * <em>Priority</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Tree IDs</b></em>' attribute list. The list contents are of
	 * type {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tree IDs</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tree IDs</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemRelation_TreeIDs()
	 * @generated
	 */
	EList<String> getTreeIDs();

} // ITreeItemRelation
