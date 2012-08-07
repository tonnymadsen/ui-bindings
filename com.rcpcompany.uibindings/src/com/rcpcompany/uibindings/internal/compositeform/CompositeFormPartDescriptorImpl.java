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
package com.rcpcompany.uibindings.internal.compositeform;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.extensionpoints.CEResourceHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Part Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartDescriptorImpl#getForm
 * <em>Form</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartDescriptorImpl#getPriority
 * <em>Priority</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartDescriptorImpl#getTitle
 * <em>Title</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartDescriptorImpl#getImage
 * <em>Image</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartDescriptorImpl#getFactory
 * <em>Factory</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CompositeFormPartDescriptorImpl extends EObjectImpl implements ICompositeFormPartDescriptor {
	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;
	/**
	 * The default value of the '{@link #getImage() <em>Image</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected static final CEResourceHolder IMAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected CEResourceHolder image = IMAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFactory() <em>Factory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactory()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<ICompositeFormPartFactory> factory;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CompositeFormPartDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ICompositeFormPackage.Literals.COMPOSITE_FORM_PART_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormDescriptor getForm() {
		if (eContainerFeatureID() != ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM) return null;
		return (ICompositeFormDescriptor) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetForm(ICompositeFormDescriptor newForm, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newForm,
				ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setForm(ICompositeFormDescriptor newForm) {
		if (newForm != eInternalContainer()
				|| (eContainerFeatureID() != ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM && newForm != null)) {
			if (EcoreUtil.isAncestor(this, newForm))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newForm != null) {
				msgs = ((InternalEObject) newForm).eInverseAdd(this,
						ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__PARTS, ICompositeFormDescriptor.class, msgs);
			}
			msgs = basicSetForm(newForm, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM, newForm, newForm));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setPriority(int newPriority) {
		final int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__PRIORITY, oldPriority, priority));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<ICompositeFormPartFactory> getFactory() {
		return factory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFactory(CEObjectHolder<ICompositeFormPartFactory> newFactory) {
		final CEObjectHolder<ICompositeFormPartFactory> oldFactory = factory;
		factory = newFactory;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FACTORY, oldFactory, factory));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setTitle(String newTitle) {
		final String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__TITLE, oldTitle, title));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEResourceHolder getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setImage(CEResourceHolder newImage) {
		final CEResourceHolder oldImage = image;
		image = newImage;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__IMAGE, oldImage, image));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetForm((ICompositeFormDescriptor) otherEnd, msgs);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM:
			return basicSetForm(null, msgs);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM:
			return eInternalContainer().eInverseRemove(this, ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__PARTS,
					ICompositeFormDescriptor.class, msgs);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM:
			return getForm();
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__PRIORITY:
			return getPriority();
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__TITLE:
			return getTitle();
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__IMAGE:
			return getImage();
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FACTORY:
			return getFactory();
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM:
			setForm((ICompositeFormDescriptor) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__PRIORITY:
			setPriority((Integer) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__TITLE:
			setTitle((String) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__IMAGE:
			setImage((CEResourceHolder) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<ICompositeFormPartFactory>) newValue);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM:
			setForm((ICompositeFormDescriptor) null);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__TITLE:
			setTitle(TITLE_EDEFAULT);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__IMAGE:
			setImage(IMAGE_EDEFAULT);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FACTORY:
			setFactory((CEObjectHolder<ICompositeFormPartFactory>) null);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM:
			return getForm() != null;
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__PRIORITY:
			return priority != PRIORITY_EDEFAULT;
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__TITLE:
			return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__IMAGE:
			return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
		case ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FACTORY:
			return factory != null;
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
		result.append(" (priority: ");
		result.append(priority);
		result.append(", title: ");
		result.append(title);
		result.append(", image: ");
		result.append(image);
		result.append(", factory: ");
		result.append(factory);
		result.append(')');
		return result.toString();
	}

} // CompositeFormPartDescriptorImpl
