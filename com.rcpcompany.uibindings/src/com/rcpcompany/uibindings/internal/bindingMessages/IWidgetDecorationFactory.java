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

/**
 * Factory to create a {@link IWidgetDecoration}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IWidgetDecorationFactory {
	/**
	 * Constructs and returns a new decoration.
	 * 
	 * @param position the position of the new decoration - TODO
	 * @return the new decoration
	 */
	IWidgetDecoration create(int position);
}
