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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.scripting.IScriptDependency;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;
import com.rcpcompany.uibindings.utils.IManagerRunnable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Script Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl#getEngine <em>Engine
 * </em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl#getEvaluationContext
 * <em>Evaluation Context</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl#getScript <em>Script
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl#getDependencies <em>
 * Dependencies</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl#getExpectedValueClass
 * <em>Expected Value Class</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl#getCurrentValue <em>
 * Current Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl#getObservableValue
 * <em>Observable Value</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptExpressionImpl#getErrorMessage <em>
 * Error Message</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ScriptExpressionImpl extends EObjectImpl implements IScriptExpression {
	/**
	 * The cached value of the '{@link #getEvaluationContext() <em>Evaluation Context</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEvaluationContext()
	 * @generated
	 * @ordered
	 */
	protected IScriptEvaluationContext evaluationContext;

	/**
	 * The default value of the '{@link #getScript() <em>Script</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScript() <em>Script</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected String script = SCRIPT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<IScriptDependency> dependencies;

	/**
	 * The cached value of the '{@link #getExpectedValueClass() <em>Expected Value Class</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExpectedValueClass()
	 * @generated
	 * @ordered
	 */
	protected Class<?> expectedValueClass;

	/**
	 * The default value of the '{@link #getCurrentValue() <em>Current Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCurrentValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object CURRENT_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCurrentValue() <em>Current Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCurrentValue()
	 * @generated
	 * @ordered
	 */
	protected Object currentValue = CURRENT_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getObservableValue() <em>Observable Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getObservableValue()
	 * @generated
	 * @ordered
	 */
	protected static final IObservableValue OBSERVABLE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObservableValue() <em>Observable Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getObservableValue()
	 * @generated
	 * @ordered
	 */
	protected IObservableValue observableValue = OBSERVABLE_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getErrorMessage() <em>Error Message</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getErrorMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getErrorMessage() <em>Error Message</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getErrorMessage()
	 * @generated
	 * @ordered
	 */
	protected String errorMessage = ERROR_MESSAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ScriptExpressionImpl() {
		super();
	}

	@Override
	public void dispose() {
		setEngine(null);

		IManagerRunnable.Factory.cancelAsyncExec("evaluate", this);

		/*
		 * TODO - if last use, then disconnect
		 */
		setEvaluationContext(null);
		if (eIsSet(IScriptEnginePackage.Literals.SCRIPT_EXPRESSION__OBSERVABLE_VALUE)) {
			getObservableValue().dispose();
		}
		if (eIsSet(IScriptEnginePackage.Literals.SCRIPT_EXPRESSION__DEPENDENCIES)) {
			getDependencies().clear();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IScriptEnginePackage.Literals.SCRIPT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptEngineDescriptor getEngine() {
		if (eContainerFeatureID() != IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE) return null;
		return (IScriptEngineDescriptor) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetEngine(IScriptEngineDescriptor newEngine, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newEngine, IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setEngine(IScriptEngineDescriptor newEngine) {
		if (newEngine != eInternalContainer()
				|| (eContainerFeatureID() != IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE && newEngine != null)) {
			if (EcoreUtil.isAncestor(this, newEngine))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newEngine != null) {
				msgs = ((InternalEObject) newEngine)
						.eInverseAdd(this, IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__EXPRESSIONS,
								IScriptEngineDescriptor.class, msgs);
			}
			msgs = basicSetEngine(newEngine, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE,
					newEngine, newEngine));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptEvaluationContext getEvaluationContext() {
		return evaluationContext;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetEvaluationContext(IScriptEvaluationContext newEvaluationContext,
			NotificationChain msgs) {
		final IScriptEvaluationContext oldEvaluationContext = evaluationContext;
		evaluationContext = newEvaluationContext;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					IScriptEnginePackage.SCRIPT_EXPRESSION__EVALUATION_CONTEXT, oldEvaluationContext,
					newEvaluationContext);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setEvaluationContext(IScriptEvaluationContext newEvaluationContext) {
		if (newEvaluationContext != evaluationContext) {
			NotificationChain msgs = null;
			if (evaluationContext != null) {
				msgs = ((InternalEObject) evaluationContext).eInverseRemove(this,
						IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS, IScriptEvaluationContext.class,
						msgs);
			}
			if (newEvaluationContext != null) {
				msgs = ((InternalEObject) newEvaluationContext).eInverseAdd(this,
						IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS, IScriptEvaluationContext.class,
						msgs);
			}
			msgs = basicSetEvaluationContext(newEvaluationContext, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IScriptEnginePackage.SCRIPT_EXPRESSION__EVALUATION_CONTEXT, newEvaluationContext,
					newEvaluationContext));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getScript() {
		return script;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setScript(String newScript) {
		final String oldScript = script;
		script = newScript;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IScriptEnginePackage.SCRIPT_EXPRESSION__SCRIPT,
					oldScript, script));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IScriptDependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectWithInverseEList.ManyInverse<IScriptDependency>(IScriptDependency.class, this,
					IScriptEnginePackage.SCRIPT_EXPRESSION__DEPENDENCIES,
					IScriptEnginePackage.SCRIPT_DEPENDENCY__EXPRESSIONS);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Class<?> getExpectedValueClass() {
		return expectedValueClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setExpectedValueClass(Class<?> newExpectedValueClass) {
		final Class<?> oldExpectedValueClass = expectedValueClass;
		expectedValueClass = newExpectedValueClass;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IScriptEnginePackage.SCRIPT_EXPRESSION__EXPECTED_VALUE_CLASS, oldExpectedValueClass,
					expectedValueClass));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getCurrentValue() {
		return currentValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCurrentValueGen(Object newCurrentValue) {
		final Object oldCurrentValue = currentValue;
		currentValue = newCurrentValue;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IScriptEnginePackage.SCRIPT_EXPRESSION__CURRENT_VALUE, oldCurrentValue, currentValue));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void setCurrentValue(Object newCurrentValue) {
		/*
		 * More intelligence:
		 * 
		 * - String: all toString OK
		 * 
		 * - Numbers
		 */

		if (newCurrentValue != null && getExpectedValueClass() == String.class) {
			newCurrentValue = "" + newCurrentValue;
		}
		if (newCurrentValue != null && !getExpectedValueClass().isInstance(newCurrentValue)) {
			setErrorMessage("Expected " + getExpectedValueClass().getName() + ", got value " + newCurrentValue);
			return;
		}
		setErrorMessage(null);
		setCurrentValueGen(newCurrentValue);
		if (eIsSet(IScriptEnginePackage.Literals.SCRIPT_EXPRESSION__OBSERVABLE_VALUE)) {
			getObservableValue().setValue(newCurrentValue);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IObservableValue getObservableValue() {
		if (observableValue == null) {
			final IBindingDataType dt = IBindingDataType.Factory.create(null, getExpectedValueClass());

			observableValue = WritableValue.withValueType(dt.getEType() != null ? dt.getEType()
					: getExpectedValueClass());
			observableValue.setValue(getCurrentValue());
		}
		return observableValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setErrorMessage(String newErrorMessage) {
		final String oldErrorMessage = errorMessage;
		errorMessage = newErrorMessage;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IScriptEnginePackage.SCRIPT_EXPRESSION__ERROR_MESSAGE, oldErrorMessage, errorMessage));
		}
	}

	@Override
	public void evaluate() {
		getEngine().getEngine().getObject().evaluate(this);
	}

	@Override
	public void updateDependencies(List<IScriptDependency> newDependencies) {
		/*
		 * Sort the new dependencies, sort they can be compared with the current ones
		 */
		Collections.sort(newDependencies, new Comparator<IScriptDependency>() {
			@Override
			public int compare(IScriptDependency o1, IScriptDependency o2) {
				return o1.hashCode() - o2.hashCode();
			}
		});
		final EList<IScriptDependency> oldDependencies = getDependencies();

		/*
		 * If the dependencies are the same - which is very likely - then just return...
		 */
		if (oldDependencies.equals(newDependencies)) return;

		final IScriptManager manager = IScriptManager.Factory.getManager();
		final ListIterator<IScriptDependency> dIterator = newDependencies.listIterator();
		while (dIterator.hasNext()) {
			IScriptDependency d = dIterator.next();
			/*
			 * Find the dependency in the current manager dependencies. If not found, then create
			 * it.
			 */
			d = manager.addDependency(d);
			dIterator.set(d);
		}

		/*
		 * Replace the previous list
		 */
		oldDependencies.clear();
		oldDependencies.addAll(newDependencies);

		/*
		 * Prune any left overs
		 */
		manager.pruneDependencies();
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
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetEngine((IScriptEngineDescriptor) otherEnd, msgs);
		case IScriptEnginePackage.SCRIPT_EXPRESSION__EVALUATION_CONTEXT:
			if (evaluationContext != null) {
				msgs = ((InternalEObject) evaluationContext).eInverseRemove(this,
						IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS, IScriptEvaluationContext.class,
						msgs);
			}
			return basicSetEvaluationContext((IScriptEvaluationContext) otherEnd, msgs);
		case IScriptEnginePackage.SCRIPT_EXPRESSION__DEPENDENCIES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDependencies()).basicAdd(otherEnd, msgs);
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
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE:
			return basicSetEngine(null, msgs);
		case IScriptEnginePackage.SCRIPT_EXPRESSION__EVALUATION_CONTEXT:
			return basicSetEvaluationContext(null, msgs);
		case IScriptEnginePackage.SCRIPT_EXPRESSION__DEPENDENCIES:
			return ((InternalEList<?>) getDependencies()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE:
			return eInternalContainer().eInverseRemove(this,
					IScriptEnginePackage.SCRIPT_ENGINE_DESCRIPTOR__EXPRESSIONS, IScriptEngineDescriptor.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE:
			return getEngine();
		case IScriptEnginePackage.SCRIPT_EXPRESSION__EVALUATION_CONTEXT:
			return getEvaluationContext();
		case IScriptEnginePackage.SCRIPT_EXPRESSION__SCRIPT:
			return getScript();
		case IScriptEnginePackage.SCRIPT_EXPRESSION__DEPENDENCIES:
			return getDependencies();
		case IScriptEnginePackage.SCRIPT_EXPRESSION__EXPECTED_VALUE_CLASS:
			return getExpectedValueClass();
		case IScriptEnginePackage.SCRIPT_EXPRESSION__CURRENT_VALUE:
			return getCurrentValue();
		case IScriptEnginePackage.SCRIPT_EXPRESSION__OBSERVABLE_VALUE:
			return getObservableValue();
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ERROR_MESSAGE:
			return getErrorMessage();
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
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE:
			setEngine((IScriptEngineDescriptor) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__EVALUATION_CONTEXT:
			setEvaluationContext((IScriptEvaluationContext) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__SCRIPT:
			setScript((String) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__DEPENDENCIES:
			getDependencies().clear();
			getDependencies().addAll((Collection<? extends IScriptDependency>) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__EXPECTED_VALUE_CLASS:
			setExpectedValueClass((Class<?>) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__CURRENT_VALUE:
			setCurrentValue(newValue);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ERROR_MESSAGE:
			setErrorMessage((String) newValue);
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
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE:
			setEngine((IScriptEngineDescriptor) null);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__EVALUATION_CONTEXT:
			setEvaluationContext((IScriptEvaluationContext) null);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__SCRIPT:
			setScript(SCRIPT_EDEFAULT);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__DEPENDENCIES:
			getDependencies().clear();
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__EXPECTED_VALUE_CLASS:
			setExpectedValueClass((Class<?>) null);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__CURRENT_VALUE:
			setCurrentValue(CURRENT_VALUE_EDEFAULT);
			return;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ERROR_MESSAGE:
			setErrorMessage(ERROR_MESSAGE_EDEFAULT);
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
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ENGINE:
			return getEngine() != null;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__EVALUATION_CONTEXT:
			return evaluationContext != null;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__SCRIPT:
			return SCRIPT_EDEFAULT == null ? script != null : !SCRIPT_EDEFAULT.equals(script);
		case IScriptEnginePackage.SCRIPT_EXPRESSION__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
		case IScriptEnginePackage.SCRIPT_EXPRESSION__EXPECTED_VALUE_CLASS:
			return expectedValueClass != null;
		case IScriptEnginePackage.SCRIPT_EXPRESSION__CURRENT_VALUE:
			return CURRENT_VALUE_EDEFAULT == null ? currentValue != null : !CURRENT_VALUE_EDEFAULT.equals(currentValue);
		case IScriptEnginePackage.SCRIPT_EXPRESSION__OBSERVABLE_VALUE:
			return OBSERVABLE_VALUE_EDEFAULT == null ? observableValue != null : !OBSERVABLE_VALUE_EDEFAULT
					.equals(observableValue);
		case IScriptEnginePackage.SCRIPT_EXPRESSION__ERROR_MESSAGE:
			return ERROR_MESSAGE_EDEFAULT == null ? errorMessage != null : !ERROR_MESSAGE_EDEFAULT.equals(errorMessage);
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
		result.append(" (script: ");
		result.append(script);
		result.append(", expectedValueClass: ");
		result.append(expectedValueClass);
		result.append(", currentValue: ");
		result.append(currentValue);
		result.append(", observableValue: ");
		result.append(observableValue);
		result.append(", errorMessage: ");
		result.append(errorMessage);
		result.append(')');
		return result.toString();
	}

} // ScriptContextImpl
