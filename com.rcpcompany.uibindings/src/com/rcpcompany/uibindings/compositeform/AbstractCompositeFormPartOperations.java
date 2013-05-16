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
package com.rcpcompany.uibindings.compositeform;

/**
 * Abstract base class for {@link ICompositeFormPartOperations}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractCompositeFormPartOperations implements ICompositeFormPartOperations {
	@Override
	public abstract void createUI(ICompositeFormPart part);
}
