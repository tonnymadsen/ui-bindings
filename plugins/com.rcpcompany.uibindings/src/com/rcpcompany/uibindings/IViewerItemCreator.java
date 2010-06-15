package com.rcpcompany.uibindings;

import org.eclipse.emf.ecore.EObject;

/**
 * This interface is used to create new items in a viewer or grid.
 * <p>
 * All operations on domain objects should happen within the {@link IManager#getEditingDomain()
 * editing domain}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IViewerItemCreator {
	public EObject createItem(IViewerItemCreatorContext context);
}
