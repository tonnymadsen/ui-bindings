/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.rcpcompany.uibindings.IAssignmentParticipantDescriptor;
import com.rcpcompany.uibindings.IAssignmentParticipantsManager;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.participants.IAssignmentParticipant;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Assignment Participants Manager</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.AssignmentParticipantsManagerImpl#getParticipants
 * <em>Participants</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AssignmentParticipantsManagerImpl extends EObjectImpl implements IAssignmentParticipantsManager {
	/**
	 * The cached value of the '{@link #getParticipants() <em>Participants</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParticipants()
	 * @generated
	 * @ordered
	 */
	protected EList<IAssignmentParticipantDescriptor> participants;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AssignmentParticipantsManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.ASSIGNMENT_PARTICIPANTS_MANAGER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<IAssignmentParticipantDescriptor> getParticipants() {
		if (participants == null) {
			participants = new EObjectWithInverseEList<IAssignmentParticipantDescriptor>(
					IAssignmentParticipantDescriptor.class, this,
					IUIBindingsPackage.ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS,
					IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__MANAGER);
		}
		return participants;
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getParticipants()).basicAdd(otherEnd, msgs);
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS:
			return ((InternalEList<?>) getParticipants()).basicRemove(otherEnd, msgs);
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS:
			return getParticipants();
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS:
			getParticipants().clear();
			getParticipants().addAll((Collection<? extends IAssignmentParticipantDescriptor>) newValue);
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS:
			getParticipants().clear();
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS:
			return participants != null && !participants.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public IAssignmentParticipant getParticipant(Class<?> destinationType, Class<?> sourceType) {
		if (Activator.getDefault().TRACE_PARTICIPANTS) {
			LogUtils.debug(this, "getParticipant(" + destinationType.getName() + ", " + sourceType.getName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		final Class<?>[] destinationTypeOrder = Platform.getAdapterManager().computeClassOrder(destinationType);
		final Class<?>[] sourceTypeOrder = Platform.getAdapterManager().computeClassOrder(sourceType);

		final List<IAssignmentParticipantDescriptor> ps = new ArrayList<IAssignmentParticipantDescriptor>();
		int psPriority = 1000000;
		for (final IAssignmentParticipantDescriptor p : getParticipants()) {
			boolean found = false;
			int priority = 0;
			int prio = 0;
			for (final String t : p.getDestinationTypes()) {
				prio = 0;
				/*
				 * If exact model type matching is wanted when just test again the model type
				 * itself.
				 * 
				 * Otherwise test against model type order as found above.
				 */
				if (p.isExactModelTypeMatch()) {
					if (destinationType.getName().equals(t)) {
						found = true;
					}
				} else {
					for (final Class<?> c : destinationTypeOrder) {
						if (c.getName().equals(t)) {
							found = true;
							break;
						}
						prio++;
					}
				}
				if (found) {
					break;
				}
			}
			if (!found) {
				continue;
			}
			priority += prio;
			found = false;
			for (final String t : p.getSourceTypes()) {
				prio = 0;
				for (final Class<?> c : sourceTypeOrder) {
					if (c.getName().equals(t)) {
						found = true;
						break;
					}
				}
				if (found) {
					break;
				}
			}
			if (!found) {
				continue;
			}
			priority += prio;

			if (priority > psPriority) {
				continue;
			}
			if (priority < psPriority) {
				ps.clear();
				psPriority = priority;
			}

			ps.add(p);
		}

		/*
		 * Three cases: no match, one match, many matches
		 */
		switch (ps.size()) {
		case 0:
			if (Activator.getDefault().TRACE_PARTICIPANTS) {
				LogUtils.error(this, "getParticipant -- > null"); //$NON-NLS-1$
			}
			return null;
		default:
			/*
			 * Find the right match
			 */
			// TODO: Find the right match
			LogUtils.error(this, "TODO: find the right match, got priority " + psPriority + " (" //$NON-NLS-1$ //$NON-NLS-2$
					+ destinationType.getSimpleName() + ", " + sourceType.getSimpleName() + "): " + ps.size() //$NON-NLS-1$ //$NON-NLS-2$
					+ " matches:\n" + ps); //$NON-NLS-1$
			//$FALL-THROUGH$ fallthrough
		case 1:
			break;
		}
		final IAssignmentParticipantDescriptor participant = ps.get(0);

		return participant.getParticipant().getObject();
	}
}
