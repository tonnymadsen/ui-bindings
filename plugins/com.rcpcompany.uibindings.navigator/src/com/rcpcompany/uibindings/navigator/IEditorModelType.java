/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings.navigator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Editior Model Type</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorModelType#getEditors <em>Editors</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorModelType#getPreferredEditor <em>Preferred Editor</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorModelType#getModelType <em>Model Type</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.navigator.IEditorModelType#getModelTypeEClassifier <em>Model Type EClassifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorModelType()
 * @generated
 */
public interface IEditorModelType extends EObject {
	/**
	 * Returns the value of the '<em><b>Editors</b></em>' reference list.
	 * The list contents are of type {@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor}.
	 * It is bidirectional and its opposite is '{@link com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getModelType <em>Model Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' reference list.
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorModelType_Editors()
	 * @see com.rcpcompany.uibindings.navigator.IEditorPartDescriptor#getModelType
	 * @generated
	 */
	EList<IEditorPartDescriptor> getEditors();

	/**
	 * Returns the value of the '<em><b>Preferred Editor</b></em>' reference.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Preferred Editor</em>' reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferred Editor</em>' reference.
	 * @see #setPreferredEditor(IEditorPartDescriptor)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorModelType_PreferredEditor()
	 * @generated
	 */
	IEditorPartDescriptor getPreferredEditor();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.IEditorModelType#getPreferredEditor <em>Preferred Editor</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferred Editor</em>' reference.
	 * @see #getPreferredEditor()
	 * @generated
	 */
	void setPreferredEditor(IEditorPartDescriptor value);

	/**
	 * Returns the value of the '<em><b>Model Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Type</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Type</em>' attribute.
	 * @see #setModelType(String)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorModelType_ModelType()
	 * @generated
	 */
	String getModelType();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.IEditorModelType#getModelType <em>Model Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Type</em>' attribute.
	 * @see #getModelType()
	 * @generated
	 */
	void setModelType(String value);

	/**
	 * Returns the value of the '<em><b>Model Type EClassifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Type EClassifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Type EClassifier</em>' reference.
	 * @see #setModelTypeEClassifier(EClassifier)
	 * @see com.rcpcompany.uibindings.navigator.INavigatorModelPackage#getEditorModelType_ModelTypeEClassifier()
	 * @generated
	 */
	EClassifier getModelTypeEClassifier();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.navigator.IEditorModelType#getModelTypeEClassifier <em>Model Type EClassifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Type EClassifier</em>' reference.
	 * @see #getModelTypeEClassifier()
	 * @generated
	 */
	void setModelTypeEClassifier(EClassifier value);

} // IEditiorModelType
