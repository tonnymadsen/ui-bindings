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

import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Context used with
 * {@link IInitializationParticipant#initialize(IInitializationParticipantContext, Object)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IInitializationParticipantContext {
	/**
	 * Returns the object to initialize.
	 * <p>
	 * Note that the specified facet of
	 * {@link IInitializationParticipant#initialize(IInitializationParticipantContext, Object)}
	 * describes which part of the object to initialize.
	 * 
	 * @return the object
	 */
	EObject getObject();

	/**
	 * The editing domain to use for all new commands.
	 * 
	 * @return the editing domain
	 */
	EditingDomain getEditingDomain();

	/**
	 * A map with all current set values on {@link #getObject()}.
	 * <p>
	 * The values have not yet been set on the real object as this will typically change other
	 * objects - e.g. in case or bi-directional references.
	 * 
	 * @return map with current values
	 */
	Map<EStructuralFeature, Object> getValueMap();

	/**
	 * Adds a new command to the set of commands used to initialize the object.
	 * 
	 * @param command the new command to add
	 */
	void addCommand(Command command);

	/**
	 * Adds a new {@link SetCommand} to the set of commands used to initialize the object.
	 * 
	 * @param feature the feature to set of {@link #getObject()}
	 * @param value the value to set
	 */
	void setStructuralFeature(EStructuralFeature feature, Object value);

	/**
	 * Returns the value of specified structural feature of {@link #getObject()} taking into account
	 * any present {@link #setStructuralFeature(EStructuralFeature, Object)}.
	 * 
	 * @param feature the feature to set of {@link #getObject()}
	 * @return the value
	 */
	Object getStructuralFeature(EStructuralFeature feature);
}
