/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Class Info</b></em>'. <!-- end-user-doc
 * -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IModelClassInfo#getClassName <em>Class Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IModelClassInfo#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getModelClassInfo()
 * @model
 * @generated
 */
public interface IModelClassInfo extends IModelInfo {
	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getModelClassInfo_ClassName()
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibindings.IModelClassInfo#getClassName <em>Class Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' map. The key is of type {@link java.lang.String}, and the
	 * value is of type {@link com.rcpcompany.uibindings.IModelFeatureInfo}, <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Features</em>' map.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getModelClassInfo_Features()
	 * @generated
	 */
	EMap<String, IModelFeatureInfo> getFeatures();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' map. The key is of type {@link java.lang.String}, and the value
	 * is of type {@link com.rcpcompany.uibindings.IModelClassInfo}, <!-- begin-user-doc -->
	 * <p>
	 * The types map is used to map from a type name to a {@link IModelClassInfo} object for that type. The map is only
	 * used for {@link IModelClassInfo} objects that are found directly from the {@link IManager}. Thus there are not
	 * types in two levels.
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Types</em>' map.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getModelClassInfo_Types()
	 * @generated
	 */
	EMap<String, IModelClassInfo> getTypes();

} // IModelClassInfo
