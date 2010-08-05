/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Editor Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getId <em>Id</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getName <em>Name</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getModelTypes <em>Model Types</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#isFallbackEditor <em>Fallback Editor</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getFactory <em>Factory</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getImage <em>Image</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorPartDescriptor()
 * @generated
 */
public interface IEditorPartDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorPartDescriptor_Id()
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorPartDescriptor_Name()
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Model Types</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Types</em>' attribute list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Types</em>' attribute list.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorPartDescriptor_ModelTypes()
	 * @generated
	 */
	EList<String> getModelTypes();

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorPartDescriptor_Priority()
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

	/**
	 * Returns the value of the '<em><b>Fallback Editor</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fallback Editor</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fallback Editor</em>' attribute.
	 * @see #setFallbackEditor(boolean)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorPartDescriptor_FallbackEditor()
	 * @generated
	 */
	boolean isFallbackEditor();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#isFallbackEditor <em>Fallback Editor</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fallback Editor</em>' attribute.
	 * @see #isFallbackEditor()
	 * @generated
	 */
	void setFallbackEditor(boolean value);

	/**
	 * Returns the value of the '<em><b>Factory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factory</em>' attribute.
	 * @see #setFactory(CEObjectHolder)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorPartDescriptor_Factory()
	 * @generated
	 */
	CEObjectHolder<IEditorPartFactory> getFactory();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getFactory <em>Factory</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factory</em>' attribute.
	 * @see #getFactory()
	 * @generated
	 */
	void setFactory(CEObjectHolder<IEditorPartFactory> value);

	/**
	 * Returns the value of the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' attribute isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' attribute.
	 * @see #setImage(CEResourceHolder)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorPartDescriptor_Image()
	 * @generated
	 */
	CEResourceHolder getImage();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getImage <em>Image</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' attribute.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(CEResourceHolder value);

} // IEditorDescriptor
