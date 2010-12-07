/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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
		}
		return super.eIsSet(featureID);
	}

} // ScriptDependencyImpl
