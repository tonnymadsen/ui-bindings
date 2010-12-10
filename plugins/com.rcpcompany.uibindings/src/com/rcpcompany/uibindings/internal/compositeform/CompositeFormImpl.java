/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal.compositeform;

import java.util.Collection;
import java.util.Comparator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.compositeform.ICompositeForm;
import com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPart;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartFactory;
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
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormImpl#getForm <em>Form
 * </em>}</li>
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
	 * The default value of the '{@link #getForm() <em>Form</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getForm()
	 * @generated
	 * @ordered
	 */
	protected static final IFormCreator FORM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForm() <em>Form</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getForm()
	 * @generated
	 * @ordered
	 */
	protected IFormCreator form = FORM_EDEFAULT;

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
			final ICompositeFormPartFactory factory = pd.getFactory().getObject();
			ICompositeFormPart part = null;

			try {
				part = factory.create(this);
			} catch (final Exception ex) {
				LogUtils.error(pd.getFactory().getConfigurationElement(), ex);
				continue;
			}
			part.setDescriptor(pd);

			getParts().add(part);
		}

		/**
		 * Sort the parts...
		 */
		ECollections.sort(getParts(), new Comparator<ICompositeFormPart>() {
			@Override
			public int compare(ICompositeFormPart o1, ICompositeFormPart o2) {
				return o1.getDescriptor().getPriority() - o2.getDescriptor().getPriority();
			}
		});

		// TODO
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
	public IFormCreator getForm() {
		return form;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setForm(IFormCreator newForm) {
		final IFormCreator oldForm = form;
		form = newForm;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ICompositeFormPackage.COMPOSITE_FORM__FORM, oldForm,
					form));
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
		case ICompositeFormPackage.COMPOSITE_FORM__FORM:
			return getForm();
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
		case ICompositeFormPackage.COMPOSITE_FORM__FORM:
			setForm((IFormCreator) newValue);
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
		case ICompositeFormPackage.COMPOSITE_FORM__FORM:
			setForm(FORM_EDEFAULT);
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
		case ICompositeFormPackage.COMPOSITE_FORM__FORM:
			return FORM_EDEFAULT == null ? form != null : !FORM_EDEFAULT.equals(form);
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
		result.append(" (form: ");
		result.append(form);
		result.append(')');
		return result.toString();
	}

} // CompositeFormImpl
