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

import org.eclipse.emf.common.command.Command;

/**
 * Interface used to assign values from one object to another object.
 * <p>
 * Primary used in drag 'n drop operations.
 * <p>
 * When an object is initialized, it is very important that all changes to the object as well as to
 * other object in the system, is made as {@link Command commands}. All needed commands must be
 * added with {IAssigmentParticipantContext#addCommand(Command)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IAssignmentParticipant {
	/**
	 * Assign the relevant values from the source of the context to the destination object of the
	 * context.
	 * 
	 * @param context a context
	 */
	void assign(IAssignmentParticipantContext context);
}
