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
 * Operations on a {@link ICompositeFormPart}.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface ICompositeFormPartOperations {
	/***
	 * Creates the UI for a part.
	 * 
	 * @param part TODO
	 */
	void createUI(ICompositeFormPart part);
}
