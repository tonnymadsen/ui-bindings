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
package com.rcpcompany.uibindings.compositeform;

/**
 * Factory interface for {@link ICompositeFormPart}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ICompositeFormPartFactory {
	/**
	 * Creates and returns a new set of operations for the specified part.
	 * <p>
	 * The operations will be set on the part automatically.
	 * 
	 * @param part the part
	 * @return the created operations
	 */
	ICompositeFormPartOperations create(ICompositeFormPart part);
}
