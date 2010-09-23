package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * This interface is used to specify the parentage for a specific element in a viewer in the form of
 * the parent5 object and the reference from that parent to the element in question.
 * <p>
 * The result is used to determine how an element can be delete/dragged/...
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IElementParentage {
	/**
	 * Returns the element in question.
	 * 
	 * @return the element
	 */
	EObject getElement();

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
}
