package com.rcpcompany.uibindings.utils;

import org.eclipse.ui.IMemento;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.BindingContextPersistence;

/**
 * This utility class is used to ease the persistence of configuration data for
 * {@link IBindingContext}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IBindingContextPersistence extends IDisposable {
	/**
	 * The factory methods for {@link IBindingContextPersistence}.
	 */
	public static final class Factory {
		private Factory() {
		}

		/**
		 * 
		 * @param context
		 * @return
		 */
		public static IBindingContextPersistence get(IBindingContext context) {
			final IBindingContextPersistence service = context.getService(IBindingContextPersistence.class);
			if (service != null) return service;
			return new BindingContextPersistence(context);
		}
	}

	/**
	 * Saves all state for the specified context.
	 * 
	 * @param memento the memento to save state into
	 */
	public void saveState(IMemento memento);

	/**
	 * Restores all state for the specified context.
	 * 
	 * @param memento the memento to restore state from
	 */
	public void restoreState(IMemento memento);
}
