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

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.util.Util;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.UIBindingsUtils;
import com.rcpcompany.uibindings.internal.Activator;
import com.rcpcompany.uibindings.utils.IControlDecoration;
import com.rcpcompany.utils.logging.LogUtils;

/**
 * Manager for {@link IControlDecoration}.
 * <p>
 * A manager exists for each {@link Shell} of the application and is automatically disposed with the
 * shell.
 * <p>
 * Each decoration of the manager is handled internally via an {@link DecorationData} object.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public final class ControlDecorationManager implements IDisposable, Listener {

	/**
	 * The size of fuzzy match region - see {@link DecorationData#intersects(Rectangle, boolean)}.
	 */
	private static final int FUZZY_SIZE = 15;

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
	private ControlDecorationManager(Shell shell) {
		myShell = shell;
		theManagers.put(getShell(), this);
		hookControl(getShell());
	}

	@Override
	public void dispose() {
		if (myHover != null) {
			myHover.setVisible(false);
			myHover.dispose();
		}

		/*
		 * Unhook all controls. This is automatically remove all decorations.
		 */
		for (final Control c : myHookedControls.toArray(new Control[myHookedControls.size()])) {
			unhookControl(c);
		}
		theManagers.remove(getShell());
	}

	public static void addDecoration(IControlDecoration decoration) {
		final ControlDecorationManager mng = getManager(decoration);
		if (mng != null) {
			mng.addADecoration(decoration);
		}
	}

	public static void removeDecoration(IControlDecoration decoration) {
		final ControlDecorationManager mng = getManager(decoration);
		if (mng != null) {
			mng.removeADecoration(decoration);
		}
	}

	/**
	 * Mapping of all decorations of this manager to internal data for the same decoration.
	 */
	private final Map<IControlDecoration, DecorationData> myDecorations = new HashMap<IControlDecoration, DecorationData>();

	public void addADecoration(IControlDecoration decoration) {
		DecorationData dd = myDecorations.get(decoration);
		if (dd == null) {
			dd = new DecorationData(decoration);
		}
		dd.update();
	}

	public void removeADecoration(IControlDecoration decoration) {
		if (Activator.getDefault().TRACE_CONTROL_DECORATIONS) {
			LogUtils.debug(this, "control: " + decoration.getControl() + "@" + decoration.getControl().hashCode() + "/"
					+ decoration.getLocation());
		}
		final DecorationData dd = myDecorations.get(decoration);
		if (dd == null) return;
		dd.dispose();
	}

	/**
	 * Map with all defined managers indexed by the shell.
	 */
	private static Map<Shell, ControlDecorationManager> theManagers = new HashMap<Shell, ControlDecorationManager>();

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
	private static ControlDecorationManager getManager(IControlDecoration decoration) {
		final Control c = decoration.getControl();
		if (c == null) return null;
		final Shell shell = c.getShell();
		ControlDecorationManager mng = theManagers.get(shell);
		if (mng == null) {
			mng = new ControlDecorationManager(shell);
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
		control.addListener(SWT.MouseHover, this);
		// control.addListener(SWT.MouseExit, this);

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
			control.removeListener(SWT.MouseHover, this);
			// control.removeListener(SWT.MouseExit, this);
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
		case SWT.MouseHover:
		case SWT.MouseExit:
			handleHover(event);
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
			if (dd.intersects(area, false)) {
				dd.paint(event);
			}
		}
	}

	/**
	 * Handles the hover event.
	 * 
	 * @param event the event
	 */
	private void handleHover(Event event) {
		final Control c = (Control) event.widget;
		final Rectangle eventArea = c.getDisplay().map(c, null, event.x, event.y, event.width, event.height);
		for (final DecorationData dd : myDecorations.values()) {
			if (dd.intersects(eventArea, true)) {
				setHoverDecoration(dd, event);
				return;
			}
		}
		setHoverDecoration(null, event);
	}

	/**
	 * The current decoration to hover if any.
	 */
	private DecorationData myHoverDecoration = null;

	/**
	 * Returns the current hover decoration.
	 * 
	 * @return the decoration or <code>null</code>
	 */
	private DecorationData getHoverDecoration() {
		return myHoverDecoration;
	}

	/**
	 * Shows the tooltip of specified decoration as a hover.
	 * 
	 * @param dd the decoration or <code>null</code>
	 * @param event the SWT event that resulted in the hover
	 */
	private void setHoverDecoration(DecorationData dd, Event event) {
		if (dd == getHoverDecoration()) return;
		/*
		 * Remove the exiting hover if present
		 */
		if (myHoverDecoration != null) {
			if (myHover != null) {
				myHover.setVisible(false);
			}
			if (myHoverControl != null) {
				myHoverControl.removeListener(SWT.MouseExit, this);
				myHoverControl.removeListener(SWT.MouseMove, this);
				myHoverControl = null;
			}
		}

		/*
		 * Show the new hover if present
		 */
		myHoverDecoration = dd;
		if (myHoverDecoration != null) {
			if (myHover == null) {
				myHover = new HoverControl();
			}
			myHover.setDecoration(myHoverDecoration);
			myHover.setVisible(myHover.hasText());

			myHoverControl = (Control) event.widget;
			myHoverControl.addListener(SWT.MouseExit, this);
			myHoverControl.addListener(SWT.MouseMove, this);
		}
	}

	/**
	 * Manager internal decoration data for one decoration.
	 */
	protected class DecorationData implements IDisposable {

		private final IControlDecoration myDecoration;

		/**
		 * The previous area painted by this decoration relative to the display.
		 */
		private Rectangle myPreviousArea = null;

		/**
		 * The previous image painted by this decoration
		 */
		private Image myPreviousImage = null;

		/**
		 * Set to true when the decoration is disposed
		 */
		private boolean isDisposed = false;

		/**
		 * Constructs and returns a new decoration data object
		 * 
		 * @param decoration he base decoration
		 */
		protected DecorationData(IControlDecoration decoration) {
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
			if (getHoverDecoration() == this) {
				setHoverDecoration(null, null);
			}
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
		public ControlDecorationManager getManager() {
			return ControlDecorationManager.this;
		}

		/**
		 * Returns the decoration itself
		 * 
		 * @return the decoration
		 */
		public IControlDecoration getDecoration() {
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
			final Image newImage = isDisposed ? null : getDecoration().getImage();
			final Rectangle newArea = getDecorationRectangle(getShell());
			/*
			 * Compare with last area and image
			 */
			if ((newArea == null ? myPreviousArea == null : newArea.equals(myPreviousArea))
					&& (newImage == null ? myPreviousImage == null : newImage.equals(myPreviousImage))) {
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
			myPreviousImage = newImage;
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
			final Image image = getDecoration().getImage();
			final Control control = getDecoration().getControl();
			if (image == null) return null;

			final Rectangle bounds = image.getBounds();
			final Point location = getDecoration().getLocation();
			if (location != null) {
				bounds.x += location.x;
				bounds.y += location.y;
			}
			bounds.y -= UIBindingsUtils.calculateYAdjustment(control);

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
			final Image image = getDecoration().getImage();
			if (image == null) return;

			final Rectangle rect = getDecorationRectangle((Control) event.widget);
			// final Color oldForeground = event.gc.getForeground();
			// event.gc.setForeground(((Control)
			// event.widget).getDisplay().getSystemColor(SWT.COLOR_RED));
			// event.gc.drawRectangle(rect);
			// event.gc.setForeground(oldForeground);
			if (Activator.getDefault().TRACE_CONTROL_DECORATIONS_VERBOSE) {
				LogUtils.debug(this, "paint: " + event.widget + "/" + event.widget.hashCode() + ": rect=" + rect);
			}
			event.gc.drawImage(image, rect.x, rect.y);
		}

		/**
		 * Returns whether this decoration intersects with specified rectangle.
		 * 
		 * @param eventArea the area to check
		 * @param fuzzy <code>true</code> if doing a fuzzy match
		 * @return <code>true</code> if the decoration is visible and the area intersects
		 */
		public boolean intersects(Rectangle eventArea, boolean fuzzy) {
			if (isDisposed) return false;
			if (!getControl().isVisible()) return false;
			final Rectangle area = getDecorationRectangle(null);
			if (area == null) return false;
			if (fuzzy) {
				if (area.width < FUZZY_SIZE) {
					final int d = FUZZY_SIZE - area.width;
					area.x -= d / 2;
					area.width += d / 2;
				}
				if (area.height < FUZZY_SIZE) {
					final int d = FUZZY_SIZE - area.height;
					area.y -= d / 2;
					area.height += d / 2;
				}
			}
			if (!area.intersects(eventArea)) return false;

			return true;
		}

		@Override
		public String toString() {
			return getControl() + "@" + getControl().hashCode() + " " + getDecoration().getLocation() + " area "
					+ getDecorationRectangle(null);
		}
	}

	/**
	 * The hover for this manager. One per shell.
	 */
	private HoverControl myHover = null;

	/**
	 * The control the hover was last hovering over.
	 */
	private Control myHoverControl = null;

	/**
	 * The hover used to show a decoration image's description.
	 * <p>
	 * Loosely based on {@link ControlDecoration}.
	 */
	private class HoverControl {
		/**
		 * Offset of info hover arrow from the left or right side.
		 */
		private final int hao = 10;

		/**
		 * Width of info hover arrow.
		 */
		private final int haw = 8;

		/**
		 * Height of info hover arrow.
		 */
		private final int hah = 10;

		/**
		 * Margin around info hover text.
		 */
		private final int hm = 2;

		/**
		 * This info hover's shell.
		 */
		Shell myHoverShell;

		/**
		 * The info hover text.
		 */
		String myLastText = null;

		/**
		 * The region used to manage the shell shape.
		 */
		Region region;

		/**
		 * Boolean indicating whether the last computed polygon location had an arrow on left. (true
		 * if left, false if right).
		 */
		boolean arrowOnLeft = true;

		/*
		 * Create a hover parented by the specified shell.
		 */
		protected HoverControl() {
			final Shell parent = getShell();
			final Display display = parent.getDisplay();
			myHoverShell = new Shell(parent, SWT.NO_TRIM | SWT.ON_TOP | SWT.NO_FOCUS | SWT.TOOL);
			myHoverShell.setBackground(display.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
			myHoverShell.setForeground(display.getSystemColor(SWT.COLOR_INFO_FOREGROUND));
			myHoverShell.addPaintListener(new PaintListener() {
				@Override
				public void paintControl(PaintEvent pe) {
					pe.gc.drawText(myLastText, hm, hm);
					if (!MAC) {
						pe.gc.drawPolygon(getPolygon(true));
					}
				}
			});
			myHoverShell.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseDown(MouseEvent e) {
					setVisible(false);
				}
			});
		}

		public boolean hasText() {
			return myLastText != null && myLastText.length() > 0;
		}

		/*
		 * Compute a polygon that represents a hover with an arrow pointer. If border is true,
		 * compute the polygon inset by 1-pixel border. Consult the arrowOnLeft flag to determine
		 * which side the arrow is on.
		 */
		int[] getPolygon(boolean border) {
			final Point e = getHoverSize();
			final int b = border ? 1 : 0;
			if (arrowOnLeft)
				return new int[] { 0, 0, e.x - b, 0, e.x - b, e.y - b, hao + haw, e.y - b, hao + haw / 2,
						e.y + hah - b, hao, e.y - b, 0, e.y - b, 0, 0 };
			return new int[] { 0, 0, e.x - b, 0, e.x - b, e.y - b, e.x - hao - b, e.y - b, e.x - hao - haw / 2,
					e.y + hah - b, e.x - hao - haw, e.y - b, 0, e.y - b, 0, 0 };
		}

		/**
		 * Disposes the hover, it is no longer needed. Dispose any resources allocated by the hover.
		 */
		public void dispose() {
			if (!myHoverShell.isDisposed()) {
				myHoverShell.dispose();
			}
			if (region != null) {
				region.dispose();
			}
		}

		/*
		 * Set the visibility of the hover.
		 */
		void setVisible(boolean visible) {
			if (visible) {
				if (!myHoverShell.isVisible()) {
					myHoverShell.setVisible(true);
				}
			} else {
				if (myHoverShell.isVisible()) {
					myHoverShell.setVisible(false);
				}
			}
		}

		public void setDecoration(DecorationData hoverDecoration) {
			String t = hoverDecoration.getDecoration().getTooltip();
			final Rectangle decorationRectangle = hoverDecoration.getDecorationRectangle(null);
			final Control targetControl = hoverDecoration.getControl();
			if (t == null) {
				t = "";
			}
			if (!t.equals(myLastText)) {
				final Point oldSize = getHoverSize();
				myLastText = t;
				final Point newSize = getHoverSize();
				if (!oldSize.equals(newSize)) {
					// set a flag that indicates the direction of arrow
					arrowOnLeft = decorationRectangle.x <= targetControl.getLocation().x;

					/**
					 * Compute the region (shape) of the shell
					 */
					final Region oldRegion = region;
					region = new Region();
					region.add(getPolygon(false));
					myHoverShell.setRegion(region);
					if (oldRegion != null) {
						oldRegion.dispose();
					}
				}
				myHoverShell.redraw();
			}

			final Point extent = getHoverSize();
			final int y = -extent.y - hah + 1;
			final int x = arrowOnLeft ? -hao + haw / 2 : -extent.x + hao + haw / 2;

			// LogUtils.debug(this, "hover " + decorationRectangle + " offset " + x + "," + y);
			myHoverShell.setLocation(decorationRectangle.x + x, decorationRectangle.y + y);
		}

		/**
		 * Return whether or not the hover (shell) is visible.
		 */
		public boolean isVisible() {
			return myHoverShell.isVisible();
		}

		/**
		 * Compute the extent of the hover for the current text.
		 * 
		 * @return the size
		 */
		public Point getHoverSize() {
			final GC gc = new GC(myHoverShell);
			final Point e = gc.textExtent(myLastText == null ? "" : myLastText);
			gc.dispose();
			e.x += hm * 2;
			e.y += hm * 2;
			return e;
		}
	}
}
