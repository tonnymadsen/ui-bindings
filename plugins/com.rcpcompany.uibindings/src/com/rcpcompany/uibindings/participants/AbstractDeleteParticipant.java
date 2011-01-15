/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
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
