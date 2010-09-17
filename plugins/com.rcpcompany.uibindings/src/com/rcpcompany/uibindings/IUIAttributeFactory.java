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
package com.rcpcompany.uibindings;

import org.eclipse.swt.widgets.Widget;

/**
 * Factory that can create an {@link IUIAttribute} from a specific {@link Widget} and attribute.
 * 
 * @author Tonny Madsen, The RCP Company
 * @since 1.3
 */
public interface IUIAttributeFactory {
	/**
	 * Constructs and returns a new UI Attribute object for the specified widget and attribute.
	 * 
	 * @param widget the widget
	 * @param attribute the attribute of the widget
	 * @return the UI Attribute object
	 */
	public IUIAttribute create(Widget widget, String attribute);
}
