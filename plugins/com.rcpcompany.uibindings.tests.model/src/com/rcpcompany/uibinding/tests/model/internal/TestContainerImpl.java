/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibinding.tests.model.internal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibinding.tests.model.TestContainer;
import com.rcpcompany.uibinding.tests.model.TestModelPackage;
import com.rcpcompany.uibinding.tests.model.TestObject;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Test Container</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestContainerImpl#getChildren <em>Children</em>}</li>
 * <li>{@link com.rcpcompany.uibinding.tests.model.internal.TestContainerImpl#getCurrent <em>Current</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TestContainerImpl extends EObjectImpl implements TestContainer {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<TestObject> children;

	/**
	 * The cached value of the '{@link #getCurrent() <em>Current</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getCurrent()
	 * @generated
	 * @ordered
	 */
	protected TestObject current;

	/**
	 * This is true if the Current reference has been set. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean currentESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TestContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestModelPackage.Literals.TEST_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<TestObject> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<TestObject>(TestObject.class, this,
					TestModelPackage.TEST_CONTAINER__CHILDREN, TestModelPackage.TEST_OBJECT__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TestObject getCurrent() {
		if (current != null && current.eIsProxy()) {
			final InternalEObject oldCurrent = (InternalEObject) current;
			current = (TestObject) eResolveProxy(oldCurrent);
			if (current != oldCurrent) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestModelPackage.TEST_CONTAINER__CURRENT,
							oldCurrent, current));
				}
			}
		}
		return current;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TestObject basicGetCurrent() {
		return current;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCurrent(TestObject newCurrent) {
		final TestObject oldCurrent = current;
		current = newCurrent;
		final boolean oldCurrentESet = currentESet;
		currentESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, TestModelPackage.TEST_CONTAINER__CURRENT, oldCurrent,
					current, !oldCurrentESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetCurrent() {
		final TestObject oldCurrent = current;
		final boolean oldCurrentESet = currentESet;
		current = null;
		currentESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET, TestModelPackage.TEST_CONTAINER__CURRENT,
					oldCurrent, null, oldCurrentESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetCurrent() {
		return currentESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TestModelPackage.TEST_CONTAINER__CHILDREN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TestModelPackage.TEST_CONTAINER__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case TestModelPackage.TEST_CONTAINER__CHILDREN:
			return getChildren();
		case TestModelPackage.TEST_CONTAINER__CURRENT:
			if (resolve) {
				return getCurrent();
			}
			return basicGetCurrent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case TestModelPackage.TEST_CONTAINER__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends TestObject>) newValue);
			return;
		case TestModelPackage.TEST_CONTAINER__CURRENT:
			setCurrent((TestObject) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case TestModelPackage.TEST_CONTAINER__CHILDREN:
			getChildren().clear();
			return;
		case TestModelPackage.TEST_CONTAINER__CURRENT:
			unsetCurrent();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case TestModelPackage.TEST_CONTAINER__CHILDREN:
			return children != null && !children.isEmpty();
		case TestModelPackage.TEST_CONTAINER__CURRENT:
			return isSetCurrent();
		}
		return super.eIsSet(featureID);
	}

} // TestContainerImpl
