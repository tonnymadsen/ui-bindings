/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.scripting;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.scripting.IScriptDependency;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptExpression;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Script Dependency</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptDependencyImpl#getObject <em>Object
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptDependencyImpl#getFeature <em>
 * Feature</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptDependencyImpl#getExpressions <em>
 * Expressions</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptDependencyImpl#getIndex <em>Index
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptDependencyImpl#getKey <em>Key</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ScriptDependencyImpl extends EObjectImpl implements IScriptDependency {
	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EObject object;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature feature;

	/**
	 * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<IScriptExpression> expressions;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final Object KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected Object key = KEY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ScriptDependencyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IScriptEnginePackage.Literals.SCRIPT_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setObject(EObject newObject) {
		final EObject oldObject = object;
		object = newObject;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IScriptEnginePackage.SCRIPT_DEPENDENCY__OBJECT,
					oldObject, object));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EStructuralFeature getFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFeature(EStructuralFeature newFeature) {
		final EStructuralFeature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IScriptEnginePackage.SCRIPT_DEPENDENCY__FEATURE,
					oldFeature, feature));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IScriptExpression> getExpressions() {
		if (expressions == null) {
			expressions = new EObjectWithInverseEList.ManyInverse<IScriptExpression>(IScriptExpression.class, this,
					IScriptEnginePackage.SCRIPT_DEPENDENCY__EXPRESSIONS,
					IScriptEnginePackage.SCRIPT_EXPRESSION__DEPENDENCIES);
		}
		return expressions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setIndex(int newIndex) {
		final int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IScriptEnginePackage.SCRIPT_DEPENDENCY__INDEX,
					oldIndex, index));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setKey(Object newKey) {
		final Object oldKey = key;
		key = newKey;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IScriptEnginePackage.SCRIPT_DEPENDENCY__KEY, oldKey,
					key));
		}
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
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__EXPRESSIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getExpressions()).basicAdd(otherEnd, msgs);
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
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__EXPRESSIONS:
			return ((InternalEList<?>) getExpressions()).basicRemove(otherEnd, msgs);
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
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__OBJECT:
			return getObject();
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__FEATURE:
			return getFeature();
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__EXPRESSIONS:
			return getExpressions();
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__INDEX:
			return getIndex();
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__KEY:
			return getKey();
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
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__OBJECT:
			setObject((EObject) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__FEATURE:
			setFeature((EStructuralFeature) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__EXPRESSIONS:
			getExpressions().clear();
			getExpressions().addAll((Collection<? extends IScriptExpression>) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__INDEX:
			setIndex((Integer) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__KEY:
			setKey(newValue);
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
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__OBJECT:
			setObject((EObject) null);
			return;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__FEATURE:
			setFeature((EStructuralFeature) null);
			return;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__EXPRESSIONS:
			getExpressions().clear();
			return;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__INDEX:
			setIndex(INDEX_EDEFAULT);
			return;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__KEY:
			setKey(KEY_EDEFAULT);
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
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__OBJECT:
			return object != null;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__FEATURE:
			return feature != null;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__EXPRESSIONS:
			return expressions != null && !expressions.isEmpty();
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__INDEX:
			return index != INDEX_EDEFAULT;
		case IScriptEnginePackage.SCRIPT_DEPENDENCY__KEY:
			return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
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
		result.append(" (index: ");
		result.append(index);
		result.append(", key: ");
		result.append(key);
		result.append(')');
		return result.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
		result = prime * result + index;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final ScriptDependencyImpl other = (ScriptDependencyImpl) obj;
		if (feature == null) {
			if (other.feature != null) return false;
		} else if (!feature.equals(other.feature)) return false;
		if (index != other.index) return false;
		if (key == null) {
			if (other.key != null) return false;
		} else if (!key.equals(other.key)) return false;
		if (object == null) {
			if (other.object != null) return false;
		} else if (!object.equals(other.object)) return false;
		return true;
	}

} // ScriptDependencyImpl
