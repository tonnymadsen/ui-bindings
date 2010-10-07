package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.AbstractObservableList;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * Simple constant {@link IObservableListMapper} with the numbers in a specific number interval.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class IndexObservableList extends AbstractObservableList {

	private final int myMin;
	private final int myMax;

	/**
	 * Constructs and returns a new list with the specified min and max values.
	 * 
	 * @param realm the realm
	 * @param min the minimum value
	 * @param max the maximum value
	 */
	public IndexObservableList(Realm realm, int min, int max) {
		super(realm);
		myMin = min;
		myMax = max;
	}

	/**
	 * Constructs and returns a new list with the specified min and max values.
	 * 
	 * @param max the maximum value
	 */
	public IndexObservableList(int min, int max) {
		this(Realm.getDefault(), min, max);
	}

	/**
	 * Constructs and returns a new list with the specified max values.
	 * 
	 * @param max the maximum value
	 */
	public IndexObservableList(int max) {
		this(0, max);
	}

	@Override
	public Object getElementType() {
		return EcorePackage.Literals.EINTEGER_OBJECT;
	}

	@Override
	protected int doGetSize() {
		return myMax - myMin + 1;
	}

	@Override
	public Object get(int index) {
		return myMin + index;
	}

}
