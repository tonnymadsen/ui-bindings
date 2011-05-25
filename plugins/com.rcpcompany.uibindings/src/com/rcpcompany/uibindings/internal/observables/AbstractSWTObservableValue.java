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
package com.rcpcompany.uibindings.internal.observables;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Widget;

/**
 * Copied strait out of
 * {@link org.eclipse.jface.internal.databinding.provisional.swt.AbstractSWTObservableValue}.
 */
public abstract class AbstractSWTObservableValue extends AbstractObservableValue implements ISWTObservableValue {

	private final Widget widget;

	/**
	 * Standard constructor for an SWT ObservableValue. Makes sure that the observable gets disposed
	 * when the SWT widget is disposed.
	 * 
	 * @param widget
	 */
	protected AbstractSWTObservableValue(Widget widget) {
		this(SWTObservables.getRealm(widget.getDisplay()), widget);
	}

	/**
	 * Constructor that allows for the setting of the realm. Makes sure that the observable gets
	 * disposed when the SWT widget is disposed.
	 * 
	 * @param realm
	 * @param widget
	 */
	protected AbstractSWTObservableValue(Realm realm, Widget widget) {
		super(realm);
		this.widget = widget;
		widget.addDisposeListener(disposeListener);
	}

	@Override
	public synchronized void dispose() {
		if (!widget.isDisposed()) {
			widget.removeDisposeListener(disposeListener);
		}
		super.dispose();
	}

	/**
	 * Dispose listener for the backed SWT widget. Not just added/removed in
	 * {@link #firstListenerAdded()} and {@link #lastListenerRemoved()} as we want to track disposal
	 * of the widget even if we don't have any listeners.
	 */
	private final DisposeListener disposeListener = new DisposeListener() {
		@Override
		public void widgetDisposed(DisposeEvent e) {
			AbstractSWTObservableValue.this.dispose();
		}
	};

	/**
	 * @return Returns the widget.
	 */
	@Override
	public Widget getWidget() {
		return widget;
	}
}
