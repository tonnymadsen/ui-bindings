package com.rcpcompany.uibindings.navigator;

import org.eclipse.emf.ecore.EObject;

/**
 * Interface for a view that can host an {@link IEditorPart}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IEditorPartView {
	/**
	 * Returns whether this editor is currently pinned.
	 * <p>
	 * If the editor is pinned, it will not react to selection changes and a new editor is created
	 * instead of reusing an existing editor.
	 * 
	 * @return <code>true</code> if pinned
	 */
	boolean isPinned();

	/**
	 * Sets whether this editor must be pinned.
	 * 
	 * @param pinned <code>true</code> if the editor must be pinned
	 * 
	 * @see #isPinned()
	 */
	void setPinned(boolean pinned);

	/**
	 * Returns the current object of this view
	 * 
	 * @return the object - possible <code>null</code>
	 */
	EObject getCurrentObject();

	/**
	 * Sets the current object of this part view.
	 * 
	 * @param obj the new object of the view
	 */
	void setCurrentObject(EObject obj);

	/**
	 * Activates this view in the workbench.
	 */
	void activateView();

	/**
	 * Returns the current editor descriptor of this editor.
	 * 
	 * @return the descriptor
	 */
	IEditorPartDescriptor getCurrentDescriptor();
}
