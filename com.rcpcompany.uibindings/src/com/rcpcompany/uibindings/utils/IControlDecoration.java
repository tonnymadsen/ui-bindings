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
package com.rcpcompany.uibindings.utils;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.IDisposable;
import com.rcpcompany.uibindings.internal.utils.ControlDecorationManager;

/**
 * Support for image decorations for {@link Control controls}.
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
public interface IControlDecoration {
	/**
	 * Factory for {@link IControlDecoration}.
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
		 * {@link #removeDecoration(IControlDecoration)} or if the control is disposed.
		 * 
		 * @param decoration the new decoration
		 */
		public static void addDecoration(IControlDecoration decoration) {
			ControlDecorationManager.addDecoration(decoration);
		}

		/**
		 * Removes an existing decoration.
		 * 
		 * @param decoration the decoration to remove
		 */
		public static void removeDecoration(IControlDecoration decoration) {
			ControlDecorationManager.removeDecoration(decoration);
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
	 * The location of this decoration in relation to the control.
	 * 
	 * @return the relative location
	 */
	Point getLocation();

	/**
	 * Returns the image of this decoration.
	 * 
	 * @return the image or <code>null</code>
	 */
	Image getImage();

	/**
	 * Returns the tooltip of this decoration.
	 * 
	 * @return the tooltip or <code>null</code>
	 */
	String getTooltip();
}
