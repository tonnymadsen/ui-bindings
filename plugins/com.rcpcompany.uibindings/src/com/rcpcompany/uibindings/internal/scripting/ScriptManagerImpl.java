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

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.BasicEMap.Entry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.internal.InternalConstants;
import com.rcpcompany.uibindings.scripting.IScriptDependency;
import com.rcpcompany.uibindings.scripting.IScriptEngineDescriptor;
import com.rcpcompany.uibindings.scripting.IScriptEngineFactory;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;
import com.rcpcompany.uibindings.scripting.ScriptEngineException;
import com.rcpcompany.uibindings.utils.IManagerRunnable;
import com.rcpcompany.utils.basic.ToStringUtils;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Script Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptManagerImpl#getEngines <em>Engines
 * </em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.scripting.ScriptManagerImpl#getGlobalEvaluationContext
 * <em>Global Evaluation Context</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.scripting.ScriptManagerImpl#getRegisteredEvaluationContexts
 * <em>Registered Evaluation Contexts</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.scripting.ScriptManagerImpl#getDependencies <em>
 * Dependencies</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ScriptManagerImpl extends EObjectImpl implements IScriptManager {

	/**
	 * The singleton manager.
	 */
	private static IScriptManager MANAGER = null;

	/**
	 * Returns the singleton manager.
	 * 
	 * @return the manager
	 */
	public static IScriptManager getManager() {
		if (MANAGER == null) {
			MANAGER = IScriptEngineFactory.eINSTANCE.createScriptManager();
		}
		return MANAGER;
	}

	@Override
	public IScriptExpression addScript(String language, String script, Class<?> expectedClass,
			IScriptEvaluationContext evaluationContext, Map<String, Object> localVariables)
			throws ScriptEngineException {
		final IScriptEngineDescriptor engine = getEngines().get(language);
		if (engine == null) throw new ScriptEngineException("Not engine for language '" + language + "'");

		/*
		 * Find the¨evaluation context
		 */
		evaluationContext = getEvaluationContext(evaluationContext, localVariables);

		/*
		 * Create an expression
		 */
		final IScriptExpression expression = IScriptEngineFactory.eINSTANCE.createScriptExpression();
		expression.setEngine(engine);
		expression.setEvaluationContext(evaluationContext);
		expression.setScript(script);
		expression.setExpectedValueClass(expectedClass);

		expression.evaluate();

		return expression;
	}

	@Override
	public IScriptEvaluationContext getEvaluationContext(IScriptEvaluationContext evaluationContext,
			Map<String, Object> localVariables) {
		if (evaluationContext == null) {
			evaluationContext = getGlobalEvaluationContext();
		}
		if (localVariables != null) {
			/*
			 * Look up an existing context with the same variables.
			 */
			for (final IScriptEvaluationContext cc : evaluationContext.getChildren()) {
				if (localVariables.equals(cc.getVariables().map())) return cc;
			}

			/*
			 * Create new context
			 */
			final IScriptEvaluationContext ec = IScriptEngineFactory.eINSTANCE.createScriptEvaluationContext();
			ec.setParent(evaluationContext);
			ec.getVariables().putAll(localVariables);

			evaluationContext = ec;
		}

		return evaluationContext;
	}

	/**
	 * The cached value of the '{@link #getEngines() <em>Engines</em>}' map. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEngines()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, IScriptEngineDescriptor> engines;

	/**
	 * The cached value of the '{@link #getGlobalEvaluationContext()
	 * <em>Global Evaluation Context</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGlobalEvaluationContext()
	 * @generated
	 * @ordered
	 */
	protected IScriptEvaluationContext globalEvaluationContext;

	/**
	 * The cached value of the '{@link #getRegisteredEvaluationContexts()
	 * <em>Registered Evaluation Contexts</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRegisteredEvaluationContexts()
	 * @generated
	 * @ordered
	 */
	protected EMap<EObject, IScriptEvaluationContext> registeredEvaluationContexts;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EMap<EObject, EList<IScriptDependency>> dependencies;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ScriptManagerImpl() {
		super();

		extensionReader();

		getRegisteredEvaluationContexts().put(null, getGlobalEvaluationContext());
	}

	/**
	 * Reads all relevant extensions.
	 */
	private void extensionReader() {
		final IExtensionRegistry registry = Platform.getExtensionRegistry();

		for (final IConfigurationElement ce : registry
				.getConfigurationElementsFor(InternalConstants.SCRIPT_ENGINES_EXTENSION_POINT)) {
			final String elementName = ce.getName();
			if (elementName.equals(InternalConstants.ENGINE_TAG)) {
				final String language = ce.getAttribute(InternalConstants.LANGUAGE_TAG);
				if (language == null || language.length() == 0) {
					LogUtils.error(ce, InternalConstants.LANGUAGE_TAG + " must be specified. Ignored"); //$NON-NLS-1$
					continue;
				}

				if (getEngines().get(language) != null) {
					LogUtils.error(ce, "Duplicate declaration of language '" + language + "'. Ignored.");
					continue;
				}

				final IScriptEngineDescriptor engine = IScriptEngineFactory.eINSTANCE.createScriptEngineDescriptor();
				engine.init(language, ce);
				getEngines().put(language, engine);
			} else {
				LogUtils.error(ce, "Unknown tag: '" + ce.getName() + "'");
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IScriptEnginePackage.Literals.SCRIPT_MANAGER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<String, IScriptEngineDescriptor> getEngines() {
		if (engines == null) {
			engines = new EcoreEMap<String, IScriptEngineDescriptor>(
					IScriptEnginePackage.Literals.STRING_TO_SCRIPT_ENGINE_MAP_ENTRY,
					StringToScriptEngineMapEntryImpl.class, this, IScriptEnginePackage.SCRIPT_MANAGER__ENGINES);
		}
		return engines;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public IScriptEvaluationContext getGlobalEvaluationContext() {
		if (globalEvaluationContext == null) {
			globalEvaluationContext = IScriptEngineFactory.eINSTANCE.createScriptEvaluationContext();
		}
		return globalEvaluationContext;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<EObject, IScriptEvaluationContext> getRegisteredEvaluationContexts() {
		if (registeredEvaluationContexts == null) {
			registeredEvaluationContexts = new EcoreEMap<EObject, IScriptEvaluationContext>(
					IScriptEnginePackage.Literals.EOBJECT_TO_SCRIPT_ENGINE_MAP_ENTRY,
					EObjectToScriptEngineMapEntryImpl.class, this,
					IScriptEnginePackage.SCRIPT_MANAGER__REGISTERED_EVALUATION_CONTEXTS);
		}
		return registeredEvaluationContexts;
	}

	@Override
	public IScriptEvaluationContext getRegisteredEvaluationContext(EObject obj) {
		while (obj != null) {
			final IScriptEvaluationContext context = getRegisteredEvaluationContexts().get(obj);
			if (context != null) return context;
			obj = obj.eContainer();
		}
		return getGlobalEvaluationContext();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EMap<EObject, EList<IScriptDependency>> getDependencies() {
		if (dependencies == null) {
			dependencies = new EcoreEMap<EObject, EList<IScriptDependency>>(
					IScriptEnginePackage.Literals.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY,
					EObjectToScriptDependencyListMapEntryImpl.class, this,
					IScriptEnginePackage.SCRIPT_MANAGER__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case IScriptEnginePackage.SCRIPT_MANAGER__ENGINES:
			return ((InternalEList<?>) getEngines()).basicRemove(otherEnd, msgs);
		case IScriptEnginePackage.SCRIPT_MANAGER__REGISTERED_EVALUATION_CONTEXTS:
			return ((InternalEList<?>) getRegisteredEvaluationContexts()).basicRemove(otherEnd, msgs);
		case IScriptEnginePackage.SCRIPT_MANAGER__DEPENDENCIES:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case IScriptEnginePackage.SCRIPT_MANAGER__ENGINES:
			if (coreType)
				return getEngines();
			else
				return getEngines().map();
		case IScriptEnginePackage.SCRIPT_MANAGER__GLOBAL_EVALUATION_CONTEXT:
			return getGlobalEvaluationContext();
		case IScriptEnginePackage.SCRIPT_MANAGER__REGISTERED_EVALUATION_CONTEXTS:
			if (coreType)
				return getRegisteredEvaluationContexts();
			else
				return getRegisteredEvaluationContexts().map();
		case IScriptEnginePackage.SCRIPT_MANAGER__DEPENDENCIES:
			if (coreType)
				return getDependencies();
			else
				return getDependencies().map();
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
		case IScriptEnginePackage.SCRIPT_MANAGER__ENGINES:
			((EStructuralFeature.Setting) getEngines()).set(newValue);
			return;
		case IScriptEnginePackage.SCRIPT_MANAGER__REGISTERED_EVALUATION_CONTEXTS:
			((EStructuralFeature.Setting) getRegisteredEvaluationContexts()).set(newValue);
			return;
		case IScriptEnginePackage.SCRIPT_MANAGER__DEPENDENCIES:
			((EStructuralFeature.Setting) getDependencies()).set(newValue);
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
		case IScriptEnginePackage.SCRIPT_MANAGER__ENGINES:
			getEngines().clear();
			return;
		case IScriptEnginePackage.SCRIPT_MANAGER__REGISTERED_EVALUATION_CONTEXTS:
			getRegisteredEvaluationContexts().clear();
			return;
		case IScriptEnginePackage.SCRIPT_MANAGER__DEPENDENCIES:
			getDependencies().clear();
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
		case IScriptEnginePackage.SCRIPT_MANAGER__ENGINES:
			return engines != null && !engines.isEmpty();
		case IScriptEnginePackage.SCRIPT_MANAGER__GLOBAL_EVALUATION_CONTEXT:
			return globalEvaluationContext != null;
		case IScriptEnginePackage.SCRIPT_MANAGER__REGISTERED_EVALUATION_CONTEXTS:
			return registeredEvaluationContexts != null && !registeredEvaluationContexts.isEmpty();
		case IScriptEnginePackage.SCRIPT_MANAGER__DEPENDENCIES:
			return dependencies != null && !dependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	private IObservableList myLanguageList = null;

	@Override
	public IObservableList getLanguageList() {
		if (myLanguageList == null) {
			myLanguageList = WritableList.withElementType(EcorePackage.Literals.ESTRING);
			myLanguageList.addAll(getEngines().keySet());

			// TODO monitor changes..
		}
		return myLanguageList;
	}

	private final Adapter myDependencyAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;

			checkChangedDependencies(msg);
		};
	};

	@Override
	public IScriptDependency addDependency(IScriptDependency dependency) {
		/*
		 * Find the list of dependencies for the object of the specified dependency
		 */
		final EObject object = dependency.getObject();
		EList<IScriptDependency> dList = getDependencies().get(object);
		if (dList == null) {
			final BasicEMap.Entry<EObject, EList<IScriptDependency>> entry = (Entry<EObject, EList<IScriptDependency>>) IScriptEngineFactory.eINSTANCE
					.create(IScriptEnginePackage.Literals.EOBJECT_TO_SCRIPT_DEPENDENCY_LIST_MAP_ENTRY);
			entry.setKey(object);
			getDependencies().add(entry);
			dList = entry.getValue();
			object.eAdapters().add(myDependencyAdapter);
		}

		/*
		 * See if we have an identical entry of the list
		 */
		for (final IScriptDependency d : dList) {
			if (d.equals(dependency)) return d;
		}
		dList.add(dependency);

		return dependency;
	}

	/**
	 * Checks if any current {@link IScriptDependency} match the specified notification.
	 * <p>
	 * If one does match, all associated expressions are re-evaluated.
	 * 
	 * @param msg the notification to check
	 */
	protected void checkChangedDependencies(Notification msg) {
		final EList<IScriptDependency> dList = getDependencies().get(msg.getNotifier());

		/*
		 * Should probably never happen!
		 */
		if (dList == null) return;

		for (final IScriptDependency d : dList) {
			if (d.getFeature() != msg.getFeature()) {
				continue;
			}

			if (d.getIndex() != -1) {
				if (d.getIndex() != msg.getPosition()) {
					continue;
				}
			}

			if (d.getKey() != null) {
				// TODO
				LogUtils.debug(this, "key=" + d.getKey() + "\nmsg=" + ToStringUtils.toString(msg));
			}

			/*
			 * We have a match...
			 */
			for (final IScriptExpression e : d.getExpressions()) {
				IManagerRunnable.Factory.asyncExec("evaluate", e, new Runnable() {
					@Override
					public void run() {
						e.evaluate();
					}
				});
			}
		}
	}

	@Override
	public void pruneDependencies() {
		final Iterator<java.util.Map.Entry<EObject, EList<IScriptDependency>>> eIterator = getDependencies().entrySet()
				.iterator();
		while (eIterator.hasNext()) {
			final java.util.Map.Entry<EObject, EList<IScriptDependency>> e = eIterator.next();
			final EList<IScriptDependency> dList = e.getValue();
			final Iterator<IScriptDependency> dIterator = dList.iterator();
			while (dIterator.hasNext()) {
				final IScriptDependency d = dIterator.next();
				if (d.getExpressions().isEmpty()) {
					dIterator.remove();
				}
			}
			if (dList.isEmpty()) {
				e.getKey().eAdapters().remove(myDependencyAdapter);
				eIterator.remove();
			}
		}
	}
} // ScriptManagerImpl
