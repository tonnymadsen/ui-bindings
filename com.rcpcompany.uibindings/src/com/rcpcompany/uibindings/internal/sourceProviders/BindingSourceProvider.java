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
package com.rcpcompany.uibindings.internal.sourceProviders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextActivation;
import org.eclipse.ui.contexts.IContextService;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.ISourceProviderStateContext;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtender;
import com.rcpcompany.uibindings.IUIBindingDecoratorExtenderDescriptor;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.model.utils.BasicUtils;
import com.rcpcompany.uibindings.utils.IManagerRunnable;
import com.rcpcompany.utils.basic.ClassUtils;
import com.rcpcompany.utils.basic.ui.TSSWTUtils;
import com.rcpcompany.utils.extensionpoints.CEObjectHolder;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Source Provider for the UI Binding framework.
 * <p>
 * As a side effect this source provider also activates/deactivates UI contexts - see
 * {@link Constants#CONTAINER_CONTEXT_ID} and {@link Constants#WIDGET_CONTEXT_ID}.
 * <p>
 * This class has a number of interfaces:
 * <dl>
 * <dt>{@link AbstractSourceProvider}</dt>
 * <dd>Used by the expression framework.</dd>
 * <dt>{@link BindingSourceProvider#getCurrentState(Event)}</dt>
 * <dd>Calculates a new state based on the event, but it does <em>not</em> alter the global state.</dd>
 * <dt>{@link BindingSourceProvider#reportSourceChanges(Event)}</dt>
 * <dd>Calculates a new state based on the event, <em>and</em> alters the global state.</dd>
 * </dl>
 * The provider uses a number of SWT events and if the current focus control is a {@link Table} or
 * {@link Tree}, it also monitors the current selection.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingSourceProvider extends AbstractSourceProvider {

	/**
	 * The names of the sources supported by this source provider.
	 * <p>
	 * <b>NOTE:</b> If you update this list, remember to update the services extension as well! This
	 * is tested!!!
	 */
	public static final String[] PROVIDED_SOURCE_NAMES = new String[] {

	Constants.SOURCES_THE_MANAGER, Constants.SOURCES_ACTIVE_CONTEXT,

	Constants.SOURCES_ACTIVE_BINDING, Constants.SOURCES_ACTIVE_BINDING_TYPE,
			Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, Constants.SOURCES_ACTIVE_BINDING_FEATURE,
			Constants.SOURCES_ACTIVE_BINDING_RO, Constants.SOURCES_ACTIVE_BINDING_UNSETTABLE,
			Constants.SOURCES_ACTIVE_BINDING_OPEN_COMMAND,

			Constants.SOURCES_ACTIVE_BINDING_VALUE, Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY,

			Constants.SOURCES_ACTIVE_CONTAINER_BINDING, Constants.SOURCES_ACTIVE_CONTAINER_BINDING_NO_CAF,
			Constants.SOURCES_ACTIVE_CONTAINER_CELL_TYPE,

			Constants.SOURCES_ACTIVE_VIEWER_ELEMENT, Constants.SOURCES_ACTIVE_VIEWER_ELEMENT_TYPE,
			Constants.SOURCES_ACTIVE_VIEWER_ELEMENT_MOVE_UP, Constants.SOURCES_ACTIVE_VIEWER_ELEMENT_MOVE_DOWN,

	};

	/**
	 * Constructs and returns a new source provider.
	 */
	public BindingSourceProvider() {
		Display.getCurrent().addFilter(SWT.FocusIn, myDisplayFilter);
		Display.getCurrent().addFilter(SWT.MouseDown, myDisplayFilter);
		Display.getCurrent().addFilter(SWT.KeyUp, myDisplayFilter);
		Display.getCurrent().addFilter(SWT.MenuDetect, myDisplayFilter);

		resetMap(myCurrentState);
	}

	@Override
	public void dispose() {
		Display.getCurrent().removeFilter(SWT.FocusIn, myDisplayFilter);
		Display.getCurrent().removeFilter(SWT.MouseDown, myDisplayFilter);
		Display.getCurrent().removeFilter(SWT.KeyUp, myDisplayFilter);
		Display.getCurrent().removeFilter(SWT.MenuDetect, myDisplayFilter);
	}

	/**
	 * The manager itself.
	 */
	private final IManager theManager = IManager.Factory.getManager();

	/**
	 * Internal filter for the display used to track the current binding information.
	 * <p>
	 * Please be extremely careful in this code to be fast and bail out as quickly as possible.
	 */
	private final Listener myDisplayFilter = new Listener() {
		@Override
		public void handleEvent(Event event) {
			reportSourceChanges(event);
		}
	};

	/**
	 * The previous state reported by the provider.
	 */
	private final Map<String, Object> myCurrentState = new HashMap<String, Object>();

	/**
	 * The last widget that was used for {@link #getCurrentState(Event)}.
	 */
	private Widget myLastWidget = null;

	/**
	 * The current selection provider.
	 * <p>
	 * Changes in the selection prompts for a re-calculation of the sources.
	 */
	protected ISelectionProvider myCurrentSelectionProvider = null;

	/**
	 * The listener used for {@link #myCurrentSelectionProvider}.
	 */
	protected ISelectionChangedListener myCurrentSelectionProviderListener = new ISelectionChangedListener() {
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if (Activator.getDefault().TRACE_SOURCE_PROVIDER_VERBOSE) {
				LogUtils.debug(this, "new selection: " + event.getSelection());
				if (event.getSelection().isEmpty()) {
					LogUtils.debug(this, "empty");
				}
			}
			reportSourceChanges(myPreviousValueEvent);
		}
	};

	/**
	 * The UI Context service.
	 * 
	 * 
	 * TODO: the the context service via the current IBindingContext
	 */
	private final IContextService myContextService = (IContextService) PlatformUI.getWorkbench().getService(
			IContextService.class);

	/**
	 * The last observable value that has been observed...
	 * <p>
	 * When/if the value changes, the state is recalculated...
	 * 
	 * @see #observe(Event, List)
	 */
	private final List<IObservableValue> myPreviousValues = new ArrayList<IObservableValue>();

	/**
	 * The event associated with {@link #myPreviousValues}.
	 */
	private Event myPreviousValueEvent;

	/**
	 * A listener that monitors changes in {@link #myPreviousValues}.
	 */
	private final IChangeListener myObservedChangeListener = new IChangeListener() {
		@Override
		public void handleChange(ChangeEvent event) {
			reportSourceChanges(myPreviousValueEvent);
		}
	};

	private IContextActivation myBaseContextContextActivation;

	private IContextActivation myWidgetContextContextActivation;

	private IContextActivation myContainerContextContextActivation;

	private IBinding myLastBinding;

	/**
	 * Observes changes in the specified valuse with the associated event.
	 * 
	 * @param event the event
	 * @param newValues the observable values
	 */
	protected void observe(Event event, List<IObservableValue> newValues) {
		myPreviousValueEvent = event;
		if (newValues.equals(myPreviousValues)) return;

		for (final IObservableValue v : myPreviousValues) {
			v.removeChangeListener(myObservedChangeListener);
		}
		myPreviousValues.clear();
		for (final IObservableValue v : newValues) {
			v.addChangeListener(myObservedChangeListener);
		}
		myPreviousValues.addAll(newValues);
	}

	/**
	 * Checks if the current state have changed, and reports these.
	 * 
	 * @param event the current event
	 * @return the resulting map
	 */
	public Map<String, Object> reportSourceChanges(Event event) {
		if (Activator.getDefault().TRACE_SOURCE_PROVIDER_VERBOSE && Activator.getDefault().TRACE_EVENTS_SWT) {
			LogUtils.debug(this, (event == myPreviousValueEvent ? "REPLAY " : "") + TSSWTUtils.toString(event));
		}

		/*
		 * If the event is FocusIn for the very same widget as last time, but with x,y=0,0, then...
		 * ignore it... It is seen whenever the current shell is send to front.
		 */
		if (event.type == SWT.FocusIn && event.widget == myLastWidget && event.x == 0 && event.y == 0)
			return myCurrentState;

		/*
		 * Ignore all key up events, except those that navigate...
		 */
		// if (event.type == SWT.KeyUp && (SWT.KEYCODE_BIT & event.keyCode) == 0) {
		// return myOldState;
		// }

		final Map<String, Object> newState = getCurrentState(event);
		myLastWidget = event.widget;

		/*
		 * Update the current state with changes - keeping them in newState as well.
		 */
		for (final Iterator<Map.Entry<String, Object>> is = newState.entrySet().iterator(); is.hasNext();) {
			final Map.Entry<String, Object> i = is.next();
			final String s = i.getKey();
			final Object n = i.getValue();

			final Object o = myCurrentState.get(s);
			if (BasicUtils.equals(n, o)) {
				is.remove();
			} else {
				myCurrentState.put(s, n);
			}
		}

		if (!newState.isEmpty()) {
			/*
			 * Reset the property testers as well, when any of the values changes
			 */
			newState.put(Constants.PREFIX + Constants.PROPERTY_CAN_DELETE, true);
			newState.put(Constants.PREFIX + Constants.PROPERTY_CAN_DELETE_SELECTED_OBJECTS, true);

			if (Activator.getDefault().TRACE_SOURCE_PROVIDER) {
				final StringBuilder sb = new StringBuilder("Binding sources change(" + myLastBinding + ")");
				for (final Map.Entry<String, Object> i : newState.entrySet()) {
					final String s = i.getKey();
					sb.append("\n  ").append(s).append('=');
					final Object v = i.getValue();
					if (v == null) {
						sb.append("<null>");
					} else if (v == IEvaluationContext.UNDEFINED_VARIABLE) {
						sb.append("<undef>");
					} else {
						sb.append('\'').append(v.toString()).append('\'').append(" [")
								.append(ClassUtils.getLastClassName(v)).append(']');
					}
				}
				LogUtils.debug(this, sb.toString());
			}

			fireSourceChanged(ISources.ACTIVE_CURRENT_SELECTION, newState);

			/*
			 * TODO: describe why
			 * 
			 * TODO: only when changing?
			 */
			final Object activeBindingObject = myCurrentState.get(Constants.SOURCES_ACTIVE_BINDING);
			if (activeBindingObject instanceof IValueBinding) {
				final IValueBinding vb = (IValueBinding) activeBindingObject;
				IManagerRunnable.Factory.asyncExec("update", vb, new Runnable() {
					@Override
					public void run() {
						if (vb.isDisposed()) return;
						vb.updateBinding();
					}
				});
			}

			/*
			 * And lastly, update the active contexts
			 */
			handleContextChanges(myCurrentState);
		}

		return myCurrentState;
	}

	/**
	 * @param newState
	 */
	private void handleContextChanges(final Map<String, Object> newState) {
		/*
		 * If inside a container binding, then activate the proper context
		 */
		final boolean cb = newState.get(Constants.SOURCES_ACTIVE_CONTAINER_BINDING) != IEvaluationContext.UNDEFINED_VARIABLE;
		if (cb && myContainerContextContextActivation == null) {
			myContainerContextContextActivation = myContextService.activateContext(Constants.CONTAINER_CONTEXT_ID);
			if (Activator.getDefault().TRACE_CONTEXTS) {
				LogUtils.debug(this, "activated " + Constants.CONTAINER_CONTEXT_ID);
			}
		}
		if (!cb && myContainerContextContextActivation != null) {
			myContextService.deactivateContext(myContainerContextContextActivation);
			myContainerContextContextActivation = null;
			if (Activator.getDefault().TRACE_CONTEXTS) {
				LogUtils.debug(this, "deactivated " + Constants.CONTAINER_CONTEXT_ID);
			}
		}

		/*
		 * If inside an value binding, then activate the proper context
		 */
		final boolean vb = !cb
				&& newState.get(Constants.SOURCES_ACTIVE_BINDING) != IEvaluationContext.UNDEFINED_VARIABLE;
		if (vb && myWidgetContextContextActivation == null) {
			myWidgetContextContextActivation = myContextService.activateContext(Constants.WIDGET_CONTEXT_ID);
			if (Activator.getDefault().TRACE_CONTEXTS) {
				LogUtils.debug(this, "activated " + Constants.WIDGET_CONTEXT_ID);
			}
		}
		if (!vb && myWidgetContextContextActivation != null) {
			myContextService.deactivateContext(myWidgetContextContextActivation);
			myWidgetContextContextActivation = null;
			if (Activator.getDefault().TRACE_CONTEXTS) {
				LogUtils.debug(this, "deactivated " + Constants.WIDGET_CONTEXT_ID);
			}
		}

		/*
		 * Also activate the base context - this does not seem to happen automatically ???
		 */
		final boolean bc = myContainerContextContextActivation != null || myWidgetContextContextActivation != null;
		if (bc && myBaseContextContextActivation == null) {
			myBaseContextContextActivation = myContextService.activateContext(Constants.COMMON_CONTEXT_ID);
			if (Activator.getDefault().TRACE_CONTEXTS) {
				LogUtils.debug(this, "activated " + Constants.COMMON_CONTEXT_ID);
			}
		}
		if (!bc && myBaseContextContextActivation != null) {
			myContextService.deactivateContext(myBaseContextContextActivation);
			myBaseContextContextActivation = null;
			if (Activator.getDefault().TRACE_CONTEXTS) {
				LogUtils.debug(this, "deactivated " + Constants.COMMON_CONTEXT_ID);
			}
		}
	}

	@Override
	public Map<String, Object> getCurrentState() {
		return myCurrentState;
	}

	/**
	 * Returns a Map with the current state for the specific event if specified.
	 * 
	 * @param event the current event - possibly <code>null</code>
	 * @return a Map with the current state
	 */
	public Map<String, Object> getCurrentState(final Event event) {
		final Map<String, Object> map = new HashMap<String, Object>();
		final List<IObservableValue> values = new ArrayList<IObservableValue>();
		resetMap(map);
		if (event.type == SWT.MenuDetect) {
			// LogUtils.debug(event, "MenuDetect");
		}
		try {
			myLastBinding = IBindingContext.Factory.getBindingForWidget(event.widget);
			if (myLastBinding == null) return map;

			map.put(Constants.SOURCES_ACTIVE_CONTEXT, myLastBinding.getContext());

			final ISourceProviderStateContext context = new ISourceProviderStateContext() {
				@Override
				public Event getEvent() {
					return event;
				}

				private Point myLocation = null;

				@Override
				public Point getLocation() {
					if (myLocation == null) {
						myLocation = new Point(event.x, event.y);
						switch (event.type) {
						case SWT.MenuDetect:
							/*
							 * The location is relative to the display
							 */
							myLocation = event.widget.getDisplay().map(null, (Control) event.widget, myLocation);
							break;
						default:
							break;
						}
					}
					return myLocation;
				}

				@Override
				public Map<String, Object> getState() {
					return map;
				}

				@Override
				public void putSourceValue(String name, Object value) {
					map.put(name, value);
				}

				@Override
				public void addObservedValue(IObservableValue value) {
					values.add(value);
				}

				@Override
				public void setSelectionProvider(ISelectionProvider provider) {
					if (provider == myCurrentSelectionProvider) return;
					if (myCurrentSelectionProvider != null) {
						myCurrentSelectionProvider.removeSelectionChangedListener(myCurrentSelectionProviderListener);
					}
					myCurrentSelectionProvider = provider;
					if (myCurrentSelectionProvider != null) {
						myCurrentSelectionProvider.addSelectionChangedListener(myCurrentSelectionProviderListener);
					}
				}
			};
			try {
				myLastBinding.updateSourceProviderState(context);
			} catch (final Exception ex) {
				LogUtils.error(myLastBinding, ex);
			}

			/*
			 * If the active binding is a value binding, run all extenders as well...
			 */
			final Object activeBinding = map.get(Constants.SOURCES_ACTIVE_BINDING);
			if (activeBinding instanceof IValueBinding) {
				final IValueBinding vb = (IValueBinding) activeBinding;
				for (final IUIBindingDecoratorExtenderDescriptor d : IManager.Factory.getManager()
						.getDecoratorExtenders()) {
					final CEObjectHolder<IUIBindingDecoratorExtender> factory = d.getFactory();
					final IUIBindingDecoratorExtender extender = factory.getObject();
					if (extender == null) {
						LogUtils.error(factory.getConfigurationElement(), "Cannot create extender");
						continue;
					}

					try {
						if (!extender.isEnabled(vb)) {
							continue;
						}
						extender.updateSourceProviderState(vb, context);
					} catch (final Exception ex) {
						LogUtils.error(factory.getConfigurationElement(), ex);
					}
				}
			}

			observe(event, values);
		} catch (final Exception ex) {
			LogUtils.error(this, ex);
		}
		return map;
	}

	private void resetMap(final Map<String, Object> map) {
		map.put(Constants.SOURCES_THE_MANAGER, theManager);
		map.put(Constants.SOURCES_ACTIVE_CONTEXT, IEvaluationContext.UNDEFINED_VARIABLE);

		map.put(Constants.SOURCES_ACTIVE_CONTAINER_BINDING, IEvaluationContext.UNDEFINED_VARIABLE);
		map.put(Constants.SOURCES_ACTIVE_CONTAINER_CELL_TYPE, IEvaluationContext.UNDEFINED_VARIABLE);
		map.put(Constants.SOURCES_ACTIVE_CONTAINER_BINDING_NO_CAF, false);

		map.put(Constants.SOURCES_ACTIVE_VIEWER_ELEMENT, IEvaluationContext.UNDEFINED_VARIABLE);
		map.put(Constants.SOURCES_ACTIVE_VIEWER_ELEMENT_TYPE, IEvaluationContext.UNDEFINED_VARIABLE);
		map.put(Constants.SOURCES_ACTIVE_VIEWER_ELEMENT_MOVE_UP, false);
		map.put(Constants.SOURCES_ACTIVE_VIEWER_ELEMENT_MOVE_DOWN, false);

		map.put(Constants.SOURCES_ACTIVE_BINDING, IEvaluationContext.UNDEFINED_VARIABLE);
		map.put(Constants.SOURCES_ACTIVE_BINDING_TYPE, IEvaluationContext.UNDEFINED_VARIABLE);
		map.put(Constants.SOURCES_ACTIVE_BINDING_MODEL_OBJECT, IEvaluationContext.UNDEFINED_VARIABLE);
		map.put(Constants.SOURCES_ACTIVE_BINDING_FEATURE, IEvaluationContext.UNDEFINED_VARIABLE);
		map.put(Constants.SOURCES_ACTIVE_BINDING_RO, true);
		map.put(Constants.SOURCES_ACTIVE_BINDING_UNSETTABLE, false);
		map.put(Constants.SOURCES_ACTIVE_BINDING_OPEN_COMMAND, IEvaluationContext.UNDEFINED_VARIABLE);

		map.put(Constants.SOURCES_ACTIVE_BINDING_VALUE, IEvaluationContext.UNDEFINED_VARIABLE);
		map.put(Constants.SOURCES_ACTIVE_BINDING_VALUE_DISPLAY, IEvaluationContext.UNDEFINED_VARIABLE);
	}

	@Override
	public String[] getProvidedSourceNames() {
		return PROVIDED_SOURCE_NAMES;
	}
}
