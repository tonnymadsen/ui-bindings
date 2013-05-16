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
package com.rcpcompany.uibindings.internal;

import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.rcpcompany.uibindings.IQuickfixProposalProcessor;
import com.rcpcompany.uibindings.IQuickfixProposalProcessorDescriptor;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Quickfix Proposal Processor Descriptor</b></em> '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorDescriptorImpl#getModelType
 * <em>Model Type</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorDescriptorImpl#getFeature
 * <em>Feature</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorDescriptorImpl#getSource
 * <em>Source</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorDescriptorImpl#getCode
 * <em>Code</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorDescriptorImpl#getMessagePattern
 * <em>Message Pattern</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.QuickfixProposalProcessorDescriptorImpl#getProcessor
 * <em>Processor</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class QuickfixProposalProcessorDescriptorImpl extends EObjectImpl implements
		IQuickfixProposalProcessorDescriptor {
	/**
	 * The default value of the '{@link #getModelType() <em>Model Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelType()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelType() <em>Model Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelType()
	 * @generated
	 * @ordered
	 */
	protected String modelType = MODEL_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeature() <em>Feature</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected String feature = FEATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final int CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected int code = CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessagePattern() <em>Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMessagePattern()
	 * @generated
	 * @ordered
	 */
	protected static final Pattern MESSAGE_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessagePattern() <em>Message Pattern</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMessagePattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern messagePattern = MESSAGE_PATTERN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProcessor() <em>Processor</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProcessor()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<IQuickfixProposalProcessor> processor;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public QuickfixProposalProcessorDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getModelType() {
		return modelType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setModelType(String newModelType) {
		final String oldModelType = modelType;
		modelType = newModelType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MODEL_TYPE, oldModelType, modelType));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFeature(String newFeature) {
		final String oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__FEATURE, oldFeature, feature));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setSource(String newSource) {
		final String oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__SOURCE, oldSource, source));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setCode(int newCode) {
		final int oldCode = code;
		code = newCode;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__CODE, oldCode, code));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Pattern getMessagePattern() {
		return messagePattern;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setMessagePattern(Pattern newMessagePattern) {
		final Pattern oldMessagePattern = messagePattern;
		messagePattern = newMessagePattern;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MESSAGE_PATTERN, oldMessagePattern,
					messagePattern));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<IQuickfixProposalProcessor> getProcessor() {
		return processor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setProcessor(CEObjectHolder<IQuickfixProposalProcessor> newProcessor) {
		final CEObjectHolder<IQuickfixProposalProcessor> oldProcessor = processor;
		processor = newProcessor;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__PROCESSOR, oldProcessor, processor));
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
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MODEL_TYPE:
			return getModelType();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__FEATURE:
			return getFeature();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__SOURCE:
			return getSource();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__CODE:
			return getCode();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MESSAGE_PATTERN:
			return getMessagePattern();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__PROCESSOR:
			return getProcessor();
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
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MODEL_TYPE:
			setModelType((String) newValue);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__FEATURE:
			setFeature((String) newValue);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__SOURCE:
			setSource((String) newValue);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__CODE:
			setCode((Integer) newValue);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MESSAGE_PATTERN:
			setMessagePattern((Pattern) newValue);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__PROCESSOR:
			setProcessor((CEObjectHolder<IQuickfixProposalProcessor>) newValue);
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
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MODEL_TYPE:
			setModelType(MODEL_TYPE_EDEFAULT);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__FEATURE:
			setFeature(FEATURE_EDEFAULT);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__SOURCE:
			setSource(SOURCE_EDEFAULT);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__CODE:
			setCode(CODE_EDEFAULT);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MESSAGE_PATTERN:
			setMessagePattern(MESSAGE_PATTERN_EDEFAULT);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__PROCESSOR:
			setProcessor((CEObjectHolder<IQuickfixProposalProcessor>) null);
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
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MODEL_TYPE:
			return MODEL_TYPE_EDEFAULT == null ? modelType != null : !MODEL_TYPE_EDEFAULT.equals(modelType);
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__FEATURE:
			return FEATURE_EDEFAULT == null ? feature != null : !FEATURE_EDEFAULT.equals(feature);
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__SOURCE:
			return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__CODE:
			return code != CODE_EDEFAULT;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__MESSAGE_PATTERN:
			return MESSAGE_PATTERN_EDEFAULT == null ? messagePattern != null : !MESSAGE_PATTERN_EDEFAULT
					.equals(messagePattern);
		case IUIBindingsPackage.QUICKFIX_PROPOSAL_PROCESSOR_DESCRIPTOR__PROCESSOR:
			return processor != null;
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
		result.append(" (modelType: "); //$NON-NLS-1$
		result.append(modelType);
		result.append(", feature: "); //$NON-NLS-1$
		result.append(feature);
		result.append(", source: "); //$NON-NLS-1$
		result.append(source);
		result.append(", code: "); //$NON-NLS-1$
		result.append(code);
		result.append(", messagePattern: "); //$NON-NLS-1$
		result.append(messagePattern);
		result.append(", processor: "); //$NON-NLS-1$
		result.append(processor);
		result.append(')');
		return result.toString();
	}

} // QuickfixProposalProcessorDescriptorImpl
