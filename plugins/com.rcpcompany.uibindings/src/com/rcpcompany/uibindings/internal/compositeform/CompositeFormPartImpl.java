/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal.compositeform;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.rcpcompany.uibindings.compositeform.ICompositeForm;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPart;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;

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
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormPartImpl#isEnabled <em>
 * Enabled</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class CompositeFormPartImpl extends EObjectImpl implements ICompositeFormPart {
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
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = false;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CompositeFormPartImpl() {
		super();
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__ENABLED:
			return isEnabled();
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__ENABLED:
			setEnabled((Boolean) newValue);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
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
		case ICompositeFormPackage.COMPOSITE_FORM_PART__ENABLED:
			return enabled != ENABLED_EDEFAULT;
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
		result.append(" (enabled: ");
		result.append(enabled);
		result.append(')');
		return result.toString();
	}

} // CompositeFormPartImpl
