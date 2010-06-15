package com.rcpcompany.uibindings;

/**
 * This interface is used to delete items in a viewer or grid.
 * <p>
 * A deletor is requested to delete an object from a containment relation, the deletor should
 * <em>also</em> remove the the object from all other relations.
 * <p>
 * All operations on domain objects should happen within the {@link IManager#getEditingDomain()
 * editing domain}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IViewerItemDeletor {
	/**
	 * Deletes the specified object in the viewer
	 * 
	 * @param context that describes the object be deleted
	 */
	public void deleteItem(IViewerItemDeletorContext context);
}
