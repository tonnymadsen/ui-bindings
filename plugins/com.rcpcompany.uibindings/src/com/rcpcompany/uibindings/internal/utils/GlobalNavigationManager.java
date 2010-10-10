/*******************************************************************************
 * Copyright (c) 2007, 2010 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.ISourceProviderListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.ExtensionContributionFactory;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.services.ISourceProviderService;

import com.rcpcompany.uibindings.BindingState;
import com.rcpcompany.uibindings.Constants;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IManager;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IValueBindingCell;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.IBindingObjectLongName;
import com.rcpcompany.uibindings.utils.IGlobalNavigationManager;
import com.rcpcompany.uibindings.utils.IManagerRunnable;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of {@link IGlobalNavigationManager}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class GlobalNavigationManager implements IGlobalNavigationManager {
	/**
	 * Returns the manager for the specified window.
	 * 
	 * @param window the window in question
	 * @param create true if the manager should be created if missing
	 * @return the manager
	 */
	public static GlobalNavigationManager getManager(IWorkbenchWindow window, boolean create) {
		GlobalNavigationManager manager = MANAGERS.get(window);
		if (manager == null && create) {
			manager = new GlobalNavigationManager(window);
		}
		return manager;
	}

	/**
	 * The number of kept locations in the location stack.
	 */
	private int myNoKeptLocations = 20;

	/**
	 * The window of this manager.
	 */
	private final IWorkbenchWindow myWindow;

	/**
	 * <code>true</code> while doing forward or backward. Ignores selection changes while this is
	 * <code>true</code>.
	 */
	private boolean inMovement = false;

	/**
	 * The location stack.
	 */
	private final List<Location> myLocationStack = new ArrayList<Location>();

	/**
	 * Returns the location stack.
	 * 
	 * @return the stack
	 */
	List<Location> getLocationStack() {
		return myLocationStack;
	}

	/**
	 * The current location - a pointer into {@link #myLocationStack} to the location that was last
	 * shown or added.
	 * <p>
	 * So it is typically {@link #myLocationStack}<code>.size()-1</code>
	 */
	private int myCurrentLocationIndex = 0;

	/**
	 * Listener for {@link Constants#SOURCES_ACTIVE_BINDING}.
	 */
	private final MySourceProviderListener myBindingSourceProviderListener;

	/**
	 * Listener used to dispose the manager when the window is closed.
	 */
	private final IWindowListener myWindowListener = new IWindowListener() {
		@Override
		public void windowOpened(IWorkbenchWindow window) {
		}

		@Override
		public void windowDeactivated(IWorkbenchWindow window) {
		}

		@Override
		public void windowClosed(IWorkbenchWindow window) {
			dispose();
		}

		@Override
		public void windowActivated(IWorkbenchWindow window) {
		}
	};

	/**
	 * Map of all managers.
	 */
	private static final Map<IWorkbenchWindow, GlobalNavigationManager> MANAGERS = new HashMap<IWorkbenchWindow, GlobalNavigationManager>();

	/**
	 * Constructs and returns a new navigation manager for the specified window.
	 * 
	 * @param window the window for the manager
	 */
	private GlobalNavigationManager(IWorkbenchWindow window) {
		Assert.isNotNull(window);
		myWindow = window;
		MANAGERS.put(window, this);

		final ISourceProviderService sps = (ISourceProviderService) window.getService(ISourceProviderService.class);
		myBindingSourceProviderListener = new MySourceProviderListener(sps, Constants.SOURCES_ACTIVE_BINDING);

		IManager.Factory.getManager().registerService(this);

		PlatformUI.getWorkbench().addWindowListener(myWindowListener);

		addLocation();
	}

	/**
	 * Disposes this manager.
	 */
	@Override
	public void dispose() {
		myBindingSourceProviderListener.dispose();

		PlatformUI.getWorkbench().removeWindowListener(myWindowListener);
		IManager.Factory.getManager().unregisterService(this);
		MANAGERS.remove(myWindow);

	}

	/**
	 * Returns the window of this manager.
	 * 
	 * @return the window
	 */
	public IWorkbenchWindow getWindow() {
		return myWindow;
	}

	private void updateHandlers() {
		if (theBackwardHandler != null) {
			theBackwardHandler.setBaseEnabled(isBackwardHistoryEnabled());
		}
		if (theForwardHandler != null) {
			theForwardHandler.setBaseEnabled(isForwardHistoryEnabled());
		}
	}

	@Override
	public void addLocation() {
		if (inMovement) return;

		/*
		 * Find the new previous location
		 */
		final Location newLocation = new Location();

		if (Activator.getDefault().TRACE_NAVIGATION_GLOBAL) {
			LogUtils.debug(this, "added " + newLocation);
		}

		/*
		 * Clear the stack of any elements after the current stack pointer
		 */
		if (myLocationStack.size() > 0) {
			myLocationStack.subList(getCurrentLocationIndex() + 1, myLocationStack.size()).clear();
		}

		/*
		 * Add the new location
		 */
		myLocationStack.add(newLocation);

		/*
		 * Remove any locations over the max number
		 */
		while (getNoKeptLocations() > 0 && myLocationStack.size() > getNoKeptLocations()) {
			myLocationStack.remove(0);
		}

		/*
		 * Set the new location pointer
		 */
		setCurrentLocationIndex(myLocationStack.size() - 1);
		updateLocation();
	}

	private final Runnable updateLocationRunnable = new Runnable() {
		@Override
		public void run() {
			getCurrentLocation().update();
		}
	};

	@Override
	public void updateLocation() {
		if (inMovement) return;
		IManagerRunnable.Factory.asyncExec("location", this, updateLocationRunnable);
	}

	public void gotoLocation(int index) {
		try {
			inMovement = true;
			setCurrentLocationIndex(index);
			getCurrentLocation().show();
		} finally {
			inMovement = false;
		}
		updateHandlers();
	}

	/**
	 * Goes back in history.
	 */
	@Override
	public void backwardHistory() {
		if (!isBackwardHistoryEnabled()) return;
		gotoLocation(getCurrentLocationIndex() - 1);
	}

	/**
	 * Returns whether the backward history method is active right now.
	 * 
	 * @return <code>true</code> if active
	 */
	public boolean isBackwardHistoryEnabled() {
		return getCurrentLocationIndex() > 0;
	}

	/**
	 * Goes forward in history.
	 */
	@Override
	public void forwardHistory() {
		if (!isForwardHistoryEnabled()) return;
		gotoLocation(getCurrentLocationIndex() + 1);
	}

	/**
	 * Returns whether the forward history method is active right now.
	 * 
	 * @return <code>true</code> if active
	 */
	public boolean isForwardHistoryEnabled() {
		return getCurrentLocationIndex() < myLocationStack.size() - 1;
	}

	@Override
	public void setNoKeptLocations(int noKeptLocations) {
		myNoKeptLocations = noKeptLocations;
	}

	@Override
	public int getNoKeptLocations() {
		return myNoKeptLocations;
	}

	/**
	 * Returns the location at the specific index.
	 * 
	 * @param i the index
	 * @return the location
	 */
	Location getLocation(int i) {
		Assert.isTrue(0 <= i && i < myLocationStack.size(),
				"Location index " + i + " must [0; " + myLocationStack.size() + "[");
		return myLocationStack.get(i);
	}

	/**
	 * Returns the current location.
	 * 
	 * @return the location
	 */
	Location getCurrentLocation() {
		return getLocation(getCurrentLocationIndex());
	}

	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocationIndex(int currentLocation) {
		myCurrentLocationIndex = currentLocation;
	}

	/**
	 * @return the currentLocation
	 */
	public int getCurrentLocationIndex() {
		return myCurrentLocationIndex;
	}

	/**
	 * A single global navigation position.
	 */
	protected class Location {
		private String myId;
		private String mySecondaryId;
		private ISelection mySelection;
		private String myTitle;
		private Image myImage;
		private IValueBinding myBinding;

		/**
		 * Constructs and returns a new location.
		 */
		protected Location() {
		}

		public void update() {
			final IWorkbenchPage activePage = myWindow.getActivePage();
			/*
			 * The active page will be null when closing a window...
			 */
			if (activePage == null) return;
			final IWorkbenchPart activePart = activePage.getActivePart();
			if (!(activePart instanceof IViewPart)) {
				if (getId() == null) {
					LogUtils.debug(this, "null Location not updated. activePart=" + activePart);
				}
				return;
			}

			final Object value = myBindingSourceProviderListener.getValue();
			if (value instanceof IValueBinding) {
				myBinding = (IValueBinding) value;
				/*
				 * If the binding is associated with a specific cell, then use the label binding for
				 * the cell. This is useful when the cell is being edited and we get the editor
				 * binding as this have gone away when we get back to the location later using
				 * show().
				 */
				final IValueBindingCell cell = myBinding.getCell();
				if (cell != null) {
					myBinding = cell.getLabelBinding();
				}
			}
			final IViewPart vp = (IViewPart) activePart;

			final IViewSite viewSite = vp.getViewSite();
			myId = viewSite.getId();
			mySecondaryId = viewSite.getSecondaryId();
			myTitle = vp.getTitle();
			myImage = vp.getTitleImage();
			if (vp instanceof IGetSelectionTarget) {
				mySelection = ((IGetSelectionTarget) vp).getCurrentSelection();
			} else {
				mySelection = null;
			}

			updateHandlers();
		}

		/**
		 * Returns the id of the view.
		 * 
		 * @return the view id
		 */
		public String getId() {
			return myId;
		}

		/**
		 * Returns the secondary id of the view.
		 * 
		 * @return the view secondary id - possibly <code>null</code>
		 */
		public String getSecondaryId() {
			return mySecondaryId;
		}

		/**
		 * Returns the active selection in the view.
		 * 
		 * @return the selection
		 */
		public ISelection getSelection() {
			return mySelection;
		}

		/**
		 * Returns the active binding in the view.
		 * 
		 * @return the binding
		 */
		public IValueBinding getBinding() {
			return myBinding;
		}

		public String getTitle() {
			return myTitle;
		}

		public Image getImage() {
			return myImage;
		}

		/**
		 * Shows the specified position.
		 */
		public void show() {
			if (Activator.getDefault().TRACE_NAVIGATION_GLOBAL) {
				LogUtils.debug(this, "show " + this);
			}
			IViewPart view = null;
			try {
				Assert.isNotNull(getId());
				view = getWindow().getActivePage().showView(getId(), getSecondaryId(), IWorkbenchPage.VIEW_ACTIVATE);
			} catch (final PartInitException ex) {
				LogUtils.error(this, ex);
				return;
			}
			if (view instanceof ISetSelectionTarget) {
				final ISetSelectionTarget t = (ISetSelectionTarget) view;
				t.selectReveal(getSelection());
			}

			final IValueBinding b = getBinding();
			if (b != null && b.getState() == BindingState.OK) {
				b.setFocus();
			}
		}

		@Override
		public String toString() {
			return "Location[" + getId() + "]=" + getSelection() + "/" + getBinding();
		}

		private GlobalNavigationManager getOuterType() {
			return GlobalNavigationManager.this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((myBinding == null) ? 0 : myBinding.hashCode());
			result = prime * result + ((myId == null) ? 0 : myId.hashCode());
			result = prime * result + ((mySecondaryId == null) ? 0 : mySecondaryId.hashCode());
			result = prime * result + ((mySelection == null) ? 0 : mySelection.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (!(obj instanceof Location)) return false;
			final Location other = (Location) obj;
			return UIBindingsUtils.equals(this.getId(), other.getId())
					&& UIBindingsUtils.equals(this.getSecondaryId(), other.getSecondaryId())
					&& UIBindingsUtils.equals(this.getSelection(), other.getSelection())
					&& UIBindingsUtils.equals(this.getBinding(), other.getBinding());
		}
	}

	public static BackwardHandler theBackwardHandler = null;

	/**
	 * <code>org.eclipse.ui.navigate.backwardHistory</code> handler.
	 */
	public static class BackwardHandler extends AbstractHandler {
		public BackwardHandler() {
			theBackwardHandler = this;
			setBaseEnabled(false);
		}

		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
			final GlobalNavigationManager manager = GlobalNavigationManager.getManager(window, false);
			if (manager != null) {
				manager.backwardHistory();
			}
			return null;
		}

		/*
		 * To gain access from GNM
		 */
		@Override
		public void setBaseEnabled(boolean state) {
			super.setBaseEnabled(state);
		}

		/*
		 * To provoke an early load
		 */
		@Override
		public void setEnabled(Object evaluationContext) {
			super.setEnabled(evaluationContext);
		}
	}

	/**
	 * Menu item contributor for the backward history menu.
	 */
	public static class BackwardHistoryMenuContributor extends ExtensionContributionFactory {
		@Override
		public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
			final IWorkbenchWindow window = (IWorkbenchWindow) serviceLocator.getService(IWorkbenchWindow.class);
			final GlobalNavigationManager manager = getManager(window, false);
			for (int i = manager.getCurrentLocationIndex() - 1; i >= 0; i--) {
				additions.addContributionItem(new LocationContributionItem(manager, i), null);
			}
		}
	}

	/**
	 * Menu item contributor for the forward history menu.
	 */
	public static class ForwardHistoryMenuContributor extends ExtensionContributionFactory {
		@Override
		public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
			final IWorkbenchWindow window = (IWorkbenchWindow) serviceLocator.getService(IWorkbenchWindow.class);
			final GlobalNavigationManager manager = getManager(window, false);
			for (int i = manager.getCurrentLocationIndex() + 1; i < manager.myLocationStack.size(); i++) {
				additions.addContributionItem(new LocationContributionItem(manager, i), null);
			}
		}
	}

	/**
	 * {@link IContributionItem} based on a {@link Location}.
	 */
	public static class LocationContributionItem extends ContributionItem implements Listener {
		private final GlobalNavigationManager myManager;
		private final int myIndex;
		private final Location myLocation;

		public LocationContributionItem(GlobalNavigationManager manager, int index) {
			myManager = manager;
			myIndex = index;

			myLocation = myManager.getLocation(myIndex);
		}

		@Override
		public void fill(Menu menu, int index) {
			MenuItem item = null;
			if (index >= 0) {
				item = new MenuItem(menu, SWT.PUSH, index);
			} else {
				item = new MenuItem(menu, SWT.PUSH);
			}
			item.setData(this);
			item.addListener(SWT.Selection, this);

			/*
			 * Modify the title based on the current selection
			 */
			String t = myLocation.getTitle();
			final ISelection selection = myLocation.getSelection();
			if (selection != null && !selection.isEmpty()) {
				final String s = IBindingObjectLongName.Factory.getLongName(selection);
				if (s != null && s.length() > 0) {
					t += " (" + s + ")";
				}
			}
			item.setText(t);
			item.setImage(myLocation.getImage());
		}

		@Override
		public void handleEvent(Event event) {
			switch (event.type) {
			case SWT.Selection:
				myManager.gotoLocation(myIndex);
			}
		}
	}

	public static ForwardHandler theForwardHandler = null;

	/**
	 * <code>org.eclipse.ui.navigate.forwardHistory</code> handler.
	 */
	public static class ForwardHandler extends AbstractHandler {
		public ForwardHandler() {
			theForwardHandler = this;
			setBaseEnabled(false);
		}

		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
			final GlobalNavigationManager manager = GlobalNavigationManager.getManager(window, false);
			if (manager != null) {
				manager.forwardHistory();
			}
			return null;
		}

		/*
		 * To gain access from GNM
		 */
		@Override
		public void setBaseEnabled(boolean state) {
			super.setBaseEnabled(state);
		}

		/*
		 * To provoke an early load
		 */
		@Override
		public void setEnabled(Object evaluationContext) {
			super.setEnabled(evaluationContext);
		}
	}

	public class MySourceProviderListener implements ISourceProviderListener, IDisposable {
		/**
		 * The source name.
		 */
		private final String mySourceName;

		/**
		 * The {@link ISourceProvider} that provides {@link #mySourceName}.
		 */
		private final ISourceProvider mySourceProvider;

		/**
		 * The latest value for {@link #mySourceName}.
		 */
		private Object myValue;

		/**
		 * Constructs and returns a new listsner for the specified source.
		 * 
		 * @param sps the {@link ISourceProvider} service
		 * @param sourceName the name of the source
		 */
		public MySourceProviderListener(ISourceProviderService sps, String sourceName) {
			mySourceName = sourceName;
			mySourceProvider = sps.getSourceProvider(sourceName);
			mySourceProvider.addSourceProviderListener(this);
			myValue = mySourceProvider.getCurrentState().get(mySourceName);
		}

		@Override
		public void dispose() {
			mySourceProvider.removeSourceProviderListener(this);
		}

		@Override
		public void sourceChanged(int sourcePriority, @SuppressWarnings("unchecked") Map sourceValuesByName) {
			if (sourceValuesByName != null && sourceValuesByName.containsKey(mySourceName)) {
				myValue = sourceValuesByName.get(mySourceName);
				// LogUtils.debug(this, mySourceName + "=" + myValue);
				updateLocation();
			}
		}

		@Override
		public void sourceChanged(int sourcePriority, String sourceName, Object sourceValue) {
			if (mySourceName.equals(sourceName)) {
				myValue = sourceValue;
				// LogUtils.debug(this, mySourceName + "=" + myValue);
				updateLocation();
			}
		}

		/**
		 * @return the value
		 */
		public Object getValue() {
			return myValue;
		}
	}
}
