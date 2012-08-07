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
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

import com.rcpcompany.uibindings.compositeform.ICompositeForm;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPart;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartOperations;
import com.rcpcompany.uibindings.utils.IFormCreator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Part</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl#getForm <em>
 * Form</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl#getDescriptor
 * <em>Descriptor</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl#getTitle <em>
 * Title</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl#getImage <em>
 * Image</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl#isEnabled <em>
 * Enabled</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl#isOpen <em>Open
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl#getOperations
 * <em>Operations</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl#getFormCreator
 * <em>Form Creator</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CompositeFormPartImpl extends EObjectImpl implements ICompositeFormPart {
	/**
	 * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescriptor()
	 * @generated
	 * @ordered
	 */
	protected ICompositeFormPartDescriptor descriptor;

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
	protected static final Image IMAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImage() <em>Image</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getImage()
	 * @generated
	 * @ordered
	 */
	protected Image image = IMAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #isOpen() <em>Open</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isOpen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPEN_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isOpen() <em>Open</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isOpen()
	 * @generated
	 * @ordered
	 */
	protected boolean open = OPEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperations() <em>Operations</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected static final ICompositeFormPartOperations OPERATIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected ICompositeFormPartOperations operations = OPERATIONS_EDEFAULT;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected CompositeFormPartImpl() {
		super();

		eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				handleChanges(msg);
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ICompositeFormPackage.Literals.COMPOSITE_FORM_PART;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeForm getForm() {
		if (eContainerFeatureID() != ICompositeFormPackage.COMPOSITE_FORM_PART__FORM) return null;
		return (ICompositeForm) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetForm(ICompositeForm newForm, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newForm, ICompositeFormPackage.COMPOSITE_FORM_PART__FORM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setForm(ICompositeForm newForm) {
		if (newForm != eInternalContainer()
				|| (eContainerFeatureID() != ICompositeFormPackage.COMPOSITE_FORM_PART__FORM && newForm != null)) {
			if (EcoreUtil.isAncestor(this, newForm))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newForm != null) {
				msgs = ((InternalEObject) newForm).eInverseAdd(this, ICompositeFormPackage.COMPOSITE_FORM__PARTS,
						ICompositeForm.class, msgs);
			}
			msgs = basicSetForm(newForm, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ICompositeFormPackage.COMPOSITE_FORM_PART__FORM,
					newForm, newForm));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormPartDescriptor getDescriptor() {
		return descriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setDescriptor(ICompositeFormPartDescriptor newDescriptor) {
		final ICompositeFormPartDescriptor oldDescriptor = descriptor;
		descriptor = newDescriptor;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ICompositeFormPackage.COMPOSITE_FORM_PART__DESCRIPTOR, oldDescriptor, descriptor));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ICompositeFormPackage.COMPOSITE_FORM_PART__TITLE,
					oldTitle, title));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Image getImage() {
		return image;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setImage(Image newImage) {
		final Image oldImage = image;
		image = newImage;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ICompositeFormPackage.COMPOSITE_FORM_PART__IMAGE,
					oldImage, image));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled) {
		final boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ICompositeFormPackage.COMPOSITE_FORM_PART__ENABLED,
					oldEnabled, enabled));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isOpen() {
		return open;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOpen(boolean newOpen) {
		final boolean oldOpen = open;
		open = newOpen;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ICompositeFormPackage.COMPOSITE_FORM_PART__OPEN,
					oldOpen, open));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormPartOperations getOperations() {
		return operations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOperations(ICompositeFormPartOperations newOperations) {
		final ICompositeFormPartOperations oldOperations = operations;
		operations = newOperations;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ICompositeFormPackage.COMPOSITE_FORM_PART__OPERATIONS, oldOperations, operations));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					ICompositeFormPackage.COMPOSITE_FORM_PART__FORM_CREATOR, oldFormCreator, formCreator));
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetForm((ICompositeForm) otherEnd, msgs);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM:
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM:
			return eInternalContainer().eInverseRemove(this, ICompositeFormPackage.COMPOSITE_FORM__PARTS,
					ICompositeForm.class, msgs);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM:
			return getForm();
		case ICompositeFormPackage.COMPOSITE_FORM_PART__DESCRIPTOR:
			return getDescriptor();
		case ICompositeFormPackage.COMPOSITE_FORM_PART__TITLE:
			return getTitle();
		case ICompositeFormPackage.COMPOSITE_FORM_PART__IMAGE:
			return getImage();
		case ICompositeFormPackage.COMPOSITE_FORM_PART__ENABLED:
			return isEnabled();
		case ICompositeFormPackage.COMPOSITE_FORM_PART__OPEN:
			return isOpen();
		case ICompositeFormPackage.COMPOSITE_FORM_PART__OPERATIONS:
			return getOperations();
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM_CREATOR:
			return getFormCreator();
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM:
			setForm((ICompositeForm) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__DESCRIPTOR:
			setDescriptor((ICompositeFormPartDescriptor) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__TITLE:
			setTitle((String) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__IMAGE:
			setImage((Image) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__OPEN:
			setOpen((Boolean) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__OPERATIONS:
			setOperations((ICompositeFormPartOperations) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM_CREATOR:
			setFormCreator((IFormCreator) newValue);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM:
			setForm((ICompositeForm) null);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__DESCRIPTOR:
			setDescriptor((ICompositeFormPartDescriptor) null);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__TITLE:
			setTitle(TITLE_EDEFAULT);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__IMAGE:
			setImage(IMAGE_EDEFAULT);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__OPEN:
			setOpen(OPEN_EDEFAULT);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__OPERATIONS:
			setOperations(OPERATIONS_EDEFAULT);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM_CREATOR:
			setFormCreator(FORM_CREATOR_EDEFAULT);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM:
			return getForm() != null;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__DESCRIPTOR:
			return descriptor != null;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__TITLE:
			return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
		case ICompositeFormPackage.COMPOSITE_FORM_PART__IMAGE:
			return IMAGE_EDEFAULT == null ? image != null : !IMAGE_EDEFAULT.equals(image);
		case ICompositeFormPackage.COMPOSITE_FORM_PART__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__OPEN:
			return open != OPEN_EDEFAULT;
		case ICompositeFormPackage.COMPOSITE_FORM_PART__OPERATIONS:
			return OPERATIONS_EDEFAULT == null ? operations != null : !OPERATIONS_EDEFAULT.equals(operations);
		case ICompositeFormPackage.COMPOSITE_FORM_PART__FORM_CREATOR:
			return FORM_CREATOR_EDEFAULT == null ? formCreator != null : !FORM_CREATOR_EDEFAULT.equals(formCreator);
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
		result.append(" (title: ");
		result.append(title);
		result.append(", image: ");
		result.append(image);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", open: ");
		result.append(open);
		result.append(", operations: ");
		result.append(operations);
		result.append(", formCreator: ");
		result.append(formCreator);
		result.append(')');
		return result.toString();
	}

	protected void handleChanges(Notification msg) {
		if (msg.isTouch()) return;

		/*
		 * Ignore the initialization...
		 */
		if (getForm() == null) return;

		if (msg.getFeature() == ICompositeFormPackage.Literals.COMPOSITE_FORM_PART__ENABLED
				|| msg.getFeature() == ICompositeFormPackage.Literals.COMPOSITE_FORM_PART__OPEN) {
			updateUI();
		}
	}

	@Override
	public void updateUI() {
		removeAllChildren();
		if (!isEnabled()) {
			createEmptyComposite();
			return;
		}

		try {
			getOperations().createUI(this);
			getFormCreator().finish();
			// getFormCreator().getContext().finish(FinishOption.IF_ALREADY_FINISHED);
		} catch (final Exception ex) {
			LogUtils.error(getDescriptor().getFactory().getConfigurationElement(), ex);
		}
	}

	/**
	 * 
	 */
	private void removeAllChildren() {
		final Composite top = getFormCreator().getTop();
		try {
			top.setRedraw(false);
			final Control[] children = top.getChildren();
			for (int i = children.length - 1; i >= 0; i--) {
				children[i].dispose();
			}
		} finally {
			top.setRedraw(true);
		}
	}

	private void createEmptyComposite() {
		final Composite top = getFormCreator().getTop();
		// final Label c = new Label(myTop, SWT.NONE);
		// c.setText("");

		final Composite c = new Composite(top, SWT.NONE);
		c.setSize(new Point(1, 1));
		// c.setBackground(c.getDisplay().getSystemColor(SWT.COLOR_BLUE));
		c.setLayout(new Layout() {

			@Override
			protected void layout(Composite composite, boolean flushCache) {
			}

			@Override
			protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
				return new Point(1, 1);
			}
		});
	}

} // CompositeFormPartImpl
