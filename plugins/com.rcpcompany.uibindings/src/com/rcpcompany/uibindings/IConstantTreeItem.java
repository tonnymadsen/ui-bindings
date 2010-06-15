/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Anon Cell Item</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IConstantTreeItem#getDescriptor <em>Descriptor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IConstantTreeItem#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getConstantTreeItem()
 * @generated
 */
public interface IConstantTreeItem extends IArgumentProvider {

	/**
	 * Returns the value of the '<em><b>Descriptor</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Descriptor</em>' reference.
	 * @see #setDescriptor(ITreeItemDescriptor)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getConstantTreeItem_Descriptor()
	 * @generated
	 */
	ITreeItemDescriptor getDescriptor();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IConstantTreeItem#getDescriptor
	 * <em>Descriptor</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Descriptor</em>' reference.
	 * @see #getDescriptor()
	 * @generated
	 */
	void setDescriptor(ITreeItemDescriptor value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(EObject)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getConstantTreeItem_Target()
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IConstantTreeItem#getTarget
	 * <em>Target</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);
} // IAnonCellItem
