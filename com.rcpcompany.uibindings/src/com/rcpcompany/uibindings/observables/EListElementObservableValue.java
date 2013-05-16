/*******************************************************************************
 * Copyright (c) 2006-2013 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.observables;

import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.model.utils.BasicUtils;
import com.rcpcompany.uibindings.utils.EditingDomainUtils;

/**
 * Basic {@link IObservableValue observable value} for an element in an EMF {@link EList}.
 * <p>
 * Can be configured to "auto extend" the list to the correct size (only happens on set) - if the
 * list is not {@link EReference#isUnique() "unique"} - by adding <code>null</code> values
 * (defaults) to <code>false</code>.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EListElementObservableValue extends AbstractObservableValue implements IKeyedObservable, IObserving {
	private final IObservableValue myObjectOV;
	private final EStructuralFeature mySF;
	private final int myIndex;
	private final EditingDomain myEditingDomain;
	/**
	 * Whether the list is automatically extended as needed.
	 */
	private boolean myExpendList = false;

	private EObject myObject = null;

	private final IChangeListener myObjectOVListener = new IChangeListener() {
		@Override
		public void handleChange(ChangeEvent event) {
			updateValue();
		}
	};

	private final Adapter myAdapter = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;
			updateValue();
		};
	};

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
		this(EditingDomainUtils.getEditingDomain(), ov, sf, index);
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

		Assert.isTrue(mySF.isMany());

		myObjectOV.addChangeListener(myObjectOVListener);
		IManager.Factory.getManager().startMonitorObservableDispose(myObjectOV, this);
		updateValue();
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
		getRealm().exec(new Runnable() {
			@Override
			public void run() {
				Object value = null;
				try {
					final EObject newObject = (EObject) myObjectOV.getValue();
					if (myObject != newObject) {
						if (myObject != null) {
							myObject.eAdapters().remove(myAdapter);
						}
						myObject = newObject;
						if (myObject != null) {
							myObject.eAdapters().add(myAdapter);
						}
					}
					if (myObject == null) return;

					final EList<?> list = (EList<?>) myObject.eGet(mySF);
					if (list == null) return;
					if (list.size() <= myIndex) return;

					value = list.get(myIndex);
				} finally {
					if (BasicUtils.equals(value, myValue)) return;

					fireValueChange(Diffs.createValueDiff(myValue, myValue = value));
				}
			}
		});
	}

	@Override
	public synchronized void dispose() {
		IManager.Factory.getManager().stopMonitorObservableDispose(myObjectOV);
		if (myObjectOV != null) {
			myObjectOV.removeChangeListener(myObjectOVListener);
		}
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
		return myValue;
	}

	@Override
	protected void doSetValue(final Object value) {
		final CompoundCommand cc = new CompoundCommand();
		if (isExpendList() && !mySF.isUnique()) {
			final List<?> l = (List<?>) myObject.eGet(mySF);
			/*
			 * Missing elements, if possible
			 */
			final int missing = myIndex + 1 - l.size();
			for (int i = 0; i < missing; i++) {
				cc.append(new AddCommand(myEditingDomain, myObject, mySF, (Object) null));
			}
		}
		cc.append(new SetCommand(myEditingDomain, myObject, mySF, value, myIndex));
		myEditingDomain.getCommandStack().execute(cc.unwrap());
	}

	@Override
	public Object getValueType() {
		return mySF.getEType();
	}

	/**
	 * Sets whether the list is automatically extended as needed.
	 * 
	 * @param expendList <code>true</code> if the list should be extended automatically
	 */
	public void setExpendList(boolean myExpendList) {
		this.myExpendList = myExpendList;
	}

	/**
	 * Returns whether the list is automatically extended as needed.
	 * 
	 * @return <code>true</code> if the list is automatically extended
	 */
	public boolean isExpendList() {
		return myExpendList;
	}
}
