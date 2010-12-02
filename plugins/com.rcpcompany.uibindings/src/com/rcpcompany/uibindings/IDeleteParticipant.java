package com.rcpcompany.uibindings;

/**
 * Participant to take part in delete operations.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IDeleteParticipant {
	/**
	 * Returns whether an element (in the specified context) can be be deleted.
	 * 
	 * @param context the context for the operation
	 * @return <code>true</code> if the element can be deleted
	 */
	boolean canDelete(IDeleteParticipantContext context);

	/**
	 * Called just before an element (in the specified context) is in fact deleted.
	 * 
	 * @param context the context for the operation
	 */
	void preDelete(IDeleteParticipantContext context);

	/**
	 * Called just after an element (in the specified context) has been deleted.
	 * 
	 * @param context the context for the operation
	 */
	void postDelete(IDeleteParticipantContext context);
}
