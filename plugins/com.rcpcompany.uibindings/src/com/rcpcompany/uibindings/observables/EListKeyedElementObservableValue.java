/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.observables;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.UIBindingsUtils;

/**
 * {@link IObservableValue Observable value} for a value from an element of an EMF {@link EList}
 * where the element have a specific key value.
 * <p>
 * The primary use of this is for objects with associated name-value lists. Using this observable
 * value, you can bind to an element in the list that has a specific key value. The element does not
 * have to exist before the bind, as it will be created automatically if set with
 * {@link #setValue(Object)}.
 * <p>
 * E.g. assume the data structures:
 * 
 * <pre>
 * class NV {
 * 	String key;
 * 	String value;
 * }
 * 
 * class B {
 * 	EList&lt;NV&gt; NVs;
 * }
 * </pre>
 * 
 * then this class can be used to find the value attribute of the NV element of
 * <code>B.getNVs()</code> where the key equals "abc" with
 * 
 * <code>new EListKeyedElementObservableValue(ed, b.getNVs(), "abc", ...Package.Literals.NV__VALUE);</code>
 * 
 * @author Tonny Madsen, The RCP Company
 * @param <T> the type of the elements of the list
 */
public class EListKeyedElementObservableValue<T extends EObject> extends AbstractObservableValue implements
		IKeyedObservable, IObserving {

	private final EditingDomain myEditingDomain;

	private final IObservableValue mySourceOV;
	private EObject mySource = null;
	private final EReference myListRef;
	private EList<T> myList;
	private final EStructuralFeature myKeySF;
	private final Object myKey;
	private int myIndex;
	private T myElement;
	private final EStructuralFeature myValueSF;

	/**
	 * The current value of the observable value.
	 */
	private Object myValue;

	private IObservableValue myListenSourceOV = null;
	private EObject myListenSource = null;
	private EList<T> myListenList = null;
	private Object myReportedValue = null;

	/**
	 * General listener used on al {@link IObservableValue} and {@link EObject}.
	 */
	private final Listener myListener = new Listener();

	/**
	 * Constructs and returns a new {@link IObservableValue} for the specified element in the list
	 * of the object.
	 * 
	 * @param editingDomain the editing domain to use
	 * @param ov observable value with the {@link EObject}
	 * @param listRef the structural feature with the list
	 * @param keySF the structural feature for the key value
	 * @param key the key value
	 * @param valueSF the structural feature for the value
	 */
	public EListKeyedElementObservableValue(EditingDomain editingDomain, IObservableValue ov, EReference listRef,
			EStructuralFeature keySF, Object key, EStructuralFeature valueSF) {
		myEditingDomain = editingDomain;
		mySourceOV = ov;
		myListRef = listRef;
		myKeySF = keySF;
		myKey = key;
		myValueSF = valueSF;

		init();
	}

	/**
	 * Constructs and returns a new {@link IObservableValue} for the specified element in the list
	 * of the object.
	 * 
	 * @param editingDomain the editing domain to use
	 * @param object the source object
	 * @param listRef the structural feature with the list
	 * @param keySF the structural feature for the key value
	 * @param key the key value
	 * @param valueSF the structural feature for the value
	 */
	public EListKeyedElementObservableValue(EditingDomain editingDomain, EObject object, EReference listRef,
			EStructuralFeature keySF, Object key, EStructuralFeature valueSF) {
		myEditingDomain = editingDomain;
		mySourceOV = null;
		mySource = object;
		myListRef = listRef;
		myKeySF = keySF;
		myKey = key;
		myValueSF = valueSF;

		init();
	}

	private void init() {

		/*
		 * Consistency tests
		 */
		// listRef is to many
		Assert.isTrue(myListRef == null || myListRef.isMany());
		// keySF is based on listRef.getReferenceType()
		// valueSF is based on listRef.getReferenceType()

		calcValue();
	}

	@Override
	public EObject getObserved() {
		return (EObject) mySourceOV.getValue();
	}

	@Override
	public Object getObservableKey() {
		return myIndex;
	}

	/**
	 * Updates the current state.
	 */
	private void calcValue() {
		/*
		 * If based on the an IOV for the base object, then first resolve this.
		 */
		if (mySourceOV != null) {
			final Object o = mySourceOV.getValue();
			if (o instanceof EObject) {
				mySource = (EObject) o;
			} else {
				mySource = null;
			}
		}

		/*
		 * Get the list of myObject
		 */
		if (mySource != null) {
			final Object l = mySource.eGet(myListRef);
			if (l instanceof EList) {
				myList = (EList<T>) l;
			} else {
				myList = null;
			}
		}

		myIndex = -1;
		myElement = null;
		if (myList != null) {
			for (int i = 0; i < myList.size(); i++) {
				final T e = myList.get(i);
				if (UIBindingsUtils.equals(e.eGet(myKeySF), myKey)) {
					myIndex = i;
					myElement = e;
					break;
				}
			}
		}

		myValue = null;
		if (myElement != null) {
			myValue = myElement.eGet(myValueSF);
		}

		/*
		 * Adds or removes listeners depending on the wanted listener state.
		 */
		if (myListenSourceOV != mySourceOV || !hasListeners()) {
			if (myListenSourceOV != null) {
				myListenSourceOV.removeChangeListener(myListener);
				myListenSourceOV = null;
			}
			if (mySourceOV != null && hasListeners()) {
				myListenSourceOV = mySourceOV;
				myListenSourceOV.addChangeListener(myListener);
			}
		}
		if (myListenSource != mySource || !hasListeners()) {
			if (myListenSource != null) {
				myListenSource.eAdapters().remove(myListener);
				myListenSource = null;
			}
			if (mySource != null && hasListeners()) {
				myListenSource = mySource;
				myListenSource.eAdapters().add(myListener);
			}
		}
		if (myListenList != myList || !hasListeners()) {
			if (myListenList != null) {
				for (final T e : myListenList) {
					e.eAdapters().remove(myListener);
				}
				myListenList = null;
			}
			if (myElement != null && hasListeners()) {
				myListenList = myList;
				for (final T e : myListenList) {
					e.eAdapters().add(myListener);
				}
			}
		}

		if (!UIBindingsUtils.equals(myValue, myReportedValue)) {
			fireValueChange(Diffs.createValueDiff(myReportedValue, myReportedValue = myValue));
		}
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

		calcValue();
	}

	@Override
	protected void lastListenerRemoved() {
		super.lastListenerRemoved();

		calcValue();
	}

	@Override
	protected final Object doGetValue() {
		calcValue();
		return myValue;
	}

	@Override
	protected void doSetValue(final Object value) {
		if (UIBindingsUtils.equals(value, myValue)) return;
		if (myList == null) throw new IndexOutOfBoundsException("No list in source");
		final Command command;
		/*
		 * If the element already exists, then change the value. Otherwise, create a new element
		 * with the correct key and value.
		 */
		if (myElement != null) {
			Assert.isTrue(myIndex != -1);
			command = new SetCommand(myEditingDomain, myElement, myValueSF, value);
		} else {
			final EClass referenceType = myListRef.getEReferenceType();
			final EObject object = EcoreUtil.create(referenceType);
			object.eSet(myKeySF, myKey);
			object.eSet(myValueSF, value);
			command = new AddCommand(myEditingDomain, myList, object);
		}
		myEditingDomain.getCommandStack().execute(command);
		calcValue();
	}

	@Override
	public Object getValueType() {
		return myValueSF;
	}

	private class Listener extends AdapterImpl implements IChangeListener {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;

			if (msg.getFeature() == myListRef) {
				/*
				 * Only list changes from the source object
				 */
				if (msg.getNotifier() != mySource) return;
				switch (msg.getEventType()) {
				case Notification.REMOVE:
				case Notification.SET:
					final EObject oldObj = (EObject) msg.getOldValue();
					oldObj.eAdapters().remove(myListener);
					break;
				default:
					break;
				}
				switch (msg.getEventType()) {
				case Notification.ADD:
				case Notification.SET:
					final EObject newObj = (EObject) msg.getNewValue();
					newObj.eAdapters().add(myListener);
					break;
				default:
					break;
				}
			} else if (msg.getFeature() == myValueSF) {
				/*
				 * Only value changes from the element object
				 */
				if (msg.getNotifier() != myElement) return;
			} else if (msg.getFeature() == myKeySF) {
				/*
				 * Key changes from all elements in the list
				 */
			} else
				/*
				 * No other changes are interesting
				 */
				return;
			calcValue();
		};

		@Override
		public void handleChange(ChangeEvent event) {
			calcValue();
		}
	}
}
