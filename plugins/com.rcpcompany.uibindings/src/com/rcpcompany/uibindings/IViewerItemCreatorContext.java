package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;

/**
 * This interface specifies the context used in
 * {@link IViewerItemCreator#createItem(IViewerItemCreatorContext)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IViewerItemCreatorContext {
	public IViewerBinding getViewerBinding();

	public IObservableList getList();

	public int getAfterIndex();

	/**
	 * Returns an object to be cloned for the new object.
	 * 
	 * @return the object to be cloned or <code>null</code>
	 */
	public EObject getCloneObject();
}
