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
package com.rcpcompany.uibindings.units;

/**
 * Abstract {@link IUnit} used to isolate units from smaller changes in the interface.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public abstract class AbstractUnit implements IUnit {
	@Override
	public abstract IUnitDimension getDimension();

	@Override
	public abstract String getName();

	@Override
	public abstract boolean isName(String name);
}
