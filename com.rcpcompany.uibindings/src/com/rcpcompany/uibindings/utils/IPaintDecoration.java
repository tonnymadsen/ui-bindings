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
package com.rcpcompany.uibindings.utils;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.PaintDecorationManager;

/**
 * Support for arbitrary decorations for {@link Control controls}.
 * <p>
 * <p>
 * Differs from {@link ControlDecoration} in a number of ways:
 * <ul>
 * <li>Support for cells in tables</li>
 * <li>Vastly more efficient when there are many decorations</li>
 * </ul>
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IPaintDecoration {
	/**
	 * Factory for {@link IPaintDecoration}.
	 */
	final class Factory {
		private Factory() {
		}

		/**
		 * Adds a new decoration.
		 * <p>
		 * The decoration is only added if the control of the decoration is non-<code>null</code>.
		 * <p>
		 * If the decoration supports the {@link IDisposable} interface, it will be notified when
		 * the decoration is no longer in use - e.g. when the decoration is removed with
		 * {@link #removeDecoration(IPaintDecoration)} or if the control is disposed.
		 * 
		 * @param decoration the new decoration
		 */
		public static void addDecoration(IPaintDecoration decoration) {
			PaintDecorationManager.addDecoration(decoration);
		}

		public static IPaintDecoration addDecoration(Control c, int x, int y) {
			final IPaintDecoration pd = IPaintDecoration.Factory.paintRectangle(c, new Rectangle(x - 2, y - 2, 4, 4), c
					.getDisplay().getSystemColor(SWT.COLOR_RED));
			IPaintDecoration.Factory.addDecoration(pd);
			return pd;
		}

		public static IPaintDecoration paintRectangle(final Control c, Rectangle rect, final Color color) {
			final Rectangle r;
			if (rect == null) {
				final Point s = c.getSize();
				r = new Rectangle(0, 0, s.x, s.y);
			} else {
				r = rect;
			}
			final IPaintDecoration pd = new IPaintDecoration() {

				@Override
				public void paint(Event event, Rectangle area) {
					// LogUtils.debug(this, event.widget + ": clip=" + event.gc.getClipping() +
					// " area=" + area);
					final Color oldForeground = event.gc.getForeground();
					event.gc.setForeground(color);
					event.gc.drawRectangle(area.x, area.y, area.width - 1, area.height - 1);
					event.gc.setForeground(oldForeground);
				}

				@Override
				public Control getControl() {
					return c;
				}

				@Override
				public Rectangle getArea() {
					return r;
				}
			};
			addDecoration(pd);

			return pd;
		}

		/**
		 * Removes an existing decoration.
		 * 
		 * @param decoration the decoration to remove
		 */
		public static void removeDecoration(IPaintDecoration decoration) {
			PaintDecorationManager.removeDecoration(decoration);
		}
	};

	/**
	 * The control of this decoration.
	 * <p>
	 * The control of a specific decoration may not change during the lifetime of the decoration.
	 * 
	 * @return the control
	 */
	Control getControl();

	/**
	 * Returns the area of this decoration in relation to the control.
	 * 
	 * @return the relative location
	 */
	Rectangle getArea();

	/**
	 * Paints the decoration.
	 * 
	 * @param area TODO
	 */
	void paint(Event event, Rectangle area);
}
