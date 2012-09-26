/*******************************************************************************
 * Copyright (c) 2017, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.observables;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * An {@link IObservableList observable list} that given an observed list and a mapper object, will
 * return a new list with the elements from the list mapped with the mapper.
 * <p>
 * Alternatively, the list can also take an EMF based observed list and an a
 * {@link EStructuralFeature structural feature} will provide a new list with the values of the
 * objects of the original list with the specific feature.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EMFListAttributeList extends WritableList implements IObserving {

	private final IObservableList myObjectList;
	private final IObservableListMapper myMapper;

	/**
	 * The value used to replace <code>null</code> values in the resulting list.
	 * <p>
	 * Thus, if the mapper returns <code>null</code>, this value is used instead (if set).
	 */
	private final Object myNullReplacementValue;

	/**
	 * Returns the value used to replace <code>null</code> values in the resulting list.
	 * 
	 * @return the current replacement value
	 */
	public Object getNullReplacementValue() {
		return myNullReplacementValue;
	}

	/**
	 * Sets the special label to be used for the <code>null</code> value.
	 * 
	 * @param nullLabel the <code>null</code> label
	 */
	public void setNullLabel(String nullLabel) {
		super.add(nullLabel);
	}

	/**
	 * Constructs and returns a new list for the specified list and mapper object.
	 * 
	 * @param objectList the observed list
	 * @param mapper the mapper object
	 * @param type the element type of the resulting list
	 */
	public EMFListAttributeList(IObservableList objectList, IObservableListMapper mapper, Object type,
			Object nullReplacementValue) {
		super(new ArrayList<Object>(), type);
		myObjectList = objectList;
		myMapper = mapper;
		myNullReplacementValue = nullReplacementValue;

		init();
	}

	/**
	 * Constructs and returns a new list for the specified list and mapper object.
	 * 
	 * @param objectList the observed list
	 * @param mapper the mapper object
	 * @param type the element type of the resulting list
	 */
	public EMFListAttributeList(IObservableList objectList, IObservableListMapper mapper, Object type) {
		this(objectList, mapper, type, null);
	}

	/**
	 * Constructs and returns a new list for the specified EMF list and feature.
	 * 
	 * @param objectList the EMF list to monitor
	 * @param structuralfeature the structural feature to retrieve
	 */
	public EMFListAttributeList(IObservableList objectList, final EStructuralFeature structuralfeature) {
		this(objectList, new IObservableListMapper() {
			@Override
			public Object map(Object value) {
				return ((EObject) value).eGet(structuralfeature);
			}
		}, structuralfeature);
	}

	private final Adapter myFeatureMonitor = new AdapterImpl() {
		@Override
		public void notifyChanged(final Notification msg) {

			/*
			 * Cannot use toString() as this calls getterCalled()....
			 * 
			 * LogUtils.error(EMFListAttributeList.this , "List disposed: " +
			 * EMFListAttributeList.this);
			 */
			if (isDisposed()) return;
			if (msg.isTouch()) return;
			if (msg.getEventType() != Notification.SET) return;

			myObjectList.getRealm().exec(new Runnable() {
				@Override
				public void run() {
					final int index = myObjectList.indexOf(msg.getNotifier());
					if (index == -1) return;
					final Object oldValue = get(index);
					Object newValue;
					try {
						newValue = myMapper.map(msg.getNotifier());
					} catch (final Exception ex) {
						newValue = null;
						LogUtils.error(myMapper, ex);
					}
					if (newValue == null ? oldValue == null : newValue.equals(oldValue)) return;
					EMFListAttributeList.super.set(index, newValue);
				}
			});
		};
	};

	private final IListChangeListener myListMonitor = new IListChangeListener() {
		private final ListDiffVisitor visitor = new ListDiffVisitor() {
			@Override
			public void handleRemove(int index, Object element) {
				if (element != null && hasListeners()) {
					((EObject) element).eAdapters().remove(myFeatureMonitor);
				}
				EMFListAttributeList.super.remove(index);
			}

			@Override
			public void handleAdd(int index, Object element) {
				EMFListAttributeList.super.add(index, mapValue(element));
				if (element != null && hasListeners()) {
					((EObject) element).eAdapters().add(myFeatureMonitor);
				}
			}
		};

		@Override
		public void handleListChange(ListChangeEvent event) {
			event.diff.accept(visitor);
		}
	};

	private void init() {
		IManager.Factory.getManager().startMonitorObservableDispose(myObjectList, this);
		for (final Object o : myObjectList) {
			super.add(mapValue(o));
		}
	}

	/**
	 * Maps a single value with the mapper.
	 * <p>
	 * If
	 * 
	 * @param obj the object to map
	 * @return the mapped value
	 */
	private Object mapValue(final Object obj) {
		Object v;
		try {
			v = myMapper.map(obj);
		} catch (final Exception ex) {
			LogUtils.error(myMapper, ex);
			v = null;
		}
		if (v == null) {
			v = myNullReplacementValue;
		}
		return v;
	}

	@Override
	public synchronized void dispose() {
		IManager.Factory.getManager().stopMonitorObservableDispose(myObjectList);
		if (hasListeners()) {
			lastListenerRemoved();
		}
		super.dispose();
	}

	@Override
	protected void firstListenerAdded() {
		super.firstListenerAdded();

		myObjectList.addListChangeListener(myListMonitor);
		for (final Object o : myObjectList) {
			final EObject obj = (EObject) o;
			if (obj != null) {
				obj.eAdapters().add(myFeatureMonitor);
			}
		}
	}

	@Override
	protected void lastListenerRemoved() {
		for (final Object o : myObjectList) {
			final EObject obj = (EObject) o;
			if (obj != null) {
				obj.eAdapters().remove(myFeatureMonitor);
			}
		}
		myObjectList.removeListChangeListener(myListMonitor);

		super.lastListenerRemoved();
	}

	@Override
	public Object getObserved() {
		return myObjectList;
	}

	@Override
	public void add(int index, Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object set(int index, Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object move(int oldIndex, int newIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection c) {
		throw new UnsupportedOperationException();
	}
}
