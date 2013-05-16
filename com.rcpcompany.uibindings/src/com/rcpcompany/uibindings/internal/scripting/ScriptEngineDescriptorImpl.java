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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.internal.InternalConstants;
import com.rcpcompany.uibindings.scripting.IScriptEngine;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Script Engine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptEngineDescriptorImpl#getLanguage
 * <em>Language</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.scripting.ScriptEngineDescriptorImpl#getExpressions
 * <em>Expressions</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptEngineDescriptorImpl#getEngine <em>
 * Engine</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ScriptEngineDescriptorImpl extends EObjectImpl implements IScriptEngineDescriptor {
	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected String language = LANGUAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<IScriptExpression> expressions;

	/**
	 * The cached value of the '{@link #getEngine() <em>Engine</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getEngine()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<IScriptEngine> engine;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ScriptEngineDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IScriptEnginePackage.Literals.SCRIPT_ENGINE_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IScriptExpression> getExpressions() {
		if (expressions == null) {
			expressions = new EObjectContainmentWithInverseEList<IScriptExpression>(IScriptExpression.class, this,
					IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__EXPRESSIONS,
					IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE);
		}
		return expressions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<IScriptEngine> getEngine() {
		return engine;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setEngine(CEObjectHolder<IScriptEngine> newEngine) {
		final CEObjectHolder<IScriptEngine> oldEngine = engine;
		engine = newEngine;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__ENGINE, oldEngine, engine));
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
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__EXPRESSIONS:
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
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__EXPRESSIONS:
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
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__LANGUAGE:
			return getLanguage();
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__EXPRESSIONS:
			return getExpressions();
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__ENGINE:
			return getEngine();
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
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__ENGINE:
			setEngine((CEObjectHolder<IScriptEngine>) newValue);
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
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__ENGINE:
			setEngine((CEObjectHolder<IScriptEngine>) null);
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
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__LANGUAGE:
			return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__EXPRESSIONS:
			return expressions != null && !expressions.isEmpty();
		case IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__ENGINE:
			return engine != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return "ScriptEngine[" + getLanguage() + "]";
	}

	@Override
	public void init(String language, IConfigurationElement ce) {
		this.language = language;

		setEngine(new CEObjectHolder<IScriptEngine>(ce, InternalConstants.ENGINE_TAG));
	}

} // ScriptEngineImpl
