/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IArgumentInformation;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Argument Information</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.ArgumentInformationImpl#getName <em>Name</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.ArgumentInformationImpl#isLookupParent <em>Lookup
 * Parent</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.ArgumentInformationImpl#isLookupAttributeTargetType
 * <em>Lookup Attribute Target Type</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.ArgumentInformationImpl#isLookupAttributeContainingClass
 * <em>Lookup Attribute Containing Class</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.ArgumentInformationImpl#isLookupReferenceTargetType
 * <em>Lookup Reference Target Type</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.ArgumentInformationImpl#isLookupReferenceContainingClass
 * <em>Lookup Reference Containing Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ArgumentInformationImpl extends EObjectImpl implements IArgumentInformation {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isLookupParent() <em>Lookup Parent</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isLookupParent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOOKUP_PARENT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isLookupParent() <em>Lookup Parent</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isLookupParent()
	 * @generated
	 * @ordered
	 */
	protected boolean lookupParent = LOOKUP_PARENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isLookupAttributeTargetType()
	 * <em>Lookup Attribute Target Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isLookupAttributeTargetType()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOOKUP_ATTRIBUTE_TARGET_TYPE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLookupAttributeTargetType()
	 * <em>Lookup Attribute Target Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isLookupAttributeTargetType()
	 * @generated
	 * @ordered
	 */
	protected boolean lookupAttributeTargetType = LOOKUP_ATTRIBUTE_TARGET_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isLookupAttributeContainingClass()
	 * <em>Lookup Attribute Containing Class</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isLookupAttributeContainingClass()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOOKUP_ATTRIBUTE_CONTAINING_CLASS_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isLookupAttributeContainingClass()
	 * <em>Lookup Attribute Containing Class</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isLookupAttributeContainingClass()
	 * @generated
	 * @ordered
	 */
	protected boolean lookupAttributeContainingClass = LOOKUP_ATTRIBUTE_CONTAINING_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #isLookupReferenceTargetType()
	 * <em>Lookup Reference Target Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isLookupReferenceTargetType()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOOKUP_REFERENCE_TARGET_TYPE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isLookupReferenceTargetType()
	 * <em>Lookup Reference Target Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isLookupReferenceTargetType()
	 * @generated
	 * @ordered
	 */
	protected boolean lookupReferenceTargetType = LOOKUP_REFERENCE_TARGET_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isLookupReferenceContainingClass()
	 * <em>Lookup Reference Containing Class</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isLookupReferenceContainingClass()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOOKUP_REFERENCE_CONTAINING_CLASS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLookupReferenceContainingClass()
	 * <em>Lookup Reference Containing Class</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isLookupReferenceContainingClass()
	 * @generated
	 * @ordered
	 */
	protected boolean lookupReferenceContainingClass = LOOKUP_REFERENCE_CONTAINING_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ArgumentInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.ARGUMENT_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		final String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.ARGUMENT_INFORMATION__NAME,
					oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isLookupParent() {
		return lookupParent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLookupParent(boolean newLookupParent) {
		final boolean oldLookupParent = lookupParent;
		lookupParent = newLookupParent;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_PARENT, oldLookupParent, lookupParent));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isLookupAttributeTargetType() {
		return lookupAttributeTargetType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLookupAttributeTargetType(boolean newLookupAttributeTargetType) {
		final boolean oldLookupAttributeTargetType = lookupAttributeTargetType;
		lookupAttributeTargetType = newLookupAttributeTargetType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_TARGET_TYPE,
					oldLookupAttributeTargetType, lookupAttributeTargetType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isLookupAttributeContainingClass() {
		return lookupAttributeContainingClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLookupAttributeContainingClass(boolean newLookupAttributeContainingClass) {
		final boolean oldLookupAttributeContainingClass = lookupAttributeContainingClass;
		lookupAttributeContainingClass = newLookupAttributeContainingClass;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_CONTAINING_CLASS,
					oldLookupAttributeContainingClass, lookupAttributeContainingClass));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isLookupReferenceTargetType() {
		return lookupReferenceTargetType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLookupReferenceTargetType(boolean newLookupReferenceTargetType) {
		final boolean oldLookupReferenceTargetType = lookupReferenceTargetType;
		lookupReferenceTargetType = newLookupReferenceTargetType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_REFERENCE_TARGET_TYPE,
					oldLookupReferenceTargetType, lookupReferenceTargetType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isLookupReferenceContainingClass() {
		return lookupReferenceContainingClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLookupReferenceContainingClass(boolean newLookupReferenceContainingClass) {
		final boolean oldLookupReferenceContainingClass = lookupReferenceContainingClass;
		lookupReferenceContainingClass = newLookupReferenceContainingClass;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_REFERENCE_CONTAINING_CLASS,
					oldLookupReferenceContainingClass, lookupReferenceContainingClass));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IUIBindingsPackage.ARGUMENT_INFORMATION__NAME:
			return getName();
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_PARENT:
			return isLookupParent();
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_TARGET_TYPE:
			return isLookupAttributeTargetType();
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_CONTAINING_CLASS:
			return isLookupAttributeContainingClass();
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_REFERENCE_TARGET_TYPE:
			return isLookupReferenceTargetType();
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_REFERENCE_CONTAINING_CLASS:
			return isLookupReferenceContainingClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case IUIBindingsPackage.ARGUMENT_INFORMATION__NAME:
			setName((String) newValue);
			return;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_PARENT:
			setLookupParent((Boolean) newValue);
			return;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_TARGET_TYPE:
			setLookupAttributeTargetType((Boolean) newValue);
			return;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_CONTAINING_CLASS:
			setLookupAttributeContainingClass((Boolean) newValue);
			return;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_REFERENCE_TARGET_TYPE:
			setLookupReferenceTargetType((Boolean) newValue);
			return;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_REFERENCE_CONTAINING_CLASS:
			setLookupReferenceContainingClass((Boolean) newValue);
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
		case IUIBindingsPackage.ARGUMENT_INFORMATION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_PARENT:
			setLookupParent(LOOKUP_PARENT_EDEFAULT);
			return;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_TARGET_TYPE:
			setLookupAttributeTargetType(LOOKUP_ATTRIBUTE_TARGET_TYPE_EDEFAULT);
			return;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_CONTAINING_CLASS:
			setLookupAttributeContainingClass(LOOKUP_ATTRIBUTE_CONTAINING_CLASS_EDEFAULT);
			return;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_REFERENCE_TARGET_TYPE:
			setLookupReferenceTargetType(LOOKUP_REFERENCE_TARGET_TYPE_EDEFAULT);
			return;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_REFERENCE_CONTAINING_CLASS:
			setLookupReferenceContainingClass(LOOKUP_REFERENCE_CONTAINING_CLASS_EDEFAULT);
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
		case IUIBindingsPackage.ARGUMENT_INFORMATION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_PARENT:
			return lookupParent != LOOKUP_PARENT_EDEFAULT;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_TARGET_TYPE:
			return lookupAttributeTargetType != LOOKUP_ATTRIBUTE_TARGET_TYPE_EDEFAULT;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_ATTRIBUTE_CONTAINING_CLASS:
			return lookupAttributeContainingClass != LOOKUP_ATTRIBUTE_CONTAINING_CLASS_EDEFAULT;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_REFERENCE_TARGET_TYPE:
			return lookupReferenceTargetType != LOOKUP_REFERENCE_TARGET_TYPE_EDEFAULT;
		case IUIBindingsPackage.ARGUMENT_INFORMATION__LOOKUP_REFERENCE_CONTAINING_CLASS:
			return lookupReferenceContainingClass != LOOKUP_REFERENCE_CONTAINING_CLASS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		final StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", lookupParent: "); //$NON-NLS-1$
		result.append(lookupParent);
		result.append(", lookupAttributeTargetType: "); //$NON-NLS-1$
		result.append(lookupAttributeTargetType);
		result.append(", lookupAttributeContainingClass: "); //$NON-NLS-1$
		result.append(lookupAttributeContainingClass);
		result.append(", lookupReferenceTargetType: "); //$NON-NLS-1$
		result.append(lookupReferenceTargetType);
		result.append(", lookupReferenceContainingClass: "); //$NON-NLS-1$
		result.append(lookupReferenceContainingClass);
		result.append(')');
		return result.toString();
	}

} // ArgumentInformationImpl
