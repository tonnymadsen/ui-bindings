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
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Assignment Participant Descriptor</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#getManager <em>Manager
 * </em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#getId <em>Id</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#getSourceTypes <em>Source
 * Types</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#getDestinationTypes <em>
 * Destination Types</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#getParticipant <em>
 * Participant</em>}</li>
 * <li>{@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#isExactModelTypeMatch <em>
 * Exact Model Type Match</em>}</li>
 * </ul>
 * </p>
 * 
 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getAssignmentParticipantDescriptor()
 * @generated
 */
public interface IAssignmentParticipantDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Manager</b></em>' reference. It is bidirectional and its
	 * opposite is '{@link com.rcpcompany.uibindings.IAssignmentParticipantsManager#getParticipants
	 * <em>Participants</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager</em>' reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Manager</em>' reference.
	 * @see #setManager(IAssignmentParticipantsManager)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getAssignmentParticipantDescriptor_Manager()
	 * @see com.rcpcompany.uibindings.IAssignmentParticipantsManager#getParticipants
	 * @generated
	 */
	IAssignmentParticipantsManager getManager();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#getManager
	 * <em>Manager</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Manager</em>' reference.
	 * @see #getManager()
	 * @generated
	 */
	void setManager(IAssignmentParticipantsManager value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getAssignmentParticipantDescriptor_Id()
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#getId <em>Id</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Source Types</b></em>' attribute list. The list contents are
	 * of type {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Types</em>' attribute list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source Types</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getAssignmentParticipantDescriptor_SourceTypes()
	 * @generated
	 */
	EList<String> getSourceTypes();

	/**
	 * Returns the value of the '<em><b>Destination Types</b></em>' attribute list. The list
	 * contents are of type {@link java.lang.String}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination Types</em>' attribute list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Destination Types</em>' attribute list.
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getAssignmentParticipantDescriptor_DestinationTypes()
	 * @generated
	 */
	EList<String> getDestinationTypes();

	/**
	 * Returns the value of the '<em><b>Participant</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participant</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Participant</em>' attribute.
	 * @see #setParticipant(CEObjectHolder)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getAssignmentParticipantDescriptor_Participant()
	 * @generated
	 */
	CEObjectHolder<IAssignmentParticipant> getParticipant();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#getParticipant
	 * <em>Participant</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Participant</em>' attribute.
	 * @see #getParticipant()
	 * @generated
	 */
	void setParticipant(CEObjectHolder<IAssignmentParticipant> value);

	/**
	 * Returns the value of the '<em><b>Exact Model Type Match</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exact Model Type Match</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exact Model Type Match</em>' attribute.
	 * @see #setExactModelTypeMatch(boolean)
	 * @see com.rcpcompany.uibindings.IUIBindingsPackage#getAssignmentParticipantDescriptor_ExactModelTypeMatch()
	 * @generated
	 */
	boolean isExactModelTypeMatch();

	/**
	 * Sets the value of the '
	 * {@link com.rcpcompany.uibindings.IAssignmentParticipantDescriptor#isExactModelTypeMatch
	 * <em>Exact Model Type Match</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Exact Model Type Match</em>' attribute.
	 * @see #isExactModelTypeMatch()
	 * @generated
	 */
	void setExactModelTypeMatch(boolean value);

} // IAssignmentParticipantDescriptor
