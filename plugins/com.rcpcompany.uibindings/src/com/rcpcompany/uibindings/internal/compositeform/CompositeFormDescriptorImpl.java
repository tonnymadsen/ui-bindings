/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.compositeform.ICompositeFormDescriptor;
import com.rcpcompany.uibindings.compositeform.ICompositeFormManager;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPackage;
import com.rcpcompany.uibindings.compositeform.ICompositeFormPartDescriptor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Descriptor</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormDescriptorImpl#getManager
 * <em>Manager</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormDescriptorImpl#getId
 * <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.compositeform.CompositeFormDescriptorImpl#getParts
 * <em>Parts</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class CompositeFormDescriptorImpl extends EObjectImpl implements ICompositeFormDescriptor {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<ICompositeFormPartDescriptor> parts;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected CompositeFormDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ICompositeFormPackage.Literals.COMPOSITE_FORM_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ICompositeFormManager getManager() {
		if (eContainerFeatureID() != ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER) return null;
		return (ICompositeFormManager) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetManager(ICompositeFormManager newManager, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newManager,
				ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setManager(ICompositeFormManager newManager) {
		if (newManager != eInternalContainer()
				|| (eContainerFeatureID() != ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER && newManager != null)) {
			if (EcoreUtil.isAncestor(this, newManager))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newManager != null) {
				msgs = ((InternalEObject) newManager).eInverseAdd(this,
						ICompositeFormPackage.COMPOSITE_FORM_MANAGER__FORMS, ICompositeFormManager.class, msgs);
			}
			msgs = basicSetManager(newManager, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER, newManager, newManager));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		final String oldId = id;
		id = newId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__ID,
					oldId, id));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<ICompositeFormPartDescriptor> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentWithInverseEList<ICompositeFormPartDescriptor>(
					ICompositeFormPartDescriptor.class, this, ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__PARTS,
					ICompositeFormPackage.COMPOSITE_FORM_PART_DESCRIPTOR__FORM);
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
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetManager((ICompositeFormManager) otherEnd, msgs);
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__PARTS:
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
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER:
			return basicSetManager(null, msgs);
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__PARTS:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER:
			return eInternalContainer().eInverseRemove(this, ICompositeFormPackage.COMPOSITE_FORM_MANAGER__FORMS,
					ICompositeFormManager.class, msgs);
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
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER:
			return getManager();
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__ID:
			return getId();
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__PARTS:
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
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER:
			setManager((ICompositeFormManager) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__ID:
			setId((String) newValue);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__PARTS:
			getParts().clear();
			getParts().addAll((Collection<? extends ICompositeFormPartDescriptor>) newValue);
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
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER:
			setManager((ICompositeFormManager) null);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__ID:
			setId(ID_EDEFAULT);
			return;
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__PARTS:
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
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__MANAGER:
			return getManager() != null;
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case ICompositeFormPackage.COMPOSITE_FORM_DESCRIPTOR__PARTS:
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
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} // CompositeFormDescriptorImpl
