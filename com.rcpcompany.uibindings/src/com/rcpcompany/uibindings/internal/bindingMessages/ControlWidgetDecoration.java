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
package com.rcpcompany.uibindings.internal.bindingMessages;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.rcpcompany.uibindings.IDisposable;

/**
 * {@link IWidgetDecoration} implementation for {@link Control}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public class ControlWidgetDecoration implements IWidgetDecoration, IDisposable {
	private final ControlDecoration myDecoration;

	/**
	 * Construct a ControlDecoration for decorating the specified control at the specified position
	 * relative to the control. Render the decoration only on the specified Composite or its
	 * children. The decoration will be clipped if it does not appear within the visible bounds of
	 * the composite or its child composites.
	 * <p>
	 * SWT constants are used to specify the position of the decoration relative to the control. The
	 * position should include style bits describing both the vertical and horizontal orientation.
	 * <code>SWT.LEFT</code> and <code>SWT.RIGHT</code> describe the horizontal placement of the
	 * decoration relative to the control, and the constants <code>SWT.TOP</code>,
	 * <code>SWT.CENTER</code>, and <code>SWT.BOTTOM</code> describe the vertical alignment of the
	 * decoration relative to the control. Decorations always appear on either the left or right
	 * side of the control, never above or below it. For example, a decoration appearing on the left
	 * side of the field, at the top, is specified as SWT.LEFT | SWT.TOP. If no position style bits
	 * are specified, the control decoration will be positioned to the left and center of the
	 * control (<code>SWT.LEFT | SWT.CENTER</code>).
	 * </p>
	 * 
	 * @param control the control to be decorated
	 * @param position bit-wise or of position constants (<code>SWT.TOP</code>,
	 *            <code>SWT.BOTTOM</code>, <code>SWT.LEFT</code>, <code>SWT.RIGHT</code>, and
	 *            <code>SWT.CENTER</code>).
	 * @param composite The SWT composite within which the decoration should be rendered. The
	 *            decoration will be clipped to this composite, but it may be rendered on a child of
	 *            the composite. The decoration will not be visible if the specified composite or
	 *            its child composites are not visible in the space relative to the control, where
	 *            the decoration is to be rendered. If this value is <code>null</code>, then the
	 *            decoration will be rendered on whichever composite (or composites) are located in
	 *            the specified position.
	 */
	public ControlWidgetDecoration(Control control, int position, Composite composite) {
		myDecoration = new ControlDecoration(control, position, composite);
	}

	@Override
	public void dispose() {
		myDecoration.dispose();
	}

	@Override
	public String getDescriptionText() {
		return myDecoration.getDescriptionText();
	}

	@Override
	public Image getImage() {
		return myDecoration.getImage();
	}

	@Override
	public void hide() {
		myDecoration.hide();
	}

	@Override
	public void setDescriptionText(String text) {
		myDecoration.setDescriptionText(text);
	}

	@Override
	public void setImage(Image image) {
		myDecoration.setImage(image);
	}

	@Override
	public void show() {
		myDecoration.show();
	}

}
