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
package com.rcpcompany.uibindings.internal.bindingMessages;

import org.eclipse.swt.graphics.Image;

import com.rcpcompany.uibindings.IDisposable;

/**
 * Base interface used for showing a decoration for a widget.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IWidgetDecoration extends IDisposable {
	/**
	 * Get the description text that may be shown in a hover for this decoration.
	 * 
	 * @return the text to be shown as a description for the decoration, or <code>null</code> if
	 *         none has been set.
	 */
	String getDescriptionText();

	/**
	 * Set the image shown in this control decoration. Update the rendered decoration.
	 * 
	 * @param text the text to be shown as a description for the decoration, or <code>null</code> if
	 *            none has been set.
	 */
	void setDescriptionText(String text);

	/**
	 * Get the image shown in this control decoration.
	 * 
	 * @return the image to be shown adjacent to the control, or <code>null</code> if one has not
	 *         been set.
	 */
	Image getImage();

	/**
	 * Set the image shown in this control decoration. Update the rendered decoration.
	 * 
	 * @param image the image to be shown adjacent to the control. Should never be <code>null</code>
	 *            .
	 */
	void setImage(Image image);

	/**
	 * Show the control decoration. This message has no effect if the decoration is already showing.
	 * If {@link #setShowOnlyOnFocus(boolean)} is set to <code>true</code>, the decoration will only
	 * be shown if the control has focus.
	 */
	void show();

	/**
	 * Hide the control decoration and any associated hovers. This message has no effect if the
	 * decoration is already hidden.
	 */
	void hide();
}
