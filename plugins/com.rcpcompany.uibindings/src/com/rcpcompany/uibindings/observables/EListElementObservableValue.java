package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.IManager;

/**
 * Basic {@link IObservableValue observable value} for an element in an EMF {@link EList}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EListElementObservableValue extends AbstractObservableValue implements IKeyedObservable, IObserving {
	private final IObservableValue myObjectOV;
	private final EStructuralFeature mySF;
	private final int myIndex;
	private final EditingDomain myEditingDomain;

	private final EObject myObject = null;

	private IValueChangeListener myObjectOVListener;
	/**
	 * The current value of the observable value.
	 */
	private Object myValue;

	/**
	 * Constructs and returns a new {@link IObservableValue} for the specified element in the list
	 * of the object.
	 * <p>
	 * The default editing domain of the {@link IManager} if used.
	 * 
	 * @param ov observable value with the {@link EObject}
	 * @param sf the structural feature with the list
	 * @param index the element of the list
	 */
	public EListElementObservableValue(IObservableValue ov, EStructuralFeature sf, int index) {
		this(IManager.Factory.getManager().getEditingDomain(), ov, sf, index);
	}

	/**
	 * Constructs and returns a new {@link IObservableValue} for the specified element in the list
	 * of the object.
	 * 
	 * @param editingDomain the editing domain to use
	 * @param ov observable value with the {@link EObject}
	 * @param sf the structural feature with the list
	 * @param index the element of the list
	 */
	public EListElementObservableValue(EditingDomain editingDomain, IObservableValue ov, EStructuralFeature sf,
			int index) {
		myEditingDomain = editingDomain;
		myObjectOV = ov;
		mySF = sf;
		myIndex = index;
	}

	@Override
	public Object getObserved() {
		return myObject;
	}

	@Override
	public Object getObservableKey() {
		return myIndex;
	}

	public void updateValue() {
		myValue = doGetValue();
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

	}

	@Override
	protected void lastListenerRemoved() {
		super.lastListenerRemoved();
	}

	@Override
	protected final Object doGetValue() {
		if (myObject == null) return null;
		final EList<?> list = (EList<?>) myObject.eGet(mySF);
		if (list == null) return null;
		if (list.size() <= myIndex) return null;

		return list.get(myIndex);
	}

	@Override
	protected void doSetValue(final Object value) {
		final SetCommand command = new SetCommand(myEditingDomain, myObject, mySF, value, myIndex);
		myEditingDomain.getCommandStack().execute(command);
	}

	@Override
	public Object getValueType() {
		return mySF.getEType();
	}
}
