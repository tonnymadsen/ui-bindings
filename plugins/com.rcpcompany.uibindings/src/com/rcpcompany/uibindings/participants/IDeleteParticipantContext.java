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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Context for various operations in {@link IDeleteParticipant}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IDeleteParticipantContext {
	/**
	 * Returns the element to delete.
	 * 
	 * @return the element
	 */
	EObject getElement();

	/**
	 * Returns the editing domain used for the delete operation
	 * 
	 * @return the editing domain
	 */
	EditingDomain getEditingDomain();

	/**
	 * Adds a command to the set of commands used to delete the element
	 * 
	 * @param command the command to add
	 */
	void addCommand(Command command);

	/**
	 * Returns whether the user can be queried as part of the operation
	 * 
	 * @return <code>true</code> if the user can be queried, <code>false</code> otherwise
	 */
	boolean canQueryUser();

	/**
	 * Don't check the target objects for incoming references.
	 * <p>
	 * Used if you make all your needed changes to the model yourself, so the check will be
	 * misleading.
	 */
	void dontCheckForIncomingReferences();
}
