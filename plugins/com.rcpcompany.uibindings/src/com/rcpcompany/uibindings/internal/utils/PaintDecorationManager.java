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
package com.rcpcompany.uibindings.internal.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.util.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.swt.widgets.Shell;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.IPaintDecoration;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Simple manager that can draw arbitrary "stuff".
 * <p>
 * A manager exists for each {@link Shell} of the application and is automatically disposed with the
 * shell.
 * <p>
 * Each decoration of the manager is handled internally via an {@link DecorationData} object.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class PaintDecorationManager implements IDisposable, Listener {

	/**
	 * The shell of this manager.
	 */
	private final Shell myShell;

	/**
	 * Cached platform flag for dealing with platform-specific issue:
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=219326 : Shell with custom region and
	 * SWT.NO_TRIM still has border
	 */
	private static boolean MAC = Util.isMac();

	/**
	 * Constructs and returns a new manager.
	 * 
	 * @param shell the shell of the manager
	 */
	private PaintDecorationManager(Shell shell) {
		myShell = shell;
		theManagers.put(getShell(), this);
		hookControl(getShell());
	}

	@Override
	public void dispose() {
		/*
		 * Unhook all controls. This is automatically remove all decorations.
		 */
		for (final Control c : myHookedControls.toArray(new Control[myHookedControls.size()])) {
			unhookControl(c);
		}
		theManagers.remove(getShell());
	}

	public static void addDecoration(IPaintDecoration decoration) {
		final PaintDecorationManager mng = getManager(decoration);
		if (mng != null) {
			mng.addADecoration(decoration);
		}
	}

	public static void removeDecoration(IPaintDecoration decoration) {
		final PaintDecorationManager mng = getManager(decoration);
		if (mng != null) {
			mng.removeADecoration(decoration);
		}
	}

	/**
	 * Mapping of all decorations of this manager to internal data for the same decoration.
	 */
	private final Map<IPaintDecoration, DecorationData> myDecorations = new HashMap<IPaintDecoration, DecorationData>();

	public void addADecoration(IPaintDecoration decoration) {
		DecorationData dd = myDecorations.get(decoration);
		if (dd == null) {
			dd = new DecorationData(decoration);
		}
		dd.update();
	}

	public void removeADecoration(IPaintDecoration decoration) {
		if (Activator.getDefault().TRACE_CONTROL_DECORATIONS) {
			LogUtils.debug(this, "control: " + decoration.getControl() + "@" + decoration.getControl().hashCode() + "/"
					+ decoration.getArea());
		}
		final DecorationData dd = myDecorations.get(decoration);
		if (dd == null) return;
		dd.dispose();
	}

	/**
	 * Map with all defined managers indexed by the shell.
	 */
	private static Map<Shell, PaintDecorationManager> theManagers = new HashMap<Shell, PaintDecorationManager>();

	/**
	 * Returns the shell of the manager.
	 * 
	 * @return the shell
	 */
	private Shell getShell() {
		return myShell;
	}

	/**
	 * Returns the manager for the specified decoration.
	 * <p>
	 * Creates a new manager if none exists
	 * 
	 * @param decoration the decoration
	 * @return the manager for the shell of the decoration
	 */
	private static PaintDecorationManager getManager(IPaintDecoration decoration) {
		final Control c = decoration.getControl();
		if (c == null) return null;
		final Shell shell = c.getShell();
		PaintDecorationManager mng = theManagers.get(shell);
		if (mng == null) {
			mng = new PaintDecorationManager(shell);
		}

		return mng;
	}

	/**
	 * The hooked controls of this manager.
	 * <p>
	 * A control is hooked when first referred in a decoration or a parent...
	 * <p>
	 * It is not unhooked until the control or this manager is disposed.
	 */
	private final Set<Control> myHookedControls = new HashSet<Control>();

	/**
	 * Hooks the specified control into this manager.
	 * <p>
	 * Also hooks all parent controls.
	 * 
	 * @param control the control
	 */
	public void hookControl(Control control) {
		if (myHookedControls.contains(control)) return;

		myHookedControls.add(control);
		control.addListener(SWT.Dispose, this);
		control.addListener(SWT.Paint, this);

		if (control != getShell()) {
			hookControl(control.getParent());
		}
	}

	/**
	 * Unhooks a specific control from the manager.
	 * 
	 * @param control the control
	 */
	public void unhookControl(Control control) {
		if (!myHookedControls.contains(control)) return;
		myHookedControls.remove(control);
		if (!control.isDisposed()) {
			control.removeListener(SWT.Dispose, this);
			control.removeListener(SWT.Paint, this);
		}
		for (final DecorationData dd : myDecorations.values()
				.toArray(new DecorationData[myDecorations.values().size()])) {
			if (dd.getControl() == control) {
				dd.dispose();
			}
		}
	}

	@Override
	public void handleEvent(Event event) {
		// LogUtils.debug(this, ToStringUtils.toString(event));
		switch (event.type) {
		case SWT.Dispose:
			handleDispose(event);
			break;
		case SWT.Paint:
			handlePaint(event);
			break;
		default:
			break;
		}
	}

	/**
	 * Handles the dispose event.
	 * 
	 * @param event the event
	 */
	private void handleDispose(Event event) {
		if (event.widget == getShell()) {
			dispose();
			return;
		}
		unhookControl((Control) event.widget);
	}

	/**
	 * Handles the paint event.
	 * 
	 * @param event the event
	 */
	private void handlePaint(Event event) {
		final Control c = (Control) event.widget;
		final Display display = c.getDisplay();
		final Rectangle area = display.map(c, null, event.x, event.y, event.width, event.height);
		for (final DecorationData dd : myDecorations.values()) {
			if (dd.intersects(area)) {
				dd.paint(event);
			}
		}
	}

	/**
	 * Manager internal decoration data for one decoration.
	 */
	protected class DecorationData implements IDisposable {

		private final IPaintDecoration myDecoration;

		/**
		 * The previous area painted by this decoration relative to the display.
		 */
		private Rectangle myPreviousArea = null;

		/**
		 * Set to true when the decoration is disposed
		 */
		private boolean isDisposed = false;

		/**
		 * Constructs and returns a new decoration data object
		 * 
		 * @param decoration he base decoration
		 */
		protected DecorationData(IPaintDecoration decoration) {
			myDecoration = decoration;
			myDecorations.put(getDecoration(), this);
			if (Activator.getDefault().TRACE_CONTROL_DECORATIONS) {
				LogUtils.debug(this, "control: " + this);
			}

			getManager().hookControl(getDecoration().getControl());
		}

		/**
		 * Returns the control of the decoration
		 * 
		 * @return the control
		 */
		public Control getControl() {
			return getDecoration().getControl();
		}

		@Override
		public void dispose() {
			isDisposed = true;
			update();
			myDecorations.remove(getDecoration());
			if (Activator.getDefault().TRACE_CONTROL_DECORATIONS) {
				LogUtils.debug(this, "control: " + this);
			}
		}

		/**
		 * Returns the manager of this decoration
		 * 
		 * @return the manager
		 */
		public PaintDecorationManager getManager() {
			return PaintDecorationManager.this;
		}

		/**
		 * Returns the decoration itself
		 * 
		 * @return the decoration
		 */
		public IPaintDecoration getDecoration() {
			return myDecoration;
		}

		/**
		 * Updates this decoration
		 */
		public void update() {
			if (Activator.getDefault().TRACE_CONTROL_DECORATIONS) {
				LogUtils.debug(this, "control: " + this);
			}
			/*
			 * Calculate new area
			 */
			final Rectangle newArea = getDecorationRectangle(getShell());
			/*
			 * Compare with last area and image
			 */
			if ((newArea == null ? myPreviousArea == null : newArea.equals(myPreviousArea))) {
				if (Activator.getDefault().TRACE_CONTROL_DECORATIONS_VERBOSE) {
					LogUtils.debug(this, "-- return");
				}
				return;
			}
			Rectangle r = null;
			if (myPreviousArea != null) {
				r = myPreviousArea;
				if (newArea != null) {
					r.add(newArea);
				}
			} else {
				r = newArea;
			}
			myPreviousArea = newArea;
			if (r != null) {
				// LogUtils.debug(this, "redraw: " + r);
				getShell().redraw(r.x, r.y, r.width, r.height, true);
				if (Activator.getDefault().TRACE_CONTROL_DECORATIONS_VERBOSE) {
					LogUtils.debug(this, "redraw " + r);
				}
			}
		}

		/**
		 * Calculates the area taken by the image translated to a specified target control
		 * 
		 * @param c the target control or null for the Display
		 * 
		 * @return the {@link Rectangle} for the image or <code>null</code> if no image is specified
		 */
		private Rectangle getDecorationRectangle(Control c) {
			final Control control = getDecoration().getControl();
			final Rectangle b = getDecoration().getArea();
			final Rectangle bounds = new Rectangle(b.x, b.y, b.width + 1, b.height + 1);

			return getShell().getDisplay().map(control, c, bounds);
		}

		/**
		 * Paints this decoration.
		 * 
		 * @param event the {@link SWT#Paint} event
		 */
		public void paint(Event event) {
			if (Activator.getDefault().TRACE_CONTROL_DECORATIONS_VERBOSE) {
				LogUtils.debug(this, "paint: " + event.widget);
			}
			// if (!shouldShowDecoration()) {
			// return;
			// }
			final Rectangle rect = getDecorationRectangle((Control) event.widget);
			if (Activator.getDefault().TRACE_CONTROL_DECORATIONS_VERBOSE) {
				LogUtils.debug(this, "paint: " + event.widget + "/" + event.widget.hashCode() + ": rect=" + rect);
			}

			getDecoration().paint(event, rect);
		}

		/**
		 * Returns whether this decoration intersects with specified rectangle.
		 * 
		 * @param eventArea the area to check
		 * @return <code>true</code> if the decoration is visible and the area intersects
		 */
		public boolean intersects(Rectangle eventArea) {
			if (isDisposed) return false;
			if (!getControl().isVisible()) return false;
			final Rectangle area = getDecorationRectangle(null);
			if (area == null) return false;
			if (!area.intersects(eventArea)) return false;

			return true;
		}

		@Override
		public String toString() {
			return getControl() + "@" + getControl().hashCode() + " " + getDecoration().getArea() + " area "
					+ getDecorationRectangle(null);
		}
	}
}
