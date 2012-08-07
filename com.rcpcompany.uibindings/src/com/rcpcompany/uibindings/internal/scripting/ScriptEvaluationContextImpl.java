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
package com.rcpcompany.uibindings.internal.scripting;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.internal.StringToObjectMapEntryImpl;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Script Evaluation Context</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptEvaluationContextImpl#getParent
 * <em>Parent</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptEvaluationContextImpl#getChildren
 * <em>Children</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptEvaluationContextImpl#getVariables
 * <em>Variables</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.scripting.ScriptEvaluationContextImpl#getExpressions
 * <em>Expressions</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ScriptEvaluationContextImpl extends EObjectImpl implements IScriptEvaluationContext {
	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected IScriptEvaluationContext parent;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<IScriptEvaluationContext> children;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' map. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Object> variables;

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
	 * @generated NOT
	 */
	protected ScriptEvaluationContextImpl() {
		super();

		// eAdapters().add(new AdapterImpl() {
		// @Override
		// public void notifyChanged(Notification msg) {
		// if (msg.isTouch()) return;
		//
		// if (msg.getFeature() ==
		// IScriptEnginePackage.Literals.SCRIPT_EVALUATION_CONTEXT__VARIABLES) {
		// //
		// switch (msg.getEventType()) {
		// case Notification.REMOVE:
		// case Notification.SET:
		// final StringToObjectMapEntryImpl entry = (StringToObjectMapEntryImpl) msg.getOldValue();
		// entry.eAdapters().remove(this);
		// break;
		// case Notification.REMOVE_MANY:
		// final List<StringToObjectMapEntryImpl> entries = (List<StringToObjectMapEntryImpl>) msg
		// .getOldValue();
		// for (final StringToObjectMapEntryImpl e : entries) {
		// e.eAdapters().remove(this);
		// }
		// break;
		// }
		// switch (msg.getEventType()) {
		// case Notification.ADD:
		// case Notification.SET:
		// final StringToObjectMapEntryImpl entry = (StringToObjectMapEntryImpl) msg.getNewValue();
		// entry.eAdapters().add(this);
		// break;
		// case Notification.ADD_MANY:
		// final List<StringToObjectMapEntryImpl> entries = (List<StringToObjectMapEntryImpl>) msg
		// .getNewValue();
		// for (final StringToObjectMapEntryImpl e : entries) {
		// e.eAdapters().add(this);
		// }
		// break;
		// }
		// reevaluateExpressions();
		// } else if (msg.getFeature() ==
		// IUIBindingsPackage.Literals.STRING_TO_OBJECT_MAP_ENTRY__KEY
		// || msg.getFeature() == IUIBindingsPackage.Literals.STRING_TO_OBJECT_MAP_ENTRY__VALUE) {
		// reevaluateExpressions();
		// }
		// }
		// });
	}

	@Override
	public void reevaluateExpressions() {
		for (final IScriptExpression sc : getExpressions()) {
			sc.evaluate();
		}

		for (final IScriptEvaluationContext ec : getChildren()) {
			ec.reevaluateExpressions();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IScriptEnginePackage.Literals.SCRIPT_EVALUATION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IScriptEvaluationContext getParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetParent(IScriptEvaluationContext newParent, NotificationChain msgs) {
		final IScriptEvaluationContext oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__PARENT, oldParent, newParent);
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
	public void setParent(IScriptEvaluationContext newParent) {
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null) {
				msgs = ((InternalEObject) parent).eInverseRemove(this,
						IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__CHILDREN, IScriptEvaluationContext.class, msgs);
			}
			if (newParent != null) {
				msgs = ((InternalEObject) newParent).eInverseAdd(this,
						IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__CHILDREN, IScriptEvaluationContext.class, msgs);
			}
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__PARENT, newParent, newParent));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IScriptEvaluationContext> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseEList<IScriptEvaluationContext>(IScriptEvaluationContext.class, this,
					IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__CHILDREN,
					IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<String, Object> getVariables() {
		if (variables == null) {
			variables = new EcoreEMap<String, Object>(IUIBindingsPackage.Literals.STRING_TO_OBJECT_MAP_ENTRY,
					StringToObjectMapEntryImpl.class, this, IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IScriptExpression> getExpressions() {
		if (expressions == null) {
			expressions = new EObjectWithInverseEList<IScriptExpression>(IScriptExpression.class, this,
					IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS,
					IScriptEnginePackage.SCRIPT_EXPRESSION__EVALUATION_CONTEXT);
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
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__PARENT:
			if (parent != null) {
				msgs = ((InternalEObject) parent).eInverseRemove(this,
						IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__CHILDREN, IScriptEvaluationContext.class, msgs);
			}
			return basicSetParent((IScriptEvaluationContext) otherEnd, msgs);
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__CHILDREN:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getChildren()).basicAdd(otherEnd, msgs);
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS:
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
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__PARENT:
			return basicSetParent(null, msgs);
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__CHILDREN:
			return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__VARIABLES:
			return ((InternalEList<?>) getVariables()).basicRemove(otherEnd, msgs);
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS:
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
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__PARENT:
			return getParent();
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__CHILDREN:
			return getChildren();
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__VARIABLES:
			if (coreType)
				return getVariables();
			else
				return getVariables().map();
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS:
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
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__PARENT:
			setParent((IScriptEvaluationContext) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__CHILDREN:
			getChildren().clear();
			getChildren().addAll((Collection<? extends IScriptEvaluationContext>) newValue);
			return;
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__VARIABLES:
			((EStructuralFeature.Setting) getVariables()).set(newValue);
			return;
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS:
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
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__PARENT:
			setParent((IScriptEvaluationContext) null);
			return;
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__CHILDREN:
			getChildren().clear();
			return;
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__VARIABLES:
			getVariables().clear();
			return;
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS:
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
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__PARENT:
			return parent != null;
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__CHILDREN:
			return children != null && !children.isEmpty();
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__VARIABLES:
			return variables != null && !variables.isEmpty();
		case IScriptEnginePackage.SCRIPT_EVALUATION_CONTEXT__EXPRESSIONS:
			return expressions != null && !expressions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Map<String, Object> collectVariables() {
		final Map<String, Object> vars = new HashMap<String, Object>();
		collectVariables(vars);

		return vars;
	}

	private void collectVariables(Map<String, Object> variables) {
		final IScriptEvaluationContext parentContext = getParent();
		if (parentContext instanceof ScriptEvaluationContextImpl) {
			((ScriptEvaluationContextImpl) parentContext).collectVariables(variables);
		}

		variables.putAll(getVariables().map());
	}

} // ScriptEvaluationContextImpl
