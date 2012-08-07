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
 * Interface supported by all objects that must be disposed.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IDisposable {

	/**
	 * Disposes of this object.
	 * <p>
	 * All resources must be freed. All listeners must be detached. Dispose will only be called once
	 * during the life cycle of an object.
	 */
	void dispose();

}
