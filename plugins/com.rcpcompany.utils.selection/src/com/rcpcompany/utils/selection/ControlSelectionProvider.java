package com.rcpcompany.utils.selection;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.forms.widgets.Section;

/**
 * A selection provider for view parts with more that one viewer. Tracks the focus of the viewers to
 * provide the correct selection.
 */
public class ControlSelectionProvider implements IPostSelectionProvider {

	/**
	 * Whether debug is enabled for this provider.
	 */
	public static boolean DEBUG = false;

	/**
	 * All round listener.
	 */
	private class MyListener implements ISelectionChangedListener, FocusListener, Listener {
		private final Control myControl;

		public MyListener(Control control) {
			myControl = control;
		}

		/*
		 * @see ISelectionChangedListener#selectionChanged
		 */
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if (myControl == controlInFocus) {
				fireSelectionChanged();
			}
		}

		@Override
		public void focusGained(FocusEvent e) {
			setFocusControl(myControl);
		}

		@Override
		public void focusLost(FocusEvent e) {
			// do not reset due to focus behavior on GTK
			// fViewerInFocus= null;
		}

		@Override
		public void handleEvent(Event event) {
			if (event.type == SWT.Activate) {
				setFocusControl(myControl);
			}
		}
	}

	private class PostSelectionListener implements ISelectionChangedListener {
		private final Control myControl;

		public PostSelectionListener(Control control) {
			myControl = control;
		}

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if (myControl == controlInFocus) {
				firePostSelectionChanged();
			}
		}

	}

	private final Map<Control, ISelectionProvider> selectionProviders = new HashMap<Control, ISelectionProvider>();

	private Control controlInFocus;

	private final ListenerList selectionChangedListeners = new ListenerList();;

	private final ListenerList postSelectionChangedListeners = new ListenerList();;

	public ControlSelectionProvider() {
		debug("created"); //$NON-NLS-1$
	}

	protected void debug(String message) {
		if (DEBUG) {
			System.out.println(this + ": " + message); //$NON-NLS-1$
		}
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ":" + hashCode(); //$NON-NLS-1$
	}

	/**
	 * @param viewers All viewers that can provide a selection
	 * @param viewerInFocus the viewer currently in focus or <code>null</code>
	 */
	public ControlSelectionProvider(StructuredViewer[] viewers, StructuredViewer viewerInFocus) {
		this();
		final Control[] controls = new Control[viewers.length];
		final ISelectionProvider[] providers = new ISelectionProvider[viewers.length];

		for (final StructuredViewer viewer : viewers) {
			addViewer(viewer);
		}
		if (viewerInFocus != null) {
			setFocusControl(viewerInFocus.getControl());
		}
	}

	/**
	 * @param controls
	 * @param providers
	 */
	public ControlSelectionProvider(Control[] controls, ISelectionProvider[] providers) {
		this();
		Assert.isNotNull(controls);
		Assert.isNotNull(providers);
		Assert.isTrue(controls.length == providers.length);

		for (int i = 0; i < controls.length; i++) {
			addControl(controls[i], providers[i]);
		}
	}

	/**
	 * Returns the control that currently has focus.
	 * 
	 * @return the control or <code>null</code>
	 */
	public Control getFocusControl() {
		return controlInFocus;
	}

	/**
	 * Returns the selection provider of the current control.
	 * 
	 * @return the provider or <code>null</code>
	 */
	public ISelectionProvider getCurrentSelectionProvider() {
		if (controlInFocus == null) return null;

		return selectionProviders.get(controlInFocus);
	}

	/**
	 * Adds a new control with a specific provider.
	 * 
	 * @param control the control
	 * @param provider the provider
	 */
	public void addControl(Control control, ISelectionProvider provider) {
		debug("added(" + control + ", " + provider + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		final MyListener listener = new MyListener(control);
		provider.addSelectionChangedListener(listener);
		selectionProviders.put(control, provider);
		control.addFocusListener(listener);
		control.addListener(SWT.Activate, listener);
		if (control instanceof Section) {
			final Section s = (Section) control;
			for (final Control c : s.getChildren()) {
				c.addListener(SWT.Activate, listener);
			}
		}
		if (provider instanceof IPostSelectionProvider) {
			final IPostSelectionProvider post = (IPostSelectionProvider) provider;
			post.addPostSelectionChangedListener(new PostSelectionListener(control));
		}
	}

	public void addViewer(StructuredViewer viewer) {
		addControl(viewer.getControl(), viewer);
	}

	/**
	 * @param control
	 */
	public void setFocusControl(Control control) {
		Assert.isNotNull(control);
		if (control == controlInFocus) return;
		debug("focus: " + control); //$NON-NLS-1$

		controlInFocus = control;

		if (!control.isFocusControl()) {
			control.setFocus();
		}

		final ISelectionProvider provider = selectionProviders.get(control);
		if (provider == null) return;
		fireSelectionChanged();
		firePostSelectionChanged();
	}

	private void fireSelectionChanged() {
		debug("selectionChanged(" + getCurrentSelectionProvider() + ": " + getSelection() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		if (selectionChangedListeners != null) {
			final SelectionChangedEvent event = new SelectionChangedEvent(this, getSelection());

			final Object[] listeners = selectionChangedListeners.getListeners();
			for (final Object listener2 : listeners) {
				final ISelectionChangedListener listener = (ISelectionChangedListener) listener2;
				listener.selectionChanged(event);
			}
		}
	}

	private void firePostSelectionChanged() {
		if (postSelectionChangedListeners != null) {
			final SelectionChangedEvent event = new SelectionChangedEvent(this, getSelection());

			final Object[] listeners = postSelectionChangedListeners.getListeners();
			for (final Object listener2 : listeners) {
				final ISelectionChangedListener listener = (ISelectionChangedListener) listener2;
				listener.selectionChanged(event);
			}
		}
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
	public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
		postSelectionChangedListeners.add(listener);
	}

	@Override
	public void removePostSelectionChangedListener(ISelectionChangedListener listener) {
		postSelectionChangedListeners.remove(listener);
	}

	@Override
	public ISelection getSelection() {
		final ISelectionProvider provider = getCurrentSelectionProvider();
		if (provider == null) return StructuredSelection.EMPTY;

		final ISelection selection = provider.getSelection();
		debug("getSelection()=" + selection); //$NON-NLS-1$
		return selection;
	}

	/*
	 * @see ISelectionProvider#setSelection
	 */
	@Override
	public void setSelection(ISelection selection) {
		final ISelectionProvider provider = getCurrentSelectionProvider();
		if (provider == null) return;

		provider.setSelection(selection);
	}
}
