/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibinding.tests.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Container</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.Container#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference. It is bidirectional and its opposite
	 * is '{@link com.rcpcompany.uibinding.tests.model.TestObject#getParent <em>Parent</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Children</em>' containment reference.
	 * @see #setChildren(TestObject)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getContainer_Children()
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	TestObject getChildren();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.Container#getChildren <em>Children</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Children</em>' containment reference.
	 * @see #getChildren()
	 * @generated
	 */
	void setChildren(TestObject value);

} // Container
