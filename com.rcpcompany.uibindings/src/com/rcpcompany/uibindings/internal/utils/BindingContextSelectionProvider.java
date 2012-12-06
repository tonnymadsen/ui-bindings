/*******************************************************************************
 * Copyright (c) 2007, 2011 The RCP Company and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     The RCP Company - initial API and implementation
 *******************************************************************************/
package com.rcpcompany.uibindings.internal.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.internal.PopupMenuExtender;

import com.rcpcompany.uibindings.IBinding;
import com.rcpcompany.uibindings.IBindingContext;
import com.rcpcompany.uibindings.IContainerBinding;
import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.IValueBinding;
import com.rcpcompany.uibindings.IViewerBinding;
import com.rcpcompany.uibindings.model.utils.BasicUtils;
import com.rcpcompany.uibindings.utils.IBindingContextSelectionProvider;
import com.rcpcompany.uibindings.utils.IFilteringTableAdapter;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Implementation of {@link IBindingContextSelectionProvider}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class BindingContextSelectionProvider extends AbstractContextMonitor implements
		IBindingContextSelectionProvider, ISelectionProvider, IDisposable {
	/**
	 * Factory method for {@link IBindingContextSelectionProvider} that checks a provider does not
	 * already exist.
	 * 
	 * @param context the context
	 * @param site the site
	 * @param setupSelectionProvider whether to set the selection provider on the site
	 * @return the new selection provider
	 */
	public static IBindingContextSelectionProvider adapt(IBindingContext context, IWorkbenchPartSite site,
			boolean setupSelectionProvider) {
		final BindingContextSelectionProvider provider = context.getService(BindingContextSelectionProvider.class);
		if (provider != null) return provider;
		return new BindingContextSelectionProvider(context, site, setupSelectionProvider);
	}

	/**
	 * Constructs and initializes a new selection provider...
	 * 
	 * @param context the binding
	 * @param site the workbench site
	 * @param setupSelectionProvider whether to set the selection provider on the site
	 */
	public BindingContextSelectionProvider(IBindingContext context, IWorkbenchPartSite site,
			boolean setupSelectionProvider) {
		super(context);
		mySite = site;
		mySetupSelectionProvider = setupSelectionProvider;

		if (context.getTop() == null) {
			final IllegalStateException ex = new IllegalStateException("No top component set.");
			LogUtils.error(context, null, ex);
			throw ex;
		}

		init();
	}

	/**
	 * Initializes this filter.
	 */
	@Override
	public void init() {
		if (mySetupSelectionProvider) {
			if (mySite.getSelectionProvider() != null) {
				LogUtils.error(this,
						"Site '" + mySite + "' already have a selection provider: " + mySite.getSelectionProvider());
			}
			mySite.setSelectionProvider(this);
		}

		Display.getCurrent().addFilter(SWT.FocusIn, myFocusListener);
		createContextMenu();

		super.init();
	}

	/**
	 * Map of all registered controls along with their providers.
	 */
	private final Map<Control, ISelectionProvider> myProviders = new HashMap<Control, ISelectionProvider>();

	/**
	 * Selection listener that is installed on the current selection provider to forward changes in
	 * the current selection provider...
	 */
	private final ISelectionChangedListener mySelectionChangedListener = new ISelectionChangedListener() {
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			checkSelection();
		}
	};

	/**
	 * Empty selection used when there are no current selection.
	 */
	protected static final ISelection myEmptySelection = new ISelection() {
		@Override
		public boolean isEmpty() {
			return true;
		}

		@Override
		public String toString() {
			return "*EMPTY SELECTION*";
		};
	};

	@Override
	public void addControl(Control control, ISelectionProvider provider) {
		if (control.getShell() != myMenuManager.getMenu().getShell()) return;
		myProviders.put(control, provider);
		control.setMenu(myMenuManager.getMenu());
		checkFocus();
	}

	@Override
	public void removeControl(Control control) {
		if (!control.isDisposed() && control.getShell() != myMenuManager.getMenu().getShell()) return;
		myProviders.remove(control);
		if (!control.isDisposed()) {
			control.setMenu(null);
		}
		checkFocus();
	}

	@Override
	public void addControl(Control control, IObservableValue selection) {
		addControl(control, new ObservableValueSelectionProvider(selection));
	}

	@Override
	public void addControl(Control control, IObservableList selection) {
		addControl(control, new ObservableListSelectionProvider(selection));
	}

	@Override
	public void addViewer(Viewer viewer) {
		addControl(viewer.getControl(), viewer);
	}

	/**
	 * Check if the current focus control has a registered selection provider.
	 * <p>
	 * If so, a {@link ISelectionChangedListener} is added to the control.
	 * <p>
	 * Called whenever the focus has changed or the registered selection providers change
	 */
	protected void checkFocus() {
		/*
		 * Find the provider for the closest enclosing widget
		 */
		Control c = myFocusControl;
		ISelectionProvider provider = null;
		while (c != null) {
			provider = myProviders.get(c);
			if (provider != null) {
				break;
			}
			if (c.isDisposed()) {
				break;
			}
			c = c.getParent();
		}

		if (provider == myCurrentProvider) return;

		if (myCurrentProvider != null) {
			myCurrentProvider.removeSelectionChangedListener(mySelectionChangedListener);
		}
		myCurrentProvider = provider;
		if (myCurrentProvider != null) {
			myCurrentProvider.addSelectionChangedListener(mySelectionChangedListener);
		}
		checkSelection();
	}

	/**
	 * Checks whether the current selection has changed and fires an event if it has...
	 */
	protected void checkSelection() {
		ISelection selection = null;
		if (myCurrentProvider != null) {
			selection = myCurrentProvider.getSelection();
		}

		if (selection == null) {
			selection = myEmptySelection;
		}
		if (BasicUtils.equals(selection, myCurrentSelection)) return;
		myCurrentSelection = selection;
		fireSelectionChanged(new SelectionChangedEvent(this, myCurrentSelection));
	}

	/**
	 * The workbench site where the menu is registered.
	 */
	private final IWorkbenchPartSite mySite;

	/**
	 * Whether to setup this selection provider on the site.
	 */
	private final boolean mySetupSelectionProvider;

	/**
	 * The current selection provider.
	 */
	protected ISelectionProvider myCurrentProvider = null;

	/**
	 * The current selection.
	 */
	private ISelection myCurrentSelection = myEmptySelection;

	/**
	 * org.eclipse.ui.internal class used to extend popup menus
	 */
	private PopupMenuExtender myPopupMenuExtender = null;

	/**
	 * The menu.
	 */
	/* package */final MenuManager myMenuManager = new MenuManager();

	/**
	 * List of selection change listeners (element type: <code>ISelectionChangedListener</code>).
	 * 
	 * @see #fireSelectionChanged
	 */
	private final ListenerList selectionChangedListeners = new ListenerList();

	protected Control myFocusControl;

	private final Listener myFocusListener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			if (event.type != SWT.FocusIn) return;
			/*
			 * Only react to focus changes within the top component
			 */
			final Control newFocusControl = (Control) event.widget;
			Control c = newFocusControl;
			while (c != null && c != getContext().getTop()) {
				c = c.getParent();
			}

			if (c == null) return;

			setFocusControl(newFocusControl);
		}
	};

	private final Listener myFocusDisposeListener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			// LogUtils.error(myFocusControl, "Control is disposed!");
			setFocusControl(null);
		}
	};

	/**
	 * Creates the context menu.
	 */
	@SuppressWarnings("restriction")
	private void createContextMenu() {
		// myMenuManager.setRemoveAllWhenShown(true);
		// mySite.registerContextMenu(myMenuManager, this);
		// myMenuManager.add(new Separator("open"));
		// myMenuManager.add(new Separator("undo"));
		// myMenuManager.add(new Separator("new"));
		// myMenuManager.add(new Separator("delete"));
		// myMenuManager.add(new Separator("select"));
		// myMenuManager.add(new Separator("navigation"));
		// myMenuManager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		myMenuManager.createContextMenu(getContext().getTop());
		getContext().getTop().setMenu(myMenuManager.getMenu());
		// myMenuManager.getMenu().addMenuListener(new MenuListener() {
		// @Override
		// public void menuShown(MenuEvent e) {
		// LogUtils.debug(BindingContextSelectionProvider.this, "");
		// }
		//
		// @Override
		// public void menuHidden(MenuEvent e) {
		// LogUtils.debug(BindingContextSelectionProvider.this, "");
		// }
		// });

		myPopupMenuExtender = new PopupMenuExtender(mySite.getId(), myMenuManager, this, mySite.getPart(), false);
	}

	protected void setFocusControl(Control newFocusControl) {
		if (myFocusControl != newFocusControl) {
			if (myFocusControl != null) {
				myFocusControl.removeListener(SWT.Dispose, myFocusDisposeListener);
			}
			myFocusControl = newFocusControl;
			if (myFocusControl != null) {
				myFocusControl.addListener(SWT.Dispose, myFocusDisposeListener);
			}
		}
		checkFocus();
	}

	/**
	 * Removes the filtering functionality again.
	 */
	@Override
	public void dispose() {
		setFocusControl(null);
		// mySite.unregisterContextMenu(myMenuManager, this);
		if (myPopupMenuExtender != null) {
			myPopupMenuExtender.dispose();
			myPopupMenuExtender = null;
		}
		if (mySetupSelectionProvider) {
			mySite.setSelectionProvider(null);
		}
		Display.getCurrent().removeFilter(SWT.FocusIn, myFocusListener);

		final Menu menu = myMenuManager.getMenu();
		super.dispose();

		/*
		 * Now that the service itself is disposed, there should be no references to the menu any
		 * more, so we can safely dispose it...
		 */
		if (menu != null) {
			menu.dispose();
		}

	}

	@Override
	protected void bindingAdded(IBinding binding) {
		if (binding instanceof IValueBinding) {
			final IValueBinding vb = (IValueBinding) binding;
			/*
			 * Ignore bindings where the UI attribute has a non-empty attribute name...
			 */
			final String attribute = vb.getUIAttribute().getAttribute();
			if (attribute != null && attribute.length() > 0) return;

			/*
			 * We need a control :-)
			 */
			final Control control = vb.getControl();
			if (control == null) return;
			final IObservable o = vb.getModelObservable();
			if (o instanceof IObservableValue) {
				addControl(control, (IObservableValue) o);
			}
			if (o instanceof IObservableList) {
				addControl(control, (IObservableList) o);
			}
		} else if (binding instanceof IViewerBinding) {
			final IViewerBinding vb = (IViewerBinding) binding;
			addViewer(vb.getViewer()); // TODO SWTB
			final IFilteringTableAdapter filtering = vb.getService(IFilteringTableAdapter.class);
			if (filtering == null) return;
			addControl(filtering.getText(), vb.getViewer()); // TODO SWTB
			return;
		} else if (binding instanceof IContainerBinding) {
			final IContainerBinding vb = (IContainerBinding) binding;
			final Control control = vb.getControl();
			if (control == null) return;
			final IObservableValue ov = vb.getSingleSelection();
			if (ov == null) return;
			addControl(control, ov);
			return;
		}
	}

	@Override
	protected void bindingRemoved(IBinding binding) {
		final Control control = binding.getControl();
		if (control == null) return;
		removeControl(control);
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	@Override
	public ISelection getSelection() {
		return myCurrentSelection;
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	@Override
	public void setSelection(ISelection selection) {
		if (myCurrentProvider != null) {
			myCurrentProvider.setSelection(selection);
		}
	}

	/**
	 * Notifies any selection changed listeners that the viewer's selection has changed. Only
	 * listeners registered at the time this method is called are notified.
	 * 
	 * @param event a selection changed event
	 * 
	 * @see ISelectionChangedListener#selectionChanged
	 */
	protected void fireSelectionChanged(final SelectionChangedEvent event) {
		final Object[] listeners = selectionChangedListeners.getListeners();
		for (final Object listener : listeners) {
			final ISelectionChangedListener l = (ISelectionChangedListener) listener;
			SafeRunnable.run(new SafeRunnable() {
				@Override
				public void run() {
					l.selectionChanged(event);
				}
			});
		}
	}

	/**
	 * Simple selection provider based on the value of an observable value.
	 */
	private final class ObservableValueSelectionProvider implements ISelectionProvider, IValueChangeListener {
		private final ListenerList selectionChangedListeners = new ListenerList();

		/**
		 * The current selection.
		 */
		private ISelection mySelection = myEmptySelection;

		/**
		 * The observable value that forms the base of the selection provider.
		 */
		private final IObservableValue myValue;

		private ObservableValueSelectionProvider(IObservableValue value) {
			myValue = value;
			value.addValueChangeListener(this);
			handleValueChange(null);
		}

		@Override
		public void addSelectionChangedListener(ISelectionChangedListener listener) {
			selectionChangedListeners.add(listener);
		}

		@Override
		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			selectionChangedListeners.remove(listener);
		}

		@Override
		public ISelection getSelection() {
			return mySelection;
		}

		@Override
		public void setSelection(ISelection sel) {
			// Not supported as this is a not a viewer
		}

		private void fireSelectionChanged() {
			if (selectionChangedListeners != null) {
				final SelectionChangedEvent event = new SelectionChangedEvent(this, getSelection());

				final Object[] listeners = selectionChangedListeners.getListeners();
				for (final Object l : listeners) {
					final ISelectionChangedListener listener = (ISelectionChangedListener) l;
					listener.selectionChanged(event);
				}
			}
		}

		@Override
		public void handleValueChange(ValueChangeEvent event) {
			Object value = myValue.getValue();
			if (!(value instanceof EObject) && myValue instanceof IObserving) {
				value = ((IObserving) myValue).getObserved();
			}
			if (value instanceof EObject) {
				mySelection = new StructuredSelection(value);
			} else {
				mySelection = myEmptySelection;
			}
			fireSelectionChanged();
		}
	}

	/**
	 * Simple selection provider based on the value of an observable list.
	 */
	private final class ObservableListSelectionProvider implements ISelectionProvider, IListChangeListener {
		private final ListenerList selectionChangedListeners = new ListenerList();

		/**
		 * The current selection.
		 */
		private ISelection mySelection = myEmptySelection;

		/**
		 * The observable value that forms the base of the selection provider.
		 */
		private final IObservableList myList;

		private ObservableListSelectionProvider(IObservableList list) {
			myList = list;
			list.addListChangeListener(this);
		}

		@Override
		public void addSelectionChangedListener(ISelectionChangedListener listener) {
			selectionChangedListeners.add(listener);
		}

		@Override
		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			selectionChangedListeners.remove(listener);
		}

		@Override
		public ISelection getSelection() {
			return mySelection;
		}

		@Override
		public void setSelection(ISelection sel) {
			// Not supported as this is a not a viewer
		}

		private void fireSelectionChanged() {
			if (selectionChangedListeners != null) {
				final SelectionChangedEvent event = new SelectionChangedEvent(this, getSelection());

				final Object[] listeners = selectionChangedListeners.getListeners();
				for (final Object listener2 : listeners) {
					final ISelectionChangedListener listener = (ISelectionChangedListener) listener2;
					listener.selectionChanged(event);
				}
			}
		}

		@Override
		public void handleListChange(ListChangeEvent event) {
			if (myList.isEmpty()) {
				mySelection = myEmptySelection;
			} else {
				mySelection = new StructuredSelection(myList);
			}
			fireSelectionChanged();
		}
	}
}
