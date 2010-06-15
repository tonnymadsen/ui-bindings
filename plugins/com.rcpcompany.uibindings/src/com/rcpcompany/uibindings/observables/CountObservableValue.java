package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * Observable value that returns the number of items in {@link IObservableList an observable list}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class CountObservableValue extends AbstractObservableValue {

	private final IObservableList myList;
	private final IListChangeListener listener = new IListChangeListener() {
		@Override
		public void handleListChange(ListChangeEvent event) {
			updateCount();
		}
	};

	/**
	 * Constructs and returns a new observable value for the specified list.
	 * 
	 * @param list the list to count
	 */
	public CountObservableValue(IObservableList list) {
		myList = list;

		updateCount();
	}

	@Override
	public synchronized void dispose() {
		if (hasListeners()) {
			lastListenerRemoved();
		}
		super.dispose();
	}

	@Override
	protected void firstListenerAdded() {
		super.firstListenerAdded();
		myList.addListChangeListener(listener);
	}

	@Override
	protected void lastListenerRemoved() {
		myList.removeListChangeListener(listener);
		super.lastListenerRemoved();
	}

	private int myCount;

	/**
	 * Updates the resulting count for this observable value.
	 */
	protected void updateCount() {
		final int newCount = myList.size();
		if (newCount != myCount) {
			final ValueDiff diff = Diffs.createValueDiff(myCount, newCount);

			myCount = newCount;
			getRealm().exec(new Runnable() {
				@Override
				public void run() {
					fireValueChange(diff);
				}
			});
		}
	}

	@Override
	protected Object doGetValue() {
		return myCount;
	}

	@Override
	public Object getValueType() {
		return EcorePackage.Literals.EINT;
	}

}
