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
 * <em><b>EMF Observable Factory Descriptor</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor#getPackagePrefix <em>Package
 * Prefix</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor#getFactory <em>Factory</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getEMFObservableFactoryDescriptor()
 * @generated
 */
public interface IEMFObservableFactoryDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Package Prefix</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Prefix</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Package Prefix</em>' attribute.
	 * @see #setPackagePrefix(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getEMFObservableFactoryDescriptor_PackagePrefix()
	 * @generated
	 */
	String getPackagePrefix();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor#getPackagePrefix
	 * <em>Package Prefix</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Package Prefix</em>' attribute.
	 * @see #getPackagePrefix()
	 * @generated
	 */
	void setPackagePrefix(String value);

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
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getEMFObservableFactoryDescriptor_Factory()
	 * @generated
	 */
	CEObjectHolder<IEMFObservableFactory> getFactory();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IEMFObservableFactoryDescriptor#getFactory <em>Factory</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Factory</em>' attribute.
	 * @see #getFactory()
	 * @generated
	 */
	void setFactory(CEObjectHolder<IEMFObservableFactory> value);

} // IEMFObservableFactoryDescriptor
