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
package com.rcpcompany.uibindings.units;

/**
 * A specific unit.
 * <p>
 * Instances of this class are immutable.
 * 
 * @author Tonny Madsen, The RCP Company
 */
public interface IUnit {
	/**
	 * Returns the dimension of this unit
	 * 
	 * @return the dimension
	 */
	IUnitDimension getDimension();

	/**
	 * Returns the canonical name for this unit.
	 * <p>
	 * <code>u.isName(u.getName()) == true</code>
	 * 
	 * @return the canonical name
	 */
	String getName();

	/**
	 * Returns whether this unit answers to the given name.
	 * <p>
	 * E.g. the unit for meters (the SI length base unit), likely answers to the names "m", "meter" and "meters".
	 * 
	 * @param name the possible name of this unit
	 * @return <code>true</code> if the name is a name for this unit
	 */
	boolean isName(String name);
}
