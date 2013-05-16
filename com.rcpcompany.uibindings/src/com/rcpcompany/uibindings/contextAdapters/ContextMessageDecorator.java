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
package com.rcpcompany.uibindings.contextAdapters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.jface.dialogs.IMessageProvider;

import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IBindingMessage;
import com.rcpcompany.uibindings.internal.bindingMessages.IContextMessageProvider;
import com.rcpcompany.uibindings.internal.utils.AbstractContextMonitor;
import com.rcpcompany.uibindings.utils.IManagerRunnable;

/**
 * Message decorator support for a single {@link IBindingContext}.
 * <p>
 * This class controls the message decorator of all bindings of the context as well as the
 * form/wizard/whatever that hosts the binding context.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ContextMessageDecorator extends AbstractContextMonitor {
	/**
	 * The {@link IContextMessageDecoratorAdapter adapter} for this decorator context.
	 */
	private IContextMessageDecoratorAdapter myAdapter;

	/**
	 * Returns the adapter of this decorator.
	 * 
	 * @return the adapter
	 */
	public IContextMessageDecoratorAdapter getAdapter() {
		return myAdapter;
	}

	/**
	 * Returns a list of all messages for this decorator.
	 * 
	 * @return the messages
	 */
	public List<IBindingMessage> getMessages() {
		return myMessages;
	}

	/**
	 * Constructs and returns a new decorator.
	 * 
	 * @param context the context
	 * @param adapter the adapter for the actual context form
	 */
	public ContextMessageDecorator(IBindingContext context, IContextMessageDecoratorAdapter adapter) {
		super(context);
		myAdapter = adapter;

		getContext().registerService(this);
		init();
	}

	@Override
	public void dispose() {
		getContext().unregisterService(this);
		super.dispose();
		if (myAdapter != null) {
			myAdapter.dispose();
			myAdapter = null;
		}
	}

	// @Override
	// protected void bindingAdded(IBinding binding) {
	// super.bindingAdded(binding);
	//
	// /*
	// * The following is a little complex, but...
	// *
	// * For each viewer binding a ViewerBindingMessageDecorator is created and associated with the
	// binding as a
	// * service.
	// *
	// * For each value binding, it is checked whether it has an ARG_CELL_KEY argument. This, if
	// present, is the cell
	// * that constructed the binding - it is handled in ColumnBindingCellInformationImpl.init(...).
	// *
	// * If the cell is found, one widget decoration creation factory is used that will create a
	// sub-cell decoration
	// * of the ViewerBindingMessageDecorator.
	// *
	// * If it is not found an ordinary ControlDecoration is used.
	// */
	// IContextMessageProvider p = null;
	// if (binding instanceof IViewerBinding) {
	// final IViewerBinding viewer = (IViewerBinding) binding;
	// new ViewerBindingMessageDecorator(viewer);
	// } else if (binding instanceof IValueBinding) {
	// final IValueBinding vb = (IValueBinding) binding;
	// final IColumnBindingCellInformation cell = vb.getCell();
	// final Control control = vb.getControl();
	// if (cell != null) {
	// final IViewerBinding viewer = cell.getColumn().getViewerBinding();
	// final ViewerBindingMessageDecorator decorator =
	// viewer.getService(ViewerBindingMessageDecorator.class);
	// final IWidgetDecorationFactory factory = new IWidgetDecorationFactory() {
	// @Override
	// public IWidgetDecoration create(int position) {
	// return decorator.addCellDecoration(cell, position);
	// }
	// };
	// p = new ValueBindingMessageImageDecorator(vb, factory, false);
	// } else if (control != null) {
	// final IWidgetDecorationFactory factory = new IWidgetDecorationFactory() {
	// @Override
	// public IWidgetDecoration create(int position) {
	// return new ControlWidgetDecoration(control, position, getContext().getTop());
	// }
	// };
	// p = new ValueBindingMessageImageDecorator(vb, factory, true);
	// } else {
	// /*
	// * No need for decoration factory as we don't have a control....
	// */
	// p = new ValueBindingMessageImageDecorator(vb, null, false);
	// }
	//
	// if (p != null) {
	// addMessageProvider(p);
	// }
	// }
	// }

	/**
	 * Adds a new message provider to this context decorator.
	 * <p>
	 * Adds listener to monitor the changes in the messages for the provider
	 * 
	 * @param provider the provider
	 */
	public void addMessageProvider(IContextMessageProvider provider) {
		provider.getMessages().addListChangeListener(myProviderChangeListener);
	}

	/**
	 * Removes a message provider.
	 * 
	 * @param provider the provider
	 */
	public void removeMessageProvider(IContextMessageProvider provider) {
		provider.getMessages().removeListChangeListener(myProviderChangeListener);
	}

	// @Override
	// protected void bindingRemoved(IBinding binding) {
	// super.bindingRemoved(binding);
	//
	// final IContextMessageProvider p = binding.getService(IContextMessageProvider.class);
	// if (p != null) {
	// removeMessageProvider(p);
	// }
	// }

	/**
	 * Listener that monitors the messages providers for any changes in the messages.
	 */
	private final IListChangeListener myProviderChangeListener = new IListChangeListener() {
		private final ListDiffVisitor myVisitor = new ListDiffVisitor() {

			@Override
			public void handleRemove(int index, Object element) {
				getMessages().remove(element);
			}

			@Override
			public void handleAdd(int index, Object element) {
				getMessages().add((IBindingMessage) element);
			}
		};

		@Override
		public void handleListChange(ListChangeEvent event) {
			event.diff.accept(myVisitor);
			updateMessages();
		}
	};

	/**
	 * The list of current messages.
	 */
	private final List<IBindingMessage> myMessages = new ArrayList<IBindingMessage>();

	/**
	 * {@link Runnable} for the next delayed update up messages in the adapter.
	 */
	private final Runnable myUpdateMessagesRunnable = new Runnable() {
		@Override
		public void run() {
			if (myAdapter != null) {
				/*
				 * Weed out any superseded messages.
				 */
				final List<IBindingMessage> ml = new ArrayList<IBindingMessage>(getMessages());
				if (ml.size() > 0) {
					final IBindingMessage[] ma = ml.toArray(new IBindingMessage[ml.size()]);
					for (int i = 0; i < ma.length; i++) {
						final IBindingMessage a = ma[i];
						for (int j = i + 1; j < ma.length; j++) {
							final IBindingMessage b = ma[j];
							if (a.supersedes(b)) {
								ml.remove(b);
								continue;
							}
							if (b.supersedes(a)) {
								ml.remove(a);
								break;
							}
						}
					}
				}
				final int type = ml.size() > 0 ? ml.get(0).getMessageType() : IMessageProvider.NONE;
				myAdapter.update(ml, type == IMessageProvider.ERROR, type);
			}
		}
	};

	/**
	 * Updates the messages for the context.
	 */
	protected void updateMessages() {
		IManagerRunnable.Factory.asyncExec("update", this, myUpdateMessagesRunnable);
	}
}
