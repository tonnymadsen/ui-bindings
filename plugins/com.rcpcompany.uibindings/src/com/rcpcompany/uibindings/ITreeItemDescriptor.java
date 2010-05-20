/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * 
 * This interface describes one possible item in a viewer tree. The information can come from a number of sources:
 * <ul>
 * <li>It can be declared via the <code>uibindings</code> extension point</li>
 * <li>It can be added directly to {@link IManager#getTreeItems()}</li>
 * <li>It can be constructed automatically if no information is available</li>
 * </ul>
 * 
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemDescriptor#getId <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemDescriptor#getChildren <em>Children</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemDescriptor#getCe <em>Ce</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemDescriptor#getModelTypes <em>Model Types</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.ITreeItemDescriptor#getNewWizardID <em>New Wizard ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemDescriptor()
 * @generated
 */
public interface ITreeItemDescriptor extends IArgumentProvider {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemDescriptor_Id()
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.ITreeItemDescriptor#getId <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list. The list contents are of type
	 * {@link com.rcpcompany.uibindings.ITreeItemRelation}. It is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.ITreeItemRelation#getParent <em>Parent</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemDescriptor_Children()
	 * @see com.rcpcompany.uibindings.ITreeItemRelation#getParent
	 * @generated
	 */
	EList<ITreeItemRelation> getChildren();

	/**
	 * Returns the value of the '<em><b>Ce</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ce</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Ce</em>' attribute.
	 * @see #setCe(IConfigurationElement)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemDescriptor_Ce()
	 * @generated
	 */
	IConfigurationElement getCe();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.ITreeItemDescriptor#getCe <em>Ce</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Ce</em>' attribute.
	 * @see #getCe()
	 * @generated
	 */
	void setCe(IConfigurationElement value);

	/**
	 * Returns the value of the '<em><b>Model Types</b></em>' attribute list. The list contents are of type
	 * {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Types</em>' attribute list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Types</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemDescriptor_ModelTypes()
	 * @generated
	 */
	EList<String> getModelTypes();

	/**
	 * Returns the value of the '<em><b>New Wizard ID</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Wizard ID</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>New Wizard ID</em>' attribute.
	 * @see #setNewWizardID(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getTreeItemDescriptor_NewWizardID()
	 * @generated
	 */
	String getNewWizardID();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.ITreeItemDescriptor#getNewWizardID
	 * <em>New Wizard ID</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>New Wizard ID</em>' attribute.
	 * @see #getNewWizardID()
	 * @generated
	 */
	void setNewWizardID(String value);

} // ITreeItemDescriptor
