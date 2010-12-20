package com.rcpcompany.uibindings.participants;

import org.eclipse.emf.ecore.EObject;

/**
 * Context for various operations in {@link IDeleteParticipant}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IDeleteParticipantContext {
	/**
	 * The element to delete.
	 * 
	 * @return the element
	 */
	EObject getElement();
}
