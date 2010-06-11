/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibinding.tests.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Test Container</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestContainer#getChildren <em>Children</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.TestContainer#getCurrent <em>Current</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestContainer()
 * @model
 * @generated
 */
public interface TestContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list. The list contents are of type
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject}. It is bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibinding.tests.model.TestObject#getParent <em>Parent</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestContainer_Children()
	 * @see com.rcpcompany.uibinding.tests.model.TestObject#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<TestObject> getChildren();

	/**
	 * Returns the value of the '<em><b>Current</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Current</em>' reference.
	 * @see #isSetCurrent()
	 * @see #unsetCurrent()
	 * @see #setCurrent(TestObject)
	 * @see com.rcpcompany.uibinding.tests.model.TestModelPackage#getTestContainer_Current()
	 * @model unsettable="true"
	 * @generated
	 */
	TestObject getCurrent();

	/**
	 * Sets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestContainer#getCurrent <em>Current</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Current</em>' reference.
	 * @see #isSetCurrent()
	 * @see #unsetCurrent()
	 * @see #getCurrent()
	 * @generated
	 */
	void setCurrent(TestObject value);

	/**
	 * Unsets the value of the '{@link com.rcpcompany.uibinding.tests.model.TestContainer#getCurrent <em>Current</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isSetCurrent()
	 * @see #getCurrent()
	 * @see #setCurrent(TestObject)
	 * @generated
	 */
	void unsetCurrent();

	/**
	 * Returns whether the value of the '{@link com.rcpcompany.uibinding.tests.model.TestContainer#getCurrent
	 * <em>Current</em>}' reference is set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return whether the value of the '<em>Current</em>' reference is set.
	 * @see #unsetCurrent()
	 * @see #getCurrent()
	 * @see #setCurrent(TestObject)
	 * @generated
	 */
	boolean isSetCurrent();

} // TestContainer
