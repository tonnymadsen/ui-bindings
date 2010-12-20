package com.rcpcompany.uibindings.participants;


/**
 * Abstract base class for {@link IDeleteParticipant}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractDeleteParticipant implements IDeleteParticipant {
	@Override
	public boolean canDelete(IDeleteParticipantContext context) {
		return true;
	}

	@Override
	public void preDelete(IDeleteParticipantContext context) {
	}

	@Override
	public void postDelete(IDeleteParticipantContext context) {
	}
}
