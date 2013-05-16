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
package com.rcpcompany.uibindings.internal.utils.dnd;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.widgets.Widget;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;

/**
 * Implementation of {@link DragSourceListener} for bindings.
 * 
 * @author Tonny Madsen, The RCP Company
 * 
 */
public class BindingDragAdapter implements DragSourceListener {
	/**
	 * The selection at the start of the drag operation.
	 */
	protected Collection<EObject> mySelection = null;

	/**
	 * This creates an instance for the given viewer.
	 */
	public BindingDragAdapter() {
		super();
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		Widget widget = event.widget;
		if (widget instanceof DragSource) {
			final DragSource ds = (DragSource) widget;
			widget = ds.getControl();
		}
		final IBinding binding = IBindingContext.Factory.getBindingForWidget(widget);
		if (binding == null) {
			event.doit = false;
			return;
		}
		mySelection = binding.getSelection();
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		mySelection = null;
		BindingTransfer.getInstance().javaToNative(null, null);
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		if (BindingTransfer.getInstance().isSupportedType(event.dataType)) {
			event.data = mySelection;
		}
	}
}
