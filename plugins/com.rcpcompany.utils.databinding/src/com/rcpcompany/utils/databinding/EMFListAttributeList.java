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
package com.rcpcompany.utils.databinding;

import java.util.ArrayList;

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

/**
 * A observable list that given an observed EMF based list and a {@link EStructuralFeature
 * structural feature} will provide a new list with the values of the object of the original list
 * with the specific feature.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class EMFListAttributeList extends WritableList implements IObservableList, IObserving {

	private final IObservableList myObjectList;
	private final IObservableListMapper myMapper;

	public EMFListAttributeList(IObservableList objectList, final EStructuralFeature structuralfeature) {
		this(objectList, new IObservableListMapper() {
			@Override
			public Object map(Object value) {
				return ((EObject) value).eGet(structuralfeature);
			}
		}, structuralfeature);
	}

	public EMFListAttributeList(IObservableList objectList, IObservableListMapper mapper, Object type) {
		super(new ArrayList<Object>(), type);
		myObjectList = objectList;
		myMapper = mapper;

		init();
	}

	private final Adapter myFeatureMonitor = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;
			if (msg.getEventType() != Notification.SET) return;

			final int index = myObjectList.indexOf(msg.getNotifier());
			if (index == -1) return;
			final Object oldValue = get(index);
			final Object newValue = myMapper.map(msg.getNotifier());
			if (newValue == null ? oldValue == null : newValue.equals(oldValue)) return;
			set(index, newValue);
		};
	};

	private final IListChangeListener myListMonitor = new IListChangeListener() {
		private final ListDiffVisitor visitor = new ListDiffVisitor() {
			@Override
			public void handleRemove(int index, Object element) {
				((EObject) element).eAdapters().remove(myFeatureMonitor);
				remove(index);
			}

			@Override
			public void handleAdd(int index, Object element) {
				add(index, myMapper.map(element));
				((EObject) element).eAdapters().add(myFeatureMonitor);
			}
		};

		@Override
		public void handleListChange(ListChangeEvent event) {
			event.diff.accept(visitor);
		}
	};

	private void init() {
		for (final Object o : myObjectList) {
			final EObject obj = (EObject) o;
			add(myMapper.map(obj));
		}
	}

	@Override
	protected void firstListenerAdded() {
		super.firstListenerAdded();

		myObjectList.addListChangeListener(myListMonitor);
		for (final Object o : myObjectList) {
			final EObject obj = (EObject) o;
			obj.eAdapters().add(myFeatureMonitor);
		}
	}

	@Override
	protected void lastListenerRemoved() {
		for (final Object o : myObjectList) {
			final EObject obj = (EObject) o;
			obj.eAdapters().remove(myFeatureMonitor);
		}
		myObjectList.removeListChangeListener(myListMonitor);

		super.lastListenerRemoved();
	}

	@Override
	public Object getObserved() {
		return myObjectList;
	}
}
