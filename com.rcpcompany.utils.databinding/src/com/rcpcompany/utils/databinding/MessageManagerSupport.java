/*******************************************************************************
 * Copyright (c) 2006-2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.utils.databinding;

import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.ISWTObservable;
import org.eclipse.jface.databinding.wizard.WizardPageSupport;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IMessageManager;

/**
 * This class is a parallel to {@link WizardPageSupport} but for
 * {@link IMessageManager}.
 * <p>
 * The class monitors the {@link ValidationStatusProvider validation status
 * providers} of the specified context, and adds/removes messages from these to
 * the message manager.
 * <p>
 * This class lives off the fact that all the changes for the observables are
 * performed in the UI thread....
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class MessageManagerSupport {
	protected final IMessageManager myMessageManager;
	protected final DataBindingContext myContext;

	/**
	 * Constructs and returns a new support object for the specified message
	 * manager and data binding context.
	 * 
	 * @param mm
	 *            the message manager
	 * @param context
	 *            the data binding context
	 */
	private MessageManagerSupport(IMessageManager mm, DataBindingContext context) {
		myMessageManager = mm;
		myContext = context;

		myContext.getValidationStatusProviders().addListChangeListener(
				new IListChangeListener() {
					@Override
					public void handleListChange(ListChangeEvent event) {
						event.diff.accept(myVisitor);
					}
				});
		for (final Object o : myContext.getValidationStatusProviders()) {
			myVisitor.handleAdd(0, o);
		}
	}

	/**
	 * Disposes the support object.
	 */
	public void dispose() {
		for (final Object o : myContext.getValidationStatusProviders()) {
			myVisitor.handleRemove(0, o);
		}
	}

	/**
	 * Constructs and returns a new support object for the specified message
	 * manager and data binding context.
	 * 
	 * @param mm
	 *            the message manager
	 * @param context
	 *            the data binding context
	 * @return the new support object
	 */
	public static MessageManagerSupport create(IMessageManager mm,
			DataBindingContext context) {
		return new MessageManagerSupport(mm, context);
	}

	/**
	 * Visitor that adds and removes a validation status listener from the
	 * context.
	 * 
	 */
	protected final ListDiffVisitor myVisitor = new ListDiffVisitor() {
		@Override
		public void handleAdd(int index, Object element) {
			final ValidationStatusProvider p = (ValidationStatusProvider) element;
			p.getValidationStatus().addValueChangeListener(
					new IValueChangeListener() {
						@Override
						public void handleValueChange(ValueChangeEvent event) {
							if (myMessageManager.isAutoUpdate()) {
								myMessageManager.setAutoUpdate(false);
								PlatformUI.getWorkbench().getDisplay()
										.asyncExec(new Runnable() {
											@Override
											public void run() {
												myMessageManager
														.setAutoUpdate(true);
											}
										});
							}
							// LogUtils.debug(MessageManagerSupport.this,
							// "Provider: " +
							// p + " - event: " + event);
							@SuppressWarnings("unchecked")
							final List<IObservableValue> targets = p
									.getTargets();

							/*
							 * See if the status message is associated with a
							 * specific control...
							 */
							Control control = null;
							if (targets.get(0) instanceof ISWTObservable) {
								final Widget widget = ((ISWTObservable) (targets
										.get(0))).getWidget();
								if (widget instanceof Control) {
									control = (Control) widget;
								}
							}

							IStatus status = (IStatus) event.diff.getOldValue();
							if (status.getSeverity() != IStatus.OK) {
								final String messageKey = String.valueOf(status
										.hashCode());
								if (control == null) {
									myMessageManager.removeMessage(messageKey);
								} else {
									myMessageManager.removeMessage(messageKey,
											control);
								}
							}

							status = (IStatus) event.diff.getNewValue();
							if (status.getSeverity() != IStatus.OK) {
								int errorType = IMessageProvider.NONE;

								if (status.getSeverity() == IStatus.ERROR) {
									errorType = IMessageProvider.ERROR;
								} else if (status.getSeverity() == IStatus.WARNING) {
									errorType = IMessageProvider.WARNING;
								} else if (status.getSeverity() == IStatus.INFO) {
									errorType = IMessageProvider.INFORMATION;
								}
								final String messageKey = String.valueOf(status
										.hashCode());
								if (control == null) {
									myMessageManager.addMessage(messageKey,
											status.getMessage(), null,
											errorType);
								} else {
									myMessageManager.addMessage(messageKey,
											status.getMessage(), null,
											errorType, control);
								}
							}
						}
					});
		}

		@Override
		public void handleRemove(int index, Object element) {
		}
	};

}
