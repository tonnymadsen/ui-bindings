/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.scripting.internal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.rcpcompany.uibindings.IBindingDataType;
import com.rcpcompany.uibindings.moao.IMOAO;
import com.rcpcompany.uibindings.moao.internal.MOAOFacetImpl;
import com.rcpcompany.uibindings.scripting.IFeatureScript;
import com.rcpcompany.uibindings.scripting.IScriptEnginePackage;
import com.rcpcompany.uibindings.scripting.IScriptEvaluationContext;
import com.rcpcompany.uibindings.scripting.IScriptExpression;
import com.rcpcompany.uibindings.scripting.IScriptManager;
import com.rcpcompany.uibindings.scripting.IScriptingPackage;
import com.rcpcompany.uibindings.scripting.ScriptEngineException;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Script</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.rcpcompany.uibindings.scripting.internal.FeatureScriptImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.scripting.internal.FeatureScriptImpl#getLanguage <em>Language</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.scripting.internal.FeatureScriptImpl#getScript <em>Script</em>}</li>
 *   <li>{@link com.rcpcompany.uibindings.scripting.internal.FeatureScriptImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureScriptImpl extends MOAOFacetImpl implements IFeatureScript {
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
	 * The default value of the '{@link #getScript() <em>Script</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScript() <em>Script</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected String script = SCRIPT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected IScriptExpression expression;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected FeatureScriptImpl() {
		super();

		eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.isTouch()) return;

				if (msg.getFeature() == IScriptingPackage.Literals.FEATURE_SCRIPT__EXPRESSION) {
					IScriptExpression e;
					e = (IScriptExpression) msg.getOldValue();
					if (e != null) {
						e.eAdapters().remove(this);
					}
					e = (IScriptExpression) msg.getNewValue();
					if (e != null) {
						e.eAdapters().add(this);
						updateValue();
					}
				} else if (msg.getFeature() == IScriptEnginePackage.Literals.SCRIPT_EXPRESSION__CURRENT_VALUE) {
					updateValue();
				} else if (msg.getFeature() == IScriptingPackage.Literals.FEATURE_SCRIPT__SCRIPT) {
					updateExpression();
				} else if (msg.getFeature() == IScriptingPackage.Literals.FEATURE_SCRIPT__LANGUAGE) {
					updateExpression();
				}
			}
		});
	}

	/**
	 * Updates the language and expression of the facet based on the script
	 */
	protected void updateExpression() {
		IScriptExpression e = getExpression();
		if (e != null && (e.getEngine() == null || !e.getEngine().getLanguage().equals(getLanguage()))) {
			e.dispose();
			setExpression(null);
			e = null;
		}
		if (e == null) {
			/*
			 * Need the language first
			 */
			if (getLanguage() == null) return;

			final IBindingDataType dt = IBindingDataType.Factory.create(null, getFeature());
			final IScriptManager manager = IScriptManager.Factory.getManager();
			final IScriptEvaluationContext context = manager.getRegisteredEvaluationContext(getObject());
			try {
				e = manager.addScript(getLanguage(), getScript(), dt.getDataType(), context, null);
				setExpression(e);
			} catch (final ScriptEngineException ex) {
				LogUtils.error(this, ex);
				return;
			}
		} else if (e.getScript() == null || !e.getScript().equals(getScript())) {
			e.setScript(getScript());
		}
		e.evaluate();
	}

	/**
	 * Updates the value of the feature of the object based on the expression.
	 */
	protected void updateValue() {
		final IScriptExpression e = getExpression();
		final IMOAO obj = getObject();
		final EStructuralFeature f = getFeature();
		if (e == null || obj == null || f == null) return;
		obj.eSet(f, e.getCurrentValue());
	}

	@Override
	public void dispose() {
		if (getExpression() != null) {
			getExpression().dispose();
		}
		setObject(null);
		setFeature(null);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IScriptingPackage.Literals.FEATURE_SCRIPT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EStructuralFeature getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (EStructuralFeature)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IScriptingPackage.FEATURE_SCRIPT__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFeature(EStructuralFeature newFeature) {
		EStructuralFeature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IScriptingPackage.FEATURE_SCRIPT__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLanguage(String newLanguage) {
		String oldLanguage = language;
		language = newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IScriptingPackage.FEATURE_SCRIPT__LANGUAGE, oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getScript() {
		return script;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScript(String newScript) {
		String oldScript = script;
		script = newScript;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IScriptingPackage.FEATURE_SCRIPT__SCRIPT, oldScript, script));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IScriptExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(IScriptExpression newExpression) {
		IScriptExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IScriptingPackage.FEATURE_SCRIPT__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IScriptingPackage.FEATURE_SCRIPT__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case IScriptingPackage.FEATURE_SCRIPT__LANGUAGE:
				return getLanguage();
			case IScriptingPackage.FEATURE_SCRIPT__SCRIPT:
				return getScript();
			case IScriptingPackage.FEATURE_SCRIPT__EXPRESSION:
				return getExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IScriptingPackage.FEATURE_SCRIPT__FEATURE:
				setFeature((EStructuralFeature)newValue);
				return;
			case IScriptingPackage.FEATURE_SCRIPT__LANGUAGE:
				setLanguage((String)newValue);
				return;
			case IScriptingPackage.FEATURE_SCRIPT__SCRIPT:
				setScript((String)newValue);
				return;
			case IScriptingPackage.FEATURE_SCRIPT__EXPRESSION:
				setExpression((IScriptExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IScriptingPackage.FEATURE_SCRIPT__FEATURE:
				setFeature((EStructuralFeature)null);
				return;
			case IScriptingPackage.FEATURE_SCRIPT__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case IScriptingPackage.FEATURE_SCRIPT__SCRIPT:
				setScript(SCRIPT_EDEFAULT);
				return;
			case IScriptingPackage.FEATURE_SCRIPT__EXPRESSION:
				setExpression((IScriptExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IScriptingPackage.FEATURE_SCRIPT__FEATURE:
				return feature != null;
			case IScriptingPackage.FEATURE_SCRIPT__LANGUAGE:
				return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
			case IScriptingPackage.FEATURE_SCRIPT__SCRIPT:
				return SCRIPT_EDEFAULT == null ? script != null : !SCRIPT_EDEFAULT.equals(script);
			case IScriptingPackage.FEATURE_SCRIPT__EXPRESSION:
				return expression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (language: ");
		result.append(language);
		result.append(", script: ");
		result.append(script);
		result.append(')');
		return result.toString();
	}

} // Script
