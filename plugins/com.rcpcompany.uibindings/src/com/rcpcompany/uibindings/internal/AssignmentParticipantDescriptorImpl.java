/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings.internal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.rcpcompany.uibindings.IAssignmentParticipantDescriptor;
import com.rcpcompany.uibindings.IAssignmentParticipantsManager;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.participants.IAssignmentParticipant;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Assignment Participant Descriptor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.internal.AssignmentParticipantDescriptorImpl#getManager <em>
 * Manager</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.AssignmentParticipantDescriptorImpl#getId <em>Id
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.AssignmentParticipantDescriptorImpl#getSourceTypes
 * <em>Source Types</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.AssignmentParticipantDescriptorImpl#getDestinationTypes
 * <em>Destination Types</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.internal.AssignmentParticipantDescriptorImpl#getParticipant
 * <em>Participant</em>}</li>
 * <li>
 * {@link com.rcpcompany.uibindings.internal.AssignmentParticipantDescriptorImpl#isExactTypeMatch
 * <em>Exact Type Match</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AssignmentParticipantDescriptorImpl extends EObjectImpl implements IAssignmentParticipantDescriptor {
	/**
	 * The cached value of the '{@link #getManager() <em>Manager</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getManager()
	 * @generated
	 * @ordered
	 */
	protected IAssignmentParticipantsManager manager;

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
	 * The cached value of the '{@link #getSourceTypes() <em>Source Types</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> sourceTypes;

	/**
	 * The cached value of the '{@link #getDestinationTypes() <em>Destination Types</em>}' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDestinationTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> destinationTypes;

	/**
	 * The cached value of the '{@link #getParticipant() <em>Participant</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParticipant()
	 * @generated
	 * @ordered
	 */
	protected CEObjectHolder<IAssignmentParticipant> participant;

	/**
	 * The default value of the '{@link #isExactTypeMatch() <em>Exact Type Match</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isExactTypeMatch()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXACT_TYPE_MATCH_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExactTypeMatch() <em>Exact Type Match</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isExactTypeMatch()
	 * @generated
	 * @ordered
	 */
	protected boolean exactTypeMatch = EXACT_TYPE_MATCH_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AssignmentParticipantDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IUIBindingsPackage.Literals.ASSIGNMENT_PARTICIPANT_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public IAssignmentParticipantsManager getManager() {
		return manager;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetManager(IAssignmentParticipantsManager newManager, NotificationChain msgs) {
		final IAssignmentParticipantsManager oldManager = manager;
		manager = newManager;
		if (eNotificationRequired()) {
			final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__MANAGER, oldManager, newManager);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setManager(IAssignmentParticipantsManager newManager) {
		if (newManager != manager) {
			NotificationChain msgs = null;
			if (manager != null) {
				msgs = ((InternalEObject) manager).eInverseRemove(this,
						IUIBindingsPackage.ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS,
						IAssignmentParticipantsManager.class, msgs);
			}
			if (newManager != null) {
				msgs = ((InternalEObject) newManager).eInverseAdd(this,
						IUIBindingsPackage.ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS,
						IAssignmentParticipantsManager.class, msgs);
			}
			msgs = basicSetManager(newManager, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__MANAGER, newManager, newManager));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__ID, oldId, id));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<String> getSourceTypes() {
		if (sourceTypes == null) {
			sourceTypes = new EDataTypeUniqueEList<String>(String.class, this,
					IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__SOURCE_TYPES);
		}
		return sourceTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EList<String> getDestinationTypes() {
		if (destinationTypes == null) {
			destinationTypes = new EDataTypeUniqueEList<String>(String.class, this,
					IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__DESTINATION_TYPES);
		}
		return destinationTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CEObjectHolder<IAssignmentParticipant> getParticipant() {
		return participant;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setParticipant(CEObjectHolder<IAssignmentParticipant> newParticipant) {
		final CEObjectHolder<IAssignmentParticipant> oldParticipant = participant;
		participant = newParticipant;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__PARTICIPANT, oldParticipant, participant));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isExactTypeMatch() {
		return exactTypeMatch;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setExactTypeMatch(boolean newExactTypeMatch) {
		final boolean oldExactTypeMatch = exactTypeMatch;
		exactTypeMatch = newExactTypeMatch;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__EXACT_TYPE_MATCH, oldExactTypeMatch,
					exactTypeMatch));
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__MANAGER:
			if (manager != null) {
				msgs = ((InternalEObject) manager).eInverseRemove(this,
						IUIBindingsPackage.ASSIGNMENT_PARTICIPANTS_MANAGER__PARTICIPANTS,
						IAssignmentParticipantsManager.class, msgs);
			}
			return basicSetManager((IAssignmentParticipantsManager) otherEnd, msgs);
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__MANAGER:
			return basicSetManager(null, msgs);
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__MANAGER:
			return getManager();
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__ID:
			return getId();
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__SOURCE_TYPES:
			return getSourceTypes();
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__DESTINATION_TYPES:
			return getDestinationTypes();
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__PARTICIPANT:
			return getParticipant();
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__EXACT_TYPE_MATCH:
			return isExactTypeMatch();
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__MANAGER:
			setManager((IAssignmentParticipantsManager) newValue);
			return;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__ID:
			setId((String) newValue);
			return;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__SOURCE_TYPES:
			getSourceTypes().clear();
			getSourceTypes().addAll((Collection<? extends String>) newValue);
			return;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__DESTINATION_TYPES:
			getDestinationTypes().clear();
			getDestinationTypes().addAll((Collection<? extends String>) newValue);
			return;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__PARTICIPANT:
			setParticipant((CEObjectHolder<IAssignmentParticipant>) newValue);
			return;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__EXACT_TYPE_MATCH:
			setExactTypeMatch((Boolean) newValue);
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__MANAGER:
			setManager((IAssignmentParticipantsManager) null);
			return;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__ID:
			setId(ID_EDEFAULT);
			return;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__SOURCE_TYPES:
			getSourceTypes().clear();
			return;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__DESTINATION_TYPES:
			getDestinationTypes().clear();
			return;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__PARTICIPANT:
			setParticipant((CEObjectHolder<IAssignmentParticipant>) null);
			return;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__EXACT_TYPE_MATCH:
			setExactTypeMatch(EXACT_TYPE_MATCH_EDEFAULT);
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
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__MANAGER:
			return manager != null;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__SOURCE_TYPES:
			return sourceTypes != null && !sourceTypes.isEmpty();
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__DESTINATION_TYPES:
			return destinationTypes != null && !destinationTypes.isEmpty();
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__PARTICIPANT:
			return participant != null;
		case IUIBindingsPackage.ASSIGNMENT_PARTICIPANT_DESCRIPTOR__EXACT_TYPE_MATCH:
			return exactTypeMatch != EXACT_TYPE_MATCH_EDEFAULT;
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
		result.append(" (id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", sourceTypes: "); //$NON-NLS-1$
		result.append(sourceTypes);
		result.append(", destinationTypes: "); //$NON-NLS-1$
		result.append(destinationTypes);
		result.append(", participant: "); //$NON-NLS-1$
		result.append(participant);
		result.append(", exactTypeMatch: "); //$NON-NLS-1$
		result.append(exactTypeMatch);
		result.append(')');
		return result.toString();
	}

} // AssignmentParticipantDescriptorImpl
