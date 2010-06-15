/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>UI Attribute Factory Descriptor</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getTypeName <em>Type Name
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getAttribute <em>Attribute
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getFactory <em>Factory</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttributeFactoryDescriptor()
 * @generated
 */
public interface IUIAttributeFactoryDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Name</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see #setTypeName(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttributeFactoryDescriptor_TypeName()
	 * @generated
	 */
	String getTypeName();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getTypeName
	 * <em>Type Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type Name</em>' attribute.
	 * @see #getTypeName()
	 * @generated
	 */
	void setTypeName(String value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attribute</em>' attribute.
	 * @see #setAttribute(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttributeFactoryDescriptor_Attribute()
	 * @generated
	 */
	String getAttribute();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getAttribute
	 * <em>Attribute</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Attribute</em>' attribute.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(String value);

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
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getUIAttributeFactoryDescriptor_Factory()
	 * @generated
	 */
	CEObjectHolder<IUIAttributeFactory> getFactory();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IUIAttributeFactoryDescriptor#getFactory <em>Factory</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Factory</em>' attribute.
	 * @see #getFactory()
	 * @generated
	 */
	void setFactory(CEObjectHolder<IUIAttributeFactory> value);

} // IUIAttributeFactoryDescriptor
