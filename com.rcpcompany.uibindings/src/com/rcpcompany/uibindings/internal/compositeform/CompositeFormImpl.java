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
package com.rcpcompany.uibindings.internal.compositeform;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.compositeform.ICompositeForm;
import com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormFactory;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPart;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartOperations;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Composite Form</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormImpl#getDescriptor <em>
 * Descriptor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormImpl#getFormCreator <em>
 * Form Creator</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormImpl#getParts <em>Parts
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CompositeFormImpl extends EObjectImpl implements ICompositeForm {
	/**
	 * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescriptor()
	 * @generated
	 * @ordered
	 */
	protected ICompositeFormDescriptor descriptor;

	/**
	 * The default value of the '{@link #getFormCreator() <em>Form Creator</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormCreator()
	 * @generated
	 * @ordered
	 */
	protected static final IFormCreator FORM_CREATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormCreator() <em>Form Creator</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFormCreator()
	 * @generated
	 * @ordered
	 */
	protected IFormCreator formCreator = FORM_CREATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ICompositeFormPart> parts;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CompositeFormImpl() {
		super();
	}

	@Override
	public void create() {
		/*
		 * First create all parts of the form
		 */
		for (final ICompositeFormPartDescriptor pd : getDescriptor().getParts()) {
			ICompositeFormPartFactory factory = null;
			try {
				factory = pd.getFactory().getObject();
			} catch (final Exception ex) {
				continue;
			}
			final ICompositeFormPart part = ICompositeFormFactory.eINSTANCE.createCompositeFormPart();
			part.setDescriptor(pd);
			part.setForm(this);
			part.setTitle(pd.getTitle());
			part.setImage(pd.getImage().getImage());
			part.setFormCreator(getFormCreator().subForm(getFormCreator().addComposite()));

			try {
				final ICompositeFormPartOperations operations = factory.create(part);
				if (operations == null) {
					LogUtils.error(pd.getFactory().getConfigurationElement(), "Factory returns null... Part ignored.");
					continue;
				}
				part.setOperations(operations);
			} catch (final Exception ex) {
				LogUtils.error(pd.getFactory().getConfigurationElement(), ex);
				continue;
			}

			getParts().add(part);
		}

		/*
		 * Now create the parts as needed
		 */
		for (final ICompositeFormPart p : getParts()) {
			p.updateUI();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ICompositeFormPackage.Literals.COMPOSITE_FORM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDescriptor(ICompositeFormDescriptor newDescriptor) {
		final ICompositeFormDescriptor oldDescriptor = descriptor;
		descriptor = newDescriptor;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ICompositeFormPackage.COMPOSITE_FORM__DESCRIPTOR,
					oldDescriptor, descriptor));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IFormCreator getFormCreator() {
		return formCreator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFormCreator(IFormCreator newFormCreator) {
		final IFormCreator oldFormCreator = formCreator;
		formCreator = newFormCreator;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ICompositeFormPackage.COMPOSITE_FORM__FORM_CREATOR,
					oldFormCreator, formCreator));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ICompositeFormPart> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentWithInverseEList<ICompositeFormPart>(ICompositeFormPart.class, this,
					ICompositeFormPackage.COMPOSITE_FORM__PARTS, ICompositeFormPackage.COMPOSITE_FORM_PART__FORM);
		}
		return parts;
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
		case ICompositeFormPackage.COMPOSITE_FORM__PARTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getParts()).basicAdd(otherEnd, msgs);
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
		case ICompositeFormPackage.COMPOSITE_FORM__PARTS:
			return ((InternalEList<?>) getParts()).basicRemove(otherEnd, msgs);
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
		case ICompositeFormPackage.COMPOSITE_FORM__DESCRIPTOR:
			return getDescriptor();
		case ICompositeFormPackage.COMPOSITE_FORM__FORM_CREATOR:
			return getFormCreator();
		case ICompositeFormPackage.COMPOSITE_FORM__PARTS:
			return getParts();
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
		case ICompositeFormPackage.COMPOSITE_FORM__DESCRIPTOR:
			setDescriptor((ICompositeFormDescriptor) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM__FORM_CREATOR:
			setFormCreator((IFormCreator) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM__PARTS:
			getParts().clear();
			getParts().addAll((Collection<? extends ICompositeFormPart>) newValue);
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
		case ICompositeFormPackage.COMPOSITE_FORM__DESCRIPTOR:
			setDescriptor((ICompositeFormDescriptor) null);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM__FORM_CREATOR:
			setFormCreator(FORM_CREATOR_EDEFAULT);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM__PARTS:
			getParts().clear();
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
		case ICompositeFormPackage.COMPOSITE_FORM__DESCRIPTOR:
			return descriptor != null;
		case ICompositeFormPackage.COMPOSITE_FORM__FORM_CREATOR:
			return FORM_CREATOR_EDEFAULT == null ? formCreator != null : !FORM_CREATOR_EDEFAULT.equals(formCreator);
		case ICompositeFormPackage.COMPOSITE_FORM__PARTS:
			return parts != null && !parts.isEmpty();
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
		result.append(" (formCreator: ");
		result.append(formCreator);
		result.append(')');
		return result.toString();
	}

} // CompositeFormImpl
