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

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;

/**
 * Abstact base class for {@link IControlDecoration}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractControlDecoration implements IControlDecoration {

	@Override
	public abstract Control getControl();

	@Override
	public abstract Image getImage();

	@Override
	public abstract Point getLocation();

	@Override
	public String getTooltip() {
		return null;
	}
}
