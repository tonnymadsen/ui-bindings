package com.rcpcompany.uibindings.internal.utils;

import org.eclipse.ui.IMemento;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.utils.IBindingContextPersistence;

/**
 * Implementation of {@link IBindingContextPersistence}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingContextPersistence implements IBindingContextPersistence, IDisposable {
	/**
	 * Constructs and initializes a new sorter...
	 * 
	 * @param context the binding
	 */
	public BindingContextPersistence(IBindingContext context) {
		myContext = context;
		init();
	}

	/**
	 * Initializes this sorter.
	 */
	protected void init() {
		myContext.registerService(this);
	}

	/**
	 * Removes the sorting functionality again.
	 */
	@Override
	public void dispose() {
		myContext.deregisterService(this);
	}

	protected final IBindingContext myContext;

	/**
	 * Saves the current state of the binding in the specified {@link IMemento} under the name of the viewer.
	 * 
	 * @param memento the memento
	 * @param name the name used for the configuration information - defaults to the name of the viewer
	 */
	public void saveState(IMemento memento) {
		if (memento == null) {
			return;
		}

		for (final IBinding b : myContext.getBindings()) {
			final String id = b.getId();
			if (id == null) {
				continue;
			}
			final IMemento bm = memento.createChild("IBinding", id);

		}

		// TODO see issue 58
	}

	/**
	 * Restores the state of the binding from the specified {@link IMemento} using the name of the viewer.
	 * 
	 * @param memento the memento
	 * @param name the name used for the configuration information - defaults to the name of the viewer
	 */
	public void restoreState(IMemento memento) {
		if (memento == null) {
			return;
		}

		// TODO see issue 58

	}
}
