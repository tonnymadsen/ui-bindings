package com.rcpcompany.uibindings.moao.ui.participants;

import com.rcpcompany.uibindings.moao.IMOAOPackage;
import com.rcpcompany.uibindings.moao.INamedObject;
import com.rcpcompany.uibindings.participants.IAssignmentParticipant;
import com.rcpcompany.uibindings.participants.IAssignmentParticipantContext;

/**
 * Simple {@link IAssignmentParticipant} to handle the name of
 * {@link com.rcpcompany.uibindings.moao.INamedObject}
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class NamedObjectToNamedObjectAsignmentParticipant implements IAssignmentParticipant {
	@Override
	public void assign(IAssignmentParticipantContext context) {
		final INamedObject si = (INamedObject) context.getSourceObject();
		context.setStructuralFeature(IMOAOPackage.Literals.NAMED_OBJECT__NAME, si.getName());
	}
}
