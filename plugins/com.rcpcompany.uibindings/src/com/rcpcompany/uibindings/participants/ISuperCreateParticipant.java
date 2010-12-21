package com.rcpcompany.uibindings.participants;

/**
 * Participant to take part in super create.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ISuperCreateParticipant {
	/**
	 * Creates the needed rows for a Super Create.
	 * 
	 * @param context the context for the operation
	 * @return <code>true</code> if the operation succeeds, and <code>false</code> otherwise
	 */
	boolean createNeededRows(ISuperCreateParticipantContext context);
}
