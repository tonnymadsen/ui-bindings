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

import java.util.EventObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;

import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IUIBindingsPackage;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Source Provider for property testers in the framework.
 * <p>
 * If a property change is fired - using {@link #fireSourceChanged(int, Map)} - for any of full
 * property names, then all the expressions that uses this property will be re-evaluated.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ManagerSourceProvider extends AbstractSourceProvider {

	/**
	 * The names of the sources supported by this source provider.
	 * <p>
	 * <b>NOTE:</b> If you update this list, remember to update the services extension as well!
	 */
	public static final String[] PROVIDED_SOURCE_NAMES = new String[] { Constants.SOURCES_CAN_UNDO,
			Constants.SOURCES_CAN_REDO, };

	/**
	 * Constructs and returns a new source provider.
	 */
	public ManagerSourceProvider() {
		theManager.getEditingDomain().getCommandStack().addCommandStackListener(myCommandStackListener);
		theManager.eAdapters().add(myManagerListener);

		initializeMap(myOldState);
		reportSourceChanges();
	}

	@Override
	public void dispose() {
		theManager.eAdapters().remove(myManagerListener);
	}

	/**
	 * Listener for the current {@link EditingDomain} of the {@link IManager}.
	 */
	private final Adapter myManagerListener = new AdapterImpl() {
		@Override
		public void notifyChanged(Notification msg) {
			if (msg.isTouch()) return;
			if (msg.getFeature() == IUIBindingsPackage.Literals.MANAGER__EDITING_DOMAIN) {
				if (msg.getOldValue() != null) {
					((EditingDomain) msg.getOldValue()).getCommandStack().removeCommandStackListener(
							myCommandStackListener);
				}
				if (msg.getNewValue() != null) {
					((EditingDomain) msg.getNewValue()).getCommandStack().addCommandStackListener(
							myCommandStackListener);
				}
				reportSourceChanges();
			}
		};
	};

	/**
	 * Listener for the command stack of the current {@link EditingDomain}.
	 */
	private final CommandStackListener myCommandStackListener = new CommandStackListener() {
		@Override
		public void commandStackChanged(EventObject event) {
			reportSourceChanges();
		}
	};

	/**
	 * The manager itself.
	 */
	private final IManager theManager = IManager.Factory.getManager();

	/**
	 * The previous state reported by the provider.
	 */
	private final Map<String, Object> myOldState = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getCurrentState() {
		return myOldState;
	}

	/**
	 * Checks if the current state have changed, and reports these.
	 * 
	 * @param event the current event
	 * @return the resulting map
	 */
	public Map<String, Object> reportSourceChanges() {
		final Map<String, Object> newState = getNewState();

		for (final Iterator<Map.Entry<String, Object>> is = newState.entrySet().iterator(); is.hasNext();) {
			final Map.Entry<String, Object> i = is.next();
			final String s = i.getKey();
			final Object n = i.getValue();

			final Object o = myOldState.get(s);
			if (o == null ? n == null : o.equals(n)) {
				is.remove();
			} else {
				myOldState.put(s, n);
			}
		}
		if (newState.size() != 0) {
			/*
			 * Reset the property testers as well, when any of values changes
			 */
			newState.put(Constants.PREFIX + Constants.PROPERTY_CAN_UNDO, true);
			newState.put(Constants.PREFIX + Constants.PROPERTY_CAN_REDO, true);

			if (Activator.getDefault().TRACE_SOURCE_PROVIDER) {
				final StringBuilder sb = new StringBuilder("Binding sources change:");
				for (final Map.Entry<String, Object> i : newState.entrySet()) {
					final String s = i.getKey();
					sb.append("\n  ").append(s).append("='");
					final Object v = i.getValue();
					if (v == null) {
						sb.append("<null>");
					} else if (v == IEvaluationContext.UNDEFINED_VARIABLE) {
						sb.append("<undef>");
					} else {
						sb.append(v.toString());
					}
					sb.append('\'');
				}
				LogUtils.debug(this, sb.toString());
			}

			fireSourceChanged(ISources.ACTIVE_CURRENT_SELECTION, newState);
		}

		return myOldState;
	}

	protected Map<String, Object> getNewState() {
		final Map<String, Object> newState = new HashMap<String, Object>();

		final EditingDomain editingDomain = theManager.getEditingDomain();
		final CommandStack commandStack = editingDomain.getCommandStack();

		newState.put(Constants.SOURCES_CAN_UNDO, commandStack.canUndo());
		newState.put(Constants.SOURCES_CAN_REDO, commandStack.canRedo());

		return newState;
	}

	private void initializeMap(final Map<String, Object> map) {
		map.put(Constants.SOURCES_CAN_UNDO, false);
		map.put(Constants.SOURCES_CAN_REDO, false);
	}

	@Override
	public String[] getProvidedSourceNames() {
		return PROVIDED_SOURCE_NAMES;
	}
}
