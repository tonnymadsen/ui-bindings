package com.rcpcompany.uibindings;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Context used with {@link IInitializer#initialize(IInitializerContext, Object)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IInitializerContext {
	/**
	 * Returns the parent object.
	 * 
	 * @return the parent object
	 */
	EObject getParent();

	/**
	 * Returns the reference from the parent to the object.
	 * 
	 * @return the reference
	 */
	EReference getReference();

	/**
	 * Returns the object to initialize.
	 * <p>
	 * Note that the specified facet of {@link IInitializer#initialize(IInitializerContext, Object)}
	 * describes which part of the object to initialize.
	 * 
	 * @return the object
	 */
	EObject getObject();

	/**
	 * The editing domain tpo use for all new commands.
	 * 
	 * @return the editing domain
	 */
	EditingDomain getEditingDomain();

	/**
	 * Adds a new command to the set of commands used to initialize the object.
	 * 
	 * @param command the new command to add
	 */
	void addCommand(Command command);
}
