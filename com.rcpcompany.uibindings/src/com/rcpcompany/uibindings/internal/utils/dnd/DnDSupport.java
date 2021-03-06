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

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.internal.utils.AbstractContextMonitor;
import com.rcpcompany.uibindings.utils.IDnDSupport;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of {@link IDnDSupport}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class DnDSupport extends AbstractContextMonitor implements IDnDSupport {
	public static IDnDSupport installOn(IBindingContext context) {
		IDnDSupport support = context.getService(IDnDSupport.class);
		if (support == null) {
			support = new DnDSupport(context);
		}
		return support;
	}

	/**
	 * The supported transfer types...
	 */
	private final Transfer[] myTransferTypes = new Transfer[] { BindingTransfer.getInstance() };

	/**
	 * Constructs and returns a new support object.
	 * 
	 * @param context the context the drag 'n drop support
	 */
	public DnDSupport(IBindingContext context) {
		super(context);

		init();
	}

	@Override
	protected void bindingAdded(IBinding binding) {
		final Control control = binding.getControl();
		if (control == null) return;

		/*
		 * No drag-n-drop for non-default attributes..
		 */
		if (binding instanceof IValueBinding) {
			final IValueBinding vb = (IValueBinding) binding;
			final String attr = vb.getUIAttribute().getAttribute();
			if (attr != null && attr.length() > 0) return;
		}

		/*
		 * Only when the object of the binding is capable
		 * 
		 * The try-catch block is used to screen again some nasty DND exceptions
		 */
		try {
			DragSourceListener dragListener = null;
			dragListener = new BindingDragAdapter();
			if (dragListener != null) {
				final DragSource dragSource = new DragSource(control, DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK);
				dragSource.setTransfer(myTransferTypes);
				dragSource.addDragListener(dragListener);
				binding.registerService(dragListener);
			}

			DropTargetListener dropListener = null;
			if (binding instanceof IViewerBinding) {
				final IViewerBinding vb = (IViewerBinding) binding;
				dropListener = new ContainerBindingDropAdapter(vb);
			}

			if (binding instanceof IContainerBinding) {
				final IContainerBinding vb = (IContainerBinding) binding;
				dropListener = new ContainerBindingDropAdapter(vb);
			}
			if (dropListener != null) {
				final DropTarget dropTarget = new DropTarget(control, DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK);
				dropTarget.setTransfer(myTransferTypes);
				dropTarget.addDropListener(dropListener);
				binding.registerService(dropListener);
			}
		} catch (final Exception ex) {
			LogUtils.error(binding, ex);
		}
	}
}
