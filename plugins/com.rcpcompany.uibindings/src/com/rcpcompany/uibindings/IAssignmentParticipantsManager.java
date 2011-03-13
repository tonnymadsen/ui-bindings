/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.rcpcompany.uibindings;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.participants.IAssignmentParticipant;

/**
 * <!-- begin-user-doc --> The manager for a number of {@link IAssignmentParticipantDescriptor}.
 * <p>
 * A manager is automatically defined for {@link IManager} and an manager can also be associated
 * with any binding as an argument. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IAssignmentParticipantsManager#getParticipants <em>
 * Participants</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getAssignmentParticipantsManager()
 * @generated
 */
public interface IAssignmentParticipantsManager extends EObject, IDisposable {
	/**
	 * Returns the value of the '<em><b>Participants</b></em>' reference list. The list contents are
	 * of type {@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor}. It is
	 * bidirectional and its opposite is '
	 * {@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#getManager
	 * <em>Manager</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Participants</em>' reference list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getAssignmentParticipantsManager_Participants()
	 * @see com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#getManager
	 * @generated
	 */
	EList<IAssignmentParticipantDescriptor> getParticipants();

	/**
	 * Returns the best match - if any - for an assignment participan in this manager.
	 * 
	 * @param destinationType the class of the destination object
	 * @param sourceType the class of the source object
	 * @return the best match or <code>null</code> if none can be found
	 */
	IAssignmentParticipant getParticipant(Class<?> destinationType, Class<?> sourceType);
}
