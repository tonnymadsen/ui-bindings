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
package com.rcpcompany.uibindings.uiAttributes;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIAttribute;
import com.rcpcompany.uibindings.internal.UIAttributeImpl;

/**
 * Abstract base class for all {@link IUIAttribute} implementations. Used to isolate the concreate
 * implementations from trivial changes in the interface.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractUIAttribute extends UIAttributeImpl {

	@Override
	public abstract Widget getWidget();

	@Override
	public IObservableValue getImageValue() {
		return null;
	}

	@Override
	public Image getImage() {
		final IObservableValue value = getImageValue();
		if (value == null) return null;
		return (Image) value.getValue();
	}

	@Override
	public abstract IObservableValue getCurrentValue();

	@Override
	public Cursor getCursor() {
		final IObservableValue value = getCursorValue();
		if (value == null) return null;
		return (Cursor) value.getValue();
	}

	@Override
	public IObservableList getPossibleValuesList() {
		return null;
	}

	@Override
	public IObservableList getStyleRangeList() {
		return null;
	}

	@Override
	public List<StyleRange> getStyleRanges() {
		final IObservableList list = getStyleRangeList();
		if (list == null) return null;
		return list;
	}

	@Override
	public IObservableValue getMaxValue() {
		return null;
	}

	@Override
	public IObservableValue getMinValue() {
		return null;
	}

	@Override
	public IObservableValue getTooltipValue() {
		return null;
	}

	@Override
	public String getTooltip() {
		final IObservableValue value = getTooltipValue();
		if (value == null) return null;
		return (String) value.getValue();
	}

	@Override
	public IControlContentAdapter getFieldAssistAdapter() {
		return null;
	}

	@Override
	public IObservableValue getFontValue() {
		return null;
	}

	@Override
	public Font getFont() {
		final IObservableValue value = getFontValue();
		if (value == null) return null;
		return (Font) value.getValue();
	}

	@Override
	public IObservableValue getForegroundValue() {
		return null;
	}

	@Override
	public Color getForeground() {
		final IObservableValue value = getForegroundValue();
		if (value == null) return null;
		return (Color) value.getValue();
	}

	@Override
	public IObservableValue getBackgroundValue() {
		return null;
	}

	@Override
	public Color getBackground() {
		final IObservableValue value = getBackgroundValue();
		if (value == null) return null;
		return (Color) value.getValue();
	}

	@Override
	public IObservableValue getEnabledValue() {
		return null;
	}

	@Override
	public Boolean isEnabled() {
		final IObservableValue value = getEnabledValue();
		if (value == null) return null;
		return (Boolean) value.getValue();
	}

	private final List<IObservable> myObservables = new ArrayList<IObservable>();
	/**
	 * All observable listeners for this object goes via this...
	 */
	protected IChangeListener[] myListeners = null;

	@Override
	public void dispose() {
		for (final IObservable v : myObservables) {
			IManager.Factory.getManager().stopMonitorObservableDispose(v);

			if (myListeners != null) {
				for (final IChangeListener myListener : myListeners) {
					if (myListener != null) {
						v.removeChangeListener(myListener);
					}
				}
			}

			v.dispose();
		}
		super.dispose();
	}

	/**
	 * Adds an observable that must be disposed when this attribute is disposed.
	 * 
	 * @param observable the observable to dispose
	 * @return the observable itself
	 */
	protected final IObservableValue addObservable(IObservableValue observable) {
		addObservable((IObservable) observable);
		return observable;
	}

	/**
	 * Adds an observable that must be disposed when this attribute is disposed.
	 * 
	 * @param observable the observable to dispose
	 * @return the observable itself
	 */
	protected final IObservableList addObservable(IObservableList observable) {
		addObservable((IObservable) observable);
		return observable;
	}

	private final void addObservable(IObservable observable) {
		myObservables.add(observable);
		IManager.Factory.getManager().startMonitorObservableDispose(observable);
		if (myListeners != null) {
			for (final IChangeListener myListener : myListeners) {
				if (myListener != null) {
					observable.addChangeListener(myListener);
				}
			}
		}
	}

	/**
	 * Adds the specified change listener to all the observable values of this attribute.
	 * 
	 * @param listener the listener to add
	 */
	public void addChangeListener(IChangeListener listener) {
		int i = -1;
		if (myListeners == null) {
			// The standard case is exactly one listener
			myListeners = new IChangeListener[1];
			i = 0;
		} else {
			final int l = myListeners.length;
			for (int n = 0; n < l; n++) {
				if (myListeners[n] == null) {
					i = n;
					break;
				}
			}
			if (i == -1) {
				final IChangeListener[] newListeners = new IChangeListener[l + 2];
				System.arraycopy(myListeners, 0, newListeners, 0, l);
				myListeners = newListeners;
				i = l;
			}
		}

		myListeners[i] = listener;
		for (final IObservable o : myObservables) {
			o.addChangeListener(listener);
		}
	}

	/**
	 * Removes the specified change listener from all the observable values of this attribute.
	 * 
	 * @param listener the listener to remove
	 */
	public void removeChangeListener(IChangeListener listener) {
		if (myListeners == null) return;
		for (int n = 0; n < myListeners.length; n++) {
			if (myListeners[n] == listener) {
				myListeners[n] = null;
				break;
			}
		}
		for (final IObservable o : myObservables) {
			o.removeChangeListener(listener);
		}
	}
}
