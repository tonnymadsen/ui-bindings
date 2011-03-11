package com.rcpcompany.uibindings.participants;

import org.eclipse.emf.ecore.EObject;

/**
 * Context used with {@link IAssignmentParticipant#assign(IAssignmentParticipantContext)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IAssignmentParticipantContext extends IInitializationParticipantContext {
	/**
	 * Returns the source object for the assignment.
	 * 
	 * @return the source object
	 */
	EObject getSourceObject();
}
