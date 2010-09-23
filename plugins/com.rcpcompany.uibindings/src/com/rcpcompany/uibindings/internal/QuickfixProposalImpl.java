/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
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
import org.eclipse.jface.resource.ImageDescriptor;

import com.rcpcompany.uibindings.IQuickfixProposal;
import com.rcpcompany.uibindings.IUIBindingsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Quickfix Proposal</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.QuickfixProposalImpl#getLabel <em>Label</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.QuickfixProposalImpl#getDescription <em>Description
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.QuickfixProposalImpl#getImage <em>Image</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.QuickfixProposalImpl#getRelevance <em>Relevance
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class QuickfixProposalImpl extends EObjectImpl implements IQuickfixProposal {
	@Override
	public String getContent() {
		return null; // Not used
	}

	@Override
	public int getCursorPosition() {
		return 0;
	}

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final ImageDescriptor IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected ImageDescriptor image = IMAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelevance() <em>Relevance</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRelevance()
	 * @generated
	 * @ordered
	 */
	protected static final int RELEVANCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRelevance() <em>Relevance</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRelevance()
	 * @generated
	 * @ordered
	 */
	protected int relevance = RELEVANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected QuickfixProposalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.QUICKFIX_PROPOSAL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLabel(String newLabel) {
		final String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.QUICKFIX_PROPOSAL__LABEL,
					oldLabel, label));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		final String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.QUICKFIX_PROPOSAL__DESCRIPTION,
					oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ImageDescriptor getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setImage(ImageDescriptor newImage) {
		final ImageDescriptor oldImage = image;
		image = newImage;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.QUICKFIX_PROPOSAL__IMAGE,
					oldImage, image));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getRelevance() {
		return relevance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRelevance(int newRelevance) {
		final int oldRelevance = relevance;
		relevance = newRelevance;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, IUIBindingsPackage.QUICKFIX_PROPOSAL__RELEVANCE,
					oldRelevance, relevance));
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
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__LABEL:
			return getLabel();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__DESCRIPTION:
			return getDescription();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__IMAGE:
			return getImage();
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__RELEVANCE:
			return getRelevance();
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
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__LABEL:
			setLabel((String) newValue);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__IMAGE:
			setImage((ImageDescriptor) newValue);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__RELEVANCE:
			setRelevance((Integer) newValue);
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
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__LABEL:
			setLabel(LABEL_EDEFAULT);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__IMAGE:
			setImage(IMAGE_EDEFAULT);
			return;
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__RELEVANCE:
			setRelevance(RELEVANCE_EDEFAULT);
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
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__LABEL:
			return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__IMAGE:
			return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
		case IUIBindingsPackage.QUICKFIX_PROPOSAL__RELEVANCE:
			return relevance != RELEVANCE_EDEFAULT;
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
		result.append(" (label: "); //$NON-NLS-1$
		result.append(label);
		result.append(", description: "); //$NON-NLS-1$
		result.append(description);
		result.append(", image: "); //$NON-NLS-1$
		result.append(image);
		result.append(", relevance: "); //$NON-NLS-1$
		result.append(relevance);
		result.append(')');
		return result.toString();
	}

} // QuickfixProposalImpl
