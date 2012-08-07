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
package com.rcpcompany.uibindings;

/**
 * Factory that creates a service for the specified service target.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IServiceFactory {
	/**
	 * Creates the service for the specified target.
	 * 
	 * @param target
	 */
	void create(IServiceTarget target);
}
