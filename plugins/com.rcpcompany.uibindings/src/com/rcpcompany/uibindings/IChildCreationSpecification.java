package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * This interface is used to specify the possible children that can be created in an
 * {@link IViewerBinding}.
 * <p>
 * The result is used to determine how an element can be added/dropped/...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IChildCreationSpecification {
	/**
	 * Internal ID for this specification.
	 * <p>
	 * Guaranteed to be the same for the same combination of parent, reference and childType.
	 * 
	 * @return the ID
	 */
	String getId();

	/**
	 * Returns the parent object of the element.
	 * 
	 * @return the parent
	 */
	EObject getParent();

	/**
	 * Returns the reference for the element in the parent.
	 * 
	 * @return the reference
	 */
	EReference getReference();

	/**
	 * Returns the element type in question.
	 * 
	 * @return the element type
	 */
	EClass getChildType();
}
