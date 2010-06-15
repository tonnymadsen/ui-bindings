package com.rcpcompany.uibindings;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EObject;

import com.rcpcompany.uibindings.internal.sourceProviders.BindingSourceProvider;

/**
 * This interface specifies the context used in
 * {@link IViewerItemDeletor#deleteItem(IViewerItemDeletorContext)}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IViewerItemDeletorContext {
	/**
	 * The involved {@link IViewerBinding viewer binding}.
	 * 
	 * @return the binding
	 */
	public IViewerBinding getViewerBinding();

	/**
	 * The involved {@link IObservableList observable list}.
	 * 
	 * @return the list
	 */
	public IObservableList getList();

	/**
	 * The index of the object in the list.
	 * 
	 * @return the index
	 */
	public int getIndex();

	/**
	 * Returns an object to be deleted.
	 * 
	 * @return the object to be deleted
	 */
	public EObject getObject();

	/**
	 * Returns whether the delete is just a test or if it is for real.
	 * <p>
	 * Used in the {@link BindingSourceProvider} to determine whether the delete operation is
	 * enabled or not.
	 * 
	 * @return <code>true</code> if only testing
	 */
	public boolean getTestOnly();
}
