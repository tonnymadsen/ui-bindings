/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
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
